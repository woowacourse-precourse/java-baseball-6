package baseball;

public class Hint {
    int ball, strike;

    void compareAnswer(Game player, Game computer) {
        int currentNumber;

        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            currentNumber = player.computerNum[i];

            if (!Array.checkArrayContains(computer.computerNum, currentNumber)) {
                continue;
            }
            if (i == Array.getIndex(computer.computerNum, currentNumber)) {
                this.strike++;
                continue;
            }

            this.ball++;
        }
    }

    void showResult() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + "볼";
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + "스트라이크";
        }

        if (result.equals("")) {
            result = "낫싱";
        }

        System.out.println(result);
    }
}
