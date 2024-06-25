package com.FindSuperMarket.demo.sys.service;

import com.FindSuperMarket.demo.sys.domain.dto.SupermarketDTO;
import com.FindSuperMarket.demo.sys.domain.request.supermarket.CreateSupermarketRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.NearbySearchRequest;

import java.util.List;

public interface SupermarketService {
    SupermarketDTO createSupermarket(CreateSupermarketRequest request);
    SupermarketDTO getSupermarketById(Long id);
    List<SupermarketDTO> getAllSupermarkets();
    List<SupermarketDTO> searchNearbySupermarkets(NearbySearchRequest request);
    void deleteSupermarket(Long id);
    SupermarketDTO updateSupermarket(Long id, CreateSupermarketRequest request);
}
