package demo.example.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constructors")
public class Constructors {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="constructorid")
	private Long constructorId;
	@Column(name="constructorref")
	private String constructorRef;
	private String name;
	private String nationality;
	private String url;

	public Long getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(Long constructorId) {
		this.constructorId = constructorId;
	}

	public String getConstructorRef() {
		return constructorRef;
	}

	public void setConstructorRef(String constructorRef) {
		this.constructorRef = constructorRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
