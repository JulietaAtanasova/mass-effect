package gameobjects;

import java.util.HashSet;

import exceptions.InsufficientFuelException;
import exceptions.LocationOutOfRangeException;
import interfaces.*;
import gameobjects.locations.*;

public class Galaxy {
	private HashSet<StarSystem> starSystems;

	public Galaxy() {
		this.starSystems = new HashSet<StarSystem>();
	}

	public HashSet<StarSystem> getStarSystems() {
		return starSystems;
	}

	public void setStarSystems(HashSet<StarSystem> starSystem) {
		this.starSystems = starSystem;
	}

	public StarSystem getStarSystemByName(String name) {
		StarSystem star = this.starSystems.stream().filter(s -> s.getName().equals(name)).findFirst().get();
		return star;
	}

	public void TravelTo(Starship ship, StarSystem destination)
			throws LocationOutOfRangeException, InsufficientFuelException {
		StarSystem startLocation = ship.getLocation();
		if (!startLocation.getNeighbourStarSystem().containsKey(destination)) {
			throw new LocationOutOfRangeException(String.format("Cannot travel directly from %s to %s",
					startLocation.getName(), destination.getName()));
		}

		double requiredFuel = startLocation.getNeighbourStarSystem().get(destination);
		if (ship.getFuel() < requiredFuel) {
			throw new InsufficientFuelException(String.format("Not enough fuel to travel to %s - $s/$s",
					destination.getName(), ship.getFuel(), requiredFuel));
		}
		
		ship.setFuel(ship.getFuel() - requiredFuel);
		ship.setLocation(destination);
	}
}
