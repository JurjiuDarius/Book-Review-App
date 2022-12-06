package entity;

public class StoreLocation extends Identifiable {
	private int id;
	private String city;
	private String country;
	private String county;
	private String address;

	public StoreLocation(int id, int id1, String city, String country, String county, String address) {
		super(id);
		this.id = id1;
		this.city = city;
		this.country = country;
		this.county = county;
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
