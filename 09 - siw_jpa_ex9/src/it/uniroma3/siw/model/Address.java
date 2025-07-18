package it.uniroma3.siw.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findAllAddresses", query = "SELECT a FROM Address a")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String zipcode;
	
	@Column(nullable = false)
	private String country;
	
	public Address() {
	}
	
	public Address(String street, String city, String state, String zipcode, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, city, country,  state, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(state, other.state) 
				&& Objects.equals(street, other.street) && Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public String toString() {
		return "Address [Id=" + Id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", country=" + country + "]";
	}
	
}
