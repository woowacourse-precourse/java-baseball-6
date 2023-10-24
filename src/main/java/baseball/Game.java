package baseball;

public class Game {

    public static void run() {
        Computer computer = new Computer();

        while (!Check.isThreeStrike()) {
            Check check = new Check(computer.getComputerNumber(), Player.getPlayerNumber());
            check.countBallAndStrike();
            check.printResult();
        }

        rerun();
    }

    public static void rerun() {
        boolean result = Player.isRerun();
        if (result) {
            Check.setIsThreeStrike(false);
            run();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }
}
