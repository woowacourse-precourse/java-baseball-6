package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Game {

    public void start(){
        boolean flag = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(flag){
            flag = game();
        }
        Console.close();
    }

    public boolean game(){
        boolean flag = true;
        Number number = Number.getInstance();
        number.generateAnswer();
        StringBuilder sb;

        List<String> words = Arrays.asList(new String[]{"볼", "스트라이크"});
        while(flag){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> predict = Utils.getNumberFromUser();
            List<Integer> result = number.checkAnswer(predict);
            sb = new StringBuilder();
            for(int i=0; i<words.size(); i++){
                if (result.get(i) !=0){
                    sb.append(String.format("%d%s ", result.get(i), words.get(i)));
                }
            }

            if(sb.toString().length()>0){
                System.out.println(sb.toString());
            }
            else{
                System.out.println("낫싱");
            }

            if(result.get(1).equals(3)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int gameAgain = Integer.parseInt(Console.readLine());
                if(gameAgain == 1){
                    return true;
                }
                return false;
            }
        }

        return flag;
    }

}
