public class Driver {
	public static void main(String[] args) {

		// Creates a model with valid values ( 3<firstname 20 ,  3<lastname<20 , 24<height<84 , 80<weight<280) and prints details
		
		Model myModel1 = new Model("Tim", "Hortons", 68, 139.9, true, false);
		System.out.println("====test for printDetails()====");
		myModel1.printDetails();

		System.out.println("====test for displayModelDetails()====");
		myModel1.displayModelDetails();

		System.out.println("====test for displayModelDetails(boolean unitMetrics)====");
		myModel1.displayModelDetails(false);

		System.out.println();
		System.out.println("***************************************************************");
		//  Creates a model with not valid values and prints details
		Model myModel2 = new Model("Ti", "HortonsHortonsHortons", 12, 300.5, false, true);
		System.out.println("====test for printDetails()====");
		myModel2.printDetails();

		System.out.println("====test for displayModelDetails()====");
		myModel2.displayModelDetails();

		System.out.println("====test for displayModelDetails(boolean unitMetrics)====");
		myModel2.displayModelDetails(false);

	}

}
