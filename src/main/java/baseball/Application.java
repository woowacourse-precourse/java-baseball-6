package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBER_LENGTH = 3;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 프로그램 시작
        System.out.println(GAME_START_MESSAGE);
        while(true) {
            List<Integer> computer = getRandomNumbers();

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
                return;
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
     * 컴퓨터의 수를 생성
     * @return 1~9까지의 숫자 3개가 담긴 리스트
     */
    public static List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    /**
     * 사용자가 입력한 수를 예외처리와 동시에 List형태로 변환
     * @return 1~9까지의 숫자 3개가 담긴 리스트
     */
    public static List<Integer> getUserNumbers() {
        List<Integer> numbers = new ArrayList<>();

        String input = getUserInput(INPUT_MESSAGE);
        if (input.length() > NUMBER_LENGTH){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (Character.isDigit(c) && 49 <= (int) c && 57 >= (int) c && !numbers.contains(Character.getNumericValue(c))){
                numbers.add(Character.getNumericValue(c));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
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
