package executor;

public class Memória {
	protected String[] memória = new String[1000];
	public int contador = 0;
	public int contador2 = 1000;
	
	public Memória() {
	        for(int i = 0; i < 1000; i++) {
	            memória[i] = "0x00";
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
	            System.out.println("Memória vazia");; // Ou qualquer valor que faça sentido quando não há elementos na memória
	            return "";
	        }
	}
	 
	public void imprimir() {   //para teste 
		for(int i = 0;i < 1000 ;i++) {
			System.out.println("posição " + i + " é: " + memória[i]);
		}
	}

}
