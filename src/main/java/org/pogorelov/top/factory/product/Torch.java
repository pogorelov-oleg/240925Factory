package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.Battery;

public class Torch extends Product {

    public Torch(Battery battery) {
        super(battery, 1);
    }

    @Override
    public void powerOnOff() {
        super.powerOnOff();

        String message = isOn() ? "Фонарик включился" : "Фонарик выключился";
        System.out.println(message);
    }

    @Override
    protected void setCharge(double energyConsumption) {
        getBattery().setChargeAmount(getBattery().getChargeAmount() - energyConsumption);
    }
}

