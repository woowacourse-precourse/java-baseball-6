package baseball;

import baseball.Dto.StrikeBallScore;
import baseball.constants.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.List;

public class Service {
    StrikeBallScore score = new StrikeBallScore();
    Boolean isThisGameOver = false;
    Boolean reStart = true;

    //숫자 입력받음
    public int[] inputNums() {
        String userAnswer = Console.readLine();
        validateInput(userAnswer);
        String[] userAnswerNums = userAnswer.split("");
        int[] nums = new int[GameConstants.MAX_NUMBER];
        for(int i = 0; i < GameConstants.MAX_NUMBER; i++){
            nums[i] = Integer.parseInt(userAnswerNums[i]);
        }
        return nums;
    }

    //입력받은 숫자의 오류 점검(중복, 3개 숫자)
    public void validateInput(String userAnswer){
        Exceptions.validateNumberLength(userAnswer);
        Exceptions.validateUniqueNumbers(userAnswer);
    }

    // 결과 계산 strike, ball
    public void calcResult(int[] userNums, int[] answerNums){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < GameConstants.MAX_NUMBER; i++){
            for(int j = 0; j < GameConstants.MAX_NUMBER; j++) {
                if(j==i && userNums[i]==answerNums[j]){
                    strikeCount++;
                }else if(userNums[i]==answerNums[j]){
                    ballCount++;
                }
            }
        }
        score.setStrike(strikeCount);
        score.setBall(ballCount);
    }

    //계산에 대해 결과문에 입력
    public String generateGameResult(){
        int strikeCount = score.getStrike();
        int ballCount = score.getBall();
        String result = "";

        if(ballCount == 0 && strikeCount == 0){
            result = ResultConstants.NOT_THING;
        }else if(ballCount == 0){
            result = String.format(ResultConstants.STRIKE, strikeCount);
            if(strikeCount == GameConstants.MAX_NUMBER){
                isThisGameOver = true;
            }
        }else if(strikeCount == 0){
            result = String.format(ResultConstants.BALL, ballCount);
        }else{
            result = String.format(ResultConstants.BALL_STRIKE ,ballCount, strikeCount);
        }

        return result;
    }

    // 랜덤 3자리 숫자 중복 안되게생성
    public int[] creRandomNums(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GameConstants.MAX_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.RANDOM_MIN_RANGE, GameConstants.RANDOM_MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int[] randomNums = new int[GameConstants.MAX_NUMBER];
        for(int i = 0; i < GameConstants.MAX_NUMBER ; i++){
            randomNums[i] = computer.get(i);
        }
        return randomNums;
    }

    //재시작 여부 질문
    public void askReStart(){
        String userAnswerForRestart = Console.readLine();
        Exceptions.validateRestartInput(userAnswerForRestart);
        if (userAnswerForRestart.equals("1")) {
            isThisGameOver = false;
            reStart = true;
        } else if (userAnswerForRestart.equals("2")) {
            reStart = false;
        }
    }
}
