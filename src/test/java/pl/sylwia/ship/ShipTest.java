package pl.sylwia.ship;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;

import pl.sylwia.ship.Ship;
import pl.sylwia.ship.position.Direction;
import pl.sylwia.ship.position.Location;
import pl.sylwia.ship.position.Point;

public class ShipTest {

	private Ship ship;
	private Location location;

	@Before
	public void setUp() {
		// given
		Point point = new Point(0, 0);
		location = new Location(point, Direction.NORTH);
		// when
		ship = new Ship(location);

	}

	@Test
	public void shouldGenerateLocation() {
		// then
		Assertions.assertThat(ship.giveShipLocation()).isEqualTo(location);
	}

	@Test
	public void shouldShipGoForward() {
		// when
		ship.goShipForward(3);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(3);
	}

	@Test
	public void shouldShipGoBack() {
		// when
		ship.goShipBack(5);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(-5);
	}

	@Test
	public void shouldShipTurnLeft() {
		// when
		ship.turnLeft();
		// then
		Assertions.assertThat(ship.giveShipLocation().getDirection()).isEqualTo(Direction.WEST);
	}

	@Test
	public void shouldShipTurnRight() {
		// when
		ship.turnRight();
		// then
		Assertions.assertThat(ship.giveShipLocation().getDirection()).isEqualTo(Direction.EAST);
	}

	@Test
	public void shouldShipMoveUnderCommand() {
		// when
		ship.moveUnderCommand("f");
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(1);
	}

	@Test
	public void shouldShipMoveUnderSequence() {
		String toSplit = "f,r";
		// when
		List<String> split = Splitter.on(",").splitToList(toSplit);
		ship.moveUnderSequence(split);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(1);
		Assertions.assertThat(ship.giveShipLocation().getDirection()).isEqualTo(Direction.EAST);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveForwardN() {
		// when
		ship.goShipForward(51);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(-50);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveForwardE() {
		// when
		ship.turnRight();
		ship.goShipForward(51);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getX()).isEqualTo(-50);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveForwardS() {
		// when
		ship.turnLeft();
		ship.turnLeft();
		ship.goShipForward(70);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(31);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveForwardW() {
		// when
		ship.turnLeft();
		ship.goShipForward(70);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getX()).isEqualTo(31);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveForward() {
		// when
		ship.goShipForward(110);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(9);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveBackN() {
		// when
		ship.goShipBack(70);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(31);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveBackS() {
		// when
		ship.turnLeft();
		ship.turnLeft();
		ship.goShipBack(70);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(-31);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveBackE() {
		// when
		ship.turnRight();
		ship.goShipBack(80);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getX()).isEqualTo(21);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveBackW() {
		// when
		ship.turnLeft();
		ship.goShipBack(80);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getX()).isEqualTo(-21);
	}

	@Test
	public void shouldShipChangeLocationAtTheEdnOfPlanetWhenMoveBack() {
		// when
		ship.goShipBack(110);
		// then
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(-9);
	}
	@Test
	public void shouldShipStopBeforeTheLand(){
		//given
		Point island = new Point(0, 3);
		Map<Point, String> grid = ship.getPlanet().getGrid();
		grid.put(island, "l");
		//when
		ship.goShipForward(5);
		//then 
		Assertions.assertThat(ship.giveShipLocation().getPoint().getY()).isEqualTo(2);
		
		
	}
}
