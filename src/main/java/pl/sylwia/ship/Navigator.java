package pl.sylwia.ship;

import pl.sylwia.ship.oriented.OrientedEast;
import pl.sylwia.ship.oriented.OrientedNorth;
import pl.sylwia.ship.oriented.OrientedSouth;
import pl.sylwia.ship.oriented.OrientedWest;
import pl.sylwia.ship.position.Location;

public class Navigator {

	public MoveShip getMoveStrategy(Location location) {

		return checkOriented(location);

	}
	
	public TurnShip getTurnStrategy(Location location) {

		return checkOriented(location);

	}

	private <T> T checkOriented(Location location) {
		switch (location.getDirection()) {
		case NORTH:
			return (T) new OrientedNorth();
		case SOUTH:
			return (T) new OrientedSouth();
		case EAST:
			return (T) new OrientedEast();
		case WEST:
			return (T) new OrientedWest();
		default:
			return null;
		}
	}
}
