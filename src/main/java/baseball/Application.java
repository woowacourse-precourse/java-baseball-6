package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        System.out.print("숫자 야구 게임을 시작합니다.\n");
        Long computerCodeId = gameController.gameStart();

        boolean pass = false;
        boolean restart = false;
        Map<Grade, Integer> result;
        while(!pass) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            result = gameController.guessCode(input, computerCodeId);
            pass = gameController.determineGameStatus(result);

            printResult(result);

            if(pass) {
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                String command = Console.readLine();
                restart = gameController.determineRestarting(command);

                gameController.initializeSetting(computerCodeId);
            }

            if(restart) {
                computerCodeId = gameController.gameStart();
                pass = false;
                restart = false;
            }
        }
    }

    private static void printResult(Map<Grade, Integer> resultMap) {
        if(resultMap.get(Grade.BALL) != 0)
            System.out.print(resultMap.get(Grade.BALL)+"볼 ");
        if(resultMap.get(Grade.STRIKE) != 0)
            System.out.print(resultMap.get(Grade.STRIKE)+"스트라이크");
        if(resultMap.get(Grade.BALL) == 0 && resultMap.get(Grade.STRIKE) == 0)
            System.out.print("낫싱");
        System.out.print("\n");
    }
}
