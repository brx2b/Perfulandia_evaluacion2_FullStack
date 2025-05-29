package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.CarritoItem;
import com.perfulandia.carritoservice.model.Producto;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import com.perfulandia.carritoservice.service.CarritoService;
import com.perfulandia.carritoservice.model.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/perfulandia_carritos")


public class CarritoController {
    private final CarritoService servicio;
    private final RestTemplate restTemplate;

    public CarritoController(CarritoService servicio, RestTemplate restTemplate) {
        this.servicio = servicio;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Carrito> mostrarCarrito(){
        return servicio.mostrarCarrito();
    }



    @Autowired
    private CarritoRepository carritoRepository;

    @PostMapping
    public Carrito guardarCarrito(@RequestBody Carrito carrito){

        return servicio.guardarCarrito(carrito);
    }
    @GetMapping("/{id}")
    public Carrito buscarCarrito(@PathVariable long id){
        return servicio.buscarCarrito(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarCarrito(@PathVariable long id){
        servicio.eliminarCarrito(id);
    }


}
