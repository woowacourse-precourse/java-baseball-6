package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {

    // TODO 예외처리 만들기 (잘못된 입력 처리)
    // TODO 코드 깔끔하게 만들기 (가독성을 높이고 좀 더 효율적으로)
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ballCount = 0;
        int strikeCount = 0;
        boolean isRun = true;

        List<Integer> computer = createRandomNumList();

        while (isRun) {
            // 유저가 입력한 3개의 숫자를 조회
            String[] userStr = Console.readLine().trim().split("");
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

            // 조회 결과값 출력
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            }
            if (ballCount != 0) {
                System.out.println(ballCount + "볼 ");
            }
            if (strikeCount != 0) {
                System.out.println(strikeCount + "스트라이크");

                // 숫자 맞추기 성공시
                if (strikeCount == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                    // 게임 종료 이후 재시작 질문
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    if (Console.readLine().trim().equals("1")) {
                        computer = createRandomNumList();
                        System.out.print("숫자를 입력해주세요 : ");
                    } else {
                        break;
                    }
                }
            }

            ballCount = 0;
            strikeCount = 0;

        }
    }

    // 랜덤으로 3개의 숫자를 생성해주는 로직.
    public static List<Integer> createRandomNumList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


}
