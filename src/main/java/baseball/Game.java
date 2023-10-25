package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    int ball, strike;

    private void playBall(List<Integer> computer, List<Integer> user){
        for(int i=0;i<3;i++){
            if(computer.get(i) == user.get(i)){
                strike++;
                continue;
            }

            if(computer.contains(user.get(i))){
                ball++;
            }

        }
    }

    private void printResult(){
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }

        if(ball > 0){
            System.out.print(ball+"볼 ");
        }

        if(strike > 0){
            System.out.print(strike+"스트라이크");
        }

        System.out.println();
    }

    private boolean checkStriked(){
        return strike == 3;
    }

    private boolean gameOver(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int check = Integer.parseInt(Console.readLine());
        return check == 2;
    }

    private boolean checkUserInput(String input){
        return input.length() == 3;
    }
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            Computer computer = new Computer();
            List<Integer> number = computer.run();

            while(true){
                ball = 0;
                strike = 0;

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();

                if(!checkUserInput(input)) {
                    throw new IllegalArgumentException("세 개의 서로 다른 숫자를 입력해주세요.");
                }

                List<Integer> inputList = new ArrayList<>();
                for(char i:input.toCharArray()){
                    inputList.add(Character.getNumericValue(i));
                }

                playBall(number, inputList);
                printResult();

                if(checkStriked()){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                    break;
                }
            }

            if(gameOver()) {
                break;
            }
        }
        System.out.println("게임 종료");
    }
}
