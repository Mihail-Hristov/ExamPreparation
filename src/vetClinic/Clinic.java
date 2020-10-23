package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet pet : this.data) {
            if (pet.getName() == name) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet currentPet = null;
        for (Pet pet: this.data) {
            if (pet.getName() == name && pet.getOwner() == owner) {
                currentPet = pet;
            }
        }

        return currentPet;
    }

    public Pet getOldestPet() {
        Pet currentPet = null;
        int age = -1;
        for (Pet pet : this.data) {
            if (pet.getAge() > age) {
                currentPet = pet;
                age = currentPet.getAge();
            }
        }

        return currentPet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("The clinic has the following patients:");
        output.append(System.lineSeparator());
        for (Pet pet : this.data) {
            output.append(pet.getName()).append(" ").append(pet.getOwner());
            output.append(System.lineSeparator());
        }

        return output.toString();
    }
}
