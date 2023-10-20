package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static String answer="";
    private static int ball=0;// 같은 숫자가 있기만 해도 ++
    private static int strike=0;// 같은 숫자가 있고, 위치도 같으면 ++
    public static void main(String[] args) {
        // TODO: 2023-10-20 오후 3:27 게임 시작 - 랜덤 세자리수 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: 2023-10-20 오후 3:22 입력 - 세자리 수 입력받기
        throwBalls();
    }

    private static void printResult() {
        ResultType type = ResultType.getType(ball, strike);
        String message = type.getMessage(ball, strike);
        System.out.println(message);
    }

    private static void makeRandomAnswer() {
        for (int i = 0; i < 3; i++)
            answer += String.valueOf(Randoms.pickNumberInRange(1, 9));
    }

    private static void throwBalls(){
        makeRandomAnswer();

        while (strike!=3){
            System.out.print("숫자를 입력해주세요 : ");
            String inputLine = Console.readLine();
            if(inputLine.length()!=3)
                throw new IllegalArgumentException();
            strike=0;
            ball=0;

            // TODO: 2023-10-20 오후 3:42 입력값과 비교 - 정답이 나올 때까지 반복 비교
            calcResult(inputLine);

            // TODO: 2023-10-20 오후 4:10 입력값과 정답 비교 후 결과 출력
            printResult();
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choiceContinue = Integer.parseInt(Console.readLine());
        if(choiceContinue ==1){
            strike=0;
            ball=0;
            answer="";
            throwBalls();
        } else if (choiceContinue==2) {
            return;
        } else
            throw new IllegalArgumentException();
    }

    private static void calcResult(String inputLine) {
        for (int i = 0; i < inputLine.length(); i++) {
            String eachChar = String.valueOf(inputLine.charAt(i));
            if(!answer.contains(eachChar))// 같은 숫자가 없으면
                continue;
            if (String.valueOf(answer.charAt(i)).compareTo(eachChar)==0){// 같은 위치에 존재
                strike++;
                continue;
            }
            ball++;
        }
    }
    enum ResultType {
        BOTH_NON_ZERO {
            @Override
            public String getMessage(int ball, int strike) {
                return ball + "볼 " + strike + "스트라이크";
            }
        },
        ONLY_BALL {
            @Override
            public String getMessage(int ball, int strike) {
                return ball + "볼";
            }
        },
        ONLY_STRIKE {
            @Override
            public String getMessage(int ball, int strike) {
                return strike + "스트라이크";
            }
        },
        NOTHING {
            @Override
            public String getMessage(int ball, int strike) {
                return "낫싱";
            }
        };

        public abstract String getMessage(int ball, int strike);

        public static ResultType getType(int ball, int strike) {
            if (ball != 0 && strike != 0) return BOTH_NON_ZERO;
            if (strike == 0 && ball != 0) return ONLY_BALL;
            if (strike != 0 && ball == 0) return ONLY_STRIKE;
            return NOTHING;
        }
    }
}
