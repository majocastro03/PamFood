package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperadorRMI extends Remote {

	public boolean autenticarOperadores(String Operador) throws RemoteException;

	public boolean agregarCliente(String cliente) throws RemoteException;

	public boolean autenticarCliente(String telefonoCliente) throws RemoteException;

	public boolean agregarPedido(String cliente, String idProducto)throws RemoteException; 
}
