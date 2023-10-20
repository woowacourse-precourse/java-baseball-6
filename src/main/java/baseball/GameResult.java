package baseball;

public class GameResult {
    int strike = 0;
    int ball = 0;
    String targetNumber;
    String inputNumber;

    public GameResult(String targetNumber, String inputNumber) {
        this.targetNumber = targetNumber;
        this.inputNumber = inputNumber;
    }

    public void checkValue() {
        char[] charToTarget = targetNumber.toCharArray();
        char[] charToInput = inputNumber.toCharArray();

        for (int i = 0; i < charToInput.length; i++) {
            if (targetNumber.contains(charToInput[i] + "")) {
                if (charToInput[i] == charToTarget[i]) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

    }

    public void outputMessages() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }

        if (strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }

        System.out.println("");

    }
}
