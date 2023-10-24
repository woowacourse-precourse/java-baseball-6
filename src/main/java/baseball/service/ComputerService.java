package baseball.service;

import baseball.domain.Computer;


public class ComputerService {

    private String computerNumber;
    private final UserService userService; // UserService를 멤버 변수로 변경

    public ComputerService(UserService userService) {
        this.userService = userService; // UserService를 생성자에서 주입받음
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameInitialize() {
        Computer computer = new Computer();
        computerNumber = computer.getNumber();
    }

    public boolean gameOn(String userNumber) {
        boolean gameEnd = gameScoreCalculate(userNumber);
        return gameEnd;
    }

    public boolean gameEnd(int userNumber) {
        return userNumber != 1;
    }

    private boolean gameScoreCalculate(String userNumber) {
        int strikes = 0;
        int balls = 0;

        char[] computerDigits = computerNumber.toCharArray();
        char[] userDigits = userNumber.toCharArray();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userDigits[i] == computerDigits[j]) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();

        if (strikes == 0 && balls == 0) result.append("낫싱");
        if (balls > 0) result.append(balls).append("볼");
        if (strikes > 0) {
            if (balls > 0) result.append(" ");
            result.append(strikes).append("스트라이크");
        }

        System.out.println(result.toString());

        return strikes == 3;
    }

}
