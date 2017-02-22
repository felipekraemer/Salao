/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jw.controller;

import com.jw.model.ProgramaSemanalModel;
import com.jw.view.ProgramaSemanalView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Kraemer
 */
public class CadApostila extends javax.swing.JFrame {

    private Date semana = new Date();
    private String alteracaoInsercao = "";
    
    private Date getSemana() {
        return semana;
    }
    
    private void setSemana(Date semana) {
        this.semana = semana;
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
    
    private String getMesExtenso(int mes) {
        switch (mes) {
            case 1: return "Janeiro";
            case 2: return "Fevereiro";
            case 3: return "Março";
            case 4: return "Abril";
            case 5: return "Maio";
            case 6: return "Junho";
            case 7: return "Julho";
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
            default: return "";
        }
    }
    
    private void carregaSemana() {
        try {
            String intervalo = "";
            
            Calendar c = Calendar.getInstance();
            c.setTime(getSemana());
            Date dataPesquisa = getSemana();
            
            int diaInicial = c.get(Calendar.DAY_OF_MONTH);
            int mesInicial = c.get(Calendar.MONTH) + 1;
            
            c.add(Calendar.DATE, 6);
            int diaFinal = c.get(Calendar.DAY_OF_MONTH);
            int mesFinal = c.get(Calendar.MONTH) + 1;
            
            if (mesInicial == mesFinal) {
                intervalo += diaInicial + " - " + diaFinal + " de " + getMesExtenso(mesFinal);
            } else {
                intervalo += diaInicial + " de " + getMesExtenso(mesInicial) + " - " + diaFinal + " de " + getMesExtenso(mesFinal);
            }
            
            lblSemana.setText(intervalo);
            
            ProgramaSemanalView semanaView = ProgramaSemanalModel.pesquisar(dataPesquisa);
            if (semanaView != null) {
                txtCanticoInicial.setText(semanaView.getCanticoInicial() + "");
                txtCanticoIntermediario.setText(semanaView.getCanticoIntermediario() + "");
                txtCanticoFinal.setText(semanaView.getCanticoFinal() + "");
                txtTesourosDiscurso.setText(semanaView.getTesourosDiscursoTema());
                txtDesignacaoUm.setText(semanaView.getMinisterioUmDiscursoTema());
                if (!semanaView.getMinisterioUmDiscursoTema().equals("")) { 
                    optDesignacaoUm.setSelected(true);
                } else if (!semanaView.getMinisterioTresDiscursoTema().equals("")) {
                    optDesignacaoTresDiscurso.setSelected(true);
                } else {
                    optDesignacaoTresEstudo.setSelected(true);
                }
                txtDesignacaoTres.setText(semanaView.getMinisterioTresDiscursoTema());
                txtVidaParte1.setText(semanaView.getVidaParte1Tema());
                txtVidaParte1Tempo.setText(semanaView.getVidaParte1Tempo() + "");
                txtVidaParte2.setText(semanaView.getVidaParte2Tema());
                txtVidaParte2Tempo.setText(semanaView.getVidaParte2Tempo() + "");
                
                btnAlterar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Não foram encontrados dados para a semana de " + intervalo + ".");
                btnAlterar.setEnabled(false);
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Um erro ocorreu ao executar esta operação.");
        }
    }
    
    
    /**
     * Creates new form CadApostila
     */
    public CadApostila() {
        initComponents();
        centralizaTela();
        
        // Busca a segunda-feira da semana atual
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int mondayNo = c.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_WEEK) + 2;
        
        // Ajusta a data atual para a segunda-feira da semana semana atual
        c.set(Calendar.DAY_OF_MONTH, mondayNo);
        setSemana(c.getTime());
        
        carregaSemana();
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnSemanaAnterior = new javax.swing.JButton();
        btnSemanaProxima = new javax.swing.JButton();
        lblSemana = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTesourosDiscurso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        optDesignacaoUm = new javax.swing.JRadioButton();
        txtDesignacaoUm = new javax.swing.JTextField();
        optDesignacaoTresDiscurso = new javax.swing.JRadioButton();
        txtDesignacaoTres = new javax.swing.JTextField();
        optDesignacaoTresEstudo = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtVidaParte1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVidaParte2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtVidaParte1Tempo = new javax.swing.JTextField();
        txtVidaParte2Tempo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCanticoInicial = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtCanticoIntermediario = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCanticoFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Semanal da Apostila");
        setPreferredSize(new java.awt.Dimension(733, 535));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Escolha a Semana"));

        btnSemanaAnterior.setText("<");
        btnSemanaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemanaAnteriorActionPerformed(evt);
            }
        });

        btnSemanaProxima.setText(">");
        btnSemanaProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemanaProximaActionPerformed(evt);
            }
        });

        lblSemana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSemana.setText("6 - 12 de Fevereiro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSemanaAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSemanaProxima)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSemanaAnterior)
                    .addComponent(btnSemanaProxima)
                    .addComponent(lblSemana))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tesouros da Palavra de Deus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtTesourosDiscurso.setEnabled(false);
        txtTesourosDiscurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTesourosDiscursoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tema do discurso:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTesourosDiscurso)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTesourosDiscurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Faça seu Melhor no Ministério", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroup1.add(optDesignacaoUm);
        optDesignacaoUm.setSelected(true);
        optDesignacaoUm.setText("Uma designação, cujo tema é:");
        optDesignacaoUm.setEnabled(false);
        optDesignacaoUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDesignacaoUmActionPerformed(evt);
            }
        });

        txtDesignacaoUm.setEnabled(false);

        buttonGroup1.add(optDesignacaoTresDiscurso);
        optDesignacaoTresDiscurso.setText("Três designações, a terceira sendo discurso com o tema:");
        optDesignacaoTresDiscurso.setActionCommand("");
        optDesignacaoTresDiscurso.setEnabled(false);
        optDesignacaoTresDiscurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDesignacaoTresDiscursoActionPerformed(evt);
            }
        });

        txtDesignacaoTres.setEnabled(false);

        buttonGroup1.add(optDesignacaoTresEstudo);
        optDesignacaoTresEstudo.setText("Três designações (Primeira Visita, Revisita e Estudo Bíblico)");
        optDesignacaoTresEstudo.setEnabled(false);
        optDesignacaoTresEstudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDesignacaoTresEstudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(optDesignacaoUm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesignacaoUm))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(optDesignacaoTresDiscurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDesignacaoTres, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(optDesignacaoTresEstudo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optDesignacaoUm)
                    .addComponent(txtDesignacaoUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optDesignacaoTresEstudo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optDesignacaoTresDiscurso)
                    .addComponent(txtDesignacaoTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nossa Vida Cristã", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel38.setText("Tema da Parte 1:");

        txtVidaParte1.setEnabled(false);

        jLabel4.setText("Tema da Parte 2 (opcional):");

        txtVidaParte2.setEnabled(false);

        jLabel1.setText("Tempo (min):");

        txtVidaParte1Tempo.setEnabled(false);
        txtVidaParte1Tempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVidaParte1TempoKeyTyped(evt);
            }
        });

        txtVidaParte2Tempo.setEnabled(false);
        txtVidaParte2Tempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVidaParte2TempoKeyTyped(evt);
            }
        });

        jLabel5.setText("Tempo (min):");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVidaParte1)
                    .addComponent(txtVidaParte2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVidaParte1Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVidaParte2Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtVidaParte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtVidaParte1Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtVidaParte2Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVidaParte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cânticos"));

        jLabel2.setText("Cântico Inicial:");

        txtCanticoInicial.setEnabled(false);
        txtCanticoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanticoInicialKeyTyped(evt);
            }
        });

        jLabel27.setText("Cântico Intermediário:");

        txtCanticoIntermediario.setEnabled(false);
        txtCanticoIntermediario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanticoIntermediarioKeyTyped(evt);
            }
        });

        jLabel25.setText("Cântico Final:");

        txtCanticoFinal.setEnabled(false);
        txtCanticoFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanticoFinalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCanticoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCanticoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCanticoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCanticoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtCanticoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtCanticoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAlterar)
                    .addComponent(btnGravar)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTesourosDiscursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTesourosDiscursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTesourosDiscursoActionPerformed

    private void btnSemanaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaAnteriorActionPerformed
        limpaCampos();
        
        Calendar c = Calendar.getInstance();
        c.setTime(getSemana());
        c.add(Calendar.DAY_OF_MONTH, -7);
        
        setSemana(c.getTime());
        
        carregaSemana();
    }//GEN-LAST:event_btnSemanaAnteriorActionPerformed
        
    private void habilitaDesabilitaCampos(boolean valor) {
        txtCanticoInicial.setEnabled(valor);
        txtCanticoIntermediario.setEnabled(valor);
        txtCanticoFinal.setEnabled(valor);
        txtTesourosDiscurso.setEnabled(valor);
        txtDesignacaoUm.setEnabled(valor);
        txtVidaParte1.setEnabled(valor);
        txtVidaParte1Tempo.setEnabled(valor);
        txtVidaParte2.setEnabled(valor);
        txtVidaParte2Tempo.setEnabled(valor);
        optDesignacaoUm.setEnabled(valor);
        optDesignacaoTresEstudo.setEnabled(valor);
        optDesignacaoTresDiscurso.setEnabled(valor);
    }
    
    private void limpaCampos() {
        txtCanticoInicial.setText("");
        txtCanticoIntermediario.setText("");
        txtCanticoFinal.setText("");
        txtTesourosDiscurso.setText("");
        txtDesignacaoUm.setText("");
        txtDesignacaoTres.setText("");
        txtVidaParte1.setText("");
        txtVidaParte1Tempo.setText("");
        txtVidaParte2.setText("");
        txtVidaParte2Tempo.setText("");
    }
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        
        limpaCampos();
        habilitaDesabilitaCampos(true);
        
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnGravar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        setAlteracaoInsercao("I");
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar?", "Atenção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (ret == 0) {
            limpaCampos();
            habilitaDesabilitaCampos(false);
            txtDesignacaoTres.setEnabled(false);
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(false);
            btnGravar.setEnabled(false);
            btnCancelar.setEnabled(false);
            
            carregaSemana();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        habilitaDesabilitaCampos(true);
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnGravar.setEnabled(true);
        btnCancelar.setEnabled(true);
        
        setAlteracaoInsercao("A");
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        ProgramaSemanalView programa = new ProgramaSemanalView();
        programa.setSemana(getSemana());
        programa.setCanticoInicial(Integer.parseInt(txtCanticoInicial.getText()));
        programa.setCanticoIntermediario(Integer.parseInt(txtCanticoIntermediario.getText()));
        programa.setCanticoFinal(Integer.parseInt(txtCanticoFinal.getText()));
        programa.setTesourosDiscursoTema(txtTesourosDiscurso.getText());
        
        if (optDesignacaoUm.isSelected()) {
            programa.setMinisterioUmDiscursoTema(txtDesignacaoUm.getText());
        } else if (optDesignacaoTresDiscurso.isSelected()) {
            programa.setMinisterioTresDiscursoTema(txtDesignacaoTres.getText());
        }
        
        programa.setVidaParte1Tema(txtVidaParte1.getText());
        programa.setVidaParte1Tempo(Integer.parseInt(txtVidaParte1Tempo.getText()));
        
        if (txtVidaParte2.getText() != null && !txtVidaParte2.getText().equals("")) {
            programa.setVidaParte2Tema(txtVidaParte2.getText());
            programa.setVidaParte2Tempo(Integer.parseInt(txtVidaParte2Tempo.getText()));
        }
        
        if (isInsercao()) {
            ProgramaSemanalModel.inserir(programa);
        } else if (isAlteracao()) {
            ProgramaSemanalModel.editar(programa);
        }
        
        habilitaDesabilitaCampos(false);
        txtDesignacaoTres.setEnabled(false);
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnGravar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }//GEN-LAST:event_btnGravarActionPerformed

    private void optDesignacaoUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDesignacaoUmActionPerformed
        txtDesignacaoUm.setText("");
        txtDesignacaoTres.setText("");
        txtDesignacaoUm.setEnabled(true);
        txtDesignacaoTres.setEnabled(false);
    }//GEN-LAST:event_optDesignacaoUmActionPerformed

    private void optDesignacaoTresDiscursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDesignacaoTresDiscursoActionPerformed
        txtDesignacaoUm.setText("");
        txtDesignacaoTres.setText("");
        txtDesignacaoUm.setEnabled(false);
        txtDesignacaoTres.setEnabled(true);
    }//GEN-LAST:event_optDesignacaoTresDiscursoActionPerformed

    private void btnSemanaProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaProximaActionPerformed
        limpaCampos();
        
        Calendar c = Calendar.getInstance();
        c.setTime(getSemana());
        c.add(Calendar.DAY_OF_MONTH, 7);
        
        setSemana(c.getTime());
        
        carregaSemana();
    }//GEN-LAST:event_btnSemanaProximaActionPerformed

    private void txtCanticoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanticoInicialKeyTyped
        String caracteres="0987654321";
        
        if ((!caracteres.contains(evt.getKeyChar()+"")) 
                || (txtCanticoInicial.getText() != null && txtCanticoInicial.getText().length() == 3)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCanticoInicialKeyTyped

    private void txtCanticoIntermediarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanticoIntermediarioKeyTyped
        String caracteres="0987654321";
        
        if ((!caracteres.contains(evt.getKeyChar()+"")) 
                || (txtCanticoIntermediario.getText() != null && txtCanticoIntermediario.getText().length() == 3)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCanticoIntermediarioKeyTyped

    private void txtCanticoFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanticoFinalKeyTyped
        String caracteres="0987654321";
        
        if ((!caracteres.contains(evt.getKeyChar()+"")) 
                || (txtCanticoFinal.getText() != null && txtCanticoFinal.getText().length() == 3)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCanticoFinalKeyTyped

    private void txtVidaParte1TempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVidaParte1TempoKeyTyped
        String caracteres="0987654321";
        
        if ((!caracteres.contains(evt.getKeyChar()+"")) 
                || (txtVidaParte1Tempo.getText() != null && txtVidaParte1Tempo.getText().length() == 2)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVidaParte1TempoKeyTyped

    private void txtVidaParte2TempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVidaParte2TempoKeyTyped
        String caracteres="0987654321";
        
        if ((!caracteres.contains(evt.getKeyChar()+"")) 
                || (txtVidaParte2Tempo.getText() != null && txtVidaParte2Tempo.getText().length() == 2)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVidaParte2TempoKeyTyped

    private void optDesignacaoTresEstudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDesignacaoTresEstudoActionPerformed
        txtDesignacaoUm.setText("");
        txtDesignacaoTres.setText("");
        txtDesignacaoUm.setEnabled(false);
        txtDesignacaoTres.setEnabled(false);
    }//GEN-LAST:event_optDesignacaoTresEstudoActionPerformed

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
            java.util.logging.Logger.getLogger(CadApostila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadApostila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadApostila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadApostila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadApostila().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSemanaAnterior;
    private javax.swing.JButton btnSemanaProxima;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblSemana;
    private javax.swing.JRadioButton optDesignacaoTresDiscurso;
    private javax.swing.JRadioButton optDesignacaoTresEstudo;
    private javax.swing.JRadioButton optDesignacaoUm;
    private javax.swing.JTextField txtCanticoFinal;
    private javax.swing.JTextField txtCanticoInicial;
    private javax.swing.JTextField txtCanticoIntermediario;
    private javax.swing.JTextField txtDesignacaoTres;
    private javax.swing.JTextField txtDesignacaoUm;
    private javax.swing.JTextField txtTesourosDiscurso;
    private javax.swing.JTextField txtVidaParte1;
    private javax.swing.JTextField txtVidaParte1Tempo;
    private javax.swing.JTextField txtVidaParte2;
    private javax.swing.JTextField txtVidaParte2Tempo;
    // End of variables declaration//GEN-END:variables
}
