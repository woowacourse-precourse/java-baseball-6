package baseball.feature;

import java.util.*;

public class Confirm {

    int accordCount;
    int positionMatchCount;
    List<Integer> userNumbers;
    List<Integer> computerNumbers;

    public Confirm(List<Integer> UserNumbers, List<Integer> ComputerNumbers) {
        userNumbers = UserNumbers;
        computerNumbers = ComputerNumbers;
    }

    // 스트라이크 ⊂ 볼
    // 따라서 일치갯수(볼) 먼저 구한다. - accordNumber
    // 그리고 일치갯수중 자리까지 일치하는 경우는 스트라이크 - checkPositionMatch
    // 일치갯수중 스트라이크를 제외하면 볼의 수

    //일치 하는 숫자의 갯수 찾기
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

    //자리와 숫자가 일치 하는 갯수 찾기
    public int checkPositionMatch() {
        int count = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                count++;
            }

        }
        positionMatchCount = count;
        return count;


    }

    // 볼, 스트라이크, 낫싱 판별
    public String referee() {
        return null;
    }


}
