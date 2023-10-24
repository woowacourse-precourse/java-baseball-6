## ⚾️ 숫자 야구 구현 기능 목록

1. 게임 시작(`startGame`)
    - 게임 시작 메세지 출력

2. 컴퓨터가 1~9 사이 랜덤한 서로 다른 숫자 3개 생성 (`ComputerBalls.getComputerBalls`)

3. 사용자 입력 받기 (`UserBalls`)
    - 조건 : 세 자리 서로 다른 숫자
    - 조건에 맞지 않는 입력이 들어오면 `IllegalArgumentException` 발생 후 프로그램 종료
        - 오류1. 숫자가 아닌 경우(`checkAllNumbers`)
        - 오류2. 3자리가 아닌 경우(`checkLength`)
        - 오류3. 서로 다른 세 숫자가 아닌 경우(`checkDifferentDigits`)
        - 오류4. 1이상 9이하의 숫자가 아닌 경우 (=0이 포함된 경우) (`checkInValidRange`)

4. 숫자 야구 게임 실행(`NumberBaseballGame`)
    - 실제 숫자 야구 게임 로직 (`NumberBaseballRule`)
        - 문자열에서 자리 & 숫자 일치하면 strike++ (`countStrike`)
        - 컴퓨터가 생성한 숫자 Set 이 사용자의 input 을 contain && 자리는 일치하지 않으면 ball++(`countBall`)
    - 게임 결과 출력(`GameMessage`)
        - 결과1. ball == 0 && strike == 0 이면 "낫싱" 출력
        - 결과2. ball == 0 이면 "스트라이크" 의 개수만 출력
        - 결과3. strike == 0 이면 "볼" 의 개수만 출력
        - 결과4. 위의 경우가 아니면 "볼" , "스트라이크" 개수 둘 다 출력
    - 게임 결과를 바탕으로 정답 여부 판단(`playRound`)
        - "3스트라이크" 메세지 출력시 게임 종료 메세지 출력

5. 사용자가 게임을 계속할지 종료할지 결정하는 input 받기(`UserDecision`)
    - input이 1 또는 2 가 아니면 `IllegalArgumentException` 발생 후 게임 종료

6. `Application` 에서 게임 흐름 구현
    - startGame()
    - playGame()
    - `userDecision` 이 1이 아니면 게임 종료

## 🔍 테스트 코드 작성

### InputTest

- `자리수_예외_테스트` : 3자리 아닐 시 에러 발생
- `서로_다른_세자리_에외_테스트` : 서로 다른 3자리가 아닐 시 에러 발생
- `숫자_예외_테스트` : 숫자가 아닌 문자 입력시 예외 테스트

### GameTest

- `스트라이크_테스트` : 3스트라이크 출력 테스트
- `볼_스트라이크_테스트` : 볼 스트라이크 출력 테스트
- `볼_테스트` : 볼 출력 테스트

### ApplicationTest

- `게임종료_후_재시작` : 게임 종료 후 재시작 작동 테스트