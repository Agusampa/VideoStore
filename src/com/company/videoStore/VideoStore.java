package com.company.videoStore;

import com.sun.deploy.uitoolkit.impl.awt.AWTPluginEmbeddedFrameWindow;

import java.time.LocalDateTime;
import java.util.*;

import java.lang.Object;

public class VideoStore {
    private List<Pelicula> peliculas;
    private List<Cliente> clientes;
    private List<Boleta> boletas;

    public VideoStore() {
        this.boletas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.peliculas = new ArrayList<>();
    }

    //
    public void todasLasPeliculas(Pelicula pelicula) {
        if(!this.existePelicula(pelicula.getTitulo())) {
            peliculas.add(pelicula);
        }
    }

    public void todosLosClientes(Cliente cliente) {
        if(!this.existeCliente(cliente.getNombre())) {
            clientes.add(cliente);
        }
    }

    public void todasLasBoletas(Boleta boleta) {
        boletas.add(boleta);
    }

    public void devulucionPelicula(Boleta boleta){
        for(Boleta boletaAux : boletas){
            if(boletaAux == boleta){
                boletaAux.cerrarBoleta();
            }
        }
    }

    public boolean existePelicula(String nombrePelicula) {
        for (Pelicula peliculaAux : peliculas) {
            if (peliculaAux.getTitulo().compareTo(nombrePelicula)==0) {
                return true;
            }
        }
        return false;
    }

    public boolean existeCliente(String nombreCliente) {
        for (Cliente clienteAux : clientes) {
            if (clienteAux.getNombre().compareTo(nombreCliente)==0) {
                return true;
            }
        }
        return false;
    }
    public boolean chequeoStockPelicula(String nombrePelicula){
        for (Pelicula peliculaAux : peliculas){
            if(peliculaAux.getTitulo().compareTo(nombrePelicula)==0){
                if(peliculaAux.getStock()>0){
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarPeliculas() {
        for (Pelicula peliculaAux : peliculas) {
            if(peliculaAux != null) {
                System.out.println(peliculaAux.toString());
            }
        }
    }
    public void mostrarBoletas(){
        for(Boleta boletaAux : boletas){
            if(boletaAux != null){
                System.out.println(boletaAux.toString());
            }
        }
    }
    public Pelicula retornarPeliculaPorNombre(String nombrePelicula){
        for(Pelicula peliculaAux : peliculas){
            if(peliculaAux.getTitulo().compareTo(nombrePelicula)==0){
                return peliculaAux;
            }
        }
        System.err.println("No se encontro el cliente");
        Pelicula peliculaErr = new Pelicula();
        return peliculaErr;
    }


    public Cliente retornarClientePorNombre(String nombreCliente){
        for(Cliente clienteAux : clientes){
            if(clienteAux.getNombre().compareTo(nombreCliente)==0){
                return clienteAux;
            }
        }
        System.err.println("No se encontro el cliente");
        Cliente clienteErr = new Cliente();
        return clienteErr;
    }


    public void mostrarAlquileresVigentes() {
        LocalDateTime fechaAux = LocalDateTime.now();

        for (Boleta boletaAux : boletas) {
            if(boletaAux.getEstado() != "Desactiva"){
                if(boletaAux.getFechaDevolucion().getMonthValue()>fechaAux.getMonthValue()) {
                    System.out.println(boletaAux.toString());
                }else{
                    if (boletaAux.getFechaDevolucion().getDayOfMonth() >= fechaAux.getDayOfMonth()) {
                        System.out.println(boletaAux.toString());
                    }
                }
            }
        }
    }
    public Boleta retornarBoletaPorClienteYPelicula(Cliente cliente, Pelicula pelicula){
        for(Boleta boletaAux : boletas){
            if(boletaAux.getCliente() == cliente){
                if(boletaAux.getPelicula() == pelicula){
                    return boletaAux;
                }
            }
        }
        System.err.println("Error, boleta no encontrada");
        Boleta boletaErr = new Boleta(cliente,pelicula);
        return boletaErr;
    }

    ///public void alquileresSegunDia(){}

    public void ultimosDiezAlquileresCliente(Cliente cliente){
        int i = 0;
        if(existeCliente(cliente.getNombre())){
            for(Boleta boletaAux : boletas){
                if(boletaAux.getCliente().equals(cliente) && i <= 10){
                    System.out.println(boletaAux.toString());
                    i++;
                }
            }
        }
    }


    public Pelicula peliculaMasFrecuente(){
        int contador1 = 0;
        int contador2 = 0;
        Pelicula peliculaAux = null;

        for(Pelicula p : this.peliculas){
            contador2 = 0;
            for(Boleta b : this.boletas){
                if(b.getPelicula().equals(p)){
                    contador2++;
                }
            }
            if(contador2>contador1){
                contador1=contador2;
                peliculaAux = p;
            }

        }
        return peliculaAux;
    }

    public void ordenarPorGenero(){

        Collections.sort(peliculas, (x , y) -> x.getGenero().compareToIgnoreCase(y.getGenero()));
        for(Pelicula peliculaAux : peliculas){
            System.out.println(peliculaAux.toString());
        }
    }
/*
    public List ordenarPeliculasPorPopulariad(){
        int contador1 = 0;
        int contador2 = 0;
        Pelicula peliculaAux = null;
        List<Pelicula> peliculasAux = this.peliculas;
        List<Pelicula> peliculasOrenadasPopularidad = new ArrayList<>();
        while (peliculasAux != null){
            System.out.println("golaaa");
            for(Pelicula p : peliculasAux){
                System.out.println("patoo");
                contador2 = 0;
                for(Boleta b : this.boletas){
                    if(b.getPelicula().equals(p)){
                        contador2++;
                    }
                }
                if(contador2>contador1){
                    System.out.println(p.toString());
                    contador1=contador2;
                    peliculaAux =  p;
                    peliculasOrenadasPopularidad.add(peliculaAux);
                }

            }
            peliculasAux.remove(peliculaAux);
        }

        return peliculasOrenadasPopularidad;
    }*/
}







