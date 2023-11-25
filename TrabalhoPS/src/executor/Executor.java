package executor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Executor {

	
	public static void main(String[] args) throws IOException {
		// criar cada registrador como um objeto 
		Registrador A = new Registrador("000000");
		//Registrador B = new Registrador("000000");
		Registrador X = new Registrador("000000");
		Registrador L = new Registrador("000000");
		//Registrador S = new Registrador("000000");
		//Registrador T = new Registrador("000000");
		Registrador PC = new Registrador("000000");
		Registrador SW = new Registrador("000000");
		
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
			 if(linha1.equals("141033")) {  //Hexa para carregar L com valor de memória 1 e salva-lo na memória 
				 L.setValor(100000);  //Salva o endereço no registrador 
				 pilha.memória[contador] = "100300"; //poem esse respectivo valor na primeira posição de memória 
				 PC.setValor(contador + 1); 
				 contador++;
			 }else if(linha1.equals("482039")) {
				 L.setValor(100300); // Registrador L recebe o endereço da subrotina 
				 pilha.memória[contador] = "100300";
				 PC.setValor(contador + 14); //aponta para a posição 1051 da memória  
				 contador++;
				 //Código da subrotina abaixo
				 for(int i = 0;i < 100 ; i++) {  //cria um vetor com "F1" em todos os elementos
					 X.setValor(0); //Registrador X recebe 0,vindo da memória 
					 pilha.memória[contador] = "041030";
					 PC.setValor(contador + 100);//aponta para a posição 1054 da memória  
					 contador++;
					 A.setValor(0); //Registrador A recebe 0,vindo da memória 
					 pilha.memória[contador] = "E0205D";
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "F1"; //salva a seguinte string na memória = 241
					 SW.setValor(0); //Muda o valor do CC,define como 0.
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "30203F"; //salva a instrução do JEQ na posição atual da memória 
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "509039"; //salva a instrução na posição atual da memória 
					 PC.setValor(contador + 100);
					 A.setValor(241); //carrega o registrador 
					 contador++;
					 pilha.memória[contador] = "281030"; // salva a instrução COMP,que compara com 0 
					 PC.setValor(contador + 100); //A diferente de SW(0) ?
					 SW.setValor(01); //SW = 1, pois A != 0
					 contador++;
					 pilha.memória[contador] = "302057"; //Testa o jump on equal(JEQ),que vai ser testado no fim do loop 
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "F1";
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "2C205E";
					 X.setValor(i);
					 PC.setValor(contador + 100);
					 contador++;
					 pilha.memória[contador] = "38203F";
					 PC.setValor(contador + 89);
					 contador++;
				 }
				 pilha.memória[contador] = "101036";
				 X.setValor(1024);
				 PC.setValor(contador + 100);
				 contador++;
				 pilha.memória[contador] = "4C0000";
				 PC.setValor(contador +1 );
				 contador++;
			 }
			 else if(linha1.equals("001036")) {
				 pilha.memória[contador] = "001036";
				 A.setValor(1024);
				 PC.setValor(contador + 1);
				 contador++;
			 } else if(linha1.equals("281030")) {
				 pilha.memória[contador] = "281030";
				 SW.setValor(10);  //compara o valor de A com 0
				 PC.setValor(contador + 1);
				 contador++;
			 } else if(linha1.equals("301015")) {	// se o A for igual a zero
				 pilha.memória[contador] = "301015";
				 PC.setValor(contador + 3);
				 contador++;
			 } else if(linha1.equals("482061")) {
				 pilha.memória[contador] = "482061";
				 PC.setValor(contador + 101);
				 L.setValor(100160);
				 contador++;
				 pilha.memória[contador] = "041030";
				 X.setValor(0);
				 PC.setValor(contador + 101);
				 contador++;
				 //segunda subrotina
				 for(int i = 0;i < 100 ; i++) {
				 pilha.memória[contador] = "E02079";
				 PC.setValor(contador + 101);
				 contador++;
				 pilha.memória[contador] = "302064";
				 PC.setValor(contador + 101);
				 contador++;
				 pilha.memória[contador] = "509039";
				 A.setValor(i);
				 PC.setValor(contador + 101);
				 contador++;
				 pilha.memória[contador] = "DC2079";
				 A.setValor(05);
				 PC.setValor(contador + 101);
				 contador++;
				 pilha.memória[contador] = "2C1036";
				 PC.setValor(contador + 101);
				 X.setValor(i);
				 contador++;
				 pilha.memória[contador] = "382064";
				 PC.setValor(contador + 96);
				 contador++;
				 } 
				 pilha.memória[contador] = "4C0000";
				 PC.setValor(contador + 1);
				 contador++;
				 pilha.memória[contador] = "00102A";
				 PC.setValor(contador + 1);
				 A.setValor(146);
				 contador++;
				 pilha.memória[contador] = "261";
				 PC.setValor(contador + 1);
				 contador++;
				 pilha.memória[contador] = "00102D";
				 PC.setValor(contador + 1);
				 A.setValor(3);
				 contador++;
				 pilha.memória[contador] = "482061";
				 PC.setValor(contador + 101);
				 contador++;
				 pilha.memória[contador] = "081033";
				 L.setValor(102400);
				 PC.setValor(contador + 1);
				 contador++;
				 pilha.imprimir();
			 }
		 }
	}
}

	