package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * 플레이어의 역할을 하는 클래스입니다.
 */
public class Person {
    private final List<Integer> inputList;

    /**
     * Person 객체를 생성하고 숫자 리스트를 초기화합니다.
     */
    public Person() {
        inputList = new ArrayList<>();
    }

    /**
     * 저장된 숫자 리스트에서 특정 인덱스의 숫자를 반환합니다.
     *
     * @param index 리스트의 인덱스
     * @return 해당 인덱스의 숫자
     */
    public int getNumberAt(int index) {
        return inputList.get(index);
    }

    /**
     * 사용자 입력을 검증하고 저장합니다.
     *
     * @param input 사용자로부터 입력받은 숫자 문자열
     */
    public void insertNumberAndValidate(String input) {
        InputValidator.validateNumberInput(input);
        for (char ch : input.toCharArray()) {
            inputList.add(Character.getNumericValue(ch));
        }
    }

    /**
     * 저장된 숫자 리스트를 초기화합니다.
     */
    public void cleanList() {
        inputList.clear();
    }
}
