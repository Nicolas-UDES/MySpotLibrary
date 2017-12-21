package MySpotLibrary.BLL;

import MySpotLibrary.Entites.Marking;
import MySpotLibrary.Entites.Player;
import MySpotLibrary.Entites.Territory;

import java.util.HashMap;
import java.util.Map;

public class TerritoryBLL {

	public static Player oldGetOwner (Territory territory){
		Map<Long,Double> map  = new HashMap<>();
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
		Map<Long, Double> powerByUser = new HashMap<>();
		Marking maxMarking = null;
		double maxPower = Double.MIN_VALUE;

		for (Marking m : territory.getMarkings()){
			double power = MarkingBLL.getPower(m);

			if(powerByUser.containsKey(m.getPlayerId())) {
				power += powerByUser.get(m.getPlayerId());
			}

			powerByUser.put(m.getPlayerId(), power);
			if(maxPower < power) {
				maxPower = power;
				maxMarking = m;
			}
		}

		return maxMarking != null ? maxMarking.getPlayerId() : null;
	}
}