package baseball.dto;

import baseball.service.Converter;
import baseball.service.Generator;

/**
 * 숫자 야구의 상대방인 컴퓨터 정보를 저장할 클래스
 */
public class Computer {
    /**
     * 문자열로 받아올 랜덤으로 생성된 세자리 수
     */
    private String input = "";
    /**
     * 각 자리의 숫자와 위치를 저장 하기 위한 배열. 배열의 index 1~9는 뽑힐 숫자의 목록.<br> 배열의 값은 뽑힌 숫자의 자리<br> 0:사용 되지 않음 1:백의 자리 2:십의 자리 3:일의 자리
     */
    private int[] computerNumberBall;

    /**
     * Computer 생성자
     * <p>
     * 난수 생성, 난수 정보를 담고 있는 배열 초기화
     */
    public Computer() {
        this.input = new Generator().generateNum();
        this.computerNumberBall = Converter.convert(input);
    }

    /**
     * 난수 정보를 저장한 배열 반환
     *
     * @return computerNumberBall
     */
    public int[] getComputerNumberBall() {
        return computerNumberBall;
    }


}
