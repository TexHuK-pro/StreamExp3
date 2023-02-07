package lambda;

public class Lamp implements ElectricityConsumer {
    public void lightOn() {
        System.out.println("Лампа включилась");
    }

    @Override
    public void electricityOn(Object sender) {
        System.out.println("пошло электричество");
        lightOn();
    }
}
