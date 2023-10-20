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

    //boolean isNotRepeat = false;
    boolean finishGame;

    public void mainController(){
        finishGame = false;

        System.out.println(printMsg(0)); //"숫자 야구 게임을 시작합니다."
        while (!finishGame){
            COMPUTER_NUM = randomNumber.mainMakeRnadomNumber(); //컴퓨터 숫자 알아오기
            //System.out.println(printMsg(0)); //"숫자 야구 게임을 시작합니다."

            //System.out.println(COMPUTER_NUM + "새로운컴퓨터");
            repeatInputToOutput(); //반복되는 구간
            //System.out.println(COMPUTER_NUM + "이전컴퓨터");

        }


    }



    private void isFinishGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();
        int number = Integer.parseInt(answer);
        System.out.println(number);

        if(number==1){ //게임 다시
            System.out.println("게임을 다시 합니다");
            finishGame = false;
        } else if(number ==2){ //게임 종료
            System.out.println("게임을 종료합니다");
            finishGame = true;
        }
        else {
            throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
        /*
        String answer = Console.readLine();
        int number = Integer.parseInt(answer);
        if(number == 2){
            finishGame = true;
            throw new IllegalArgumentException();
        } else if (number==1) {
            //COMPUTER_NUM = new ArrayList<>(); // 새로운 컴퓨터 숫자 생성
            //USER_NUM = new ArrayList<>(); // 사용자 숫자 초기화

        }
        */

    }




    private void repeatInputToOutput(){ //반복되는
        System.out.println(COMPUTER_NUM + "컴퓨터");


        boolean isNotRepeat = false;
        while (!isNotRepeat){
            System.out.print(printMsg(1)); //"숫자를 입력해주세요 : " println이 아니고 print로 출력
            String answer = Console.readLine(); //사용자에게 번호 입력받기
            USER_NUM = stringToList(answer); //list 변환 + 유효검사
            isNotRepeat = scoreManager.setAndCheckScore(COMPUTER_NUM, USER_NUM); //true면 몀춤


            System.out.println(isNotRepeat);
            if(isNotRepeat){ //isNotRepeat가 true가 되자마자 빠져나오지는 않는다.
                isFinishGame();
            }
        }

        //만약 all스트라이크 = 멈춤
        //아님 => 꼐속

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
