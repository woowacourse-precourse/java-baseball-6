package baseball;

import baseball.excpetion.InputException;
import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayGame {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private List<Integer> computerNumberList;
    private ComputerNumber computerNumber;
    private UserNumber userNumber;
    private List<Integer> userNumberList;
    private InputException numberException;

    public PlayGame(){
        computerNumber = new ComputerNumber();
        userNumber = new UserNumber();
        numberException = new InputException();

    }

    public void playBaseball(){
        computerNumberList = computerNumber.generateNumber();
        while (true) {
            System.out.print(INPUT_MESSAGE);
            userNumberList = userNumber.inputUserNumber();
            boolean result = getResult(userNumberList, computerNumberList);
            if(!result){
                break;
            }
        }
        restartGame();
    }

    public boolean getResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        int strike = checkStrike(userNumberList,computerNumberList);
        int ball = checkBall(userNumberList,computerNumberList);
        if(strike==0 && ball ==0){
            System.out.println(NOTHING_MESSAGE);
            return true;
        }
        if(strike!=0 && ball!=0){
            System.out.print(ball+BALL_MESSAGE+" ");
            System.out.println(strike+STRIKE_MESSAGE);
            return true;
        }
        if(strike<3 && ball == 0) {
            System.out.println(strike+STRIKE_MESSAGE);
            return true;
        }
        if(ball!=0 && strike == 0){
            System.out.println(ball+BALL_MESSAGE);
            return true;
        }
        if (strike==3){
            System.out.println(strike+STRIKE_MESSAGE);
            System.out.println(WIN_MESSAGE);
            System.out.println(OPTION_MESSAGE);
        }
        return false;
    }

    public int checkStrike(List<Integer> userNumberList, List<Integer> computerNumberList){
        int strike = 0;
        for(int i=0; i<3; i++){
            if(userNumberList.get(i).equals(computerNumberList.get(i))){
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(List<Integer> userNumberList, List<Integer> computerNumberList){
        int ball = 0;
        for(int i=0; i<3; i++){
            if(userNumberList.contains(computerNumberList.get(i)) && !(userNumberList.get(i).equals(computerNumberList.get(i)))){
                ball++;
            }
        }
        return ball;
    }

    public void restartGame(){
        String inputOption = Console.readLine();
        numberException.validOption(inputOption);
        if(inputOption.equals("1")){
            playBaseball();
        }
    }
}

