package baseball;

import baseball.domain.answer.Answer;
import baseball.domain.game.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String chooseNumber;
        do {
            Answer answer = new Answer();
            System.out.println(Game.gameStartLog());
            Game.baseBallGame(answer);
            System.out.println(Game.gameEndLog());
            chooseNumber = Console.readLine();
        } while (!chooseNumber.equals("2"));
    }
}
