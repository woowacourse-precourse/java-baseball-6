package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int startInclusive = 1;
    public static final int endInclusive = 9;

    private static final int numLength = 3;

    public static List<Integer> splitDigitsFromRandomNumber = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        initComputerNumber();
    public static boolean compareUserInputByComputerNumber(List<Integer> splitDigitsFromUserInput) {
        int strikeNumber = 0;
        int ballNumber = 0;
        int nothingNumber = 0;
        int trackIdx = 0;

        for (Integer userDigit : splitDigitsFromUserInput) {
            if (userDigit.equals(splitDigitsFromRandomNumber.get(trackIdx))) {
                strikeNumber++;
            } else if (splitDigitsFromRandomNumber.contains(userDigit)) {
                ballNumber++;
            } else {
                nothingNumber++;
            }
            trackIdx++;
        }

        return evaluateByResult(strikeNumber, ballNumber, nothingNumber);
    }
    public static void initComputerNumber() {
        splitDigitsFromRandomNumber.clear();
        while (splitDigitsFromRandomNumber.size() < numLength) {
            //여기서 IllegalArgumentException 고려해봐야 한다.
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (!splitDigitsFromRandomNumber.contains(randomNumber)) {
                splitDigitsFromRandomNumber.add(randomNumber);
            }
        }
    }

    public static List<Integer> inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String stringDigitsFromUserInput = Console.readLine();
        validateUserInputLength(stringDigitsFromUserInput);
        return splitDigits(stringDigitsFromUserInput);
    }

    private static void validateUserInputLength(String stringDigitsFromUserInput) {
        if (stringDigitsFromUserInput.length() != numLength) {
            throw new IllegalArgumentException("숫자의 길이가 " + numLength + "와 다릅니다.");
        }
    }

    private static List<Integer> splitDigits(String stringDigitsFromUserInput) {
        List<Integer> splitDigitsFromUserInput = new ArrayList<>();
        for (int i = 0; i < stringDigitsFromUserInput.length(); i++) {
            int number = Character.getNumericValue(stringDigitsFromUserInput.charAt(i));
            if (!splitDigitsFromUserInput.contains(number)) {
                splitDigitsFromUserInput.add(number);
            }
        }
        if (splitDigitsFromUserInput.size() != numLength) {
            throw new IllegalArgumentException("중복된 숫자 존재");
        }
        return splitDigitsFromUserInput;
    }
}
