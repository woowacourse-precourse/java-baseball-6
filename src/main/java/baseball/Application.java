package baseball;

import baseball.Controller.GameController;
import baseball.Service.CompareNumberService;
import baseball.Service.RandomGenerator;
import baseball.View.Input;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        boolean gameRunning = true;
        while (gameRunning) {
            String randomNum = RandomGenerator.getRandomNumber();
//            System.out.println(randomNum);
            System.out.println("숫자 야구 게임을 시작합니다.");
            while (true) {
                String userNum = Input.inputUserNumber();

                CompareNumberService compareNumberService = new CompareNumberService();
                String result = compareNumberService.CompareNumbers(userNum, randomNum);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break; // 게임 종료
                }
            }

            String choice = Input.inputRetryNumber();

            if (!choice.equals("1")) {
                gameRunning = false; // 게임 종료
            }
        }

        }
}


