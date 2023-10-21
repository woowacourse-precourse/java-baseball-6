package baseball;

public class BaseballGame {
    public void start() {
        Output.printGameStart();
        run();
    }

    private void run() {
        Computer computer = new Computer();

        // (삭제 예정)
        System.out.println(computer.getNumbers());

        while (true) {
            User user = new User();

            // (삭제 예정)
            System.out.println(user.getNumbers());

            Umpire umpire = new Umpire();
            umpire.compareUserWithComputer(user.getNumbers(), computer.getNumbers());
            if (umpire.isThreeStrike()) {
                break;
            }
        }

        Output.printGameEnd();
        exist();
    }

    private void exist() {
        Mode mode = new Mode();
        if (mode.isRestart()) {
            run();  // 재시작
        }  // 완전히 종료
    }
}
