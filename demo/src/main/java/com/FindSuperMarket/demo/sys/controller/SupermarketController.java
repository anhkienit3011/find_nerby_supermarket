package com.FindSuperMarket.demo.sys.controller;



import com.FindSuperMarket.demo.sys.domain.dto.SupermarketDTO;
import com.FindSuperMarket.demo.sys.domain.request.supermarket.CreateSupermarketRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.NearbySearchRequest;
import com.FindSuperMarket.demo.sys.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supermarkets")
@RequiredArgsConstructor
public class SupermarketController {

    private final SupermarketService supermarketService;

    @PostMapping
    public ResponseEntity<SupermarketDTO> createSupermarket(@RequestBody CreateSupermarketRequest request) {
        SupermarketDTO supermarketDTO = supermarketService.createSupermarket(request);
        return new ResponseEntity<>(supermarketDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupermarketDTO> getSupermarketById(@PathVariable Long id) {
        SupermarketDTO supermarketDTO = supermarketService.getSupermarketById(id);
        return ResponseEntity.ok(supermarketDTO);
    }

    @GetMapping
    public ResponseEntity<List<SupermarketDTO>> getAllSupermarkets() {
        List<SupermarketDTO> supermarkets = supermarketService.getAllSupermarkets();
        return ResponseEntity.ok(supermarkets);
    }

    @PostMapping("/search")
    public ResponseEntity<List<SupermarketDTO>> searchNearbySupermarkets(@RequestBody NearbySearchRequest request) {
        List<SupermarketDTO> supermarkets = supermarketService.searchNearbySupermarkets(request);
        return ResponseEntity.ok(supermarkets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupermarket(@PathVariable Long id) {
        supermarketService.deleteSupermarket(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupermarketDTO> updateSupermarket(@PathVariable Long id, @RequestBody CreateSupermarketRequest request) {
        SupermarketDTO supermarketDTO = supermarketService.updateSupermarket(id, request);
        return ResponseEntity.ok(supermarketDTO);
    }
}