package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {
    public String inputUserNumber() {
        return Console.readLine();
    }

    public static List<Integer> splitDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        digits.add(number / 100); // 백의자리 추출하여 리스트에 추가
        digits.add((number % 100) / 10); // 십의자리 추출하여 리스트에 추가
        digits.add(number % 10); // 일의자리 추출하여 리스트에 추가
        return digits;
    }
}
