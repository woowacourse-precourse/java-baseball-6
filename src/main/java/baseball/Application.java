package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * 상대방(컴퓨터)이 숫자 생성
     * @return List<Integer> computer
     */
    public List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    /**
     * 입력 받은 수 검증
     * @param input
     * @return boolean true || false
     */
    public boolean inputCheckAll(String input) {
        //3자리 수가 맞는지 확인
        if (!inputCheckLength(input)) {
            return false;
        }
        //다른 문자가 아닌, 숫자인지 확인
        if (!inputCheckNumber(input)) {
            return false;
        }

        return true;
    }

    public boolean inputCheckLength(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    public boolean inputCheckNumber(String input) {
        if (!input.matches("[1-9]+")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Application application = new Application();
        List<Integer> computer = application.makeComputerNumber();  //상대방(컴퓨터)이 숫자 생성
        String input;                                               //입력받는 값을 넣어 줄 변수
        boolean gameFlag = true;                                    //게임 계속 실행할지 그만둘지 표시

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameFlag) {
            System.out.println("숫자를 입력해주세요 : ");

            input = Console.readLine();                             //사용자가 숫자를 입력할 수 있는 환경 구현
            if (!application.inputCheckAll(input)) {
                throw new IllegalArgumentException();
            }


        }
    }
}
