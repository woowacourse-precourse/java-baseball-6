package baseball.view;

import baseball.model.Score;
import baseball.util.Messages;
import baseball.util.NumValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public void displayGameStartMessage() {
        // 게임 시작 메시지 출력
        System.out.println(Messages.GAME_START_MESSAGE);
    }

    public String getUserInput() {
        // 사용자 입력을 받아 반환
        System.out.print(Messages.INPUT_PROMPT);
        String num = Console.readLine();
        NumValidator.isValid(num);
        return num;
    }

    public void displayScore(Score score) {
        // 점수 출력
        if (score.getBall() > 0) {
            System.out.print(score.getBall() + "볼 ");
        }
        if (score.getStrike() > 0) {
            System.out.print(score.getStrike() + "스트라이크 ");
        }
        if (score.getStrike() == 0 && score.getBall() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void displayGameOverMessage() {
        // 게임 종료 메시지 출력
        System.out.println(Messages.STRIKE_MESSAGE);
    }

    public boolean askForReplay() {
        // 재시작 여부 묻기
        System.out.println(Messages.REPLAY_PROMPT);
        int replay = Integer.parseInt(Console.readLine());
        return replay != 2;
    }

    public static void displayErrorMessage(String errorMessage) {
        // 예외 메시지 출력
        System.err.println(errorMessage);
    }
}
