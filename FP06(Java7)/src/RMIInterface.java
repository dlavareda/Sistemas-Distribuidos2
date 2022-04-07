

import java.util.ArrayList;

public interface RMIInterface extends java.rmi.Remote {
	public void adiciona(String s) throws java.rmi.RemoteException;

	public ArrayList<String> consulta() throws java.rmi.RemoteException;
}