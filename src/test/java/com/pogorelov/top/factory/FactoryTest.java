package com.pogorelov.top.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.pogorelov.top.factory.Factory;
import org.pogorelov.top.factory.battery.ChineseBattery;
import org.pogorelov.top.factory.battery.Duracell;
import org.pogorelov.top.factory.battery.RechargeableBattery;
import org.pogorelov.top.factory.product.*;

public class FactoryTest {
    @Test
    void switchOnOff() {
        Torch torchChinese = Factory.createTorch(ChineseBattery.class);
        Torch torchDuracell = Factory.createTorch(Duracell.class);
        Torch torchRechargeable = Factory.createTorch(RechargeableBattery.class);

        Radio radioChinese = Factory.createRadio(ChineseBattery.class);
        Radio radioDuracell = Factory.createRadio(Duracell.class);
        Radio radioRechargeable = Factory.createRadio(RechargeableBattery.class);

        TorchDuo torchDuoChinese = Factory.createTorchDuo(ChineseBattery.class);
        TorchDuo torchDuoDuracell = Factory.createTorchDuo(Duracell.class);
        TorchDuo torchDuoRechargeable = Factory.createTorchDuo(RechargeableBattery.class);

        TorchWithRadio torchWithRadio = Factory.createTorchWithRadio();

        TorchLED torchLED = Factory.createTorchLED();

        for (int i = 0; i < 4; i++) {
            torchChinese.powerOnOff();
            torchDuracell.powerOnOff();
            torchRechargeable.powerOnOff();

            radioChinese.powerOnOff();
            radioDuracell.powerOnOff();
            radioRechargeable.powerOnOff();

            torchDuoChinese.powerOnOff();
            torchDuoDuracell.powerOnOff();
            torchDuoRechargeable.powerOnOff();

            torchWithRadio.powerOnOff();
            torchWithRadio.radioOnOff();

            torchLED.powerOnOff();
        }

        Assertions.assertEquals(3, torchChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(48, torchDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(68, torchRechargeable.getBattery().getChargeAmount());

        Assertions.assertEquals(3.67,
                Math.round(radioChinese.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(48.67,
                Math.round(radioDuracell.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(68.67,
                Math.round(radioRechargeable.getBattery().getChargeAmount() * 100) / (double) 100);

        Assertions.assertEquals(4, torchDuoChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(4, torchDuoChinese.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(49, torchDuoDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(49, torchDuoDuracell.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(69, torchDuoRechargeable.getBattery().getChargeAmount());
        Assertions.assertEquals(69, torchDuoRechargeable.getBatteryTwo().getChargeAmount());

        Assertions.assertEquals(68.33,
                Math.round(torchWithRadio.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(68.33,
                Math.round(torchWithRadio.getBatteryTwo().getChargeAmount() * 100) / (double) 100);

        Assertions.assertEquals(69.78,
                Math.round(torchLED.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(69.78,
                Math.round(torchLED.getBatteryTwo().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(69.78,
                Math.round(torchLED.getBatteryThree().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(99.68, torchLED.getChargeInPercent());
    }

    @Test
    void outOfCharge() {
        Torch torchChinese = Factory.createTorch(ChineseBattery.class);
        Torch torchDuracell = Factory.createTorch(Duracell.class);
        Torch torchRechargeable = Factory.createTorch(RechargeableBattery.class);

        Radio radioChinese = Factory.createRadio(ChineseBattery.class);
        Radio radioDuracell = Factory.createRadio(Duracell.class);
        Radio radioRechargeable = Factory.createRadio(RechargeableBattery.class);

        TorchDuo torchDuoChinese = Factory.createTorchDuo(ChineseBattery.class);
        TorchDuo torchDuoDuracell = Factory.createTorchDuo(Duracell.class);
        TorchDuo torchDuoRechargeable = Factory.createTorchDuo(RechargeableBattery.class);

        TorchWithRadio torchWithRadio = Factory.createTorchWithRadio();

        TorchLED torchLED = Factory.createTorchLED();


        for (int i = 0; i < 11; i++) {
            torchChinese.powerOnOff();
        }
        for (int i = 0; i < 101; i++) {
            torchDuracell.powerOnOff();
        }
        for (int i = 0; i < 141; i++) {
            torchRechargeable.powerOnOff();
        }

        for (int i = 0; i < 15; i++) {
            radioChinese.powerOnOff();
        }
        for (int i = 0; i < 151; i++) {
            radioDuracell.powerOnOff();
        }
        for (int i = 0; i < 211; i++) {
            radioRechargeable.powerOnOff();
        }

        for (int i = 0; i < 21; i++) {
            torchDuoChinese.powerOnOff();
        }
        for (int i = 0; i < 201; i++) {
            torchDuoDuracell.powerOnOff();
        }
        for (int i = 0; i < 281; i++) {
            torchDuoRechargeable.powerOnOff();
        }

        for (int i = 0; i < 169; i++) {
            torchWithRadio.powerOnOff();
            torchWithRadio.radioOnOff();
        }

        for (int i = 0; i < 1261; i++) {
            torchLED.powerOnOff();
        }

        Assertions.assertEquals(0, torchChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(0, torchDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(0, torchRechargeable.getBattery().getChargeAmount());

        Assertions.assertEquals(0.33,
                Math.round(radioChinese.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(0,
                Math.round(radioDuracell.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(0,
                Math.round(radioRechargeable.getBattery().getChargeAmount() * 100) / (double) 100);

        Assertions.assertEquals(0, torchDuoChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(0, torchDuoChinese.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(0, torchDuoDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(0, torchDuoDuracell.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(0, torchDuoRechargeable.getBattery().getChargeAmount());
        Assertions.assertEquals(0, torchDuoRechargeable.getBatteryTwo().getChargeAmount());

        Assertions.assertEquals(0,
                Math.round(torchWithRadio.getBattery().getChargeAmount() * 100) / (double) 100);
        Assertions.assertEquals(0,
                Math.round(torchWithRadio.getBatteryTwo().getChargeAmount() * 100) / (double) 100);

        Assertions.assertEquals(0,
                Math.round((torchLED.getBattery().getChargeAmount()) * 100) / (double) 100);
        Assertions.assertEquals(0,
                Math.round((torchLED.getBatteryTwo().getChargeAmount()) * 100) / (double) 100);
        Assertions.assertEquals(0,
                Math.round((torchLED.getBatteryThree().getChargeAmount()) * 100) / (double) 100);
        Assertions.assertEquals(0, torchLED.getChargeInPercent());
    }

    @Test
    void chargeBattery() {
        Torch torchChinese = Factory.createTorch(ChineseBattery.class);
        Torch torchDuracell = Factory.createTorch(Duracell.class);
        Torch torchRechargeable = Factory.createTorch(RechargeableBattery.class);

        Radio radioChinese = Factory.createRadio(ChineseBattery.class);
        Radio radioDuracell = Factory.createRadio(Duracell.class);
        Radio radioRechargeable = Factory.createRadio(RechargeableBattery.class);

        TorchDuo torchDuoChinese = Factory.createTorchDuo(ChineseBattery.class);
        TorchDuo torchDuoDuracell = Factory.createTorchDuo(Duracell.class);
        TorchDuo torchDuoRechargeable = Factory.createTorchDuo(RechargeableBattery.class);

        TorchWithRadio torchWithRadio = Factory.createTorchWithRadio();

        TorchLED torchLED = Factory.createTorchLED();

        for (int i = 0; i < 6; i++) {
            torchChinese.powerOnOff();
            torchDuracell.powerOnOff();
            torchRechargeable.powerOnOff();

            radioChinese.powerOnOff();
            radioDuracell.powerOnOff();
            radioRechargeable.powerOnOff();

            torchDuoChinese.powerOnOff();
            torchDuoDuracell.powerOnOff();
            torchDuoRechargeable.powerOnOff();

            torchWithRadio.powerOnOff();

            torchLED.powerOnOff();
        }

        torchChinese.sendToCharge();
        torchDuracell.sendToCharge();
        torchRechargeable.sendToCharge();

        radioChinese.sendToCharge();
        radioDuracell.sendToCharge();
        radioRechargeable.sendToCharge();

        torchDuoChinese.sendToCharge();
        torchDuoDuracell.sendToCharge();
        torchDuoRechargeable.sendToCharge();

        torchWithRadio.sendToCharge();

        torchLED.sendToCharge();

        Assertions.assertEquals(2, torchChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(47, torchDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(70, torchRechargeable.getBattery().getChargeAmount());

        Assertions.assertEquals(3, Math.round(radioChinese.getBattery().getChargeAmount()));
        Assertions.assertEquals(48, Math.round(radioDuracell.getBattery().getChargeAmount()));
        Assertions.assertEquals(70, Math.round(radioRechargeable.getBattery().getChargeAmount()));

        Assertions.assertEquals(3.5, torchDuoChinese.getBattery().getChargeAmount());
        Assertions.assertEquals(3.5, torchDuoChinese.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(48.5, torchDuoDuracell.getBattery().getChargeAmount());
        Assertions.assertEquals(48.5, torchDuoDuracell.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(70, torchDuoRechargeable.getBattery().getChargeAmount());
        Assertions.assertEquals(70, torchDuoRechargeable.getBatteryTwo().getChargeAmount());

        Assertions.assertEquals(70, torchWithRadio.getBattery().getChargeAmount());
        Assertions.assertEquals(70, torchWithRadio.getBatteryTwo().getChargeAmount());

        Assertions.assertEquals(70, torchLED.getBattery().getChargeAmount());
        Assertions.assertEquals(70, torchLED.getBatteryTwo().getChargeAmount());
        Assertions.assertEquals(70, torchLED.getBatteryThree().getChargeAmount());

    }
}