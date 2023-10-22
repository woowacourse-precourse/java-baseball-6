package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameProcessor {

    private static final int INITIAL_RANDOM_NUMBER = 1;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int DIGIT_SIZE = 3;

    private List<String> generateRandomNumberList() {
        List<String> randomNumberList = new ArrayList<>();
        for (int i = 0; i < DIGIT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);
            randomNumberList.add(String.valueOf(randomNumber));
        }
        return randomNumberList;
    }

    private List<String> generateUserNumberList(Data data) {
        List<String> userNumberList = new ArrayList<>();

        String userNumberString = data.getUserAnswerNumber();

        for (int i = 0; i < DIGIT_SIZE; i++) {
            char digitChar = userNumberString.charAt(i);
            userNumberList.add(String.valueOf(digitChar));
        }
        return userNumberList;
    }

    private String calculateStrike(Data data, List<String> userNumberList, List<String> randomNumberList) {
        int strike = 0;

        for (int i = 0; i < DIGIT_SIZE; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strike++;
            }
        }
        return String.valueOf(strike);
    }

    private String calculateBall(Data data, List<String> userNumberList, List<String> randomNumberList) {
        int ball = 0;

        for (int i = 0; i < DIGIT_SIZE; i++) {
            for (int j = 0; j < DIGIT_SIZE; j++) {
                if (userNumberList.get(i).equals(randomNumberList.get(j))) {
                    ball++;
                    break;
                }
            }
        }
        return String.valueOf(ball);
    }

    private List<String> calculateStrikeBall(Data data) {
        List<String> strikeBall = Arrays.asList("0", "0");
        List<String> userNumberList = generateUserNumberList(data);
        List<String> randomNumberList = generateRandomNumberList();

        String strike = calculateStrike(data, userNumberList, randomNumberList);
        String ball = calculateBall(data, userNumberList, randomNumberList);

        strikeBall.set(0, strike);
        strikeBall.set(1, ball);

        System.out.println("strikeBall: " + strikeBall);
        System.out.println("userNumberList: " + userNumberList);
        System.out.println("randomNumberList: " + randomNumberList);

        return strikeBall;
    }

    public Boolean validateCompleteAnswer(Data data) {
        boolean isCompleteAnswer = false;
        if (data.getAnswerList().get(0).equals("3")) {
            isCompleteAnswer = true;
        }
        return isCompleteAnswer;
    }

    public String generateAnswerText(Data data, MessageManager messageManager) {
        String answerText;
        StringBuilder answerTextBuilder = new StringBuilder();
        List<String> answerList = calculateStrikeBall(data);
        System.out.println("answerList: " + answerList);

        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) > 0) {
            answerTextBuilder.append(answerList.get(0));
            answerTextBuilder.append(messageManager.getSameDigitMessage());
            answerTextBuilder.append(" ");
            answerTextBuilder.append(answerList.get(1));
            answerTextBuilder.append(messageManager.getSameNumberMessage());
        }
        if (Integer.parseInt(answerList.get(0)) > 0 && Integer.parseInt(answerList.get(1)) == 0) {
            answerTextBuilder.append(answerList.get(0));
            answerTextBuilder.append(messageManager.getSameDigitMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) > 0) {
            answerTextBuilder.append(answerList.get(1));
            answerTextBuilder.append(messageManager.getSameNumberMessage());
        }
        if (Integer.parseInt(answerList.get(0)) == 0 && Integer.parseInt(answerList.get(1)) == 0) {
            answerTextBuilder.append(messageManager.getWrongMessage());
        }

        data.setAnswerList(answerList);
        answerText = answerTextBuilder.toString();

        return answerText;
    }

    public boolean illegalArgumentException(Data data) {
        boolean error = false;
        if ((data.getUserAnswerNumber().length()) != 3) {
            System.out.println("세자리 수를 입력해 주세요.");
            error = true;
        }
        return error;
    }


}
