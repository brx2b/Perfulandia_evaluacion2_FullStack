package com.perfulandia.carritoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarritoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //establecemos relacion
    private String nombre;
    private double precioUnidad;
    private int cantidad;
    private double precioTotal;

    public void setId(long id) {
        this.id = id;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    @JsonIgnore
    private Carrito carrito;




    //calcula el precio total multiplicando la cantidad del producto x el precio unitario
    public void calcularPrecioTotal() {
        this.precioTotal = this.precioUnidad * this.cantidad;
    }


}
