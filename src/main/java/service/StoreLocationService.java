package service;

import entity.StoreLocation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class StoreLocationService {

    private Repository<StoreLocation> storeLocationRepository;

    public StoreLocation add(StoreLocation storeLocation) {
        return storeLocationRepository.add(storeLocation);
    }

    public StoreLocation update(StoreLocation storeLocation) {
        return storeLocationRepository.update(storeLocation);
    }

    public void deleteById(Integer id) {
        storeLocationRepository.deleteById(id);
    }

    public StoreLocation findById(Integer id) {
        return storeLocationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("StoreLocation not found!"));
    }

    public List<StoreLocation> findAll() {
        return storeLocationRepository.findAll();
    }

}
