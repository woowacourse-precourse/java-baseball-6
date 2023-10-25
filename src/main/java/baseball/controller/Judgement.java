package baseball.controller;

import baseball.model.ComputerNumberDto;
import baseball.model.GameResultDto;
import baseball.model.UserNumberDto;

import java.util.List;

import static baseball.utility.Constants.NUMBER_LIMIT_LENGTH;

public class Judgement {
    private List<Integer> computerNumber;
    private List<Integer> userNumber;
    private int strikeCount;
    private int ballCount;
    private GameResultDto gameResultDto;

    public Judgement(){
        strikeCount = 0;
        ballCount = 0;
        gameResultDto = new GameResultDto();
    }

    public GameResultDto compareNumbers(ComputerNumberDto computerNumberDto, UserNumberDto userNumberDto){
        computerNumber = computerNumberDto.getComputerNumber();
        userNumber = userNumberDto.getUserNumber();
        judgeStrike(); //스트라이크 여부 판단
        judgeBall(); //볼 여부 판단
        setGameResultDto(); //결과값을 담아서 전달해줄 dto 값 설정
        return gameResultDto;
    }

    private void judgeStrike(){
        for(int i = 0; i < NUMBER_LIMIT_LENGTH; i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
            }
        }
    }

    private void judgeBall(){
        for(int i = 0; i < NUMBER_LIMIT_LENGTH; i++){
            if(computerNumber.get(i) != userNumber.get(i) && computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
    }

    private void setGameResultDto(){
        gameResultDto.setStrikeCount(strikeCount);
        gameResultDto.setBallCount(ballCount);
    }
}
