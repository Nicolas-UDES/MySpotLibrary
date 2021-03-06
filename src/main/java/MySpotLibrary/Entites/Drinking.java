package MySpotLibrary.Entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Squirrel on 2017-11-25.
 */

@Entity
public class Drinking implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    private double used;

    private boolean emptied;

    private Date date;

    @JoinColumn(name = "location")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Territory location;

    @JoinColumn(name = "location")
    private Long locationId;

    @JoinColumn(name = "player")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Player player;

    @JoinColumn(name = "player")
    private Long playerId;

    public Drinking() {
    }

    public Drinking(Long id, double amount, Date date, Territory location, Player player) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.location = location;
        this.locationId = location.getId();
        this.player = player;
        this.playerId = player.getId();
        this.used = 0.0;
        this.emptied = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
