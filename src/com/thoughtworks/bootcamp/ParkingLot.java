package com.thoughtworks.bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabdul on 6/28/16.
 */
public class ParkingLot {

    private int availableParkingSlot;
    private List<Token> tokenList;
    List<ParkingLotListener> listeners;

    public void addListener(ParkingLotListener parkingLotListener) {
        this.listeners.add(parkingLotListener);
    }

    public ParkingLot(int availableParkingSlot) {
        this.availableParkingSlot = availableParkingSlot;
        tokenList = new ArrayList(availableParkingSlot);
        listeners = new ArrayList();
    }

    public Token park() {
        if (this.availableParkingSlot == 0)
            return null;
        availableParkingSlot--;
        if (this.availableParkingSlot == 0){
            if (listeners != null)
                notifyParkingLotFull();
        }
        Token token = new Token();
        tokenList.add(token);
        return token;
    }

    private void notifyParkingLotFull() {
        listeners.forEach(ParkingLotListener::onParkingLotIsFull);
    }

    public boolean unPark(Token parkingToken) {
        if (parkingToken == null) return false;
        if (tokenList.remove(parkingToken)) {
            availableParkingSlot++;
            return true;
        }
        return false;
    }

    public static class Token {

        public Token() {

        }
    }

    public interface ParkingLotListener {
        void onParkingLotIsFull();
    }
}
