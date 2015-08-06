package engine.commands;

import engine.Messages;
import gameobjects.ships.DefaultStarship;
import interfaces.GameEngine;
import interfaces.Projectile;
import interfaces.Starship;

public class AttackCommand extends Command {

	public AttackCommand(GameEngine gameEngine) {
		super(gameEngine);
	}

	@Override
	public void Execute(String[] commandArgs) {
		super.Execute(commandArgs);
		String attackerShipName = commandArgs[1];
		String targetShipName = commandArgs[2];

		if (!super.isShipInStarSystem(targetShipName)) {
			System.out.println(Messages.NO_SUCH_SHIP_IN_STAR_SYSTEM);
			return;
		}

		DefaultStarship attackerShip = (DefaultStarship) getStarshipByName(attackerShipName);
		DefaultStarship targetShip = (DefaultStarship) getStarshipByName(targetShipName);
		if (!attackerShip.isIntact() || !targetShip.isIntact()) {
			System.out.println(Messages.SHIP_ALREADY_DESTROYED);
			return;
		}

		System.out.println(String.format(Messages.SHIP_ATTACKED, attackerShip.getName(), targetShip.getName()));
		Projectile projectile = attackerShip.produceAttack();
		targetShip.respondAttack(projectile);

		if (targetShip.getHealth() == 0) {
			System.out.println(String.format(Messages.SHIP_DESTROYED, targetShipName));
		}
	}

}
