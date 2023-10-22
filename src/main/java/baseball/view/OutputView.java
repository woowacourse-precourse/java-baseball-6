package baseball.view;

import baseball.constant.Validation;
import baseball.dto.ScoreDto;

public class OutputView {

    public static void printIntro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printScore(ScoreDto scoreDto) {
        int ball = scoreDto.getBall();
        int strike = scoreDto.getStrike();

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        if (ball > 0 & strike > 0) {
            sb.append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        if (ball == 0 & strike == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }

    public static void printFinish() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n",
                Validation.NUMBER_LENGTH);
    }

    public static void printContinue() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%n",
                Validation.CONTINUE_GAME,
                Validation.FINISH_GAME);
    }
}
