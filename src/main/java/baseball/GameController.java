package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class GameController {

    private NumberController numberController = new NumberController();
    private ExceptionController exceptionController = new ExceptionController();

    public void gameStart() {
        List<Integer> computerNumberList = numberController.generateComputerNumberList();

        Integer strike = 0;
        Integer ball = 0;
        boolean gameActive = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameActive) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            Integer inputNum = Integer.parseInt(input);
            exceptionController.validateThreeDigitNumber(inputNum);
            List<Integer> inputNumList = numberController.splitter(inputNum);

            Map<String, Integer> report = numberController.compareNumberList(computerNumberList,
                inputNumList);
            strike = report.get("strike");
            ball = report.get("ball");

            gameActive = handleGameActive(strike, ball);

            if (strike == 3 && gameActive == true) {
                computerNumberList = numberController.generateComputerNumberList();
            }
        }
    }

    public boolean handleGameActive(int strike, int ball) {
        reportGameResult(strike, ball);

        if (strike != 3) {
            return true;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int gameProgressNumber = Integer.parseInt(Console.readLine());
        exceptionController.validateGameProgressNumber(gameProgressNumber);

        if (gameProgressNumber == 1) {
            return true;
        }
        System.out.println("게임 종료");
        return false;
    }

    public void reportGameResult(int strike, int ball) {
        if (strike != 3) {
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
            if (strike != 0 && ball != 0) {
                System.out.println(ball + "볼" + " " + strike + "스트라이크");
            }
            if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            }
            if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            }
        }
        System.out.println("3스트라이크");
    }

}
