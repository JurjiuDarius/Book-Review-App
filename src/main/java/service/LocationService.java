package service;

import entity.StoreLocation;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class LocationService {

	private Repository<StoreLocation> storeLocationRepository;

	public void addStoreLocation(StoreLocation storeLocation) {
		storeLocationRepository.add(storeLocation);
	}

	public void updateStoreLocation(StoreLocation storeLocation) {
		storeLocationRepository.update(storeLocation);
	}

	public void deleteStoreLocation(Integer id) {
		storeLocationRepository.deleteById(id);
	}

	public List<StoreLocation> getAllStoreLocations(Integer id) {
		return storeLocationRepository.findAll();
	}

}
