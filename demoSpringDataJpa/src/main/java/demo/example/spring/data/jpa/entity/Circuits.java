package demo.example.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "circuits")
@NamedQuery(name = "Circuits.getCircuitsByName", query = "select c from Circuits c where c.name = ?1")
public class Circuits {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "circuitid", nullable = false)
	private Long circuitId;

	@Column(name = "circuitref")
	private String circuitRef;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "country")
	private String country;

	@Column(name = "lat")
	private Double lat;

	@Column(name = "lng")
	private Double lng;

	@Column(name = "alt")
	private String alt;

	@Column(name = "url")
	private String url;

	public Long getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(Long circuitId) {
		this.circuitId = circuitId;
	}

	public String getCircuitRef() {
		return circuitRef;
	}

	public void setCircuitRef(String circuitRef) {
		this.circuitRef = circuitRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
