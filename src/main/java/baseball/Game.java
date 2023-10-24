package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int strike;
    private int ball;
    private List<Integer> computer_number = new ArrayList<>();

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        createComputerNumber();
    }

    private void createComputerNumber() { //컴퓨터가 3개의 숫자를 랜덤으로 생성
        while (computer_number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_number.contains(randomNumber)) { //중복되지 않는 숫자인 경우에만 리스트에 추가
                computer_number.add(randomNumber);
            }
        }
    }
}