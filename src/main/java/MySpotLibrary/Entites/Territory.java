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
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<GeoPos> positions;

    private TerritoryType territoryType;

    private GeoPos center;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Marking> markings;

    public Territory() {
        this(new ArrayList<GeoPos>());
    }

    public Territory(List<GeoPos> positions) {
        this.positions = positions;
        markings = new ArrayList<Marking>();
    }

    public Territory(long id, TerritoryType territoryType, List<GeoPos> positions) {
        this(positions);
        this.id = id;
        this.territoryType = territoryType;
    }

    public void addAll(GeoPos... geoPos){
        Collections.addAll(positions, geoPos);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Player getOwner (){
        Map <String,String> map  = new HashMap<String, String>();
        double maxPower = markings.get(0).getPower();
        Marking theMarking = markings.get(0);

        for (Marking m : markings){
            String key = Long.toString(m.getPlayerId());
            String power = map.get(key);
            double newPower;

            if (power == null)
                newPower = m.getPower();
            else
                newPower = Double.parseDouble(power) + m.getPower();

            map.put(key,Double.toString(newPower));

            if (newPower > maxPower)
                theMarking = m;
        }

        return theMarking.getPlayer();
    }
}
