package engine.factories;

import gameobjects.locations.StarSystem;
import gameobjects.ships.DefaultStarship;
import gameobjects.ships.StarshipType;
import interfaces.Starship;

public class ShipFactory {
	public Starship create(StarshipType type, String name, StarSystem location) throws UnsupportedOperationException {
		switch (type) {
		case Frigate:
			return new DefaultStarship(type, name, 60, 50, 30, 220, location);
		case Cruiser:
			return new DefaultStarship(type, name, 100, 100, 50, 300, location);
		case Dreadnought:
			return new DefaultStarship(type, name, 200, 300, 150, 700, location);
		default:
			throw new UnsupportedOperationException("Starship type not supported.");
		}
	}
}
