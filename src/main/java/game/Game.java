package game;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    static boolean restart = true;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(restart){
            play();
        }
    }

    private void play(){
        List<Integer> computer = getComputerPlay();

        List<Integer> user = getUserPlay();

        checkPlay(computer, user);
    }

    private List<Integer> getComputerPlay(){
        //서로 다른 숫자 입력할 수 잇게끔 해야함 -> 리드미 참조!!
        List<Integer> computerPlay = new ArrayList<>();

        while (computerPlay.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerPlay.contains(randomNumber)) {
                computerPlay.add(randomNumber);
            }
        }

        return computerPlay;
    }

    private List<Integer> getUserPlay(){
        List<Integer> userPlay = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String[] input = Console.readLine().split("");

        int inputSize = input.length;

        for(int i = 0; i < inputSize; i++){
            int value = Integer.parseInt(input[i]);
            userPlay.add(value);
        }

        return userPlay;
    }

    private void checkPlay(List<Integer> computerPlay, List<Integer> userPlay){
        int ballCount = 0;
        int strikeCount = 0;

        for(int computerNumber : computerPlay){
            boolean sameNumber = false;
            if(userPlay.contains(userPlay)){
                sameNumber = true;
            }

            while(sameNumber){

            }
//            for(int j = 0; j < 3; j++){
//                if(userPlay[i].equals(computerPlay[j]) && i == j){
//                    strikeCount++;
//                    break;
//                } else if(userPlay[i].equals(computerPlay[j]) && i != j){
//                    ballCount++;
//                }
//            }
        }

        if(ballCount != 0 && strikeCount != 0){
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if(ballCount != 0 && strikeCount == 0){
            System.out.println(ballCount + "볼");
        } else if(ballCount == 0 && strikeCount != 0){
            System.out.println(strikeCount + "스트라이크");
            isRestart(strikeCount);
        } else{
            System.out.println("낫싱");
        }
    }

    private void isRestart(int strikeCount){
        if(strikeCount == 3){
            String choose;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            choose = Console.readLine();
            if(choose.equals("2")) {
                restart = false;
            }
        }
    }
}
