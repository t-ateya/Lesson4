package pre_lesson4;

public class Main {

	public static void main(String [] args){
		Car car = new Car();
		SUV suv = new SUV();
		car.printInfo();	
		System.out.println(car.transport(10));	//Default method
		Vehicle.move();		//Static interface method

		//Instance of operator
		//Usage: 
		System.out.println("suv instanceof Car: "+(suv instanceof Car));
	}
	
}
