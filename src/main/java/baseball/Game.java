package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player = new Player();//사용자 객체
    private Computer computer = new Computer();//컴퓨터 객체

    public void start() {
        //게임 시작 멘트 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        //컴퓨터 객체에게 난수 생성
        computer.makeNumber();
        // <-- 정답 맞출때까지 반복 -->
        while (true) {
            String input = player.getInput();//사용자 객체에게 입력 받기
            if (checkGameInput(input)) {//입력 검증 -> checkInput()
                String result = computer.makeResult(
                        changeInputStringToNumberList(input));//문제 없으면 컴퓨터 객체에게 입력값에 대해서 결과값 검증
                System.out.println(result);//결과값 출력
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    end();//만약 결과값 맞다 -> end 호출
                    break;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public Boolean checkGameInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            try {
                Integer.parseInt(input.substring(i, i + 1));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public Boolean checkRestartInput(String input) {
        if (input.length() != 1) {
            return false;
        }
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Integer> changeInputStringToNumberList(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            result.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return result;
    }

    public Integer changeInputStringToNumber(String input) {
        return Integer.parseInt(input);
    }

    public void end() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");//재시작할지 여부 묻기
        String input = player.getInput();//사용자 객체에게 입력 받기
        if (checkRestartInput(input)) {//입력 검증 -> checkInput()
            int numInput = changeInputStringToNumber(input);//1 받았으면 start() 재호출, 2 받았으면 그대로 종료
            if (numInput == 1) {
                start();
            } else if (numInput == 2) {
                return;//게임 종료
            }
        } else {
            throw new IllegalArgumentException();
        }

    }
}
