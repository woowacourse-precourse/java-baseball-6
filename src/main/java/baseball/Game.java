package baseball;

import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.createComputerNumbers();
//        System.out.println(computerNumbers);
        BaseballGame baseballGame = new BaseballGame(computerNumbers);
        baseballGame.playBaseballGame();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        if (Objects.equals(userInput, "1")) {
            play();
        }
        System.out.println("게임 종료");
    }
}
