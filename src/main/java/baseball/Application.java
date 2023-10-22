package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int a = 425;
        List<Integer> as = new ArrayList<>();
    }
}
/**
 * Number 클래스 처음 숫자를 만들어 냄
 * Computer 클래스 입력받은 숫자로 strike, ball 판단
 * Game 클래스 stirke, ball 가지고 게임의 완료 여부
 * Input 클래스 게임의 진행을 위해 입출력을 담당
 * Exception 클래스 예외를 담당하는 클래스
 */
class Number{
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    public List<Integer> makeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}

