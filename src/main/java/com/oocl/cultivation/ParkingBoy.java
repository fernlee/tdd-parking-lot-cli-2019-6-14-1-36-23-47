package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = parkingLot.addCar(car);
        if (ticket != null) {
            clearLastErrorMessage();
        }
        return ticket;
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        if (ticket == null) {
            lastErrorMessage = "Please provide your parking ticket.";
            return null;
        }
        Car car = parkingLot.findCar(ticket);
        if (car == null) {
            lastErrorMessage = "Unrecognized parking ticket.";
        } else {
            clearLastErrorMessage();
        }
        return car;
    }

    private void clearLastErrorMessage() {
        lastErrorMessage = null;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
