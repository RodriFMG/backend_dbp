package com.example.micro1.application;
import com.example.micro1.Service.BebidaService;
import com.example.micro1.Service.CafeService;
import com.example.micro1.Domain.Bebida;
import com.example.micro1.Domain.Cafe;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cafe")
@CrossOrigin(origins = "http://localhost:19006")
public class CafeController {

    @Autowired
    private CafeService cafeService;

    @GetMapping
    public ResponseEntity<List<Cafe>> AllCafe(){
        List<Cafe> cafe = cafeService.getAllCafe();
        return new ResponseEntity<>(cafe,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> PostBebida(@RequestBody Cafe cafe){
        cafeService.saveCafe(cafe);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable Long id, @RequestBody Cafe cafe){
        Optional<Cafe> updatedCafe = cafeService.updateCafe(id,cafe);
        return updatedCafe.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchProducto(@PathVariable Long id, @RequestBody Cafe cafe){
        Optional<Cafe> patchCafe = cafeService.patchCafe(id,cafe);
        return patchCafe.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable Long id) {
        Optional<Cafe> deletedCafe = cafeService.deleteCafe(id);
        return deletedCafe.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }


}
