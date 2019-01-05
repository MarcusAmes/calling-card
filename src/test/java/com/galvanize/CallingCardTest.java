package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallingCardTest {

    @Test
    public void CallingCardMakeTest() {
        //setup
        CallingCard callingCard = new CallingCard(10);
        //execution

        //assertion
        assertEquals(0, callingCard.getRemainingMinutes());

    }

    @Test
    public void CallingCardAddDollarsTest() {
        //setup
        CallingCard callingCard = new CallingCard(10);
        CallingCard callingCard2 = new CallingCard(20);
        //execution
        callingCard.addMinutes(5);
        callingCard2.addMinutes(5);
        //assertion
        assertEquals(50, callingCard.getRemainingMinutes());
        assertEquals(25, callingCard2.getRemainingMinutes());
    }

    @Test
    public void UseMinutesTest() {
        //setup
        CallingCard callingCard = new CallingCard(10);
        //execution
        callingCard.addMinutes(5);
        callingCard.useMinutes(13);
        int firstUse = callingCard.getRemainingMinutes();
        callingCard.useMinutes(9);
        int secondUse = callingCard.getRemainingMinutes();

        //assertion
        assertEquals(37, firstUse);
        assertEquals(28, secondUse);
    }

    @Test
    public void UseMoreMinutesThanHave() {
        CallingCard callingCard = new CallingCard(10);
        callingCard.addMinutes(1);
        callingCard.useMinutes(14);
        assertEquals(0, callingCard.getRemainingMinutes());
    }

    @Test
    public void NotFlatMinute() {
        CallingCard callingCard = new CallingCard(11);
        callingCard.addMinutes(3);
        assertEquals(27, callingCard.getRemainingMinutes());
        CallingCard callingCard1 = new CallingCard(11);
        callingCard1.addMinutes(9);
        assertEquals(81, callingCard1.getRemainingMinutes());
    }

}
