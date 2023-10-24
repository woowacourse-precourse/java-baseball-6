package runGame;

import static runGame.constant.ANSWER_SIZE;
import static runGame.constant.BALL;
import static runGame.constant.END_RANGE;
import static runGame.constant.GAME_OVER;
import static runGame.constant.INPUT_NUMBER;
import static runGame.constant.NOTHING;
import static runGame.constant.RESTART_GAEM;
import static runGame.constant.RESTART_NUMBER;
import static runGame.constant.START_GAME;
import static runGame.constant.START_RANGE;
import static runGame.constant.STRIKE;
import static runGame.constant.SUCCESS;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import error.ErrorManage;
import java.util.ArrayList;
import java.util.List;

/*
 * 클래스 이름 : RunGame
 * baseball-game 실제 구동
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-10-22
 *
 * 작성자 : 문재경
 */
public class RunGame {
    private String computer_num; // 컴퓨터에서 제공해주는 정답

    /*
     * 컴퓨터가 제공해주는 정답을 생성하는 생성자 메서드
     *
     * @param void
     * @return void
     */
    public RunGame() {
        List<Integer> c_number = new ArrayList<>(); // 정답을 저장할 리스트
        while (c_number.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!c_number.contains(randomNumber)) {
                c_number.add(randomNumber);
            }
        }
        String List_to_String = c_number.toString();
        computer_num = List_to_String.replaceAll("[^0-9]", "");
    }

    /*
     * 객체를 생성해주고 게임 실행과 게임 종료 함수를 실행해주는 메서드
     *
     * @param void
     * @return void
     */
    public static void run() {
        System.out.println(START_GAME);
        RunGame runGame;

        do {
            runGame = new RunGame();
            runGame.gaemStart();
        } while (runGame.gameOver());

        Console.close();
    }

    /*
     * 유저에게 숫자를 받고 게임 결과 함수를 실행에 결과에 따라 반복을 실행하는 메서드
     *
     * @param void
     * @return void
     */
    private void gaemStart() {
        ErrorManage errorManage = new ErrorManage(); // 에러 관리 클래스
        String user_number; // 유저가 입력한 숫자

        do {
            System.out.print(INPUT_NUMBER);
            user_number = Console.readLine();
            errorManage.userNumberErrorManage(user_number);
        } while (!gameResult(user_number).equals(SUCCESS));
    }

    /*
     * 유저가 입력한 숫자를 받고 결과를 출력해주고 return 해주는 메서드
     *
     * @param user_number
     * @return result
     */
    private String gameResult(String user_number) {
        String result = NumOfStrikeAndBall(isStrike(user_number), isBall(user_number)); // 게임 결과
        System.out.println(result);

        return result;
    }

    /*
     * 유저에게 종료 메시지를 입력받고 그에 따라 종료할지 재시작할지 판단하는 메서드
     *
     * @param void
     * @return restart || exit
     */
    private boolean gameOver() {
        ErrorManage errorManage = new ErrorManage(); // 에러 관리 클래스
        String exit; // 종료 메세지

        System.out.println(GAME_OVER);
        System.out.println(RESTART_GAEM);

        exit = Console.readLine();
        errorManage.exitNumberErrorManage(exit);

        return exit.equals(RESTART_NUMBER);
    }

    /*
     * 유저가 입력한 숫자를 받고 정답과 비교해 스트라이크가 얼마나 있는지 return 해주는 메서드
     *
     * @param user_number
     * @return strike
     */
    private int isStrike(String numbers) {
        int strike = 0; // 스트라이크 수

        for (int i = 0; i < computer_num.length(); i++) {
            if (numbers.charAt(i) == computer_num.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    /*
     * 유저가 입력한 숫자를 받고 정답과 비교해 볼이 얼마나 있는지 return 해주는 메서드
     *
     * @param user_number
     * @return ball
     */
    private int isBall(String numbers) {
        int ball = 0; // 볼 수

        for (int i = 0; i < numbers.length(); i++) {
            String number = numbers.substring(i, i + 1);
            if (computer_num.contains(number)) {
                ball++;
            }
        }
        return ball;
    }

    /*
     * strike 와 ball 의 수를 받고 총 몇 개의 스트라이크와 볼을 쳤는지를 return 해주는 메서드
     *
     * @param strike, ball
     * @return answer
     */
    private String NumOfStrikeAndBall(int strike, int ball) {
        String answer = ""; // 스트라이크와 볼 값을 담을 변수

        if (strike == 0 && ball == 0) {
            answer = NOTHING;
        }

        answer += NumOfBall(ball - strike);
        answer += NumOfStrike(strike);

        return answer;
    }

    /*
     * 유저가 입력한 strike 수에 따라 문자열을 return 해주는 함수
     *
     * @param strike
     * @return n스트라이크
     */
    private String NumOfStrike(int strike) {
        if (strike > 0) {
            return strike + STRIKE;
        }

        return "";
    }

    /*
     * 유저가 입력한 ball 수에 따라 문자열을 return 해주는 함수
     *
     * @param ball
     * @return n볼
     */
    private String NumOfBall(int ball) {
        if (ball > 0) {
            return ball + BALL;
        }

        return "";
    }


}
