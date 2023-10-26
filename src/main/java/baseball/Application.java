package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> answer = new ArrayList<>();
    public static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            makeNumber();
            Game();
            if(endGame() == 2){
                break;
            }
        }
    }

    public static void makeNumber(){
        answer.clear();
        while(answer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
    }

    public static void Game(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();
        String result = checkNumber(input);
        System.out.println(result);
        if(!result.equals("3스트라이크")){
            Game();
        }
    }

    public static void splitNumber(String input){
        if(input.length()!=3){
            throw new IllegalArgumentException();
        }
        inputList.clear();
        int i=0;
        while(inputList.size()<3){
            int number = IsNumber(input.split("")[i]);
            if(number == 0){
                throw new IllegalArgumentException();
            }
            if(inputList.contains(number)){
                throw new IllegalArgumentException();
            }
            inputList.add(number);
            i++;
        }
    }

    public static int IsNumber(String input){
        try{
            int number = Integer.valueOf(input);
            return number;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static String generateResultString(int ball, int strike){
        String result = "";
        if(ball==0 && strike==0){
            result = "낫싱";
        }else if(ball!=0 && strike==0){
            result = ball+"볼";
        }else if(ball==0 && strike!=0){
            result = strike+"스트라이크";
        }else{
            result = ball+"볼 "+ strike+"스트라이크";
        }
        return result;
    }

    public static String checkNumber(String input){
        splitNumber(input);

        int ball = 0;
        int strike = 0;
        for(int i=0;i<3;i++){
            if(answer.get(i)==inputList.get(i)){
                strike++;
            }else if(inputList.get(i)!=answer.get(i) && answer.contains(inputList.get(i))){
                ball++;
            }
        }

        return generateResultString(ball,strike);
    }

    public static int endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int number = IsNumber(readLine());
        if(number!=1 && number!=2){
            throw new IllegalArgumentException();
        }
        return number;
    }

}
