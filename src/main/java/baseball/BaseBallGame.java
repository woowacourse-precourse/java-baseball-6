package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBallGame {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_LENGTH = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void gameStart() {
        printStartMessage();

        while(true) {

        }
    }

    private void printPlayerInputMessage() {
        System.out.println(PLAYER_INPUT_MESSAGE);
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    private List<Integer> getRandomNumber() {
        Set<Integer> computerNumber = new HashSet<>();

        while(computerNumber.size() < RANDOM_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

            computerNumber.add(randomNumber);
        }

        return computerNumber.stream().toList();
    }

    private boolean isInvalidInput(String input) {
        return isNumeric(input) && isUniqueDigits(input) && isThreeDigit(input);
    }

    private boolean isNumeric(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isUniqueDigits(String input) {
        for (int i = 0; i < input.length(); i++) {
            if(input.indexOf(input.charAt(i)) != i) {
                return false;
            }
        }

        return true;
    }

    private boolean isThreeDigit(String input) {
        return input.length() == 3;
    }
}
