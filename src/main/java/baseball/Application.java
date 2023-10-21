package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String isEnd;

        do {
            Game game = new Game(new User(), new Computer());
            
            game.play();
            GameMessage.GAME_RESTART_PROMPT.print();
            isEnd = readLine();
            if (isEnd.length() != 1 || !Character.isDigit(isEnd.charAt(0)) || !(1 <= Integer.parseInt(isEnd)
                    && Integer.parseInt(isEnd) <= 2)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        } while (Integer.parseInt(isEnd) == 1);

    }
}
