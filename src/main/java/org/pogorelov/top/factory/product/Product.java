package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.Battery;
import org.pogorelov.top.factory.battery.Charger;

public abstract class Product {
    private final Battery battery;
    private double energyConsumption;
    private boolean isOn;

    public Product(Battery battery, double energyConsumption) {
        this.battery = battery;
        this.energyConsumption = energyConsumption;
        this.isOn = false;
    }

    public void powerOnOff() {
        if (Math.round(battery.getChargeAmount() * 100) / (double) 100 <
                Math.round(energyConsumption * 100) / (double) 100 && !isOn) {
            System.out.println("Батарея разряжена");
        } else {
            isOn = !isOn;
            if (isOn) setCharge(energyConsumption);
        }
    }

    /**
     * Метод реализует потребление энергии
     * @param energyConsumption количество потребляемой энергии за одно включение
     */
    protected abstract void setCharge(double energyConsumption);

    public void sendToCharge() {
        Charger.chargeBattery(battery);
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public Battery getBattery() {

        return battery;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
