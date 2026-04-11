public class TrainManagement {

    public static boolean searchBogie(String[] bogieIds, String key) {

        try {

            if (bogieIds == null || key == null) {
                throw new IllegalArgumentException("Input cannot be null");
            }

            for (String id : bogieIds) {

                if (id.equals(key)) {
                    System.out.println("Bogie Found: " + key);
                    return true;
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

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        searchBogie(bogieIds, "BG309");
        searchBogie(bogieIds, "BG999");
    }
}