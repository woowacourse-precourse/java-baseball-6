package baseball.service;

import baseball.domain.PlayBaseball;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballService {
    private final String initComment = "숫자 야구 게임을 시작합니다.";
    private final String choiceComment = "";
    private String userNum = "";
    private final PlayBaseball playBaseball;
    public PlayBaseballService(PlayBaseball playBaseball){
        this.playBaseball = playBaseball;
    }

    public void getInitComment(){
        System.out.println(initComment);
    }

    public void getChoiceComment(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void insertNum(){
        Console.readLine();
    }

    public String getGameResult(){
        String result = "";
        if(playBaseball.getGameLaunch().getBallNum() > 0){
            result += playBaseball.getGameLaunch().getBallNum()+" ";
        }
        if(playBaseball.getGameLaunch().getStrikeNum() > 0){
            result += playBaseball.getGameLaunch().getStrikeNum();
        }
        return result;
    }

    public String getUserNum(){
        return userNum;
    }


}
