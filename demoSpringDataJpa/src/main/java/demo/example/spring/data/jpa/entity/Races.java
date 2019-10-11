package demo.example.spring.data.jpa.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "races")
public class Races {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "raceid")
	private Long raceId;
	@Column(name = "year")
	private Integer year;
	@Column(name = "round")
	private Integer round;
	@ManyToOne
	@JoinColumn(name = "circuitid")
	private Circuits circuitId;
	@Column(name = "name")
	private String name;
	@Column(name = "date")
	private Date date;
	@Column(name = "time")
	private Time time;
	@Column(name = "url")
	private String url;

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getRound() {
		return round;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

	public Circuits getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(Circuits circuitId) {
		this.circuitId = circuitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
