package com.perfulandia.carritoservice.model;
import com.perfulandia.carritoservice.model.Producto;

import jakarta.persistence.*;
import lombok.*;
import java.math.*;

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
    private long idProducto;
    private String nombreProducto;
    private double precioProducto;
    private int cantidadProducto;
    private double precioTotal;

    @ManyToOne
    private Carrito carrito;



    //calcula el precio total multiplicando la cantidad del producto x el precio unitario
    public void setPrecioTotal() {
            this.precioTotal = precioProducto*cantidadProducto;
    }


}
