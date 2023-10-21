package baseball;

import baseball.domain.answer.Answer;
import baseball.domain.game.Game;
import baseball.domain.number.Number;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static final Answer ANSWER = new Answer();


    public static void main(String[] args) {

        System.out.print(Game.gameStartLog());

        String result;
        do {
            Number inputNumber = new Number(Console.readLine());
            result = Game.compare(inputNumber.toIntList(), ANSWER.toIntList());
            System.out.println(result);
        } while (!result.equals("3스트라이크"));

    }
}
