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
        contador++;
    }

    public String getMemória() {
        if (contador > 0) {
            return memória[contador - 1];
        } else {
            System.out.println("Memória vazia");
            return "";
        }
    }

    public void imprimir() {
        for(int i = 0; i < 1000 ; i++) {
            System.out.println("posição " + i + " é: " + memória[i]);
        }
    }
    
    public String getEnderecoInicial() {
        return "000000"; // Defina o endereço inicial conforme necessário
    }
    
    public String proximoEndereco(String enderecoAtual, String operacao, String valor) {
        int valorInt = Integer.parseInt(valor);
        int incremento = operacao.equals("WORD") ? 3 : valorInt * 3;
        int enderecoInt = Integer.parseInt(enderecoAtual, 16); // Converte o endereço hexadecimal para inteiro
        enderecoInt += incremento; // Adiciona o incremento ao endereço atual
        return String.format("%06X", enderecoInt); // Converte o novo endereço de volta para hexadecimal e o retorna
    }
    
    // Método para obter uma representação em forma de string do conteúdo da memória
    public String getConteudoMemoria() {
        StringBuilder conteudo = new StringBuilder();
        for (int i = 0; i < memória.length; i++) {
            conteudo.append("Posição ").append(i).append(": ").append(memória[i]).append("\n");
        }
        return conteudo.toString();
    }
}
