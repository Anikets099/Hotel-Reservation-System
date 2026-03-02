import java.io.*;

public class BookingManager {

    private static final String FILE_NAME = "bookings.txt";

    public void saveReservation(Reservation reservation) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(reservation.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving booking.");
        }
    }

    public void viewBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }

    public void cancelBooking(int roomNumber) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(tempFile)) {

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.contains("," + roomNumber + ",")) {
                    writer.write(currentLine + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error cancelling booking.");
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}