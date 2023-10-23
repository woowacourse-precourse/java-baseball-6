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

    private List<Integer> ballStrikeList(Data data) {
        List<Integer> ballStrike = data.getResultList();
        List<String> userNumberList = generateUserNumberList(data);
        List<String> randomNumberList = generateRandomNumberList(data);

        int ball = calculateBall(userNumberList, randomNumberList);
        int strike = calculateStrike(userNumberList, randomNumberList);

        ballStrike.set(0, ball);
        ballStrike.set(1, strike);

        return ballStrike;
    }

    public Boolean validateCompleteAnswer(Data data) {
        boolean isCompleteAnswer = false;
        if (data.getResultList().get(1) == DIGIT_LENGTH_LIMIT) {
            isCompleteAnswer = true;
        }
        return isCompleteAnswer;
    }

    public String generateResultText(Data data, MessageManager messageManager) {
        String resultText;
        StringBuilder resultTextBuilder = new StringBuilder();
        List<Integer> resultList = ballStrikeList(data);

        data.setResultList(resultList);
        data.setIsCompleteAnswer(validateCompleteAnswer(data));

        if (resultList.get(0) > 0 && resultList.get(1) > 0) {
            resultTextBuilder.append(resultList.get(0));
            resultTextBuilder.append(messageManager.getSameNumberMessage());
            resultTextBuilder.append(" ");
            resultTextBuilder.append(resultList.get(1));
            resultTextBuilder.append(messageManager.getSameDigitMessage());
        }
        if (resultList.get(0) > 0 && resultList.get(1) == 0) {
            resultTextBuilder.append(resultList.get(0));
            resultTextBuilder.append(messageManager.getSameNumberMessage());
        }
        if (resultList.get(0) == 0 && resultList.get(1) > 0) {
            resultTextBuilder.append(resultList.get(1));
            resultTextBuilder.append(messageManager.getSameDigitMessage());
        }
        if (resultList.get(0) == 0 && resultList.get(1) == 0) {
            resultTextBuilder.append(messageManager.getWrongMessage());
        }

        resultText = resultTextBuilder.toString();

        return resultText;
    }

    public boolean illegalArgumentException(Data data) {
        boolean error = false;
        if ((data.getUserNumber().length()) != DIGIT_LENGTH_LIMIT) {
            error = true;
        }
        return error;
    }
}
