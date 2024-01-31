package executor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Executor {
	
	 public static void main(String[] args) throws IOException, InterruptedException {
		Interface interfaceObj = new Interface();
	    interfaceObj.setVisible(true);
	        
		Montador[] montador = new Montador[4];
		
		
		// criar cada registrador como um objeto 
		Registrador A = new Registrador("000000");
		//Registrador B = new Registrador("000000");
		Registrador X = new Registrador("000000");
		Registrador L = new Registrador("000000");
		//Registrador S = new Registrador("000000");
		//Registrador T = new Registrador("000000");
		Registrador PC = new Registrador("000000");
		Registrador SW = new Registrador("000000");
		
	
		//contador para o montador
		int j = 0;
		for(int v = 0;v < 4;v++)
			 montador[v] = new Montador();
		
		//cria a memória também 
		Memória pilha = new Memória();
		int contador = 0;
		
		//lê o arquivo de entrada em uma String
		 String caminhoDoArquivo = "C:\\Users\\ACER\\OneDrive\\Desktop\\Java\\Entrada.txt";
		 		

		 BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo));
		 List<String> linhas = new ArrayList<>();
		 String linha;

		 while ((linha = br.readLine()) != null) {
		     linhas.add(linha); // Adiciona cada linha à lista
		 }

		 // Agora você tem todas as linhas do arquivo em 'linhas'
		 for (String l : linhas) {
		     System.out.println(l); // Exibe cada linha
		 }
		 
		 
		 // Lembre-se de fechar o recurso após o uso
		 br.close();
		 
		 for(String linha1 : linhas) {
			 
			 System.out.println("Instrução: " + linha1); // Exibe cada linha
			
			 imprimirRegistradores(pilha, contador, A, X, L, PC);
			 
			 if(montador[j].codigoFonte != null ) {
			 interfaceObj.atualizar(linha1, A, X, L, PC ,montador[j].binario, montador[j].mnemonico,montador[j].codigoFonte);
			 
			 }
			 
	         Thread.sleep(500);
			
			 
			 if(linha1.equals("141033")) { //Hexa para carregar L com valor de memória 1 e salva-lo na memória 

					L.setValor(100000); //Salva o endereço no registrador 

					pilha.memória[contador] = "100300"; //Poe esse respectivo valor na primeira posição de memória 

					PC.setValor(contador + 1); 

					//Retorna os valores convertidos em bin e os mnem da instrucao

					montador[j].atualizarCodigoFonte("141033");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;

					contador++;
					
					////////////////
					
					}else if(linha1.equals("482039")) {

					L.setValor(100300); //Registrador L recebe o endereço da subrotina 

					pilha.memória[contador] = "100300";

					PC.setValor(contador + 14); //Aponta para a posição 1051 da memória

					montador[j].atualizarCodigoFonte("482039");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;

					contador++;

					//Código da subrotina abaixo
					if(linha1 == "041030") {
					for(int i = 0; i < 20 ; i++) { //Cria um vetor com "F1" em todos os elementos

					X.setValor(0); //Registrador X recebe 0,vindo da memória 

					pilha.memória[contador] = "041030";

					PC.setValor(contador + 100); //Aponta para a posição 1054 da memória 

					contador++;

					montador[j].atualizarCodigoFonte("041030");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;
					

					

					A.setValor(0); //Registrador A recebe 0,vindo da memória 

					pilha.memória[contador] = "E0205D";

					PC.setValor(contador + 100);

					contador++;

					montador[j].atualizarCodigoFonte("E0205D");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "F1"; //Salva a seguinte string na memória = 241

					SW.setValor(0); //Muda o valor do CC,define como 0.

					PC.setValor(contador + 100);

					contador++;

					montador[j].atualizarCodigoFonte("F1");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					
					//j++;

					

					pilha.memória[contador] = "30203F"; //Salva a instrução do JEQ na posição atual da memória 

					PC.setValor(contador + 100);

					contador++;

					montador[j].atualizarCodigoFonte("30203F");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "509039"; //Salva a instrução na posição atual da memória 

					PC.setValor(contador + 100);

					A.setValor(241); //Carrega o registrador 

					contador++;

					montador[j].atualizarCodigoFonte("509039");

					montador[j].converteBinario();

					montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "281030"; //Salva a instrução COMP,que compara com 0 

					PC.setValor(contador + 100); //A diferente de SW(0) ?

					SW.setValor(01); //SW = 1, pois A != 0

					contador++;

					//montador[j].atualizarCodigoFonte("281030");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "302057"; //Testa o jump on equal(JEQ),que vai ser testado no fim do loop 

					PC.setValor(contador + 100);

					contador++;

					//montador[j].atualizarCodigoFonte("302057");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "F1";

					PC.setValor(contador + 100);

					contador++;

					//montador[j].atualizarCodigoFonte("F1");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "2C205E";

					X.setValor(i);

					PC.setValor(contador + 100);

					contador++;

					//montador[j].atualizarCodigoFonte("2C205E");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "38203F";

					PC.setValor(contador + 89);

					contador++;

					//montador[j].atualizarCodigoFonte("38203F");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					}

					// 101036

					pilha.memória[contador] = "101036";

					X.setValor(1024);

					PC.setValor(contador + 100);

					contador++;

					//montador[j].atualizarCodigoFonte("101036");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					

					pilha.memória[contador] = "4C0000";

					PC.setValor(contador +1 );

					contador++;

					//montador[j].atualizarCodigoFonte("4C0000");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

						}
					}
					else if(linha1.equals("001036")) {

					pilha.memória[contador] = "001036";

					A.setValor(1024);

					PC.setValor(contador + 1);

					contador++;

					//montador[j].atualizarCodigoFonte("001036");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					} else if(linha1.equals("281030")) {

					pilha.memória[contador] = "281030";

					SW.setValor(10); //compara o valor de A com 0

					PC.setValor(contador + 1);

					contador++;

					//montador[j].atualizarCodigoFonte("281030");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					} else if(linha1.equals("301015")) {	//se o A for igual a zero

					pilha.memória[contador] = "301015";

					PC.setValor(contador + 3);

					contador++;

					//montador[j].atualizarCodigoFonte("301015");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					} else if(linha1.equals("482061")) {

					pilha.memória[contador] = "482061";

					PC.setValor(contador + 101);

					L.setValor(100160);

					contador++;

					//montador[j].atualizarCodigoFonte("482061");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "041030";

					X.setValor(0);

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("041030");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					//segunda subrotina
					
					if(linha1 == "E02079" ) {

					for(int i = 0;i < 20 ; i++) {

					pilha.memória[contador] = "E02079";

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("E02079");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "302064";

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("302064");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "509039";

					A.setValor(i);

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("509039");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "DC2079";

					A.setValor(05);

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("DC2079");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "2C1036";

					PC.setValor(contador + 101);

					X.setValor(i);

					contador++;

					//montador[j].atualizarCodigoFonte("2C1036");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "382064";

					PC.setValor(contador + 96);

					contador++;

					//montador[j].atualizarCodigoFonte("382064");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					} 

					pilha.memória[contador] = "4C0000";

					PC.setValor(contador + 1);

					contador++;

					//montador[j].atualizarCodigoFonte("4C0000");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "00102A";

					PC.setValor(contador + 1);

					A.setValor(146);

					contador++;

					//montador[j].atualizarCodigoFonte("00102A");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "261";

					PC.setValor(contador + 1);

					contador++;

					//montador[j].atualizarCodigoFonte("261");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "00102D";

					PC.setValor(contador + 1);

					A.setValor(3);

					contador++;

					//montador[j].atualizarCodigoFonte("00102D");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "482061";

					PC.setValor(contador + 101);

					contador++;

					//montador[j].atualizarCodigoFonte("482061");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.memória[contador] = "081033";

					L.setValor(102400);

					PC.setValor(contador + 1);

					contador++;

					//montador[j].atualizarCodigoFonte("081033");

					//montador[j].converteBinario();

					//montador[j].criaMnemonica();

					//j++;

					pilha.imprimir();
					
						}
					}
			 
			 
				
		
		 }
		
	}
	 
	// Função para imprimir os registradores A, X, L e PC
	    public static void imprimirRegistradores(Memória pilha, int contador, Registrador A, Registrador X, Registrador L, Registrador PC) {
	        System.out.println("Memória Pilha: " + pilha.getMemória());
	        System.out.println("Registrador PC: " + PC.getValor());
	        System.out.println("Registrador A: " + A.getValor());
	        System.out.println("Registrador X: " + X.getValor());
	        System.out.println("Registrador L: " + L.getValor());
	        System.out.println("------------");
	        System.out.println();
	    }
	    
 
}

	