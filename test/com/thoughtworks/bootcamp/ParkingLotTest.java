package com.thoughtworks.bootcamp;

import org.junit.*;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Test
    public void shouldOneObserverBeNotifiedWhenEventOccurs() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot.ParkingLotListener owner =  mock(ParkingLot.ParkingLotListener.class);
        parkingLot.addListener(owner);
        parkingLot.park();
        verify(owner, times(1)).onParkingLotIsFull();
    }

    @Test
    public void shouldMultipleObserverBeNotifiedWhenEventOccurs() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot.ParkingLotListener owner =  mock(ParkingLot.ParkingLotListener.class);
        ParkingLot.ParkingLotListener airportSecurity =  mock(ParkingLot.ParkingLotListener.class);
        parkingLot.addListener(owner);
        parkingLot.addListener(airportSecurity);
        parkingLot.park();
        verify(owner, times(1)).onParkingLotIsFull();
        verify(airportSecurity, times(1)).onParkingLotIsFull();
    }

}
