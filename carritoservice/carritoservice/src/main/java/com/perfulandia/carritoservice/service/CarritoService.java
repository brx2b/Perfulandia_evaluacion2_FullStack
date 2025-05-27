package com.perfulandia.carritoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {
    public final CarritoRepository repoCarrito;
    public CarritoService(CarritoRepository repoCarrito){
        this.repoCarrito=repoCarrito;
    }
    public List<Carrito> mostrarCarrito(){
        return repoCarrito.findAll();
    }

    public Carrito guardarCarrito(Carrito carrito){
        return repoCarrito.save(carrito);
    }

    public Carrito buscarCarrito(long id){
        return repoCarrito.findById(id).orElse(null);
    }

    public void eliminarCarrito(long id){repoCarrito.deleteById(id);
    }
}
