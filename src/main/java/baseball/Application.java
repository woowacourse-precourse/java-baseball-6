package baseball;

/*
     3가지 수 랜덤 - 컴퓨터
     3가지 수 입력해서 컴퓨터의 숫자 맞추기
     동일한 위치에 같은 숫자를 적으면 -> 1,2,3스트라이크
     숫자는 같지만 위치는 다를 때 -> 1,2,3볼
     하나도 맞지 않을 때 -> 낫싱
     새로 시작 -> 1 , 종료 -> 2
 */
/*
    필요한 거 -> 랜덤, 스캐너
    숫자를 스트링으로 해서 인덱스를 비교해?
    스트라이크 -> 컴퓨터의 인덱스와 입력한 인덱스를 일대일 비교 맞으면 스트라이크 출력
    볼 -> 3 숫자와 비교해서 하나라도 같고, 같은 숫자와 같은 인덱스가 아닐 때
    낫싱 -> 3 숫자와 비교해서 하나도 같지 않을 때
 */

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private String userAnswer;
    private String endAnswer;
    private List<Integer> comNum;
    private int strike = 0;
    private int ball = 0;

    //게임 시작
    public void startgame(){

        System.out.println("숫자 야구 게임을 시작합니다.");

        this.comNum = computerNumber(); //컴퓨터 숫자 반환메소드 호출해서 사용

    }

    //컴퓨터 숫자 반환메소드
    public List<Integer> computerNumber(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("컴퓨터 숫자 >>>"+computer);

        return computer;

    }

    //사용자 입력
    public void inputNumber(){

        System.out.print("숫자를 입력해주세요 : ");
        userAnswer = Console.readLine();

        if(userAnswer.length() != 3){
            System.out.println("잘못된 입력입니다.");
            play();
        }

    }

    //입력값 정수 리스트 반환메소드
    public List<Integer> userNumber(){

        //문자열 입력값을 정수 입력값으로 변환하여 리스트에 하나씩 저장
        List<Integer> userNumber = new ArrayList<>();

        for (int i=0;i<userAnswer.length();i++){
            char answerChar  = userAnswer.charAt(i);
            int answerInt = Character.getNumericValue(answerChar); //char -> int 형변환
            userNumber.add(answerInt);
        }

        return userNumber;

    }

    //게임 - 숫자 비교
    public void playBaseball(){

        List<Integer> userNum = userNumber(); //입력값 정수화해서 가져오기

        strike = 0; //초기화
        ball = 0;

        //-- 컴퓨터와 입력값 비교 -----------------------------
        for(int i=0;i<3;i++){
            if (userNum.get(i) == this.comNum.get(i)){
                strike++;
            } else if (this.comNum.contains(userNum.get(i))) {
                ball++;
            }
        }

        if(ball>0) System.out.print(ball + "볼 ");
        if(strike>0) System.out.print(strike + "스트라이크");
        if(strike==0 && ball==0) System.out.println("낫싱");
        System.out.println(); //--모양새 맞추는 거 은지꺼 슬쩍 봤슴니다..ㅎㅎㅠ

    }

    //게임 진행
    public void play(){

        do {

            inputNumber(); //입력받기
            playBaseball(); //게임하기

        }while (strike !=3 );

    }

    //게임 결과
    public void result(){

        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    //재시작
    public void restart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        endAnswer = Console.readLine();

        //-- 게임 재시작 ------------------------------
        switch (endAnswer) {
            case "1": game(); break;
            case "2": System.exit(0); break;
            default:
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                restart();
        }

    }

    public void game(){

        try {

            while (true) {

            startgame();
            play();
            result();
            restart();

            }

        }catch (IllegalArgumentException  e){
            throw e;
        }

    }


    public static void main(String[] args) {

        Application ob = new Application();

        ob.game();
    }
}
