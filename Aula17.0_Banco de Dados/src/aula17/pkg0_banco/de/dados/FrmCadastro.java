/*
Janela Principal
 */
package aula17.pkg0_banco.de.dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrmCadastro extends javax.swing.JFrame {
    
    List<Funcionario> listaFuncionarios;
       
    public FrmCadastro() {
        listaFuncionarios = new ArrayList<Funcionario>();
        initComponents();
    }
    
    private void cadastrarFuncionarios(){
        Funcionario funcionario = new Funcionario();
        
        String nome = txtNome.getText();
        funcionario.setNome(nome);
        
        Character sexo = ' ';
        if (rbtnM.isSelected()){
            sexo='M';
        } else {
            sexo='F';
        }
        funcionario.setSexo(sexo);
        
        String endereco = txtEndereco.getText();
        funcionario.setEndereco(endereco);
        
        String bairro = txtBairro.getText();
        funcionario.setBairro(bairro);
        
        String complemento = txtComplemento.getText();
        funcionario.setComplemento(complemento);
        
        String municipio = txtMunicipio.getText();
        funcionario.setMunicipio(municipio);
        
        String uf = cmbUf.getSelectedItem().toString();
        funcionario.setUf(uf);
       
        //Acrscenta na lista
        listaFuncionarios.add(funcionario);
        
        FuncionarioDAL funcionarioDB = new FuncionarioDAL();
        funcionarioDB.salvar(funcionario);
        
        
        
        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!!!!");
        txtNome.setText("");
        rbtnM.setSelected(true);
        txtEndereco.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtMunicipio.setText("");
        cmbUf.setSelectedItem("");
    }
    
    private void exibirFuncionarios(){
        
        String dados = " ";
        for(Funcionario funcionario : listaFuncionarios){
                dados = dados+funcionario.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, dados);
        
    }
    
    private void exportar(){
        //Pode ocorrer um erro de arquivo nao encontrado, é preciso usar o Try Catch
        try{
            
            JFileChooser fc = new JFileChooser();   //Caixa de dialogo salvar   
            int resultado = fc.showSaveDialog(this);    //O que aconteceu com a iteração (O usuario escolher um arquivo)
            
            if (resultado == JFileChooser.APPROVE_OPTION){ 
                File arquivo = fc.getSelectedFile();    //Cria um objeto do tipo arquivo com o arquivo selecionado 
                FileWriter fw = new FileWriter(arquivo);    //Classe que escrever em arquivo
                BufferedWriter bw = new BufferedWriter(fw);      //Bufferiza dados antes de escrever
                
                for (Funcionario funcionario : listaFuncionarios){
                    bw.write(funcionario.toString());
                    bw.newLine();
                }
                bw.close();
            }
          //  throw new Exception("Aconteceu algo errado");
        } catch (Exception ex){
            //ex.printStackTrace();
        }
        
    }
    
    private void exportarSerial(){
        try{
            JFileChooser fc = new JFileChooser();
            int resultado = fc.showSaveDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION){
                File arquivo = fc.getSelectedFile();
                FileOutputStream fos = new FileOutputStream(arquivo);   //Cria uma gravação de stream de dados(Gera somente primitivos) 
                ObjectOutputStream oos = new ObjectOutputStream(fos);   //Grava um fluxo de dados
                oos.writeObject(listaFuncionarios);
                oos.close();
            }   
            
            }catch(Exception ex){
                //ex.printStackTrace();
        }
        
        
    }
    
    private void importar(){
        try{
            //Janela de Dialogo para abrir
            JFileChooser fc = new JFileChooser();
            int resultado = fc.showOpenDialog(this);    //O que aconteceu com a iteração (O usuario escolher um arquivo)    
           
            if (resultado == JFileChooser.APPROVE_OPTION){   //Se o usuario selecionou um arquivo correto
                File arquivo = fc.getSelectedFile();    //Cria um objeto do tipo arquivo com o arquivo selecionado
                FileReader fr = new FileReader(arquivo);    //Classe que ler um arquivo
                BufferedReader br = new BufferedReader(fr);     //Buffer para ler arquivos
                
                while(br.ready()){  //Lê o arquivo até chegar o fim
                    String dados = br.readLine();    //Lê uma linha
                    Funcionario func = new Funcionario();   
                    func.formString(dados);
                    listaFuncionarios.add(func);
                }
            br.close(); //Fecha o arquivo 
            }
        } catch(Exception ex){  
        //executa caso o try ocorrer erro
        } finally {
          //Executa depois da excessão
        }
    } 
    
    private void importarSerial(){
        try{
            JFileChooser fc = new JFileChooser();
            int resultado = fc.showOpenDialog(this);

            if(resultado == JFileChooser.APPROVE_OPTION){
                File arquivo = fc.getSelectedFile();
                FileInputStream fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                listaFuncionarios = (List<Funcionario>) ois.readObject();
                ois.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBtnSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbUf = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        rbtnM = new javax.swing.JRadioButton();
        rbtnF = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        btnVisualizar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Funcionários 1.3");

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Sexo");

        jLabel5.setText("Complemento");

        jLabel6.setText("UF");

        cmbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        jLabel7.setText("Bairro");

        grupoBtnSexo.add(rbtnM);
        rbtnM.setSelected(true);
        rbtnM.setText("M");
        rbtnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMActionPerformed(evt);
            }
        });

        grupoBtnSexo.add(rbtnF);
        rbtnF.setText("F");

        jLabel8.setText("Município");

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar Dado");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportar.setText("Importar Dado");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbtnM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbtnF))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5)
                                            .addComponent(txtComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                            .addComponent(txtEndereco)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnM)
                            .addComponent(rbtnF))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarFuncionarios();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        exibirFuncionarios();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        exportarSerial();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        importarSerial();
    }//GEN-LAST:event_btnImportarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cmbUf;
    private javax.swing.ButtonGroup grupoBtnSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnF;
    private javax.swing.JRadioButton rbtnM;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
