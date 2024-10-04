package org.pogorelov.top.factory.battery;

public class RechargeableBattery extends Battery {
    private final int maxCharge;

    public RechargeableBattery() {
        super(70);
        this.maxCharge = 70;
    }

    public void showCharge() {
        System.out.printf("Уровень заряда: %.2f\n", getChargeAmount());
    }

    public int getMaxCharge() {

        return maxCharge;
    }
}

