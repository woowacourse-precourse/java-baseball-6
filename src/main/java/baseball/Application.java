package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        startPrint();

        List<Integer> computerNumbers = generateRandomNumbers();

    }

    private static void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateRandomNumbers(){
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }


}
