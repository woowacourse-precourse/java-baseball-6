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
            int digit = number % 10; // 나머지를 구해서 현재 자릿수를 얻습니다.
            digitList.addFirst(digit); // 리스트의 앞쪽에 자릿수를 추가합니다.
            number /= 10; // 다음 자릿수를 처리하기 위해 숫자를 나눕니다.
        }

        return digitList;
    }
}
