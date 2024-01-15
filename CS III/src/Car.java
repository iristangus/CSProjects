// Iris T
// CS 3 Summer 2022-2023
// CarInventoryQuiz
// Car objects containing its information
// Car
// 7/27/22

public class Car {
	
	// Information for that car
	private String id;
	private String make;
	private String model;
	private String year;
	private String price;
	
	/*
	 * Constructor that initializes car info
	 * 
	 * @param id	vehicle id
	 * @param make	make of the car
	 * @param model	model of the car
	 * @param year	year it was made
	 * @param price	price of the car
	 */
	public Car(String id, String make, String model, String year, String price) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	/*
	 * Accessor method for vehicle id
	 * 
	 * @return vehicle id
	 */
	public String getid() {
		return this.id;
	}
	
	/*
	 * Accessor method for make
	 * 
	 * @return make of the car
	 */
	public String getmake() {
		return this.make;
	}
	
	/*
	 * Accessor method for model
	 * 
	 * @return model of the car
	 */
	public String getmodel() {
		return this.model;
	}
	
	/*
	 * Accessor method for year
	 * 
	 * @return year the car was made
	 */
	public String getyear() {
		return this.year;
	}
	
	/*
	 * Accessor method for price
	 * 
	 * @return price of the car
	 */
	public String getprice() {
		return this.price;
	}


}
