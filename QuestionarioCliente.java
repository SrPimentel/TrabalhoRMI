package Trabalho4;

/** QuestionarioCliente.java **/

import java.rmi.registry.*;
public class QuestionarioCliente {
			public static void main(String[] args) {
				try {
				// Obtém uma referência para o registro do RMI
				Registry registry = LocateRegistry.getRegistry(1234);
					// Obtém a stub do servidor
					Questionario stub = (Questionario) registry.lookup("Questionario");
					// Chama o método do servidor e imprime a mensagem
					System.out.println(stub.questionario("1;5;VVFFV"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	}


