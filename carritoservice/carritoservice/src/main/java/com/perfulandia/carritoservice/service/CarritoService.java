package com.perfulandia.carritoservice.service;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.model.CarritoItem;
import com.perfulandia.carritoservice.repository.CarritoItemRepository;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    public CarritoService(CarritoRepository repoCarrito, CarritoItemRepository repoCarritoItem){
        this.repoCarrito=repoCarrito;
        this.repoCarritoItem = repoCarritoItem;
    }

    public final CarritoRepository repoCarrito;
    public final CarritoItemRepository repoCarritoItem;

    public List<Carrito> mostrarCarrito(){
        return repoCarrito.findAll();
    }

    public List<CarritoItem> mostrarItems(){
        return repoCarritoItem.findAll();
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
