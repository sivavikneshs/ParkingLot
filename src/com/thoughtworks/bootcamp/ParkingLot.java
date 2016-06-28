package com.thoughtworks.bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabdul on 6/28/16.
 */
public class ParkingLot {

    private int availableParkingSlot = 2;
    private List<Token> tokenList;

    public ParkingLot(int availableParkingSlot) {
        this.availableParkingSlot = availableParkingSlot;
        tokenList = new ArrayList(availableParkingSlot);
    }

    public Token park() {
        if (this.availableParkingSlot == 0)
            return null;
        availableParkingSlot--;
        Token token = new Token();
        tokenList.add(token);
        return token;
    }

    public boolean unPark(Token parkingToken) {
        if (parkingToken == null) return false;
        if (tokenList.contains(parkingToken)) {
            availableParkingSlot++;
            tokenList.remove(parkingToken);
            return true;
        }
        return false;
    }

    public static class Token {

        public Token() {

        }
    }
}
