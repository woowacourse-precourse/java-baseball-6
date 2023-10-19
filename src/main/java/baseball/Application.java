package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 프로그램 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            List<Integer> computer = getRandomNumbers();
        }
    }

    /**
     * 컴퓨터의 수를 생성
     * @return 1~9까지의 숫자 3개가 담긴 리스트
     */
    public static List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
