package org.pogorelov.top.factory;

import org.pogorelov.top.factory.battery.Battery;
import org.pogorelov.top.factory.battery.ChineseBattery;
import org.pogorelov.top.factory.battery.Duracell;
import org.pogorelov.top.factory.battery.RechargeableBattery;
import org.pogorelov.top.factory.product.*;

public class Factory {
    public static Torch createTorch(Class clazz) {

        return new Torch(createBattery(clazz));
    }

    public static Radio createRadio(Class clazz) {

        return new Radio(createBattery(clazz));
    }

    public static TorchDuo createTorchDuo(Class clazz) {

        return new TorchDuo(createBattery(clazz), createBattery(clazz));
    }

    public static TorchWithRadio createTorchWithRadio() {

        return new TorchWithRadio(new RechargeableBattery(), new RechargeableBattery());
    }

    public static TorchLED createTorchLED() {

        return new TorchLED(new RechargeableBattery(),new RechargeableBattery(),new RechargeableBattery());
    }

    private static Battery createBattery(Class clazz) {
        Battery battery;
        battery = switch (clazz.getSimpleName()) {
            case "ChineseBattery" -> new ChineseBattery();
            case "Duracell" -> new Duracell();
            case "RechargeableBattery" -> new RechargeableBattery();
            default -> throw new IllegalStateException("Недопустимый аргумент: " + clazz.getSimpleName() + ".class");
        };

        return battery;
    }
}