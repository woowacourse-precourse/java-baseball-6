package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(answer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            String result = checkNumber(input);
            System.out.println(result);
            if(result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int reset = Integer.valueOf(readLine());
                if(reset == 2){
                    break;
                }
            }
        }
    }

    public static String checkNumber(String input){
        String result="";
        int inputNumber = Integer.valueOf(input);
        List<Integer> inputList = new ArrayList<>();
        inputList.add(inputNumber/100);
        inputNumber%=100;
        inputList.add(inputNumber/10);
        inputList.add(inputNumber%10);
        int strike = 0;
        int ball = 0;
        for(int i=0;i<3;i++){
            if(answer.get(i)==inputList.get(i)){
                strike++;
            }else if(inputList.get(i)!=answer.get(i) && answer.contains(inputList.get(i))){
                ball++;
            }
        }
        if(ball==0 && strike==0){
            result = "낫싱";
        }else if(ball!=0 && strike==0){
            result=ball+"볼";
        }else if(ball==0 && strike!=0){
            result=strike+"스트라이크";
        }else{
            result=ball+"볼 "+ strike+"스트라이크";
        }
        return result;
    }

}
