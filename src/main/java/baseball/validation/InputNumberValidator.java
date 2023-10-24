package baseball.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
* 플레이어가 입력한 숫자를 검증하는 클래스
* */
public class InputNumberValidator {

    private static final String RESTART = "1";
    private static final String END = "2";
    private static final String REGEX = "[0-9]+";
    private static final Integer NUMBER_SIZE = 3;

    /*
     * 플레이어의 입력값(String) 전체 검증 메서드
     * @Param input 플레이어의 숫자
     * */
    public List<Integer> validateInputNumber(String input) {
        validateInputSize(input);
        validateInputType(input);
        validateInputDuplication(input);

        return convertStrToList(input);
    }

    /*
    * 플레이어의 입력값(String)을 List로 변환하는 메서드
    * @Param input 플레이어의 숫자
    * */
    public List<Integer> convertStrToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /*
     * 플레이어의 입력값이 3자리 수인지 확인
     * @Param input 플레이어의 숫자
     * */
    private static void validateInputSize(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 플레이어의 입력값이 숫자인지 확인
     * @Param input 플레이어의 숫자
     * */
    private static void validateInputType(String input) {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 플레이어의 입력값이 중복인지 확인
     * @Param input 플레이어의 숫자
     * */
    private static void validateInputDuplication(String input) {
        Set<Character> duplicateCheckSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            duplicateCheckSet.add(c);
        }

        if (duplicateCheckSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 게임 재시작 물음 시 플레이어의 입력값 검증 메서드
     * @Param input 플레이어의 숫자
     * */
    public void validateGameStateInput(String input) {
        if (!(input.equals(RESTART) || input.equals(END))) {
            throw new IllegalArgumentException();
        }
    }
}
