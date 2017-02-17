package com.jw.model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import com.jw.view.PublicadorView;
import java.awt.HeadlessException;


public class PublicadoresModel {
    
    /**
     * Método que insere um novo publicador
     * 
     * @param publicador - Uma inst�ncia da classe PublicadorView
     */
    public static void inserir(PublicadorView publicador) {
        try {
            
            publicador = trataValoresNulos(publicador);
            
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT MAX(codigo) AS NOVO_CODIGO FROM publicadores";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            long novoCodigoPublicador = 0;
            if (rs != null && rs.next()) {
                novoCodigoPublicador = rs.getLong("NOVO_CODIGO") + 1;
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sql = "INSERT INTO publicadores (codigo, nome, endereco, data_nascimento, data_batismo, "
                + "telefone, email, ungido_outra_ovelha, privilegio, observacoes, sexo, usuario, senha, situacao, participa_escola) VALUES ("
                + novoCodigoPublicador + ", "
                + "'" + publicador.getNome() + "', "
                + "'" + publicador.getEndereco() + "', ";
            
            if (publicador.getDataNascimento() != null) {
                sql += "'" + sdf.format(publicador.getDataNascimento().getTime()) + "', ";
            } else {
                sql += "NULL, ";
            }
            
            if (publicador.getDataBatismo() != null) {
                sql += "'" + sdf.format(publicador.getDataBatismo().getTime()) + "', ";
            } else {
                sql += "NULL, ";
            }
            
            sql += "'" + publicador.getTelefone() + "', "
                + "'" + publicador.getEmail() + "', "
                + "'" + publicador.getUngidoOutraOvelha() + "', "
                + "'" + publicador.getPrivilegio() + "', "
                + "'" + publicador.getObservacoes() + "', "
                + "'" + publicador.getSexo() + "', "
                + "'" + publicador.getUsuario() + "', " 
                + "'" + publicador.getSenha() + "', "
                + "'" + publicador.getSituacao() + "', ";
            
            if (publicador.getParticipaEscola()) {
                sql += "'S')";
            } else {
                sql += "'N')";
            }
            
            int result = stmt.executeUpdate(sql);
            if (result == 1) {
                publicador.setCodigo(novoCodigoPublicador);
                JOptionPane.showMessageDialog(null, "Publicador cadastrado!");
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
     * Método que retorna todos os dados do publicador buscando pelo nome
     * 
     * @param nome - O nome do publicador
     * @return PublicadorView - Uma inst�ncia da classe com todos os dados do publicador
     */
    public static PublicadorView pesquisar(String nome) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT * FROM publicadores WHERE "
                       + "nome = '" + nome + "'";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            PublicadorView fields = null;
            if (rs != null && rs.next()) {
                fields = new PublicadorView();
                fields.setCodigo(rs.getLong("codigo"));
                fields.setNome(rs.getString("nome"));
                fields.setEndereco(rs.getString("endereco"));
                fields.setDataNascimento(rs.getDate("data_nascimento"));
                fields.setTelefone(rs.getString("telefone"));
                fields.setEmail(rs.getString("email"));
                fields.setDataBatismo(rs.getDate("data_batismo"));
                fields.setUngidoOutraOvelha(rs.getString("ungido_outra_ovelha"));
                fields.setPrivilegio(rs.getString("privilegio"));
                fields.setObservacoes(rs.getString("observacoes"));
                fields.setSexo(rs.getString("sexo"));
                fields.setUsuario(rs.getString("usuario"));
                fields.setSenha(rs.getString("senha"));
                fields.setSituacao(rs.getString("situacao"));
                
                if (rs.getString("participa_escola").equals("S")) {
                    fields.setParticipaEscola(true);
                } else {
                    fields.setParticipaEscola(false);
                }
                
                fields = trataValoresNulos(fields);
            }
            
            return fields;
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
     * M�todo que retorna todos os dados do publicador buscando pelo c�digo
     * @param codigo - O c�digo do publicador
     * @return PublicadorView - Uma inst�ncia da classe com todos os dados do publicador
     */
    public static PublicadorView pesquisar(long codigo) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT * FROM publicadores WHERE "
                       + "codigo = " + codigo;
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            PublicadorView fields = null;
            if (rs != null && rs.next()) {
                fields = new PublicadorView();
                fields.setCodigo(rs.getLong("codigo"));
                fields.setNome(rs.getString("nome"));
                fields.setEndereco(rs.getString("endereco"));
                fields.setDataNascimento(rs.getDate("data_nascimento"));
                fields.setTelefone(rs.getString("telefone"));
                fields.setEmail(rs.getString("email"));
                fields.setDataBatismo(rs.getDate("data_batismo"));
                fields.setUngidoOutraOvelha(rs.getString("ungido_outra_ovelha"));
                fields.setPrivilegio(rs.getString("privilegio"));
                fields.setObservacoes(rs.getString("observacoes"));
                fields.setSexo(rs.getString("sexo"));
                fields.setUsuario(rs.getString("usuario"));
                fields.setSenha(rs.getString("senha"));
                fields.setSituacao(rs.getString("situacao"));
                if (rs.getString("participa_escola").equals("S")) {
                    fields.setParticipaEscola(true);
                } else {
                    fields.setParticipaEscola(false);
                }
                
                fields = trataValoresNulos(fields);
            }
            
            return fields;
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
     * Método que retorna o nome do publicador buscando por usuário e senha
     * @param usuario - O usuário do publicador
     * @param senha   - A senha do publicador
     * @return String - O nome do publicador
     */
    public static String pesquisar(String usuario, String senha) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT nome FROM publicadores WHERE "
                       + "usuario = '" + usuario + "' AND "
                       + "senha = '" + senha + "'";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            String nome = "";
            if (rs != null && rs.next()) {
                 nome = rs.getString("nome");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e / ou senha incorretos!");
            }
            
            return nome;
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
     * Método que retorna todos os publicadores existentes
     * @return ArrayList - Lista contendo todos os publicadores existentes
     */
    public static ArrayList<PublicadorView> pesquisarTodos() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT * FROM publicadores ORDER BY nome";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList publicadores = null;
            
            if (rs != null) {
                publicadores = new ArrayList();
                while (rs.next()) {
                    PublicadorView fields = new PublicadorView();
                    fields.setCodigo(rs.getLong("codigo"));
                    fields.setNome(rs.getString("nome"));
                    fields.setEndereco(rs.getString("endereco"));
                    fields.setDataNascimento(rs.getDate("data_nascimento"));
                    fields.setTelefone(rs.getString("telefone"));
                    fields.setEmail(rs.getString("email"));
                    fields.setDataBatismo(rs.getDate("data_batismo"));
                    fields.setUngidoOutraOvelha(rs.getString("ungido_outra_ovelha"));
                    fields.setPrivilegio(rs.getString("privilegio"));
                    fields.setObservacoes(rs.getString("observacoes"));
                    fields.setSexo(rs.getString("sexo"));
                    fields.setUsuario(rs.getString("usuario"));
                    fields.setSenha(rs.getString("senha"));
                    fields.setSituacao(rs.getString("situacao"));
                    if (rs.getString("participa_escola").equals("S")) {
                        fields.setParticipaEscola(true);
                    } else {
                        fields.setParticipaEscola(false);
                    }
                    
                    fields = trataValoresNulos(fields);
                    
                    publicadores.add(fields);
                }
            }
            
            return publicadores;
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
     * Método que retorna todos os anciãos existentes
     * @return ArrayList - Lista contendo todos os anciãos existentes
     */
    public static ArrayList<PublicadorView> pesquisarAnciaos() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT nome FROM publicadores WHERE privilegio = 'ANC' ORDER BY nome";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList publicadores = null;
            
            if (rs != null) {
                publicadores = new ArrayList();
                while (rs.next()) {
                    PublicadorView fields = new PublicadorView();
                    fields.setNome(rs.getString("nome"));                    
                    publicadores.add(fields);
                }
            }
            
            return publicadores;
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
     * Método que retorna todos os anciãos e servos ministeriais existentes
     * @return ArrayList - Lista contendo todos os anciãos e servos ministeriais existentes
     */
    public static ArrayList<PublicadorView> pesquisarAnciaosEServos() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT nome FROM publicadores WHERE privilegio in ('ANC', 'SEM') ORDER BY nome";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList publicadores = null;
            
            if (rs != null) {
                publicadores = new ArrayList();
                while (rs.next()) {
                    PublicadorView fields = new PublicadorView();
                    fields.setNome(rs.getString("nome"));                    
                    publicadores.add(fields);
                }
            }
            
            return publicadores;
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
     * Método que retorna todos os anciãos, servos ministeriais e publicadores batizados existentes
     * @return ArrayList - Lista contendo todos os anciãos, servos ministeriais e publicadores batizados existentes
     */
    public static ArrayList<PublicadorView> pesquisarAnciaosServosEPublicadoresBatizados() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT nome FROM publicadores WHERE privilegio in ('ANC', 'SEM', 'PUB') AND sexo = 'M' ORDER BY nome";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList publicadores = null;
            
            if (rs != null) {
                publicadores = new ArrayList();
                while (rs.next()) {
                    PublicadorView fields = new PublicadorView();
                    fields.setNome(rs.getString("nome"));                    
                    publicadores.add(fields);
                }
            }
            
            return publicadores;
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
     * Método que retorna todos os varões existentes exceto anciãos
     * @return ArrayList - Lista contendo todos os varões existentes exceto anciãos
     */
    public static ArrayList<PublicadorView> pesquisarVaroesExcetoAnciaos() {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            String sql = "SELECT nome FROM publicadores WHERE privilegio in ('SEM', 'PUB', 'PNB') AND sexo = 'M' ORDER BY nome";
        
            Statement stmt;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList publicadores = null;
            
            if (rs != null) {
                publicadores = new ArrayList();
                while (rs.next()) {
                    PublicadorView fields = new PublicadorView();
                    fields.setNome(rs.getString("nome"));                    
                    publicadores.add(fields);
                }
            }
            
            return publicadores;
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
     * M�todo que edita os dados do publicador
     * @param PublicadorView - Uma instância da classe contendo todos os dados do publicador
     */
    public static void editar(PublicadorView fields) {
        try {
            ConexaoBD.openConnection();
            Connection conn = ConexaoBD.getConnection();
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            String sql = "UPDATE publicadores SET "
                       + "nome = '" + fields.getNome() + "', "
                       + "endereco = '" + fields.getEndereco() + "', ";
            if (fields.getDataNascimento() != null) {
                sql += "data_nascimento = '" + sdf.format(fields.getDataNascimento().getTime()) + "', ";
            } else {
                sql += "data_nascimento = NULL, ";
            }
            
            if (fields.getDataBatismo() != null) {
                sql += "data_batismo = '" + sdf.format(fields.getDataBatismo().getTime()) + "', ";
            } else {
                sql += "data_batismo = NULL, ";
            }
            
            sql += "telefone = '" + fields.getTelefone() + "', "
                + "email = '" + fields.getEmail() + "', "
                + "ungido_outra_ovelha = '" + fields.getUngidoOutraOvelha() + "', "
                + "privilegio = '" + fields.getPrivilegio() + "', "
                + "observacoes = '" + fields.getObservacoes() + "', "
                + "sexo = '" + fields.getSexo() + "', "
                + "usuario = '" + fields.getUsuario() + "', "
                + "senha = '" + fields.getSenha() + "', "
                + "situacao = '" + fields.getSituacao() + "', "
                + "participa_escola = '" + (fields.getParticipaEscola() ? "S" : "N") + "' "
                + "WHERE codigo = " + fields.getCodigo();
            
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
    
    public static PublicadorView trataValoresNulos(PublicadorView view) {
        if (view.getEmail() == null) {
            view.setEmail("");
        }
        if (view.getEndereco() == null) {
            view.setEndereco("");
        }
        if (view.getObservacoes() == null) {
            view.setObservacoes("");
        }
        if (view.getPrivilegio() == null) {
            view.setPrivilegio("");
        }
        if (view.getSexo() == null) {
            view.setSexo("");
        }
        if (view.getTelefone() == null) {
            view.setTelefone("");
        }
        if (view.getUngidoOutraOvelha() == null) {
            view.setUngidoOutraOvelha("");
        }
        if (view.getUsuario() == null) {
            view.setUsuario("");
        }
        if (view.getSenha() == null) { 
            view.setSenha("");
        }
        if (view.getSituacao() == null) {
            view.setSituacao("");
        }
        return view;
    }
    
}
