package Core;


import Utilities.E_Color;
import Utilities.E_EngineType;

public class Engine extends ItemPart {


	private E_EngineType engineType;

	private double engineVolume;

	private boolean isTurboEngine;

	public Engine(String serialNumber, double price, String manufactureCountry, E_Color color, double weight,
			E_EngineType engineType, double engineVolume, boolean isTurboEngine) {
		super(serialNumber, price, manufactureCountry, color, weight);
		this.engineType = engineType;
		this.engineVolume = engineVolume;
		this.isTurboEngine = isTurboEngine;
	}

	
	public Engine(String serialNumber) {
		super(serialNumber);
	}


	public E_EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(E_EngineType engineType) {
		this.engineType = engineType;
	}

	public double getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(double engineVolume) {
		this.engineVolume = engineVolume;
	}

	public boolean isTurboEngine() {
		return isTurboEngine;
	}

	public void setTurboEngine(boolean isTurboEngine) {
		this.isTurboEngine = isTurboEngine;
	}



}
