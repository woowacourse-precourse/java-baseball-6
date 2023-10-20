package baseball;

import java.util.List;

public class CompareService {
    private int strike, ball;
    private String result;

    // 초기화
    public void init() {
        strike = ball = 0;
        result = "";
    }

    // 비교하는 서비스 실행
    public String run(List<Integer> inputValueList, List<Integer> computer) {
        // 비교하는 로직 동작
        compare(inputValueList, computer);
        // 결과값 세팅
        setResult();

        return result;
    }

    // 내 입력값과 컴퓨터값을 비교하는 로직
    private void compare(List<Integer> inputValueList, List<Integer> computer) {
        for (int i = 0; i < 3; i++) {
            int now = inputValueList.get(i);
            for (int j = 0; j < 3; j++) {
                int computerValue = computer.get(j);
                // 스트라이크
                if(now == computerValue && i == j) {
                    strike += 1; break;
                }
                // 볼
                else if(now == computerValue) {
                    ball += 1; break;
                }
            }
        }
    }

    // 결과값 세팅하는 로직
    private void setResult() {
        if(strike == 0 && ball == 0) result += "낫싱";
        else if(strike != 0 && ball == 0) result += (strike + "스트라이크");
        else if(strike == 0 && ball != 0) result += (ball + "볼");
        else result += (ball + "볼 " + strike + "스트라이크");
    }

}
