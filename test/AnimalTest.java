package test;

import java.util.ArrayList;

import model.idemo.Dog;
import model.idemo.Bird;
import model.idemo.Animal;

public class AnimalTest {
	
	public static void main(String [] args){
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Dog(50, 50, "Bulldog", 3, "white"));
		animals.add(new Bird(100, 100, "Eagle", 5, 10));
		animals.add(new Dog(150, 150, "Poodle", 3, "brown"));
		animals.add(new Bird(200, 200, "Sparrow", 1, 2));

		// for(var v: animals){
		// 	//System.out.println(v.toString());
		// }

		 //Automated testing is always preferrable!!!
		for(var v: animals){
			String m = v.toString();
			if(v instanceof Dog){
				assert m.contains("Dog");
			}
			else if (v instanceof Bird){
				assert m.contains("Bird");
			}
		}
	}
}
