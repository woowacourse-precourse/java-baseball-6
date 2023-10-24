package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int endSign;
    static boolean isCorrect;
    static int[] randomNumberArray;
    static boolean[] checkArray;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        endSign = 1; // 게임 지속 : 1, 게임 종료 : 2

        // 게임 진행. 문제를 맞춰도 다시 시작 가능해야함.
        while(endSign == 1) {
            // 랜덤 숫자 생성.
            makeRandomNumber();

            // 숫자 맞추기 게임 시작q
            gameStart();
        }
    }

    static void makeRandomNumber() {
        isCorrect = false;
        randomNumberArray = new int[3];
        checkArray = new boolean[9];
        for(int i=0; i<randomNumberArray.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while(checkArray[randomNumber-1]) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            checkArray[randomNumber-1] = true;
            randomNumberArray[i] = randomNumber;
            // System.out.println(randomNumberArray[i]); // 정답 미리보기 for test
        }
    }

    // 입력 값 확인
    static int[] checkInputNumber(String[] inputArray) {
        int[] inputToIntArray = new int[3];
        boolean[] checkList = new boolean[9];

        // 3자리 초과 시 오류
        if(inputArray.length > 3) {
            System.out.println("세자리 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        for (int i=0; i<inputArray.length; i++) {
            try { // 입력 값이 숫자인지 체크
                inputToIntArray[i] = Integer.parseInt(inputArray[i]);
                if(inputToIntArray[i] == 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("숫자를 입력해 주세요.");
                throw new IllegalArgumentException();
            }

            // 중복된 숫자 체크.
            if(!checkList[inputToIntArray[i]-1]) {
                checkList[inputToIntArray[i]-1] = true;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return inputToIntArray;
    }

    // 숫자 입력 받기
    static int[] getInputNumber() {
        System.out.print("숫자를 입력해주세요. : ");
        // 입력 : 1~9 숫자 중 3가지로 이루어진 세자리 숫자.
        // 입력 시 같은 숫자는 사용 금지.
        // 입력 시 숫자만 입력 가능.
        String input = Console.readLine();
        String[] inputArray = input.split("");

        return checkInputNumber(inputArray);
    }

    static void printResult(int strike, int ball) {
        if(strike == 3) { // 정답인 경우
            // 정답이라면 while문 break.
            System.out.println("3스트라이크"
                + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
                + "\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int inputInt = Integer.parseInt(Console.readLine());
            if(inputInt == 2) { // 게임 종료
                endSign = 2;
            } else { // 이번 게임은 끝. 다음 게임 다시 시작.
                endSign = 1;
            }
            isCorrect = true;
        } else if(strike == 0 && ball == 0) { // 하나도 못맞춘 경우
            System.out.println("낫싱");
        } else { // 볼 또는 스트라이크가 있는 경우
            if(ball > 0) {
                System.out.print(ball + "볼 ");
                if(strike > 0) {
                    System.out.print(strike + "스트라이크");
                }
            } else {
                System.out.print(strike + "스트라이크");
            }
            System.out.println(); // 개행
        }
    }

    static void gameStart() {
        while(!isCorrect) {
            // 입력 값 확인
            int[] inputToIntArray = getInputNumber();

            // 입력 후 판단.
            int strike = 0;
            int ball = 0;
            for(int i=0; i<randomNumberArray.length; i++) {
                if(randomNumberArray[i] == inputToIntArray[i]) {
                    strike++;
                }
                for(int j=0; j<randomNumberArray.length; j++) {
                    if(i !=j && randomNumberArray[i] == inputToIntArray[j]) {
                        ball++;
                    }
                }
            }
            printResult(strike, ball);
        }
    }

}
