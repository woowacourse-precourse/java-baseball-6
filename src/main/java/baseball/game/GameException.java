package baseball.game;

public class GameException {

    public static void validateInput(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
