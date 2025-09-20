package org.example.model;

public class Livro {

    // Atributos do Livro
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicado;
    private boolean status;

    // Construtor
    public Livro (String titulo,String autor, int anoPublicado, boolean status)
    {
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicado(anoPublicado);
        setStatus(status);
    }

    // Métodos Setters e Getters
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor)
    {
        this.autor = autor;
    }

    public int getAnoPublicado()
    {
        return anoPublicado;
    }

    public void setAnoPublicado(int anoPublicado)
    {
        this.anoPublicado = anoPublicado;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
}
