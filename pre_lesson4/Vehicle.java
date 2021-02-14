package pre_lesson4;

public interface Vehicle{

	int ID = 4;  //all constants are final by default

	void printInfo();

	static void move(){
		System.out.println("Car has been moved!");
	}

	//Default methods do not have to overriden by 
	//classes that implement the interface
	default String transport(int distance){
		String transported = "Interface Method: Transported by "+distance+" miles";
		return transported;
	}
}