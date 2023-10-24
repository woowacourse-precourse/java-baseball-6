package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    public void startGame(){
        while(true){
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String checkNumber = Console.readLine();

            if(checkNumber.equals("2")){
                break;
            }
            else if(!checkNumber.equals("1")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
    public void playGame(){
        List<Integer> computer = RandomNumberGenerator.generateRandomNumber();

        List<Integer> user;

        while(true){
            user = UserInput.inputNumber();

            int[] result = compareNumber(computer,user);

            printResult(result);

            if(result[0]==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

    }

    private int[] compareNumber(List<Integer> computer,List<Integer> user){
        int strike = 0;
        int ball = 0;

        for(int i=0; i<3; i++){
            if(computer.get(i).equals(user.get(i))){
                strike++;
            }else if (computer.contains(user.get(i))){
                ball++;
            }
        }

        int[] result = {strike,ball};

        return result;
    }

    private void printResult(int[] result){
        if(result[1] != 0){
            System.out.print(result[1]+"볼 ");
        }

        if(result[0] != 0){
            System.out.print(result[0]+"스트라이크");
        }

        if(result[1]==0 && result[0]==0){
            System.out.print("낫싱");
        }

        System.out.println();
    }
}
