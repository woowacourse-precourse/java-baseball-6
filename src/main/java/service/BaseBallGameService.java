package service;

import static constants.MessageType.GAME_END;
import static constants.MessageType.GAME_START;
import static constants.MessageType.INPUT_NUMBER;
import static constants.MessageType.NEW_GAME;
import static constants.MessageType.STRIKE_3;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.Computer;
import model.Game;
import model.User;
import view.BaseballGameView;

public class BaseBallGameService {

    private BaseballGameView baseballGameView;
    private Game game;
    private User user;
    private Computer computer;
    public BaseBallGameService(BaseballGameView baseballGameView, Game game, User user, Computer computer){
        this.baseballGameView = baseballGameView;
        this.game = game;
        this.user = user;
        this.computer = computer;

    }

    public BaseBallGameService(){}

    public void runGame(){
        //게임 시작
        baseballGameView.print(baseballGameView.getGameMessage(GAME_START));
        String flag = NEW_GAME.getMessage();
        String computerNumber = "";
        do{
            //컴퓨터 랜덤 수 반환
            if(computerNumber.isBlank()){
                computerNumber = computer.createRandomNumber();
                computer.setRandomNumber(computerNumber);
            }

            //사용자 입력값 받기
            baseballGameView.print(baseballGameView.getGameMessage(INPUT_NUMBER));
            user.setUserNumber();
            String userNumber = user.getNumber();

            //사용자 입력값 유효성 검사
            if(game.isUserNumber(userNumber)){
                //볼, 스트라이크, 낫싱 판단하기
                List<String> baseballScoreList = game.createBaseballScoreList(computerNumber, userNumber);
                //결과값 가공하기
                String baseBallResult = baseballGameView.printBaseBallCalculation(baseballScoreList);
                baseballGameView.print(baseBallResult);
                //3스트라이크 판별하기
                if(!STRIKE_3.getMessage().equals(baseBallResult)){
                    continue;
                }
                //게임 종료
                baseballGameView.print(baseballGameView.getGameMessage(GAME_END));
                flag = Console.readLine();
                computerNumber = "";
            }
        }while (NEW_GAME.getMessage().equals(flag));
    }

}
