package baseball;

public class Application {
    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();
        while (true) {
            boolean restart = numberBaseball.execute();
            if (restart == false) {
                break;
            }
        }
    }
}