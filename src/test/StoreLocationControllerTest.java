package test;

import controller.StoreLocationController;
import entity.StoreLocation;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.StoreLocationView;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StoreLocationControllerTest {

    Repository<StoreLocation> storeLocationRepository = new Repository<StoreLocation>();
    StoreLocationView storeLocationView = new StoreLocationView();
    StoreLocationController storeLocationController;

    @BeforeAll
    private void setup() {
        storeLocationController = new StoreLocationController(storeLocationRepository, storeLocationView);
    }

    @Test
    void testAdd() {
        StoreLocation storeLocation = new StoreLocation(1,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.addStoreLocation(storeLocation);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        StoreLocation storeLocation = new StoreLocation(-2,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.addStoreLocation(storeLocation);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        StoreLocation storeLocation = new StoreLocation(1,2,"Cluj","Romania","Cluj","Constanta");
        StoreLocation updateStoreLocation = new StoreLocation(1,2,"","","","Mamaia");
        try {
            storeLocationController.addStoreLocation(storeLocation);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        StoreLocation storeLocation = new StoreLocation(1,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.deleteStoreLocationById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        StoreLocation storeLocation = new StoreLocation(-2,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.deleteStoreLocationById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        StoreLocation storeLocation = new StoreLocation(1,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        StoreLocation storeLocation = new StoreLocation(1,2,"Cluj","Romania","Cluj","Constanta");
        try {
            storeLocationController.displayById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}



