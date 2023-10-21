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

        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (reGame != 2) {
                if (reGame == 1) {
                    computer = NumberProducer.makeNumberInRange(1, 9, 3);
                    reGame = 0; // reGame 초기화
                    // test
                    System.out.println("computer = " + computer);
                }
                System.out.print("숫자를 입력해주세요 : ");
                String result = NumberMatcher.numberMatcherResult(computer);
                // todo 결과를 어떤 식으로 줘서 판별할지 고민
                if (result.equals("3스트라이크")) {
                    System.out.println(result);
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    reGame = Integer.parseInt(Console.readLine());
                } else {
                    System.out.println(result);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 1부터 9 사이의 숫자만 입력할 수 있습니다.");
        }
    }
}
