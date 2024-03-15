/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package executor;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import java.awt.event.*;

/**
 *
 * @author ACER
 */
public class Interface2 extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean emExecucao = false;
	/**
     * Creates new form Interface
     */
    public Interface2() {
        initComponents();
        setResizable(true); // Permite redimensionar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a aplicação ao fechar a janela
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Inicia em modo de tela cheia
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    setExtendedState(JFrame.NORMAL); // Restaura para o modo normal
                    setResizable(true); // Torna a janela redimensionável novamente
                }
            }
        });
        setFocusable(true); // Torna a janela focável para receber eventos de teclado
     // Defina cores de fundo para os painéis
        jPanel1.setBackground(new Color(240, 240, 240)); // Cor de fundo cinza claro para o painel principal
        jScrollPane1.setBackground(Color.WHITE); // Cor de fundo branca para a área de rolagem

        // Defina cores de texto e estilo de fonte para os rótulos
        jLabel1.setFont(new Font("Arial", Font.BOLD, 24)); // Define a fonte em negrito com tamanho 24 para o rótulo
        jLabel1.setForeground(Color.BLUE); // Define a cor do texto como azul
        jLabel2.setForeground(Color.BLACK); // Define a cor do texto como preto

        // Adicione cores de fundo e texto para os botões
        Executar.setBackground(Color.GREEN); // Cor de fundo verde para o botão
        Executar.setForeground(Color.WHITE); // Cor do texto branco para o botão
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Instruções = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Executar = new javax.swing.JButton();
        PC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        A = new javax.swing.JTextField();
        X = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        L = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Montador = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Macros = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Simbolos = new javax.swing.JTextArea();
        memoria = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Memoria = new javax.swing.JTextArea();
        memoria1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 18)); // NOI18N
        jLabel1.setText("Sic/XE");

        Instruções.setColumns(20);
        Instruções.setRows(5);
        jScrollPane1.setViewportView(Instruções);

        jLabel2.setText("Código");

        Executar.setText("Executar");
        Executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecutarActionPerformed1(evt);
            }
        });

        PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCActionPerformed(evt);
            }
        });

        jLabel3.setText("PC");

        jLabel4.setText("Reg X");

        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });

        jLabel5.setText("Reg A");

        jLabel6.setText("Reg L");

        L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LActionPerformed(evt);
            }
        });

        jLabel7.setText("Montador");

        Montador.setColumns(20);
        Montador.setRows(5);
        jScrollPane2.setViewportView(Montador);

        jLabel8.setText("Macros");

        Macros.setColumns(20);
        Macros.setRows(5);
        jScrollPane3.setViewportView(Macros);

        Simbolos.setColumns(20);
        Simbolos.setRows(5);
        jScrollPane4.setViewportView(Simbolos);

        memoria.setText("Memória");

        Memoria.setColumns(20);
        Memoria.setRows(5);
        jScrollPane5.setViewportView(Memoria);

        memoria1.setText("Simbolos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Executar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(memoria1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel3)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(memoria))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(111, 111, 111))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(120, 120, 120))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Executar)))
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memoria1)
                    .addComponent(memoria)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void ExecutarActionPerformed1(java.awt.event.ActionEvent evt) {                                         
    	 // Verifica se o código já está em execução
        if (!emExecucao) {
            // Define que o código está em execução
            emExecucao = true;

            // Desativa o botão "Executar" para evitar múltiplas execuções simultâneas
            Executar.setEnabled(false);

            // Lógica para iniciar a execução do código
            try {
                // Inicia a execução do código chamando o método main da classe Executor
                Executor.main(new String[]{});

                // Atualiza a interface com informações relevantes, se necessário
                // Por exemplo: exibir uma mensagem de conclusão, habilitar controles, etc.
            } catch (Exception ex) {
                // Trata qualquer exceção que possa ocorrer durante a execução
                // Você pode exibir uma mensagem de erro para o usuário ou realizar outras ações apropriadas
                ex.printStackTrace(); // Aqui, apenas imprimimos o rastreamento da pilha para depuração
            } finally {
                // Marca o fim da execução do código
                emExecucao = false;

                // Ativa novamente o botão "Executar" após a conclusão da execução ou tratamento de exceções
                Executar.setEnabled(true);
            }
        }
                         
    }                                        

    private void XActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
    }                                 

    private void LActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
    }                                 

    private void PCActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
    }
    
    public void atualizarInterface(List<TabelaSimbolos> simbolos) {
        StringBuilder textoSimbolos = new StringBuilder();
        for (TabelaSimbolos entrada : simbolos) {
            textoSimbolos.append("Símbolo: ").append(entrada.getNome()).append("\n");
            textoSimbolos.append("Endereço: ").append(entrada.getEndereco()).append("\n");
            textoSimbolos.append("Valor: ").append(entrada.getValor()).append("\n\n");
        }
        atualizarSimbolos(textoSimbolos.toString());
    }
    public void atualizarMemoria(String[] memoria) {
        StringBuilder textoMemoria = new StringBuilder();
        for (int i = 0; i < memoria.length; i++) {
            textoMemoria.append("Endereço ").append(i).append(": ").append(memoria[i]).append("\n");
        }
        Memoria.setText(textoMemoria.toString());
    }
    
    public void atualizarSimbolos(String textoSimbolos) {
        Simbolos.setText(textoSimbolos); // Supondo que Simbolos seja o JTextArea onde você deseja exibir os símbolos
    }
    
    public void atualizar(String instrucao, int ValorA , int ValorX , int ValorL , int ValorPC, String binario , String mnemonico , String codigoFonte , List<Macro> macros){
         
            Montador.append(binario + " | " + mnemonico + " | " + codigoFonte + "\n");
            // RegistradorPC.setText(Integer.toString(PC.getValor()));
            A.setText(Integer.toString(ValorA));
            X.setText(Integer.toString(ValorX));
            L.setText(Integer.toString(ValorL));
            PC.setText(Integer.toString(ValorPC));
            // RegistradorA.setText(Integer.toString(A.getValor()));
            // RegistradorX.setText(Integer.toString(X.getValor()));
            // RegistradorL.setText(Integer.toString(L.getValor()));
            Instruções.append(instrucao + "\n");
            for (Macro macro : macros) {
                Macros.append("Nome da Macro: " + macro.getNome() + "\n");
                Macros.append("Bin da Macro: " + macro.valorBin() + "\n");
                Macros.append("Chamada da Macro: " + macro.getChamada() + "\n");
                Macros.append("---------\n");
            }
        ;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField A;
    private javax.swing.JButton Executar;
    private javax.swing.JTextArea Instruções;
    private javax.swing.JTextField L;
    private javax.swing.JTextArea Macros;
    private javax.swing.JTextArea Memoria;
    private javax.swing.JTextArea Montador;
    private javax.swing.JTextField PC;
    private javax.swing.JTextArea Simbolos;
    private javax.swing.JTextField X;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel memoria;
    private javax.swing.JLabel memoria1;
    // End of variables declaration                   
}
