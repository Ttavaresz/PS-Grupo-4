package executor;

public class Registrador {
	private int valor;
	private String endereço;
	
	Registrador(String endereçoAtual){
		this.valor = 0;
		this.endereço = endereçoAtual;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String getEndereço() {
		return this.endereço;
	}
	
	public void setValor(int valorAtual) {
		this.valor = valorAtual;
	}
	
	public void imprimirTudo() { //impressão para teste 
		System.out.println(this.valor);
		System.out.println(this.endereço);
	}

	/*
	 registradores:
	 A - Acumulador - Operações aritméticas
	 X - Index - Utilizado para endereçamento 
	 L - Linkado - Utilizada para subrotinas 
	 B - Base - Utilizado para endereçamento 
	 S - Uso geral
	 T - Uso geral
	 F - Não sera utilizado(float point stacker)
	 PC - Program counter - contém o endereço da próxima instrução 
	 SW - Status Word - Utilizado para salvar resultados de comparações
	 
	 */
	
}
