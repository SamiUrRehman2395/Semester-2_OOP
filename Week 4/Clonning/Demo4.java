class Flight{
    private int flightNo;
    private String origin;
    private String destination;

    public Flight(int flightNo, String origin, String destination) {
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNo=" + flightNo +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Flight that = (Flight) obj;

        return this.flightNo == that.flightNo && (this.origin.equals(that.origin) && this.destination.equals(that.destination));
    }

    public Flight clone(){
        return new Flight(flightNo, origin, destination);
    }
}

class Passenger{
    private String passengerName;
    private int passengerAge;

    private Flight flight;

    public Passenger(String passengerName, int passengerAge, Flight flight) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.flight = flight;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", flight=" + flight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Passenger that = (Passenger) obj;

        if (this.passengerName.equals(that.passengerName) && this.passengerAge == that.passengerAge && this.flight.equals(that.flight)) {
            return true;
        } else {
            return false;
        }
    }

    public Passenger clone(){
//        return new Passenger(passengerName, passengerAge, flight); //shallow
        return new Passenger(passengerName, passengerAge, flight.clone()); //deep
    }

}

public class Demo4 {
    public static void main(String[] args) {

        Passenger p1 = new Passenger("Imad Wasim", 33, new Flight(504, "Pakistan","England"));

        System.out.println(p1.toString());

        Passenger p2 = p1.clone();
        System.out.println("\nBefore Modifications\n");
        System.out.println("Original:-");
        System.out.println(p1.toString());
        System.out.println("Clone:-");
        System.out.println(p2.toString());


        p1.getFlight().setFlightNo(122);
        p1.getFlight().setOrigin("England");
        p1.getFlight().setDestination("Pakistan");
        p1.setPassengerName("Mohammad Amir");
        p1.setPassengerAge(37);

        System.out.println("\nAfter Modifications\n");

        System.out.println("Original:-");
        System.out.println(p1.toString());
        System.out.println("Clone:-");
        System.out.println(p2.toString());

        System.out.println("___________________\n");


        if (p1.equals(p2)) {
            System.out.println("Passengers are the same");
        } else {
            System.out.println("Passengers are different");
        }

    }
}
