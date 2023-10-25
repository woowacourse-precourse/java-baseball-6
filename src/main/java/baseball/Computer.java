package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터
 */
public class Computer {
    /**
     * 서로 다른 숫자 3개 생성
     */
    public List<Integer> generateNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Constant.GENERATE_NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constant.GENERATE_MIN_VALUE, Constant.GENERATE_MAX_VALUE);
            if (!computer.contains(randomNumber)) { // 중복 값인지 확인
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자 입력 숫자와 컴퓨터 숫자 비교하여 힌트 생성
     */
    public static Hint compareNumbers(List<Integer> computerNumbers, List<Integer> inputNumbers){
        int ballCount = 0;
        int strikeCount = 0;
        for (int i=0; i<Constant.GENERATE_NUM_SIZE; i++){
            if (computerNumbers.contains(inputNumbers.get(i))){ // 사용자 입력 숫자를 컴퓨터 숫자가 포함하고 있는 경우
                if (computerNumbers.get(i)==inputNumbers.get(i)){ // 스트라이크인 경우
                    strikeCount += 1;
                } else { // 볼인 경우
                    ballCount += 1;
                }
            }
        }
        return new Hint(ballCount, strikeCount);
    }
}
