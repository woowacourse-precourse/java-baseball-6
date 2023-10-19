package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    RandomNumber randomNumber = new RandomNumber();
    static List<Integer> COMPUTER_NUM = new ArrayList<>();
    static List<Integer> USER_NUM = new ArrayList<>();
    boolean isRepeat = true;

    public void mainController(){
        COMPUTER_NUM = randomNumber.mainMakeRnadomNumber();
        //System.out.println(COMPUTER_NUM);
        repeatInputToOutput();
        System.out.println(USER_NUM + "문자열");
    }

    private void repeatInputToOutput(){ //반복되는
        String answer = Console.readLine();
        USER_NUM = stringToList(answer);

        //숫자받기
        //유효성검사
        //저장
        //대조 검사

    }
    private List<Integer> stringToList(String answer){ //string => list 변환
        String[] strArray = answer.split("");
        List<Integer> resultList = new ArrayList<>();

        for(String str : strArray){
            int num = Integer.parseInt(str);
            resultList.add(num);
        }

        return resultList;
    }

}
