package baseball.numberBaseball.game;

import baseball.numberBaseball.type.CallType;
import baseball.numberBaseball.type.PlayType;
import camp.nextstep.edu.missionutils.Randoms;
import extension.ValidateExt;
import java.util.List;
import java.util.ArrayList;

public class PlayNumberBaseballImpl implements PlayNumberBaseball {
    private List<Integer> computerNum;
    private List<Integer> userNum;
    private Integer strike = 0;
    private Integer ball = 0;


    @Override
    public void playGame() {
        computerNum = new ArrayList<>();
        userNum = new ArrayList<>();

        // 1에서 9까지 서로 다른 임의의 수 3개를 선택 하여 상대방(컴퓨터) 배열에 중복 없이 저장 합니다.
        while(computerNum.size() < PlayType.MAX_PLAY_SIZE.getPlayValue()){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
    }

    @Override
    public boolean gameOver() {
        if(strike == PlayType.STRIKEOUT.getPlayValue()){
            strike = 0;
            ball = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean gameRestart(String replayInput) throws IllegalArgumentException {
        if(!replayInput.equals(CallType.RESTART.getOnStatueType()) && !replayInput.equals(CallType.FINISH.getOnStatueType())){
            throw new IllegalArgumentException();
        }
        return replayInput.equals(CallType.RESTART.getOnStatueType());
    }

    @Override
    public void gamePlaying(String num) throws IllegalArgumentException {
        userNum = new ArrayList<>();
        if(!ValidateExt.validateUserInput(num)){
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new NumberFormatException();
        }

        for(int i=0 ; i < PlayType.MAX_PLAY_SIZE.getPlayValue() ; i++){
            userNum.add((num.charAt(i) - '0'));
        }
    }

    @Override
    public String gameResult() {
        String result = "";
        strike = 0; ball = 0;

        for(int i=0 ; i<PlayType.MAX_PLAY_SIZE.getPlayValue() ; i++){
            Integer tempNum = computerNum.get(i);

            if(tempNum.equals(userNum.get(i))){
                strike++;
                userNum.set(i, 0);
            }
        }

        for(int i=0 ; i<PlayType.MAX_PLAY_SIZE.getPlayValue() ; i++){
            if(userNum.get(i) == 0){
                continue;
            }

            if(computerNum.contains(userNum.get(i))){
                ball++;
            }
        }

        if(strike > 0 && ball > 0){
                result += ball + CallType.BALL.getOnStatueType();
                result += " ";
                result += strike + CallType.STRIKE.getOnStatueType();
            } else if (strike > 0) {
                result += strike + CallType.STRIKE.getOnStatueType();
            } else if (ball > 0){
                result += ball + CallType.BALL.getOnStatueType();
            } else {
                result = CallType.NOTHING.getOnStatueType();
        }

        return result;
    }


}
