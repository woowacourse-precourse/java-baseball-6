package baseball.feature;

import java.util.*;

public class Confirm {

    int accordCount;
    List<Integer> userNumbers;
    List<Integer> computerNumbers;

    Confirm(List<Integer> UserNumbers, List<Integer> ComputerNumbers) {
        userNumbers = UserNumbers;
        computerNumbers = ComputerNumbers;
    }

    // 스트라이크 ⊂ 볼
    // 따라서 일치갯수(볼) 먼저 구한다. accordNumber
    // 그리고 일치갯수중 자리까지 일치하는 경우는 스트라이크
    // 일치갯수중 스트라이크를 제외하면 볼의 수
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



}
