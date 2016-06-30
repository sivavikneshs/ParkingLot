package com.thoughtworks.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by in-sivaviknesh on 6/29/16.
 */
public class ParkingLotAttendantTest {

    @Before
    public void before() {

    }

    @Test
    public void attendantShouldReceiveParkingRequests() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        ParkingLotListener owner =  mock(ParkingLotOwner.class);
        owner.delegateParking();
        verify(parkingLotAttendant, times(1)).park();

    }

    /*@Test
    public void attendantShouldReceiveUnParkingRequests() {
        *//*Based on the assumption he received parking request()*//*
        ParkingLotListener owner =  mock(ParkingLotListener.class);
        ParkingLotAttendant parkingLotAttendant = owner.delegateParking();
        parkingLotAttendant.addParkingLot(mock(ParkingLot.class));
        parkingLotAttendant.unpark();

    }*/
}
