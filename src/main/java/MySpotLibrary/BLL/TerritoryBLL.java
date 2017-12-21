package MySpotLibrary.BLL;

import MySpotLibrary.Entites.Marking;
import MySpotLibrary.Entites.Player;
import MySpotLibrary.Entites.Territory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TerritoryBLL {

	public static Player oldGetOwner (Territory territory){
		Map<Long,Double> map  = new HashMap<Long, Double>();
		Marking theMarking = territory.getMarkings().get(0);
		double maxPower = MarkingBLL.getPower(theMarking);

		for (Marking m : territory.getMarkings()){
			Long key = m.getPlayerId();
			Double power = map.get(key);
			double newPower = MarkingBLL.getPower(m);

			if (power != null) {
				newPower += power;
			}
			map.put(key,newPower);

			if (newPower > maxPower) {
				maxPower = newPower;
				theMarking = m;
			}
		}

		return theMarking.getPlayer();
	}

	public static Long getOwner(Territory territory) {
		Optional<Marking> max = territory.getMarkings().stream().reduce(MarkingBLL::max);
		return max.isPresent() ? max.get().getPlayerId() : null;
	}
}