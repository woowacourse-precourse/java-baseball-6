package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class View {

    public String user_balls() {
        String userInput = Console.readLine();
        if(!check_userBalls(userInput)){
            throw new IllegalArgumentException("Input 값이 잘못되었습니다.");
        }
        return userInput;
    }
    public String restart_num() {
        String userInput = Console.readLine();
        if(!check_rst(userInput)){
            throw new IllegalArgumentException("RESTART 값이 잘못되었습니다.");
        }
        return userInput;
    }

    private boolean check_rst(String userInput) {
        return checkLenRst(userInput)&&checkAllInteger(userInput);
    }

    private boolean checkLenRst(String userInput) {
        return userInput.length()==1;
    }

    private boolean check_userBalls(String userInput) {
        return checkLenBall(userInput)&&checkAllInteger(userInput)&&checkOverlapping(userInput);
    }

    private boolean checkLenBall(String userInput) {
        return userInput.length()==3;
    }

    private boolean checkAllInteger(String userInput) {
        try{
            Integer.parseInt(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException("INPUT에 숫자 외의 값이 있습니다");
        }
        return true;
    }

    private boolean checkOverlapping(String userInput) {
        Set<Character> check = new HashSet<>();
        for(char c : userInput.toCharArray()){
            check.add(c);
        }
        return check.size() == 3;
    }

    public void ballAndStrike_result(int strike, int ball) {
        //TODO : 1볼 1스트라이크
        StringBuilder sb = new StringBuilder();
        sb.append(ball)
                .append(MESSAGE.BALL.getMessage())
                .append(" ")
                .append(strike)
                .append(MESSAGE.STRIKE.getMessage());
        System.out.println(sb.toString());
    }

    public void nothing_result() {
        System.out.println(MESSAGE.NOTHING.getMessage());
    }

    public void ball_result(int ball) {
        StringBuilder sb = new StringBuilder();
        sb.append(ball).append(MESSAGE.BALL.getMessage());
        System.out.println(sb.toString());
    }

    public void strike_result(int strike) {
        StringBuilder sb = new StringBuilder();
        sb.append(strike).append(MESSAGE.STRIKE.getMessage());
        System.out.println(sb.toString());
    }

    public void game_end() {
        System.out.println(MESSAGE.GAME_END_MSG.getMessage());
    }

    public void game_start() {
        System.out.println(MESSAGE.GAME_START_MSG.getMessage());
    }

    public void input_msg() {
        System.out.print(MESSAGE.INPUT_USER_NUM.getMessage());
    }

    public void restart_msg() {
        System.out.println(MESSAGE.INPUT_RESTART.getMessage());
    }
}
