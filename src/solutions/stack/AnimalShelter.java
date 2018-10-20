package solutions.stack;

import javax.management.openmbean.InvalidKeyException;
import javax.sound.midi.SysexMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by neaGaze on 9/30/18.
 *
 * (D, 1), (D, 2), (C, 1), (D, 3)
 *
 * firstCat = (C, 1)
 * firstDog = (D, 1)
 * first = (D, 1)
 *
 */
public class AnimalShelter {
	public static abstract class Animal {
	    String name;
	    int order, id;

	    public Animal(String name, int id) {
	        this.id = id;
	        this.name = name;
        }
    }

    public static class Dog extends Animal {
	    public Dog(int id) {
	        super("Dog", id);
        }
    }

    public static class Cat extends Animal {
        public Cat(int id) {
            super("Cat", id);
        }
    }

    Queue<Animal> dog, cat;
	int order;

	public AnimalShelter() {
	    this.dog = new LinkedList<Animal>();
        this.cat = new LinkedList<Animal>();
    }

    public void enqueue(Animal animal) {
	    if(animal.name.equals("Dog"))
	        dog.add(animal);
	    else if(animal.name.equals("Cat"))
	        cat.add(animal);
	    else throw new ArrayIndexOutOfBoundsException("Invalid name of animals");
	    animal.order = order++;
        System.out.println("Adding animal "+animal.name+" id:" + animal.id+" order: "+animal.order);
    }

    public Animal dequeueDog() {
	    if(dog.isEmpty()) throw new ArrayIndexOutOfBoundsException("Dog queue is empty");
	    Animal animal = dog.poll();
	    System.out.println("Dequing dog id: " + animal.id + " order: " + animal.order);
	    return animal;
    }

    public Animal dequeueCat() {
        if(cat.isEmpty()) throw new ArrayIndexOutOfBoundsException("Cat queue is empty");
        Animal animal = cat.poll();
        System.out.println("Dequing cat id: " + animal.id + " order: " + animal.order);
        return animal;
    }

    public Animal dequeue() {
	    //System.out.println("Before deleting dog size: " + dog.size() + " cat size: " + cat.size());
	    if(cat.isEmpty() && !dog.isEmpty()) return dog.poll();
        if(dog.isEmpty() && !cat.isEmpty()) return cat.poll();
        if(dog.isEmpty() && cat.isEmpty()) throw new ArrayIndexOutOfBoundsException("Both queues are empty");
        Animal animal = null;
        if(dog.peek().order < cat.peek().order) animal =  dequeueDog();
        else animal = dequeueCat();
        System.out.println("The animal returned in general dequeue: " + animal.name +", id: "+animal.id + " order: "+animal.order);
        //System.out.println("After deleting dog size: " + dog.size() + " cat size: " + cat.size());
        return animal;
    }

    public void print() {
	    Iterator<Animal> iter = dog.iterator();
        System.out.println("\nPrinting dog queue of size: "+ dog.size() +"...");
	    while(iter.hasNext()) {
	        Animal d = iter.next();
	        System.out.println(d.name+": " + d.id + " order: "+d.order);
        }
        System.out.println("\nPrinting cat queue of size: "+ cat.size() +"...");
        Iterator<Animal> iter2 = cat.iterator();
        while(iter2.hasNext()) {
            Animal d2 = iter2.next();
            System.out.println(d2.name+": " + d2.id + " order: " + d2.order);
        }
    }

    public static void test() {
	    AnimalShelter shelter = new AnimalShelter();
	    shelter.enqueue(new Dog(1));
        shelter.enqueue(new Dog(2));
        shelter.enqueue(new Cat(1));
        shelter.enqueue(new Cat(2));
        shelter.dequeueDog();
        shelter.dequeueCat();
        shelter.enqueue(new Dog(3));
        shelter.dequeue();
        shelter.print();
    }
}
