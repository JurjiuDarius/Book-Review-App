package controller;

import entity.StoreLocation;
import exception.BadValueException;
import service.StoreLocationService;
import view.StoreLocationView;

public class StoreLocationController {

    private final StoreLocationService storeLocationService;
    private final StoreLocationView storeLocationView;

    public StoreLocationController(StoreLocationService storeLocationService, StoreLocationView storeLocationView) {
        this.storeLocationService = storeLocationService;
        this.storeLocationView = storeLocationView;
    }

    public StoreLocation addStoreLocation(StoreLocation storeLocation) throws BadValueException {
        if (storeLocation.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return storeLocationService.add(storeLocation);
    }

    public StoreLocation updateStoreLocation(StoreLocation storeLocation) throws BadValueException {
        if (storeLocation.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return storeLocationService.update(storeLocation);
    }

    public void deleteStoreLocationById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        storeLocationService.deleteById(id);
    }

    public void displayAll() {

        storeLocationView.displayStoreLocations(storeLocationService.findAll());
    }

    public void displayById(int id) throws BadValueException {

        storeLocationView.displayStoreLocation(storeLocationService.findById(id));

    }

}

