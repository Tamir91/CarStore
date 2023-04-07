package Core;

import java.io.Serializable;
import java.util.Objects;

import Utilities.E_Color;

public abstract class ItemPart implements Serializable {

	protected String serialNumber;
	
	protected double price;
	
	protected String manufactureCountry;
	
	protected E_Color color;
	
	protected double weight;

	public ItemPart(String serialNumber, double price, String manufactureCountry, E_Color color, double weight) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.manufactureCountry = manufactureCountry;
		this.color = color;
		this.weight = weight;
	}

	public ItemPart(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serialNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPart other = (ItemPart) obj;
		return Objects.equals(serialNumber, other.serialNumber);
	}

	@Override
	public String toString() {
		return "ItemPart [serialNumber=" + serialNumber + ", price=" + price + ", manufactureCountry="
				+ manufactureCountry + ", color=" + color + ", weight=" + weight + "]";
	}
}
