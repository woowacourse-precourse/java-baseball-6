package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.GameView;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    private final User user;
    private final Computer computer;
    private final GameView view;

    public BaseBall() {
        view = new GameView();
        user = User.getUser();
        computer = Computer.getComputer();
    }

    public void start() {

        view.printGameStartMessage();

        while (true) {

            computer.createComputerNumber();

            do {
                view.printInputNumberMessage();

                String input = readLine();
                isValidNumber(input);
                user.setNumber(convertInputToArrayList(input));

                user.calculateGameResult(computer.getNumber());
                view.printResult();
            } while (!user.gameFinish());

            view.printFinishGameMessage();
            view.printInputRestartMessage();

            String input = readLine();
            if (input.equals("2")) {
                break;
            } else if (!input.equals("1")) {
                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }

        }
    }

    private void isValidNumber(String s) {
        Set<Integer> hashSet = new HashSet<>();

        if (s.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        for (int i = 0; i < 3; i++) {
            int j = s.charAt(i) - '0';

            if (!(j >= 1 && j <= 9)) {
                throw new IllegalArgumentException("1에서 9사이의 숫자만 입력해주세요.");
            }

            if (hashSet.contains(j)) {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
            }

            hashSet.add(j);
        }
    }

    private List<Integer> convertInputToArrayList(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(input.charAt(i) - '0');
        }

        return list;
    }
}
