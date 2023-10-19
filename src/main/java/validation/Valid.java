package validation;

import static constant.BaseConst.EXIT;
import static constant.BaseConst.RESTART;

public class Valid {


    public void myNumberValid(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자는 사용할 수 없음");
        }
        if (number.length() != 3) throw new IllegalArgumentException("3개의 숫자를 입력할 수 있음");
        if (number.contains("0")) throw new IllegalArgumentException("0은 사용할 수 없음");

        for (int i = 0; i < number.length()-1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)){
                    throw new IllegalArgumentException("중복된 숫자는 사용할 수 없음");
                }
            }
        }
    }

    public void restartValid(String text) {
        try {
            int number = Integer.parseInt(text);
            if (number != RESTART && number != EXIT) {
                throw new IllegalArgumentException("게임을 재시작하려면 1, 종료하려면 2를 입력해야함");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("재시작 여부는 숫자로만 이루어져야함");
        }
    }
}
