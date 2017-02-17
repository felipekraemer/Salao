/*
 * CadPublicadores.java
 *
 * Created on 9 de Abril de 2009, 00:09
 */

package com.jw.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.jw.model.PublicadoresModel;
import com.jw.view.PublicadorView;

/**
 *
 * @author  Felipe
 */
public class CadPublicadores extends javax.swing.JFrame {
    
    /** Creates new form CadPublicadores */
    public CadPublicadores() {
        initComponents();
        centralizaTela();
        carregaTabela();
    }
    
    private void centralizaTela() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        
        this.setLocation(x, y);
    }
    
    /**
     * Método que limpa os campos do formulário
     */
    private void limpaCampos() {
        txtNome.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtDataNascimento.setText("");
        txtDataBatismo.setText("");
        txtObs.setText("");
        cboOOUngido.setSelectedIndex(0);
        cboPrivilegio.setSelectedIndex(0);
        cboSituacao.setSelectedIndex(0);
        chbParticipaEscola.setSelected(false);
        optMasculino.setSelected(false);
        optFeminino.setSelected(false);
        txtUsuario.setText("");
        txtSenha.setText("");
    }
    
    /**
     * Método que desabilita os campos do formulário
     */
    public void desabilitaCampos() {
        txtNome.setEditable(false);
        txtEndereco.setEditable(false);
        txtTelefone.setEditable(false);
        txtEmail.setEditable(false);
        txtDataNascimento.setEditable(false);
        txtDataBatismo.setEditable(false);
        txtObs.setEditable(false);
        txtObs.setEnabled(false);
        txtObs.setOpaque(false);
        cboOOUngido.setEnabled(false);
        cboOOUngido.setOpaque(false);
        chbParticipaEscola.setEnabled(false);
        chbParticipaEscola.setOpaque(false);
        cboPrivilegio.setEnabled(false);
        cboPrivilegio.setOpaque(false);
        cboSituacao.setEnabled(false);
        cboSituacao.setOpaque(false);
        optMasculino.setEnabled(false);
        optFeminino.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtUsuario.setEditable(false);
        txtSenha.setEnabled(false);
        txtSenha.setEditable(false);
    }
    
    /**
     * Método que habilita os campos do formulário
     */
    private void habilitaCampos() {
        txtNome.setEditable(true);
        txtEndereco.setEditable(true);
        txtTelefone.setEditable(true);
        txtEmail.setEditable(true);
        txtDataNascimento.setEditable(true);
        txtDataBatismo.setEditable(true);
        txtObs.setEditable(true);
        txtObs.setEnabled(true);
        txtObs.setOpaque(true);
        cboOOUngido.setEnabled(true);
        cboOOUngido.setOpaque(true);
        cboPrivilegio.setEnabled(true);
        cboPrivilegio.setOpaque(true);
        cboSituacao.setEnabled(true);
        cboSituacao.setOpaque(true);
        chbParticipaEscola.setEnabled(true);
        chbParticipaEscola.setOpaque(true);
        optMasculino.setEnabled(true);
        optFeminino.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtUsuario.setEditable(true);
        txtSenha.setEnabled(true);
        txtSenha.setEditable(true);
    }
    
    /*
     * M�todo que carrega a tabela de cadastro de publicadores
     */
    private void carregaTabela() {
        DefaultTableModel model = (DefaultTableModel)tblRegPublicadores.getModel();
        
        if (tblRegPublicadores.getRowCount() > 0) {
            for (int i = tblRegPublicadores.getRowCount(); i > 0; i--) {
                model.removeRow(i - 1);
            }
        }
        
        ArrayList publicadores = PublicadoresModel.pesquisarTodos();
        
        if (publicadores != null) {
            Iterator it = publicadores.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        String nome = ((PublicadorView) it.next()).getNome();
                        model.addRow(new Object[] {nome});
                    }
            }
        }
        
        
    }
    
    /**
     * Método que valida os campos do formulário
     * @return Se os campos estão válidos ou não
     */
    public boolean validaCampos() {
        
        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo Nome deve ser preenchido.");
            txtNome.grabFocus();
            return false;
        }
        
        if (!txtTelefone.getText().equals("") && txtTelefone.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "O campo Telefone está incorreto.");
            txtTelefone.grabFocus();
            return false;
        }
        
        if (!txtEmail.getText().equals("") && (txtEmail.getText().indexOf("@") == -1 || txtEmail.getText().indexOf(".") == -1)) {
            JOptionPane.showMessageDialog(null, "O campo E-mail está incorreto.");
            txtEmail.grabFocus();
            return false;
        }
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        Date dataNascimento = null;
        Date dataBatismo = null;
        
        if (!txtDataNascimento.getText().equals("")) {
            if (txtDataNascimento.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "O campo Data Nascimento está incorreto.");
                txtDataNascimento.grabFocus();
                return false;
            }
            
            try {
                dataNascimento = sdf.parse(txtDataNascimento.getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(null, "O campo Data Nascimento está incorreto.");
                txtDataNascimento.grabFocus();
                return false;
            }

            if (!sdf.format(dataNascimento).equals(txtDataNascimento.getText())) {
                JOptionPane.showMessageDialog(null, "O campo Data Nascimento está incorreto.");
                txtDataNascimento.grabFocus();
                return false;
            }
        }
        
        if (!txtDataBatismo.getText().equals("")) {
            if (txtDataBatismo.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "O campo Data Batismo está incorreto.");
                txtDataBatismo.grabFocus();
                return false;
            }
            
            try {
                dataBatismo = sdf.parse(txtDataBatismo.getText());
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(null, "O campo Data Batismo está incorreto.");
                txtDataBatismo.grabFocus();
                return false;
            }

            if (!sdf.format(dataBatismo).equals(txtDataBatismo.getText())) {
                JOptionPane.showMessageDialog(null, "O campo Data Batismo está incorreto.");
                txtDataBatismo.grabFocus();
                return false;
            }
        }
        
        if (dataNascimento != null && dataBatismo != null && dataNascimento.after(dataBatismo)) {
            JOptionPane.showMessageDialog(null, "Data Nascimento não pode ser posterior à Data Batismo.");
            txtDataBatismo.grabFocus();
            return false;
        }
        
        if (!optMasculino.isSelected() && !optFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "O campo Sexo deve ser informado.");
            optMasculino.grabFocus();
            return false;
        }
        
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegPublicadores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboOOUngido = new javax.swing.JComboBox();
        txtEmail = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDataBatismo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboPrivilegio = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        optMasculino = new javax.swing.JRadioButton();
        optFeminino = new javax.swing.JRadioButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        cboSituacao = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        chbParticipaEscola = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Publicadores");
        setResizable(false);

        jLabel1.setText("Nome:");

        txtNome.setEditable(false);
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        jLabel2.setText("Endereço:");

        txtEndereco.setEditable(false);
        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyTyped(evt);
            }
        });

        tblRegPublicadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Publicadores Cadastrados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegPublicadores.setRowSelectionAllowed(false);
        tblRegPublicadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegPublicadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegPublicadores);

        jLabel3.setText("Data Nascimento:");

        jLabel4.setText("Telefone:");

        jLabel5.setText("E-mail:");

        txtTelefone.setEditable(false);
        txtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefoneKeyTyped(evt);
            }
        });

        jLabel6.setText("Outra Ovelha / Ungido:");

        cboOOUngido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Outra Ovelha", "Ungido" }));
        cboOOUngido.setEnabled(false);

        txtEmail.setEditable(false);
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtDataNascimento.setEditable(false);
        txtDataNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataNascimentoKeyTyped(evt);
            }
        });

        jLabel7.setText("Data Batismo:");

        txtDataBatismo.setEditable(false);
        txtDataBatismo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataBatismoKeyTyped(evt);
            }
        });

        jLabel8.setText("Privilégio:");

        cboPrivilegio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Ancião", "Servo Ministerial", "Publicador(a) Batizado(a)", "Publicador(a) Não Batizado(a)" }));
        cboPrivilegio.setEnabled(false);

        jLabel9.setText("Observações:");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
                btnNovojButton1ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("OK");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setText("Sexo:");

        optMasculino.setText("Masculino");
        optMasculino.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        optMasculino.setEnabled(false);
        optMasculino.setMargin(new java.awt.Insets(0, 0, 0, 0));
        optMasculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optMasculinoMouseClicked(evt);
            }
        });

        optFeminino.setText("Feminino");
        optFeminino.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        optFeminino.setEnabled(false);
        optFeminino.setMargin(new java.awt.Insets(0, 0, 0, 0));
        optFeminino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optFemininoMouseClicked(evt);
            }
        });

        txtUsuario.setEditable(false);
        txtUsuario.setEnabled(false);
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        jLabel11.setText("Usuário:");

        jLabel12.setText("Senha:");

        txtSenha.setEditable(false);
        txtSenha.setEnabled(false);
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });

        cboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Pioneiro(a) Especial", "Pioneiro(a) de Tempo Integral", "Pioneiro(a) Regular", "Pioneiro(a) Auxiliar", "Afastado(a)", "Desassociado(a)" }));
        cboSituacao.setEnabled(false);

        jLabel13.setText("Situação:");

        jScrollPane2.setEnabled(false);

        txtObs.setEditable(false);
        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setEnabled(false);
        txtObs.setOpaque(false);
        jScrollPane2.setViewportView(txtObs);

        chbParticipaEscola.setText("Participa da Escola");
        chbParticipaEscola.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addComponent(txtEndereco)
                            .addComponent(txtNome)
                            .addComponent(txtEmail)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboOOUngido, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cboPrivilegio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtDataNascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(optMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(optFeminino)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbParticipaEscola)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboSituacao, 0, 212, Short.MAX_VALUE)
                                        .addComponent(txtDataBatismo)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboOOUngido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDataBatismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(optFeminino)
                    .addComponent(optMasculino)
                    .addComponent(chbParticipaEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboPrivilegio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNovo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar)
                        .addComponent(btnCancelar)
                        .addComponent(btnAlterar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optFemininoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optFemininoMouseClicked
        optFeminino.setSelected(true);
        optMasculino.setSelected(false);
    }//GEN-LAST:event_optFemininoMouseClicked

    private void optMasculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optMasculinoMouseClicked
        optMasculino.setSelected(true);
        optFeminino.setSelected(false);
    }//GEN-LAST:event_optMasculinoMouseClicked

    private void txtDataBatismoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataBatismoKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isDigit(c) && c != '/') || txtDataBatismo.getText().length() >= 10) {
            evt.consume();
        }
        
        if (txtDataBatismo.getText().length() == 2 || txtDataBatismo.getText().length() == 5) {
            txtDataBatismo.setText(txtDataBatismo.getText() + "/");
        }
    }//GEN-LAST:event_txtDataBatismoKeyTyped

    private void txtDataNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataNascimentoKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isDigit(c) && c != '/') || txtDataNascimento.getText().length() >= 10) {
            evt.consume();
        }
        
        if (txtDataNascimento.getText().length() == 2 || txtDataNascimento.getText().length() == 5) {
            txtDataNascimento.setText(txtDataNascimento.getText() + "/");
        }
    }//GEN-LAST:event_txtDataNascimentoKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        if(txtEmail.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyTyped
        if(txtEndereco.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEnderecoKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isLetter(c) && !Character.isSpaceChar(c)) || txtNome.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoneKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) || txtTelefone.getText().length() >= 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefoneKeyTyped

    /**
     * M�todo chamado quando clica-se na tabela de registro de publicadores
     * @param MouseEvent - O evento chamado quando clica-se na tabela
     */
    private void tblRegPublicadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegPublicadoresMouseClicked
        String nomeSelecionado = (String) tblRegPublicadores.getModel().getValueAt(tblRegPublicadores.getSelectedRow(), tblRegPublicadores.getSelectedColumn());
        if (!nomeSelecionado.equals("")) {
            int retorno = 0;
            if (txtNome.isEditable()) { //usu�rio estava inserindo / editando dados
                retorno = JOptionPane.showConfirmDialog(null, "Os dados não salvos serão perdidos. Deseja continuar?");
            }
            if (retorno == 0) {
                btnAlterar.setEnabled(true);

                PublicadorView view = PublicadoresModel.pesquisar(nomeSelecionado);
                if (view != null) {
                    setCodigo(view.getCodigo());
                    txtNome.setText(view.getNome());
                    txtEndereco.setText(view.getEndereco());
                    txtTelefone.setText(String.valueOf(view.getTelefone()));
                    txtEmail.setText(view.getEmail());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    if (view.getDataNascimento() != null) {
                        txtDataNascimento.setText(sdf.format(view.getDataNascimento()));
                    } else {
                        txtDataNascimento.setText("");
                    }
                    
                    if (view.getDataBatismo() != null) {
                        txtDataBatismo.setText(sdf.format(view.getDataBatismo()));
                    } else {
                        txtDataBatismo.setText("");
                    }
                    
                    if(view.getSexo() == null) {
                        view.setSexo("");
                    }
                    
                    switch (view.getSexo()) {
                        case "M":
                            optMasculino.setSelected(true);
                            optFeminino.setSelected(false);
                            break;
                        case "F":
                            optFeminino.setSelected(true);
                            optMasculino.setSelected(false);
                            break;
                        default:
                            optMasculino.setSelected(false);
                            optFeminino.setSelected(false);
                            break;
                    }
                    
                    txtObs.setText(view.getObservacoes());
                    
                    String ungidoOutraOvelha = "";
                    if (view.getUngidoOutraOvelha().equals("UN")) {
                        ungidoOutraOvelha = "Ungido";
                    } else {
                        ungidoOutraOvelha = "Outra Ovelha";
                    }
                    
                    cboOOUngido.setSelectedItem(ungidoOutraOvelha);
                    
                    String privilegio = view.getPrivilegio();
                    switch (privilegio) {
                        case "ANC":
                            privilegio = "Ancião";
                            break;
                        case "SEM":
                            privilegio = "Servo Ministerial";
                            break;
                        case "PUB":
                            privilegio = "Publicador(a) Batizado(a)"; 
                            break;
                        case "PNB":
                            privilegio = "Publicador(a) Não Batizado(a)";
                            break;
                    }
                    cboPrivilegio.setSelectedItem(privilegio);
                    
                    chbParticipaEscola.setSelected(view.getParticipaEscola());
                    
                    txtUsuario.setText(view.getUsuario());
                    txtSenha.setText(view.getSenha());
                    
                    String situacao = view.getSituacao();
                    switch (situacao) {
                        case "PIE":
                            situacao = "Pioneiro(a) Especial";
                            break;
                        case "PTI":
                            situacao = "Pioneiro(a) de Tempo Integral";
                            break;
                        case "PIR":
                            situacao = "Pioneiro(a) Regular";
                            break;
                        case "PIA":
                            situacao = "Pioneiro(a) Auxiliar";
                            break;
                        case "AFA":
                            situacao = "Afastado(a)";
                            break;
                        case "DES":
                            situacao = "Desassociado(a)";
                            break;
                    }
                    cboSituacao.setSelectedItem(situacao);
                }
            }
        }
    }//GEN-LAST:event_tblRegPublicadoresMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int retorno = JOptionPane.showConfirmDialog(null, "Os dados não salvos serão perdidos. Deseja continuar?");
        if (retorno == 0) {
            limpaCampos();
            desabilitaCampos();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnCadastrar.setEnabled(false);
            btnCancelar.setEnabled(false);
            tblRegPublicadores.setEnabled(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validaCampos()) {
            PublicadorView view = new PublicadorView();
            
            if (isAlteracao()) {
                view.setCodigo(getCodigo());
            }
            view.setNome(txtNome.getText());
            view.setEndereco(txtEndereco.getText());
            view.setTelefone(txtTelefone.getText());
            view.setEmail(txtEmail.getText());
            
            if (!txtDataNascimento.getText().equals("")) {
                String strDataNascimento[] = txtDataNascimento.getText().split("/");
                
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.set(Integer.parseInt(strDataNascimento[2]),      //ano
                                   Integer.parseInt(strDataNascimento[1]) - 1,  //mês Janeiro = 0
                                   Integer.parseInt(strDataNascimento[0]));     //dia
                
                view.setDataNascimento(dataNascimento.getTime());
            }
            
            if (!txtDataBatismo.getText().equals("")) {
                String strDataBatismo[] = txtDataBatismo.getText().split("/");
                
                Calendar dataBatismo = Calendar.getInstance();
                dataBatismo.set(Integer.parseInt(strDataBatismo[2]),      //ano
                                Integer.parseInt(strDataBatismo[1]) - 1,  //mês Janeiro = 0
                                Integer.parseInt(strDataBatismo[0]));     //dia


                view.setDataBatismo(dataBatismo.getTime());
            }
            
            if (optMasculino.isSelected()) {
                view.setSexo("M");
            } else if (optFeminino.isSelected()) {
                view.setSexo("F");
            }
            
            view.setObservacoes(txtObs.getText());
            
            String ungidoOutraOvelha = String.valueOf(cboOOUngido.getSelectedItem());
            if (ungidoOutraOvelha.equals("Ungido")) {
                ungidoOutraOvelha = "UN";
            } else {
                ungidoOutraOvelha = "OO";
            }
            view.setUngidoOutraOvelha(ungidoOutraOvelha);
            
            String privilegio = String.valueOf(cboPrivilegio.getSelectedItem());
            switch (privilegio) {
                case "Ancião":
                    privilegio = "ANC";
                    break;
                case "Servo Ministerial":
                    privilegio = "SEM";
                    break;
                case "Publicador(a) Batizado(a)":
                    privilegio = "PUB"; 
                    break;
                case "Publicador(a) Não Batizado(a)":
                    privilegio = "PNB";
                    break;
            }
            
            view.setPrivilegio(privilegio);
            
            String situacao = String.valueOf(cboSituacao.getSelectedItem());
            switch (situacao) {
                case "Pioneiro(a) Especial":
                    situacao = "PIE";
                    break;
                case "Pioneiro(a) de Tempo Integral":
                    situacao = "PTI";
                    break;
                case "Pioneiro(a) Regular":
                    situacao = "PIR";
                    break;
                case "Pioneiro(a) Auxiliar":
                    situacao = "PIA";
                    break;
                case "Afastado(a)":
                    situacao = "AFA";
                    break;
                case "Desassociado(a)":
                    situacao = "DES";
                    break;
                default: 
                    situacao = "";
                    break;
            }
            view.setSituacao(situacao);
            
            view.setParticipaEscola(chbParticipaEscola.isSelected());
            
            view.setUsuario(txtUsuario.getText());
            view.setSenha(txtSenha.getText());
            
            if (isInsercao()) {
                PublicadoresModel.inserir(view);
            } else if (isAlteracao()) {
                PublicadoresModel.editar(view);
            }
            
            setCodigo(view.getCodigo());
            
            carregaTabela();
            limpaCampos();
            desabilitaCampos();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnCadastrar.setEnabled(false);
            btnCancelar.setEnabled(false);
            tblRegPublicadores.setEnabled(true);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        habilitaCampos();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtNome.grabFocus();
        tblRegPublicadores.setEnabled(false);
        setAlteracaoInsercao("A");
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovojButton1ActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_btnNovojButton1ActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        habilitaCampos();
        limpaCampos();
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        txtNome.grabFocus();
        tblRegPublicadores.setEnabled(false);
        setAlteracaoInsercao("I");
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        if(txtUsuario.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped
        if(txtSenha.getText().length() >= 45) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSenhaKeyTyped
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPublicadores().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cboOOUngido;
    private javax.swing.JComboBox cboPrivilegio;
    private javax.swing.JComboBox cboSituacao;
    private javax.swing.JCheckBox chbParticipaEscola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton optFeminino;
    private javax.swing.JRadioButton optMasculino;
    private javax.swing.JTable tblRegPublicadores;
    private javax.swing.JTextField txtDataBatismo;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Declara��o de vari�veis do formul�rio
     */
    private String alteracaoInsercao = "";
    private long codigo = 0;
    
    /**
     * M�todos Get e Set das vari�veis do formul�rio
     */
    private long getCodigo() {
        return codigo;
    }
    
    private void setCodigo(long codCliente) {
        this.codigo = codCliente;
    }
    
    private boolean isAlteracao() {
        return alteracaoInsercao.equals("A");
    }
    
    private boolean isInsercao() {
        return alteracaoInsercao.equals("I");
    }
    
    private void setAlteracaoInsercao(String alteracaoInsercao) {
        this.alteracaoInsercao = alteracaoInsercao;
    }
}
