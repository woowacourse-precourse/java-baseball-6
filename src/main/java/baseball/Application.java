package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //(게임 시작 문구 출력)
        System.out.println("숫자 야구 게임을 시작합니다");
        //random number generation for computer
        List<Integer> computerNumber = generateComputerNumber();
        while(true){ //running game
            List<Integer> userGuess = getUserInput();
            int[] result = checkResult(computerNumber,userGuess);
            printResult(result);
        }

    }

    private static void printResult(int[] result) {
        if(result[0]==0&&result[1]==0)
            System.out.print("낫싱");
        if(result[0]>0)
            System.out.print(result[0]+"볼 ");
        if(result[1]>0)
            System.out.print(result[1]+"스트라이크 ");
        System.out.println();
        return ;
    }

    //check&return the number of strike and ball
    private static int[] checkResult(List<Integer> computerNumber, List<Integer> userGuess) {
        int strike=0, ball=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (computerNumber.get(i).equals(userGuess.get(j))) {//same number exist
                    if (i == j) {
                        strike++;
                        break;
                    } else {
                        ball++;
                        break;
                    }

                }
            }
        }
        return new int[]{strike,ball};
    }


    private static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }

    //user input
    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        List<Integer> parseInput = new ArrayList<>();
        for(char ch : input.toCharArray()) {
            parseInput.add(ch - '0'); //char to integer
        }
        return parseInput;
    }
}
