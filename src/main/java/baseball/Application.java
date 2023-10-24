package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // restart의 초기값을 true로 설정하여 while문의 실행 조건을 충족하도록 한다.
        boolean restart = true;

        // while문 안에서 숫자야구 게임을 진행한다.
        // 게임 종료 시 재시작 여부에 따라 restart 변수를 제어하여 while문의 재실행 여부를 제어한다.
        while(restart == true){
            System.out.println("숫자 야구 게임을 시작합니다.");

            // computerList라는 이름의 리스트를 선언한다.
            // makeRandomList 함수를 사용해 computerList에 길이가 3이고 중복되지 않는 랜덤 숫자로 이루어진 리스트를 저장한다.
            List<Integer> computerList = new ArrayList<>();
            computerList = makeRandomList(3);

            // gaming 함수를 사용해 숫자야구를 진행한다.
            // gaming 함수는 3스트라이크가 나올 때까지, 입력을 받고 결과를 출력하는 과정을 반복한다.
            gaming(computerList);

            // 게임 종료되면 askFinish 함수를 사용해 게임 재시작 여부를 입력받는다.
            // askFinish함수는 게임 재시작 선택 시 true를, 종료 선택 시 false를 반환한다.
            // 해당 값을 restart 변수에 저장하여 while문의 재실행 여부를 제어한다.
            restart = askFinish();
        }
    }

    /**
     * 길이가 length이고, 중복되지 않는 랜덤한 숫자들로 이루어진 List를 반환하는 함수이다.
     *
     * @param length : 반환할 List의 길이
     * @return randomList : 중복되지 않는 랜덤한 숫자들로 이루어지고 길이가 length인 List
     */
    public static List<Integer> makeRandomList(int length){
        List<Integer> randomList = new ArrayList<>();

        // randomList의 길이가 length가 될 때까지 숫자를 추가하는 과정을 반복한다.
        while (randomList.size() < length) {
            // 1과 9 사이의 랜덤한 수를 골라 randomNumber에 저장한다.
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            // randomList에 해당 숫자가 없다면, randomList에 해당 숫자를 추가한다.
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }

    /**
     * 실질적으로 숫자 야구를 하는 함수로, 3자리 숫자를 입력 받고 matching 함수를 사용해 그에 따른 결과를 출력한다.
     * matching 함수는 숫자 야구 결과를 출력한다. 또한 3 스트라이크일 경우 true를, 그 외에는 false를 반환한다.
     * false를 반환받을 경우, 다시 gaming 함수를 호출해 숫자를 입력하고 결과를 확인하는 과정이 진행 되도록 한다.
     * 입력 받은 데이터가 3자리 숫자가 아닐 경우 오류를 발생 시킨다.
     *
     * @param computerList : 사용자의 입력과 비교할 List
     * @throws : 길이가 3이 아니거나 정수 만으로 이루어지지 않는 경우 IllegalArgumentException
     */
    public static void gaming(List<Integer> computerList){
        System.out.print("숫자를 입력해주세요 : ");
        String gameInput = Console.readLine();

        // 1.길이가 3이 아니거나 2.모두 정수로 이루어져있지 않은 경우 오류를 발생시킨다.
        // checkInt 함수는 모두 정수로 이루어졌을 경우 true를, 그렇지 않은 경우 false를 반환한다.
        if(gameInput.length() != 3 || checkInt(gameInput) == false){
            throw new IllegalArgumentException("3자리 숫자가 아닙니다.");
        }

        // matching 함수가 false를 반환할 경우 다시 gaming함수를 호출하고, true를 반환할 경우는 gaming 함수가 그대로 종료된다.
        // matching 함수는 3스트라이크일 경우 true를, 그 외의 경우 false를 반환한다.
        else if (matching(gameInput, computerList) == false){
            gaming(computerList);
        }
    }

    /**
     * 문자열 형태의 gameInput이 정수로만 이루어졌는지 확인하는 함수이다.
     *
     * @param gameInput : 확인할 문자열
     * @return : 모두 정수로 이루어졌을 경우 true, 그렇지 않은 경우 false
     */
    public static boolean checkInt(String gameInput){
        for(int i=0 ; i<gameInput.length() ; i++){
            // gameInput의 i번째 원소를 currentChar에 저장한다. (문자 형태)
            char currentChar = gameInput.charAt(i);

            // currentChar이 정수가 아닐 경우 false를 반환한다.
            if(Character.isDigit(currentChar) == false)
                return false;
        }

        // 모두 정수일 경우 true를 반환한다.
        return true;
    }

    /**
     * gameInput과 computerList를 비교하여  볼과 스트라이크 개수를 출력하는 함수이다.
     * 결과가 3 스트라이크인 경우 true를 반환하고 이외에는 false를 반환한다.
     * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼로 카운트하며, 같은 수가 전혀 없으면 낫싱을 출력한다.
     *
     * @param gameInput : 사용자가 입력한 문자열
     * @param computerList : 사용자 입력과 비교할 List
     * @return : strike가 3일 경우 true, 이외에는 false
     */
    public static boolean matching(String gameInput, List<Integer> computerList){
        // 스트라이크의 개수는 strike 변수를, 볼의 개수는 ball 변수를 사용한다.
        int strike=0, ball=0;

        // gameInput의 첫번째 원소부터 정수형으로 변환 후 computerList와 비교한다.
        for (int i=0 ; i<gameInput.length() ; i++){
            // gameInput의 i번째 원소를 문자 형태로 가져오고, 0의 아스키코드만큼 빼주어 해당 숫자를 currentInt에 저장한다.
            int currentInt = gameInput.charAt(i)-'0';

            // 포함하고 있지만 자리가 다른 경우 ball을 증가시키고, 자리까지 같은 경우 strike를 증가시킨다.
            if(computerList.contains(currentInt)){
                if(computerList.get(i)==currentInt)
                    strike++;
                else
                    ball++;
            }
        }

        // strike가 3일 경우, 결과 출력 후 true를 반환한다.
        if (strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        // strike와 ball 모두 0일 경우, '낫싱' 출력 후 false를 반환한다.
        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }

        // 그 외의 경우 ball과 strike의 개수를 출력하고, false를 반환한다.
        else{
            System.out.println(ball+"볼 " + strike + "스트라이크");
            return false;
        }
    }

    /**
     * 종료 여부를 입력받는 함수이다.
     *
     * @return : 재시작(1)을 선택한 경우 true, 종료(2)를 선택한 경우 false
     * @throws : 1과 2 이외의 데이터를 입력했다면 IllegalArgumentException
     */
    public static Boolean askFinish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String finishInput = Console.readLine();

        // 1 입력 시 true를 반환한다.
        if(finishInput.equals("1")){
            return true;
        }

        // 2 입력 시 false를 반환한다.
        else if (finishInput.equals("2")){
            return false;
        }

        // 입력 데이터가 1이나 2가 아닐 경우, IllegalArgumentException 에러를 발생시킨다.
        else {
            throw new IllegalArgumentException("1과 2중에 선택하세요.");
        }
    }
}
