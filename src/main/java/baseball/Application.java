package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.startGame();
    }
}

class Game {
    private List<Integer> answer;
    public void startGame() {
        System.out.println(this.answer);
    }

    private void setNewAnswer() {
        this.answer = new ArrayList<>();
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }
}