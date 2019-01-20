package com.galvanize;

public class CellPhone {
    private CallingCard card;
    private boolean isTalking = false;
    private String callHistory = "";
    private String callingPhoneNumber = "";
    private int callTime = 0;

    public CellPhone(CallingCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "CellPhone{" +
                "card=" + card +
                ", isTalking=" + isTalking +
                ", callHistory='" + callHistory + '\'' +
                ", callingPhoneNumber='" + callingPhoneNumber + '\'' +
                ", callTime=" + callTime +
                '}';
    }

    public void call(String phoneNumber) {
        callingPhoneNumber = phoneNumber;
        isTalking = true;
    }

    public void endCall() {
        if(callHistory.length() > 0) {
            callHistory += ", ";
        }
        callHistory += callingPhoneNumber + " (";
        if(card.getRemainingMinutes() <= 1) {
            callHistory += "cut off at ";
        }
        if (callTime > 1) {
            callHistory += callTime + " minutes)";
        } else {
            callHistory += callTime + " minute)";
        }
        isTalking = false;
        callTime = 0;
    }

    public boolean isTalking() {
        return isTalking;
    }

    public String getCallHistory() {
        return callHistory;
    }

    public String getCallingPhoneNumber() {
        return callingPhoneNumber;
    }

    public void tick() {
        callTime++;
        if(card.getRemainingMinutes() <= 1) {
            endCall();
        }
        card.useMinutes(1);
    }
}
