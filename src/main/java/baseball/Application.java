package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean playing = true;

    public static int strike = 0;
    public static int ball = 0;
    public static int out = 0;

    public static List<Integer> computer = null;
    public static List<Integer> user = null;

    public static void init(){
        playing = true;
        strike = 0;
        ball = 0;
        out = 0;
        computer = null;
        user = null;
    }

    public static void createAnswer(){
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public static boolean validateUserInput(String input){
        user = new ArrayList<>();

        if(input.length() != 3){
            return false;
        }

        for(int i=0; i<input.length(); i++){
            char testChar = input.charAt(i);

            if(!Character.isDigit(testChar)){
                return false;
            }

            int tempInt = Character.getNumericValue(testChar);
            if(tempInt == 0){
                return false;
            }
            if(user.contains(tempInt)){
                return false;
            }
            user.add(tempInt);
        }

        return user.size() == 3;
    }

    public static void whetherBallStrikeOut(){
        ball = 0;
        strike = 0;
        out = 0;

        for(int i=0; i<user.size(); i++){
            int userCurNum = user.get(i);
            int computerCurNum = computer.get(i);

            if(userCurNum == computerCurNum){
                strike +=1;
                continue;
            }

            if(computer.contains(userCurNum)){
                ball +=1;
                continue;
            }

            out += 1;
        }
    }

    public static boolean qWhetherTerminate(String input){
        if("1".equals(input)){
            return true;
        } else if("2".equals(input)){
            return false;
        }

        throw new IllegalArgumentException();
    }

    public static void printResult(){
        String result = "";

        if(out == 3){
            result += "낫싱";
        }

        if(ball > 0){
            result += ball + "볼";
        }

        if(strike > 0){
            // ball이 하나라도 있으면 공백을 추가해줘야함
            if(!result.isEmpty()){
                result += " ";
            }
            result += strike + "스트라이크";
        }

        System.out.println(result);
    }


    public static void main(String[] args){
        init(); // 멤버 변수 정리

        System.out.println("숫자 야구게임을 시작합니다.");
        createAnswer();

        while (playing){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            if(!validateUserInput(userInput)){
                throw new IllegalArgumentException();
            }
            whetherBallStrikeOut();

            printResult();

            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String input = Console.readLine();

                if(!qWhetherTerminate(input)){
                    playing = false;
                } else{
                    createAnswer();
                }
            }
        }
    }
}
