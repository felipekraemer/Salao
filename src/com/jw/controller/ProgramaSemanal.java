/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jw.controller;

import com.jw.model.LicoesModel;
import com.jw.model.ProgramaSemanalModel;
import com.jw.model.PublicadoresModel;
import com.jw.view.LicaoView;
import com.jw.view.ProgramaSemanalView;
import com.jw.view.PublicadorView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Kraemer
 */
public class ProgramaSemanal extends javax.swing.JFrame {

    /**
     * Creates new form ProgramaSemanal
     */
    public ProgramaSemanal() {
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
    
    private void limpaCampos() {
        cboPresidente.removeAllItems();
        cboOracaoInicial.removeAllItems();
        txtCanticoInicial.setText("");
        txtCanticoIntermediario.setText("");
        txtCanticoFinal.setText("");
        txtComentariosIniciais.setText("");
        txtTesourosDiscursoTema.setText("");
        cboTesourosDiscursoOrador.removeAllItems();
        cboTesourosJoiasOrador.removeAllItems();
        cboTesourosLeituraOrador.removeAllItems();
        cboTesourosLeituraLicao.removeAllItems();
        txtRecapitulacao.setText("");
        cboOracaoFinal.removeAllItems();
        cboMinisterioTresVisitaOrador.removeAllItems();
        cboMinisterioTresVisitaAux.removeAllItems();
        cboMinisterioTresVisitaLicao.removeAllItems();
        cboMinisterioTresRevisitaOrador.removeAllItems();
        cboMinisterioTresRevisitaAux.removeAllItems();
        cboMinisterioTresRevisitaLicao.removeAllItems();
        cboMinisterioTresEstudoOrador.removeAllItems();
        cboMinisterioTresEstudoAux.removeAllItems();
        cboMinisterioTresEstudoLicao.removeAllItems();
        txtMinisterioTresDiscursoTema.setText("");
        cboMinisterioTresDiscursoOrador.removeAllItems();
        cboMinisterioTresDiscursoLicao.removeAllItems();
        cboMinisterioUmDiscursoOrador.removeAllItems();
        txtMinisterioUmDiscursoTema.setText("");
        lblVidaParte1Tempo.setText("? min:");
        lblVidaParte2Tempo.setText("? min:");
        txtVidaParte1Tema.setText("");
        txtVidaParte2Tema.setText("");
        cboVidaParte1Orador.removeAllItems();
        cboVidaParte2Orador.removeAllItems();
        cboVidaEstudoDirigente.removeAllItems();
        cboVidaEstudoLeitor.removeAllItems();
    }
    private Date semana = new Date();
    
    private Date getSemana() {
        return semana;
    }
    
    private void setSemana(Date semana) {
        this.semana = semana;
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
                carregaLicoes();
                carregaPublicadores();
                
                cboPresidente.setSelectedItem(semanaView.getPresidente());
                txtCanticoInicial.setText(semanaView.getCanticoInicial() + "");
                cboOracaoInicial.setSelectedItem(semanaView.getOracaoInicial());
                
                System.out.println(semanaView.getPresidente());
                if (semanaView.getPresidente() == 0) {
                    txtComentariosIniciais.setText("");
                    txtRecapitulacao.setText("");
                }
                
                txtCanticoIntermediario.setText(semanaView.getCanticoIntermediario() + "");
                txtCanticoFinal.setText(semanaView.getCanticoFinal() + "");
                
                //ABA TESOUROS DA PALAVRA DE DEUS
                txtTesourosDiscursoTema.setText(semanaView.getTesourosDiscursoTema());
                cboTesourosDiscursoOrador.setSelectedItem(semanaView.getTesourosDiscursoOrador());
                cboTesourosJoiasOrador.setSelectedItem(semanaView.getTesourosJoiasOrador());
                cboTesourosLeituraOrador.setSelectedItem(semanaView.getTesourosLeituraOrador());
                cboTesourosLeituraLicao.setSelectedItem(semanaView.getTesourosLeituraLicao());
                
                //ABA FAÇA SEU MELHOR NO MINISTÉRIO
                
                if (!semanaView.getMinisterioUmDiscursoTema().equals("")) {
                    //SE FOR DESIGNAÇÃO ÚNICA, DE 15 MINUTOS
                    txtMinisterioUmDiscursoTema.setText(semanaView.getMinisterioUmDiscursoTema());
                    cboMinisterioUmDiscursoOrador.setSelectedItem(semanaView.getMinisterioUmDiscursoOrador());
                    
                } else {
                    //SEMPRE TEM VISITA E REVISITA
                    cboMinisterioTresVisitaOrador.setSelectedItem(semanaView.getMinisterioTresVisitaOrador());
                    cboMinisterioTresVisitaAux.setSelectedItem(semanaView.getMinisterioTresVisitaAux());
                    cboMinisterioTresVisitaLicao.setSelectedItem(semanaView.getMinisterioTresVisitaLicao());
                    cboMinisterioTresRevisitaOrador.setSelectedItem(semanaView.getMinisterioTresRevisitaOrador());
                    cboMinisterioTresRevisitaAux.setSelectedItem(semanaView.getMinisterioTresRevisitaAux());
                    cboMinisterioTresRevisitaLicao.setSelectedItem(semanaView.getMinisterioTresRevisitaLicao());
                    
                    //A TERCEIRA PARTE PODE SER ESTUDO BÍBLICO OU DISCURSO
                    if (!semanaView.getMinisterioTresDiscursoTema().equals("")) {
                        cboMinisterioTresDiscursoOrador.setSelectedItem(semanaView.getMinisterioTresDiscursoOrador());
                        txtMinisterioTresDiscursoTema.setText(semanaView.getMinisterioTresDiscursoTema());
                        cboMinisterioTresDiscursoLicao.setSelectedItem(semanaView.getMinisterioTresDiscursoLicao());
                        
                    } else {
                        cboMinisterioTresEstudoOrador.setSelectedItem(semanaView.getMinisterioTresEstudoOrador());
                        cboMinisterioTresEstudoAux.setSelectedItem(semanaView.getMinisterioTresEstudoAux());
                        cboMinisterioTresEstudoLicao.setSelectedItem(semanaView.getMinisterioTresEstudoLicao());
                    }
                }
                
                
                
                //ABA NOSSA VIDA CRISTÃ
                txtVidaParte1Tema.setText(semanaView.getVidaParte1Tema());
                lblVidaParte1Tempo.setText(formataNumero(semanaView.getVidaParte1Tempo()) + " min:");
                //A PARTE 2 É OPCIONAL
                if (!semanaView.getVidaParte2Tema().equals("")) {
                    txtVidaParte2Tema.setText(semanaView.getVidaParte2Tema());
                    lblVidaParte2Tempo.setText(formataNumero(semanaView.getVidaParte2Tempo()) + " min:");
                }
                btnAlterar.setEnabled(true);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Não foram encontrados dados para a semana de " + intervalo + ".");
                btnAlterar.setEnabled(false);
                limpaCampos();
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Um erro ocorreu ao executar esta operação.");
        }
        
    }
    
