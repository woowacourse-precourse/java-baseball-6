구현 목록 
0.Application 실행

    1.BaseballGame() = 야구게임시작 첫 단계
        1.1ComputerPoint() computerpoint값 반환 (임의의 중복되지 않은 랜덤한숫2ㅏ (1~9)
        1.2PlayerPoint() playerPoint 값 반환 ()
            1.2.1 예외 검사 (3자리가아닐경우, 중복값이 있을경우, 0이하의수가있을경우, 문자가 아닐경우, )
        1.3getTotalFromPoint() 점수값 반환
            1.3.1 printPoint() 합계가 0일경우 "낫싱"
                1.3.1.1 chcekBallAndStrike() 볼과 스트라이크 계산
                    1.3.1.1.1 zeroBallOrStrike() 볼, 스트라이크 경우가 하나만 있을경우
        1.4 getCheckStrikeFromPlay() 스트라이크 3일경우 1.5실행 아닐경우 다시 1.2로 리턴
        1.5 getEndGameFromInputVal() 게임 재시작및 종료 반환/ 게임 재시작시1로 리턴 아닐경우 종료
            1.5.1 예외 검사(1, 2가아닌 다른숫자일경우)
