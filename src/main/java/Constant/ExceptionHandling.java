package Constant;

import java.util.ArrayList;

public abstract class ExceptionHandling {
    public static void ExceptionLength(ArrayList<Integer> Numbers) {
        if (Numbers.size() != 3) {
            throw new IllegalArgumentException("세자리 수가 아님");
        }
    }

    public static void ExceptionDuplication(ArrayList<Integer> Numbers) {
        for (int i = 0; i < Numbers.size(); i++) {
            for (int j = i + 1; j < Numbers.size(); j++) {
                if (Numbers.get(i).equals(Numbers.get(j))) {
                    throw new IllegalArgumentException("중복되는 숫자가 있음");
                }
            }
        }
    }
    public static void ExceptionNotOneTwo() {
        throw new IllegalArgumentException("1과 2가 아닌 입력")
    }
}
