package baseball;

import java.util.List;

public class Hint {

    public HintDto calHint(List<Integer> answer, List<Integer> userNum) {
        HintDto hintDto = new HintDto();
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == userNum.get(i)) {
                hintDto.plusStrike();
                continue;
            }
            if (answer.contains(userNum.get(i))) {
                hintDto.plusBall();
            }
        }
        return hintDto;
    }

    public boolean printHint(HintDto hintDto) {
        int strike = hintDto.getStrike();
        int ball = hintDto.getBall();

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
