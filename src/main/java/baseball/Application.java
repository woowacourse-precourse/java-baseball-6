package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현

        while (true){
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computerNumber = getComputerNumber();

            while (true){
                List<Integer> userNumber;

                System.out.print("숫자를 입력해주세요 : ");
                try{
                    userNumber = getUserNumber();
                } catch (IllegalArgumentException e){
                    throw new IllegalArgumentException();
                }

                int result = check(computerNumber, userNumber);
                int strikeCnt = result/10;
                int ballCnt = result%10;

                if (strikeCnt == 3){
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else if (strikeCnt == 0 && ballCnt == 0){
                    System.out.println("낫싱");
                }
                else if (strikeCnt == 0){
                    System.out.println(ballCnt + "볼");
                }
                else if (ballCnt == 0){
                    System.out.println(strikeCnt + "스트라이크");
                }
                else{
                    System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String ans = readLine();
            if (!ans.equals("1") && !ans.equals("2")){
                throw new IllegalArgumentException();
            }

            if (ans.equals("2")){
                break;
            }
        }
    }

    public static List<Integer> getComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> getUserNumber() throws IllegalArgumentException{

        String tmp = readLine();

        if ((tmp.length() != 3) || !tmp.matches("[1-9]+")){
            throw new IllegalArgumentException();
        }

        List<Integer> userNum = new ArrayList<>();
        int tmpUserNum = Integer.parseInt(tmp);

        int firstNum = tmpUserNum/100;
        tmpUserNum %= 100;
        int secondNum = tmpUserNum/10;
        tmpUserNum %= 10;
        int thirdNum = tmpUserNum;

        if (!userNum.contains(firstNum)) {
            userNum.add(firstNum);
        }
        if (!userNum.contains(secondNum)) {
            userNum.add(secondNum);
        }
        if (!userNum.contains(thirdNum)) {
            userNum.add(thirdNum);
        }

        if (userNum.size() != 3){
            throw new IllegalArgumentException();
        }

        return userNum;
    }

    public static int check(List<Integer> computerNum, List<Integer> userNum){
        int strikeBallInfo = 0;

        for (int i=0; i<3; i++){
            if (userNum.get(i) == computerNum.get(i)){
                strikeBallInfo += 10;
            }
            else if ((userNum.get(i) == computerNum.get((i+1)%3)) || (userNum.get(i) == computerNum.get((i+2)%3))) {
                strikeBallInfo++;
            }
        }

        return strikeBallInfo;
    }
}


