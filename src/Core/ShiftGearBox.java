package Core;


import Utilities.E_Color;

public class ShiftGearBox extends ItemPart {
	

	private String type;
	
	public ShiftGearBox(String serialNumber, double price, String manufactureCountry, E_Color color, double weight,
			String type) {
		super(serialNumber, price, manufactureCountry, color, weight);
		this.type = type;
	}

	public ShiftGearBox(String serialNumber) {
		super(serialNumber);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public E_Color getColor() {
		return color;
	}

	public void setColor(E_Color color) {
		this.color = color;
	}
	
	
	
}
