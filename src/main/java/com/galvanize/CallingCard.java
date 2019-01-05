package com.galvanize;

public class CallingCard {
    private int remainingMinutes = 0;
    private int centsPerMinute;

    public CallingCard(int centsPerMinute) {
        this.centsPerMinute = centsPerMinute;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void addMinutes(int dollars) {
        remainingMinutes += dollars * 100 / centsPerMinute;
    }

    public void useMinutes(int minutes) {
        if(remainingMinutes - minutes < 0) {
            remainingMinutes = 0;
        } else {
            remainingMinutes -= minutes;
        }
    }
}
