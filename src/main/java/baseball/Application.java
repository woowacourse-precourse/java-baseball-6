package baseball;

import baseball.game.Game;
import baseball.utils.Common;

import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        game();
    }
    static void game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Integer flag = run();
            if(flag==1) {
                continue;
            } else if (flag==2) {
                break;
            } else {
                throw new IllegalArgumentException("input value only can be 1 or 2");
            }
        }
    }

    static Integer run() {
        List<Integer> answer = Game.createAnswer();
        while(true) {
            String inputString = Common.input3StringFromKeyboard();
            List<Integer> inputNumbers = Common.stringToIntegerArray(inputString);

            List<Integer> ballCount = Game.checkAnswer(inputNumbers, answer);
            Game.printAnswer(ballCount);
            if (Objects.equals(ballCount.get(0), 3)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return Integer.parseInt(Common.input1StringFromKeyboard());
            }
        }
    }
}
