package baseball.service;

import baseball.domain.BaseballGame;
import baseball.utils.MakeRandomNumber;
import baseball.utils.Validator;
import baseball.view.BaseballGameConsole;
import camp.nextstep.edu.missionutils.Console;
public class BaseballService {
    private int size;
    private BaseballGame baseballGame;
    private BaseballGameConsole baseballGameConsole = new BaseballGameConsole();
    public BaseballService(int size){
        this.size = size;
        baseballGame = new BaseballGame(MakeRandomNumber.getRandomNumbers(size));
    }
    public void playGame() {
        int strikeCount = 0;
        while (strikeCount != 3) {
            playTurn();
            baseballGameConsole.printScoreMessage(baseballGame.getBall(), baseballGame.getStrike());
            strikeCount = baseballGame.getStrike();
        }
    }
    private void playTurn(){
        baseballGame.initStrikeAndBall();
        int[] userGuess = getUserNumber();
        getScore(userGuess);
    }

    private int[] getUserNumber() throws IllegalArgumentException{
        BaseballGameConsole.requestInputData();
        String input = Console.readLine();
        Validator validator = new Validator();
        return validator.validateInput(input,size);
    }

    //스트라이크 볼 판정 로직
    private void getScore(int[] userGuess){

        for (int i = 0; i < size; i++) {
            if (baseballGame.haveDigit(userGuess[i])){
                if (userGuess[i] == baseballGame.getNumbers()[i]){
                    baseballGame.increaseStrike();
                }
                else{
                    baseballGame.increaseBall();
                }
            }
        }
    }

}
