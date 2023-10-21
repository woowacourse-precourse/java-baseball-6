package baseball;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    // 고민: Validating 로직과 리스트로 변환하는 로직을 따로 가져가고 싶은데 idDigit 안에 그 기능이 있어서 분리가 안 되는 느ㅊ무
    // 리스트로만 반환하기 싫어서인듯? 내가 하고 싶은 것은 input이 list면 list, input이 string이면 string을 리턴하고 싶은 것일지도

    public static List<Integer> convert(String input, int length) throws IllegalArgumentException {
        // 최종 결과를 담을 List 생성
        List<Integer> candidate = new ArrayList<>();

        // 입력 문자열 길이 검증
        if (input.length() != length) {
            throw new IllegalArgumentException();
        }

        // 입력 문자열이 모두 숫자로 변환 가능한지 체크(음수, 소수, 문자는 변환 불가)
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                candidate.add(Character.getNumericValue(c));
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        // 입력에 중복이 있는지 확인
        if((candidate.stream().distinct().count()) != length) {
            throw new IllegalArgumentException();
        }

        return candidate;
    }
}
