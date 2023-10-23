package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int size;

    public Game(int size) {
        this.size = size;
    }

    public void run() {
        List<Integer> computer = createNumbers(size);
        boolean finished = false;
        while (!finished) {
            String input = Utils.printAndInput("숫자를 입력해주세요 : ");
            Player.isValidInput(input, size);
            finished = Player.getResult(computer, input, size);
        }
        System.out.println(size + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean selectRestartOrExit(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력해야합니다.");
        }
        return input.equals("2");
    }
    public static List<Integer> createNumbers(int size) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
