package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameProcessor {

    private static final int INITIAL_RANDOM_NUMBER = 1;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int DIGIT_LENGTH_LIMIT = 3;

    private List<String> generateRandomNumberList(Data data) {
        List<String> randomNumberList = data.getRandomNumberList();

        if (randomNumberList.isEmpty()) {
            for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
                int randomNumber = Randoms.pickNumberInRange(INITIAL_RANDOM_NUMBER,
                        LAST_RANDOM_NUMBER);
                randomNumberList.add(String.valueOf(randomNumber));
            }
            data.setRandomNumberList(randomNumberList);
        }
        return randomNumberList;
    }

    private List<String> generateUserNumberList(Data data) {
        List<String> userNumberList = new ArrayList<>();
        String userNumberString = data.getUserNumber();

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            char digitChar = userNumberString.charAt(i);
            userNumberList.add(String.valueOf(digitChar));
        }
        data.setUserNumberList(userNumberList);
        return userNumberList;
    }

    private int calculateBall(List<String> userNumberList,
            List<String> randomNumberList) {
        int ball = 0;

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            for (int j = 0; j < DIGIT_LENGTH_LIMIT; j++) {
                if (userNumberList.get(i).equals(randomNumberList.get(j)) && i != j) {
                    ball++;
                }
            }
        }
        return ball;
    }

    private int calculateStrike(List<String> userNumberList,
            List<String> randomNumberList) {
        int strike = 0;

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public Boolean validateFullStrike(Data data) {
        boolean isFullStrike = false;
        if (data.getStrike() == DIGIT_LENGTH_LIMIT) {
            isFullStrike = true;
        }
        return isFullStrike;
    }

    public String generateResultText(Data data, MessageManager messageManager) {
        List<String> userNumberList = generateUserNumberList(data);
        List<String> randomNumberList = generateRandomNumberList(data);

        int ball = calculateBall(userNumberList, randomNumberList);
        int strike = calculateStrike(userNumberList, randomNumberList);

        data.setBall(ball);
        data.setStrike(strike);
        data.setIsCompleteAnswer(validateFullStrike(data));

        String resultText;
        StringBuilder resultTextBuilder = new StringBuilder();

        if (ball > 0 && strike > 0) {
            resultTextBuilder.append(ball);
            resultTextBuilder.append(messageManager.getBallText());
            resultTextBuilder.append(" ");
            resultTextBuilder.append(strike);
            resultTextBuilder.append(messageManager.getStrikeText());
        }
        if (ball > 0 && strike == 0) {
            resultTextBuilder.append(ball);
            resultTextBuilder.append(messageManager.getBallText());
        }
        if (ball == 0 && strike > 0) {
            resultTextBuilder.append(strike);
            resultTextBuilder.append(messageManager.getStrikeText());
        }
        if (ball == 0 && strike == 0) {
            resultTextBuilder.append(messageManager.getNothingText());
        }

        resultText = resultTextBuilder.toString();

        return resultText;
    }

    public boolean illegalArgumentException(Data data) {
        boolean isError = false;
        if ((data.getUserNumber().length()) != DIGIT_LENGTH_LIMIT) {
            isError = true;
        }
        return isError;
    }
}
