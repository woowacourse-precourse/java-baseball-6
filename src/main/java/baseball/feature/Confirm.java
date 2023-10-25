package baseball.feature;

import java.text.MessageFormat;
import java.util.*;

public class Confirm {

    private int accordCount;
    private int positionMatchCount;
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;

    public Confirm(List<Integer> UserNumbers, List<Integer> ComputerNumbers) {
        userNumbers = UserNumbers;
        computerNumbers = ComputerNumbers;
    }

    // 3개의 숫자를 모두 맞히지 못했을 시 재입력 메소드
    public void takeNumbers(List<Integer> UserNumbers) {
        userNumbers = UserNumbers;
    }

    // 스트라이크 ⊂ 볼
    // 따라서 일치갯수(볼) 먼저 구한다. - accordNumber
    // 그리고 일치갯수중 자리까지 일치하는 경우는 스트라이크 - checkPositionMatch
    // 일치갯수중 스트라이크를 제외하면 볼의 수

    //일치 하는 숫자의 갯수 찾기 테스트 에러 때문에 public으로 함
    public int accordNumber() {
        int count = 0;
        for (int num : userNumbers) {
            if (computerNumbers.contains(num)) {
                count++;
            }
        }
        accordCount = count;
        return count;
    }

    //자리와 숫자가 일치 하는 갯수 찾기 테스트 에러 때문에 public으로 함
    public int checkPositionMatch() {
        int count = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                count++;
            }

        }
        positionMatchCount = count;
        return count;


    }

    // 볼, 스트라이크, 낫싱 판별
    // 두 리스트를 비교,판별이후 accordCount, positionMatchCount 초기화
    public String referee() {
        String resultMessage;
        accordNumber();
        checkPositionMatch();
        if (accordCount == 0) {
            return "낫싱";
        }
        int strike = positionMatchCount;
        int ball = accordCount - positionMatchCount;

        if (strike == 0) {
            resultMessage = MessageFormat.format("{0}볼", ball);
        } else if (ball == 0) {
            resultMessage = MessageFormat.format("{0}스트라이크", strike);
        } else {
            resultMessage = MessageFormat.format("{0}볼 {1}스트라이크", ball, strike);
        }
        return resultMessage;
    }


}
