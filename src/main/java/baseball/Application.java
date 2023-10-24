package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (outerCondition) {
            String generatedNumber = numberGenerator();
            System.out.println("숫자 야구 게임을 시작합니다.");
            try {
                while (innerCondition) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String userInput = getUserInput();
                    inputNumberTest(userInput);
                    isStrikeBallOut(userInput, generatedNumber);                
                }
            } catch (IllegalArgumentException e) {
                outerCondition = false;
                innerCondition = false;
                break;
            }
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
                int oneOrTwo = Integer.parseInt(getUserInput());
                if(oneOrTwo == 1){
                    outerCondition = true;
                    innerCondition = true;
                } else if(oneOrTwo == 2){
                    outerCondition = false;
                } else{
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            } catch (IllegalArgumentException e) {
                outerCondition = false;
                innerCondition = false;
                break;
            }
        }
    }
    
    public static boolean innerCondition = true;
    public static boolean outerCondition = true;
    public static String numberGenerator() {
        List<Integer> rNum = new ArrayList<>();

        while (rNum.size() < 3) {
            int tmpNum = Randoms.pickNumberInRange(1, 9);
            if (!rNum.contains(tmpNum)) {
                rNum.add(tmpNum);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : rNum) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static String getUserInput() {
        return Console.readLine();
    }

    public static void inputNumberTest(String input){// 입력한 숫자가 규격에 맞는지 테스트
        if(!input.matches("[1-9]{3}") || uniqueTest(input)){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static boolean uniqueTest(String input){//중복 숫자 있는지 판단
        for(int i=0; i < input.length();i++){
            char a = input.charAt(i);
            if(input.indexOf(a) != input.lastIndexOf(a)){
                return true;
            }
        }
        return false;
    }

    public static void isStrikeBallOut(String inputNum, String solveNum){
        //스트라이크
        int strike = 0;
        int ball = 0;
        for(int i=0;i<inputNum.length();i++){
            char digit = inputNum.charAt(i);
            int solveIndex = solveNum.indexOf(digit);
            if(solveIndex == -1){
                continue;
            }
            if(i != solveIndex){
                ball += 1;
            }
            if(i == solveIndex){
                strike += 1;
            }
        }
        if(ball==0 && strike == 0){
            System.out.print("낫싱");
        } else {
            if(ball>0){
                System.out.print(ball + "볼 ");
            }
            if(strike>0){
                System.out.print(strike + "스트라이크");
            }
        }
        if(strike == 3 ){
            System.out.println();
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            innerCondition = false;
        }
        System.out.println();
    }
}