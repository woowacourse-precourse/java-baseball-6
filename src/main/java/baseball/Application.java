package baseball;

import java.util.List;


public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현

        //시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean retry = true; //초기값 true

        //컴퓨터 랜덤 3자리 수 생성
        RandomNumber randomNumber = new RandomNumber();
        //사용자 3자리 수 입력
        InputNum inputNum = new InputNum();
        //정답 3자리와 입력 3자리 비교
        Compare compare = new Compare();
        //게임 종료 후 종료 or 재시도 결정
        EndOrRetry endOrRetry = new EndOrRetry();


        while (retry == true) {
            List<Integer> randNum = randomNumber.RandomNumber();
            String result = ""; //초기값 설정

            //게임(한 판)이 진행되는 경우
            while (!"3스트라이크".equals(result)) {
                result = compare.Compare(randNum, inputNum.getInputNum());
                System.out.println(result);
              }
            //1이나 2로 재시작/종료 결정
            retry = endOrRetry.endOrRetry();
        }
    }
}
