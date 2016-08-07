package pl.sylwia.ship.position;

public enum Direction {
	
	
	NORTH(0,"N"),
	EAST(1,"E"),
	SOUTH(2,"S"),
	WEST(3,"W"),
	NONE(4,"X");
	
	private Integer number;
	private String shortcut;
	
	private Direction (Integer number, String shortcut){	
		this.number=number;
		this.shortcut = shortcut;
	}

	public Integer getNumber() {
		return number;
	}	
	
}
