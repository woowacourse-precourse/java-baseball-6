package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true) {
            NumberBaseball game = new NumberBaseball();

            while(true) {
                System.out.print("숫자를 입력해 주세요 : ");
                String inputString = Console.readLine();

                int[] userNumber = InputManager.parseInput(inputString);

                System.out.println(game.getResultMsg(userNumber));

                if(game.isEnd()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartInput = Console.readLine();

            if(!InputManager.validateRestartInput(restartInput)) {
                throw new IllegalArgumentException();
            }

            if(restartInput.equals("2")) {
                break;
            }
        }
    }


}
