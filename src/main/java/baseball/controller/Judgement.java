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
    private boolean isCorrectNumber;
    private GameResultDto gameResultDto;

    public Judgement(){}

    public GameResultDto compareNumbers(ComputerNumberDto computerNumberDto, UserNumberDto userNumberDto){
        setDefaultValue(); //변수값들 초기화

        computerNumber = computerNumberDto.getComputerNumber();
        userNumber = userNumberDto.getUserNumber();
        judgeStrike(); //스트라이크 여부 판단
        judgeBall(); //볼 여부 판단
        judgeCorrectNumber(); //정답여부 판단
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
            if((computerNumber.get(i) != userNumber.get(i)) && computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }
    }

    private void judgeCorrectNumber(){
        if(strikeCount == 3){
            isCorrectNumber = true;
        }
        else{
            isCorrectNumber = false;
        }
    }

    private void setGameResultDto(){
        gameResultDto.setStrikeCount(strikeCount);
        gameResultDto.setBallCount(ballCount);
        gameResultDto.setIsCorrectNumber(isCorrectNumber);
    }

    private void setDefaultValue(){
        strikeCount = 0;
        ballCount = 0;
        gameResultDto = new GameResultDto();
    }
}
