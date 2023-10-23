package baseball.logic;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;


    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomlyExtractNumber();

        Player player = new Player();
        while (true) {
            player.guess();
        }
    }

    private List<Integer> randomlyExtractNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자: "+ computerNumbers);
        return computerNumbers;
    }
}
