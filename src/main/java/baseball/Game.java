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
            String input = Utils.printAndInput(PrintMessage.INPUT_NUMBER);
            isValidInput(input, size);
            finished = getResult(computer, input, size);
        }
        System.out.println(size + PrintMessage.END_GAME);
    }

    public boolean selectRestartOrExit(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(PrintMessage.ONLY_ONE_OR_TWO);
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

    private boolean getResult(List<Integer> computer, String input, int size) {
        List<Integer> userNumberList = Utils.stringArrToIntegerList(input);

        Player player = new Player(computer, userNumberList, size);
        player.printResult();

        return player.getStrike() == size;
    }

    private void isValidInput(String input, int size) {
        if (!Utils.isNaturalNumbers(input)) {
            throw new IllegalArgumentException(PrintMessage.ONLY_NATURAL_NUMBER);
        } else if (!Utils.isValidSize(input, size)) {
            throw new IllegalArgumentException(size + PrintMessage.ONLY_THIS_SIZE);
        } else if (!Utils.isNotDuplication(input)) {
            throw new IllegalArgumentException(PrintMessage.NOT_DUPLICATE_NUMBER);
        }
    }
}
