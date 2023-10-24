package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Game {

    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true){
            initComputerNumber();
            //System.out.println(Data.computerNumber); // 디버깅용
            setPlayerNumber();
            getResult();
            printHint();
            checkAnswer();
            if(!Data.isPlaying){
                break;
            }


        }
    }
    static void checkAnswer(){

        if(Data.strike == Data.ANSWER_STRIKE){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            Data.isPlaying = restartGame();
            Data.isCreated = false;
        }

    }
    static boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(playerInput());
        if(input == Data.DO_RESTART) return true;
        else if(input == Data.DO_NOT_RESTART) return false;
        else throw new IllegalArgumentException();

    }
    static void printHint(){
        if(Data.strike == Data.ANSWER_STRIKE) System.out.println(Data.strike +"스트라이크");
        else if(Data.strike == 0 && Data.ball ==0)System.out.println("낫싱");
        else if(Data.strike == 0) System.out.println(Data.ball + "볼");
        else if(Data.ball == 0) System.out.println(Data.strike + "스트라이크");
        else System.out.println(Data.ball + "볼 " +Data.strike + "스트라이크");
    }
    static void getResult(){
        int count = 0;
        Data.strike = 0;
        Data.ball = 0;
        for(int index = 0; index < Data.playerNumber.size(); index++){
            if(Data.computerNumber.get(index).equals(Data.playerNumber.get(index))  ) Data.strike += 1;
            if(Data.computerNumber.contains(Data.playerNumber.get(index))) Data.ball += 1;
        }
        Data.ball -= Data.strike;
    }
    static void initComputerNumber(){
        if(Data.isCreated) return;

        Data.computerNumber = new ArrayList<>();
        while (Data.computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!Data.computerNumber.contains(randomNumber)){
                Data.computerNumber.add(randomNumber);
            }
        }
        Data.isCreated = true;
    }
    static void setPlayerNumber() throws IllegalArgumentException{
        Data.playerNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = playerInput();
        int toIntInput = Integer.parseInt(input);
        while (toIntInput > 0){
            Data.playerNumber.add(toIntInput%10);
            toIntInput /= 10;
        }
        Collections.reverse(Data.playerNumber);
        exceptionCheck();

    }
    static void exceptionCheck(){
        if(Data.playerNumber.contains(0)){
            throw new IllegalArgumentException();
        }
        if(Data.playerNumber.size() != 3){
            throw new IllegalArgumentException();
        }
        if(!redundantCheck()){
            throw new IllegalArgumentException();
        }
    }
    static boolean redundantCheck(){
        Set<Integer> inputSet = new HashSet<>(Data.playerNumber);

        if(inputSet.size() != Data.playerNumber.size()) return false;
        return true;
    }

    static String playerInput(){
        String input = Console.readLine();
        return input;
    }
}
