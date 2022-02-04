package Trabalho4;

/** QuestionarioCliente.java **/

import java.rmi.registry.*;
public class QuestionarioCliente {
			public static void main(String[] args) {
				try {
				// Obt�m uma refer�ncia para o registro do RMI
				Registry registry = LocateRegistry.getRegistry(1234);
					// Obt�m a stub do servidor
					Questionario stub = (Questionario) registry.lookup("Questionario");
					// Chama o m�todo do servidor e imprime a mensagem
					System.out.println(stub.questionario("1;5;VVFFV"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	}


