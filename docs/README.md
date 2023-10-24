# java-baseball-6

## 구현할 기능 목록
    1. ControlGame()
        -startGame  : 게임을 시작하고 필요한 기능들을 호출하는 메서드
        -exitGame   : 게임을 종료하는 메서드
    2. Player
        -makeUserInput      : 사용자의 숫자 입력을 받아 예외 처리를 하고 저장
        -getPlayerNumber    : 입력받은 숫자를 반환
    3. Computer
        -makeRandomNumber   : 무작위 숫자를 생성
        -getComputerNumber  : 생성된 무작위 숫자를 반환
    4. VerifyNumber
        -countBallnStrike   : 사용자의 숫자와 무작위 숫자를 받아 볼, 스트라이크 여부 검증
        -printBallnStrike   : 검증된 볼, 스트라이크 카운트 출력
        -checkStrikeCount   : 스트라이크 카운트가 3인 경우 안내 출력