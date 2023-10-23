package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
//        숫자야구 게임은 while문 안에서 실행된다.
//        while문의 조건이 참이 되어 실행되도록 restart의 초기값을 true로 설정한다.

        boolean restart = true;

        while(restart == true){
            System.out.println("숫자 야구 게임을 시작합니다.");

//            computerList라는 이름의 리스트를 선언한다.
//            makeRandomList 함수를 사용해 길이가 3이고 중복되지 않는 랜덤 숫자로 이루어진 리스트를 computerList에 저장한다.
            List<Integer> computerList = new ArrayList<>();
            computerList = makeRandomList(3);

//            gaming 함수를 사용해 3스트라이크가 나올 때까지 숫자야구를 진행한다.
            gaming(computerList);

//            게임 종료되면 askFinish 함수를 사용해 게임 재시작 여부를 입력받는다.
//            askFinish함수는 게임 재시작 선택 시 true를, 종료 선택 시 false를 반환한다.
//            해당 값을 restart 변수에 저장하여 while문의 재실행 여부를 제어한다.
            restart = askFinish();
        }
    }

    public static List<Integer> makeRandomList(int length){
//        길이가 length이고, 중복되지 않는 랜덤 숫자로 이루어진 List를 반환하는 함수이다.

        List<Integer> randomList = new ArrayList<>();

//        랜덤으로 1부터 9까지의 숫자를 고르고, 해당 숫자가 randomList에 없다면 추가한다.
//        randomList의 길이가 length보다 작을 경우 위 과정을 반복한다.
        while (randomList.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }

    public static void gaming(List<Integer> computerList){
//        실질적으로 숫자 야구를 하는 함수이다.
//        입력 받은 데이터가 3자리 숫자가 아닐 경우 오류를 발생 시키고, 3자리 숫자일 경우 matching 함수를 실행한다.
//        입력 받은 데이터의 숫자 야구 결과가 3스트라이크가 아닌 경우, 다시 gaming 함수를 호출해 숫자를 입력하는 과정이 진행 되도록 한다.

        System.out.print("숫자를 입력해주세요 : ");
        String gameInput = Console.readLine();

        if(gameInput.length() != 3 || checkInt(gameInput) == false){
//            길이가 3이 아니거나 모두 정수로 이루어져있지 않은 경우 오류를 발생시킨다.
//            checkInt 함수는 모두 정수로 이루어졌을 경우 true를, 그렇지 않은 경우 false를 반환한다.
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }
        else if (matching(gameInput, computerList) == false){
//            matching 함수는 3스트라이크일 경우 true를, 그 외의 경우 false를 반환한다.
//            false일 경우 다시 gaming함수를 호출하고, true일 경우는 gaming 함수가 그대로 종료된다.
            gaming(computerList);
        }
    }

    public static boolean checkInt(String gameInput){
//        gameInput이 정수로 이루어졌는지 확인하는 함수이다.
//        모두 정수로 이루어졌을 경우 true를, 그렇지 않은 경우 false를 반환한다.

        for(int i=0 ; i<gameInput.length() ; i++){
            char currentChar = gameInput.charAt(i);
            if(Character.isDigit(currentChar) == false)
                return false;
        }

        return true;
    }

    public static boolean matching(String gameInput, List<Integer> computerList){
//        gameInput과 computerList를 비교하여  스크라이크, 볼 여부를 알려주는 함수이다.
//        3자리 숫자와 위치를 모두 맞춘 경우 true를 반환하고, 그 외에는 false를 반환한다.

        int strike=0, ball=0;

//        gameInput의 맨 앞자리부터 정수형으로 변환 후 computerList와 비교한다.
//        포함하고 있지만 자리가 다른 경우 ball을 증가시키고, 자리까지 같은 경우 strike를 증가시킨다.
        for (int i=0 ; i<gameInput.length() ; i++){
            int currentInt = gameInput.charAt(i)-'0';

            if(computerList.contains(currentInt)){
                if(computerList.get(i)==currentInt)
                    strike++;
                else
                    ball++;
            }
        }

        if (strike == 3){
//            3스트라이크의 경우, true를 반환한다.
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if (strike == 0 && ball == 0) {
//            낫싱의 경우, false를 반환한다.
            System.out.println("낫싱");
            return false;
        }
        else{
//            그 외의 경우 볼과 스트라이크 개수를 출력하고, false를 반환한다.
            System.out.println(ball+"볼 " + strike + "스트라이크");
            return false;
        }

    }

    public static Boolean askFinish(){
//        종료 여부를 입력받는 함수이다.
//        재시작(1)을 선택한 경우 true를, 종료(2)를 선택한 경우 false를 반환한다.
//        1과 2 이외의 데이터를 입력했다면 오류를 발생시킨다.

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String finishInput = Console.readLine();

        if(finishInput.equals("1"))
            return true;

        else if (finishInput.equals("2"))
            return false;

        else
            throw new  IllegalArgumentException("1과 2중에 선택하세요.");
    }
}
