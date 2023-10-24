package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
        public static void main(String[] args) { StartGame();}
                public static void StartGame(){
                        System.out.println("숫자야구 게임을 시작 합니다.");
                        List <String> computer = ComputerInput();
                        UserInput(computer);
        }
                // 랜덤숫자3자리 생성 메소드  =============================================================
        public static List <String> ComputerInput(){
                List<String> computer = new ArrayList<>();
                while (computer.size() < 3) {
                        String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
                        if (!computer.contains(randomNumber)) {
                                computer.add(randomNumber);
                        }
                }
                System.out.println("computer = " + computer);   //todo 난수확인값 지워야함
                return computer;
        }
        // 입력값 메소드 =======================================================================
        public static void UserInput(List<String> computer) {                   //todo 예외처리 (중복포함)
                List<String> user = new ArrayList<>();
                System.out.println("중복이 되지 않는 세 자리의 숫자를 입력해 주세요.");
                String userInput = Console.readLine();
                Collections.addAll(user, userInput.split(""));
                System.out.println("user = " + user);           //todo user 확인값 제출전 제거
                for (String str : user) {
                        if (CheckValueInput(str, 0) == 0 || user.size() != 3) {
                                try {
                                        System.out.println("올바른 세자리 숫자를 입력이 되지 않았습니다.");
                                        throw new IllegalArgumentException();
                                } catch (IllegalArgumentException e) {
                                        return;
                                }
                        }
                }
                        // 판정 메소드 =====================================================================================
                        int ballCount = 0;
                        int strikeCount = 0;
                        for (int j = 0; j <user.size(); j++) {
                                if (computer.contains(user.get(j))) {
                                        if (computer.indexOf(user.get(j)) == j) {
                                                strikeCount++;
                                        } else {
                                                ballCount++;
                                        }
                                }
                        }
                        System.out.println("strikeCount = " + strikeCount);           //todo strikeCount 확인값 제출전 제거
                        System.out.println("ballCount = " + ballCount);           //todo ballCount 확인값 제출전 제거
                        // 출력 메소드 ===================================================================================
                        if (strikeCount == 3) {
                                System.out.println("3스트라이크!");
                                System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                                String choice = Console.readLine();           //todo 재시작or종료 구현
                                if (choice.equals("1") ) {
                                        System.out.println("게임을 재시작 합니다.\n");
                                        StartGame();
                                } else if (choice.equals("2")) {
                                        System.out.println("게임을 종료 합니다.");
                                        return;             // todo 임시
                                } else {
                                        try {
                                                throw new IllegalArgumentException();
                                        } catch (Exception e) {
                                                System.out.println("e = " + e);
                                                return;
                                        }
                                }
                        } else if (strikeCount + ballCount == 0) {
                                System.out.println("낫싱!");
                                UserInput(computer);
                        } else {
                                System.out.println(ballCount + "볼, " + strikeCount + "스트라이크");        // 출력
                                UserInput(computer);
                        }

        }

        public static int CheckValueInput(String value, int defVal) {
                try {
                        return Integer.parseInt(value);
                } catch (IllegalArgumentException e) {
                        return defVal;
                }
        }
}
