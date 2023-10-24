package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GameModel {
    private static final int NUMBER_SIZE = 3;
    private List<Integer> computer;

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String END_MESSAGE = "게임 종료";
    public static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String ASK_NUMBERS = "숫자를 입력해주세요 : ";

    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";

    public GameModel() {
        this.computer = new ArrayList<>();
    }

    public List<Integer> checkAnswer(String input) {
        validateInput(input);

        List<Integer> answer = convertInputToList(input);

        int strike = calculateStrikes(answer);
        int ball = calculateBalls(answer);

        List<Integer> result = new ArrayList<>();
        result.add(strike);
        result.add(ball);

        return result;
    }

    public void generateComputerNumber() {
        computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    private void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            answer.add(input.charAt(i) - '0');
        }
        return answer;
    }

    private int calculateStrikes(List<Integer> answer) {
        int strike = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (Objects.equals(answer.get(i), computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBalls(List<Integer> answer) {
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (!answer.get(i).equals(computer.get(i)) && computer.contains(answer.get(i))) {
                ball++;
            }
        }
        return ball;
    }

}
