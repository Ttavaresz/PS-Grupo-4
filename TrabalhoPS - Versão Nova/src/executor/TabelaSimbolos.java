package executor;

public class TabelaSimbolos {
    private String nome;
    private String endereco;
    private int valor;

    public TabelaSimbolos(String nome, String enderecoAtual, int valor) {
        this.nome = nome;
        this.endereco = enderecoAtual;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getValor() {
        return valor;
    }


    // Outros métodos, se necessário
}

