package baseball.controller;

import baseball.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

/**
 * 유저의 입출력을 처리하는 컨트롤러
 */
public class GameController {

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void controlRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());
        if (input == 1) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.run();
        }
    }

    public void checkStrikeOrBall(int ballCount, int strikeCount) {
        StringBuilder sb = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        if (ballCount != 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (strikeCount == 3) {
            sb.append("\n");
            sb.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println(sb.toString());
    }
}
