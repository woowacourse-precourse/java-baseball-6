package validator;

import java.util.List;

public class Validator {
    // input의 길이 체크
    public void isRightSize(String str) throws IllegalArgumentException {
        if (str.length() != 3) {
            throw new IllegalArgumentException(); // "길이가 3이 아닙니다."
        }
    }
    // input 받은 값이 int로 변환 가능한지 체크
    public Integer changeToInteger(String str) throws IllegalArgumentException {
        Integer integer = Integer.parseInt(str);
        return integer;
    }
    // 1부터 9까지의 수인지 체크
    public void isRightRange(Integer integer) throws IllegalArgumentException {
        if (integer == 0) {
           throw new IllegalArgumentException();
        }
    }
    // 중복된 숫자가 포함되어 있는지 체크
    public void isContain(List<Integer> list, Integer integer) {
        if (list.contains(integer)) {
            throw new IllegalArgumentException();
        }
    }
}
