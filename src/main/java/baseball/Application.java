package baseball;

import baseball.dto.Computer;
import baseball.dto.Result;
import baseball.service.Converter;
import baseball.service.Generator;
import baseball.service.Validate;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Computer computer = new Computer();
            computer.setInput(new Generator().generateNum());
            computer.setComputerNumberBall(Converter.convert(computer.getInput()));

            Result result = new Result();
            while (result.isCondition()) {
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();
                try {
                    new Validate().validate(num);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    Console.close();
                    return;
                }

            }
        }
    }
}
