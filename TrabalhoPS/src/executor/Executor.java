package executor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Executor {

	
	public static void main(String[] args) {
		// criar cada registrador como um objeto 
		Registrador A = new Registrador("000000");
		Registrador B = new Registrador("000000");
		Registrador X = new Registrador("000000");
		Registrador L = new Registrador("000000");
		Registrador S = new Registrador("000000");
		Registrador T = new Registrador("000000");
		Registrador PC = new Registrador("000000");
		Registrador SW = new Registrador("000000");
		
		//cria a memória também 
		Memória pilhaMemória = new Memória();
		
		//lê o arquivo de entrada em uma String
		 String caminhoDoArquivo = "caminho/para/seu/arquivo.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {
	            List<String> linhas = new ArrayList<>();
	            String linha;

	            while ((linha = br.readLine()) != null) {
	                linhas.add(linha); // Adiciona cada linha à lista
	            }

	            // Agora você tem todas as linhas do arquivo em 'linhas'
	            for (String l : linhas) {
	                System.out.println(l); // Exibe cada linha
	            }
	        } catch (IOException e) {
	            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
	        
	        
		} 
	}
