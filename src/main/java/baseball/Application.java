package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean con = true;
        while(con) {
            baseballGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputString = Console.readLine();

            if (inputString.equals("2")) {
                con = false;
            }else if (inputString.equals("1")){
                continue;
            }else {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void baseballGame(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


        Boolean isOut = false;
        while(!isOut){
            isOut = pitch(computer);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public static boolean pitch(List<Integer> computer){
        System.out.print("숫자를 입력해주세요 : ");
        int strikeCount = 0;
        int ballCount = 0;

        String inputString = Console.readLine();
        String[] inputStringList = inputString.split("");
        if(inputStringList.length != 3){
            throw  new IllegalArgumentException();
        }
        int[] inputIntegerList = null;
        try {
            inputIntegerList = Arrays.stream(inputStringList).mapToInt(Integer::parseInt).toArray();
        }catch ( NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }

        for(int i = 0; i<3; i++) {
            String judgeResult = judge(computer, i, inputIntegerList[i]);
            if (judgeResult.equals("Strike")) {
                strikeCount++;
            } else if (judgeResult.equals("Ball")) {
                ballCount++;
            }
        }
        if(ballCount == 0 && strikeCount == 0){
            System.out.print("낫싱");
        } else {
            if(ballCount!=0){
                System.out.print(ballCount + "볼");
                if(strikeCount!=0){ System.out.print(" "); }
            }
            if(strikeCount!=0){
                System.out.print(strikeCount + "스트라이크");
                if(strikeCount == 3){
                    System.out.println();
                    return true;
                }
            }
        }
        System.out.println();
        return false;
    }
    public static String judge(List<Integer> computer, Integer index, Integer input) {
        for(int i = 0; i<3; i++){
            if(computer.get(i).equals(input)){
                if(i == index){
                    return "Strike";
                }
                return "Ball";
            }
        }
        return "Nothing";
    }
}
