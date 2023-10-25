package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Game {
    private boolean playing;
    private int strikeCnt;
    private int ballCnt;

    private void init(){
        strikeCnt = 0;
        ballCnt = 0;
    }

    public void setGame(){
        playing = true;
    }

    public boolean isPlaying(){
        return playing;
    }

    public void run(){
        Computer computer = new Computer();
        User user = new User();

        setGame();
        System.out.println(Print.START_GAME);

        while (isPlaying()){
            computer.setComputerObject();

            while (!isThreeStrike()){
                System.out.print(Print.GET_INPUT);
                user.setUserObject();

                // 입력한 숫자에 대한 결과 출력
                gameLogic(computer, user);
                System.out.println(getGameResult());
            }
            askReplay();
        }
    }

    public void gameLogic(Computer computer, User user){
        init();

        for(int index=0; index<3; index++){
            if(computer.getComputerNumber(index) == user.getUserNumber(index)){
                strikeCnt++;
            } else if(computer.isComputerContains(user.getUserNumber(index))){
                ballCnt++;
            }
        }
    }

    public String getGameResult(){
        if(strikeCnt > 0){
            if(strikeCnt == 3){ return Print.THREE_STRIKE; }
            if(ballCnt > 0){ return Print.N_BALL_N_STRIKE(ballCnt, strikeCnt); }
            return Print.ONLY_STRIKE(strikeCnt);
        }
        else if(ballCnt > 0){ return Print.ONLY_BALL(ballCnt); }
        return Print.NOTHING;
    }

    public boolean isOneOrTwo(String str) {
        return Pattern.matches("[1|2]", str);
    }

    public void askReplay(){
        System.out.println(Print.REPLAY_GAME);
        String input = Console.readLine();
        if(!isOneOrTwo(input)){
            throw new IllegalArgumentException("게임을 시작하려면 1혹은 2를 입력해야 합니다.");
        }
        init();

        if(Integer.parseInt(input) == 2){
            playing = false;
        }
    }

    public boolean isThreeStrike(){
        return strikeCnt == 3;
    }
}
