package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.Charger;
import org.pogorelov.top.factory.battery.RechargeableBattery;

public class TorchLED extends TorchDuo {
    RechargeableBattery batteryThree;

    public TorchLED(RechargeableBattery batteryOne, RechargeableBattery batteryTwo,
                    RechargeableBattery batteryThree) {
        super(batteryOne, batteryTwo);
        this.batteryThree = batteryThree;
        setEnergyConsumption((double) 1 / 3);
    }

    @Override
    public void powerOnOff() {
        if (Math.round((super.getBattery().getChargeAmount() + getBatteryTwo().getChargeAmount() +
                batteryThree.getChargeAmount()) * 100) / (double) 100 < Math.round(getEnergyConsumption() * 100)
                / (double) 100 && !isOn()) {
            System.out.println("Батарея разряжена");
        } else {
            setOn(!isOn());
            String message = isOn() ? "Фонарик включился. Заряд: " + getChargeInPercent() + "%" : "Фонарик выключился";
            System.out.println(message);
            if (isOn()) setCharge(getEnergyConsumption());
        }
    }

    @Override
    public void sendToCharge() {
        super.sendToCharge();
        Charger.chargeBattery(batteryThree);
    }

    @Override
    protected void setCharge(double energyConsumption) {
        getBattery().setChargeAmount(getBattery().getChargeAmount() - energyConsumption / 3);
        getBatteryTwo().setChargeAmount(getBatteryTwo().getChargeAmount() - energyConsumption / 3);
        batteryThree.setChargeAmount(batteryThree.getChargeAmount() - energyConsumption / 3);
    }

    public double getChargeInPercent() {
        int oneHundredPercent = ((RechargeableBattery) getBattery()).getMaxCharge() +
                ((RechargeableBattery) getBatteryTwo()).getMaxCharge() + batteryThree.getMaxCharge();//100%
        double chargeNow = getBattery().getChargeAmount() +
                getBatteryTwo().getChargeAmount() + batteryThree.getChargeAmount();

        if (chargeNow == 0)

            return 0;
        else

            return (double) Math.round((chargeNow * 100 / oneHundredPercent) * 100) / 100;

    }

    public RechargeableBattery getBatteryThree() {
        return batteryThree;
    }
}
