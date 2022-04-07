

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIImpl extends UnicastRemoteObject implements RMIInterface {
	ArrayList<String> lista;
	int count = 0;

	public RMIImpl() throws java.rmi.RemoteException {
		super();
		lista = new ArrayList<String>();
	}

	public void adiciona(String s) throws java.rmi.RemoteException {
		lista.add(s);
	}

	public ArrayList<String> consulta() throws java.rmi.RemoteException {
		count++;
		return lista;
	}
	public int getCount() throws java.rmi.RemoteException {
		return count;
	}
}