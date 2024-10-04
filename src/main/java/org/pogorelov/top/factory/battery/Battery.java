package org.pogorelov.top.factory.battery;

public abstract class Battery {
    private double chargeAmount;

    public Battery(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public double getChargeAmount() {
        return chargeAmount;
    }
}
