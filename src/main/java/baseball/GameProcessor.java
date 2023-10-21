package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameProcessor {

    private static final int INITIAL_RANDOM_NUMBER = 1;
    private static final int LAST_RANDOM_NUMBER = 9;
    private static final int DIGIT_SIZE = 3;

    private static List<String> generateRandomNumberList() {
        List<String> randomNumberList = new ArrayList<>();
        for (int i = 0; i < DIGIT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(INITIAL_RANDOM_NUMBER, LAST_RANDOM_NUMBER);
            randomNumberList.add(String.valueOf(randomNumber));
        }
        return randomNumberList;
    }

    private static List<String> generateUserNumberList(Data data) {
        List<String> userNumberList = new ArrayList<>();

        String userNumberString = data.getInputData();

        for (int i = 0; i < DIGIT_SIZE; i++) {
            char digitChar = userNumberString.charAt(i);
            userNumberList.add(String.valueOf(digitChar));
        }
        return userNumberList;
    }

    private static String calculateStrike(Data data) {
        int strike = 0;
        List<String> randomNumberList = generateRandomNumberList();
        List<String> userNumberList = generateUserNumberList(data);

        for (int i = 0; i < DIGIT_SIZE; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strike++;
            }
        }
        return String.valueOf(strike);
    }

    public List<String> calculateStrikeBallList(Data data) {
        List<String> strikeBallList = new ArrayList<>();
        List<String> randomNumberList = generateRandomNumberList();
        List<String> userNumberList = generateUserNumberList(data);


    }

    public void IllegalArgumentException(Data data) {
        if ((data.getInputData().length()) > 3) {
            System.out.println("3보다 큽니다");
        }
    }


}
