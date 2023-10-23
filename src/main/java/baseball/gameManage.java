package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class gameManage implements gameManageInterface {
    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            play();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }


    }

    public List<Integer> selectComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Integer selectPlayerNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        if (playerNumber.length() > 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return Integer.parseInt(playerNumber);
    }

    public void play() {
        List<Integer> computerNumber = selectComputerNumber();

    }
}
