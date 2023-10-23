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
        String userNumberString = data.getUserAnswerNumber();

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            char digitChar = userNumberString.charAt(i);
            userNumberList.add(String.valueOf(digitChar));
        }
        return userNumberList;
    }

    private String calculateBall(List<String> userNumberList,
            List<String> randomNumberList) {
        int ball = 0;

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            for (int j = 0; j < DIGIT_LENGTH_LIMIT; j++) {
                if (userNumberList.get(i).equals(randomNumberList.get(j))) {
                    ball++;
                    break;
                }
            }
        }
        return String.valueOf(ball);
    }

    private String calculateStrike(List<String> userNumberList,
            List<String> randomNumberList) {
        int strike = 0;

        for (int i = 0; i < DIGIT_LENGTH_LIMIT; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strike++;
            }
        }
        return String.valueOf(strike);
    }

    private List<String> calculateStrikeBall(Data data) {
        List<String> strikeBall = data.getAnswerCountList();
        List<String> userNumberList = generateUserNumberList(data);
        List<String> randomNumberList = generateRandomNumberList(data);

        String strike = calculateStrike(userNumberList, randomNumberList);
        String ball = calculateBall(userNumberList, randomNumberList);

        strikeBall.set(0, strike);
        strikeBall.set(1, ball);

        return strikeBall;
    }

    public Boolean validateCompleteAnswer(Data data) {
        boolean isCompleteAnswer = false;
        if (data.getAnswerCountList().get(0).equals(String.valueOf(DIGIT_LENGTH_LIMIT))) {
            isCompleteAnswer = true;
        }
        return isCompleteAnswer;
    }

    public String generateAnswerText(Data data, MessageManager messageManager) {
        String answerText;
        StringBuilder answerTextBuilder = new StringBuilder();
        List<String> answerList = calculateStrikeBall(data);

        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) > 0) {
            if (Integer.parseInt(answerList.get(0)) != 3
                    && (Integer.parseInt(answerList.get(1)) - Integer.parseInt(answerList.get(0)))
                    > 0) {
                answerTextBuilder.append(String.valueOf(
                        Integer.parseInt(answerList.get(1)) - Integer.parseInt(answerList.get(0))));
                answerTextBuilder.append(messageManager.getSameNumberMessage());
                answerTextBuilder.append(" ");
            }
            answerTextBuilder.append(answerList.get(0));
            answerTextBuilder.append(messageManager.getSameDigitMessage());
        }
        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) == 0) {
            answerTextBuilder.append(answerList.get(0));
            answerTextBuilder.append(messageManager.getSameDigitMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) > 0) {
            answerTextBuilder.append(String.valueOf(
                    Integer.parseInt(answerList.get(1)) - Integer.parseInt(answerList.get(0))));
            answerTextBuilder.append(messageManager.getSameNumberMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) == 0) {
            answerTextBuilder.append(messageManager.getWrongMessage());
        }

        data.setAnswerCountList(answerList);
        data.setIsCompleteAnswer(validateCompleteAnswer(data));

        answerText = answerTextBuilder.toString();

        return answerText;
    }

    public boolean illegalArgumentException(Data data) {
        boolean error = false;
        if ((data.getUserAnswerNumber().length()) != 3) {
            error = true;
        }
        return error;
    }


}
