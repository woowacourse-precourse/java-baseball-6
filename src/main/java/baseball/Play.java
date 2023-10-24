package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Play { // 숫자 야구 게임 진행 관련 클래스

    private final User user;
    private final Computer com;
    private final Rules rules;

    public Play() {
        this.user = new User();
        this.com = new Computer();
        this.rules = new Rules();
    }

    public void numberBaseBallGame() {  // 숫자 야구 게임 실행
        startGame();
        runGame();
        restartOrFinishGame();
    }

    private void startGame() {  // 게임 시작 단계
        System.out.println("숫자 야구 게임을 시작합니다.");
        com.setCom();
    }

    // countBallsAndStrikes() 내부 코드의 가독성을 높이기 위해 인자 전달용으로 getter 사용
    // 또한 getter인 getUser()와 getCom()은 countBallsAndStrikes() 호출 이외의 용도로는 사용하지 않름
    private void runGame() {    // 게임 진행 단계
        while (true) {
            String input = setInput("숫자를 입력해주세요 : ");
            user.setUser(input);
            rules.countBallsAndStrikes(user.getUser(), com.getCom());
            if (rules.isThreeStrikes()) {
                rules.printIfAnswer();
                break;
            }
            rules.printIfNotAnswer();
            user.clearUser();
        }
    }

    private String setInput(String msg) {   // 입력값을 문자열 형태로 저장
        System.out.print(msg);              // 입력 메시지 출력
        String temp = Console.readLine();
        checkIfInputHasChar(temp);            // 첫번째, 두번째 입력 모두 문자 없는 숫자만 필요
        return temp;
    }

    // 입력값에서 숫자 이외 문자가 포함되면 IllegalArgumentException 발생
    // 두번의 입력(사용자의 숫자, 재시작) 모두 숫자만 필요하므로 공통으로 수행하는 유효성 검사
    private void checkIfInputHasChar(String input) {
        try {
            int temp = Integer.parseInt(input); // 입력값에 문자가 섞이면 Exception 발생
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("This input is not Integer: " + input);
        }
    }

    private void restartOrFinishGame() {    // 게임 재시작 or 종료 단계
        // 게임 재시작을 2회 이상 수행하려면 반복문 필수
        while (true) {
            String input = setInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            int menuNum = checkMenuNumber(input);
            if (menuNum == 1) {
                restartGame();
            } else if (menuNum == 2) {
                finishGame();
                break;
            }
        }
    }

    // 재시작 메뉴 번호 입력 시 1, 2 이외의 숫자가 입력되면 IllegalArgumentException 발생
    private int checkMenuNumber(String input) {
        checkIfInputHasChar(input);
        int menuNum = Integer.parseInt(input);
        if (menuNum < 1 || menuNum > 2) {
            throw new IllegalArgumentException("Invalid Menu Number: " + menuNum);
        }
        return menuNum;
    }

    // 정답 이후 재시작 시 사용자의 숫자 & 상대방의 숫자를 모두 초기화한 후 게임 진행
    // 사용자 입력값을 초기화하지 않으면 재시작 직후 입력값에 대해 잘못된 결과 출력
    private void restartGame() {
        user.clearUser();
        com.clearCom();
        com.setCom();
        runGame();
    }

    private void finishGame() {
        System.out.println("숫자 야구 게임을 종료합니다.");
        user.clearUser();
        com.clearCom();
        Console.close();
    }
}
