package executor;

public class Memória {
	protected String[] memória = new String[10000];
	private int contador = 0;
	
	Memória() {
		for(int i = 0;i < 200 ;i++) {  //PREENCHE A MEMÓRIA COM 000000
			memória[i] = "000000";
		}
	}
	
	public void setMemória(String Entrada) {
		memória[contador] = Entrada;
		contador ++;
	}
	
	public String getMemória() {
		 if (contador > 0) {
	            return memória[contador - 1];
	        } else {
	            return "N/A"; // Ou qualquer valor que faça sentido quando não há elementos na memória
	        }
	}
	
	public void imprimir() {   //para teste 
		for(int i = 0;i < 200 ;i++) {
			System.out.println(memória[i]);
		}
	}
}
