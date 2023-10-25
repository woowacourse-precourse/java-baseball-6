package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input;
        Game game;

        GameMessage.WELCOME.print();
        do {
            game = new Game(new User(), new Computer());

            game.play();
            GameMessage.GAME_RESTART_PROMPT.print();
            input = readLine();
            if (!isValid(input)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        } while (Integer.parseInt(input) == 1);

    }

    private static boolean isValid(String input) {
        if (input.length() != 1 || !Character.isDigit(input.charAt(0)) ||
                !(1 <= Integer.parseInt(input) && Integer.parseInt(input) <= 2)) {
            return false;
        }
        return true;
    }
}
