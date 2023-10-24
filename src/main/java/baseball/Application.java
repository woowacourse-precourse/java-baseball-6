package baseball;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    public static void gameStart() {
        PickRandomNumber pickRandomNumber = new PickRandomNumber();
        String targetNumber = pickRandomNumber.pickRandomNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String inputNumber = getInputNumber();
            GameResult gameResult = new GameResult(targetNumber, inputNumber);
            gameResult.checkValue();
            gameResult.outputMessages();

            if (gameResult.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        checkRestart();
    }

    public static String getInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String value = Console.readLine();
        ValidateInputValue validate = new ValidateInputValue(value);

        if (!validate.validate()) {
            throw new IllegalArgumentException();
        } else {
            System.out.println(value);
            return value;
        }
    }

    public static void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        switch (Console.readLine()) {
            case "1":
                gameStart();
                break;

            case "2":
                break;

            default:
                throw new IllegalArgumentException();
        }
    }
}
