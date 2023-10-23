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
        boolean isReStarted = true;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        checkInputFormat(input);

        if (input.equals("2")) {
            isReStarted = false;
        }

        return isReStarted;
    }

    private static void checkInputFormat(String s) {
        // 숫자 형식 확인
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        // 1 or 2 인지 확인
        if (!(s.equals("1") || s.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
