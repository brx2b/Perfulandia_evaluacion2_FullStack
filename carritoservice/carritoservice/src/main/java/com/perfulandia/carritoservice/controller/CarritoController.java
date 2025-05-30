package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.model.CarritoItem;
import com.perfulandia.carritoservice.repository.CarritoRepository;
import com.perfulandia.carritoservice.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/perfulandia_carritos")
public class CarritoController {

    private final CarritoService servicio;
    private final RestTemplate restTemplate;

    public CarritoController(CarritoService servicio, RestTemplate restTemplate) {
        this.servicio = servicio;
        this.restTemplate = restTemplate;
    }

    @Autowired
    private CarritoRepository carritoRepository;

    @GetMapping
    public List<Carrito> mostrarCarrito() {
        return servicio.mostrarCarrito();
    }

    @PostMapping
    public Carrito guardarCarrito(@RequestBody Carrito carrito) {
        return servicio.guardarCarrito(carrito);
    }

    @GetMapping("/{id}")
    public Carrito buscarCarrito(@PathVariable long id) {
        return servicio.buscarCarrito(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCarrito(@PathVariable long id) {
        servicio.eliminarCarrito(id);
        return ResponseEntity.ok("✅ El carrito se eliminó con éxito");
    }

    @PatchMapping("/{id}")
    public CarritoItem actualizar(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return servicio.actualizar(id, campos);
    }

    @PostMapping("/{carritoId}/items")
    public ResponseEntity<?> agregarItemAlCarrito(@PathVariable long carritoId, @RequestBody CarritoItem item) {
        Carrito actualizado = servicio.agregarItemAlCarrito(carritoId, item);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
}
