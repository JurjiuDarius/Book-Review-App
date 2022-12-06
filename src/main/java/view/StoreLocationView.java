package view;

import entity.StoreLocation;

import java.util.List;

public class StoreLocationView {

    public void displayStoreLocation(StoreLocation storeLocation) {
        System.out.println(storeLocation);
    }

    public void displayStoreLocations(List<StoreLocation> storeLocations) {
        for (StoreLocation storeLocation : storeLocations) {
            System.out.println(storeLocation);
        }
    }

}
