package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임을 계속 진행할 것인지 판단하는 숫자
        // 0: inPlay | 1 : play | 2 : stop
        int chkPlay = 0;

        // 게임 시작
        while(chkPlay != 2) {
            // 1. 컴퓨터가 가지고 있을 랜덤한 수 생성
            int[] listOfRandomNumAndPos = selectRandomInteger();

            // 게임 진행
            while(true) {
                // 출력할 ball과 strike 배열 선언
                // arr[0] = ball | arr[0] = strike
                int[] ballAndStrike;

                // 2. 입력 및 유효성 검사
                System.out.print("숫자를 입력해주세요 : ");
                char[] userInput = getUserInput();

                // 3. 스트라이크와 볼 판정
                ballAndStrike = chkUserInput(listOfRandomNumAndPos, userInput);

                // 4. 출력
                printUserResult(ballAndStrike[0], ballAndStrike[1]);

                // 5. 정답 여부 확인 후 반복 여부 결정
                chkPlay = chkFinishAndRestart(ballAndStrike[1]);
                if(chkPlay != 0) break;
            }
        }
    }

    public static int[] selectRandomInteger() {
        // 컴퓨터가 가지고 있을 랜덤한 수를 담을 list 생성
        int[] listOfRandomNumPos = new int[10];

        // 배열을 -1으로 초기화
        for(int i = 1; i <= 9; i++) {
            listOfRandomNumPos[i] = -1;
        }

        // 서로 다른 임의의 수 3개를 랜덤으로 뽑음
        for(int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(listOfRandomNumPos[randomNumber] == -1) {
                listOfRandomNumPos[randomNumber] = i;
            } else i--;
        }

        return listOfRandomNumPos;
    }

    public static char[] getUserInput() {
        // 유저의 입력을 받음
        String userInput = Console.readLine();
        char[] chars = userInput.toCharArray();

        // 입력 조건을 확인
        boolean isValidInput = userInput.matches("[1-9]{3}");
        if(!isValidInput || (chars[0] == chars[1] || chars[1] == chars[2] || chars[0] == chars[2])) {
            throw new IllegalArgumentException("[입력오류] : <숫자 예측>은 서로 다른 3자리 숫자이어야 합니다");
        }

        return chars;
    }

    public static int[] chkUserInput(int[] listOfRandomNumAndPos, char[] userInput) {
        // loop를 돌면서 스트라이크 및 볼 판정
        int[] resultUserInput = new int[2];
        int ball = 0;
        int strike = 0;

        for(int idx = 0; idx < 3; idx++) {
            int nowIndexNum = Character.getNumericValue(userInput[idx]);

            if(listOfRandomNumAndPos[nowIndexNum] != -1) {
                if(listOfRandomNumAndPos[nowIndexNum] == idx) strike++;
                else ball++;
            }
        }

        resultUserInput[0] = ball;
        resultUserInput[1] = strike;

        return resultUserInput;
    }

    public static void printUserResult(int ball, int strike) {
        // 낫싱일 때와 낫싱이 아닐 때로 나누어 출력
        if(ball == 0 && strike == 0) {
            System.out.print("낫싱");
        } else {
            if(ball != 0) System.out.print(ball + "볼 ");
            if(strike != 0) System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public static int chkFinishAndRestart(int strikeNum) {
        // 정답을 맞추면 재시작 여부를 사용자에게 물어봄
        int chkNextStep = 0;

        if(strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String userSelect = Console.readLine();

            if(userSelect.equals("1")) {
                chkNextStep = 1;
            } else if(userSelect.equals("2")) {
                chkNextStep = 2;
            } else {
                throw new IllegalArgumentException("[입력오류] : <시작/종료 선택>은 1 혹은 2 이어야 합니다");
            }
        }

        return chkNextStep;
    }
}
