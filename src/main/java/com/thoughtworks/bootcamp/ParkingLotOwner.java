package com.thoughtworks.bootcamp;

/**
 * Created by in-sivaviknesh on 6/29/16.
 */
public class ParkingLotOwner implements ParkingLotListener{
    @Override
    public void receiveNotificationWhenParkingLotIsFull() {
        // Show Full Board

    }

    @Override
    public void receiveNotificationWhenParkingLotIsAvailable() {

    }

    @Override
    public void delegateParking() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.park();
    }
}
