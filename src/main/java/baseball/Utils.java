package baseball;

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
}
