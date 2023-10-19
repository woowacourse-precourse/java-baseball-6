package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        int ballCount = baseballGame.getBallCount(userInput);
        int strikeCount = baseballGame.getStrikeCount(userInput);
    }
}
