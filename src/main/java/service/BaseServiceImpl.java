package service;

import domain.Baseball;
import repository.BaseRepository;
import repository.InputRepository;
import repository.InputRepositoryImpl;

import java.util.List;

import static constant.BaseConst.*;

public class BaseServiceImpl implements BaseService{

    private final InputRepository inputRepository = new InputRepositoryImpl();
    private final BaseRepository baseRepository = new BaseRepository();

    /**
     * 게임 기능
     */
    @Override
    public void game() {
        Baseball number = new Baseball(); // 랜덤번호 생성

        boolean flag = false;
        while (!flag) {
            String myNumberStr = inputRepository.getMyNumber();
            List<Integer> myNumber = baseRepository.getMyNumber(myNumberStr);

            int[] result = baseRepository.confirmNumber(number.getBaseNumber(), myNumber);

            baseRepository.printMessage(result);
            flag = result[STRIKE] == COMPLETE;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 재시작 여부확인
     * @return 선택결과가 RESTART(1) 이면 true, EXIT(2)이면 false
     */
    @Override
    public boolean isRestart() {
        String restartSelect = inputRepository.getRestartSelect();
        return Integer.parseInt(restartSelect) == RESTART;
    }


}
