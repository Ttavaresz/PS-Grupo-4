package executor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Executor {
	static Registrador A = new Registrador("000000");
	static Registrador X = new Registrador("000000");
	static Registrador L = new Registrador("000000");
	static Registrador PC = new Registrador("000000");
	static Registrador SW = new Registrador("000000");
	static List<Montador> montadorList = new ArrayList<>();
	static Memória pilha = new Memória();
	static int contador2 = 100;
	//static Interface interfaceObj = new Interface();
	static List<Macro> macros = new ArrayList<>();
	static String currentDirectory = System.getProperty("user.dir");
	static String filePath = currentDirectory +  File.separator + "macros.asm";
	static int index = 0;
	static Ligador ligador = new Ligador(pilha , 500);
	
    public static void main(String[] args) {
    	Interface2 interface2 = new Interface2();
		interface2.setVisible(true);
    	
    	ligador.carregarSimbolos("simbolos.txt");
    	System.out.println("Símbolos carregados:");
        for (int i = 0; i < ligador.tamanho(); i++) {
            TabelaSimbolos entrada = ligador.obterEntrada(i);
            System.out.println("Símbolo: " + entrada.getNome());
            System.out.println("Endereço: " + entrada.getEndereco());
            System.out.println("Valor: " + entrada.getValor());
            System.out.println(); // Adicionar uma linha em branco para separar os símbolos
        }
        
        interface2.atualizarInterface(ligador.getSimbolos());
        interface2.atualizarMemoria(pilha.memória);
    	
    	
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
				Montador montador = montadorList.get(index);
				System.out.println("Valor de A: " + A.valor);
				System.out.println("Valor de PC: " + PC.valor);
                interface2.atualizar(linha, A.valor, X.valor, L.valor, PC.valor, montador.binario, montador.codigoFonte, montador.mnemonico ,macros );
                index++;

                
            }
            
            processarMacro();

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
    			
            ///////
        	case "48":	//JSUB m, carrega em L o valor de PC e atribui a PC o valor de numeroInt
        		tipo = 3;
        		L.valor = PC.valor;
        		PC.valor = numeroInt;
        		atualizar(instrução, tipo);
        		break;
        	//case "28":	//COMP m, 
        		//tipo = 3;
        		//atualizar(instrução, tipo);
        		//break;
        		
        	/*case "30":	//JEQ m, PC recebe o valor de m se CC receber valor =
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	case "3C":	//J m, PC recebe o valor de m
        		tipo = 3;
        		PC.valor = numeroInt;
        		atualizar(instrução, tipo);
        		break;
        		
        	/*case "08":	// LDL m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	case "4C":	//RSUB m, PC recebe o valor de L
        		tipo = 3;
        		PC.valor = L.valor;
        		atualizar(instrução, tipo);
        		break;
        		
        	/*case "04":	//LDX m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	/*case "E0":	//TD m - test device specified by m (???)
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	/*case "D8":	//RD m, A (o bit mais importante recebe o dado especificado por m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	case "54":	//STCH m, m recebe A (o bit mais importante)
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;
        		
        	case "2C":	//TIX m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;
        		
        	case "38":	//JLT m, PC recebe o valor de m se CC for menor que
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;
        		
        	/*case "10":	//STX m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;*/
        		
        	case "50":	//LDCH m, A (o bit mais importante) recebe o valor de m
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;
        		
        	case "DC":	//WD m, device specified by m <-- A (bit mais importante - ou bit mais a direita)
        		tipo = 3;
        		atualizar(instrução, tipo);
        		break;
            }
    			
    	}
    	
  
    
    public static void atualizar(String instrução , int tipo) {
    	Montador montador = new Montador();
         montador.codigoFonte = instrução;
         montador.criaMnemonica();
         montador.converteBinario();
         pilha.memória[pilha.contador] = instrução;
         PC.valor += (1 * tipo);
         montadorList.add(montador); // Adiciona o novo Montador à lista
         pilha.contador++;
    }
    
    public static void processarMacro() {

        try (BufferedReader reader = new BufferedReader(new FileReader("macro.txt"))) {
            String line;
            StringBuilder chamada = new StringBuilder(); // Usado para construir a chamada da macro
            boolean insideMacro = false; // Flag para indicar se estamos dentro de uma macro
            String nomeMacro = ""; // Armazena o nome da macro atual

            while ((line = reader.readLine()) != null) {
                // Verifica se a linha contém uma definição de MACRO
                Matcher matcher = Pattern.compile("^MACRO\\s+(\\w+)").matcher(line);
                if (matcher.find()) {
                    // Se encontramos uma nova definição de MACRO, iniciamos a captura
                    insideMacro = true;
                    nomeMacro = matcher.group(1);
                    chamada.setLength(0); // Limpa o StringBuilder
                } else if (line.trim().startsWith("MEND")) {
                    // Se encontramos o fim da macro, encerramos a captura
                    insideMacro = false;
                    // Adiciona a macro à lista
                    macros.add(new Macro(nomeMacro, chamada.toString()));

                } else if (insideMacro) {
                    // Se estivermos dentro de uma macro, adicionamos a linha à chamada da macro
                    chamada.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escrever as macros em um arquivo .asm
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
				BufferedWriter writerTXT = new BufferedWriter(new FileWriter("saida.txt"))) {
        	 for (Macro macro : macros) {
                // Escreve o nome da macro no arquivo .asm
                writer.write(macro.valorBin());
                // Escreve o nome da macro no arquivo .txt (saida.txt)
                writerTXT.write("MACRO " + macro.getNome() + "\n");
                // Escreve a chamada da macro no arquivo .txt (saida.txt)
                writerTXT.write(macro.getChamada() + "\n");
                // Escreve o MEND no arquivo .txt (saida.txt)
                writerTXT.write("MEND\n");
                // Escreve uma linha em branco para separar as macros no arquivo .txt (saida.txt)
                writerTXT.write("\n");
            }
        } catch (IOException e) {
        	 e.printStackTrace();
        	 System.err.println("Erro ao criar o arquivo macros.asm: " + e.getMessage());
        }

        // Exibir informações das macros
        for (Macro macro : macros) {
        	macro.valorBin();
            System.out.println("Nome da Macro: \n" + macro.getNome());
            System.out.println("Bin da Macro: \n" + macro.valorBin());
            System.out.println("Chamada da Macro: \n" + macro.getChamada());
            System.out.println("---------");
         
        }
    }

}
