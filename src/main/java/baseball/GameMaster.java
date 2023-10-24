package baseball;

public class GameMaster {

    private static final View view = View.create();
    private static final Computer computer = Computer.create();
    private static final User user = User.create();
    private static int strike;
    private static int input;

    private GameMaster() {
    }

    public static void run() {
        view.startGame();
        do {
            computer.setNumber();
            do {
                user.setInputNumber(view.inputNumber());
                strike = view.result(computer.judgeResult(user.getNumber()));
            } while (strike < 3);
            input = view.restart();
            if (!(input == 1 || input == 2)) {
                throw new IllegalArgumentException("올바른 값을 입력해주세요.");
            }
        } while (input == 1);
    }
}
