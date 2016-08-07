package pl.sylwia.ship;

import java.util.List;

import pl.sylwia.ship.position.Location;
import pl.sylwia.ship.position.Planet;

public class Ship {

	private Location location;
	private Planet planet = new Planet(-50, 50, -50, 50);
	private Navigator navigator = new Navigator();

	private Integer yMax = planet.getyMax();
	private Integer xMax = planet.getxMax();
	private Integer yMin = planet.getyMin();
	private Integer xMin = planet.getxMin();

	public Ship(Location location) {
		this.location = location; // do tworzonego obiektu this, do jego pola
									// location przypisuje nowa wartosc location
		if (location.getPoint().getY() > yMax)
			throw new RuntimeException("Y poza zakresem.");
		if (location.getPoint().getX() > xMax)
			throw new RuntimeException("X poza zakresem");
		if (location.getPoint().getY() < yMin)
			throw new RuntimeException("Y poza zakresem.");
		if (location.getPoint().getX() < xMin)
			throw new RuntimeException("X poza zakresem");
	}

	public Location giveShipLocation() {
		return location;
	}

	public void goShipForward(Integer step) {
		MoveShip moveStrategy = navigator.getMoveStrategy(location);
		moveStrategy.goShipForwardI(step, this);
	}

	public void goShipBack(Integer step) {
		MoveShip moveShip = navigator.getMoveStrategy(location);
		moveShip.goShipBackI(step, this);

	}

	public void turnLeft() {
		TurnShip turnStrategy = navigator.getTurnStrategy(location);
		turnStrategy.turnLeftI(this);

	}

	public Planet getPlanet() {
		return planet;
	}

	public void turnRight() {
		 TurnShip turnStrategy = navigator.getTurnStrategy(location);
		 turnStrategy.turnRightI(this);
	}

	public void moveUnderCommand(String command) {
		switch (command) {
		case "f":
			goShipForward(1);
			break;
		case "b":
			goShipBack(1);
			break;
		case "l":
			turnLeft();
			break;
		case "r":
			turnRight();
			break;
		default:
			break;
		}

	}

	public void moveUnderSequence(List<String> split) {
		for (String string : split) {
			moveUnderCommand(string);
		}

	}

}
