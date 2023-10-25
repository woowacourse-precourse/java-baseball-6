package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private final static int MAX_LENGTH = 3;

    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        boolean isStarted = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (isStarted) {
                randomNumbers.generateRandomNums();
                isStarted = false;
            }
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();

            MyNumbers myNumbers = new MyNumbers(input);
            Calculator.calculateGameResult(myNumbers.getNums(), randomNumbers.getNums());

            ResultPrinter.printResult(Calculator.getBall(), Calculator.getStrike());
            Calculator.initializeFields();
            if (ResultPrinter.isDone()) {
                ResultPrinter.initializeFiled();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String str = readLine();

                if (str.equals("1")) {
                    isStarted = true;
                    continue;
                } else if (str.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