    private void carregaLicoes() {
        cboMinisterioTresEstudoLicao.addItem("Selecione...");
        cboMinisterioTresRevisitaLicao.addItem("Selecione...");
        cboMinisterioTresVisitaLicao.addItem("Selecione...");
        cboMinisterioTresDiscursoLicao.addItem("Selecione...");
        cboTesourosLeituraLicao.addItem("Selecione...");
        ArrayList<LicaoView> licoes = LicoesModel.pesquisarTodas();
        if (licoes != null && !licoes.isEmpty()) {
            Iterator it = licoes.iterator();
            while (it.hasNext()) {
                LicaoView view = (LicaoView) it.next();
                cboMinisterioTresEstudoLicao.addItem(formataNumero(view.getNumero()) + " - " + view.getDescricao());
                cboMinisterioTresRevisitaLicao.addItem(formataNumero(view.getNumero()) + " - " + view.getDescricao());
                cboMinisterioTresVisitaLicao.addItem(formataNumero(view.getNumero()) + " - " + view.getDescricao());
                cboMinisterioTresDiscursoLicao.addItem(formataNumero(view.getNumero()) + " - " + view.getDescricao());
                cboTesourosLeituraLicao.addItem(formataNumero(view.getNumero()) + " - " + view.getDescricao());
            }
        }
    }
    
