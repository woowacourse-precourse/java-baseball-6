package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballController.startGame();
    }
}

class BaseballController {

    public static void startGame() {
        Answer answer = new Answer(QuizMaker.createNewQuiz());

        while (answer.isTrying()) {
            UserBall userBall = InputView.getUserBallByUserInput();
            ResultBall resultBall = answer.getResultBallByUserBall(userBall);
            ResultView.printResultByResultBall(resultBall);
        }

        if (FinishView.needMoreGame()){
            startGame();
        }
    }
}

class QuizMaker {

    private static final int MINIMUM_NUMBER = 1;

    private static final int MAXIMUM_NUMBER = 9;

    private static final int LENGTH_OF_QUIZ = 3;


    public static List<Integer> createNewQuiz() {
        Set<Integer> quizSet = new HashSet<>();
        while(quizSet.size() < LENGTH_OF_QUIZ) {
                quizSet.add(Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }

        return new ArrayList<>(quizSet);
    }
}

class Answer {


    private List<Integer> answer;

    private boolean isTrying = true;

    public Answer(List<Integer> newQuiz) {
        this.answer = newQuiz;
    }

    public boolean isTrying() {
        return isTrying;
    }

    public ResultBall getResultBallByUserBall(UserBall userBall) {
        List<Integer> userInputList = userBall.getUserInputList();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            Integer answerNumber = answer.get(i);
            Integer userInputNumber = userInputList.get(i);

            if (answerNumber == userInputNumber) {
                strike++;
            } else if (answer.contains(userInputNumber)) {
                ball++;
            }
        }

        setIsTryingByStrike(strike);
        return new ResultBall(strike, ball);

    }

    private void setIsTryingByStrike(int strike) {
        if (strike == 3) {
            isTrying = false;
        }
    }
}

class UserBall {
    private final List<Integer> userInputList;

    public UserBall(List<Integer> userInputList) {
        this.userInputList = userInputList;
    }

    public List<Integer> getUserInputList() {
        return userInputList;
    }
}

class ResultBall {

    private final int strike;

    private final int ball;

    public ResultBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}

class InputView {

    private static final String MESSAGE_TO_ASK_USER_INPUT = "숫자를 입력해주세요 : ";

    private static final int VALID_LENGTH_OF_USER_INPUT = 3;

    private static final String VALID_NUMBER_PATTERN = "^[1-9]{3}$";

    public static UserBall getUserBallByUserInput() {
        System.out.print(MESSAGE_TO_ASK_USER_INPUT);
        return validateUserInput(Console.readLine());
    }

    private static UserBall validateUserInput(String userInput) {
        validateLength(userInput);
        validateOnlyNumbers(userInput);
        validateDuplicate(userInput);

        return getUserBallByUserInput(userInput);
    }

    private static void validateLength(String userInput) {
        if (userInput.length() != VALID_LENGTH_OF_USER_INPUT) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOnlyNumbers(String userInput) {
        if (!userInput.matches(VALID_NUMBER_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(String userInput) {
        Set<Character> characterSet = new HashSet<>();
        for (Character character : userInput.toCharArray()) {
            characterSet.add(character);
        }

        if (characterSet.size() != VALID_LENGTH_OF_USER_INPUT) {
            throw new IllegalArgumentException();
        }
    }

    private static UserBall getUserBallByUserInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (Character character : userInput.toCharArray()) {
            userInputList.add(Integer.parseInt(String.valueOf(character)));
        }

        return new UserBall(userInputList);
    }
}

class ResultView {

    private static final String BALL_MESSAGE = "볼";

    private static final String STRIKE_MESSAGE = "스트라이크";

    private static final String BETWEEN_MESSAGE = " ";

    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printResultByResultBall(ResultBall resultBall) {
        int strike = resultBall.getStrike();
        int ball = resultBall.getBall();

        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(getBallMessage(ball));
        resultMessageBuilder.append(getBetweenMessage(ball,strike));
        resultMessageBuilder.append(getStrikeMessage(strike));
        resultMessageBuilder.append(getNothingMessage(ball, strike));

        System.out.println(resultMessageBuilder);
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return "";
        }

        return ball + BALL_MESSAGE;
    }

    private static String getBetweenMessage(int ball, int strike) {
        if ((ball != 0) && (strike != 0)) {
            return BETWEEN_MESSAGE;
        }

        return "";
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return "";
        }

        return strike + STRIKE_MESSAGE;
    }

    private static String getNothingMessage(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            return NOTHING_MESSAGE;
        }

        return "";
    }


}


class FinishView {


    public static final String CORRECT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String NEW_GAME_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";



    public static boolean needMoreGame() {
        System.out.println(CORRECT_ANSWER_MESSAGE);
        System.out.println(NEW_GAME_OR_EXIT_MESSAGE);
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return true;
        }

        return false;
    }
}