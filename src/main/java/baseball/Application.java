package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    // TODO 코드 깔끔하게 만들기 (가독성을 높이고 좀 더 효율적으로)
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ballCount = 0;
        int strikeCount = 0;
        boolean isRun = true;

        // 랜덤 숫자 생성
        ArrayList<Integer> computer = createRandomNumList(new ArrayList<>());

        while (isRun) {
            // 유저가 입력한 숫자를 조회
            String[] userStr = Console.readLine().trim().split("");

            //TODO 유저가 잘못된 값을 입력했을 때, 예외처리 제작 (IllegalArgumentException 발생)

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
                    isRun = false;
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

    // 랜덤으로 3개의 숫자를 생성해주는 로직.
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
