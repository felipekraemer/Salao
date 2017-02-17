package com.jw.view;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class PublicadorView {
   
    private long codigo;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private Date dataBatismo;
    private String ungidoOutraOvelha;
    private String privilegio;
    private String observacoes;
    private String sexo;
    private String usuario;
    private String senha;
    private String situacao;
    private boolean participaEscola;

    /*
     * M�todo que retorna o c�digo do publicador
     */
    public long getCodigo() {
        return codigo;
    }

    /*
     * M�todo que insere um c�digo para o publicador
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /*
     * M�todo que retorna o nome do publicador
     */
    public String getNome() {
        return nome;
    }

    /*
     * M�todo que insere um nome para o publicador
     */
    public void setNome(String name) {
        this.nome = name;
    }

    /*
     * M�todo que retorna o endere�o do publicador
     */
    public String getEndereco() {
        return endereco;
    }

    /*
     * M�todo que insere um endere�o para o publicador
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /*
     * M�todo que retorna a data de nascimento do publicador
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /*
     * M�todo que insere uma data de nascimento para o publicador
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /*
     * M�todo que retorna o telefone do publicador
     */
    public String getTelefone() {
        return telefone;
    }

    /*
     * M�todo que insere um telefone para o publicador
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /*
     * M�todo que retorna o e-mail do publicador
     */
    public String getEmail() {
        return email;
    }

    /*
     * M�todo que insere um e-mail para o publicador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * M�todo que retorna a data de batismo do publicador
     */
    public Date getDataBatismo() {
        return dataBatismo;
    }

    /*
     * M�todo que insere uma data de batismo para o publicador
     */
    public void setDataBatismo(Date dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    /*
     * M�todo que retorna se o publicador � Ungido ou Outra Ovelha
     */
    public String getUngidoOutraOvelha() {
        return ungidoOutraOvelha;
    }

    /*
     * M�todo que insere um aprisco para o publicador
     */
    public void setUngidoOutraOvelha(String ungidoOutraOvelha) {
        this.ungidoOutraOvelha = ungidoOutraOvelha;
    }

    /*
     * M�todo que retorna o privil�gio do publicador
     */
    public String getPrivilegio() {
        return privilegio;
    }

    /*
     * M�todo que insere um privil�gio para o publicador
     */
    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    /*
     * M�todo que retorna observa��es sobre o publicador
     */
    public String getObservacoes() {
        return observacoes;
    }

    /*
     * M�todo que insere observa��es sobre o publicador
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /*
     * M�todo que retorna o sexo do publicador
     */
    public String getSexo() {
        return sexo;
    }

    /*
     * M�todo que insere o sexo do publicador
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public void setParticipaEscola(boolean participaEscola) {
        this.participaEscola = participaEscola;
    }
    
    public boolean getParticipaEscola() {
        return this.participaEscola;
    }
    
    
}