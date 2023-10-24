package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    public int[] com_num = new int[3];
    public int[] input_num = new int[3];
    public int strike = 0;
    public int ball = 0;
    public int state = 0;

    public Game() {
    }

    public void run() {
        try{
            do {
                play();
            } while (restart() == true);
        }catch (IllegalArgumentException e){
            throw e;
        }
    }

    private void play(){
        init();

        do {
            try {
                System.out.print("숫자를 입력해주세요 : ");

                /***
                 * 입력값 받아서 정수형 리스트로 변환
                 */
                String num = Console.readLine();

                if (num.length() != 3) {
                    throw new IllegalArgumentException("숫자를 잘못 입력했습니다.");
                }

                for (int i = 0; i < input_num.length; i++) {
                    input_num[i] = num.charAt(i) - '0';
                }

                /**
                 * strike, ball 초기화
                 */
                strike = 0;
                ball = 0;

                /**
                 * 입력값 분석: 첫 번째 시도 최종본
                 */
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (com_num[i] == input_num[j] && i == j) {
                            strike++;
                        } else if (com_num[i] == input_num[j] && i != j) {
                            ball++;
                        }
                    }
                }

                /**
                 * 결과값 출력
                 */
                if (strike > 0 && ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike > 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else if (ball > 0 && strike == 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println("낫싱");
                }

            } catch (IllegalArgumentException e){
                throw e;
            }
        } while(strike < 3);
    }

    private boolean restart() throws IllegalArgumentException{

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        state = Integer.parseInt(Console.readLine());
        if (state != 1 && state != 2) {
            throw new IllegalArgumentException();
        }

        if (state == 1) {
            return true;
        } else if (state == 2) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void init(){
        try {
            for(int i = 0;i < com_num.length;i++) {
                com_num[i] = Randoms.pickNumberInRange(1, 9);
                for(int j = 0;j < i;j++) {
                    if (com_num[i] == com_num[j]) {
                        i--;
                        break;
                    }
                }
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
        } catch (IllegalArgumentException e) {
        }
    }
}
