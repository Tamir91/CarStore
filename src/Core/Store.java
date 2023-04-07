package Core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

	// This function read customer strings information from file and add customers to store.
	public void getCustomersFromTextFile(String fileName) {
		String line = "";
		BufferedReader inFile = null;
		Path path = Paths.get(fileName);

		if (Files.exists(path)) {
			File f = new File(fileName);

			if (f.isFile() && customers != null) {
				try {
					inFile = new BufferedReader(new FileReader(fileName));
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}

				while (true) {
					try {
						if ((line = inFile.readLine()) == null) break;
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					addCustomerToStore(createCustomerFromString(line));
				}
			}
		}
	}

	// This function building and returned customer object from string.
	private Customer createCustomerFromString(String str) {
		String id, firstName, lastName, city, email;
		StringTokenizer st;

		st = new StringTokenizer(str);

		if (st.hasMoreTokens())
			id = st.nextToken();
		else
			id = "NOT_ID";

		if (st.hasMoreTokens())
			firstName = st.nextToken();
		else
			firstName = "NOT_FIRST_NAME";

		if (st.hasMoreTokens())
			lastName = st.nextToken();
		else
			lastName = "NOT_LAST_NAME";

		if (st.hasMoreTokens())
			city = st.nextToken();
		else
			city = "NOT_CITY";

		if (st.hasMoreTokens())
			email = st.nextToken();
		else
			email = "NOT_EMAIL";

		return new Customer(id, firstName, lastName, city, email);
	}

	/**
	 * This function add car to customer and remove it from store
	 * @param licencePlateSerial - car licence plate number
	 * @param customerId - customer ID
	 * @return true if car was added otherwise false
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

	/**
	 * This function write sorted cars by they price into file
	 * @return new sorted list of cars
	 */
	public ArrayList<Car> sortAllCarsByPricesAsc(){
		ArrayList<Car> sortedCars = null;

		if (cars != null) {
			sortedCars = new ArrayList<>(cars);

			Collections.sort(sortedCars);
		}

		writeCarsToFile(sortedCars, "qry.txt");
		return sortedCars;
	}

	private void writeCarsToFile(ArrayList<Car> cars, String fileName) {
		Formatter formatter;

		formatter = openFile(fileName);
		writeArrayList(formatter, cars);
		closeFile(formatter);
	}

	// This function open file for writing.
	private Formatter openFile(String fileName) {
		Formatter formatter = null;

		try {
			formatter = new Formatter(fileName);
		} catch (SecurityException e) {
			System.out.println("Permission denied.");
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file.");
			System.exit(1);
		}

		return formatter;
	}

	// This function write formatted data to file.
	private void writeArrayList(Formatter output, ArrayList<Car> cars) {
		if (cars != null && output != null) {
			for (Car c : cars) {
				try {

					String format = """
							Licence Plate : %s
							Car Model : %s
							Sub Model : %s
							color : %s
							Manufacture Country : %s
							Model Year : %d
							Car Length : %.2f
							Car Weight : %.2f
							Max Seats : %d,
							Wheels Air Volume : %.2f
							
							""";
					output.format(format,
							c.getLicencePlateSerial(),
							c.getCarModel(),
							c.getSubModel(),
							c.getColor(),
							c.getManufactureCountry(),
							c.getModelYear(),
							c.getCarLength(),
							c.getCarWeight(),
							c.getMaxSeats(),
							c.getWheelsAirVolume());

				} catch (FormatterClosedException e) {
					System.err.println(e.getMessage());
					break;
				}
			}
		}
	}

	private void closeFile(Formatter f) {
		if (f != null)
			f.close();
	}

	/**
	 * This function save cars to file that manufactured in specific month
	 * @param month of manufacture
	 */
	public void saveCarsToCSFileByMonthOfProduction(int month) {
		ArrayList<Car> carsInMonth = new ArrayList<>();
		int carMonth;

		if (cars != null && 1 <= month && month <= 12 ) {
			for (Car c : cars) {

				carMonth = c.getManufactureDate().getMonth() + 1;
				// getMonth() returned number in range from 0 to 11, so we need + 1.
				if (c.getManufactureDate() != null && carMonth == month) {
					carsInMonth.add(c);
				}
			}
		}

		writeToFile(carsInMonth, "save.bin");
	}

	// This function write cars to binary file.
	private void writeToFile(ArrayList<Car> cars, String fileName) {
		ObjectOutputStream out = openBinaryFileToWrite(fileName);

		if (out != null && cars != null) {
			for (Car c : cars) {
				if (c != null) {
					try {
						out.writeObject(c);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}

		closeBinaryFile(out);
	}

	// This function return pointer to writable binary file.
	private ObjectOutputStream openBinaryFileToWrite(String fileName) {
		FileOutputStream fileOutputStream;
		ObjectOutputStream out;

		try {
			fileOutputStream = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fileOutputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return out;
	}

	// This function close file.
	private void closeBinaryFile(ObjectOutputStream stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 *
	 * @return
	 */
	public String getCustomerPayedMostMoney() {
		Customer customerPayedMostMoney = null;
		double tempPriceOfAllCars = 0.;
		double maxPriceOfAllCars = 0.;

		if (customers != null) {
			for (Customer c : customers) {
				if (c != null) {
					tempPriceOfAllCars = getTotalPriceOfCars(c);

					if (tempPriceOfAllCars > maxPriceOfAllCars) {
						maxPriceOfAllCars = tempPriceOfAllCars;
						customerPayedMostMoney = c;
					}
				}
			}
		}

		if (customerPayedMostMoney != null)
			return customerPayedMostMoney + "\n" +
					"Number Of Cars : " + customerPayedMostMoney.getCarsBought().size() + "\n" +
					"Cars Price : " + maxPriceOfAllCars;
		else
			return "Not found a customer Payed Most Money";
	}

	// This function return total price of all customer cars.
	private double getTotalPriceOfCars(Customer c) {
		double priceOfAllCars = 0.;
		HashSet<Car> cars;

		if (c != null) {
			cars = c.getCarsBought();

			if (cars == null)
				return priceOfAllCars;

			for (Car car : cars) {
				if (car != null) {
					try {
						priceOfAllCars += car.calcCarPrice();
					} catch (SpecialException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}

		return priceOfAllCars;
	}
}
