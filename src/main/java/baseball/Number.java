package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Number {
    Number(String string) {
        this.list = toArrayList(string);
    }

    public ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> toArrayList(String number) {
        checkValidity(number);
        ArrayList<Integer> numberArray = new ArrayList<>();
        String[] strArr = number.split("");
        for (String str : strArr) {
            numberArray.add(Integer.parseInt(str));
        }
        checkRedundancy(numberArray);
        return numberArray;
    }

    private void checkValidity(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            error();
        }
        if (str.length() != 3) {
            error();
        }
    }

    private void checkRedundancy(ArrayList<Integer> number) {
        Set<Integer> set = new HashSet<>();
        for (int i : number) {
            if (set.contains(i)) {
                error();
            } else {
                set.add(i);
            }
        }
    }

    private void error() {
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }
}
