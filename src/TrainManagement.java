public class TrainManagement {

    public static int[] sortCapacities(int[] capacities) {

        try {

            if (capacities == null) {
                throw new IllegalArgumentException("Capacity array cannot be null");
            }

            if (capacities.length == 0) {
                throw new IllegalArgumentException("Capacity array cannot be empty");
            }

            int n = capacities.length;

            for (int i = 0; i < n - 1; i++) {

                for (int j = 0; j < n - i - 1; j++) {

                    if (capacities[j] < 0 || capacities[j + 1] < 0) {
                        throw new IllegalArgumentException("Capacity cannot be negative");
                    }

                    if (capacities[j] > capacities[j + 1]) {

                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Sorting operation completed.");
        }

        return capacities;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        int[] capacities = {72, 56, 24, 70, 60};

        int[] sorted = sortCapacities(capacities);

        System.out.println("Sorted Capacities:");

        for (int c : sorted) {
            System.out.print(c + " ");
        }
    }
}