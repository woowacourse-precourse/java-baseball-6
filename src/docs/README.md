# 미션 - 숫자 야구

## 📝 구현 기능 정리

### Model
1. Game
   - createRandomNumber() : Random 값 객체를 생성하는 메서드
   - checkScoreResult() : 입력받은 숫자와 Random 값의 점수를 체크하는 메서드

### View
1. InputView
   - inputNumber() : 숫자를 입력받는 메서드
   - inputRestartChoice() : 재시작 여부를 입력받는 메서드

2. OutPutView
   - printGameStart() : 게임 시작을 알리는 메시지를 출력 메서드
   - printResult() : 게임 한판 당 결과 메시지를 출력하는 메서드
   - printGameOver() : 게임이 종료됐음을 알리는 메시지를 출력하는 메서드

### Controller
1. BaseBallController
   - run() : 게임 전체 진행 메서드
   - checkRestart() : 게임 재시작 여부를 체크하는 메서드

---

진행하면서 추가되는 메서드, 기능들은 작성하면서 구현하기 🚀