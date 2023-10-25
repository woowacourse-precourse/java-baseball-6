package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private boolean playing;
    private int strikeCnt;
    private int ballCnt;

    static int FINISH_THE_GAME = 2;
    static int NUMBER_OF_INPUT_NUMBERS = 3;

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

            while ( !(isThreeStrike()) ){
                System.out.print(Print.GET_INPUT);
                user.setUserObject();

                gameLogic(computer, user);
                System.out.println(getGameResult());
            }
            askReplay();
        }
    }

    public void gameLogic(Computer computer, User user){
        init();

        for(int index = 0; index < NUMBER_OF_INPUT_NUMBERS; index++){
            if(computer.getComputerNumber(index) == user.getUserNumber(index)){
                strikeCnt++;
            } else if(computer.isComputerContains(user.getUserNumber(index))){
                ballCnt++;
            }
        }
    }

    public String getGameResult(){
        if(strikeCnt > 0){
            if(strikeCnt == NUMBER_OF_INPUT_NUMBERS){ return Print.THREE_STRIKE; }
            if(ballCnt > 0){ return Print.N_BALL_N_STRIKE(ballCnt, strikeCnt); }
            return Print.ONLY_STRIKE(strikeCnt);
        }
        else if(ballCnt > 0){ return Print.ONLY_BALL(ballCnt); }
        return Print.NOTHING;
    }

    public boolean isFinishTheGame(String input) { return Integer.parseInt(input) == FINISH_THE_GAME; }

    public void askReplay(){
        System.out.println(Print.ASK_REPLAY_GAME);
        String input = Console.readLine();
        Validate.isOneOrTwo(input);
        init();

        if(isFinishTheGame(input)){
            playing = false;
        }
    }

    public boolean isThreeStrike(){
        return strikeCnt == NUMBER_OF_INPUT_NUMBERS;
    }
}
