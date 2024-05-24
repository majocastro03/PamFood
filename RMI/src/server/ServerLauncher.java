package server;

import java.util.Scanner;

import interfaces.AdminRMI;
import interfaces.OperadorRMI;

public class ServerLauncher {
	
		
	public static void main(String[] args) {
		RMIServer rmiServer1 = null ;
		   RMIServer rmiServer2 = null;
		try {
			AdminRMI admin = new ServiceAdmin(); 
			
			 String ip = "localhost";
		      String port = "6002";
		      String serviceName = "AdminService";
		       rmiServer1 = new RMIServer(ip, port, serviceName, admin);
		      
		      boolean deployed = rmiServer1.deploy();
		      if (deployed) {
		    	 new ServerAviso().setVisible(true);
		        System.out.println("Server is running...");
		      }else {
		        System.out.println("Server failed to start.");
		        new ServerFailed().setVisible(true);
		      }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		try {
			OperadorRMI operador = new ServiceOperador(); 
			
			 String ip = "localhost";
		      String port = "5002";
		      String serviceName = "OperadorService";
		      rmiServer2 = new RMIServer(ip, port, serviceName, operador);
		      
		      boolean deployed = rmiServer2.deploy();
		      if (deployed) {
		        System.out.println("Server is running...");
		      } else {
		        System.out.println("Server failed to start.");
		      }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in); 
		scanner.nextLine(); 
		rmiServer1.undeploy(); 
		rmiServer2.undeploy(); 
		
		
	}
}
