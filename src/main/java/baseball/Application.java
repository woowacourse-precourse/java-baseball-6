package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User player = new User();
        Computer computer = new Computer();
    }

    public static void startNewGame(User player, Computer comp) {
        greetings();
        comp.generateNumber();
        while (true) {
            List<Integer> inputNum = player.enterNumber();
            comp.count(inputNum);
            comp.result();

            if (comp.isCorrect()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }
        }
    }
}
