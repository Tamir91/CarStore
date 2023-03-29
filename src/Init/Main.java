package Init;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import Core.*;
import Utilities.E_CarModel;
import Utilities.E_Color;
import Utilities.E_EngineType;


public class Main {


	public static void main(String[] args) throws IOException, ParseException,ClassNotFoundException, SpecialException {
	

		// the command read from the input file 
		String command;



		// to check if the command updated the objects 
		boolean isUpdated;

		// writer buffer creation used after update 
		MyFileLogWriter.initializeMyFileWriter();

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));

		// the fly Object	
		Store store = null;

		// create Scanner for the text file named "input.txt" 
		Scanner input = new Scanner(new File("input.txt"));

		// if the file has next - not empty 
		if (input.hasNext()) {
			store = new Store("Store",1);			
		}
		store.getCustomersFromTextFile("customersInput.txt");

		/*
		 *  read the commands. loop while input file [input.hasnext()]
		 * and the fly is not null 
		 */
		while (input.hasNext() && store != null) {

			/* 
			 * read the command, must be first at line because command value 
			 * determine which method will be activated in JEuroTournament object.
			 */
			command = input.next();
			isUpdated = false;

			// ================				Command			================
			if (command.equals("addRegularCar")) {

				String licencePlateSerial=input.next();
				E_CarModel carModel=E_CarModel.valueOf(input.next());
				String subModel=input.next();
				E_Color color=E_Color.valueOf(input.next());
				Date manufactureDate=df.parse(input.next());
				String manufactureCountry=input.next();
				int modelYear=input.nextInt();
				double carLength=input.nextDouble();
				double carWeight=input.nextDouble();
				int maxSeats=input.nextInt();
				double wheelsAirVolume=input.nextDouble();
				String engineNum = input.next();
				String shiftGearNum = input.next();
				String steeringWheel = input.next();
				String wheelNum1 = input.next();
				String wheelNum2 = input.next();
				String wheelNum3 = input.next();
				String wheelNum4 = input.next();
				Engine engine = new Engine(engineNum);
				int engineInd = store.getItems().indexOf(engine);
				ShiftGearBox shift = new ShiftGearBox(shiftGearNum);
				int shiftInd = store.getItems().indexOf(shift);
				SteeringWheel steeringWheelItem = new SteeringWheel(steeringWheel);
				int steeringWheelInd = store.getItems().indexOf(steeringWheelItem);
				Wheel w1  = new Wheel(wheelNum1);
				int wheelInd1 = store.getItems().indexOf(w1);
				Wheel w2  = new Wheel(wheelNum2);
				int wheelInd2 = store.getItems().indexOf(w2);
				Wheel w3  = new Wheel(wheelNum3);
				int wheelInd3 = store.getItems().indexOf(w3);
				Wheel w4  = new Wheel(wheelNum4);
				int wheelInd4 = store.getItems().indexOf(w4);



				RegularCar rc = new RegularCar(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength, carWeight, maxSeats, wheelsAirVolume);
				if(engineInd!=-1)
					rc.addItemToCar(store.getItems().get(engineInd));
				if(shiftInd!=-1)
					rc.addItemToCar(store.getItems().get(shiftInd));
				if(steeringWheelInd!=-1)
					rc.addItemToCar(store.getItems().get(steeringWheelInd));
				if(wheelInd1!=-1)
					rc.addItemToCar(store.getItems().get(wheelInd1));
				if(wheelInd2!=-1)
					rc.addItemToCar(store.getItems().get(wheelInd2));
				if(wheelInd3!=-1)
					rc.addItemToCar(store.getItems().get(wheelInd3));
				if(wheelInd4!=-1)
					rc.addItemToCar(store.getItems().get(wheelInd4));

				try {
					isUpdated = store.addCarToStore(rc);
				} catch (SpecialException e) {
					System.out.println(e.getMessage());
				}

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Regular Car returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Regular Car " + licencePlateSerial
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Regular Car " + licencePlateSerial
							+ " to System");
				}

			}
			
			// ================				Command			================
			if (command.equals("addMiniCar")) {

				String licencePlateSerial=input.next();
				E_CarModel carModel=E_CarModel.valueOf(input.next());
				String subModel=input.next();
				E_Color color=E_Color.valueOf(input.next());
				Date manufactureDate=df.parse(input.next());
				String manufactureCountry=input.next();
				int modelYear=input.nextInt();
				double carLength=input.nextDouble();
				double carWeight=input.nextDouble();
				int maxSeats=input.nextInt();
				double wheelsAirVolume=input.nextDouble();
				String type = input.next();
				String engineNum = input.next();
				String shiftGearNum = input.next();
				String steeringWheel = input.next();
				String wheelNum1 = input.next();
				String wheelNum2 = input.next();
				String wheelNum3 = input.next();
				String wheelNum4 = input.next();
				Engine engine = new Engine(engineNum);
				int engineInd = store.getItems().indexOf(engine);
				ShiftGearBox shift = new ShiftGearBox(shiftGearNum);
				int shiftInd = store.getItems().indexOf(shift);
				SteeringWheel steeringWheelItem = new SteeringWheel(steeringWheel);
				int steeringWheelInd = store.getItems().indexOf(steeringWheelItem);
				Wheel w1  = new Wheel(wheelNum1);
				int wheelInd1 = store.getItems().indexOf(w1);
				Wheel w2  = new Wheel(wheelNum2);
				int wheelInd2 = store.getItems().indexOf(w2);
				Wheel w3  = new Wheel(wheelNum3);
				int wheelInd3 = store.getItems().indexOf(w3);
				Wheel w4  = new Wheel(wheelNum4);
				int wheelInd4 = store.getItems().indexOf(w4);
				
				MiniCar mc = new MiniCar(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength, carWeight, maxSeats, wheelsAirVolume,type);
				if(engineInd!=-1)
					mc.addItemToCar(store.getItems().get(engineInd));
				if(shiftInd!=-1)
					mc.addItemToCar(store.getItems().get(shiftInd));
				if(steeringWheelInd!=-1)
					mc.addItemToCar(store.getItems().get(steeringWheelInd));
				if(wheelInd1!=-1)
					mc.addItemToCar(store.getItems().get(wheelInd1));
				if(wheelInd2!=-1)
					mc.addItemToCar(store.getItems().get(wheelInd2));
				if(wheelInd3!=-1)
					mc.addItemToCar(store.getItems().get(wheelInd3));
				if(wheelInd4!=-1)
					mc.addItemToCar(store.getItems().get(wheelInd4));

				try {
					isUpdated = store.addCarToStore(mc);
				} catch (SpecialException e) {
					System.out.println(e.getMessage());
				}

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Mini Car Returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Mini Car " + licencePlateSerial
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add  new Mini Car " + licencePlateSerial
							+ " to System");
				}

			}

			
			// ================				Command			================
			if (command.equals("addSportCar")) {
				String licencePlateSerial=input.next();
				E_CarModel carModel=E_CarModel.valueOf(input.next());
				String subModel=input.next();
				E_Color color=E_Color.valueOf(input.next());
				Date manufactureDate=df.parse(input.next());
				String manufactureCountry=input.next();
				int modelYear=input.nextInt();
				double carLength=input.nextDouble();
				double carWeight=input.nextDouble();
				int maxSeats=input.nextInt();
				double wheelsAirVolume=input.nextDouble();
				boolean isFastCar=false;
				boolean isConvertible=false;
				boolean is4or2doors=false ;
				int fast=input.nextInt();
				int convertible = input.nextInt();
				int dooris4or2 = input.nextInt();
				if(fast!=0)
					isFastCar=true;
				if(convertible!=0)
					isConvertible=true;
				if(dooris4or2!=0)
					is4or2doors=true;
				
				String engineNum = input.next();
				String shiftGearNum = input.next();
				String steeringWheel = input.next();
				String wheelNum1 = input.next();
				String wheelNum2 = input.next();
				String wheelNum3 = input.next();
				String wheelNum4 = input.next();
				Engine engine = new Engine(engineNum);
				int engineInd = store.getItems().indexOf(engine);
				ShiftGearBox shift = new ShiftGearBox(shiftGearNum);
				int shiftInd = store.getItems().indexOf(shift);
				SteeringWheel steeringWheelItem = new SteeringWheel(steeringWheel);
				int steeringWheelInd = store.getItems().indexOf(steeringWheelItem);
				Wheel w1  = new Wheel(wheelNum1);
				int wheelInd1 = store.getItems().indexOf(w1);
				Wheel w2  = new Wheel(wheelNum2);
				int wheelInd2 = store.getItems().indexOf(w2);
				Wheel w3  = new Wheel(wheelNum3);
				int wheelInd3 = store.getItems().indexOf(w3);
				Wheel w4  = new Wheel(wheelNum4);
				int wheelInd4 = store.getItems().indexOf(w4);
				
				SportCar sc = new SportCar(licencePlateSerial, carModel, subModel, color, manufactureDate, manufactureCountry, modelYear, carLength, carWeight, maxSeats, wheelsAirVolume, isFastCar, isConvertible, is4or2doors);
				if(engineInd!=-1)
					sc.addItemToCar(store.getItems().get(engineInd));
				if(shiftInd!=-1)
					sc.addItemToCar(store.getItems().get(shiftInd));
				if(steeringWheelInd!=-1)
					sc.addItemToCar(store.getItems().get(steeringWheelInd));
				if(wheelInd1!=-1)
					sc.addItemToCar(store.getItems().get(wheelInd1));
				if(wheelInd2!=-1)
					sc.addItemToCar(store.getItems().get(wheelInd2));
				if(wheelInd3!=-1)
					sc.addItemToCar(store.getItems().get(wheelInd3));
				if(wheelInd4!=-1)
					sc.addItemToCar(store.getItems().get(wheelInd4));

				try {
					isUpdated = store.addCarToStore(sc);
				} catch (SpecialException e) {
					System.out.println(e.getMessage());
				}

				MyFileLogWriter
				.writeToFileInSeparateLine("add Sport Car returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Sport Car " + licencePlateSerial
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Sport Car " + licencePlateSerial
							+ " to System");
				}

			}
			
			// ================				Command			================
			if (command.equals("addEngine")) {
				String serialNumber=input.next();
				double price=input.nextDouble();
				String manufactureCountry=input.next();
				E_Color color=E_Color.valueOf(input.next());
				double weight=input.nextDouble();
				E_EngineType engineType =E_EngineType.valueOf(input.next());
				double engineVolume=input.nextDouble();
				int num = input.nextInt();
				boolean isTurboEngine=false;

				if(num==1)
					isTurboEngine=true;

				Engine e = new Engine(serialNumber, price, manufactureCountry, color, weight, engineType, engineVolume, isTurboEngine);
				isUpdated = store.addItemToStore(e);

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Engine To System Returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Engine " + serialNumber
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Engine " + serialNumber
							+ " to System");
				}

			}

			// ================				Command			================
			if (command.equals("addShiftGear")) {

				String serialNumber=input.next();
				double price=input.nextDouble();
				String manufactureCountry=input.next();
				E_Color color=E_Color.valueOf(input.next());
				double weight=input.nextDouble();
				String type = input.next();

				ShiftGearBox e = new ShiftGearBox(serialNumber, price, manufactureCountry, color, weight, type);
				isUpdated = store.addItemToStore(e);

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Shift Gear Box To System Returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Shift Gear Box " + serialNumber
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Shift Gear Box " + serialNumber
							+ " to System");
				}

			}

			// ================				Command			================
			if (command.equals("addSteeringWheel")) {

				String serialNumber=input.next();
				double price=input.nextDouble();
				String manufactureCountry=input.next();
				E_Color color=E_Color.valueOf(input.next());
				double weight=input.nextDouble();
				String coverType = input.next();

				SteeringWheel e = new SteeringWheel(serialNumber, price, manufactureCountry, color, weight, price, weight, coverType);
				isUpdated = store.addItemToStore(e);

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Steering Wheel To System Returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Steering Wheel " + serialNumber
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Steering Wheel " + serialNumber
							+ " to System");
				}

			}

			// ================				Command			================
			if (command.equals("addWheel")) {

				String serialNumber=input.next();
				double price=input.nextDouble();
				String manufactureCountry=input.next();
				E_Color color=E_Color.valueOf(input.next());
				double weight=input.nextDouble();
				double diameter=input.nextDouble();
				double width=input.nextDouble();

				Wheel e = new Wheel(serialNumber, price, manufactureCountry, color, weight, diameter, width);
				isUpdated = store.addItemToStore(e);

				MyFileLogWriter
				.writeToFileInSeparateLine("Add Wheel To System Returns:");

				if (isUpdated) { // if adding successfully, then true returned,
					// the following message is written to the output file
					MyFileLogWriter
					.writeToFileInSeparateLine("\tSuccessfully added Wheel " + serialNumber
							+ " to System");
				} else {
					MyFileLogWriter
					.writeToFileInSeparateLine("\tFailed to add new Wheel " + serialNumber
							+ " to System");
				}

			}
		
		
		// ================				Command			================
		if (command.equals("addCarToCustomer")) {
			String customerId=input.next();

			String licencePlateSerial=input.next();
			isUpdated = store.addCarToCustomer(licencePlateSerial, customerId);
		
			MyFileLogWriter
			.writeToFileInSeparateLine("Added Car : "+licencePlateSerial+ " To Customer : "+customerId +" Returnes : ");

			if (isUpdated) { // if adding successfully, then true returned,
				// the following message is written to the output file
				MyFileLogWriter
				.writeToFileInSeparateLine("\tSuccessfully added Car " + licencePlateSerial
						+ " to Customer : "+customerId);
			} else {
				MyFileLogWriter
				.writeToFileInSeparateLine("\tFailed to add new Car To Customer " + customerId);
			}

		}
	
		}
		Car c1 = store.getCars().get(0);
		Car c2=c1;
		
		boolean b = store.removeCarFromStore(c1);
		if(b)
			System.out.println("Successfully Removed Car : "+c1.getLicencePlateSerial()+" from system");
		else
			System.out.println("Failed To Remove Car : "+c1.getLicencePlateSerial()+" from system");

		b = store.removeCarFromStore(c2);
		if(b)
			System.out.println("Successfully Removed Car : "+c2.getLicencePlateSerial()+" from system");
		else
			System.out.println("Failed To Remove Car : "+c2.getLicencePlateSerial()+" from system => Car Not Exist In System");

					
		
		System.out.println("Cars Sorted By Car's Price Asc : ");
		
		ArrayList<Car> carsToPrint2 = store.sortAllCarsByPricesAsc();
		for(Car c : carsToPrint2) {
			System.out.println(c.getCarModel()+" "+c.getLicencePlateSerial()+" "+c.calcCarPrice());
		}
		System.out.println();
		store.saveCarsToCSFileByMonthOfProduction(10);
		
		System.out.println("Customer That Payed Most Money For Cars : ");
		System.out.println(store.getCustomerPayedMostMoney());
		System.out.println();

		int i=0,j=0;
		
		for(Car c : store.getCars()) {
			
			if(i==0 && c instanceof RegularCar) {
				RegularCar rc = (RegularCar) c;
				System.out.println(rc.toString());
				System.out.println("Cost For Moving To Store ? : "+rc.calcCarCostForMovingToStore());
				System.out.println("Trade ? : "+rc.carForTrade());
				System.out.println("Trailer Is Availiable ? : "+rc.checkIfTrailerIsAvailiable());
				System.out.println();
				i++;

			}
			else if(j==0 && c instanceof MiniCar) {
				MiniCar mc = (MiniCar) c;
				System.out.println(mc.toString());
				System.out.println("Cost For Moving To Store ? : "+mc.calcCarCostForMovingToStore());
				System.out.println("Trade ? : "+mc.carForTrade());
				System.out.println("Trailer Is Availiable ? : "+mc.checkIfTrailerIsAvailiable());
				System.out.println();
				j++;
			}
		}
		System.out.println();
		MyFileLogWriter.saveLogFile(); // save the output file
		input.close(); // close connection to input file
		System.out.println("[End Of process]");
		System.out.println("\n NOTICE:\n\t\"End of process\" " +
				"does NOT mean that all your methods are correct.\n" +
				"\n==>\t You NEED to check the \"output.txt\" file");



	}



}
