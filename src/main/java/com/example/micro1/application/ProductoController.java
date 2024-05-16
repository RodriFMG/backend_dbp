package com.example.micro1.application;

import com.example.micro1.Domain.Producto;

import com.example.micro1.Service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:19006")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> AllProducto(){
        List<Producto> producto = productoService.getAllProducto();
        return new ResponseEntity<>(producto,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> PostProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable Long id, @RequestBody Producto producto){
        Optional<Producto> updatedProducto = productoService.updateProducto(id,producto);
        return updatedProducto.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchProducto(@PathVariable Long id, @RequestBody Producto producto){
        Optional<Producto> patchedProducto = productoService.patchProducto(id,producto);
        return patchedProducto.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Optional<Producto> deletedProducto = productoService.deleteProducto(id);
        return deletedProducto.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }

    @GetMapping("/{name}")
    public ResponseEntity<Producto> BuscarNombre(@PathVariable String name) {
        Optional<Producto> producto = productoService.getNameProducto(name);

        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}