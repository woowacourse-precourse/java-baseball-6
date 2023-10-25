package baseball;

public class Application {
    public static void main(String[] args) {
        Host host = new Host(new Counterpart());
        host.play();
    }
}