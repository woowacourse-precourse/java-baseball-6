package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException {

    public void validNumberLength(String playerNumber) {
        if(playerNumber.length()!=3) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
    }

    public void validNumberType(String playerNumber) {
        String regExp = "[1-9]+";
        if(!playerNumber.matches(regExp)) {
            throw new IllegalArgumentException("0을 제외한 숫자만 입력하세요.");
        }
    }

    public void validDuplicateNumber(String playerNumber) {
        Set<Character> checkNumber = new HashSet<>();
        for(int i=0; i<3; i++) {
            checkNumber.add(playerNumber.charAt(i));
        }
        if(checkNumber.size()!=3) {
            new IllegalArgumentException("중복되는 숫자 없이 입력하세요.");
        }
    }

    public void validOption(String option) {
        if(!option.equals("1") && !option.equals("2")) {
            new IllegalArgumentException("1과 2 중에서 선택하세요.");
        }
    }
}
