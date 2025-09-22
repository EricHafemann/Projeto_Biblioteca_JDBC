package org.example.model;

public class Usuario {

    //Atributos de Usuario
    private int id;
    private String nome;
    private String username;
    private String senha;
    private String tipoUsuario;

    // Construtores
    public Usuario(String nome, String username, String senha, String tipoUsuario) {
        setNome(nome);
        setUsername(username);
        setSenha(senha);
        setTipoUsuario(tipoUsuario);
    }

    public Usuario ()
    {

    }

    // Métodos Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
