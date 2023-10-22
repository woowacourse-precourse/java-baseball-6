package baseball.common.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommonNumberServiceTest {

    private CommonNumberService commonNumberService;

    //@BeforeAll 어노테이션이 붙은 메소드는 반드시 정적 클래스이어야 한다
    //혹은 테스크 클래스의 생명 주기를 인스턴스 생명주기와 맞춰주면 된다
    @BeforeAll
    public void init(){
        commonNumberService = new CommonNumberService();
    }



    @Test
    @DisplayName("랜덤 3자리 숫자 생성 테스트")
    public void 서로_다른_3자리_숫자_생성(){

        commonNumberService.createRandomNumber();
        ArrayList<Integer> computer = commonNumberService.getComputer();
        assertEquals(computer.size(),3);        //3자리 숫자

        HashSet<Integer> set = new HashSet<>(computer);
        assertEquals(set.size(),3);     //서로 다른 숫자
    }

}