package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class View {

    public String user_balls() throws Exception {
        String userInput = Console.readLine();
        if(!check_userBalls(userInput)){
            throw new Exception("Input 값이 잘못되었습니다.");
        }
        return userInput;
    }
    public String restart_num() throws Exception {
        String userInput = Console.readLine();
        if(!check_rst(userInput)){
            throw new Exception("Input 값이 잘못되었습니다.");
        }
        return userInput;
    }

    private boolean check_rst(String userInput) throws Exception {
        return checkLenRst(userInput)&&checkAllInteger(userInput);
    }

    private boolean checkLenRst(String userInput) {
        return userInput.length()==1;
    }

    private boolean check_userBalls(String userInput) throws Exception {
        return checkLenBall(userInput)&&checkAllInteger(userInput)&&checkOverlapping(userInput);
    }

    private boolean checkLenBall(String userInput) {
        return userInput.length()==3;
    }

    private boolean checkAllInteger(String userInput) throws Exception {
        try{
            Integer.parseInt(userInput);
        }catch (Exception e){
            throw new Exception("INPUT에 숫자 외의 값이 있습니다");
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

    public void ballAndStrike_result(int ball, int strike) {
        //TODO : 1볼 1스트라이크
        StringBuilder sb = new StringBuilder();
        sb.append(ball)
                .append(MESSAGE.BALL)
                .append(" ")
                .append(strike)
                .append(MESSAGE.STRIKE);
        System.out.print(sb.toString());
    }

    public void nothing_result() {
        System.out.print(MESSAGE.NOTHING);
    }

    public void ball_result(int ball) {
        StringBuilder sb = new StringBuilder();
        sb.append(ball).append(MESSAGE.BALL);
        System.out.print(sb.toString());
    }

    public void strike_result(int strike) {
        StringBuilder sb = new StringBuilder();
        sb.append(strike).append(MESSAGE.STRIKE);
        System.out.print(sb.toString());
    }

    public void game_end() {
        System.out.println(MESSAGE.GAME_END_MSG);
    }

    public void game_start() {
        System.out.println(MESSAGE.GAME_START_MSG);
    }

}
