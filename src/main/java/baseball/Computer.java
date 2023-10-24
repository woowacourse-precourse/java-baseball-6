package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Computer {
    private static final int BALL_COUNT = 3; // 컴퓨터가 생성할 공(숫자)의 개수
    private static final int MIN_BALL_NUM = 1; // 공(숫자)가 가질 수 있는 가장 작은 수
    private static final int MAX_BALL_NUM = 9; // 공(숫자)가 가질 수 있는 가장 큰 수
    private List<Integer> numbers; // 반환할 공(숫자)를 담을 리스트

    //생성자, numbers에 generateRandoms()를 호출해 공(숫자)을 담는다
    public Computer(){
        this.numbers = generateRandoms();
    }

    // BALL_COUNT 개수의 MIN_BALL_NUM 부터 MAX_BALL_NUM 까지의 중복 되지 않은 수가 담긴 리스트 반환
    private List<Integer> generateRandoms(){
        List<Integer> generatedNumbers = new ArrayList<>(); // 생성된 난수가 담길 리스트
        while (generatedNumbers.size() < BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUM, MAX_BALL_NUM);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }

    // 생성된 숫자들이 담긴 리스트를 반환한다
    public List<Integer> getNumbers(){
        return numbers;
    }

}
