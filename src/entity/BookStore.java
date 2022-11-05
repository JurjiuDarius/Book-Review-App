package entity;

import java.util.List;

public class BookStore extends Identifiable {
	private int id;
	private List<StoreLocation> locations;
	private int establishmentYear;

	public BookStore(int id, int id1, List<StoreLocation> locations, int establishmentYear) {
		super(id);
		this.id = id1;
		this.locations = locations;
		this.establishmentYear = establishmentYear;
	}

	public List<StoreLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<StoreLocation> locations) {
		this.locations = locations;
	}

	public int getEstablishment_year() {
		return establishmentYear;
	}

	public void setEstablishmentYear(int establishmentYear) {
		this.establishmentYear = establishmentYear;
	}

}
