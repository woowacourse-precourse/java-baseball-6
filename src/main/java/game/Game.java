package game;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static boolean restart;
    static boolean userPlayAgain;
    static final int INPUT_MIN = 1;
    static final int INPUT_MAX = 9;
    static final int INPUT_SIZE = 3;
    static final String RESTART_GAME = "1";
    static final String EXIT_GAME = "2";

    public void start(){
        restart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        try{
            while(restart){
                play();
                askRestart();
            }
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    private void play(){
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();

        computer = getComputerPlay();

        userPlayAgain = true;

        while(userPlayAgain){
            try{
                user = getUserPlay();
                checkPlay(computer, user);

            } catch(IllegalArgumentException e){
                throw new IllegalArgumentException();
            }
        }
}

    private List<Integer> getComputerPlay(){
        List<Integer> computerPlay = new ArrayList<>();

        while (computerPlay.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerPlay.contains(randomNumber)) {
                computerPlay.add(randomNumber);
            }
        }

        return computerPlay;
    }

    private List<Integer> getUserPlay() throws IllegalArgumentException{
        List<Integer> userPlay = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String[] input = Console.readLine().split("");

        if(input.length != INPUT_SIZE){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < INPUT_SIZE; i++) {
            int value = Integer.parseInt(input[i]);

            if(value < INPUT_MIN || value > INPUT_MAX || userPlay.contains(value)){
                throw new IllegalArgumentException("Input error");
            }

            userPlay.add(value);
        }

        return userPlay;
    }

    private void checkPlay(List<Integer> computerPlay, List<Integer> userPlay){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < INPUT_SIZE; i++){
            int userNum = userPlay.get(i);

            if(computerPlay.contains(userNum) && (computerPlay.indexOf(userNum) == i)){
                strikeCount++;
            } else if(computerPlay.contains(userNum)){
                ballCount++;
            }
        }

        if(ballCount != 0 && strikeCount != 0){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if(ballCount != 0){
            System.out.println(ballCount + "볼");
        } else if(strikeCount != 0){
            System.out.println(strikeCount + "스트라이크");

            if(strikeCount == 3){
                userPlayAgain = false;
            }
        } else{
            System.out.println("낫싱");
        }
    }

    private void askRestart() throws IllegalArgumentException{
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String choose;
        choose = Console.readLine();
        if(choose.equals(EXIT_GAME) ){
            restart = false;
        } else if(choose.equals(RESTART_GAME)) {
            restart = true;
        } else{
            throw new IllegalArgumentException("Input error");
        }
    }
}
