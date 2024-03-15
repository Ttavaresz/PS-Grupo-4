package executor;

public class Macro {
	private String nome;
	private String chamada;
	protected String binarioValor;
	
	public Macro(String nome , String chamada) {
		this.nome = nome;
		this.chamada = chamada;
	}
	
	 public String getNome() {
	        return nome;
	    }
	 
	 public String getChamada() {
	        return chamada;
	    }
	 
	 
	 public String valorBin() {
	        StringBuilder binario = new StringBuilder();
	        for (char c : nome.toCharArray()) {
	            // Converte o caractere para binário
	            String binarioChar = Integer.toBinaryString(c);
	            // Preenche com zeros à esquerda, se necessário, para ter 8 bits
	            while (binarioChar.length() < 8) {
	                binarioChar = "0" + binarioChar;
	            }
	            // Adiciona o binário do caractere à string binária final
	            binario.append(binarioChar);
	            // Adiciona um espaço entre cada caractere binário
	            binario.append(" ");
	        }
	        binarioValor = binario.toString();
	        return binario.toString();
	    }
	
}
