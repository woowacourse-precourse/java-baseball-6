package baseball;

import baseball.computer.Computer;
import baseball.user.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.constants.BaseballConstants.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 프로그램 시작
        System.out.println(GAME_START_MESSAGE);
        while(true) {
            List<Integer> computer = getComputerNumbers();

            // 사용자가 번호 맞추기 시작
            playGame(computer);

            // 개암 재시작
            if(!restartGame()) {
                break;
            }
        }
        Console.close();
    }

    /**
     * 게임 시작
     * @param computer 컴퓨터의 번호
     */
    public static void playGame(List<Integer> computer) {
        while(true) {
            List<Integer> user = getUserNumbers();

            int strike = getStrike(computer, user);
            int ball = getBall(computer, user);

            if (strike == NUMBER_LENGTH) {
                System.out.println(strike + STRIKE_MESSAGE);
                System.out.println(GAME_OVER_MESSAGE);
                break;
            } else if (strike > 0 && ball > 0) {
                System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            } else if (strike > 0 && ball == 0) {
                System.out.println(strike + STRIKE_MESSAGE);
            } else if (strike == 0 && ball > 0){
                System.out.println(ball + BALL_MESSAGE);
            } else if (strike == 0 && ball == 0) {
                System.out.println(NOTHING_MESSAGE);
            }
        }
    }

    /**
     * 게임 재시작
     * @return 입력값이 1이면 True 2이면 False
     */
    public static boolean restartGame() {
        String restart = getUserInput(RESTART_MESSAGE);

        if (!(restart.equals("1") || restart.equals("2"))){
            throw new IllegalArgumentException();
        }
        return "1".equals(restart);
    }


    /**
     * 컴퓨터의 번호를 랜덤으로 생성
     * @return 컴퓨터의 번호
     */
    public static List<Integer> getComputerNumbers() {
        return Computer.getRandomNumbers();
    }

    /**
     * 사용자가 입력한 수를 List로 변환
     * @return 1~9까지의 숫자 3개가 담긴 리스트
     */
    public static List<Integer> getUserNumbers() {

        String input = getUserInput(INPUT_MESSAGE);

        User user = new User(input);
        return user.getNumbers();
    }

    /**
     * 위치별 번호가 같은 값의 갯수를 구한다.
     * @param computer 컴퓨터의 번호
     * @param user 사용자가 입력한 번호
     * @return 컴퓨터와 사용자의 번호 간의 스트라이크 갯수
     */
    public static int getStrike(List<Integer> computer, List<Integer> user) {
        int res = 0;

        for (int i=0; i < NUMBER_LENGTH; i++){
            if (computer.get(i).equals(user.get(i))){
                res++;
            }
        }
        return res;
    }

    /**
     * 위치별로 번호는 다르지만 사용자가 입력한 번호가 컴퓨터의 번호 안에 존재하는 값의 갯수를 구한다.
     * @param computer 컴퓨터의 번호
     * @param user 사용자가 입력한 번호
     * @return 컴퓨터와 사용자의 번호 간의 볼 갯수
     */
    public static int getBall(List<Integer> computer, List<Integer> user) {
        int res = 0;

        for (int i=0; i < NUMBER_LENGTH; i++){
            if (!computer.get(i).equals(user.get(i)) && computer.contains(user.get(i))){
                res++;
            }
        }
        return res;
    }

    /**
     * 사용자 입력 받기
     * @return 문자열 입력값
     */
    public static String getUserInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }
}
