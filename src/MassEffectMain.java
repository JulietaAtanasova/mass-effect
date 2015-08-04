import engine.DefaultCommandManager;
import engine.DefaultGameEngine;
import gameobjects.Galaxy;
import gameobjects.locations.StarSystem;
import interfaces.CommandManager;
import interfaces.GameEngine;

public class MassEffectMain {

	public static void main(String[] args) {
		Galaxy galaxy = new Galaxy();
		seedStarSystem(galaxy);

		CommandManager commandManager = new DefaultCommandManager();
		GameEngine gameEngine = new DefaultGameEngine(commandManager, galaxy);
		gameEngine.run();
	}

	public static void seedStarSystem(Galaxy galaxy) {
		StarSystem artemisTau = new StarSystem("Artemis-Tau");
		StarSystem serpentNebula = new StarSystem("Serpent-Nebula");
		StarSystem hadesGamma = new StarSystem("Hades-Gamma");
		StarSystem keplerVerge = new StarSystem("Kepler-Verge");

		galaxy.getStarSystems().add(artemisTau);
		galaxy.getStarSystems().add(serpentNebula);
		galaxy.getStarSystems().add(hadesGamma);
		galaxy.getStarSystems().add(keplerVerge);

		artemisTau.getNeighbourStarSystem().put(serpentNebula, 50.0);
		artemisTau.getNeighbourStarSystem().put(keplerVerge, 120.0);

		serpentNebula.getNeighbourStarSystem().put(artemisTau, 50.0);
		serpentNebula.getNeighbourStarSystem().put(hadesGamma, 360.0);

		hadesGamma.getNeighbourStarSystem().put(serpentNebula, 360.0);
		hadesGamma.getNeighbourStarSystem().put(keplerVerge, 145.0);

		keplerVerge.getNeighbourStarSystem().put(hadesGamma, 145.0);
		keplerVerge.getNeighbourStarSystem().put(artemisTau, 120.0);

	}

}
