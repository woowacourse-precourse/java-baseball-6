package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {

    public static String GAME_NUM;
    public static final String CONTINUE_NUMBER = "1";
    public static final String END_NUMBER = "2";

    public static List<Integer> computer;

    /* 숫자 야구 게임을 시작하는 메서드 */
    public void play() {
        startGame();
    }

    /* 컴퓨터 숫자를 만드는 메서드 */
    public static void makeComputerNumber() {
        computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    /* 게임 시작 메소드 */
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        makeComputerNumber();
        GAME_NUM = CONTINUE_NUMBER;
        while (GAME_NUM.equals(CONTINUE_NUMBER)) {
            System.out.print("숫자를 입력해 주세요 : ");
            String input = Console.readLine();
            //입력값 올바른 형태인지 체크
            validateUserInput(input);
            numberBasketballGame(input);
        }
    }

    /* 야구 게임 로직 */
    public static void numberBasketballGame(String input) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for(int i=0; i<3; i++){
            int userNum = input.charAt(i) - '0';
            for(int j=0; j<3; j++){
                int computerNums = computer.get(j);
                if(userNum == computerNums) {
                    if(i == j) strikeCnt++;
                    else ballCnt++;
                }
            }
        }
        printResult(strikeCnt, ballCnt);
        if (strikeCnt == 3) endGame();
    }

    /* 게임을 종료하는 메소드 */
    private static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        GAME_NUM = Console.readLine();
        validateInput(GAME_NUM);
        if(GAME_NUM.equals(CONTINUE_NUMBER)) makeComputerNumber(); //컴퓨터 숫자 리셋
    }

    /* 종료시, 사용자 입력 값의 유효성 확인 메서드 */
    private static void validateInput(String input) {
        if ( !input.equals(CONTINUE_NUMBER) && !input.equals(END_NUMBER) ) {
            throw new IllegalArgumentException( "1 또는 2만 입력하세요" );
        }
    }

    /* 사용자가 제대로된 값을 입력했는지 확인하는 메소드 */
    private static void validateUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값의 길이가 잘못 되었습니다.");
        }
        int[] nums = new int[10];
        for(int i=0; i<3; i++) {
            //(2) 숫자가 아니면 error
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException("1-9 사이 정수 값을 입력해주세요");

            //(3) 중복된 숫자가 존재할 시 error
            int num = input.charAt(i) - '0';
            if(nums[num] != 0) throw new IllegalArgumentException("중복된 숫자가 존재합니다");
            nums[num]++;
        }
    }

    /* 게임의 결과를 출력하는 메소드 */
    private static void printResult(int strike, int ball){
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) sb.append("낫싱");
        else {
            if(ball != 0) sb.append(ball).append("볼 ");
            if(strike != 0) sb.append(strike).append("스트라이크");
        }
        System.out.println(sb);
    }
}
