package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compare {
    public int CountEqualNumber(List<Integer> computer, List<Integer> player) {
        // 동일한 숫자를 비교하여 계산하고 equal에 저장한다.
        int equal = 0;
        for (Integer integer : player) {
            if (computer.contains(integer)) {
                equal += 1;
            }
        }
        return equal;
    }

    public int CountStrikeNumber(List<Integer> computer, List<Integer> player) {
        // 전체 스트라이크의 갯수를 계산하고 strike에 저장한다.
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public List<Integer> CheckInput(String input) {
        List<Integer> playNumber = new ArrayList<>();
        // 첫 번째 input에 대한 입력값 확인 - 문자인지 숫자인지 확인하기(소숫점을 입력할 경우도 마찬가지)
        try {
            int change_int_input = Integer.parseInt(input);
            if (change_int_input < 100 || change_int_input > 999) {
                throw new IllegalArgumentException("잘못된 값 입력 (3자리가 아닌 숫자 또는 문자)");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값 입력 (3자리가 아닌 숫자 또는 문자)");
        }

        // 3자리 숫자일 경우 playNumber에 저장
        for (String sliceInput : input.split("")) {
            playNumber.add(Integer.parseInt(sliceInput));
        }

        // 각 위치의 자리 수를 얻는다.
        int first = playNumber.get(0);
        int second = playNumber.get(1);
        int third = playNumber.get(2);

        // 2번 같은 숫자가 있는지 확인 하기
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException("잘못된 값 입력 (서로 다른 숫자가 아닌 3자리 숫자)");
        }

        return playNumber;
    }
}
