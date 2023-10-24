package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        String status = "1"; // 상태가 1이면 새 게임 시작, 2면 종료
        do {
            List<Integer> comNum = generateNum();   // 컴퓨터가 난수 생성
            playNumberBaseballGame(comNum);   // 생성된 난수로 게임 시작
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            status = Console.readLine();    // 게임 종료 후 1 또는 2 입력 받음
        } while (status.equals("1"));
    }

    public static List<Integer> generateNum() {     // 난수 생성 함수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void checkInputValid(String input) {
        try {
            int number = Integer.parseInt(input);   //  입력받은 난수를 int 형으로 캐스팅하여 값의 유효성 검사
            if (number < 100 || number > 999) {
                throw new IllegalArgumentException("세자리 수가 아닙니다."); //  세자리 수가 아니면 오류 처리
            }
            if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
                throw new IllegalArgumentException("중복 숫자가 있습니다."); //  중복된 숫자 발견 시 오류 처리
            }
        } catch (IllegalArgumentException e) {
//                System.out.println("예외 발생: " + e.getMessage());
            throw e;
        }
    }

    public static boolean playNumberBaseballGame(List<Integer> comNum) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("문자열을 입력하세요 : ");
            input = Console.readLine(); // 사용자로부터 숫자 입력 받음
            checkInputValid(input);

            String ScomNum = "";    //  컴퓨터가 생성한 난수를 문자열로 받아오는 변수
            for (int number : comNum) { //  난수를 문자열로 변환하는 프로세스
                ScomNum += number;
            }
            if (ScomNum.equals(input)) {    //  난수와 사용자의 입력 값이 일치하면 3 스트라이크로 종료
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            wrongCheck(ScomNum, input); //  완전 일치하지 않을 경우, 비교하여 볼/스트라이크 카운트
        }
        return true;
    }

    public static void wrongCheck(String ScomNum, String input) {
        int strikeCnt = 0;
        int ballCnt = 0;
        //  두개의 숫자를 char 배열에 저장
        char[] comNumArray = ScomNum.toCharArray();
        char[] inputNumArray = input.toCharArray();
        //  두수의 숫자와 숫자의 위치에 따른 스트라이크/볼 카운트 조정
        for (int i = 0; i < comNumArray.length; i++) {
            for (int j = 0; j < inputNumArray.length; j++) {
                if (comNumArray[i] == inputNumArray[i]) {   //  숫자의 위치와 숫자가 같으면 스트라이크 +1
                    strikeCnt += 1;
                    break;
                }
                else if (comNumArray[i] == inputNumArray[j]) {  //  같은 숫자가 다른 자리에 있으면 볼 +1
                    ballCnt += 1;
                    break;
                }
            }
        }
        //  출력
        if (ballCnt > 0 || strikeCnt > 0) {
            if (strikeCnt == 0) {
                System.out.println(ballCnt+"볼");
            }
            else if (ballCnt == 0) {
                System.out.println(strikeCnt+"스트라이크");
            }
            else {
                System.out.print(ballCnt+"볼 ");
                System.out.println(strikeCnt+"스트라이크");
            }
        }
        else {
            System.out.println("낫싱");
        }
    }
}
