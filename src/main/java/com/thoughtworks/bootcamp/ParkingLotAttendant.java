package com.thoughtworks.bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by in-sivaviknesh on 6/29/16.
 */
public class ParkingLotAttendant {

    List<ParkingLot> parkingLots = new ArrayList<>();
    private List<Token> tokenList;
    List<ParkingLotListener> listeners;

    public ParkingLotAttendant() {
        tokenList = new ArrayList();
        listeners = new ArrayList();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Token park() {
        for(ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isParkingLotFull())
                continue;
            parkingLot.parkingLotTaken();
            Token token = new Token();
            tokenList.add(token);
            return token;
        }
        notifyParkingLotFull();
        throw new ParkingLotFullException("Oops, All Parking Lots are full!");
    }

  /*  public boolean unPark(Token parkingToken) {
        if (isParkingLotFull())
            notifyParkingLotSpaceAvailableOnceItIsFull();
        if (tokenList.remove(parkingToken)) {
            availableParkingSlot++;
            return true;
        }
        return false;
    }*/

    private void notifyParkingLotFull() {
        listeners.forEach(ParkingLotListener::receiveNotificationWhenParkingLotIsFull);
    }

    private void notifyParkingLotSpaceAvailableOnceItIsFull() {
        listeners.forEach(ParkingLotListener::receiveNotificationWhenParkingLotIsAvailable);
    }

    public void addListener(ParkingLotListener parkingLotListener) {
        this.listeners.add(parkingLotListener);
    }

    public void addToken(Token token) {
        this.tokenList.add(token);
    }

}
