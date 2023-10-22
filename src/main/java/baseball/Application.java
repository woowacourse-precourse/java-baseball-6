package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Computer{
    private final List<Integer> computerNum;

    public Computer(){
        this.computerNum = pickNumbers();
    }

    public List<Integer> pickNumbers(){
        List<Integer> arr = new ArrayList<>();
        while (arr.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!arr.contains(randomNumber)) {
                arr.add(randomNumber);
            }
        }
        return arr;
    }
}

class Game {
    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
    }


}
public class Application {
    public static void main(String[] args) {
        new Game().start();
    }
}