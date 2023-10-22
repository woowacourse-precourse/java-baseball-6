package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.utils.Constants.*;

/*
 난수를 생성을 담당하는 클래스
 기능은 별로 없지만, 난수 생성을 이용한 기능이 추가로 생길 시를 대비해 유틸 클래스로 관리
 */

public final class RandomNumberGenerator {

    private RandomNumberGenerator(){
    }

    /*
    1 ~ 9 안의 난수를 생성하는 함수
     */

    public static int pickRandomNumberValidRange(){
        return Randoms.pickNumberInRange(USER_ANSWER_LOWER_LIMIT, USER_ANSWER_UPPER_LIMIT);
    }
    /*
    아래 함수는 UserAction과 ComputerAction의 통일성을 위해 ComputerAction으로 기능을 위임함.
     */
    /*
    public static List<Integer> generateRandomNumberList(){
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < ANSWER_LENGTH){
            int randomNumber = pickRandomNumberValidRange();

            if (!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
     */
}
