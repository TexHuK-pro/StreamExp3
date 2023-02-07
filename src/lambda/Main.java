package lambda;

import static java.lang.System.out;

public class Main {

    public static void fire(Object sender){
        out.println("fire");
    }

    public static void main(String[] args) {
        Switcher sw = new Switcher();

        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        sw.addElectricityListener(lamp);
        sw.addElectricityListener(radio);

        sw.addElectricityListener(new ElectricityConsumer() {
            @Override
            public void electricityOn(Object sender) {
                out.println("Пожар в анонимном классе!");
                out.println("Пожар в анонимном классе!!!");
            }
        });

        sw.addElectricityListener(sender -> out.println("Пожар в лямбде выражении!"));
        sw.addElectricityListener(sender -> out.println("Пожар в лямбде выражении!"));



        sw.switchOn();
    }
}
