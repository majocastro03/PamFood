package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaces.OperadorRMI;

public class Server {

    public String ip;
    public String port;
    public String serviceName;
    public String url;
    
   public Server() throws RemoteException, MalformedURLException {
	   String url = "//localhost:5000/Operador";
	   LocateRegistry.createRegistry(5000);
	   Naming.rebind(url, new ServiceOperador());
   }
   
    public Server(String ip, String port, String serviceName) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public boolean deployService() {
        boolean ack = false;
        if (ip == null | port == null | serviceName == null) return ack;
        try {
            System.setProperty( "java.rmi.server.hostname", ip);
            OperadorRMI service2 = new ServiceOperador();
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind(url, service2);
            ack = true;
        } catch (RemoteException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            return ack;
        }
    }
}