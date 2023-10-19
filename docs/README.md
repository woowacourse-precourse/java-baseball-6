## 기능 목록

- InputView
  - [x] 사용자가 예상하는 숫자를 입력한다.
  - [ ] 게임을 재시작 여부를 입력한다.

- RandomNumberCreateUtil
  - [x] 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다.

- CheckBallAndStrike
  - [x] Ball과 Strike의 상태를 변경한다.

- Player
  - [x] 예상된 숫자를 저장한다.
  - [x] 입력한 숫자의 중복 검사와 개수를 확인한다.

- OutputView
  - [ ] 게임 진행 메시지들을 출력한다.
  - [x] 사용자 입력에 대한 볼/스트라이크 결과를 출력한다.
<hr>

- BaseballMessage
  - [x] 숫자야구 용어 상수
- BaseballRole
  - [x] 숫자야구 규칙 상수
- ErrorMessage
  - [x] 에러 메시지 상수
- ProgressMessage
  - [x] 게임 진행 메시지 상수


## 에러 처리
- InputValidator
  - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을
    발생시킨 후 애플리케이션은 종료되어야 한다.
  - [x] 예상 숫자 입력 시 문자를 입력한다면 에러가 발생한다.
  - [ ] 게임 재시작 여부 입력 시 1 혹은 2를 입력하지 않으면 에러가 발생한다. 