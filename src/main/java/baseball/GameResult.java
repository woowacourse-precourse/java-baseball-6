package baseball;

public class GameResult {
    public static int[] getResult(String computerNumber, String userNumber) {
        int ball = 0;
        int strike = 0;
        int[] result = {0, 0};
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(Character.toString(userNumber.charAt(i)))) {
                ball++;
            }
        }
        for (char userNum : userNumber.toCharArray()) {
            if (computerNumber.indexOf(userNum) == userNumber.indexOf(userNum)) {
                strike++;
            }
        }
        ball -= strike;
        result = new int[]{strike, ball};
        return result;
    }

    public void getRetryNumber() {
        NumberControl numberControl = new NumberControl();
        numberControl.getNumberAfterFinish();
    }

    public void printResult(String computerNumber, String userNumber) {
        NumberControl numberControl = new NumberControl();
        Outputs output = new Outputs();
        int[] result = getResult(computerNumber, userNumber); //result[0] = 스트라이크, result[1] = 볼
        int strike = result[0];
        int ball = result[1];
        if (strike > 0 && ball == 0) { //스트라이크
            System.out.print(strike);
            output.wordStrike();
            System.out.print("\n");
            if (strike == 3) { //3스트라이크
                output.wordWinTheGame();
                getRetryNumber();
                if (Application.getSetNumber() == 1) {
                    Application.cNumber = numberControl.getComputerNumber(); //재시작용 난수 생성
                }
            }
        } else if (strike == 0 && ball > 0) { //볼
            System.out.print(ball);
            output.wordBall();
            System.out.print("\n");
        } else if (strike > 0 && ball > 0) { //볼-스트라이크
            System.out.print(ball);
            output.wordBall();
            System.out.print(strike);
            output.wordStrike();
            System.out.print("\n");
        } else if (strike == 0 && ball == 0) { //낫싱
            output.wordNothing();
        }
    }
}
