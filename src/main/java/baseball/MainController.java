package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    RandomNumber randomNumber = new RandomNumber();
    Validator validator = new Validator();
    ScoreManager scoreManager = new ScoreManager();

    static List<Integer> COMPUTER_NUM = new ArrayList<>(); //컴퓨터 숫지
    static List<Integer> USER_NUM = new ArrayList<>(); //사용자 숫자
    static boolean FINISH_GAME; //게임이 끝났는가?

    public void mainController(){
        FINISH_GAME = false;

        System.out.println(printMsg(0)); //"숫자 야구 게임을 시작합니다."
        while (!FINISH_GAME){ //게임 종료할 떄까지 반복
            COMPUTER_NUM = randomNumber.mainMakeRnadomNumber(); //컴퓨터 랜덤숫자 생성 -> 저장
            repeatInputToOutput(); //3스트라이크가 될때까지 반복되는 구간
        }
    }

    //3스트라이크가 될때까지 반복되는 구간
    private void repeatInputToOutput(){ //사용자 숫자 입력받기 및 저장 -> 유효검사 -> 점수 매기기 -> 점수 출
        boolean isNotRepeat = false; //3스트라이크면 true -> 멈춤

        System.out.println(COMPUTER_NUM + "컴퓨터");
        while (!isNotRepeat){
            System.out.print(printMsg(1)); //"숫자를 입력해주세요 : " println이 아니고 print로 출력
            String answer = Console.readLine(); //사용자에게 번호 입력받기
            USER_NUM = stringToList(answer); //list 변환 + 유효검사 -> 저장
            isNotRepeat = scoreManager.setAndCheckScore(COMPUTER_NUM, USER_NUM); //점수 매기기 -> 점수출력
        }
        if(isNotRepeat){ //=true 3스트라이크 시
            isFinishGame(); //마지막 msg 출력
        }
    }

    // 3스트라이크시 마지막 msg
    private void isFinishGame(){
        System.out.println(printMsg(2)); //"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        String answer = Console.readLine();
        int number = Integer.parseInt(answer); //String->int변환

        if(number==1){ //게임 다시
            FINISH_GAME = false;
        } else if(number ==2){ //게임 종료
            FINISH_GAME = true; //mainController 다시 실행
        } else {
            throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
    }

    private List<Integer> stringToList(String answer){ //입력받는 숫자 string => list 변환
        List<Integer> resultList = new ArrayList<>();

        String[] strArray = answer.split(""); //String -> String[]
        for(String str : strArray){
            int num = Integer.parseInt(str); //String(한글자) -> int 변환
            resultList.add(num);
        }
        validator.isVaildNumber(resultList,answer); //숫자 유효검사

        return resultList;
    }

    private String printMsg(int i){ //출력할 메시지 저장
        String[] msg = {"숫자 야구 게임을 시작합니다.",
                "숫자를 입력해주세요 : ",
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        };
        return msg[i];
    }
}
