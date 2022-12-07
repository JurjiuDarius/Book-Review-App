package controller;

import entity.StoreLocation;
import exception.BadValueException;
import repository.Repository;
import view.StoreLocationView;

import java.util.Optional;

public class StoreLocationController {

	private final Repository<StoreLocation> storeLocationRepository;
	private final StoreLocationView storeLocationView;

	public StoreLocationController(Repository<StoreLocation> repository, StoreLocationView storeLocationView) {
		this.storeLocationRepository = repository;
		this.storeLocationView = storeLocationView;
	}

	public StoreLocation addStoreLocation(StoreLocation storeLocation) throws BadValueException {
		if (storeLocation.getId() < 0) {
			throw new BadValueException("Ids are positive numbers");
		}

		return storeLocationRepository.add(storeLocation);
	}

	public StoreLocation updateStoreLocation(StoreLocation storeLocation) throws BadValueException {
		if (storeLocation.getId() < 0) {
			throw new BadValueException("Ids are positive numbers");
		}
		return storeLocationRepository.update(storeLocation);
	}

	public void deleteStoreLocationById(int id) throws BadValueException {
		if (id < 0) {
			throw new BadValueException("Ids are positive numbers");
		}

		storeLocationRepository.deleteById(id);
	}

	public void displayAll() {

		storeLocationView.displayStoreLocations(storeLocationRepository.findAll());
	}

	public void displayById(int id) throws BadValueException {
		Optional<StoreLocation> storeLocationOptional = storeLocationRepository.findById(id);
		if (id < 0) {
			throw new BadValueException("Ids are positive numbers");
		}
		if (!storeLocationOptional.isEmpty()) {
			storeLocationView.displayStoreLocation(storeLocationOptional.get());
		}
	}

}

