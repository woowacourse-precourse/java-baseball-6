package service;

import domain.Baseball;
import repository.BaseRepository;
import repository.BaseRepositoryImpl;
import repository.InputRepository;
import repository.InputRepositoryImpl;

import java.util.List;

import static constant.BaseConst.*;

public class BaseServiceImpl implements BaseService{

    private final InputRepository inputRepository = new InputRepositoryImpl();
    private final BaseRepository baseRepository = new BaseRepositoryImpl();

    /**
     * 게임 기능
     */
    @Override
    public void game() {
        Baseball number = new Baseball(); // 랜덤번호 생성

        boolean flag = false;
        while (!flag) {
            // 사용자로부터 입력을 받고 검증한 값을 String으로 반환
            String myNumberStr = inputRepository.getMyNumber();

            // 검증된 문자열을 List<Integer>로 반환
            List<Integer> myNumber = baseRepository.getMyNumber(myNumberStr);

            // 정답과 사용자가 입력한 값을 비교한 결과를 int[] result에 반환
            int[] result = baseRepository.confirmNumber(number.getBaseNumber(), myNumber);

            // 결과 출력
            baseRepository.printMessage(result);

            // 스트라이크가 3개라면 flag = true 변경
            flag = ( result[STRIKE] == MAX_LENGTH );
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 재시작 여부확인
     * @return 선택결과가 RESTART("1") 이면 true, EXIT("2")이면 false
     */
    @Override
    public boolean isRestart() {
        // 사용자로부터 입력을 받고 검증한 값을 String으로 반환
        String restartSelect = inputRepository.getRestartSelect();

        // 반환된 값은 "1" 또는 "2"인 상태에서 RESTART("1") 와 일치하는지 확인
        return restartSelect.equals(RESTART);
    }


}
