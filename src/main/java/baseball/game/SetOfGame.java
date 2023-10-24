package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.numbers.ComputerNumbersGenerator;
import java.util.Objects;

public class SetOfGame {

    public SetOfGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        String userInput;

        do {
            UnitOfGame unitOfGame = new UnitOfGame(new ComputerNumbersGenerator());
            unitOfGame.play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = readLine();
        } while (Objects.equals(userInput, "1"));

    }
}
