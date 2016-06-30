package com.thoughtworks.bootcamp;

/**
 * Created by in-sivaviknesh on 6/29/16.
 */
public interface ParkingLotListener {
    void receiveNotificationWhenParkingLotIsFull();

    void receiveNotificationWhenParkingLotIsAvailable();

    void delegateParking();
}
