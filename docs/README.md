## 구현할 기능 목록
게임 시작 → run() ⇒ Controller
- 게임 셋팅 → setGame() ⇒ Controller
  - 컴퓨터 랜덤 숫자 3개 세팅 → setRandomNumber() ⇒ Model
- 게임 실행 → playGame() ⇒ Controller
  - 숫자 야구 게임을 시작합니다.  출력 → printStartMent() ⇒ View
  - 숫자를 입력해주세요 :  출력 → printNumInputMent() ⇒ View
  - 사용자 숫자 입력 받기 → inputUserNumber() ⇒ Model
  - 판단 →checkBallAndStrike(int[] user, int[] computer) ⇒ Model
  - 결과 출력 → printResult() ⇒ View
- 게임 끝 → endGame() ⇒ Controller
  - 끝났다면 3개의 숫자를 모두 맞히셨습니다! 게임 종료 출력 → printEndMent() ⇒ View
- 다시하기 → askRetry() ⇒ Controller
  - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.  출력 → printRetryMent() ⇒ View
  - 입력값 받아서 알맞는 응답 반환
