package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static boolean hasDuplicate(ArrayList<Integer> temp){ // 동일한 숫자가 있는지 확인하는 hasDuplicate 메서드
        if(temp.size() != 3)
            return true;
        if(temp.contains(0))
            return true;
        for(int i=0; i < temp.size(); i++){
            for(int j=i+1; j < temp.size(); j++){
                if(temp.get(i).equals(temp.get(j))) // 동알한 숫자가 있다면 true
                    return true;
            }
        }
        return false; // 동일한 숫자가 없으면 false
    }
    public static ArrayList<Integer> randomComputerNumber(){ // 랜덤으로 3자리 수를 생성하는 rendomComputerNumber 메서드
        ArrayList<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }
    public static ArrayList<Integer> userInputNumber(String userInput){ // 사용자가 입력한 수를 배열에 저장하는 userInputNumber 메서드
        ArrayList<Integer> userArray = new ArrayList<>();
        for(int i=0; i < userInput.length(); i++){ // userInput의 3자리 수를 한 자리씩 끊어 userArray에 삽입
            char digitChar = userInput.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            userArray.add(digit);
        }
        return userArray;
    }
    public static int[] isStrikeAndBallNumber(ArrayList<Integer> computerNum, ArrayList<Integer> userNum){ // 볼과 스트라이크의 개수를 확인하는 isStrikeAndBallNumber 메서드
        int[] sbArr = new int[2]; // 스트라이크와 볼의 개수를 담는 sbArr
        for(int i=0; i < computerNum.size(); i++){
            int computerDigitNumber = computerNum.get(i); // computerNum 배열의 i번째 원소를 담는 computerDigitNumber
            for(int j=0; j < userNum.size(); j++){
                int myDigitNumber = userNum.get(j); // userNum 배열의 j번째 원소를 담는 myDigitNumber
                if(computerDigitNumber == myDigitNumber){ // 동일하면서
                    if(i == j) // 같은 위치에 존재한다면
                        sbArr[1]++; // 스트라이크 +1
                    else // 다른 위치에 존재한다면
                        sbArr[0]++; // 볼 +1
                }
            }
        }
        return sbArr;
    }
    public static void printStrikeAndBall(int[] strikeAndBall){ // 볼과 스트라이크의 개수에 따라 출력문을 생성하는 printStrikeAndBall 메서드
        if(strikeAndBall[0] + strikeAndBall[1] == 0) // 볼과 스트라이크가 없다면 낫싱을 출력
            System.out.println("낫싱");
        else if(strikeAndBall[0] > 0 && strikeAndBall[1] > 0) // 볼과 스트라이크 모두 존재한다면 둘 다 출력
            System.out.println(strikeAndBall[0] + "볼 " + strikeAndBall[1] + "스트라이크");
        else if(strikeAndBall[0] > 0) // 볼만 존재한다면 볼의 개수를 출력
            System.out.println(strikeAndBall[0] + "볼");
        else if(strikeAndBall[1] > 0) // 스트라이크만 존재한다면 스트라이크의 개수를 출력
            System.out.println(strikeAndBall[1] + "스트라이크");
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ArrayList<Integer> computerNumber = randomComputerNumber(); // 서로 다른 3자리 수를 랜덤으로 생성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 숫자를 입력받기 위해 BufferedReader 선언
        boolean isProgress = true; // 진행 여부를 확인하는 isProgress
        while(isProgress){ // isProgress가 true이면 반복, false이면 종료
            System.out.print("숫자를 입력해주세요 : ");
            String userInput;
            try {
                userInput = reader.readLine(); // 사용자가 숫자를 입력
            }
            catch (IOException e){
                throw new IllegalArgumentException();
            }
            ArrayList<Integer> userNumber = userInputNumber(userInput); // 입력한 값을 userNumber 배열에 저장 ex) "123" -> [1, 2, 3]
            if(hasDuplicate(userNumber)) // 동일한 숫자가 존재하거나, userNumber의 개수가 3이 아니거나, 0이 존재한다면 예외 발생
                throw new IllegalArgumentException();
            int[] strikeAndBall = isStrikeAndBallNumber(computerNumber, userNumber); // 볼과 스트라이크의 개수를 배열에 저장
            printStrikeAndBall(strikeAndBall); // 볼과 스트라이크의 개수를 출력
            if(strikeAndBall[1] == 3){ // 스트라이크의 개수가 3이면
                System.out.println("세 개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String replayNum; // 1 또는 2를 입력받는 replayNum
                try {
                    replayNum = reader.readLine();
                }
                catch (IOException e){
                    throw new IllegalArgumentException();
                }
                int reStartNumber = Integer.parseInt(replayNum);
                if(reStartNumber == 1){ // 1을 입력했다면 게임을 새로 시작하므로 새로운 랜덤 3자리 수를 생성
                    computerNumber = randomComputerNumber();
                }
                else if(reStartNumber == 2) // 2를 입력했다면 게임 종료
                    isProgress = false;
                else // 1 또는 2를 입력하지 않았다면 예외 발생
                    throw new IllegalArgumentException();
            }
        }
    }
}