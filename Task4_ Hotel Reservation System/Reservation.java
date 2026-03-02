public class Reservation {

    private String customerName;
    private int roomNumber;
    private String checkIn;
    private String checkOut;
    private String paymentStatus;

    public Reservation(String customerName, int roomNumber,
                       String checkIn, String checkOut, String paymentStatus) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.paymentStatus = paymentStatus;
    }

    public String toFileString() {
        return customerName + "," + roomNumber + "," +
               checkIn + "," + checkOut + "," + paymentStatus;
    }

    public int getRoomNumber() { return roomNumber; }

    public String toString() {
        return "Customer: " + customerName +
               " | Room: " + roomNumber +
               " | Check-In: " + checkIn +
               " | Check-Out: " + checkOut +
               " | Payment: " + paymentStatus;
    }
}