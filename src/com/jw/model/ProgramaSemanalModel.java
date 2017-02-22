package com.jw.model;

import com.jw.view.ProgramaSemanalView;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Kraemer
 */
public class ProgramaSemanalModel {
    
    /**
     * Método que insere um novo programa semanal
     * 
     * @param programa - Uma instância da classe ProgramaSemanalView
     */
    public static void inserir(ProgramaSemanalView programa) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            Statement stmt = conn.createStatement();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            programa = trataValoresNulos(programa);
            
            String sql = "INSERT INTO programa_semanal (semana, cantico_inicial, cantico_intermediario, cantico_final, "
                       + "tesouros_discurso_tema, ministerio_um_discurso_tema, ministerio_tres_discurso_tema, "
                       + "vida_parte1_tema, vida_parte1_tempo, vida_parte2_tema, vida_parte2_tempo) VALUES ("
                       + "'" + sdf.format(programa.getSemana()) + "', "
                       + programa.getCanticoInicial() + ", "
                       + programa.getCanticoIntermediario() + ", "
                       + programa.getCanticoFinal() + ", "
                       + "'" + programa.getTesourosDiscursoTema() + "', "
                       + "'" + programa.getMinisterioUmDiscursoTema() + "', "
                       + "'" + programa.getMinisterioTresDiscursoTema() + "', "
                       + "'" + programa.getVidaParte1Tema()+ "', "
                       + programa.getVidaParte1Tempo() + ", "
                       + "'" + programa.getVidaParte2Tema() + "', "
                       + programa.getVidaParte2Tempo() + ")";
            
