package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AdminRMI extends Remote {
	
	public boolean agregarOperador(String operador)  throws RemoteException; 
    
    public boolean autenticarAdministrador(String administrador) throws RemoteException; 
    
    public boolean modificarOperadores(String idOperador) throws RemoteException; 
    
    public String mostrarOperadores() throws RemoteException; 
    

    
}

