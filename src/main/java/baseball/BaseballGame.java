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
            String inputNumber = Input.readUserNumbers();
            // TODO: inputNumber 예외 처리

            User user = new User(inputNumber);

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
        String inputModeStr = Input.readModeRestartOrEnd();
        int inputMode = Integer.parseInt(inputModeStr);
        // TODO: inputMode 예외 처리

        if (inputMode == Constants.MODE_RESTART) {
            run();  // 재시작
        }  // 완전히 종료
    }
}
