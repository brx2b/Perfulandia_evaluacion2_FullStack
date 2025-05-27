package com.perfulandia.carritoservice.model;


import jakarta.persistence.*;
import lombok.*;
//DTO
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private long id;
    private String nombre;
    private double precio;
}
