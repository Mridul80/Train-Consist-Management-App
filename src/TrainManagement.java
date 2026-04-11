import java.util.Arrays;

public class TrainManagement {

    public static boolean binarySearchBogie(String[] bogieIds, String key) {

        try {

            if (bogieIds == null || key == null) {
                throw new IllegalArgumentException("Input cannot be null");
            }

            Arrays.sort(bogieIds);

            int low = 0;
            int high = bogieIds.length - 1;

            if (bogieIds.length == 0) {
                System.out.println("Bogie Not Found: " + key);
                return false;
            }

            while (low <= high) {

                int mid = (low + high) / 2;

                int compare = key.compareTo(bogieIds[mid]);

                if (compare == 0) {
                    System.out.println("Bogie Found: " + key);
                    return true;
                }

                if (compare > 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println("Bogie Not Found: " + key);
            return false;

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        binarySearchBogie(bogieIds, "BG205");
        binarySearchBogie(bogieIds, "BG999");
    }
}