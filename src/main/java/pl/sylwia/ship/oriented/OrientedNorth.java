package pl.sylwia.ship.oriented;

import pl.sylwia.ship.MoveShip;
import pl.sylwia.ship.Ship;
import pl.sylwia.ship.TurnShip;
import pl.sylwia.ship.position.Direction;

public class OrientedNorth implements MoveShip, TurnShip {

	@Override
	public void goShipForwardI(Integer step, Ship ship) {
		for (int i = 0; i < step; i++) {
			Integer nextStep = ship.giveShipLocation().getPoint().getY() + 1;

			if (nextStep > ship.getPlanet().getyMax())
				nextStep = ship.getPlanet().getyMin();

			if (ship.getPlanet().checkIfTheNextStepIsWater(ship.giveShipLocation().getPoint().getX(), nextStep))
				ship.giveShipLocation().getPoint().setY(nextStep);
			else {
				System.out.println("Następna pozycja to ląd.");
				break;
			}
		}

	}

	@Override
	public void goShipBackI(Integer step, Ship ship) {
		for (int i = 0; i < step; i++) {
			Integer nextStep = ship.giveShipLocation().getPoint().getY() - 1;

			if (nextStep < ship.getPlanet().getxMin())
				nextStep = ship.getPlanet().getxMax();

			if (ship.getPlanet().checkIfTheNextStepIsWater(ship.giveShipLocation().getPoint().getX(), nextStep))
				ship.giveShipLocation().getPoint().setY(nextStep);
			else {
				System.out.println("Następna pozycja to ląd.");
				break;
			}
		}

	}

	@Override
	public void turnLeftI(Ship ship) {
		ship.giveShipLocation().setDirection(Direction.WEST);

	}

	@Override
	public void turnRightI(Ship ship) {
		ship.giveShipLocation().setDirection(Direction.EAST);

	}

}