    private void carregaPublicadores() {
        cboPresidente.addItem("Selecione ancião...");
        cboOracaoInicial.addItem("Selecione ancião, servo ministerial, ou publicador batizado...");
        cboOracaoFinal.addItem("Selecione ancião, servo ministerial, ou publicador batizado...");
        cboTesourosDiscursoOrador.addItem("Selecione ancião ou servo ministerial...");
        cboTesourosJoiasOrador.addItem("Selecione ancião ou servo ministerial...");
        cboTesourosLeituraOrador.addItem("Selecione servo ministerial, publicador batizado ou não batizado...");
        
        ArrayList<PublicadorView> publicadores = PublicadoresModel.pesquisarAnciaos();
        if (publicadores != null && !publicadores.isEmpty()) {
            Iterator it = publicadores.iterator();
            while (it.hasNext()) {
                PublicadorView view = (PublicadorView) it.next();
                cboPresidente.addItem(view.getNome());
            }
        }
        
        publicadores = PublicadoresModel.pesquisarAnciaosEServos();
        if (publicadores != null && !publicadores.isEmpty()) {
            Iterator it = publicadores.iterator();
            while (it.hasNext()) {
                PublicadorView view = (PublicadorView) it.next();
                cboTesourosDiscursoOrador.addItem(view.getNome());
                cboTesourosJoiasOrador.addItem(view.getNome());
            }
        }
        
        publicadores = PublicadoresModel.pesquisarAnciaosServosEPublicadoresBatizados();
        if (publicadores != null && !publicadores.isEmpty()) {
            Iterator it = publicadores.iterator();
            while (it.hasNext()) {
                PublicadorView view = (PublicadorView) it.next();
                cboOracaoInicial.addItem(view.getNome());
                cboOracaoFinal.addItem(view.getNome());
            }
        }
        
        publicadores = PublicadoresModel.pesquisarVaroesExcetoAnciaos();
        
        if (publicadores != null && !publicadores.isEmpty()) {
            Iterator it = publicadores.iterator();
            while (it.hasNext()) {
                PublicadorView view = (PublicadorView) it.next();
                cboTesourosLeituraOrador.addItem(view.getNome());
            }
        }
        
        
    }
    
