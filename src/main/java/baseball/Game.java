package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Computer computer;
    public void run(){
        while(true){
            computer = new Computer();
            int n = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");
            while(true){
                // 숫자 입력
                System.out.print("숫자를 입력해주세요 : ");
                try{
                    n = getUserInputAsInt(3);
                }
                catch (IllegalArgumentException e){
                    System.out.println("올바른 숫자 형식이 아닙니다.");
                    return;
                }

                // 정답 비교
                String result = computer.ansCheck(n);
                System.out.println(result);

                // 게임 종료 여부
                if(checkGameEnd(result)){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            } // 게임 한 판 종료

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            // 재시작 여부
            int userMode;
            try {
                userMode = getUserInputAsInt(1);
            }
            catch (IllegalArgumentException e){
                System.out.println("올바른 숫자 형식이 아닙니다.");
                return;
            }
            switch (userMode){
                case 1:
                    break;
                case 2:
                    return;
            }
        }
    }

    /*
        입력을 받고 Int형으로 변환 값 리턴
     */
    public int getUserInputAsInt(int limit_Length){
        String userInput = Console.readLine();

        if (userInput.length() != limit_Length) {
            throw new IllegalArgumentException(limit_Length+ "자리의 수를 입력해야 합니다.");
        }
        try {
            int parsedValue = Integer.parseInt(userInput);
            return parsedValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자 형식이 아닙니다.");
        }
    }

    /*
        - 게임 종료 여부 확인
        스트라이크이면 true 리턴, 그렇지 않으면 flase 리턴
     */
    public boolean checkGameEnd (String result){
        if(result.equals("3스트라이크")){
            return true;
        }
        else{
            return  false;
        }
    }

}
