package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellPhoneTest {
    @Test
    public void InstanceDeclaration() {
        CellPhone cellPhone = new CellPhone(new CallingCard(10));
        cellPhone.call("123-4567");
        assertEquals("123-4567", cellPhone.getCallingPhoneNumber());
    }

    @Test
    public void isTalkingTest() {
        CellPhone cellPhone = new CellPhone(new CallingCard(10));
        assertEquals(false, cellPhone.isTalking());
        cellPhone.call("123-4567");
        assertEquals(true, cellPhone.isTalking());
    }

    @Test
    public void tickTest() {
        CallingCard card = new CallingCard(10);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.tick();
        assertEquals(7, card.getRemainingMinutes());
    }

    @Test
    public void endCallTest() {
        CallingCard card = new CallingCard(10);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        assertEquals(true, cellPhone.isTalking());
        cellPhone.tick();
        cellPhone.endCall();
        assertEquals(false, cellPhone.isTalking());
    }

    @Test
    public void cutOffTest() {
        CallingCard card = new CallingCard(20);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.tick();
        assertEquals(true, cellPhone.isTalking());
        cellPhone.tick();
        assertEquals(false, cellPhone.isTalking());
        assertEquals(0, card.getRemainingMinutes());
    }

    @Test
    public void callHistoryTest() {
        CallingCard card = new CallingCard(10);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        cellPhone.endCall();
        assertEquals("123-4567 (1 minute)", cellPhone.getCallHistory());
    }

    @Test
    public void callHistoryTestMultiple() {
        CallingCard card = new CallingCard(10);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        cellPhone.endCall();
        cellPhone.call("333-3333");
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.endCall();
        assertEquals("123-4567 (1 minute), 333-3333 (3 minutes)", cellPhone.getCallHistory());
    }

    @Test
    public void callHistoryCutOffTest() {
        CallingCard card = new CallingCard(20);
        card.addMinutes(1);
        CellPhone cellPhone = new CellPhone(card);
        cellPhone.call("123-4567");
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.endCall();
        cellPhone.call("333-3333");
        cellPhone.tick();
        cellPhone.tick();
        cellPhone.tick();
        assertEquals("123-4567 (2 minutes), 333-3333 (cut off at 3 minutes)", cellPhone.getCallHistory());
    }
}
