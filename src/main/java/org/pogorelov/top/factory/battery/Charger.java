package org.pogorelov.top.factory.battery;

public class Charger {
    public static void chargeBattery(Battery battery) {
        if (battery instanceof RechargeableBattery) {
            battery.setChargeAmount(((RechargeableBattery) battery).getMaxCharge());
            System.out.print("Батарея полностью заряжена. ");
            ((RechargeableBattery) battery).showCharge();
        } else System.out.println("Данный тип батареек не заряжается");
    }
}
