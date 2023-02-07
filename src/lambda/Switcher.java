package lambda;

import java.util.ArrayList;
import java.util.List;

public class Switcher {

    private final List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn(){
        System.out.println("Включатель ON");
        /*if(consumer != null) {
            consumer.electricityOn();
        }*/

        for (ElectricityConsumer listener : listeners) {
            listener.electricityOn(this);
        }
    }
}
