package com.thoughtworks.bootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabdul on 6/28/16.
 */
public class ParkingLot {

    private int availableParkingSlot;
    private int capacity = 10;



    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }



    public boolean isParkingLotFull() {
        return availableParkingSlot == 0;
    }

    public void parkingLotTaken() {
        availableParkingSlot--;
    }

    public void setParkingLotFree() {
        availableParkingSlot++;
    }




}
