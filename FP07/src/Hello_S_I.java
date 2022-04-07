
public interface Hello_S_I extends java.rmi.Remote {
	public void printOnServer(String s) throws java.rmi.RemoteException;

	public void subscribe(String s, Hello_C_I cliente) throws java.rmi.RemoteException;
}