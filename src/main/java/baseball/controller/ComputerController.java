package baseball.controller;

import baseball.model.BaseBall;
import baseball.service.OutputView;

import java.util.List;

public class ComputerController {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;
    RandomNumberUtil randomNumberUtil = new RandomNumberUtil();
    OutputView outputView = new OutputView();


    //게임 시작시 난수 생성하기 위한 함수
    public void startGame(BaseBall baseBall){
        List<Integer> computerNumbers = randomNumberUtil.generateComputerNumber();
        baseBall.setComputerNumbers(computerNumbers);
    }

    public boolean gameProcess(BaseBall baseBall){
        List<Integer> playerNumbers = baseBall.getPlayerNumbers();
        List<Integer> computerNumbers = baseBall.getComputerNumbers();

        compareNumbers(playerNumbers,computerNumbers);

        return isThreeStrike();
    }

    public void compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers){
        strikeCount = 0;
        ballCount = 0;
        for(int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++){
            if(playerNumbers.get(i)==computerNumbers.get(i)){
                strikeCount++;
            }
            if(computerNumbers.get(i) != playerNumbers.get(i) && computerNumbers.contains(playerNumbers.get(i))){
                ballCount++;
            }
        }
        showHint();
    }


    public void showHint(){
        String hint = "";

        hint += getBallHintMessage();
        hint += getStrikeHintMessage();
        hint += getNothing();

        outputView.showHintMessage(hint);
    }

    private String getStrikeHintMessage(){
        if(strikeCount>0){
            return strikeCount + "스트라이크" + " ";
        }

        return "";
    }

    private String getBallHintMessage(){
        if(ballCount>0){
            return ballCount + "볼" + " ";
        }

        return "";
    }
    private String getNothing(){
        if (ballCount == 0 && strikeCount == 0){
                return "낫싱" ;
        }
        return "";
    }

    public boolean isThreeStrike(){
        return strikeCount == 3;
    }



}
