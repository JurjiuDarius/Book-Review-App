package entity;

import java.util.List;

public class BookStore extends Identifiable {
	private int id;
	private List<StoreLocation> locations;
	private int establishment_year;

	public BookStore(int id, int id1, List<StoreLocation> locations, int establishment_year) {
		super(id);
		this.id = id1;
		this.locations = locations;
		this.establishment_year = establishment_year;
	}

	public List<StoreLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<StoreLocation> locations) {
		this.locations = locations;
	}

	public int getEstablishment_year() {
		return establishment_year;
	}

	public void setEstablishment_year(int establishment_year) {
		this.establishment_year = establishment_year;
	}

}
