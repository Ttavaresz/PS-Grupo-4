package executor;

public class Memória {
	private String[] memória = new String[150];
	private int contador = 0;
	
	Memória() {
		for(int i = 0;i < 150;i++) {  //PREENCHE A MEMÓRIA COM 000000
			memória[i] = "000000";
		}
	}
	
	public void setMemória(String Entrada) {
		memória[contador] = Entrada;
		contador ++;
	}
	
	public String getMemória() {
		return memória[contador];
	}
	
	public void imprimir() {   //para teste 
		for(int i = 0;i < 150;i++) {
			System.out.println(memória[i]);
		}
	}
}
