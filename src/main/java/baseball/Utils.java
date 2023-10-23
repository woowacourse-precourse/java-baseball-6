package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Utils {


    public static boolean isInRange(int number, int start, int end) {
        return number >= start && number <= end;
    }


    public static List<Integer> splitNumberToDigitList(int number) {
        LinkedList<Integer> digitList = new LinkedList<>();
        while (number > 0) {
            int digit = number % 10;
            digitList.addFirst(digit);
            number /= 10;
        }
        return digitList;
    }

    public static List<Integer> createUniqueNumberList(int size, int start, int end) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }
}
