package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
public final class Utils {
    public static void validateRestartOrExitInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }

    public static List<Integer> createRandomNumberList(int length) {
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }

    public static void validateUserInput(String input) {
        validateStringLength(input, 3);
        validateStringNaturalNumbers(input);
        validateAllDifferentCharacters(input);
    }

    public static void validateStringLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("입력값의 길이가 " + length + "가 아닙니다. 프로그램을 종료합니다.");
        }
    }

