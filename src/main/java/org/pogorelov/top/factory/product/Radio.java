package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.Battery;

public class Radio extends Product {

    public Radio(Battery battery) {
        super(battery, 1 / 1.5);
    }

    @Override
    public void powerOnOff() {
        super.powerOnOff();

        String message = isOn() ? "Радио включилось" : "Радио выключилось";
        System.out.println(message);
    }

    @Override
    protected void setCharge(double energyConsumption) {
        getBattery().setChargeAmount(getBattery().getChargeAmount() - energyConsumption);
    }
}
