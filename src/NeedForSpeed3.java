import java.util.*;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carParameters = new TreeMap<>();

        for (int i = 0; i < numberOfLine; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            addCar(carParameters,tokens);
        }

        String inputCommand = scanner.nextLine();
        while (!"Stop".equals(inputCommand)){
            String[] tokens = inputCommand.split(" : ");
            String command = tokens[0];

            switch (command){
                case "Drive":
                    String carNameForDrive = tokens[1];
                    int distance = Integer.parseInt(tokens[2]);
                    int fuelForDrive = Integer.parseInt(tokens[3]);

                    proceedTheDriveCommand(carParameters, carNameForDrive, distance, fuelForDrive);

                    break;
                case "Refuel":
                    String carNameForRefuel = tokens[1];
                    int fuelForRefuel = Integer.parseInt(tokens[2]);

                    proceedTheRefuelCommand(carParameters, carNameForRefuel, fuelForRefuel);

                    break;
                case "Revert":
                    String carNameForRevert = tokens[1];
                    int km = Integer.parseInt(tokens[2]);

                    proceedTheRevertCommand(carParameters, carNameForRevert, km);

                    break;


            }
            inputCommand = scanner.nextLine();
        }

        carParameters
                .entrySet()
                .stream()
                .sorted((c1, c2) -> Integer.compare(c2.getValue().get(0), c1.getValue().get(0)))
                .forEach(c -> {
                    String carName = c.getKey();
                    int mileage = carParameters.get(carName).get(0);
                    int fuel = carParameters.get(carName).get(1);
                    System.out.println(String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.",carName, mileage,fuel));
                });

    }

    public static void addCar(Map<String, List<Integer>> carParameters, String[] tokens){
        String car = tokens[0];
        int mileage = Integer.parseInt(tokens[1]);
        int fuel = Integer.parseInt(tokens[2]);

        List<Integer> carSpecification = new ArrayList<>();
        carSpecification.add(mileage);
        carSpecification.add(fuel);

        carParameters.putIfAbsent(car, new ArrayList<>());
        carParameters.put(car, carSpecification);
    }

    public static void proceedTheDriveCommand(Map<String, List<Integer>> carParameters, String carName, int distance, int fuel){
        int availableFuel = carParameters.get(carName).get(1);

        if (availableFuel < fuel){
            System.out.println("Not enough fuel to make that ride");
        }else {
            int newMileage = carParameters.get(carName).get(0) + distance;
            int newFuel = carParameters.get(carName).get(1) - fuel;

            List<Integer> temp = new ArrayList<>();
            temp.add(newMileage);
            temp.add(newFuel);

            carParameters.put(carName, temp);
            System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.", carName, distance, fuel));
        }

        if (carParameters.get(carName).get(0) >= 100000){
            carParameters.remove(carName);
            System.out.println(String.format("Time to sell the %s!",carName));
        }
    }

    public static void proceedTheRefuelCommand(Map<String, List<Integer>> carParameters, String carName, int fuel){
        int currentFuel = carParameters.get(carName).get(1);
        int newFuel = 0;
        int howMuchFit = 0;
        if (currentFuel + fuel > 75){
            newFuel = 75;
            howMuchFit = 75 - currentFuel;
        }else {
            newFuel = currentFuel + fuel;
            howMuchFit = fuel;
        }
        List<Integer> temp = carParameters.get(carName);
        temp.remove(1);
        temp.add(newFuel);

        carParameters.put(carName, temp);

        System.out.println(String.format("%s refueled with %d liters", carName, howMuchFit));
    }

    public static void proceedTheRevertCommand(Map<String, List<Integer>> carParameters, String carName, int km){
        int currentMileage = carParameters.get(carName).get(0);
        currentMileage = Math.max(currentMileage - km, 10000);
        if (currentMileage > 10000){
            System.out.println(String.format("%s mileage decreased by %d kilometers",carName, km));
        }

        List<Integer> temp = carParameters.get(carName);
        temp.remove(0);
        temp.add(0, currentMileage);
        carParameters.put(carName, temp);

    }

}
