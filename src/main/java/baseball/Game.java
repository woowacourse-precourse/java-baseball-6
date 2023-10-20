package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    boolean gameClear = false;
    List<Integer> computer = null;
    List<Integer> userGuess = null;


    public Game() {
        startAnnounce();
        computerPickNum();
        inputGuess();
        gameClearAnnounce();
    }

    private void computerPickNum() {
        this.computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void inputGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        this.userGuess = new ArrayList<>();
        input.chars().forEach(i -> userGuess.add(i - 48));
    }

    private void startAnnounce() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void gameClearAnnounce() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }


}
