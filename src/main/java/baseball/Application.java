package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
        public static void main(String[] args) {
                boolean start = true;
                while (start) {
                        // 랜덤숫자3자리 생성 메소드  =============================================================
                        List<Integer> computer = new ArrayList<>();
                        while (computer.size() < 3) {
                                int randomNumber = Randoms.pickNumberInRange(1, 9);
                                if (!computer.contains(randomNumber)) {
                                        computer.add(randomNumber);
                                }
                        }
                        boolean reTry = true;
                        System.out.println(computer);   //난수확인값 지워야함

                        // 입력값 메소드 =======================================================================
                        System.out.println("생각하는 숫자 한개씩 입력(enter)해주세요.");       //todo 예외처리 (중복포함)
                        List<Integer> user = new ArrayList<>();
                        for (int i = 0; user.size() < 3; i++) {
//                while (user.size() < 3) { // while문 test
                                String userInput = Console.readLine();
                                try {
                                        user.add(Integer.parseInt(userInput));
                                } catch (IllegalArgumentException e) {
                                        System.out.println("IllegalArgumentException"); //예외처리확인
                                        return;
                                }
                        }
                        System.out.println(user); // 입력된 숫자 확인값 지워야함

                        // 판정 메소드 =====================================================================================
                        int ballCount = 0;
                        int strikeCount = 0;
                        for (int i = 0; i < user.size(); i++) {
                                if (computer.contains(user.get(i))) {
                                        if (computer.indexOf(user.get(i)) == i) {
                                                strikeCount++;
                                        } else {
                                                ballCount++;
                                        }
                                }
                        }
                        // 출력 메소드 ===================================================================================
                        if (strikeCount == 3) {
                                System.out.println("3스트라이크!");
                                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                                String choice = Console.readLine();           //todo 재시작or종료 구현
                                if (choice == "1") {
                                        start = true;
                                } else {
                                        return;
                                }
                        } else if (strikeCount + ballCount == 0) {
                                System.out.println("낫싱!");
                        } else {
                                System.out.println(ballCount + "볼, " + strikeCount + "스트라이크");        // 출력
                        }
                        reTry = true;

//                int[] test = new int[0];              // 이형식은 왜 안되는지 찾아보기
//                for (int x = 0; test.length < 3; x++) {
//                        String testInut = Console.readLine();
//                        test.
//                }
                }

        }
}