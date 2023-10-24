package baseball.game;

import baseball.numbers.Computer;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SetOfGame {

    public SetOfGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        Computer computer = new Computer();
        UnitOfGame unitOfGame = new UnitOfGame(computer.getComputerNumbers());
        unitOfGame.play();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        if (Objects.equals(userInput, "1")) {
            play();
        }
    }
}
