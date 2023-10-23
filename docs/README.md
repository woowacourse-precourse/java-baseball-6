### Computer 기능 구현
  - [x] 게임 시작 시 서로 다른 세 자리 수를 만든다. (generateTargetNumber)
  - [x] 사용자가 입력한 값을 받아 결과를 확인 (checkInputNumber)
  - [x] 스트라이크 여부를 확인하는 함 (isStrike)
  - [x] 게임을 시작하는 메서드 구현 (gameStart)
  - [x] Computer 실행시키는 메서드 구현 (run)

<br>

### view 기능 구현
  - [x] InputView (입력 뷰)
    - [x] 유저가 입력하는 세 개의 숫자를 받는 메서드 구현 (readUserNumber)
      - [x] 숫자만 입력했는지 유효성 검사
      - [x] 3개의 숫자인지 유효성 검사
      - [x] 1부터 9까지의 숫자를 입력했는지 유효성 검사
      - [x] 중복된 숫자를 입력했는지 유효성 검사
    - [x] 게임 종료 시 입력하는 커멘드를 입력 받는 메서드 구현 (readGameEndCommand)
      - [x] 1 또는 2만 입력했는지 유효성 검사


  - [x] OutputView (출력 뷰)
    - [x] 게임 시작 메시지 출력 (printGameStartMessage)
    - [x] 숫자 입력 메시지 출력 (printInputNumberMessage)
    - [x] 매번 입력에 대한 결과 메시지 출력 (printResultMessage)
    - [x] 게임 종료 메시지 출력 (printGameEndMessage)