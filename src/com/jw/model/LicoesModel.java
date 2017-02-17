package com.jw.model;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.jw.view.LicaoView;
import java.awt.HeadlessException;

/**
 *
 * @author Felipe
 */
public class LicoesModel {
    
    /**
     * Método que retorna todas as lições existentes
     * @return ArrayList - Lista contendo todas as lições existentes
     */
    public static ArrayList<LicaoView> pesquisarTodas() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT * FROM licoes ORDER BY numero";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList licoes = null;
            
            if (rs != null) {
                licoes = new ArrayList();
                while (rs.next()) {
                    LicaoView view = new LicaoView();
                    
                    view.setNumero(rs.getInt("numero"));
                    view.setDescricao(rs.getString("descricao"));
                    
                    licoes.add(view);
                }
            }
            
            
            return licoes;
            
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
    
    /**
     * Método que retorna todos os dados da lição buscando pelo número
     * 
     * @param numero - O número da lição
     * @return LicaoView - Uma instância da classe com todos os dados da lição
     */
    public static LicaoView pesquisar(int numero) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT * FROM licoes WHERE numero = " + numero;
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            LicaoView view = null;
            
            if (rs != null && rs.next()) {
                view = new LicaoView();
                
                view.setNumero(rs.getInt("numero"));
                view.setDescricao(rs.getString("descricao"));
            }
            
            return view;
            
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
    
    /**
     * Método que insere uma nova lição
     * 
     * @param view - Uma instância da classe LicaoView
     */
    public static void inserir(LicaoView view) {
        try {
            
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT MAX(numero) AS NOVO_NUMERO FROM licoes";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            int novoNumero = 0;
            if (rs != null && rs.next()) {
                novoNumero = rs.getInt("NOVO_NUMERO") + 1;
            }
            
            sql = "INSERT INTO licoes (numero, descricao) VALUES (" + novoNumero + ", '" + view.getDescricao() + "')";
            
            int result = stmt.executeUpdate(sql);
            if (result == 1) {
                view.setNumero(novoNumero);
                JOptionPane.showMessageDialog(null, "Lição cadastrada!");
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
     * Método que edita os dados da lição
     * @param licaoView - Uma instância da classe contendo todos os dados da lição
     */
    public static void alterar(LicaoView view) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "UPDATE licoes SET "
                       + "descricao = '" + view.getDescricao() + "' "
                       + "WHERE numero = " + view.getNumero();
            
            Statement stmt;
            stmt = conn.createStatement();
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
}
