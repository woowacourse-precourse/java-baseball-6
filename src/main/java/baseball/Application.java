package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // goal 1 : 컴퓨터, 사용자 값을 다른 클래스로 분리한다
    private ArrayList<Integer> computer; // 컴퓨터의 세자리 수를 저장
    private ArrayList<Integer> user; // 사용자의 세자리 수를 저장
    private boolean isEqual = false; // 사용자와 컴퓨터의 세자리 수의 일치 여부 저장

    /**
     *  0. 게임을 최초 실행하는 메소드
     *    0-1. 게임 시작 문구를 출력한다
     *    1. 게임을 시작 / 재시작 하는 메소드를 실행한다
     */
    void boot() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.startGame();
    }

    /**
     * 1. 게임을 시작 / 재시작 하는 메소드(게임 절차 전반을 실행한다)
     *     1-1. setComputer : 컴퓨터의 세자리 수를 설정한다
     *     1-2. while(사용자가 컴퓨터의 세자리 수를 맞출 때까지)
     *         1-2-1. setUser : 사용자의 세자리 수를 설정한다
     *         1-2-2. judge : 컴퓨터와 사용자의 세자리 수를 비교한다
     *     1-3. exit : 게임 종료 문구를 출력하고 사용자에게 재시작 / 종료 여부를 입력받는다
     */
    void startGame() {
        this.setComputer();
        while (!this.isEqual) {
            this.setUser();
            this.judge();
        }
        this.exit();
    }
    /**
     * 1-1. 컴퓨터의 세자리 수를 설정한다
     */
    void setComputer() {
        this.isEqual = false;
        this.computer = new ArrayList<>();
        while (this.computer.size() < 3) {
            // 중복되지 않은 1-9로 구성되어 있는 세자리 수 computer로 add
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.computer.contains(randomNumber)) {
                this.computer.add(randomNumber);
            }
        }
    }
    /**
     *     @throws IllegalArgumentException
     * 1-2-1. 사용자의 세자리 수를 입력받아 설정한다
     *        입력받은 값이 규칙에 적합한지 검증 후 적합하지 않으면 예외를 발생시킨다
     */
    void setUser() throws IllegalArgumentException {
        this.user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String score = Console.readLine();
        System.out.println("com : " + this.computer);
        // 사용자 입력 값 규칙 적합 여부 검증(1-9까지의 세자리 수로 구성되어 있는지)
        if (!(score.length() == 3 && score.matches("[1-9][1-9][1-9]"))) {
            throw new IllegalArgumentException();
        }
        // 사용자 입력 값이 규칙에 적합 여부 검증(세자리 수 중 중복된 수가 있는지)
        // 적합할 시 user로 세자리 수 add
        for (char c : score.toCharArray()) {
            if (this.user.contains(Character.getNumericValue(c))) {
                throw new IllegalArgumentException();
            } else this.user.add(Character.getNumericValue(c));
        }
    }
    /**
     * 1-2-2. 사용자와 컴퓨터의 세자리 수를 비교한다
     *        비교값에 따른 검증 결과를 출력한다
     *        사용자와 컴퓨터의 세자리 수가 일치 시 isEqual 필드를 false로 바꿔 loop 탈출
     *        // goal 2 : 세자리 수를 검증하는 메소드와 결과를 출력하는 메소드를 분리한다.
     *        // goal 3 : isEqual 필드를 내부로 캡슐화한다
     */
    void judge() {
        // 사용자와 컴퓨터의 세자리 수를 비교한다
        int ball = 0, strike = 0;
        for (int computerIndex = 0; computerIndex < 3; computerIndex++) {
            for (int userIndex = 0; userIndex < 3; userIndex++) {
                if (this.computer.get(computerIndex).equals(this.user.get(userIndex))) {
                    if (computerIndex == userIndex) strike++;
                    else ball++;
                }
            }
        }
        // 사용자와 컴퓨터의 세자리 수의 비교 결과를 출력한다
        if (ball == 0 && strike == 0) System.out.println("낫싱");
        if (ball != 0 && strike != 0) System.out.println(ball + "볼 " + strike + "스트라이크");
        if (ball != 0 && strike == 0) System.out.println(ball + "볼");
        if (ball == 0 && strike != 0) System.out.println(strike + "스트라이크");

        // 세자리 수가 모두 일치할 시 boolean 필드 isequal을 true로 만든다
        if (strike == 3) this.isEqual = true;
    }

    /**
     * @throws IllegalArgumentException
     * 1-3. 게임 종료 문구를 출력하고 게임 시작여부를 재확인한다
     */
    void exit() throws IllegalArgumentException {
        // 게임 종료 문구를 출력하고, 개임 재시작 / 종료 여부를 사용자에게 입력받는다
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        // 1 입력시 게임을 재시작, 2 입력시 종료, 그 외 입력시 예외를 발생시킨다
        if (input.equals("1")) this.startGame();
        else if (input.equals("2")) return;
        else throw new IllegalArgumentException();
        // goal 4 : 메소드 호출 방식을 개선해 스택오버플로우를 방지한다
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.boot();
    }
}
