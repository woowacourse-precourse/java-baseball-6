package baseball;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        Boolean isGameDone = false;

        Boolean isCorrect = false;
        while (!isGameDone) {

            GameManager gameManager = new GameManager();
            List<Integer> randomNumber = gameManager.createRandomNumber();

            while (!isCorrect) {

                System.out.print("숫자를 입력하세요: ");
                List<Integer> userNumber = gameManager.getUserNumber();

                String result = gameManager.match(randomNumber, userNumber);
                System.out.println(result);


                if ("3스트라이크".equals(result)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    if (Integer.parseInt(readLine()) == 2) isGameDone = true;

                    break;
                }
            }
        }
    }

}
