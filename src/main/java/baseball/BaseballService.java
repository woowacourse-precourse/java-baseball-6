package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    List<Integer> computer = new ArrayList<>();
    int strikeNumber = 0;
    int ballNumber = 0;
    public void createNumber(){
        while(computer.size() <3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    public void inputNumber(){
        strikeNumber = 0;
        ballNumber = 0;
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNumber = new ArrayList<>();
        if(input.length() != 3){
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        for (int i=0; i<3; i++){
            inputNumber.add(Integer.parseInt(input.substring(i,i+1)));
        }
        for(int i=0; i<3; i++){
            for(int j =i+1; j <3; j++){
                if(inputNumber.get(i).equals(inputNumber.get(j))){
                    throw new IllegalArgumentException("입력값이 잘못되었습니다.");
                }
            }
        }
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(computer.get(i).equals(inputNumber.get(j)) && i == j){
                    strikeNumber++;
                }if(computer.get(i).equals(inputNumber.get(j)) && i != j){
                    ballNumber++;
                }
            }
        }
    }

    public void printResult(){
        if(strikeNumber == 3){
            System.out.println(strikeNumber + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(strikeNumber > 0 && ballNumber == 0){
            System.out.println(strikeNumber + "스트라이크");
        }else if(ballNumber > 0 && strikeNumber == 0) {
            System.out.println(ballNumber + "볼");
        }else if(strikeNumber > 0 && ballNumber > 0) {
            System.out.println(ballNumber + "볼 " + strikeNumber + "스트라이크");
        }
        else{
            System.out.println("낫싱");
        }
    }

    public boolean restart(){
        if(strikeNumber==3){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String gameContinue = Console.readLine();
            if(gameContinue.equals("1")){
                computer.clear();
                createNumber();
                return true;
            } else if(gameContinue.equals("2")){
                return false;
            } else{
                throw new IllegalArgumentException("입력값이 잘못되었습니다.");
            }
        }
        return true;
    }

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        createNumber();
        boolean keep = true;
        while(keep){
            inputNumber();
            printResult();
            keep = restart();
        }
    }
}
