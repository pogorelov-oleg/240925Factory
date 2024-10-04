package org.pogorelov.top.factory.product;

import org.pogorelov.top.factory.battery.RechargeableBattery;

public class TorchWithRadio extends TorchDuo {
    private final Radio radio;

    public TorchWithRadio(RechargeableBattery batteryOne, RechargeableBattery batteryTwo) {
        super(batteryOne, batteryTwo);
        radio = new Radio(batteryOne);
    }

    public void radioOnOff() {
        if (Math.round((super.getBattery().getChargeAmount() + getBatteryTwo().getChargeAmount()
        ) * 100) / (double) 100 < Math.round(radio.getEnergyConsumption() * 100)
                / (double) 100 && !radio.isOn()) {
            System.out.println("Батарея разряжена");
        } else {
            radio.setOn(!radio.isOn());
            String message = radio.isOn() ? "Радио включилось" : "Радио выключилось";
            System.out.println(message);
            if (radio.isOn()) setCharge(radio.getEnergyConsumption());
        }
    }
}
