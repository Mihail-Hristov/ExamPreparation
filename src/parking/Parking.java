package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        boolean isRemoved = false;
        int indexForRemoving = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) && this.data.get(i).getModel().equals(model)) {
                indexForRemoving = i;
                isRemoved = true;
                break;
            }
        }
        if (isRemoved) {
            this.data.remove(indexForRemoving);
        }

        return isRemoved;
    }

    public Car getLatestCar() {
    int latestYear = Integer.MIN_VALUE;
    Car latestCar = null;
        for (Car car : this.data) {
            if (car.getYear() > latestYear) {
                latestYear = car.getYear();
                latestCar = car;
            }
        }

        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car searchingCar = null;
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                searchingCar = car;
            }
        }

        return searchingCar;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("The cars are parked in %s:", this.type));
        result.append(System.lineSeparator());
        for (Car car : this.data) {
            result.append(car.toString());
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

}
