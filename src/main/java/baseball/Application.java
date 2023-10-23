package baseball;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int[] numbers = new int[3];
        boolean check = true;
        while(check){ // check가 false가 될때까지 게임을 계속 진행
            System.out.println("숫자 야구 게임을 시작합니다.");
            Random random = new Random();
            numbers = random.createNumber();
            while(true) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = readLine();
                CheckFunction checkFunction = new CheckFunction(input);
                if (checkFunction.isValid()) {
                    // User가 입력한 모든 숫자가 다른 경우 게임을 진행
                    int [] arr = new int[3];
                    arr[0] = input.charAt(0) - '0';
                    arr[1] = input.charAt(1) - '0';
                    arr[2] = input.charAt(2) - '0';
                    int strike = 0, ball = 0;
                    for(int i = 0; i < 3; i++){
                        if(arr[i] == numbers[i])
                            strike++; // 스트라이크 계산
                        else{
                            for(int j = 0; j < 3; j++){
                                if(i == j); // 위에서 strike를 걸러내었으므로, 거르기 위한 코드
                                else if(arr[i] == numbers[j])
                                    ball++; // 볼 계산
                            }
                        }
                    }
                    Result result = new Result(strike, ball);
                    if(result.isReGame()) { // 결과값 출력하면서 만약 정답을 맞출 경우 코드 내부를 실행
                        input = readLine();
                        if(input.charAt(0) - '0' == 2){
                            check = false;
                            break; // 유저가 게임을 종료하기로 선언하였으므로 while문을 종료
                        }
                        else
                            break; // 유저가 게임을 계속 하기로 선언하였으므로 다시 처음으로 돌아감.
                    }
                }
                else { // User가 입력한 숫자 중 같은 숫자가 있거나, 숫자가 아닌 경우가 있으므로 에러 출력
                    throw new IllegalArgumentException("잘못 입력된 값입니다.");
                }
            }
        }
    }
}
