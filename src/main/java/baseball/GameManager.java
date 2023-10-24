package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class GameManager {
    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String INFO_MESSAGE = "숫자를 입력해주세요 : ";
    private final String STRING_BALL = "볼";
    private final String STRING_STRIKE = "스트라이크";
    private final String STRING_NONE = "낫싱";

    private Computer com;
    private User user;
    public GameManager() {
        com = new Computer();
        user = new User();
    }

    public void gameStart(){
        boolean start = true;
        String userRestartInput;
        System.out.println(GAME_START_MESSAGE);

        while(start){
            com.setRandomNumList();

            while(true) {
                System.out.print(INFO_MESSAGE);

                GuessVo guessVo = readUserGuess();
                user.setGuessVo(guessVo);
                ResultGuessVo resultGuessVo = checkUserGuess();
                printResultGuess(resultGuessVo);

                if (isFinished(resultGuessVo)) {
                    printEndAndRestartMessage();

                    userRestartInput = Console.readLine();
                    validateUserRestart(userRestartInput);

                    start = userRestartInput.equals("1") ? true : false;
                    break;
                }
            }
        }
    }


    private GuessVo readUserGuess(){
        List<Integer> guessNumber = new ArrayList<Integer>(3);
        String userGuess = Console.readLine();

        validateUserGuess(userGuess);

        if(userGuess.length() != 3)
            throw new IllegalArgumentException();

        for(int i = 0; i < 3; ++i){
            int num = userGuess.charAt(i) - '0';
            guessNumber.add(num);
        }

        return new GuessVo(guessNumber);
    }

    private void validateUserGuess(String userGuess){
        try {
            Integer.parseInt(userGuess);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(userGuess.length() != 3)
            throw new IllegalArgumentException();

        for(int i = 0; i < 3; ++i){
            if(userGuess.charAt(i) == '0')
                throw new IllegalArgumentException();
        }
    }

    private ResultGuessVo checkUserGuess(){
        List<Integer> comNumList = com.getNumList();
        List<Integer> userGuessList = user.getGuessVo().getGuessedNumber();

        int cntBall = 0;
        int cntStrike = 0;

        //check strike
        for(int i = 0 ; i < 3; ++i){
            if(comNumList.get(i) == userGuessList.get(i)) {
                cntStrike++;
            }
        }

        //check ball
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(i == j) continue;

                if(userGuessList.get(i) == comNumList.get(j)) {
                    cntBall++;
                }
            }
        }

        return new ResultGuessVo(cntBall, cntStrike);
    }

    private void printResultGuess(ResultGuessVo resultGuessVo) {
        int cntStrike = resultGuessVo.getCntStrike();
        int cntBall = resultGuessVo.getCntBall();

        if(cntStrike == 0 && cntBall == 0){
            System.out.print(STRING_NONE);
        }
        else{
            if(cntBall > 0)
                System.out.print(cntBall + STRING_BALL + " ");
            if(cntStrike > 0)
                System.out.print(cntStrike + STRING_STRIKE + " ");
        }

        System.out.println();
    }

    private boolean isFinished(ResultGuessVo resultGuessVo){
        return resultGuessVo.getCntBall() == 0 && resultGuessVo.getCntStrike() == 3;
    }
    private void printEndAndRestartMessage() {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(GAME_RESTART_MESSAGE);
    }

    private void validateUserRestart(String userRestartInput) {
        if(!(userRestartInput.equals("1") || userRestartInput.equals("2")))
            throw new IllegalArgumentException();
    }
}

