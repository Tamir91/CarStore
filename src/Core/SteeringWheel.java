package Core;

import Utilities.E_Color;

public class SteeringWheel extends ItemPart{


	
	public SteeringWheel(String serialNumber, double price, String manufactureCountry, E_Color color, double weight,
			double diameter, double width, String coverType) {
		super(serialNumber, price, manufactureCountry, color, weight);
		this.coverType = coverType;
	}
	
	public SteeringWheel(String serialNumber) {
		super(serialNumber);
	}
	
	public String coverType;

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}
	
	
	
}
