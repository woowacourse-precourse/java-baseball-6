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

        while (true) {
            List<Integer> splitDigitsFromUserInput = inputUserNumber();
            boolean resultByCompare = compareUserInputByComputerNumber(splitDigitsFromUserInput);
            if (resultByCompare) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isContinueByUserInput = Console.readLine();
                if (isContinueByUserInput.equals("1")) {
                    initComputerNumber();
                } else if (isContinueByUserInput.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException(
                            "잘못된 값을 입력했습니다" + " you input = " + isContinueByUserInput);
                }
            }
        }

    }


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

    public static boolean evaluateByResult(int strikeNumber, int ballNumber, int nothingNumber) {
        if (strikeNumber == numLength) {
            System.out.println(numLength + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (nothingNumber == numLength) {
            System.out.println("낫싱");
        } else if (strikeNumber != 0 || ballNumber != 0) {
            if (ballNumber != 0) {
                System.out.print(ballNumber + "볼 ");
            }
            if (strikeNumber != 0) {
                System.out.println(strikeNumber + "스트라이크");
            }
            System.out.println();
        }
        return false;
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
