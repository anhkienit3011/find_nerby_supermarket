package com.FindSuperMarket.demo.sys.service.imp;

import com.FindSuperMarket.demo.exception.ResourceNotFoundException;
import com.FindSuperMarket.demo.sys.domain.dto.SupermarketDTO;
import com.FindSuperMarket.demo.sys.domain.entity.Supermarket;
import com.FindSuperMarket.demo.sys.domain.mapper.SupermarketMapper;
import com.FindSuperMarket.demo.sys.domain.request.supermarket.CreateSupermarketRequest;
import com.FindSuperMarket.demo.sys.domain.request.user.NearbySearchRequest;
import com.FindSuperMarket.demo.sys.repository.CategoryRepository;
import com.FindSuperMarket.demo.sys.repository.SupermarketRepository;
import com.FindSuperMarket.demo.sys.service.SupermarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SupermarketServiceImpl implements SupermarketService {
    private final SupermarketRepository supermarketRepository;
    private final CategoryRepository categoryRepository;
    private final SupermarketMapper supermarketMapper;
    @Override
    public SupermarketDTO createSupermarket(CreateSupermarketRequest request) {
        Supermarket supermarket = supermarketMapper.toEntity(request);
        supermarket = supermarketRepository.save(supermarket);
        return supermarketMapper.toDTO(supermarket);
    }

    @Override
    public SupermarketDTO getSupermarketById(Long id) {
        Supermarket supermarket = supermarketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supermarket not found"));
        return supermarketMapper.toDTO(supermarket);
    }

    @Override
    public List<SupermarketDTO> getAllSupermarkets() {
        List<Supermarket> supermarkets = supermarketRepository.findAll();
        return supermarketMapper.toDTOList(supermarkets);
    }

    @Override
    public List<SupermarketDTO> searchNearbySupermarkets(NearbySearchRequest request) {
        List<Supermarket> supermarkets = supermarketRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude().subtract(BigDecimal.valueOf(request.getRadiusInKm() / 111.0)),
                request.getLatitude().add(BigDecimal.valueOf(request.getRadiusInKm() / 111.0)),
                request.getLongitude().subtract(BigDecimal.valueOf(request.getRadiusInKm() / 111.0)),
                request.getLongitude().add(BigDecimal.valueOf(request.getRadiusInKm() / 111.0))
        );
        return supermarketMapper.toDTOList(supermarkets);
    }

    @Override
    public void deleteSupermarket(Long id) {
        if (!supermarketRepository.existsById(id)) {
            throw new ResourceNotFoundException("Supermarket not found");
        }
        supermarketRepository.deleteById(id);
    }

    @Override
    public SupermarketDTO updateSupermarket(Long id, CreateSupermarketRequest request) {
        Supermarket supermarket = supermarketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supermarket not found"));
        supermarketMapper.updateEntityFromRequest(request, supermarket);
        supermarket = supermarketRepository.save(supermarket);
        return supermarketMapper.toDTO(supermarket);
    }
}
