package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.computer();
    }
}

class Game{
    List<Integer> computer_answer = new ArrayList<>();

    void computer(){
        while (computer_answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_answer.contains(randomNumber)) {
                computer_answer.add(randomNumber);
            }
        }
        System.out.println("computer: " + computer_answer);
    }
}