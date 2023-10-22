package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Integer> computer = new ArrayList<>();
    private List<Integer> player = new ArrayList<>();
    private boolean correctFlag = false;
    User user = new User();

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = randomNumber();
        System.out.println(computer);
        while (!correctFlag) {
            player = user.getNumber();
            System.out.println(player);
        }
    }

    public List<Integer> randomNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computer.add(randomNumber);
        }
        return new ArrayList<>(computer);
    }
}
