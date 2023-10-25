package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private static final String FORMAT = "^[1-2]$";
    private static final Pattern PATTERN = Pattern.compile(FORMAT);
    private final Computer computer;
    private final User user;

    public Game() {
        computer = new Computer();
        user = new User();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        } while (canRestart());
    }

    private void play() {
        computer.start();
        do {
            user.inputNumber();
        } while (computer.canPlayContinue(user));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean canRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateInput(input);
        return Integer.parseInt(input) == 1;
    }

    private void validateInput(String input) {
        if (!PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
