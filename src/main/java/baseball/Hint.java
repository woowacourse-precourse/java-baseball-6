package baseball;

import java.util.List;

public class Hint {

    public HintCountDto calHint(List<Integer> answer, List<Integer> userNum) {
        HintCountDto hintCountDto = new HintCountDto();
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == userNum.get(i)) {
                hintCountDto.plusStrike();
                continue;
            }
            if (answer.contains(userNum.get(i))) {
                hintCountDto.plusBall();
            }
        }
        return hintCountDto;
    }

    public boolean printHint(HintCountDto hintCountDto) {
        int strike = hintCountDto.getStrike();
        int ball = hintCountDto.getBall();

        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }

        if (ball > 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
            return false;
        }

        if (ball == 0 && strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return false;
        }

        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }
}
