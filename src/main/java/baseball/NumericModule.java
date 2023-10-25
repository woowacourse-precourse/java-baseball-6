package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumericModule {

    private NumericModule() {
    }

    public static List<Integer> getRandomNumberList(int length) {
        List<Integer> list = new ArrayList<>();
        while (list.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }
        return list;
    }

    public static List<Integer> stringToIntegerList(String string) {
        List<Integer> numberList = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            int number = Character.getNumericValue(ch);
            numberList.add(number);
        }
        return numberList;
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
