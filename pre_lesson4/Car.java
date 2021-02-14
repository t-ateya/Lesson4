package pre_lesson4;

public class Car implements Vehicle{

	@Override
	public void printInfo(){
		System.out.println("Print Info method overriden by Car class");
	}

	@Override
	public String transport(int distance){
		String transported = "Car method: Default interface methods has been overriden";
		return transported;
	}
	
}
