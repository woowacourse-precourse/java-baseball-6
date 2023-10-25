package baseball.game;

import baseball.computer.Computer;
import baseball.user.User;
import baseball.util.InputUtil;

import java.util.List;

import static baseball.constants.BaseballConstants.*;
import static baseball.constants.BaseballConstants.NOTHING_MESSAGE;

public class Game {

    public void start() {
        Computer computer = new Computer();
        User user = new User();

        while (true) {
            computer.setNumbers();

            // 사용자가 번호 맞추기 시작
            while(true) {
                String input = InputUtil.getUserInput(INPUT_MESSAGE);
                user.setNumbers(input);

                List<Integer> computerNumbers = computer.getNumbers();
                List<Integer> userNumbers = user.getNumbers();


                int strike = getStrikeCount(computerNumbers, userNumbers);
                int ball = getBallCount(computerNumbers, userNumbers);

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

            // 개암 재시작
            if(!restart()) {
                break;
            }
        }
    }

    private boolean restart() {
        String restart = InputUtil.getUserInput(RESTART_MESSAGE);

        if (!(restart.equals("1") || restart.equals("2"))){
            throw new IllegalArgumentException();
        }
        return "1".equals(restart);
    }

    /**
     * 위치별 번호가 같은 값의 갯수를 구한다.
     * @param computer 컴퓨터의 번호
     * @param user 사용자가 입력한 번호
     * @return 컴퓨터와 사용자의 번호 간의 스트라이크 갯수
     */
    private int getStrikeCount(List<Integer> computer, List<Integer> user) {
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
    private int getBallCount(List<Integer> computer, List<Integer> user) {
        int res = 0;

        for (int i=0; i < NUMBER_LENGTH; i++){
            if (!computer.get(i).equals(user.get(i)) && computer.contains(user.get(i))){
                res++;
            }
        }
        return res;
    }
}
