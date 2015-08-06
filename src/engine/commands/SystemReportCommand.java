package engine.commands;

import java.util.List;
import java.util.stream.Collectors;

import gameobjects.locations.StarSystem;
import interfaces.GameEngine;
import interfaces.Starship;

public class SystemReportCommand extends Command {

	public SystemReportCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		
		String starSystemName = commandArgs[1];
		StarSystem starSystem = this.getGameEngine().getGalaxy().getStarSystemByName(starSystemName);
		
		List<Starship> starSystemShips = getGameEngine().getStarships().stream()
				.filter(s -> s.getLocation().getName().equals(starSystem.getName()))
				.collect(Collectors.toList());;
		
		List<Starship> intactShips = starSystemShips.stream().filter(s -> s.getHealth() > 0)
				.sorted((a, b) -> b.getHealth() - a.getHealth()).sorted((a, b) -> b.getShields() - a.getShields())
				.collect(Collectors.toList());
		List<Starship> destroyedShips = starSystemShips.stream().filter(s -> s.getHealth() == 0)
				.sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
		
		System.out.println("Intact ships:");
		if(intactShips.size() > 0){
			intactShips.stream().forEach(s -> System.out.println(s));
		} else {
			System.out.println("N/A");
		}
		
		System.out.println("Destroyed ships:");
		if(destroyedShips.size() > 0){
			destroyedShips.stream().forEach(s -> System.out.println(s));
		} else {
			System.out.println("N/A");
		}
	}

}
