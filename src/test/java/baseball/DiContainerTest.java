package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiContainerTest {

    @DisplayName("DiContainer 를 활용한 객체 생성은 null 값이 아닐 것이다.")
    @Test
    void diContainerNullTest() {

        //given
        DiContainer diContainer = new DiContainer();

        //when
        ComputerController computerController = diContainer.ComputerController();

        //then
        assertThat(computerController).isNotNull();
    }

    @DisplayName("DiContainer 로 생성한 객체는 new 예약어로 생성한 객체와 동일한 클래스의 인스턴스다.")
    @Test
    void computerControllerCreatTest() {

        //given
        DiContainer diContainer = new DiContainer();

        //when
        ComputerController computerControllerForMakeDI = diContainer.ComputerController();
        ComputerController computerControllerForNew = new ComputerController(new ComputerView(),
                new ComputerValidation(new Computer().makeAnswerList()));

        //then
        assertThat(computerControllerForMakeDI).isInstanceOf(computerControllerForNew.getClass());
        assertThat(computerControllerForNew).isInstanceOf(computerControllerForMakeDI.getClass());
    }
}