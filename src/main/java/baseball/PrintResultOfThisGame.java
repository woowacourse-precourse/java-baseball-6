package baseball;

public class PrintResultOfThisGame {
    private ResultOfGame resultOfGame;

    private boolean isThreeStrike = false;

    public PrintResultOfThisGame(ResultOfGame resultOfGame) {
        this.resultOfGame = resultOfGame;
    }

    public void getResultOfThisGame() {
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        for (String result : resultOfGame.getList()) {
            if (result.equals("Strike")) {
                strike++;
            } else if (result.equals("Ball")) {
                ball++;
            } else if (result.equals("nothing")) {
                nothing++;
            }
        }

        String printResult = "";
        if (ball != 0) {
            printResult += ball;
            printResult += "볼 ";
        }
        if (strike != 0) {
            printResult += strike;
            printResult += "스트라이크";
            if (strike == 3) {
                printResult += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
                isThreeStrike = true;
            }
        }
        if (nothing == 3) {
            printResult += "낫싱";
        }

        System.out.println(printResult);
    }

    public boolean isThreeStrike() {
        return isThreeStrike;
    }

}
