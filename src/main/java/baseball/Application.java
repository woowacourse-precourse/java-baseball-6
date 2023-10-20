package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game.start();
    }
    // 숫자 저장 클래스 만들기
    // 비교 메서드
    // 입력 메서드
    // 출력 메서드
    // 게임 재시작 or 종료
    // 예외 처리 (마지막에 1,2 이외를 누르면, 세자리 수 아니고 1234 입력 등)
}

class Number {
    private static final int START_OF_RANGE = 1;
    private static final int END_OF_RANGE = 9;
    static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_OF_RANGE, END_OF_RANGE);
    }

}

class Result {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    static final int NEW_START = 1;
    static final int EXIT_GAME = 2;
    static final String END_MESSAGE = Game.NUMBERS + STRIKE + "\n" + Game.NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 " + NEW_START + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.\n";

    static String getResult(int[] arr1, int[] arr2){
        int countBall = 0;
        int countStrike = 0;
        for(int i=0; i<Game.NUMBERS; i++) {
            for(int j=0; j<Game.NUMBERS; j++) {
                if (arr1[i] == arr2[j])
                    if(i==j) countStrike++;
                    else countBall++;
            }
        }
        if(countStrike==0 && countBall==0) return NOTHING + "\n";
        else if(countStrike==3) return END_MESSAGE;
        else return countBall + BALL + " " + countStrike + STRIKE + "\n";
    }
}

class Game {
    public static final int NUMBERS = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    static int[] answer = new int[NUMBERS];
    static int[] userAnswer = new int[NUMBERS];

    static void generateAnswer() {
        for(int i = 0; i<NUMBERS; i++) {
            answer[i] = Number.getRandomNumber();
            for(int j=0; j<i; j++)
                while(answer[i]==answer[j]) answer[i] = Number.getRandomNumber();
        }

    }
    static void getUserNumbers() {
        String strNum = Console.readLine();
        if(strNum.length()>NUMBERS) throw new IllegalArgumentException("Invalid input");
        for(int i = 0; i < NUMBERS; i++) userAnswer[i]=strNum.charAt(i) - '0';
    }

    static String getResult() {
        return Result.getResult(answer, userAnswer);
    }
    static void restart() {
        //System.out.print("restart");
        int num = Integer.parseInt(Console.readLine());
        if(num == 1) start();
        //else if(num == 2) System.out.print("게임 종료");
    }
    public static void start() {
        System.out.print(START_MESSAGE);
        generateAnswer();
        System.out.print(Arrays.toString(answer));
        while (true) {
            System.out.print(INPUT_MESSAGE);
            getUserNumbers();
            System.out.print(getResult());
            if(Objects.equals(getResult(), Result.END_MESSAGE)) break;
        }
        restart();
    }

}