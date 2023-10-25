package baseball;

public class Application {

    public static void main(String[] args) {
        while (true) {
            Round round = new Round();
            boolean gameResult = round.gameplay();
            if (!gameResult) {
                break;
            }
        }
    }
}