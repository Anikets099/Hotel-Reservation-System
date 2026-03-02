import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        BookingManager manager = new BookingManager();

        while (true) {

            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    hotel.showAvailableRooms();
                    break;

                case 2:
                    hotel.showAvailableRooms();
                    System.out.print("Enter Room Number: ");
                    int roomNo = sc.nextInt();
                    sc.nextLine();

                    Room room = hotel.findRoom(roomNo);

                    if (room != null && room.isAvailable()) {

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Check-In Date: ");
                        String checkIn = sc.nextLine();

                        System.out.print("Enter Check-Out Date: ");
                        String checkOut = sc.nextLine();

                        System.out.print("Enter 16-digit Card Number: ");
                        String card = sc.nextLine();

                        if (card.length() == 16) {

                            Reservation res = new Reservation(
                                    name, roomNo, checkIn, checkOut, "Paid");

                            manager.saveReservation(res);
                            room.setAvailable(false);

                            System.out.println("Booking Successful!");

                        } else {
                            System.out.println("Payment Failed!");
                        }

                    } else {
                        System.out.println("Room not available.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Room Number to Cancel: ");
                    int cancelRoom = sc.nextInt();
                    manager.cancelBooking(cancelRoom);

                    Room cancelR = hotel.findRoom(cancelRoom);
                    if (cancelR != null) {
                        cancelR.setAvailable(true);
                    }

                    System.out.println("Booking Cancelled.");
                    break;

                case 4:
                    manager.viewBookings();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}