    private String formataNumero(int numero) {
        if (numero <= 9) {
            return "0" + numero;
        } else {
            return "" + numero;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboPresidente = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboOracaoInicial = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSemanaAnterior = new javax.swing.JButton();
        btnSemanaProxima = new javax.swing.JButton();
        lblSemana = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cboTesourosDiscursoOrador = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboTesourosJoiasOrador = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cboTesourosLeituraOrador = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboTesourosLeituraLicao = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        txtTesourosDiscursoTema = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cboMinisterioTresVisitaAux = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cboMinisterioTresVisitaOrador = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cboMinisterioTresRevisitaOrador = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        cboMinisterioTresRevisitaAux = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cboMinisterioTresEstudoAux = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        cboMinisterioTresEstudoOrador = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cboMinisterioTresVisitaLicao = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        cboMinisterioTresRevisitaLicao = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        cboMinisterioTresEstudoLicao = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        cboMinisterioUmDiscursoOrador = new javax.swing.JComboBox();
        txtMinisterioUmDiscursoTema = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cboMinisterioTresDiscursoOrador = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        txtMinisterioTresDiscursoTema = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cboMinisterioTresDiscursoLicao = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblVidaParte1Tempo = new javax.swing.JLabel();
        cboVidaParte1Orador = new javax.swing.JComboBox();
        cboVidaParte2Orador = new javax.swing.JComboBox();
        lblVidaParte2Tempo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        cboVidaEstudoLeitor = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cboVidaEstudoDirigente = new javax.swing.JComboBox();
        txtVidaParte1Tema = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtVidaParte2Tema = new javax.swing.JTextField();
        txtCanticoIntermediario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboOracaoFinal = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        txtCanticoFinal = new javax.swing.JTextField();
        txtCanticoInicial = new javax.swing.JTextField();
        txtComentariosIniciais = new javax.swing.JTextField();
        txtRecapitulacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programa Semanal");
        setResizable(false);

        jLabel1.setText("Presidente:");

        cboPresidente.setEnabled(false);
        cboPresidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPresidenteActionPerformed(evt);
            }
        });

        jLabel2.setText("Oração Inicial:");

        cboOracaoInicial.setEnabled(false);

        jLabel3.setText("03 min: Comentários Iniciais:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Escolha a Semana"));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSemanaAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSemana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSemanaProxima)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSemanaAnterior)
                    .addComponent(btnSemanaProxima)
                    .addComponent(lblSemana))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jLabel4.setText("10 min:");

        cboTesourosDiscursoOrador.setEnabled(false);

        jLabel6.setText("08 min:");

        cboTesourosJoiasOrador.setEnabled(false);

        jLabel7.setText("04 min:");

        cboTesourosLeituraOrador.setEnabled(false);

        jLabel5.setText("Encontre Joias Espirituais");

        jLabel8.setText("Leitura da Bíblia");

        cboTesourosLeituraLicao.setEnabled(false);

        jLabel32.setText("Lição:");

        txtTesourosDiscursoTema.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTesourosDiscursoTema, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTesourosDiscursoOrador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTesourosJoiasOrador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboTesourosLeituraOrador, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTesourosLeituraLicao, 0, 398, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboTesourosDiscursoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTesourosDiscursoTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTesourosJoiasOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboTesourosLeituraOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboTesourosLeituraLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tesouros da Palavra de Deus", jPanel1);

        jLabel17.setText("02 min:");

        jLabel18.setText("Primeira Visita");

        cboMinisterioTresVisitaAux.setEnabled(false);

        jLabel19.setText("Auxiliar:");

        jLabel20.setText("Designado(a):");

        cboMinisterioTresVisitaOrador.setEnabled(false);

        jLabel21.setText("04 min:");

        jLabel22.setText("Segunda Visita");

        jLabel23.setText("Designado(a):");

        cboMinisterioTresRevisitaOrador.setEnabled(false);

        jLabel24.setText("Auxiliar:");

        cboMinisterioTresRevisitaAux.setEnabled(false);

        jLabel25.setText("06 min:");

        cboMinisterioTresEstudoAux.setEnabled(false);

        jLabel27.setText("Auxiliar:");

        cboMinisterioTresEstudoOrador.setEnabled(false);

        jLabel28.setText("Designado(a):");

        jLabel29.setText("Lição:");

        cboMinisterioTresVisitaLicao.setEnabled(false);

        jLabel30.setText("Lição:");

        cboMinisterioTresRevisitaLicao.setEnabled(false);

        jLabel31.setText("Lição:");

        cboMinisterioTresEstudoLicao.setEnabled(false);

        jLabel26.setText("15 min:");

        cboMinisterioUmDiscursoOrador.setEnabled(false);

        txtMinisterioUmDiscursoTema.setEditable(false);

        jLabel16.setText("Designado:");

        jLabel33.setText("Estudo Bíblico");

        jLabel34.setText("Discurso");

        jLabel35.setText("Designado:");

        cboMinisterioTresDiscursoOrador.setEnabled(false);

        jLabel36.setText("Tema:");

        txtMinisterioTresDiscursoTema.setEditable(false);

        jLabel37.setText("Lição:");

        cboMinisterioTresDiscursoLicao.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cboMinisterioTresDiscursoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinisterioTresDiscursoTema))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cboMinisterioTresEstudoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboMinisterioTresEstudoAux, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cboMinisterioTresRevisitaOrador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboMinisterioTresRevisitaAux, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMinisterioTresVisitaOrador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMinisterioTresVisitaAux, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboMinisterioTresVisitaLicao, 0, 373, Short.MAX_VALUE)
                            .addComponent(cboMinisterioTresRevisitaLicao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMinisterioTresEstudoLicao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMinisterioTresDiscursoLicao, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinisterioUmDiscursoTema, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMinisterioUmDiscursoOrador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMinisterioTresVisitaAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(cboMinisterioTresVisitaOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(cboMinisterioTresVisitaLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMinisterioTresRevisitaAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(cboMinisterioTresRevisitaOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(jLabel33))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboMinisterioTresEstudoAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)
                                .addComponent(cboMinisterioTresEstudoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboMinisterioTresDiscursoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel35)
                                .addComponent(jLabel36)
                                .addComponent(txtMinisterioTresDiscursoTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel37))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboMinisterioTresRevisitaLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMinisterioTresEstudoLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMinisterioTresDiscursoLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMinisterioUmDiscursoOrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtMinisterioUmDiscursoTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel18.getAccessibleContext().setAccessibleName("88");
        jLabel22.getAccessibleContext().setAccessibleName("88");
        jLabel33.getAccessibleContext().setAccessibleName("88");
        jLabel34.getAccessibleContext().setAccessibleName("88");

        jTabbedPane1.addTab("Faça seu Melhor no Ministério", jPanel2);

        jLabel15.setText("Cântico Intermediário:");

        lblVidaParte1Tempo.setText("? min:");

        cboVidaParte1Orador.setEnabled(false);

        cboVidaParte2Orador.setEnabled(false);

        lblVidaParte2Tempo.setText("? min:");

        jLabel38.setText("30 min:");

        jLabel39.setText("Estudo Bíblico de Congregação");

        cboVidaEstudoLeitor.setEnabled(false);

        jLabel40.setText("Designado:");

        jLabel41.setText("Leitor:");

        cboVidaEstudoDirigente.setEnabled(false);

        txtVidaParte1Tema.setEditable(false);

        jLabel43.setText("Designado:");

        jLabel13.setText("Designado:");

        txtVidaParte2Tema.setEditable(false);

        txtCanticoIntermediario.setEditable(false);
        txtCanticoIntermediario.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCanticoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblVidaParte1Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVidaParte1Tema, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lblVidaParte2Tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVidaParte2Tema, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboVidaEstudoDirigente, 0, 354, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboVidaEstudoLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboVidaParte2Orador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboVidaParte1Orador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCanticoIntermediario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVidaParte1Tempo)
                    .addComponent(cboVidaParte1Orador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVidaParte1Tema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVidaParte2Tempo)
                    .addComponent(cboVidaParte2Orador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtVidaParte2Tema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(cboVidaEstudoLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(cboVidaEstudoDirigente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nossa Vida Cristã", jPanel4);

        jLabel9.setText("03 min: Recapitulação da reunião e visão geral da próxima semana:");

        jLabel10.setText("Oração Final:");

        cboOracaoFinal.setEnabled(false);

        jLabel12.setText("Cântico Inicial:");

        jLabel14.setText("Cântico Final:");

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);

        btnNovo.setText("Novo");

        txtCanticoFinal.setEditable(false);
        txtCanticoFinal.setEnabled(false);

        txtCanticoInicial.setEditable(false);
        txtCanticoInicial.setEnabled(false);

        txtComentariosIniciais.setEditable(false);

        txtRecapitulacao.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPresidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCanticoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboOracaoInicial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtComentariosIniciais)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboOracaoFinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCanticoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRecapitulacao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCanticoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboOracaoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtComentariosIniciais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRecapitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCanticoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboOracaoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSemanaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaAnteriorActionPerformed
        limpaCampos();

        Calendar c = Calendar.getInstance();
        c.setTime(getSemana());
        c.add(Calendar.DAY_OF_MONTH, -7);

        setSemana(c.getTime());

        carregaSemana();
    }//GEN-LAST:event_btnSemanaAnteriorActionPerformed

    private void btnSemanaProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanaProximaActionPerformed
        limpaCampos();

        Calendar c = Calendar.getInstance();
        c.setTime(getSemana());
        c.add(Calendar.DAY_OF_MONTH, 7);

        setSemana(c.getTime());

        carregaSemana();
    }//GEN-LAST:event_btnSemanaProximaActionPerformed

    private void cboPresidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPresidenteActionPerformed
        if (cboPresidente.getItemCount() == 0 || cboPresidente.getSelectedItem().toString().equals("Selecione ancião...")) {
            txtComentariosIniciais.setText("");
            txtRecapitulacao.setText("");
        } else {
            txtComentariosIniciais.setText(cboPresidente.getSelectedItem().toString());
            txtRecapitulacao.setText(cboPresidente.getSelectedItem().toString());
        }
        
    }//GEN-LAST:event_cboPresidenteActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramaSemanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramaSemanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramaSemanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramaSemanal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramaSemanal().setVisible(true);
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
    private javax.swing.JComboBox cboMinisterioTresDiscursoLicao;
    private javax.swing.JComboBox cboMinisterioTresDiscursoOrador;
    private javax.swing.JComboBox cboMinisterioTresEstudoAux;
    private javax.swing.JComboBox cboMinisterioTresEstudoLicao;
    private javax.swing.JComboBox cboMinisterioTresEstudoOrador;
    private javax.swing.JComboBox cboMinisterioTresRevisitaAux;
    private javax.swing.JComboBox cboMinisterioTresRevisitaLicao;
    private javax.swing.JComboBox cboMinisterioTresRevisitaOrador;
    private javax.swing.JComboBox cboMinisterioTresVisitaAux;
    private javax.swing.JComboBox cboMinisterioTresVisitaLicao;
    private javax.swing.JComboBox cboMinisterioTresVisitaOrador;
    private javax.swing.JComboBox cboMinisterioUmDiscursoOrador;
    private javax.swing.JComboBox cboOracaoFinal;
    private javax.swing.JComboBox cboOracaoInicial;
    private javax.swing.JComboBox cboPresidente;
    private javax.swing.JComboBox cboTesourosDiscursoOrador;
    private javax.swing.JComboBox cboTesourosJoiasOrador;
    private javax.swing.JComboBox cboTesourosLeituraLicao;
    private javax.swing.JComboBox cboTesourosLeituraOrador;
    private javax.swing.JComboBox cboVidaEstudoDirigente;
    private javax.swing.JComboBox cboVidaEstudoLeitor;
    private javax.swing.JComboBox cboVidaParte1Orador;
    private javax.swing.JComboBox cboVidaParte2Orador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblSemana;
    private javax.swing.JLabel lblVidaParte1Tempo;
    private javax.swing.JLabel lblVidaParte2Tempo;
    private javax.swing.JTextField txtCanticoFinal;
    private javax.swing.JTextField txtCanticoInicial;
    private javax.swing.JTextField txtCanticoIntermediario;
    private javax.swing.JTextField txtComentariosIniciais;
    private javax.swing.JTextField txtMinisterioTresDiscursoTema;
    private javax.swing.JTextField txtMinisterioUmDiscursoTema;
    private javax.swing.JTextField txtRecapitulacao;
    private javax.swing.JTextField txtTesourosDiscursoTema;
    private javax.swing.JTextField txtVidaParte1Tema;
    private javax.swing.JTextField txtVidaParte2Tema;
    // End of variables declaration//GEN-END:variables
}
