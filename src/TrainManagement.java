class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String shape;
    String cargo;

    GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        try {
            System.out.println("\nAssigning cargo: " + cargo + " to " + shape + " bogie");

            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException(
                        "Unsafe Assignment: Petroleum cannot be assigned to Rectangular bogie"
                );
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned successfully ✔");

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment process completed for " + shape + " bogie.");
        }
    }

    @Override
    public String toString() {
        return shape + " Bogie -> Cargo: " + (cargo == null ? "None" : cargo);
    }
}

public class TrainManagement {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");

        b2.assignCargo("Petroleum");

        System.out.println("\nFinal Bogie States:");
        System.out.println(b1);
        System.out.println(b2);
    }
}