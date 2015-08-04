package gameobjects.locations;

import java.util.HashMap;

public class StarSystem {
	private String name;
	private HashMap<StarSystem, Double> neighbourStarSystem;

	public StarSystem(String name){
		this.name = name;
		this.neighbourStarSystem = new HashMap<StarSystem, Double>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<StarSystem, Double> getNeighbourStarSystem() {
		return neighbourStarSystem;
	}

	public void setNeighbourStarSystem(HashMap<StarSystem, Double> neighbourStarSystem) {
		this.neighbourStarSystem = neighbourStarSystem;
	}

}
