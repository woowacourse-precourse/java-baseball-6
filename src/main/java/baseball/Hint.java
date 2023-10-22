package baseball;

public class Hint {

    public static HintCountDto calHint(String answer, String userNum) {
        HintCountDto hintCountDto = new HintCountDto();
        for (int i = 0; i < 3; i++) {
            if (answer.charAt(i) == userNum.charAt(i)) {
                hintCountDto.plusStrike();
            } else if (answer.indexOf(userNum.charAt(i)) != -1) {
                hintCountDto.plusBall();
            }
        }
        return hintCountDto;
    }

    public static boolean printHint(HintCountDto hintCountDto) {
        int ball = hintCountDto.getBall();
        int strike = hintCountDto.getStrike();

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
        } else if (ball == 0 && strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        }
        return false;
    }
}
