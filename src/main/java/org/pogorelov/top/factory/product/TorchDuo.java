package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.Battery;
import org.pogorelov.top.factory.battery.Charger;

public class TorchDuo extends Torch {
    private final Battery batteryTwo;

    public TorchDuo(Battery batteryOne, Battery batteryTwo) {
        super(batteryOne);
        this.batteryTwo = batteryTwo;
    }

    @Override
    public void powerOnOff() {
        if (Math.round((super.getBattery().getChargeAmount() + this.batteryTwo.getChargeAmount()) * 100)
                / (double) 100 < Math.round(getEnergyConsumption() * 100) / (double) 100 && !isOn()) {
            System.out.println("Батарея разряжена");
        } else {
            setOn(!isOn());
            String message = isOn() ? "Фонарик включился" : "Фонарик выключился";
            System.out.println(message);
            if (isOn()) setCharge(getEnergyConsumption());
        }
    }

    @Override
    public void sendToCharge() {
        super.sendToCharge();
        Charger.chargeBattery(batteryTwo);
    }

    @Override
    protected void setCharge(double energyConsumption) {
        getBattery().setChargeAmount(getBattery().getChargeAmount() - energyConsumption / 2);
        this.batteryTwo.setChargeAmount(this.batteryTwo.getChargeAmount() - energyConsumption / 2);
    }

    public Battery getBatteryTwo() {
        return batteryTwo;
    }
}
