package pl.sylwia.ship.position;

import java.util.HashMap;
import java.util.Map;

public class Planet {

	private Integer yMax;
	private Integer yMin;
	private Integer xMax;
	private Integer xMin;
	private Map<Point, String> grid;

	public Planet(Integer xMin, Integer xMax, Integer yMin, Integer yMax) {
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;

		fillTheGridWithWater(xMin, xMax, yMin, yMax);

	}

	private void fillTheGridWithWater(Integer xMin, Integer xMax, Integer yMin, Integer yMax) {
		grid = new HashMap<>();

		for (int i = xMin; i <= xMax; i++) {
			for (int j = yMin; j <= yMax; j++)
				grid.put(new Point(i, j), "w");
		}
	}

	public boolean checkIfTheNextStepIsWater(Integer x, Integer y) {
		Point point = new Point(x, y);
		return grid.get(point) == "w";
			
	}

	public Integer getyMax() {
		return yMax;
	}

	public Integer getyMin() {
		return yMin;
	}

	public Integer getxMax() {
		return xMax;
	}

	public Integer getxMin() {
		return xMin;
	}

	public Map<Point, String> getGrid() {
		return grid;
	}
}
