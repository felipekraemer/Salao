/*
 * CadLicoes.java
 *
 * Created on 9 de Maio de 2009, 12:06
 */

package com.jw.controller;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import com.jw.model.LicoesModel;
import com.jw.view.LicaoView;

/**
 *
 * @author  Felipe
 */
public class CadLicoes extends javax.swing.JFrame {
    
    /** Creates new form CadLicoes */
    public CadLicoes() {
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
    
    /*
     * M�todo que carrega a tabela de cadastro de li��es
     */
    private void carregaTabela() {
        tblRegLicoes.setModel(new DefaultTableModel(new Object [][] { },
                new String [] {"No.", "Descrição"}));
        
        if (tblRegLicoes.getRowCount() > 0) {
            for (int i = tblRegLicoes.getRowCount(); i > 0; i--) {
                 DefaultTableModel dtm = (DefaultTableModel) tblRegLicoes.getModel();
                 dtm.removeRow(i - 1);
            }
        }
        
        ArrayList licoes = LicoesModel.pesquisarTodas();
        
        if (licoes != null && !licoes.isEmpty()) {
            Iterator it = licoes.iterator();
            if (it != null) {
                while (it.hasNext()) {
                    LicaoView view = (LicaoView) it.next();
                    DefaultTableModel dtm = (DefaultTableModel) tblRegLicoes.getModel();
                    dtm.addRow(new Object[] {view.getNumero(), view.getDescricao()});
                }
            }
        }
        ajustaLarguraColunas();
    }
    
    private void limpaCampos() {
        txtNumero.setText("");
        txtDescricao.setText("");
    }
    
    private void desabilitaCampos() {
        txtDescricao.setEditable(false);
    }
    
    private void habilitaCampos() {
        txtDescricao.setEditable(true);
    }
    
    private boolean validaFormulario() {
        if (txtDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo Descrição deve ser preenchido.");
            txtDescricao.grabFocus();
            return false;
        }
        
        return true;
    }
    
    public void ajustaLarguraColunas() {
        JTableHeader header = tblRegLicoes.getTableHeader();
        TableCellRenderer tcr = null;
        if (header != null) {
            tcr = header.getDefaultRenderer();
        }
        
        TableColumnModel colunas = tblRegLicoes.getColumnModel();
        TableModel model = tblRegLicoes.getModel();

        int margem = colunas.getColumnMargin();
        int qtdLinhas = model.getRowCount();
        int larguraTotal = 0;

        for (int i = colunas.getColumnCount() - 1; i >= 0; --i) {
            TableColumn modelo = colunas.getColumn(i);
            int indiceColuna = modelo.getModelIndex();
            int largura = -1; 
            TableCellRenderer h = modelo.getHeaderRenderer();

            if (h == null) {
                h = tcr;
            }

            if (h != null) {
                Component c = h.getTableCellRendererComponent(tblRegLicoes, modelo.getHeaderValue(), false, false, -1, i);
                largura = c.getPreferredSize().width;
            }

            for (int linha = qtdLinhas - 1; linha >= 0; --linha) {
                TableCellRenderer r = tblRegLicoes.getCellRenderer(linha, i);
                Component c = r.getTableCellRendererComponent(tblRegLicoes, model.getValueAt(linha, indiceColuna), false, false, linha, i);
                largura = Math.max(largura, c.getPreferredSize().width);
            }

            if (largura >= 0) {
                modelo.setPreferredWidth(largura + margem);
            }
            
            larguraTotal += modelo.getPreferredWidth();
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegLicoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lições da Escola");
        setResizable(false);

        jLabel1.setText("Número:");

        jLabel2.setText("Descrição:");

        txtNumero.setEditable(false);

        txtDescricao.setEditable(false);
        txtDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescricaoKeyTyped(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.setEnabled(false);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblRegLicoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lições Cadastradas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegLicoes.setRowSelectionAllowed(false);
        tblRegLicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegLicoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegLicoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnAlterar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(btnOK)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescricaoKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isLetter(c) && !Character.isSpaceChar(c)) || txtDescricao.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescricaoKeyTyped

    private void tblRegLicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegLicoesMouseClicked
        int numeroSelecionado = ((Integer) tblRegLicoes.getModel().getValueAt(tblRegLicoes.getSelectedRow(), 0)).intValue();
        
        if (numeroSelecionado != 0) {
            int retorno = 0;
            if (txtDescricao.isEditable()) { //usu�rio estava inserindo / editando dados
                retorno = JOptionPane.showConfirmDialog(null, "Os dados não salvos serão perdidos. Deseja continuar?");
            }
            if (retorno == 0) {
                btnAlterar.setEnabled(true);
                
                LicaoView view = LicoesModel.pesquisar(numeroSelecionado);
                if (view != null) {
                    setNumeroLicao(view.getNumero());
                    txtNumero.setText(String.valueOf(view.getNumero()));
                    txtDescricao.setText(view.getDescricao());
                }
            }
            
            btnAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_tblRegLicoesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int retorno = JOptionPane.showConfirmDialog(null, "Os dados não salvos serão perdidos. Deseja continuar?");
        if (retorno == 0) {
            limpaCampos();
            desabilitaCampos();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnOK.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (validaFormulario()) {
            LicaoView view = new LicaoView();
            
            if (isAlteracao()) {
                view.setNumero(getNumeroLicao());
            }
            view.setDescricao(txtDescricao.getText());
            
            if (isInsercao()) {
                LicoesModel.inserir(view);
            } else if (isAlteracao()) {
                LicoesModel.alterar(view);
            }
            
            setNumeroLicao(view.getNumero());
            
            carregaTabela();
            limpaCampos();
            desabilitaCampos();
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnOK.setEnabled(false);
            btnCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        habilitaCampos();
        setAlteracaoInsercao("A");
        txtDescricao.grabFocus();
        
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnOK.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCampos();
        habilitaCampos();
        txtDescricao.grabFocus();
        setAlteracaoInsercao("I");
        
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnOK.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnNovoActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadLicoes().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegLicoes;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Declara��o de vari�veis do formul�rio
     */
    private String alteracaoInsercao = "";
    private int numeroLicao = 0;
    
    /**
     * M�todos Get e Set das vari�veis do formul�rio
     */
    private int getNumeroLicao() {
        return numeroLicao;
    }
    
    private void setNumeroLicao(int numeroLicao) {
        this.numeroLicao = numeroLicao;
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