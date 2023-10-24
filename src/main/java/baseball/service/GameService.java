package baseball.service;

import baseball.game.BaseNum;
import baseball.game.Game;
import baseball.validation.ValidUserInput;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameService {

    private int size;
    private int[] baseNumber;

    Game game;
    BaseNum baseNum = new BaseNum();

    public void setGame(int startInclusive, int endInclusive, int count){
        this.size = count;
        baseNumber = baseNum.createRandomBaseNum(startInclusive, endInclusive, count);
    }

    public void playGame(){
        inputRequirement(); //view에게 '숫자를 입력해주세요' 출력 부탁
        inputUserValue(); // input 받아서 검증까지
        calculateBallStrike(); // ball & strike 계산
        resultPrint(); // 위 ball & strike 내용 바탕으로 계산
        retryPlay(); // 3스트라이크 여부 판단
    }

    public void inputRequirement(){
        GameMessage.inputRequirementMessage();
    }

    public void inputUserValue(){
        game = new Game(size);
    }

    public void calculateBallStrike(){
        int[] inputNumber = game.getUserInput();
        for(int i=0; i<size; i++){ //i : 사용자 입력
            for(int j=0; j<size; j++){ //j : 기존
                if(inputNumber[i] == baseNumber[j]){
                    if(i == j){
                        game.incStrikeCount();
                    } else {
                        game.incBallCount();
                    }
                    break;
                }
            }
        }
    }

    public void resultPrint(){
        GameMessage.resultMessage(game.getBallCount(), game.getStrikeCount());
    }

    public void retryPlay(){
        if(game.getStrikeCount() != size){
            playGame();
        }
    }
}
