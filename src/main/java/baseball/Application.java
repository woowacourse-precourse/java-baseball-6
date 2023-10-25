package baseball;

public class Application {
    static App app = new App();
    public static void main(String[] args) {
        boolean option;
        app.start();
        do {
            app.randomNum();
            app.game();
            option = app.end();
        } while (option);
    }
}