package service;

import baseball.domain.Baseballs;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.ComputerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ComputerServiceTest {
    Computer computer = new Computer();
    Player player = new Player();

    @Test
    void 컴퓨터_공_초기화_테스트() {
        // given
        ComputerService computerService = new ComputerService(computer, player);
        // when
        computerService.setup();
        // then
        Baseballs baseballs = computer.getBaseballs();
        Assertions.assertNotNull(baseballs); // baseballs 객체가 null이 아닌지 확인
        assertEquals(3, baseballs.size()); // baseballs 객체가 3개의 볼을 가지는지 확인
    }


    @Test
    void 컴퓨터_vs_플레이어_3볼() {
        // given
        ComputerService computerService = new ComputerService(computer, player);

        // 컴퓨터용 Mock Baseballs 객체 생성
        Baseballs computerMockBaseballs = mock(Baseballs.class);
        // 컴퓨터 mock 객체에 원하는 동작 설정
        when(computerMockBaseballs.getBaseball(0)).thenReturn(1);
        when(computerMockBaseballs.getBaseball(1)).thenReturn(2);
        when(computerMockBaseballs.getBaseball(2)).thenReturn(3);
        // 테스트용 Mock 객체를 컴퓨터에 설정
        computer.setBaseballs(computerMockBaseballs);

        // 플레이어용 Mock Baseballs 객체 생성
        Baseballs playerMockBaseballs = mock(Baseballs.class);
        // 플레이어 mock 객체에 원하는 동작 설정
        when(playerMockBaseballs.getBaseball(0)).thenReturn(3);
        when(playerMockBaseballs.getBaseball(1)).thenReturn(1);
        when(playerMockBaseballs.getBaseball(2)).thenReturn(2);
        // 테스트용 Mock 객체를 플레이어에 설정
        player.setBaseballs(playerMockBaseballs);

        // 플레이어 1 ~ 3 번째 볼이 스트라이크는 아니고 베이스볼 안에 포함되있다는 가정
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(0))).thenReturn(true);
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(1))).thenReturn(true);
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(2))).thenReturn(true);

        // when
        int actualCount = computerService.calculateBallCount();

        // then
        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void 컴퓨터_vs_플레이어_3스트라이크() {
        // given
        ComputerService computerService = new ComputerService(computer, player);

        // Mock Baseballs 객체 생성
        Baseballs mockBaseballs = mock(Baseballs.class);

        // 모의(Mock) 객체에 원하는 동작 설정
        when(mockBaseballs.getBaseball(0)).thenReturn(1);
        when(mockBaseballs.getBaseball(1)).thenReturn(2);
        when(mockBaseballs.getBaseball(2)).thenReturn(3);

        // 테스트용 Mock 객체를 컴퓨터에 설정
        computer.setBaseballs(mockBaseballs);
        // 테스트용 Mock 객체를 플레이어에 설정
        player.setBaseballs(mockBaseballs);

        // when
        int actualCount = computerService.calculateStrikeCount();

        // then
        int expectedCount = 3;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void 컴퓨터_vs_플레이어_2볼_1스트라이크() {
        // given
        ComputerService computerService = new ComputerService(computer, player);

        // 컴퓨터용 Mock Baseballs 객체 생성
        Baseballs computerMockBaseballs = mock(Baseballs.class);
        // 컴퓨터 mock 객체에 원하는 동작 설정
        when(computerMockBaseballs.getBaseball(0)).thenReturn(1);
        when(computerMockBaseballs.getBaseball(1)).thenReturn(2);
        when(computerMockBaseballs.getBaseball(2)).thenReturn(3);

        // 테스트용 Mock 객체를 컴퓨터에 설정
        computer.setBaseballs(computerMockBaseballs);
        // 플레이어용 Mock Baseballs 객체 생성
        Baseballs playerMockBaseballs = mock(Baseballs.class);
        // 플레이어 mock 객체에 원하는 동작 설정
        when(playerMockBaseballs.getBaseball(0)).thenReturn(1);
        when(playerMockBaseballs.getBaseball(1)).thenReturn(3);
        when(playerMockBaseballs.getBaseball(2)).thenReturn(2);

        // 플레이어 1, 2 번째 공은 볼, 0 번째 공은 스트라이크
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(0))).thenReturn(false);
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(1))).thenReturn(true);
        when(computerMockBaseballs.contains(playerMockBaseballs.getBaseball(2))).thenReturn(true);

        // 테스트용 Mock 객체를 컴퓨터에 설정
        computer.setBaseballs(computerMockBaseballs);
        // 테스트용 Mock 객체를 플레이어에 설정
        player.setBaseballs(playerMockBaseballs);

        // when
        int actualBallCount = computerService.calculateBallCount();
        int actualStrikeCount = computerService.calculateStrikeCount();

        // then
        int expectedBallCount = 2;
        int expectedStrikeCount = 1;
        assertEquals(expectedBallCount, actualBallCount);
        assertEquals(expectedStrikeCount, actualStrikeCount);
    }
}
