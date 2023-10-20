package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberArray {

    private List<Integer> numList = new ArrayList<>();

    public NumberArray() {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }

    public NumberArray(String num) {
        int length = num.length();
        System.out.println(length);
        if (length != 3) {
            throw new IllegalArgumentException("3개의 값만 입력하세요.");
        }

        for (int i = 0; i < length; i++) {
            char character = num.charAt(i);
            if (((int) character > 57) || ((int) character < 48)) {
                System.out.println((int) character);
                throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다");
            }

            int intValue = Character.getNumericValue(character);
            if (numList.contains(intValue)) {
                throw new IllegalArgumentException("서로다른 숫자 3개를 입력하셔야 합니다.");

            }
            numList.add(intValue);
        }
    }
}
