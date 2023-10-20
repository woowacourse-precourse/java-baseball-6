package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.createComputerNumbers();
        System.out.println(computerNumbers);
        BaseballGame baseballGame = new BaseballGame(computerNumbers);
        baseballGame.play();
    }
}
