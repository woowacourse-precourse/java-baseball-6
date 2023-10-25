package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    static int setNumber = 1;
    static String cNumber;
    static String pNumber;

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

    public static void printResult(String computerNumber, String userNumber) { //질문사항
        NumberControl numberControl = new NumberControl();
        Outputs output = new Outputs();
        int[] result = getResult(computerNumber, userNumber); //idx 0 = 스트라이크, idx 1 = 볼
        int strike = result[0];
        int ball = result[1];
        if (strike > 0 && ball == 0) { //스트라이크
            System.out.print(strike);
            output.wordStrike();
            System.out.print("\n");
            if (strike == 3) { //3스트라이크
                output.wordWinTheGame();
                getNumberAfterFinish();// 1혹은 2를 입력 받음
                if (setNumber == 1) {
                    cNumber = numberControl.getComputerNumber(); //재시작용 난수 생성
                }
            }
        } else if (strike == 0 && ball > 0) { //볼
            System.out.print(ball);
            output.wordBall();
            System.out.print("\n");
        } else if (strike > 0 && ball > 0) { //스트라이크 - 볼
            System.out.print(ball);
            output.wordBall();
            System.out.print(strike);
            output.wordStrike();
            System.out.print("\n");
        } else if (strike == 0 && ball == 0) { //낫싱
            output.wordNothing();
        }
    }

    public static void getNumberAfterFinish() {
        int setNumberCheck = Integer.parseInt(Console.readLine());
        isCorrectRetryNumber(setNumberCheck);
        setNumber = setNumberCheck;

    }

    public static void isCorrectRetryNumber(int number) throws IllegalArgumentException {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("1과 2 이외의 값을 입력했습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberControl numberControl = new NumberControl();
        Outputs output = new Outputs();
        cNumber = numberControl.getComputerNumber(); //생성된 컴퓨터 3자리 난수
        output.wordStart();
        setNumber = 1;
        while (setNumber != 2) {
            output.wordInsertNumber();
            String user = Console.readLine();
            pNumber = numberControl.getPlayerNumber(user); //74,75 합치는 방법 필요함.
            printResult(cNumber, pNumber);
        }
    }

}
