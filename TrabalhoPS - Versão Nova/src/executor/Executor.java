package executor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Executor {
	static Registrador A = new Registrador("000000");
	static Registrador X = new Registrador("000000");
	static Registrador L = new Registrador("000000");
	static Registrador PC = new Registrador("000000");
	static Registrador SW = new Registrador("000000");
	static Montador[] montador = new Montador[1000];
	static Memória pilha = new Memória();
	static int contador2 = 100;
	static Interface interfaceObj = new Interface();

	
    public static void main(String[] args) {
    	interfaceObj.setVisible(true);
    	
        try {
            // Cria um objeto File representando o arquivo "input.txt"
            File file = new File("input.txt");
            
            // Cria um FileInputStream para ler bytes do arquivo
            FileInputStream fis = new FileInputStream(file);
            
            // Cria um BufferedReader para ler linhas de texto do FileInputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String linha;
            // Lê cada linha do arquivo até o final
            while ((linha = br.readLine()) != null) {
                // Processa cada linha do arquivo
                String instruçãoHexa = linha.trim(); // Remove espaços em branco
               

                // Decodificação e execução da instrução
                executarInstrução(instruçãoHexa); // Executa a instrução
                interfaceObj.atualizar(linha,A,X,L,PC,"","","");
                
            }

            // Fecha o BufferedReader
            br.close();
        } catch (IOException e) {
            // Trata exceções de E/S (leitura do arquivo)
            e.printStackTrace();
        }
        pilha.imprimir();
        
    }

    
    // Método para decodificar e executar a instrução
    public static void executarInstrução(String instrução) {
    	//(2 primeiros char pra descobrir o opcode)
    	//(Baseado nisso diria se e do tipo 1/2/3/4 e diria se é direto ou indireto)
    	//(ativar ou não as flags em instruções do tipo 3)
    	
    	String opcode = instrução.substring(0, 2);
    	String valor = instrução.substring(2, 6);
    	int numeroInt = Integer.parseInt(valor);
    	int tipo = 0;
    	System.out.println("Opcode: " + opcode);
    	
    	switch(opcode) {
    		case "00": //LDA,Carrega o valor da memória em A
    			tipo = 3;
    			//atualiza o valor no registrador respectivo
    			A.setValor(numeroInt);
    			
    			System.out.println("valor: " + A.valor);
    			atualizar(instrução, tipo);
    			break;
    		case "0C": //STA, salva o valor de A na memória
    			tipo = 3;
    			atualizar(instrução, tipo);
    			pilha.memória[contador2] = String.valueOf(A.valor);
    			contador2++;
    			break;
    		case "18":	//ADD m, soma em A o valor de m
    			tipo = 3;
    			A.valor += numeroInt;
    			atualizar(instrução, tipo);
    			break;
    		case "14": //STL m, carrega o valor do registrador L na memória
    			tipo = 3;
    			pilha.memória[contador2] = String.valueOf(L.valor);
    			atualizar(instrução, tipo);
    			break;
    		case "1C":	//SUB m,
    			tipo = 3;
    			atualizar(instrução, tipo);
    			break;
    			
    	}
    	
    	
    }
    
    public static void atualizar(String instrução , int tipo) {
    	if (montador[pilha.contador] == null) {
            montador[pilha.contador] = new Montador();
        }
		montador[pilha.contador].codigoFonte = instrução;
		montador[pilha.contador].criaMnemonica();
		pilha.memória[pilha.contador] = instrução;
		PC.valor = pilha.contador + (1*tipo);
		pilha.contador++;
    }
}
