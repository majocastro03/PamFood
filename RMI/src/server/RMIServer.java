package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer implements Runnable {

	  private String ip;
	  private String port;
	  private String url;
	  private String serviceName;
	  private Remote service;

	  public RMIServer(String ip, String port, String serviceName, Remote service)  {
	    this.ip = ip;
	    this.port = port;
	    this.serviceName = serviceName;
	    this.service = service;
	    this.url = "//" + ip + ":" + port + "/" + serviceName;
	  }
	  
	  public boolean deploy() {
	    boolean successful = false;
	    if (ip == null || port == null || serviceName == null)
	      return successful;
	    try {
	      System.setProperty("java.rmi.server.hostname", ip);
	      LocateRegistry.createRegistry(Integer.parseInt(port));
	      Naming.rebind(url, service);
	      Logger.getLogger(this.getClass().getSimpleName()).log(Level.INFO, "Service " + serviceName + " is running on {0}", url);
	      successful = true;
	    } catch (RemoteException | MalformedURLException e) {
	      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
	    }
	    return successful;
	  }

	  public boolean undeploy() {
	    boolean successful = false;
	    try {
	      Naming.unbind(url);
	      successful = true;
	    } catch (RemoteException | MalformedURLException | NotBoundException e) {
	      Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, e.getMessage(), e);
	    }
	    System.out.println("Undeplyed");
	    return successful ;
	  }

	  @Override
	  public void run() {
	      this.deploy();
	  }
}

