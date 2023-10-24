package baseball;

import baseball.domain.answer.Answer;
import baseball.service.game.GameGenerator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String chooseNumber;
        do {
            Answer answer = new Answer();
            System.out.println(GameGenerator.gameStartLog());
            GameGenerator.baseBallGame(answer);
            System.out.println(GameGenerator.gameEndLog());
            chooseNumber = Console.readLine();
        } while (chooseNumber.equals("1"));
    }
}
