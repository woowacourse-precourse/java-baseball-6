package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean game = true;
        while(game) {
            List<Integer> computer = new ArrayList<>();

            // 컴퓨터 숫자 생성
            generateComputer(computer);

            while (true) {
                int ballCnt = 0;
                int strikeCnt = 0;

                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> number = new ArrayList<>();

                // 값 입력받기
                String[] values = Console.readLine().split("");

                // 입력받은 문자열에서 숫자로 변환 시 오류 체크
                checkValues(values, number);

                // strike와 ball 계산
                for(int i=0; i<3; ++i) {
                    if(computer.get(i) == number.get(i)) {
                        strikeCnt++;
                    }
                }
                for(int c: number) {
                    if(computer.contains(c)) {
                        ballCnt++;
                    }
                }
                ballCnt -= strikeCnt;

                // 결과 출력
                printCnt(ballCnt, strikeCnt);

                // 게임 종료
                if(strikeCnt == 3) {
                    break;
                }
            }
            
            // 다시하기
            game = replay();
        }
    }

    private static void checkValues(String[] values, List<Integer> number) {
        if(values.length != 3) {
            throw new IllegalArgumentException();
        }
        for(String value : values) {
            try {
                int temp = Integer.parseInt(value);
                if(number.contains(temp)) {
                    throw new IllegalArgumentException();
                }
                number.add(Integer.parseInt(value));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean replay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String reGame = Console.readLine();
        if(reGame.equals("1")) {
            return true;
        } else if(reGame.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void printCnt(int ballCnt, int strikeCnt) {
        if(ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
        } else if(strikeCnt == 0) {
            System.out.println(ballCnt + "볼");
        } else if(ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

    private static void generateComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.println("randomNumber" + computer.size() + " = " + randomNumber);
            }
        }
    }
}
