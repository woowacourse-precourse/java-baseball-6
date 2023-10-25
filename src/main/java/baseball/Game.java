package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Game {

    final int NUM_LENGTH = 3;

    final int RESTART = 1;
    final int GAME_OVER = 2;

    private int[] com_num = new int[NUM_LENGTH];
    private int[] input_num = new int[NUM_LENGTH];

    private int strike = 0;
    private int ball = 0;

    public Game() {
    }

    public void run() {
        do {
            play();
        } while (restart() == true);
    }

    private void play(){
        init();

        do {
            System.out.print("숫자를 입력해주세요 : ");

            getInputNum();
            checkResult();
            printResult();

        } while (strike < 3);
    }

    /**
     * 컴퓨터 넘버 셋팅
     */
    private void init(){

        for (int i = 0;i < com_num.length;i++) {
            // 랜덤 숫자 선택
            com_num[i] = Randoms.pickNumberInRange(1, 9);

            // 중복값 제거
            for (int j = 0;j < i;j++) {
                if (com_num[i] == com_num[j]) {
                    i--;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(com_num));
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /***
     * 입력값 받은 후 정수형 리스트로 변환
     */
    private void getInputNum() {

        String num = Console.readLine();

        if (num.length() != NUM_LENGTH) {
            throw new IllegalArgumentException("숫자를 잘못 입력했습니다.");
        }

        for (int i = 0; i < input_num.length; i++) {
            input_num[i] = num.charAt(i) - '0';
        }
    }

    /**
     * 입력값 분석
     */
    private void checkResult() {
        // strike, ball 초기화
        strike = 0;
        ball = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            for (int j = 0; j < NUM_LENGTH; j++) {
                if (com_num[i] == input_num[j] && i == j) {
                    strike++;
                } else if (com_num[i] == input_num[j] && i != j) {
                    ball++;
                }
            }
        }
    }

    /**
     * 결과값 출력
     */
    private void printResult(){
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    /***
     * 게임 재실행
     */
    private boolean restart() throws IllegalArgumentException {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 게임 플레이어가 숫자 입력
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum != RESTART && inputNum != GAME_OVER) {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }

        if (inputNum == RESTART) {
            return true;
        } else if (inputNum == GAME_OVER) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
    }
}
