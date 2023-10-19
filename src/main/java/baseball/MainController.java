package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    RandomNumber randomNumber = new RandomNumber();
    Validator validator = new Validator();
    ScoreManager scoreManager = new ScoreManager();
    static List<Integer> COMPUTER_NUM = new ArrayList<>();
    static List<Integer> USER_NUM = new ArrayList<>();
    boolean isRepeat = true;

    public void mainController(){
        COMPUTER_NUM = randomNumber.mainMakeRnadomNumber(); //컴퓨터 숫자 알아오기
        System.out.println(printMsg(0)); //"숫자 야구 게임을 시작합니다."

        while (isRepeat) {
            repeatInputToOutput(); //반복되는 구간
            System.out.println(COMPUTER_NUM + "컴퓨터");
            //System.out.println(USER_NUM + "사용자");
        }
    }








    private void repeatInputToOutput(){ //반복되는
        System.out.print(printMsg(1)); //"숫자를 입력해주세요 : " println이 아니고 print로 출력
        String answer = Console.readLine(); //사용자에게 번호 입력받기
        USER_NUM = stringToList(answer); //list 변환 + 유효검사
        isRepeat = scoreManager.setAndCheckScore(COMPUTER_NUM, USER_NUM);

        //대조 검사

    }
    private List<Integer> stringToList(String answer){ //string => list 변환
        String[] strArray = answer.split("");
        List<Integer> resultList = new ArrayList<>();

        for(String str : strArray){
            int num = Integer.parseInt(str);
            resultList.add(num);
        }
        validator.isVaildNumber(resultList,answer); //숫자 유효검사

        return resultList;
    }

    private String printMsg(int i){
        String[] msg = {"숫자 야구 게임을 시작합니다.",
                "숫자를 입력해주세요 : "
        };
        return msg[i];
    }

}
