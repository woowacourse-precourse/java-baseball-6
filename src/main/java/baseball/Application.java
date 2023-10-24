package baseball;

import baseball.number.NumberMatcher;
import baseball.number.NumberProducer;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int reGame = 1;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (reGame != 2) {
            if (reGame == 1) {
                computer = NumberProducer.makeNumberInRange(1, 9, 3);
                reGame = 0; // reGame 초기화
            }
            System.out.print("숫자를 입력해주세요 : ");
            String result = NumberMatcher.numberMatcherResult(computer, 1, 9, 3);

            if (result.equals("3스트라이크")) {
                System.out.println(result);
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                reGame = Integer.parseInt(Console.readLine());
            } else {
                System.out.println(result);
            }
        }
        Console.close();
    }
}
