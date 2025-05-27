package com.perfulandia.carritoservice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private long id;
    private String nombre;
    private double precio;
    private int stock;
}
