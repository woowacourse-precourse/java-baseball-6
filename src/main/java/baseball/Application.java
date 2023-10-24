package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        boolean continuePlaying = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            play();
            continuePlaying = askContinue();

        }while(continuePlaying);

    }

    private static void play(){
        List<Integer> randomNum = generateRandomNumber();
        List<Integer> userNum;
        String userInput;
        boolean win = false;

        do{
            System.out.print("숫자를 입력해주세요:");
            userInput = Console.readLine();
            userNum = checkUserInput(userInput);

            if(getGameResult(randomNum,userNum)){
                win = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

        }while(!win);
    }

    public static List<Integer> generateRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> checkUserInput(String userInput){
        if(userInput.length() > 3){
            throw new IllegalArgumentException();
        }

        int num = 0;
        try{
             num = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException 발생");
        }

        List<Integer> userNumber = userNumToList(num);

        for(Integer i : userNumber){
            if(i == 0){
                throw new IllegalArgumentException();
            }
            if(Collections.frequency(userNumber, i) >= 2) {
                throw new IllegalArgumentException();
            }
        }

        return userNumber;
    }
    public static List<Integer> userNumToList(int num){
        List<Integer> numArr = new ArrayList<>();
        while(numArr.size() < 3){
            numArr.add(num % 10);
            num /= 10;
        }

        Collections.reverse(numArr);

        return numArr;
    }
    public static boolean getGameResult(List<Integer> randomNum, List<Integer> userNum){
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++){
            if(randomNum.get(i) == userNum.get(i)){
                strike++;
            }
        }

        for(int i = 0; i < 3; i++){
            if(randomNum.get(i) != userNum.get(i) && randomNum.contains(userNum.get(i))){
                ball++;
            }
        }

        printBallAndStrike(ball, strike);

        if(strike == 3){
            return true;
        } else{
            return false;
        }
    }

    private static void printBallAndStrike(int ball, int strike){
        StringBuilder sb = new StringBuilder();
        if(strike != 0 && ball != 0){
            sb.append(ball).append("볼 ").append(strike).append("스트라이크");
        } else if (strike != 0) {
            sb.append(strike).append("스트라이크");
        } else if (ball != 0) {
            sb.append(ball).append("볼");
        }else{
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    public static boolean askContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = camp.nextstep.edu.missionutils.Console.readLine();

        if(userInput.equals("1")){
            return true;
        } else if(userInput.equals("2")){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
