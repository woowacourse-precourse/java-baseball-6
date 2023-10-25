package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_CHOICE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String QUIT_VALUE = "2";
    private static final String RESTART_VALUE = "1";

    Computer computer = new Computer();
    User user = new User();
    boolean quit = false;
    int both=0;
    int strike=0;
    int ball=0;
    String quitResponse="";

    public void quitDecide(){
        if(this.quitResponse.equals(QUIT_VALUE)){
            quit = true;
        }else if(this.quitResponse.equals(RESTART_VALUE)){
            computer.setRandomNumber();
        }
    }

    public void play(){
        System.out.println(START_MESSAGE);

        computer.setRandomNumber();

        while(!quit) {
            initCount();
            user.setUserNumber(); //유저입력받기

            System.out.println(ans(computer.computerDigit,user.userDigit));

            if(this.strike == 3) {
                System.out.println(STRIKE_FINISH);
                System.out.println(RESTART_CHOICE);
                setQuitResponse();
                quitDecide();
            }
        }
    }

    public void setQuitResponse(){
        String inputQuit = Console.readLine();
        validateQuitInput(inputQuit);
        this.quitResponse = inputQuit;
    }

    private void validateQuitInput(String quitResponse) {
        List<String> inputList = new ArrayList<>(Arrays.asList(new String[]{RESTART_VALUE, QUIT_VALUE}));
        boolean inputValidation = inputList.contains(quitResponse);
        if(!inputValidation) {
            throw new IllegalArgumentException("IllegalArgument for QuitInput");
        }
    }

    public int countBoth(List<Integer> computer, List<Integer> user){
        both = 0;
        for(int i = 0; i < user.size(); i++){
            if(computer.contains(user.get(i))){
                both += 1;
            }
        }
        return both;
    }

    public int countStrike(List<Integer> computer, List<Integer> user){
        strike = 0;
        for(int i = 0; i < user.size(); i++){
            if(computer.get(i) == user.get(i)){
                strike += 1;
            }
        }
        return strike;
    }

    public String ans(List<Integer> computer, List<Integer> user){
        this.both = countBoth(computer, user);
        this.strike = countStrike(computer, user);
        this.ball = this.both - this.strike;

        if(both == 0){
            return "낫싱";
        }else if(strike == 0){
            return ball + "볼";
        }else if(ball == 0){
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public void initCount(){
        this.both=0;
        this.strike=0;
        this.ball=0;
        this.quitResponse="";
        quit = false;
        user.userDigit = new ArrayList<>();
    }
}
