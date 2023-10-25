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

    public static void printResult(String computerNumber, String userNumber) {
        NumberControl numberControl = new NumberControl();
        int[] result = getResult(computerNumber, userNumber); //idx 0 = 스트라이크, idx 1 = 볼
        int strike = result[0];
        int ball = result[1];
        if (strike > 0 && ball == 0) { //스트라이크
            System.out.printf("\n%d스트라이크\n", strike);
            if (strike == 3) { //3스트라이크
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                getNumberAfterFinish();// 1혹은 2를 입력 받음
                if (setNumber == 1) {
                    cNumber = numberControl.getComputerNumber(); //재시작용 난수 생성
                }
            }
        } else if (strike == 0 && ball > 0) { //볼
            System.out.printf("\n%d볼\n", ball);
        } else if (strike > 0 && ball > 0) { //스트라이크 - 볼
            System.out.printf("\n%d볼 %d스트라이크\n", ball, strike);
        } else if (strike == 0 && ball == 0) { //낫싱
            System.out.println("\n낫싱");
        }
    }

    public static void getNumberAfterFinish() {
        int setNumberCheck = Integer.parseInt(Console.readLine());
        isCorrectRetryNumber(setNumberCheck);
        setNumber = setNumberCheck;

    }

    public static void isCorrectRetryNumber(int number) throws IllegalArgumentException {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberControl numberControl = new NumberControl();
        cNumber = numberControl.getComputerNumber(); //생성된 컴퓨터 3자리 난수
        startMention(); // 게임 시작 멘트
        setNumber = 1;
        while (setNumber != 2) {
            System.out.print("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            pNumber = numberControl.getPlayerNumber(user);
            printResult(cNumber, pNumber);
        }
    }


    public static void startMention() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
