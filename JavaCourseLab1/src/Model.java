import java.text.NumberFormat;
import java.util.Locale;

/**
 * Model class creates specified model object. It provides method to print to
 * details of the object model. Also calculates hourly rate for a specified
 * model object.
 * 
 * @author Hunkar Lule
 *
 */
public class Model {
	private String firstName;
	private String lastName;
	private int height;
	private double weight;
	private boolean canTravel;
	private boolean isSmokes;
	private static String occupation = "modelling";

	public static final int INCHES_PER_FOOT = 12;
	public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
	public static final int TALL_INCHES = 67;
	public static final double THIN_POUNDS = 140.0;
	public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
	public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
	public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
	public static final int MIN_HEIGHT = 24;
	public static final int MAX_HEIGHT = 84;
	public static final int MIN_WEIGHT = 80;
	public static final int MAX_WEIGHT = 280;
	public static final double CMS_PER_INCH = 2.54;
	public static final double POUNDS_PER_KG = 2.20;

	/**
	 * Non-arg constructor.
	 */
	public Model() {
	}

	/**
	 * Constructs a new Model with specified firstName, lastName, height, weight,
	 * canTravel and isSmokes arguments.
	 * 
	 * @param firstName
	 *            first name of the model.
	 * @param lastName
	 *            last name of the model.
	 * @param height
	 *            height of the model.
	 * @param weight
	 *            weight of the model.
	 * @param canTravel
	 *            a boolean, shows the model can travel or not.
	 * @param isSmokes
	 *            a boolean, shows the model smokes or not.
	 */
	public Model(String firstName, String lastName, int height, double weight, boolean canTravel, boolean isSmokes) {

		setFirstName(firstName);
		setLastName(lastName);
		setHeight(height);
		setWeight(weight);
		setCanTravel(canTravel);
		setIsSmokes(isSmokes);
	}
	/**
	 * Constructs a new Model with specified firstName, lastName, height, weight.
	 * 
	 * @param firstName
	 *            first name of the model.
	 * @param lastName
	 *            last name of the model.
	 * @param height
	 *            height of the model.
	 * @param weight
	 *            weight of the model.
	 */
	public Model(String firstName, String lastName, int height, double weight) {

		setFirstName(firstName);
		setLastName(lastName);
		setHeight(height);
		setWeight(weight);
		setCanTravel(true);
		setIsSmokes(false);
	}

	/**
	 * Returns first name of the model.
	 * 
	 * @return first name of the model.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name of the model with specified firstName argument if lenght of
	 * specified firstName argument is between 3(inclusive) and 20(inclusive).
	 * 
	 * @param firstName
	 *            first name of the model.
	 */
	public final void setFirstName(String firstName) {
		if (firstName != null && firstName.length() >= 3 && firstName.length() <= 20) {
			this.firstName = firstName;
		}
	}

	/**
	 * Returns last name of the model.
	 * 
	 * @return last name of the model.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name of the model with specified lastName argument if lenght of
	 * specified lastName argument is between 3(inclusive) and 20(inclusive).
	 * 
	 * @param lastName
	 *            last name of the model.
	 */
	public final void setLastName(String lastName) {
		if (lastName != null && lastName.length() >= 3 && lastName.length() <= 20) {
			this.lastName = lastName;
		}
	}

	/**
	 * Returns height of the model.
	 * 
	 * @return height of the model.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns height of the model in feet and inches as a string.
	 * 
	 * @return height of the model in feet and inches as a string.
	 */
	public String getHeightInFeetAndInches() {
		switch (height % INCHES_PER_FOOT) {
		case 0:
			return height / INCHES_PER_FOOT + " feet";
		case 1:
			return height / INCHES_PER_FOOT + " feet " + height % INCHES_PER_FOOT + " inch";
		default:
			return height / INCHES_PER_FOOT + " feet " + height % INCHES_PER_FOOT + " inches";
		}
	}

	/**
	 * Sets height of the model with specified height argument if specified height
	 * argument is between MIN_HEIGHT and MAX_HEIGHT values.
	 * 
	 * @param height
	 *            height of the model
	 */
	public final void setHeight(int height) {
		if (height >= MIN_HEIGHT && height <= MAX_HEIGHT) {
			this.height = height;
		}
	}

	/**
	 * Sets height of the model with specified feet and inches arguments. First
	 * calculates the height using feet and inches arguments.if calculated is
	 * between MIN_HEIGHT and MAX_HEIGHT values then sets this height as model's
	 * height.
	 * 
	 * @param feet
	 *            height of the model
	 * @param inches
	 *            height of the model
	 */
	public final void setHeight(int feet, int inches) {
		int height = INCHES_PER_FOOT * feet + inches;
		setHeight(height);
	}

