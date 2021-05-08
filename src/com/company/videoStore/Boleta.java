package com.company.videoStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.util.UUID;

public class Boleta {
    private LocalDateTime fechaRetiro;
    private LocalDateTime fechaDevolucion;
    private Cliente cliente;
    private Pelicula pelicula;
    private String estado;

    //
    public Boleta(Cliente cliente, Pelicula pelicula) {
        this.fechaRetiro = LocalDateTime.now();
        this.fechaDevolucion = LocalDateTime.now().plusDays(3);
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.estado = "Activo";
    }

    public LocalDateTime getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDateTime fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void cerrarBoleta(){
        this.estado = "Desactiva";
    }
    //
    @Override
    public String toString(){
        return "\nBoleta \nNombre: "+this.cliente.getNombre()+
                "\nPelicula: "+this.pelicula.getTitulo()+
                "\nFecha de retiro: "+this.fechaRetiro+
                "\nFecha de devolucion: "+this.fechaDevolucion+
                "\nEstado: "+this.estado;
    }


}
