package com.company;

import com.company.videoStore.Boleta;
import com.company.videoStore.Cliente;
import com.company.videoStore.Pelicula;
import com.company.videoStore.VideoStore;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //LocalDateTime fecha = LocalDateTime.now().plusDays(7);
        //System.out.println(fecha);
        VideoStore videoStore = new VideoStore();

        Cliente cliente1 = new Cliente("Juan Perez", 156998520, "Luro 2214");
        Cliente cliente2 = new Cliente("Andrea Ramirez", 154885698, "Libertad 1421");
        Cliente cliente3 = new Cliente("Oscar Lopez", 151456974, "Colon 4512");

        videoStore.todosLosClientes(cliente1);
        videoStore.todosLosClientes(cliente2);
        videoStore.todosLosClientes(cliente3);

        Pelicula pelicula1 = new Pelicula("Accion", "BASE SECRETA", "20/3/2021", 200, "R", "EEUU", "Pelicula de guerra", 3);
        Pelicula pelicula2 = new Pelicula("Aventura", "LA LEYENDA DE LA TUMABA DEL DRAGON", "17/9/2014", 97, "PG-13", "FR", "Dos hermanos buscando un dragon", 5);
        Pelicula pelicula3 = new Pelicula("Comedia", "NIÑERA A PRUEBA DE BALAS", "30/1/2004", 118, "PG", "EEUU", "Una niñera un poco particular", 5);
        Pelicula pelicula4 = new Pelicula("Comedia", "A", "30/1/2004", 118, "PG", "EEUU", "A", 5);

        videoStore.todasLasPeliculas(pelicula1);
        videoStore.todasLasPeliculas(pelicula2);
        videoStore.todasLasPeliculas(pelicula3);
        videoStore.todasLasPeliculas(pelicula4);

        Boleta boleta1 = new Boleta(cliente1,pelicula1);
        Boleta boleta2 = new Boleta(cliente1,pelicula2);
        Boleta boleta3 = new Boleta(cliente1,pelicula3);
        Boleta boleta4 = new Boleta(cliente1,pelicula4);
        Boleta boleta5 = new Boleta(cliente2,pelicula1);
        Boleta boleta6 = new Boleta(cliente2,pelicula2);
        Boleta boleta7 = new Boleta(cliente3,pelicula1);
        Boleta boleta8 = new Boleta(cliente3,pelicula2);
        Boleta boleta9 = new Boleta(cliente3,pelicula3);
        Boleta boleta10 = new Boleta(cliente3,pelicula4);
        Boleta boleta11 = new Boleta(cliente2,pelicula3);

        videoStore.todasLasBoletas(boleta1);
        videoStore.todasLasBoletas(boleta2);
        videoStore.todasLasBoletas(boleta3);
        videoStore.todasLasBoletas(boleta4);
        videoStore.todasLasBoletas(boleta5);
        videoStore.todasLasBoletas(boleta6);
        videoStore.todasLasBoletas(boleta7);
        videoStore.todasLasBoletas(boleta8);
        videoStore.todasLasBoletas(boleta9);
        videoStore.todasLasBoletas(boleta10);
        videoStore.todasLasBoletas(boleta11);

        System.out.println("*****************************************\n* Hola, bienvenido a nuestro VideoStore!*\n*****************************************\n\nQue desea hacer?");
        System.out.println("1_Alquilar una pelicula\n2_Devolver una pelicula\n3_Gestionar el video club");

        Scanner scInt = new Scanner(System.in);

        int ejercicio = scInt.nextInt();

        Scanner scString = new Scanner(System.in);

        //String nombrePelicula = scString.nextLine();

        switch (ejercicio) {

            case 1:


                System.out.println("Que pelicula desea alquilar? (ingresar todo el nombre en mayuscula)\n");

                System.out.println("Lista de peliculas: ");
                videoStore.mostrarPeliculas();

                String nombrePelicula = scString.nextLine();

                System.out.println("\n");

                if ((videoStore.existePelicula(nombrePelicula))) {
                    if (videoStore.chequeoStockPelicula(nombrePelicula)) {
                        System.out.println("Hay stock de la pelicula deseada!\nIngrese su nombre completo: ");
                        String nombreCliente = scString.nextLine();
                        if (videoStore.existeCliente(nombreCliente)) {
                            Boleta boleta = new Boleta(videoStore.retornarClientePorNombre(nombreCliente), videoStore.retornarPeliculaPorNombre(nombrePelicula));
                            videoStore.todasLasBoletas(boleta);


                        } else {
                            System.out.println("Usted no esta registrado en el sistema, para poder continuar con el alquiler ingrese su numero de telefono");
                            int numeroTelefono = scInt.nextInt();
                            System.out.println("Ingrese su direccion para completar el registro");
                            String direccion = scString.nextLine();

                            Cliente cliente = new Cliente(nombreCliente,numeroTelefono,direccion);
                            videoStore.todosLosClientes(cliente);

                            Boleta boleta = new Boleta(cliente, videoStore.retornarPeliculaPorNombre(nombrePelicula));
                            videoStore.todasLasBoletas(boleta);

                        }
                    } else {
                        System.err.println("No hay stock de la pelicula seleccionada!");
                    }
                }

                videoStore.mostrarBoletas();

                break;

            case 2:
                System.out.println("Ingrese su nombre y pelicula que desea devolver:");
                String nombre = scString.nextLine();
                String titulo = scString.nextLine();

                Cliente clienteAux = videoStore.retornarClientePorNombre(nombre);
                Pelicula peliculaAux = videoStore.retornarPeliculaPorNombre(titulo);

                Boleta boletaDevuelta =videoStore.retornarBoletaPorClienteYPelicula(clienteAux,peliculaAux);

                videoStore.devulucionPelicula(boletaDevuelta);




            case 3:
                System.out.println("Que accion desea realizar?\n1_Consultar alquileres vigentes\n2_Devoluciones segun el dia\n3_Consultar los ultimos 10 alquileres de un cliente\n4_consultar los titulos mas alquilados\n5_Ordenar titulos por genero\n6_Ordenarlos segun popularidad\n7_Ver informacion detallada de un titulo");
                int eleccion = scInt.nextInt();

                switch (eleccion){
                    case 1:
                        System.out.println("\n\nAlquileres vigentes:");
                        videoStore.mostrarAlquileresVigentes();
                        break;

                    case 2:

                        break;

                    case 3:
                        System.out.println("Ingrese el nombre del cliente que desea ver sus ultimas 10 boletas:");
                        String nombreCliente = scString.nextLine();
                        Cliente clienteBuscado = new Cliente();
                        clienteBuscado = videoStore.retornarClientePorNombre(nombreCliente);
                        videoStore.ultimosDiezAlquileresCliente(clienteBuscado);
                        break;

                    case 4:
                        System.out.println("El titulo mas alquilado es:");
                        Pelicula peliculaMasAlquilada = videoStore.peliculaMasFrecuente();
                        System.out.println(peliculaMasAlquilada.toString());
                        System.out.println("/////////////////////////////////////////////");
                        videoStore.mostrarBoletas();


                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:

                        break;
                }




        }
    }
}
