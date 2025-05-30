package com.perfulandia.productservice.service;

import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ProductoService {
/*comentario*/
    public final ProductoRepository repo;
    public ProductoService(ProductoRepository repo){
        this.repo=repo;
    }

    //listar
    public List<Producto> listar(){
        return repo.findAll();
    }
    //Guardar
    public Producto guardar(Producto producto){
        return repo.save(producto);
    }
    //Buscar
    public Producto bucarPorId(long id){
        return repo.findById(id).orElse(null);
    }
    //Eliminar
    public void eliminar(long id){
        repo.deleteById(id);
    }

    public Producto actualizar(long id, Map<String, Object> campos) {
        Producto producto = repo.findById(id).orElse(null);

        if (producto == null){
            return null;
        }
        //clave es el nombre del campo a actualizar "nombre" o "correo"
        //Valor es el nuevo valor para el campo
        campos.forEach((clave, valor) -> { //Recorre las diferentes claves en campos (que contiene el mapeo json)
                    switch (clave) { //Evalua que campo se actualizara segun la clave
                        case "nombre":
                            producto.setNombre((String) valor); //transforma el valor (objeto) a String y le asigna el nuevo valor
                            break;
                        case "precio":
                            // Verifica si el valor recibido es una instancia de String
                            if (valor instanceof String) {
                                // Si es un String, lo convierte a Double usando Double.parseDouble y lo asigna como precio
                                producto.setPrecio(Double.parseDouble((String) valor));
                            }
                            // Si no es un String pero sí un número (por ejemplo, Integer, Double, etc.)
                            else if (valor instanceof Number) {
                                // Convierte el valor a double con .doubleValue() y lo asigna como precio
                                producto.setPrecio(((Number) valor).doubleValue());
                            }

                            break;
                        case "stock":
                            if (valor instanceof String) {
                                producto.setStock(Integer.parseInt((String) valor));
                            } else if (valor instanceof Number) {
                                producto.setStock(((Number) valor).intValue());
                            }
                            break;
                    }
                }
        );
        return repo.save(producto);
    }
}
