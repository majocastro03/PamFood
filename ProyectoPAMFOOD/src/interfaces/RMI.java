package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote {
	

    public boolean autenticarOperador (String operadorString) throws RemoteException;
    
    public boolean agregarCliente(String username, String telefono, String direccion )  throws RemoteException;

    public boolean agregarOperador(String id, String password )  throws RemoteException; 

}
