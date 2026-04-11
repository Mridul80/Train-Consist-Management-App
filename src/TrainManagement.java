import java.util.Arrays;

public class TrainManagement {

    public static int[] sortCapacities(int[] capacities) {

        if (capacities == null || capacities.length == 0) {
            throw new IllegalArgumentException("Invalid capacity array");
        }

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        return capacities;
    }

    public static String[] sortBogieNames(String[] bogies) {

        try {

            if (bogies == null) {
                throw new IllegalArgumentException("Bogie array cannot be null");
            }

            if (bogies.length == 0) {
                throw new IllegalArgumentException("Bogie array cannot be empty");
            }

            Arrays.sort(bogies);

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Bogie sorting completed.");
        }

        return bogies;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogies = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        String[] sorted = sortBogieNames(bogies);

        System.out.println("Sorted Bogie Names:");

        System.out.println(Arrays.toString(sorted));
    }
}