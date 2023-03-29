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

	/**
	 * This function add new customer to store
	 * @param c new customer
	 */
	public void addCustomerToStore(Customer c) {
		int emptyCellIndex = -1;
		boolean isContainCustomer = false;

		if (customers == null || c == null)
			return;

		for (int i = 0; i < customers.length; i++) {
			if (emptyCellIndex == -1 && customers[i] == null) {
				emptyCellIndex = i;
			}

			if (customers[i] != null && customers[i].equals(c)) {
				isContainCustomer = true;
				break;
			}
		}

		if (!isContainCustomer && emptyCellIndex != -1)
			customers[emptyCellIndex] = c;
	}

	/**
	 * This function add new car to store
	 * @param c - car
	 * @return true if a car added otherwise false
	 * @throws SpecialException the exception in case a car is not ready
	 */
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

	/**
	 * This function removes car from store
	 * @param c - car
	 * @return true if car was removed otherwise false
	 */
	public boolean removeCarFromStore(Car c) {
		if (cars != null && c != null)
			return cars.remove(c);

		return false;
	}

	/**
	 * This function removes customer from store
	 * @param c - customer
	 * @return true if customer removed otherwise false
	 */
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

	/**
	 * The function check if car ready.
	 * @param c - car
	 * @return true if car ready otherwise false
	 */
	public boolean checkIfCarIsReady(Car c) {
		double carPrice = 0;

		if (c != null) {
			try {
				carPrice = c.calcCarPrice();
			} catch (SpecialException e) {
				return false;
			}

			return carPrice != 0;
		}

		return false;
	}

	/**
	 * This function add parts to store
	 * @param i - item
	 * @return true if part successfully added to the store otherwise false
	 */
	public boolean addItemToStore(ItemPart i) {
		if (items != null && i != null && !items.contains(i)) {
			return items.add(i);
		}
		return false;
	}

	public void getCustomersFromTextFile(String fileName) {
		

	}

	/**
	 *
	 * @param licencePlateSerial
	 * @param customerId
	 * @return
	 */
	public boolean addCarToCustomer(String licencePlateSerial,String customerId) {
		boolean isCarAdded = false;
		Car car = getCar(licencePlateSerial);
		Customer customer = getCustomer(customerId);

		if (cars != null && customers != null && car != null && customer != null) {
			isCarAdded = customer.addCarToCustomer(car) && cars.remove(car);

			if (!isCarAdded)
				customer.removeCarFromCustomer(car);
		}

		return isCarAdded;
	}

	// This function find and return car by licence plate
	// Return pointer to car object if it finds otherwise return null.
	private Car getCar(String licencePlateSerial) {
		if (cars != null) {
			for (Car c : cars) {
				if (c.getLicencePlateSerial().equals(licencePlateSerial))
					return c;
			}
		}
		return null;
	}

	// This function find and return customer by customer ID
	// Return pointer to customer object if it finds otherwise return null.
	private Customer getCustomer(String customerId) {
		if (customers != null) {
			for (Customer c : customers) {
				if (c.getIdNumber().equals(customerId))
					return c;
			}
		}
		return null;
	}

	/*-----------------------------------------------Queries----------------------------------------------------*/


	public ArrayList<Car> sortAllCarsByPricesAsc(){
		
	}

	public void saveCarsToCSFileByMonthOfProduction(int month) {

	}

	public String getCustomerPayedMostMoney() throws SpecialException {
		
	}
}
