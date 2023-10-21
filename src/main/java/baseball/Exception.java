package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 예외처리 클래스
 */
public class Exception {
    public List<Integer> numberList = new ArrayList<>();
    /**
     * 모든 예외처리 과정을 거치는 메소드.
     * 예외가 발생하지 않았다면 문자열을 int list로 반환해줌
     */
    public List<Integer> isValid(String number) {
        inRange(number);
        numberList = convertStringToIntList(number);
        checkDuplicate(numberList);
        checkCount(numberList);

        return numberList;
    }

    /*
     * 숫자들이 모두 1~9인지 확인
     */
    private void inRange(String number) {
        if (!number.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 1~9 사이의 숫자를 입력해 주세요.");
        }
    }
    /*
     * 숫자 중 중복이 없는지 확인
     */
    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicate = new HashSet<>(numbers);
        if (numbers.size() != noDuplicate.size()) {
            throw new IllegalArgumentException("[ERROR] 중복이 아닌 숫자를 입력해 주세요.");
        }
    }
    /*
     * 숫자 개수가 3개인지 확인
     */
    private void checkCount(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 숫자를 세개 입력해 주세요.");
        }
    }
    /*
     * 문자열 입력을 int list로 변환해주는 메소드
     */
    private List<Integer> convertStringToIntList(String number) {
        List<Integer> list = new ArrayList<>();

        for (String n : number.split("")) {
            list.add(Integer.parseInt(n));
        }
        return list;
    }


}
