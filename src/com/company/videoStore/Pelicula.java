package com.company.videoStore;

public class Pelicula {
    private String genero;
    private String titulo;
    private String fechaDeLanzamiento;
    private int duracion;
    private String clasificacionDeAudiencia;
    private String paisDeOrigen;
    private String descripcion;
    private int stock;
    private int alquilada;

    //Constructores
    public Pelicula(){}

    public Pelicula(String genero, String titulo, String fechaDeLanzamiento, int duracion, String clasificacionDeAudiencia, String paisDeOrigen, String descripcion, int stock) {
        this.genero = genero;
        this.titulo = titulo;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.duracion = duracion;
        this.clasificacionDeAudiencia = clasificacionDeAudiencia;
        this.paisDeOrigen = paisDeOrigen;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    //

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getclasificacionDeAudiencia() {
        return clasificacionDeAudiencia;
    }

    public void setclasificacionDeAudiencia(String clasificacionDeAudiencia) {
        clasificacionDeAudiencia = clasificacionDeAudiencia;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    //
    @Override
    public String toString(){
        return "\nTitulo: "+this.titulo+
                "\nGenero: "+this.genero+
                "\nFecha de lanzamiento: "+this.fechaDeLanzamiento+
                "\nDuracion: "+this.duracion+
                "\nClasificacion de audiencia: "+this.clasificacionDeAudiencia+
                "\nOrigen: "+this.paisDeOrigen+
                "\nDescripcion: "+this.descripcion;
                //"\nStock: "+this.stock;

    }

}
