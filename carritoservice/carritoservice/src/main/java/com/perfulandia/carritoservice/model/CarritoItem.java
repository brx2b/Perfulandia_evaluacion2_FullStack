package com.perfulandia.carritoservice.model;
import com.perfulandia.carritoservice.model.Producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int cantidadProducto;
    private BigDecimal precioUnidad;
    private BigDecimal precioTotal;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carrito")
    private Carrito carrito;

    //calcula el precio total multiplicando la cantidad del producto x el precio unitario
    public void setPrecioTotal(){
        this.precioTotal = this.precioUnidad.multiply(new BigDecimal(cantidadProducto));
    }
}
