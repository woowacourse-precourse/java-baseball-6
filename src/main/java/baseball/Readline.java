package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Readline {
    public List<Integer> ReadPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> playNumber = new ArrayList<>();
        String input = Console.readLine();
        // 여기서 분기로 첫 번째 input에 대한 입력값 확인 - 문자인지 숫자인지 확인하기(소숫점을 입력할 경우도 마찬가지)
        try {
            int checkinput = Integer.parseInt(input);
            if (checkinput < 100 || checkinput > 999) {
                throw new IllegalArgumentException("잘못된 값 입력 (3자리가 아닌 숫자 또는 문자)");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값 입력 (3자리가 아닌 숫자 또는 문자)");
        }
        // 3자리 숫자일 경우 playNumber에 저장
        for (String sliceInput : input.split("")) {
            playNumber.add(Integer.parseInt(sliceInput));
        }

        // 각 위치의 자리수를 초기화 한다.
        int first = playNumber.get(0);
        int second = playNumber.get(1);
        int third = playNumber.get(2);

        // 2번 분기로 같은 숫자가 있는지 확인 하기
        if (first == second || second == third || first == third) {
            throw new IllegalArgumentException("잘못된 값 입력 (서로 다른 숫자가 아닌 3자리 숫자)");
        }
        return playNumber;
    }
}
