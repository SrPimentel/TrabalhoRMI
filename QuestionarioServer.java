package Trabalho4;

/** QuestionarioServer.java **/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class QuestionarioServer implements Questionario {
			public QuestionarioServer() {}
			// main()
			public static void main(String[] args) {
				try {
				// Instancia o objeto servidor e a sua stub
				QuestionarioServer server = new QuestionarioServer();
				Questionario stub = (Questionario)
				UnicastRemoteObject.exportObject(server, 0);
				// Registra a stub no RMI Registry para que ela seja obtida pelos clientes
				Registry registry = LocateRegistry.createRegistry(1234);
				registry.bind("Questionario", stub);
				System.out.println("Servidor pronto");
				} catch (Exception ex) {
				ex.printStackTrace();
				}
				}
			// questionario()
			public String questionario(String x) throws RemoteException {
				System.out.println("Executando Questionario()");
					
					String questoes = x;
					String[] cortada = questoes.split(";");            
		            String numero_questoes = cortada[0];
		            String numero_alternativas = cortada[1];
		            String questionario = cortada[2];
		            
		            String resposta = "1;5;VVVFF"; 
		            String[] cortada2 = resposta.split(";");
		            String numero_questoes1 = cortada2[0];
		            String numero_alternativas1 = cortada2[1];
		            String respostas = cortada2[2];
		            
		            char[] quest = questionario.toCharArray();
		            char[] respo = respostas.toCharArray();
		          
		            int certo = 0;
		            int errado = 0;
		            boolean r = false;
		           
		            if (numero_questoes.equals(numero_questoes1)){
		            	r = numero_alternativas.equals(numero_alternativas1);
		            }if (r == true) {
		                	for (int c = 0; c<respo.length; c++) {
		                		if (quest[c] == respo[c]) {
		                			certo++;
		                		}else 
		       	            	 errado++;
			              }
		            }

				
				return "Questionario: " + questoes + "\n" + "Corrigido: " + numero_questoes + ";" + certo + ";"+ errado ;
				}
			
			
	}


