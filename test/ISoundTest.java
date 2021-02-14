package test;

import java.util.ArrayList;


import model.idemo.ISound;
import model.idemo.Dog;
import model.idemo.Bird;
import model.idemo.Airplane;
import model.idemo.Car;

public class ISoundTest {

	public static void main(String [] args){
		ArrayList<ISound> sounds = new ArrayList<>();

		//Animals
		sounds.add(new Dog(50, 50, "Bulldog", 3, "white"));
		sounds.add(new Bird(100, 100, "Eagle", 5, 10));
		sounds.add(new Dog(150, 150, "Poodle", 3, "brown"));
		sounds.add(new Bird(200, 200, "Sparrow", 1, 2));

		//vehicles
		sounds.add(new Car(4, 10, "Ford", 9000, "Sedan"));
		sounds.add(new Airplane(100, 100, "Boeing", 500000, 350));
		sounds.add(new Car(40, 60, "GM", 8500, "SUV"));
		sounds.add(new Airplane(500, 700, "Airbus", 700000, 250));

		// for(var v: sounds){
		// 	//System.out.println(v.toString());
		// }

		 //Automated testing is always preferrable!!!
		for(var v: sounds){
			String m = v.toString();
			if(v instanceof Dog){
				assert m.contains("Dog");
			}
			else if (v instanceof Bird){
				assert m.contains("Bird");
			}
			else if(v instanceof Car){
				assert m.contains("Car");
			}
			else if (v instanceof Airplane){
				assert m.contains("Airplane");
			}
		}
	}
	
}
