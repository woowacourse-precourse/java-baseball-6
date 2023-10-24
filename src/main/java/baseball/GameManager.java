package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class GameManager {
    private Computer computer = new Computer();
    private User user = new User();
    /**
     * 게임 시작
     */
    public GameManager() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void execute() {
        Map<String, Integer> resultMap;

        computer.init();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> input = user.init(Console.readLine());
            resultMap = computer.compare(input);
        } while(!result(resultMap));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean result(Map<String, Integer> result) {
        gameResultPrint(result);
        if(result.get("strike") == 3) {
            return true;
        }
        return false;
    }

    private void gameResultPrint(Map<String, Integer> result) {
        Integer strike = result.get("strike");
        Integer ball = result.get("ball");

        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if(strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else if(strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
