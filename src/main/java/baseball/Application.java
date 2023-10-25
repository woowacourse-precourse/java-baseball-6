package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
        public static void main(String[] args) {
                StartGame();
        }

        public static void StartGame() {                 //게임시작
                System.out.println("숫자야구 게임을 시작 합니다.");
                List<String> computer = ComputerInput();
                UserInput(computer);
                System.out.println("computer = " + computer);           //난수 확인값
        }

        // 랜덤숫자3자리 생성 메소드  =============================================================================
        public static List<String> ComputerInput() {            //난수생성
                List<String> computer = new ArrayList<>();
                while (computer.size() < 3) {
                        String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
                        if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                        }
                }
                System.out.println("computer = " + computer);           //난수 확인값
                return computer;
        }

        // 입력값 메소드(입력후 전달받은 computer 값과 비교후 출력) ===================================================
        public static void UserInput(List<String> computer) {                   //todo 예외처리 (중복포함)
                List<String> user = new ArrayList<>();
                System.out.println("중복이 되지 않는 세 자리의 숫자를 입력해 주세요.");
                String userInput = Console.readLine();
                System.out.println("userInput = " + userInput);
                try {
                        for(String s : userInput.split("")) { // 입력받은 값을 배열에 나눠서 저장
                                if(!user.contains(s)) {  // 배열에 값이 없으면
                                        user.add(s);  // 배열에 저장
                                } else { // 값이 있으면 Exception 발생
                                        throw new IllegalArgumentException();
                                }
                        }
                        for(String s : user) { // 유저에게 입력받은 값 확인을 위한 for문
                                if(toParseInt(s,0) == 0) { // 0 또는 문자가 입력되면 Exception 발생시킴
                                        throw new IllegalArgumentException();
                                }
                        }
                } catch (IllegalArgumentException e) {
                        return;
                }
                if(userInput.length() != 3) { // 입력된 수가 3자리가 아니라면 Exception 발생
                        throw new IllegalArgumentException();
                }
                System.out.println("user = " + user);           // 입력 확인값

                // 판정 메소드 ===================================================================================
                int ballCount = 0;
                int strikeCount = 0;
                for (int j = 0; j < user.size(); j++) {
                        if (computer.contains(user.get(j))) {
                                if (computer.indexOf(user.get(j)) == j) {
                                        strikeCount++;
                                } else {
                                        ballCount++;
                                }
                        }
                }
//                        System.out.println("strikeCount = " + strikeCount);
//                        System.out.println("ballCount = " + ballCount);
                // 출력 메소드 ===================================================================================
                if (strikeCount == 3) {
                        System.out.println("3스트라이크!");
                        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료\n" +
                                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        String choice = Console.readLine();           // 재시작 또는 종료를 하기 위한 입력
                        if (choice.equals("1")) {
                                System.out.println("게임을 재시작 합니다.\n");
                                StartGame();            //게임 재시작
                        } else if (choice.equals("2")) {
                                System.out.println("게임을 종료 합니다.");
                                return;
                        } else {
                                try {
                                        throw new IllegalArgumentException();   //1,2 외의 값 입력시 예외처리 후 종료
                                } catch (Exception e) {
                                        System.out.println("잘못된 값을 입력 했습니다.");
                                        return;
                                }
                        }
                } else if (strikeCount + ballCount == 0) {
                        System.out.println("낫싱!");
                        UserInput(computer);
                } else if (strikeCount == 0 && ballCount > 0) {
                        System.out.println(ballCount + "볼");
                        UserInput(computer);
                } else if (ballCount == 0 && strikeCount > 0) {
                        System.out.println(strikeCount + "스트라이크");
                        UserInput(computer);
                } else {
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");        // 출력
                        UserInput(computer);
                }
        }

        public static int toParseInt(String value, int defVal) {        // 입력된 변수를 Integer로 바꿔주는 함수
                try {
                        return Integer.parseInt(value);         //입력 숫자 예외처리
                } catch (Exception e) {
                        return defVal;
                }
        }
}
