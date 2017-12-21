package MySpotLibrary.Entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Marking implements Serializable {

	@Id
	@GeneratedValue
	private long id;

	private Date date;

	private double amount;

	private double used;

	private boolean emptied;

	private double strength;

	@JoinColumn(name = "location")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Territory location;

	@JoinColumn(name = "location")
	private long locationId;

	@JoinColumn(name = "player")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Player player;

	@JoinColumn(name = "player")
	private long playerId;

	public Marking() {
	}

	public Marking(int id, Date date, double amount, double strength, Territory location, Player player) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.strength = strength;
		this.location = location;
		this.locationId = location.getId();
		this.player = player;
		this.playerId = player.getId();

		used = 0.0;
		emptied = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public Territory getLocation() {
		return location;
	}

	public void setLocation(Territory location) {
		this.location = location;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public double getUsed() {
		return used;
	}

	public void setUsed(double used) {
		this.used = used;
	}

	public boolean isEmptied() {
		return emptied;
	}

	public void setEmptied(boolean emptied) {
		this.emptied = emptied;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
}
