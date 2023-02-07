package lambda;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Музыка заиграла в радио");
    }

    @Override
    public void electricityOn(Object sender) {
        System.out.println("пошло электричество в радио");
        playMusic();
    }
}
