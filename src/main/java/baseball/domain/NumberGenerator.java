package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int SIZE = 3;

    public static List<BaseBall> generateAnswerNumbers(){
        List<BaseBall> randomBaseBallNumbers = new ArrayList<>();
        while(randomBaseBallNumbers.size() < SIZE){
            int number = Randoms.pickNumberInRange(BaseBall.MIN_NUMBER, BaseBall.MAX_NUMBER);
            if(!randomBaseBallNumbers.contains(number)){
                randomBaseBallNumbers.add(BaseBall.toBaseBall(number));
            }
        }
        return randomBaseBallNumbers;
    }

    public static void generateUserNumbers(){
        // TODO : 사용자 입력값 기반 BaseBalls 생성
    }
}
