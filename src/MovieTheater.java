import java.util.Scanner;

public class MovieTheater {
    private String[][] regularSeats;
    private String[] skyboxSeats;
    private static final int ROWS = 10;
    private static final int SEATS_PER_ROW = 10;
    private static final int SKYBOX_SEATS = 5;
    private static final String[] ROW_LABELS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public MovieTheater() {
        regularSeats = new String[ROWS][SEATS_PER_ROW];
        skyboxSeats = new String[SKYBOX_SEATS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                regularSeats[i][j] = "X";
            }
        }

        for (int i = 0; i < SKYBOX_SEATS; i++) {
            skyboxSeats[i] = "XX";
        }
    }

    public void displaySeatingChart() {
        System.out.println("Regular Seating:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                System.out.print(ROW_LABELS[i] + (j + 1) + " " + regularSeats[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSkybox Seating:");
        for (int i = 0; i < SKYBOX_SEATS; i++) {
            System.out.print("SK" + (i + 1) + " " + skyboxSeats[i] + " ");
        }
        System.out.println();
    }

    public boolean reserveSeat(String seat) {
        if (seat.startsWith("SK")) {
            int seatNumber = Integer.parseInt(seat.substring(2)) - 1;
            if (seatNumber >= 0 && seatNumber < SKYBOX_SEATS && skyboxSeats[seatNumber].equals("XX")) {
                skyboxSeats[seatNumber] = "YY";
                return true;
            }
        } else {
            char row = seat.charAt(0);
            int rowIndex = row - 'A';
            int seatNumber = Integer.parseInt(seat.substring(1)) - 1;
            if (rowIndex >= 0 && rowIndex < ROWS && seatNumber >= 0 && seatNumber < SEATS_PER_ROW && regularSeats[rowIndex][seatNumber].equals("X")) {
                regularSeats[rowIndex][seatNumber] = "Y";
                return true;
            }
        }
        return false;
    }

    public boolean isSeatAvailable(String seat) {
        if (seat.startsWith("SK")) {
            int seatNumber = Integer.parseInt(seat.substring(2)) - 1;
            return seatNumber >= 0 && seatNumber < SKYBOX_SEATS && skyboxSeats[seatNumber].equals("XX");
        } else {
            char row = seat.charAt(0);
            int rowIndex = row - 'A';
            int seatNumber = Integer.parseInt(seat.substring(1)) - 1;
            return rowIndex >= 0 && rowIndex < ROWS && seatNumber >= 0 && seatNumber < SEATS_PER_ROW && regularSeats[rowIndex][seatNumber].equals("X");
        }
    }

    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            theater.displaySeatingChart();
            System.out.println("Enter the seat(s) you want to select (e.g., A1, SK1): ");
            String seat = scanner.nextLine().trim().toUpperCase();
            if (theater.isSeatAvailable(seat)) {
                System.out.println("These seat(s) are available. Do you want to reserve them? Press 'A' to reserve or 'N' to not reserve.");
                String response = scanner.nextLine().trim().toUpperCase();
                if (response.equals("A")) {
                    theater.reserveSeat(seat);
                    System.out.println("Seat(s) reserved successfully.");
                } else {
                    System.out.println("Seat(s) not reserved.");
                }
            } else {
                System.out.println("The requested seat(s) are not available. Please select another seat(s).");
            }
        }
    }
}

