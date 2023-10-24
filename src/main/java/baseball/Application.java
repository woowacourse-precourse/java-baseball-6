package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballComputer baseballComputer = new BaseballComputer();
        boolean isFinished = false;
        do {
            baseballComputer.selectNumber();
            System.out.println("숫자 야구 게임을 시작합니다");
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (baseballComputer.chkInputError(input)) {
                throw new IllegalArgumentException();
            }
        } while (!isFinished);
    }
}
