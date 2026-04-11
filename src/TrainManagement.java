import java.util.*;

public class TrainManagement {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            if (type.equals("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment");
            }
            this.type = type;
            this.cargo = cargo;
        }
    }

    static List<String> bogieIds = new ArrayList<>();

    public static boolean linearSearch(String key) {
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(String key) {
        List<String> sorted = new ArrayList<>(bogieIds);
        Collections.sort(sorted);

        int low = 0, high = sorted.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(sorted.get(mid));

            if (cmp == 0) return true;
            else if (cmp > 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static boolean safeSearch(String key) {
        if (bogieIds.isEmpty()) {
            throw new IllegalStateException("No bogies available for search");
        }
        return linearSearch(key);
    }

    public static void setBogieIds(List<String> ids) {
        bogieIds = new ArrayList<>(ids);
    }

    public static List<String> getBogieIds() {
        return bogieIds;
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        bogieIds.add("BG101");
        bogieIds.add("BG205");
        bogieIds.add("BG309");

        System.out.println("Initial Bogie Count: " + bogieIds.size());

        System.out.println("Linear Search BG205: " + linearSearch("BG205"));
        System.out.println("Binary Search BG309: " + binarySearch("BG309"));

        try {
            safeSearch("BG999");
        } catch (Exception e) {
            System.out.println("Search Error: " + e.getMessage());
        }
    }
}