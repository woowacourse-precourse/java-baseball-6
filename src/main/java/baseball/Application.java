package baseball;

public class Application {
    static String startMsg = "숫자 야구 게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.println(startMsg);
        RandomNumber baseball = new RandomNumber();
        UserInput userInput = new UserInput();
        Validation validation = new Validation();
        Comparison comparison = new Comparison();
        Result result = new Result();
        Restart restart = new Restart();

        while (true) {
            int[] target = baseball.pickRandom();

            while (true) {
                String input = userInput.getInput();
                if (validation.isValid(input)) {
                    int[] ipt = new int[3];
                    for (int i = 0; i < 3; i++) {
                        ipt[i] = input.charAt(i) - '0';
                    }
                    int[] compareResult = comparison.comparison(target, ipt);
                    if (result.getResult(compareResult)) {
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
                }
            }

            int chk = restart.restart();
            if (chk == 2) {
                break;
            } else if (chk == 3) {
                throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
            }
        }
    }
}
