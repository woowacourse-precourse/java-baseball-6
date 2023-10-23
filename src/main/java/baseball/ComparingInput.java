package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComparingInput {
    /*
    ###  3️⃣ 정답을 비교하는 기능
    - 사용자의 입력값과 정답을 비교한 후, 결과를 출력한다.
    - [1] 사용자의 입력값과 정답 중 같은 수가 전혀 없으면 '낫싱'
    - [2] 사용자의 입력값과 정답 중 같은 수가 있지만 다른 자리에 있으면 '볼'
    - [3] 사용자의 입력값과 정답 중 같은 수가 같은 자리에 있으면 '스트라이크'
     */

    private int strike = 0;
    private int ball = 0;

    public void Compare(int num, String input) {
        String answer = Integer.toString(num); // 문자 형변환
        char[] answerArr = answer.toCharArray();
        char[] inputArr = input.toCharArray();

        ArrayList<Character> inputList = new ArrayList<Character>();
        for (char i : inputArr) {
            inputList.add(i);
        }

        for (int i = 0; i < 3; i++) {
            if (inputList.get(i) == answerArr[i]) {
                strike += 1;
            } else if (inputList.contains(answerArr[i])) {
                ball += 1;
            }
        }
    }
    public void PrintResults() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball+"볼");
        } else if (ball == 0) {
            System.out.println(strike+"스트라이크");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

}
