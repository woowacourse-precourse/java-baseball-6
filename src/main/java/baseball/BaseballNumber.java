package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//숫자 야구 게임의 컴퓨터의 사용자의 수를 위한 클래스
public class BaseballNumber {
    private List<Integer> number = new ArrayList<>(3);
    public BaseballNumber(List<Integer> number){
        findException(number);
        this.number = number;
    }

    private void findException(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("게임을 진행할 수는 항상 3개여야 합니다.");
        }
        if (number.get(0) == number.get(1) || number.get(1) == number.get(2) || number.get(0) == number.get(2)) {
            throw new IllegalArgumentException("서로 같은 숫자들은 입력될 수 없습니다.");
        }
    }
//
//
//    @Override
//    public String toString() {
//        return "BaseballNumber{" +
//                "number=" + number +
//                '}';
//    }
    //같은 경우(1, 3, 5)가 반복된다???
    public static BaseballNumber initializeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new BaseballNumber(computer);
    }
}
