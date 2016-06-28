package com.thoughtworks.bootcamp;

import org.junit.*;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by kabdul on 6/28/16.
 */
public class ParkingLotTest {

    @Test
    public void carShouldBeParkedWhenParkingLotIsFree() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertNotNull(parkingLot.park());
    }

    @Test
    public void carShouldNotBeParkedIfParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(2);
        assertNotNull(parkingLot.park());
        assertNotNull(parkingLot.park());
        assertNull(parkingLot.park());
    }

    @Test
    public void carShouldUnParkIfParkedInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot.Token parkingToken = parkingLot.park();
        assertNotNull(parkingToken);
        assertTrue(parkingLot.unPark(parkingToken));
        assertFalse(parkingLot.unPark(parkingToken));
    }

    @Test
    public void carShouldNotUnParkIfNotParkedInParkingLot() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot.Token unParkedToken = new ParkingLot.Token();
        assertFalse(parkingLot.unPark(null));
        assertFalse(parkingLot.unPark(unParkedToken));
    }
}
