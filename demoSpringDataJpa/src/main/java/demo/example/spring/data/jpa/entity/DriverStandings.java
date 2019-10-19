package demo.example.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driverstandings")
public class DriverStandings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driverstandingsid")
	Long driverStandingsId;
	@Column(name = "raceid")
	Long raceId;
	@Column(name = "driverid")
	Long driverId;
	Double points;
	Long position;
	@Column(name = "positiontext")
	String positionText;
	Long wins;

	public Long getDriverStandingsId() {
		return driverStandingsId;
	}

	public void setDriverStandingsId(Long driverStandingsId) {
		this.driverStandingsId = driverStandingsId;
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public String getPositionText() {
		return positionText;
	}

	public void setPositionText(String positionText) {
		this.positionText = positionText;
	}

	public Long getWins() {
		return wins;
	}

	public void setWins(Long wins) {
		this.wins = wins;
	}

	@Override
	public String toString() {
		return "DriverStandings [driverStandingsId=" + driverStandingsId + ", raceId=" + raceId + ", driverId="
				+ driverId + ", points=" + points + ", position=" + position + ", positionText=" + positionText
				+ ", wins=" + wins + "]";
	}

}
