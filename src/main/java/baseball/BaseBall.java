package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;

public class BaseBall {

    private final int ANSWER_LENGTH = 3;
    private List<Integer> answer;
    private boolean ended = false;
    private int ball;
    private int strike;


    BaseBall() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.reset();
    }

    public boolean isEnded() {
        return this.ended;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void reset() {
        this.answer = Randoms.pickUniqueNumbersInRange(0, 9, ANSWER_LENGTH);
        System.out.println(this.answer);
        this.ended = false;
    }

    public boolean evaluate(String inputString) {
        this.validateInputString(inputString);
        List<Integer> input = NumericModule.stringToIntegerList(inputString);
        this.compareAnswerToInput(this.answer, input);
        this.printScore();
        if (this.strike == this.ANSWER_LENGTH) {
            System.out.println("숫자를 모두 맞히셨습니다! 게임 종료");
            this.ended = true;
            return true;
        }
        return false;
    }

    public void printScore() {
        int ballCount = this.getBall();
        int strikeCount = this.getStrike();
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    private void compareAnswerToInput(List<Integer> answer, List<Integer> input) {
        this.ball = 0;
        this.strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (Objects.equals(answer.get(i), input.get(i))) {
                this.strike += 1;
            } else if (answer.contains(input.get(i))) {
                this.ball += 1;
            }
        }
    }

    private void validateInputString(String inputString) {
        if (inputString.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException(ANSWER_LENGTH + "개의 숫자를 입력해주세요.");
        }
        if (!NumericModule.isNumeric(inputString)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
