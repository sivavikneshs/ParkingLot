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
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        parkingLotAttendant.addParkingLot(new ParkingLot(2));
        assertNotNull(parkingLotAttendant.park());
    }

    @Test(expected = ParkingLotFullException.class)
    public void carShouldNotBeParkedIfParkingLotIsFull() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        parkingLotAttendant.addParkingLot(new ParkingLot(2));
        assertNotNull(parkingLotAttendant.park());
        assertNotNull(parkingLotAttendant.park());
    }

   /* @Test
    public void carShouldUnParkIfParkedInParkingLot() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        parkingLotAttendant.addParkingLot(new ParkingLot(2));
        Token parkingToken = parkingLotAttendant.park();
        assertNotNull(parkingToken);
        assertTrue(parkingLotAttendant.unPark(parkingToken));
        assertFalse(parkingLotAttendant.unPark(parkingToken));
    }

    @Test
    public void carShouldNotUnParkIfNotParkedInParkingLot() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        parkingLotAttendant.addParkingLot(new ParkingLot(2));
        parkingLotAttendant.addToken(mock(Token.class));
        assertFalse(parkingLotAttendant.unPark(null));
        assertFalse(parkingLotAttendant.unPark(unParkedToken));
    }*/

    @Test
    public void shouldOneObserverBeNotifiedWhenEventOccurs() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotListener owner =  mock(ParkingLotListener.class);
        parkingLotAttendant.addListener(owner);
        parkingLotAttendant.park();
        verify(owner, times(1)).receiveNotificationWhenParkingLotIsFull();
    }

    @Test
    public void shouldMultipleObserverBeNotifiedWhenEventOccurs() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotListener owner =  mock(ParkingLotListener.class);
        ParkingLotListener airportSecurity =  mock(ParkingLotListener.class);
        parkingLotAttendant.addListener(owner);
        parkingLotAttendant.addListener(airportSecurity);
        parkingLotAttendant.park();
        verify(owner, times(1)).receiveNotificationWhenParkingLotIsFull();
        verify(airportSecurity, times(1)).receiveNotificationWhenParkingLotIsFull();
    }

  /*  @Test
    public void shouldNotifyParkingLotOwnerOnceSpaceIsAvailableAfterTheFullSign() {
        ParkingLotAttendant parkingLotAttendant = mock(ParkingLotAttendant.class);
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotListener owner =  mock(ParkingLotListener.class);
        parkingLotAttendant.addListener(owner);
        Token token = parkingLotAttendant.park();
        parkingLotAttendant.unPark(token);
        verify(owner, times(1)).receiveNotificationWhenParkingLotIsAvailable();
    }
*/

}
