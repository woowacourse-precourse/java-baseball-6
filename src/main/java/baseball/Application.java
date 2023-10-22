package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //1.컴퓨터 숫자 생성 메소드
        //2.사용자 숫자 입력 받기
        //3.비교 연산 메소드
        //숫자, 자리가 모두 만족 시 스트라이크
        //숫자가 맞지만 자리가 다른 경우 ball
        try {
            System.out.printf("숫자를 입력해주세요 :");
            String input = Console.readLine();//입력 받기
            List<Integer> user = input.chars().mapToObj(e->Character.getNumericValue(e)).toList();

            user.stream().forEach(System.out::println);//출력

            System.out.println("컴퓨터 숫자 추출");
            List<Integer> computer = IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                    .distinct()
                    .limit(3)
                    .boxed()
                    .toList();//서로 다른 숫자 3개가 나올때까지 생성(스트림 연산)
            
            computer.stream().forEach(System.out::print);//출력

            //비교연산 메소드



            //유효성 검사
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
}
