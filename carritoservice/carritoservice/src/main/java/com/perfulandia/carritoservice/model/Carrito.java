package com.perfulandia.carritoservice.model;


import jakarta.persistence.*;
//todas las anotaciones necesarias para la persistencia de datos
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
//mi clase "carrito" sera guardada en la base de datos como tabla y

@Data
//genera automaticamente getters setters y toString()

@AllArgsConstructor
@NoArgsConstructor
//los constructores con y sin argumentos

public class Carrito {
    @Id
    //toma el primero de los campos como id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //genera un id autoincremental automaticamente en la base d datos
    private long id;

    private BigDecimal precioFinal = BigDecimal.ZERO;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CarritoItem> items = new HashSet<>();

    //es para actualizar el precio final del carrito
    private void actualizarPrecioFinal() {
        this.precioFinal = items.stream().map(item -> {
            BigDecimal precioUnidad = item.getPrecioUnidad();
            if (precioUnidad == null) {
                return  BigDecimal.ZERO;
            }
            return precioUnidad.multiply(BigDecimal.valueOf(item.getCantidadProducto()));
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Se usa mas tarde cuando se agregan o sacan productos, actualizando el precio acorde
    public void agregarItem(CarritoItem item) {
        this.items.add(item);
        item.setCarrito(this);
        actualizarPrecioFinal();
    }

    public void eliminarItem(CarritoItem item) {
        this.items.remove(item);
        item.setCarrito(null);
        actualizarPrecioFinal();
    }


}
