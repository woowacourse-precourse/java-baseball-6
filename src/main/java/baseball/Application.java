package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();

        printMessage("숫자 야구 게임을 시작합니다.\n");
        Long computerCodeId = gameController.gameStart();

        boolean pass = false;
        boolean restart = false;
        String input;
        String command;
        Map<Grade, Integer> result;
        while(!pass) {
            printMessage("숫자를 입력해주세요 : ");
            input = Console.readLine();
            result = gameController.guessCode(input, computerCodeId);
            pass = gameController.determineGameStatus(result);

            printResult(result);

            if(pass) {
                printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                command = Console.readLine();
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

    private static void printResult(final Map<Grade, Integer> resultMap) {
        if(resultMap.get(Grade.BALL) != 0) {
            System.out.print(resultMap.get(Grade.BALL) + "볼");
        }
        if(resultMap.get(Grade.BALL) != 0 && resultMap.get(Grade.STRIKE) != 0) {
            System.out.print(" ");
        }
        if(resultMap.get(Grade.STRIKE) != 0) {
            System.out.print(resultMap.get(Grade.STRIKE) + "스트라이크");
        }
        if(resultMap.get(Grade.BALL) == 0 && resultMap.get(Grade.STRIKE) == 0) {
            System.out.print("낫싱");
        }
        System.out.print("\n");
    }

    private static void printMessage(final String message) {
        System.out.print(message);
    }
}
