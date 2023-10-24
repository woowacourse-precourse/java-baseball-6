package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 1~9 사이 각 자리수가 중복되지 않는 3자리 수 생성 메소드
    public List<Integer> getNumber() {
        // 컴퓨터 채번값 담을 리스트
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            // 1~9 사이 랜덤 번호 채번
            int randomNum = Randoms.pickNumberInRange(1, 9);
            // 동일한 번호가 아닐때만 추가
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
        return computer;
    }

    // 사용자 입력값과 숫자 비교 후 결과 출력하는 메소드
    public void baseballGame() {
        // 컴퓨터 채번 메소드 호출
        List<Integer> computerNum = getNumber();
        // 테스트용 - 컴퓨터가 채번한 번호
//        System.out.println(computerNum);
        boolean isStart = true;
        // 종료할때까지 반복
        while (isStart) {
            System.out.print("숫자를 입력해주세요 : ");
            // 사용자 입력값 받기
            String inputNum = Console.readLine();
            // 사용자 입력값 담을 리스트
            List<Integer> userNum = new ArrayList<>();

            // 사용자 입력값 인트 전환하기위해 try catch
            try {
                // 3자리수가 넘어갈경우 Exception처리
                if (inputNum.length() != 3) {
                    throw new IllegalArgumentException();
                } else {
                    // 사용자 입력값 인트로 전환
                    int i = Integer.parseInt(inputNum);
                    // 각 수의 자리 판별용 - 100의 자리부터 카운트
                    int count = 1000;
                    while (userNum.size() < 3) {
                        // 중복 숫자 있을경우 Exception처리
                        if (!userNum.contains((i % count) / (count / 10))) {
                            userNum.add((i % count) / (count / 10));
                            count /= 10;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            } catch (Exception e) {
                // 숫자가 아닌 문자 입력했을경우 Exception처리
                throw new IllegalArgumentException();
            }
            // 테스트용 - 인트전환, 리스트에 담은 사용자 입력값
//            System.out.println(userNum);

            // 채번, 입력값 비교 후 출력
            int ball = 0;
            int strike = 0;
            for (int i = 0; i < computerNum.size(); i++) {
                for (int j = 0; j < userNum.size(); j++) {
                    if (computerNum.get(i) == userNum.get(j)) {
                        // 자리와 숫자가 같을때 strike
                        if (i == j) {
                            strike++;
                        } else {
                            // 숫자만 같을때 ball
                            ball++;
                        }
                    }
                }
            }

            // 결과 출력
            if (ball > 0) {
                if (strike > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼");
                }
            } else if (strike == 3) {
                isStart = false;
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String answer = Console.readLine();
                try {
                    int answerInt = Integer.parseInt(answer);
                    // 새로운 게임 시작
                    if (answerInt == 1) {
                        baseballGame();
                    }
                    // 게임 종료
                    else if (answerInt == 2) {
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (Exception e) {
                    throw new IllegalArgumentException();
                }
            } else if (strike > 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }


    public static void main(String[] args) {
        Application application = new Application();
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 야구게임 시작
        application.baseballGame();
    }
}
