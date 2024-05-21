public class MovieTheaterTest {
    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater();

        // Display initial seating chart
        System.out.println("Initial Seating Chart:");
        theater.displaySeatingChart();
        System.out.println();

        // Test reserving a regular seat
        System.out.println("Reserving regular seat A1:");
        boolean reservedA1 = theater.reserveSeat("A1");
        System.out.println("Seat A1 reserved: " + reservedA1);
        System.out.println("Seating Chart after reserving A1:");
        theater.displaySeatingChart();
        System.out.println();

        // Test reserving a skybox seat
        System.out.println("Reserving skybox seat SK1:");
        boolean reservedSK1 = theater.reserveSeat("SK1");
        System.out.println("Seat SK1 reserved: " + reservedSK1);
        System.out.println("Seating Chart after reserving SK1:");
        theater.displaySeatingChart();
        System.out.println();

        // Test reserving an already reserved regular seat
        System.out.println("Attempting to reserve already reserved seat A1:");
        boolean reservedA1Again = theater.reserveSeat("A1");
        System.out.println("Seat A1 reserved again: " + reservedA1Again);
        System.out.println();

        // Test reserving an already reserved skybox seat
        System.out.println("Attempting to reserve already reserved seat SK1:");
        boolean reservedSK1Again = theater.reserveSeat("SK1");
        System.out.println("Seat SK1 reserved again: " + reservedSK1Again);
        System.out.println();

        // Test checking availability of an available regular seat
        System.out.println("Checking availability of seat B2:");
        boolean availableB2 = theater.isSeatAvailable("B2");
        System.out.println("Seat B2 available: " + availableB2);
        System.out.println();

        // Test checking availability of an available skybox seat
        System.out.println("Checking availability of seat SK2:");
        boolean availableSK2 = theater.isSeatAvailable("SK2");
        System.out.println("Seat SK2 available: " + availableSK2);
        System.out.println();

        // Test checking availability of an already reserved regular seat
        System.out.println("Checking availability of already reserved seat A1:");
        boolean availableA1 = theater.isSeatAvailable("A1");
        System.out.println("Seat A1 available: " + availableA1);
        System.out.println();

        // Test checking availability of an already reserved skybox seat
        System.out.println("Checking availability of already reserved seat SK1:");
        boolean availableSK1 = theater.isSeatAvailable("SK1");
        System.out.println("Seat SK1 available: " + availableSK1);
        System.out.println();
    }
}

