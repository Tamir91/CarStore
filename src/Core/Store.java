package Core;

import java.util.ArrayList;

public class Store {

	private String storeName;

	private int storeId;

	private ArrayList<Car> cars;

	private Customer[] customers;

	private ArrayList<ItemPart> items;


	public Store(String storeName, int storeId) {
		this.storeName = storeName;
		this.storeId = storeId;
		this.cars = new ArrayList<>();
		this.customers = new Customer[100];
		this.items=new ArrayList<ItemPart>();

	}

	public String getStoreName() {
		return storeName;
	}


	public ArrayList<ItemPart> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemPart> items) {
		this.items = items;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public ArrayList<Car> getCars() {
		return cars;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}




	/*---------------------------------------------------Methods----------------------------------------------------*/

	public void addCustomerToStore(Customer c) {

	}
	
	public boolean addCarToStore(Car c) throws SpecialException {
		if(c!=null) {
			boolean b = checkIfCarIsReady(c);
			if(!b) {

				throw new SpecialException("Car : "+c.licencePlateSerial +" Isn't Ready , Some Parts Are Missing");
			}
			if(!this.cars.contains(c)) {
				return this.cars.add(c);
			}
			return false;
		}
		return false;
	}

	public boolean removeCarFromStore(Car c) {
	
	}

	public boolean removeCustomerFromStore(Customer c) {
		if(c!=null) {
			for(Customer cust : this.customers) {
				if(cust!=null && cust.equals(c)) {
					if(cust.getCarsBought().size()<=0) {
						cust=null;
						return true;
					}
					else
						return false;
				}
			}
			return false;
		}
		return false;
	}

	public boolean checkIfCarIsReady(Car c) {
	
	}



	public boolean addItemToStore(ItemPart i) {
	
	}

	public void getCustomersFromTextFile(String fileName) {
		

	}


	public boolean addCarToCustomer(String licencePlateSerial,String customerId) {
	
	}

	/*-----------------------------------------------Queries----------------------------------------------------*/


	public ArrayList<Car> sortAllCarsByPricesAsc(){
		
	}

	public void saveCarsToCSFileByMonthOfProduction(int month) {

	}

	public String getCustomerPayedMostMoney() throws SpecialException {
		
	}
}
