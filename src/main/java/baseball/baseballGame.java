package baseball;

import static baseball.constants.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class baseballGame {

    //랜덤 세자리 수 만들기
    public List<Integer> getRandomNumber(){
        List<Integer> numberList = new ArrayList<>();

        while(numberList.size() <3) {
            int randomNum = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numberList.contains(randomNum)) {
                numberList.add(randomNum);
            }
        }
        return numberList;
    }

    // 사용자로부터 숫자 입력 받기
    public String getInputNumber() {
        return Console.readLine();
    }


    //입력값 검증하기
    public List<Integer> validateInputNumber(String input) {
        List<Integer> inputNumber = Arrays.stream(input.split(""))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력 해야 합니다.");
        }

        return inputNumber;
    }

    //출력 규칙
    public void getPrintResult(int ball, int strike) {
        StringBuilder result = new StringBuilder("");

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball > 0) {
            result.append(ball).append("볼").append(" ");
        }
        if (strike > 0) {
            result.append(strike).append("스트라이크");
        }
        System.out.println(result.toString().trim());
    }
}