            int result = stmt.executeUpdate(sql);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Cadastro da apostila realizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro!");
            }
        } catch (SQLException | HeadlessException sqle) {
            System.out.println(sqle);
            JOptionPane.showMessageDialog(null, "Erro!");
        } finally {
            try {
                ConexaoBD.closeConnection();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void editar(ProgramaSemanalView programa) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            Statement stmt = conn.createStatement();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            programa = trataValoresNulos(programa);
            
            String sql = "UPDATE programa_semanal SET "
                       + "cantico_inicial = " + programa.getCanticoInicial() + ", "
                       + "cantico_intermediario = " + programa.getCanticoIntermediario() + ", "
                       + "cantico_final = " + programa.getCanticoFinal() + ", "
                       + "tesouros_discurso_tema = '" + programa.getTesourosDiscursoTema() + "', "
                       + "ministerio_um_discurso_tema = '" + programa.getMinisterioUmDiscursoTema() + "', "
                       + "ministerio_tres_discurso_tema = '" + programa.getMinisterioTresDiscursoTema() + "', "
                       + "vida_parte1_tema = '" + programa.getVidaParte1Tema() + "', "
                       + "vida_parte1_tempo = " + programa.getVidaParte1Tempo() + ", "
                       + "vida_parte2_tema = '" + programa.getVidaParte2Tema() + "', "
                       + "vida_parte2_tempo = " + programa.getVidaParte2Tempo() + " "
                       + "WHERE semana = '" + sdf.format(programa.getSemana()) + "';";
            
            int result = stmt.executeUpdate(sql);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro!");
            }
        } catch (SQLException | HeadlessException sqle) {
            System.out.println(sqle);
            JOptionPane.showMessageDialog(null, "Erro!");
        } finally {
            try {
                ConexaoBD.closeConnection();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    
    /**
     * Método que retorna todos os dados da semana
     * @param semana - A semana a ser pesquisada
     * @return PublicadorView - Uma inst�ncia da classe com todos os dados do publicador
     */
    public static ProgramaSemanalView pesquisar(Date semana) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String sql = "SELECT * FROM programa_semanal WHERE "
                       + "semana = '" + sdf.format(semana)+ "'";
        
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ProgramaSemanalView semanaView = null;
            if (rs != null && rs.next()) {
                semanaView = new ProgramaSemanalView();
                semanaView.setSemana(rs.getDate("semana"));
                semanaView.setCanticoInicial(rs.getInt("cantico_inicial"));
                semanaView.setCanticoIntermediario(rs.getInt("cantico_intermediario"));
                semanaView.setCanticoFinal(rs.getInt("cantico_final"));
                semanaView.setPresidente(rs.getInt("presidente"));
                semanaView.setOracaoInicial(rs.getInt("oracao_inicial"));
                semanaView.setOracaoFinal(rs.getInt("oracao_final"));
                semanaView.setTesourosDiscursoTema(rs.getString("tesouros_discurso_tema"));
                semanaView.setTesourosDiscursoOrador(rs.getInt("tesouros_discurso_orador"));
                semanaView.setTesourosJoiasOrador(rs.getInt("tesouros_joias_orador"));
                semanaView.setTesourosLeituraOrador(rs.getInt("tesouros_leitura_orador"));
                semanaView.setTesourosLeituraLicao(rs.getInt("tesouros_leitura_licao"));
                semanaView.setMinisterioUmDiscursoTema(rs.getString("ministerio_um_discurso_tema"));
                semanaView.setMinisterioUmDiscursoOrador(rs.getInt("ministerio_um_discurso_orador"));
                semanaView.setMinisterioTresVisitaOrador(rs.getInt("ministerio_tres_visita_orador"));
                semanaView.setMinisterioTresVisitaAux(rs.getInt("ministerio_tres_visita_aux"));
                semanaView.setMinisterioTresVisitaLicao(rs.getInt("ministerio_tres_visita_licao"));
                semanaView.setMinisterioTresRevisitaOrador(rs.getInt("ministerio_tres_revisita_orador"));
                semanaView.setMinisterioTresRevisitaAux(rs.getInt("ministerio_tres_revisita_aux"));
                semanaView.setMinisterioTresRevisitaLicao(rs.getInt("ministerio_tres_revisita_licao"));
                semanaView.setMinisterioTresEstudoOrador(rs.getInt("ministerio_tres_estudo_orador"));
                semanaView.setMinisterioTresEstudoAux(rs.getInt("ministerio_tres_estudo_aux"));
                semanaView.setMinisterioTresEstudoLicao(rs.getInt("ministerio_tres_estudo_licao"));
                semanaView.setMinisterioTresDiscursoOrador(rs.getInt("ministerio_tres_discurso_orador"));
                semanaView.setMinisterioTresDiscursoTema(rs.getString("ministerio_tres_discurso_tema"));
                semanaView.setMinisterioTresDiscursoLicao(rs.getInt("ministerio_tres_discurso_licao"));
                semanaView.setVidaParte1Tema(rs.getString("vida_parte1_tema"));
                semanaView.setVidaParte1Orador(rs.getInt("vida_parte1_orador"));
                semanaView.setVidaParte1Tempo(rs.getInt("vida_parte1_tempo"));
                semanaView.setVidaParte2Tema(rs.getString("vida_parte2_tema"));
                semanaView.setVidaParte2Orador(rs.getInt("vida_parte2_orador"));
                semanaView.setVidaParte2Tempo(rs.getInt("vida_parte2_tempo"));
                semanaView.setEstudoDirigente(rs.getInt("estudo_dirigente"));
                semanaView.setEstudoLeitor(rs.getInt("estudo_leitor"));
                
                semanaView = trataValoresNulos(semanaView);
            }
            
            return semanaView;
        } catch (SQLException sqle) {
            System.out.println(sqle);
            JOptionPane.showMessageDialog(null, "Erro!");
            return null;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro!");
            return null;
        } finally {
            try {
                ConexaoBD.closeConnection();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static ProgramaSemanalView trataValoresNulos(ProgramaSemanalView view) {
        if (view.getMinisterioUmDiscursoTema() == null) {
            view.setMinisterioUmDiscursoTema("");
        }
        
        if (view.getTesourosDiscursoTema() == null) {
            view.setTesourosDiscursoTema("");
        }
        
        if (view.getVidaParte1Tema() == null) {
            view.setVidaParte1Tema("");
        }
        
        if (view.getVidaParte2Tema() == null) {
            view.setVidaParte2Tema("");
        }
        
        if (view.getMinisterioTresDiscursoTema() == null) {
            view.setMinisterioTresDiscursoTema("");
        }
        return view;
    }
}
