package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    private static int ballCount;

    // TODO: 베이스볼 게임 클래스를 생성해, Application 클래스와 분리
    // TODO: 변수명, 함수명 변경 (직관적으로)
    // TODO: if문, 로직들 함수화

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ballCount = 0;
        int strikeCount = 0;
        boolean isRun = true;

        // 랜덤 숫자 생성
        ArrayList<Integer> computer = createRandomNumList(new ArrayList<>());

        while (isRun) {
            String inputStr = Console.readLine().trim();

            //잘못된 값 입력
            if (inputStr == null || !inputStr.matches("[1-9]+") || inputStr.length() != 3) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 1~9로 이뤄진 중복되지 않는 3자리의 숫자를 입력해주세요.");
            }

            // 유저가 입력한 숫자를 배열화
            String[] userStr = inputStr.split("");

            //중복된 숫자 입력
            if (userStr[0].equals(userStr[1]) || userStr[0].equals(userStr[2]) || userStr[1].equals(userStr[2])) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 1~9로 이뤄진 중복되지 않는 3자리의 숫자를 입력해주세요.");
            }

            // 숫자 정답여부 확인
            for (int i = 0; i < 3; i++) {
                int nowNum = Integer.parseInt(userStr[i]);
                if (computer.contains(nowNum)) {
                    if (computer.get(i) == nowNum) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }

            // 맞춘 숫자의 종류와 개수 출력
            if (strikeCount == 3) {
                System.out.println(strikeCount + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // 게임 종료 이후 재시작 질문
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 재시작을 선택했다면
                if (Console.readLine().trim().equals("1")) {
                    computer.clear();
                    computer = createRandomNumList(computer);
                    System.out.print("숫자를 입력해주세요 : ");

                    // 종료를 선택했다면
                } else {
                    isRun = false; // 종료
                }
            } else if (ballCount != 0 && strikeCount != 0) {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            } else if (ballCount != 0) {
                System.out.println(ballCount + "볼 ");
            } else if (strikeCount != 0) {
                System.out.println(strikeCount + "스트라이크");
            } else {
                System.out.println("낫싱");
            }

            ballCount = 0;
            strikeCount = 0;

        }
    }

    public static ArrayList<Integer> createRandomNumList(ArrayList<Integer> numList) {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
        return numList;
    }

}