	/**
	 * Returns weight of the model.
	 * 
	 * @return weight of the model.
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Returns weight of the model in kg.
	 * 
	 * @return weight of the model in kg.
	 */
	public long getWeightKg() {
		return Math.round(weight / POUNDS_PER_KG);
	}

	/**
	 * Sets weight of the model with specified weight argument if specified weight
	 * argument is between MIN_WEIGHT and MAX_WEIGHT values.
	 * 
	 * @param weight
	 *            weight of the model
	 */
	public final void setWeight(double weight) {
		if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT) {
			this.weight = weight;
		}
	}

	/**
	 * Sets weight of the model with specified weight argument. First converts
	 * weight from kg to pounds. Then if specified weight argument is between
	 * MIN_WEIGHT and MAX_WEIGHT values, Sets weight of the model in pounds.
	 * 
	 * @param kilograms
	 *            weight of the model in kg
	 */
	public final void setWeight(long kilograms) {
		double weight = kilograms * POUNDS_PER_KG;
		setWeight(weight);
	}

	/**
	 * Returns the model can travel or not.
	 * 
	 * @return the model can travel or not
	 */
	public boolean getCanTravel() {
		return canTravel;
	}

	/**
	 * Sets travel property of the model.
	 * 
	 * @param canTravel
	 *            a boolean.
	 */
	public final void setCanTravel(boolean canTravel) {
		this.canTravel = canTravel;
	}

	/**
	 * Returns the model smokes or not
	 * 
	 * @return the model smokes or not
	 */
	public boolean getIsSmokes() {
		return isSmokes;
	}

	/**
	 * Sets smoking property of the model.
	 * 
	 * @param isSmokes
	 *            a boolean.
	 */
	public final void setIsSmokes(boolean isSmokes) {
		this.isSmokes = isSmokes;
	}

	/**
	 * Returns occupation of the model.
	 * 
	 * @return occupation of the model.
	 */
	public static String getOccupation() {
		return occupation;
	}

	/**
	 * Calculates and returns the hourly rate for model.
	 * 
	 * @return hourly rate of Model.
	 */
	public int calculatePayDollarsPerHour() {
		int ratePerHour = BASE_RATE_DOLLARS_PER_HOUR;

		if (getHeight() >= TALL_INCHES && getWeight() < THIN_POUNDS) {
			ratePerHour += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
		}
		ratePerHour += (getCanTravel() == true ? TRAVEL_BONUS_DOLLARS_PER_HOUR : 0);
		ratePerHour -= (getIsSmokes() == true ? SMOKER_DEDUCTION_DOLLARS_PER_HOUR : 0);
		return ratePerHour;
	}

	/**
	 * Prints all details of model.
	 */
	public void displayModelDetails() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.CANADA);

		System.out.println("Name: " + getFirstName() + " " + getLastName());
		System.out.println("Height: " + getHeightInFeetAndInches());
		System.out.println("Weight: " + getWeight() + " pounds");
		System.out.println("Travels: " + (getCanTravel() ? "yep" : "nope"));
		System.out.println("Smokes: " + (getIsSmokes() ? "yep" : "nope"));
		System.out.println("Hourly rate: " + fmt.format(calculatePayDollarsPerHour()));
	}

	/**
	 * An overload of displayModelDetails(). Prints the all details of model
	 * according to the parameter provided.
	 * 
	 * @param metricUnits
	 *            a boolean that determines whether details of model will be showed
	 *            in metric units or not.
	 */
	public void displayModelDetails(boolean metricUnits) {
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

		if (!metricUnits) {
			displayModelDetails();
		} else {
			System.out.println("Name: " + getFirstName() + " " + getLastName());
			System.out.println("Height: " + Math.round((getHeight() * CMS_PER_INCH)) + " cm");
			System.out.println("Weight: " + getWeightKg() + " kg");
			System.out.println("Travels: " + (getCanTravel() ? "yep" : "nope"));
			System.out.println("Smokes: " + (getIsSmokes() ? "yep" : "nope"));
			System.out.println("Hourly rate: " + fmt.format(calculatePayDollarsPerHour()));
		}
	}

	/**
	 * Print details of Model.
	 */
	public void printDetails() {
		System.out.println("Name: " + getFirstName() + " " + getLastName());
		System.out.println("Height: " + getHeight() + " inches");
		System.out.println("Weight: " + getWeight() + " pounds");
		System.out.println(getCanTravel() ? "Does travel" : "Does not travel");
		System.out.println(getIsSmokes() ? "Does smoke" : "Does not smoke");
	}

	@Override
	public String toString() {
		return "Model1 [firstName=" + firstName + ", lastName=" + lastName + ", height=" + height + ", weight=" + weight
				+ ", canTravel=" + canTravel + ", isSmokes=" + isSmokes + "]";
	}

}
