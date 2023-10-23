package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer;
    private final Player player;
    private final Judge judge;

    public Game() {
        this.computer = new Computer();
        this.player = new Player();
        this.judge = new Judge();
    }

    public boolean start() {

        boolean isFinished = false;

        while (!isFinished) {
            System.out.print("숫자를 입력해주세요 : ");
            player.enterNumber();
            isFinished = judge.judgmentFinish(player, computer);
        }

        return checkRestart();
    }

    private boolean checkRestart() {
        boolean isRestarted = true;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        checkInputFormat(input);

        if (input.equals("2")) {
            isRestarted = false;
        }

        return isRestarted;
    }

    private static void checkInputFormat(String input) {
        checkNumeric(input);
        checkOneOrTwo(input);
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkOneOrTwo(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
