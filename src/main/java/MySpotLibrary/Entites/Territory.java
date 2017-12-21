package MySpotLibrary.Entites;

import MySpotLibrary.Entites.Enumerable.TerritoryType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Squirrel on 2017-11-20.
 */
@Entity
public class Territory implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GeoPos> positions;

    private TerritoryType territoryType;

    private GeoPos center;

    private String name;

    @JoinColumn(name = "ownedBy")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Player ownedBy;

    @JoinColumn(name = "ownedBy")
    private Long ownedById;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Marking> markings;

    public Territory() {
        this(new ArrayList<GeoPos>());
    }

    public Territory(List<GeoPos> positions) {
        this.positions = positions;
        markings = new ArrayList<Marking>();
    }

    public Territory(Long id, TerritoryType territoryType, List<GeoPos> positions) {
        this(positions);
        this.id = id;
        this.territoryType = territoryType;
    }

    public void addAll(GeoPos... geoPos){
        Collections.addAll(positions, geoPos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GeoPos> getPositions() {
        return positions;
    }

    public void setPositions(List<GeoPos> positions) {
        this.positions = positions;
    }

    public TerritoryType getTerritoryType() {
        return territoryType;
    }

    public void setTerritoryType(TerritoryType territoryType) {
        this.territoryType = territoryType;
    }

    public GeoPos getCenter() {
        return center;
    }

    public void setCenter(GeoPos center) {
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Marking> getMarkings() {
        return markings;
    }

    public void setMarkings(List<Marking> markings) {
        this.markings = markings;
    }

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }

    public Long getOwnedById() {
        return ownedById;
    }

    public void setOwnedById(Long ownedById) {
        this.ownedById = ownedById;
    }
}
