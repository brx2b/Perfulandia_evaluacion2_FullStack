package com.perfulandia.carritoservice.model;


import jakarta.persistence.*;
//todas las anotaciones necesarias para la persistencia de datos
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
//mi clase "carrito" sera guardada en la base de datos como tabla

@Data
//genera automaticamente getters setters y toString()

@AllArgsConstructor
@NoArgsConstructor
//los constructores con y sin argumentos

@Builder

public class Carrito {
    @Id
    //toma el primero de los campos como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //genera un id autoincremental automaticamente en la base d datos
    private long id;

    //definicion de relacion, agregando el mappeBy para q
    //cascade: cuando guardes/elimines al carrito igual eliminas los items en el
    //orphanRemoval eliminas un item del carro igual lo eliminas d la base d datos

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CarritoItem> items = new ArrayList<>();


}

