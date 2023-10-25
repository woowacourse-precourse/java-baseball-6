package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;

public class Service {
    private static final String START_MESSAGE = "숫자 야구를 시작하겠습니다.";
    private static final String INFO_INPUT = "숫자를 입력해 주세요 : ";
    private static final int LENGTH = 3;
    private Integer ballCount = 0;
    private Integer strikeCount = 0;
    private boolean continueFlag = true;

    Player player = new Player();
    private ArrayList<Integer> systemNumber = new ArrayList<Integer>();

    private ArrayList<Integer> playerNumber = new ArrayList<Integer>();

    public void play() throws IllegalArgumentException {
        System.out.println(START_MESSAGE);
        initializeSystem();

        while(continueFlag) {
            System.out.println(INFO_INPUT);
            initializePlayer();

            checkBallStrike(playerNumber, systemNumber);
            statusMessage();
            restart();
            initializeCount();

        }
    }


    private void initializePlayer() throws IllegalArgumentException{
        player.setUserNumber();
        playerNumber = player.getNumberList();
    }

    private void initializeSystem() throws IllegalArgumentException{
        systemNumber = setSystemNumber();
    }

    private ArrayList<Integer> setSystemNumber() throws IllegalArgumentException{
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(list.size() < 3){
            Integer randomNum = Randoms.pickNumberInRange(1,9);
            if(!list.contains(randomNum)){
                list.add(randomNum);
            }
        }
        return list;
    }

    private void checkBallStrike(ArrayList<Integer> player, ArrayList<Integer> system){
        for(int i = 0; i < system.size(); i++){
            for(int j = 0 ; j < player.size() ; j++){
                if(system.get(i).equals(player.get(j)) && i == j){
                    strikeCount++;
                } else if(system.get(i).equals(player.get(j)) && i != j){
                    ballCount++;
                }
            }
        }
    }

    private void statusMessage(){
        String result;
        if( ballCount != 0 && strikeCount != 0){
            System.out.println(ballCount + "볼 " + strikeCount +"스트라이크");
        } else if(ballCount == 0 && strikeCount != 0){
            System.out.println(strikeCount+"스트라이크");
        } else if(ballCount != 0 && strikeCount == 0){
            System.out.println(ballCount+"볼");
        }
        else {
            System.out.println("낫싱");
        }
    }

    private void restart() throws IllegalArgumentException{
        if(strikeCount == LENGTH){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            Exceptions.restartException(restart);
            if(restart.equals("1")){
                initializeAll();
                systemNumber = setSystemNumber();
                continueFlag = true;
            } else {
                continueFlag = false;
                //Console.close();
            }
        }
    }
    private void initializeAll(){
        this.ballCount = 0;
        this.strikeCount = 0;
        this.playerNumber.clear();
        this.systemNumber.clear();
    }

    private void initializeCount(){
        this.ballCount = 0;
        this.strikeCount = 0;
    }

}
