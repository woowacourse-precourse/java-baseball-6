package validation;

import java.util.HashSet;
import java.util.Set;

import static constant.BaseConst.*;

public class Valid {


    public void myNumberValid(String number) {

        if (number.matches("[^1-9]")) throw new IllegalArgumentException("문자와 0은 사용할 수 없음");
        if (number.length() != MAX_LENGTH) throw new IllegalArgumentException(MAX_LENGTH + "개의 숫자를 입력할 수 있음");

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            if (!set.add(number.charAt(i))) {
                throw new IllegalArgumentException("중복된 숫자는 사용할 수 없음");
            }
        }
    }

    public void restartValid(String text) {
        if (text.matches("[^12]")){
            throw new IllegalArgumentException("게임을 재시작하려면 1, 종료하려면 2를 입력해야함");
        }
        if (text.length() != 1) {
            throw new IllegalArgumentException("숫자 하나만 입력해야함");
        }

    }
}
