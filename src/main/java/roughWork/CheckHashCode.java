package main.java.roughWork;

import java.util.Objects;

public class CheckHashCode {
    public static void main(String[] args) {
        Animal a1= new Animal("Lion", 35);
        Animal a2= new Animal("Tiger", 55);
        Animal a3= new Animal("Lion", 35);
        System.out.println(a1.equals(a3));
    }
}
class Animal {
    String animalName;
    int animalAge;

    public Animal(String animalName, int animalAge) {
        this.animalName = animalName;
        this.animalAge = animalAge;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalAge == animal.animalAge &&
                Objects.equals(animalName, animal.animalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalAge);
    }
}
