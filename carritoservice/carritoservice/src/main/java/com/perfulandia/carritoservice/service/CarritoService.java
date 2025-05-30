package com.perfulandia.carritoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.model.CarritoItem;
import com.perfulandia.carritoservice.repository.CarritoItemRepository;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarritoService {

    public final CarritoRepository repoCarrito;
    public final CarritoItemRepository repoCarritoItem;

    public CarritoService(CarritoRepository repoCarrito, CarritoItemRepository repoCarritoItem) {
        this.repoCarrito = repoCarrito;
        this.repoCarritoItem = repoCarritoItem;
    }

    public List<Carrito> mostrarCarrito() {
        return repoCarrito.findAll();
    }

    public Carrito guardarCarrito(Carrito carrito) {
        carrito.setId(0);
        for (CarritoItem item : carrito.getItems()) {
            item.setCarrito(carrito);
            item.setPrecioTotal();
            item.setId(0);
        }
        return repoCarrito.save(carrito);
    }

    public Carrito buscarCarrito(long id) {
        return repoCarrito.findById(id).orElse(null);
    }

    public void eliminarCarrito(long id) {
        repoCarrito.deleteById(id);
    }

    public CarritoItem actualizar(long id, Map<String, Object> campos) {
        CarritoItem carritoItem = repoCarritoItem.findById(id).orElse(null);
        if (carritoItem == null) {
            return null;
        }

        campos.forEach((clave, valor) -> {
            switch (clave) {
                case "nombre":
                    carritoItem.setNombre((String) valor);
                    break;
                case "precioUnidad":
                    if (valor instanceof String) {
                        carritoItem.setPrecioUnidad(Double.parseDouble((String) valor));
                    } else if (valor instanceof Number) {
                        carritoItem.setPrecioUnidad(((Number) valor).doubleValue());
                    }
                    break;
                case "cantidad":
                    if (valor instanceof String) {
                        carritoItem.setCantidad(Integer.parseInt((String) valor));
                    } else if (valor instanceof Number) {
                        carritoItem.setCantidad(((Number) valor).intValue());
                    }
                    break;
            }
        });

        carritoItem.setPrecioTotal();
        return repoCarritoItem.save(carritoItem);
    }

    public Carrito agregarItemAlCarrito(long carritoId, CarritoItem item) {
        Carrito carrito = repoCarrito.findById(carritoId).orElse(null);
        if (carrito == null) return null;

        item.setCarrito(carrito); // asocia el item al carrito
        item.setId(0); // fuerza INSERT en lugar de UPDATE
        item.setPrecioTotal(); // calcula el precio total si tienes esa lógica

        // Guarda el item en la base de datos
        repoCarritoItem.save(item);

        // Vuelve a cargar el carrito con los items
        return repoCarrito.findById(carritoId).orElse(null);
    }

}
