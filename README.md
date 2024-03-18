# Programação-de-Sistemas
### Membros: Daniel Henrique, Karen Satie, Lucas Tavares, Frederico Larangeira, Mauro Gomes, Pedro Volz, Samuel de Araujo

Este repositório foi desenvolvido para a disciplina de Programação de Sistemas, com o principal objetivo de elaborar uma máquina virtual e um montador. Esses componentes são projetados para interpretar e processar códigos em linguagem assembly, produzindo a saída apropriada com base no código-fonte fornecido.

Durante o projeto, implementamos uma máquina virtual que emula a arquitetura SIC/XE, considerada uma evolução do modelo SIC. Este trabalho visa fornecer uma ferramenta capaz de compreender e executar comandos em assembly, simulando o comportamento de um processador real no contexto da arquitetura SIC/XE.


## SIC/XE Assembler

Uma versão simplificada e hipotética do processador SIC/XE, o que foi implementado:

* Endereçamento Direto ou Indireto baseado no tipo de instrução;

* Registradores A,X,L,PC,SW;

* Instruções Estendidas(tipo 4);

* Registrador Base;

* Leitura de arquivo Objeto;

* Geração de arquivo .asm;

* Interface com informações úteis;

| Mnemonic | Format | Opcode | Effect | Notes |
|----------|--------|--------|--------|-------|
| ADD m | 3/4 | 18 | A ← (A) + (m..m+2) | |
| ADDF m | 3/4 | 58 | F ← (F) + (m..m+5) | F |
| ADDR r1,r2 | 2 | 90 | r2 ← (r2) + (r1) | |
| AND m | 3/4 | 40 | A ← (A) & (m..m+2) | |
| CLEAR r1 | 2 | B4 | r1 ← 0 | |
| COMP m | 3/4 | 28 | A : (m..m+2) | C |
| COMPF m | 3/4 | 88 | F : (m..m+5) | CF |
| COMPR r1,r2 | 2 | A0 | (r1) : (r2) | C |
| DIV m | 3/4 | 24 | A : (A) / (m..m+2) | |
| DIVF m | 3/4 | 64 | F : (F) / (m..m+5) | F |
| DIVR r1,r2 | 2 | 9C | (r2) ← (r2) / (r1) | |
| FIX | 1 | C4 | A ← (F) [Converte para inteiro] | |
| FLOAT | 1 | C0 | F ← (A) [Converte para float] | F |
| HIO | 1 | F4 | Halt I/O channel number (A) | P |
| J m | 3/4 | 3C | PC ← m | |
| JEQ m | 3/4 | 30 | PC ← m if CC set to = | |
| JGT m | 3/4 | 34 | PC ← m if CC set to > | |
| JLT m | 3/4 | 38 | PC ← m if CC set to < | |
| JSUB m | 3/4 | 48 | L ← (PC); PC ← m | |
| LDA m | 3/4 | 00 | A ← (m..m+2) | |
| LDB m | 3/4 | 68 | B ← (m..m+2) | |
| LDCH m | 3/4 | 50 | A [byte mais a direita] ← (m) | |
| LDF m | 3/4 | 70 | F ← (m..m+5) | F |
| LDL m | 3/4 | 08 | L ← (m..m+2) | |
| LDS m | 3/4 | 6C | S ← (m..m+2) | |
| LDT m | 3/4 | 74 | T ← (m..m+2) | |
| LDX m | 3/4 | 04 | X ← (m..m+2) | |
| LPS m | 3/4 | D0 | Carrega Status do Processador | P |
| MUL m | 3/4 | 20 | A ← (A) * (m..m+2) | |
| MULF m | 3/4 | 60 | F ← (F) * (m..m+5) | |
| MULR r1,r2 | 2 | 98 | r2 ← (r2) * (r1) | |
| NORM | 1 | C8 | F ← (F) [normalizado] | F |
| OR m | 3/4 | 44 | A ← (A) (m..m+2) | |
| RD m | 3/4 | D8 | A [byte mais a direita] ← data | P |
| RMO r1,r2 | 2 | AC | r2 ← (r1) | |
| RSUB | 3/4 | 4C | PC ← (L) | |
| SHIFTL r1,n | 2 | A4 | r1 ← (r1); left circular shift | |
| SHIFTR r1,n | 2 | A8 | r1 ← (r1); right shift n bits | |
| SIO | 1 | F0 |Testa o canal de Entrada/Saída número (A) | P |
| SSK m | 3/4 | EC | Chave de proteção do endereço m | P |
| STA m | 3/4 | 0C | m..m+2 ← (A) | |
| STB m | 3/4 | 78 | m..m+2 ← (B) | |
| STCH m | 3/4 | 54 | m ← (A) [byte mais a direita] | |
| STF m | 3/4 | 80 | m..m+5 ← (F) | F |
| STI m | 3/4 | D4 | Timer de intervalo com valor ← (m..m+2) | P |
| STL m | 3/4 | 14 | m..m+2 ← (L) | |
| STS m | 3/4 | 7C | m..m+2 ← (S) | |
| STSW m | 3/4 | E8 | m..m+2 ← (SW) | P |
| STT m | 3/4 | 84 | m..m+2 ← (T) | |
| STX m | 3/4 | 10 | m..m+2 ← (X) | |
| SUB m | 3/4 | 1C | A ← (A) - (m..m+2) | |
| SUBF m | 3/4 | 5C | F ← (F) - (m..m+5) | F |
| SUBR r1,r2 | 2 | 94 | r2 ← (r2) - (r1) | |
| SVC n | 2 | B0 | Gera interrupção SVC | |
| TD m | 3/4 | E0 | Testa a device dada por (m) | PC |
| TIO | 1 | F8 | Testa o canal de Entrada/Saída número (A) | PC |
| TIX m | 3/4 | 2C | X ← (X) + 1; (X) : (m..m+2) | C |
| TIXR r1 | 2 | B8 | X ← (X) + 1; (X) : (r1) | C |
| WD m | 3/4 | DC | Device especificado por (m) ← (A) | P |


## Executor 

Lógica pricipal de execução do código,lê uma entrada com os arquivos objetos do código em sic/xe e roda conforme ele.

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
    }
    
    public static void atualizar(String instrução , int tipo) {
    }


## Registradores

Segue a lógica do processador,com seu valor e endereço e os métodos relacionados.


## Ligador

Essa classe implementa a lógica da tabela de símbolos,com seu respectivo endereço,operação e valor,todos salvos a partir da metade da memória(Necessário colocar um arquivo com código base do programa)


## Montador

Lê o arquivo fonte e monta as instruções todas em uma única etapa,com o opcode em binário,a mnemônica e o respectivo código-fonte.


## Carregador de Macros

Lê um arquivo com os macros separados,onde ele separa a chamada completa do macro,seu nome e seu valor em binário para ser salvo na memória.


## Memória 

É uma pilha com elementos em forma de String, e armazena loads,instruções recentes,macros e variáveis.


## Interface

Interface que mostra todos os elementos citados anteriormente com um botão de executar.
![Interface do Simulador SIC/XE](/interface.jpg)


## Instalação

1. Baixar uma IDE que suporte arquvios locais(Eclipse,VS code,Intellij);

2. Instalar a JVM;

3. Rodar a interface e clickar no botão executar duas vezes;

## Referências

 - [Arquitetura SIC/XE](https://www.geeksforgeeks.org/sic-xe-architecture/)
 - [Como Funciona a arquitetura](https://acervolima.com/arquitetura-sic-xe/)
 - [Projeto que serviu de Base](https://github.com/MazenTarek7/SIC-XE-Assembler)