package baseball;

public class PitchResult {
    private int ball;
    private int strike;

    private final RandomNumber randomNumber;

    public PitchResult(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getStrike() {
        return strike;
    }

    public void addBall(int ball) {
        this.ball = ball + 1;
    }

    public void addStrike(int strike) {
        this.strike = strike + 1;
    }

    public void judgePitch(String inputString) {
        for (int idx = InputRange.START_INDEX.getValue(); idx < InputRange.CORRECT_INPUT_RANGE.getValue(); idx++) {
            if (randomNumber.getRandomNumber().get(idx).equals(Character.getNumericValue(inputString.charAt(idx)))) {
                addStrike(strike);
            } else if (randomNumber.getRandomNumber().contains(Character.getNumericValue(inputString.charAt(idx)))) {
                addBall(ball);
            }
        }
    }

    public void printPitchResult() {
        if (strike == PitchRange.MIN_STRIKES.getValue() && ball == PitchRange.MIN_BALLS.getValue()) {
            System.out.println("낫싱");
            return;
        }

        if (strike == PitchRange.MAX_STRIKES.getValue()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하시면 2를 입력하세요.");
            return;
        }

        if (ball == PitchRange.MIN_BALLS.getValue()) {
            System.out.println(strike + "스트라이크");
            return;
        }

        if (strike == PitchRange.MIN_STRIKES.getValue()) {
            System.out.println(ball + "볼");
            return;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

}
