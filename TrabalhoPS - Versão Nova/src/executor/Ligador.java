package executor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ligador {
    private List<TabelaSimbolos> tabela;
    private Memória memória;
    private final int enderecoInicial;

    public Ligador(Memória memória, int enderecoInicial) {
        this.tabela = new ArrayList<>();
        this.memória = memória;
        this.enderecoInicial = enderecoInicial;
    }

    public void carregarSimbolos(String arquivo) {
        String enderecoAtual = String.valueOf(enderecoInicial); // Define o endereço inicial da memória
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                Matcher matcher = Pattern.compile("^\\s*(\\w+)\\s+(\\w+)\\s+(\\w+)").matcher(linha);
                if (matcher.find()) {
                    String simbolo = matcher.group(1);
                    String operacao = matcher.group(2);
                    String valor = matcher.group(3);

                    if (operacao.equals("WORD") || operacao.equals("RESW")) {
                        tabela.add(new TabelaSimbolos(simbolo, enderecoAtual, Integer.parseInt(valor)));
                        enderecoAtual = memória.proximoEndereco(enderecoAtual, operacao, valor); // Calcula o próximo endereço
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TabelaSimbolos obterEntrada(int indice) {
        return tabela.get(indice);
    }

    public int tamanho() {
        return tabela.size();
    }
    
    public List<TabelaSimbolos> getSimbolos() {
        return tabela;
    }
}
