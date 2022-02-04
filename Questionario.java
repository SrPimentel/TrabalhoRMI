package Trabalho4;

import java.rmi.*;

public interface Questionario extends Remote {
	public String questionario(String x) throws RemoteException;
	
}
