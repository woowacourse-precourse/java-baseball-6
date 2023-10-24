## 구현할 기능 목록

1. **게임 시작 메시지 출력**
    - 게임 시작 시 "숫자 야구 게임을 시작합니다." 메시지를 출력.

2. **랜덤한 3자리 숫자 생성**
    - `generateRandomNumbers()` 메서드를 사용하여 1에서 9까지 서로 다른 3개의 숫자로 이루어진 컴퓨터의 숫자를 생성.

3. **사용자 입력 유효성 검사**
    - `isValidInput(String input)` 메서드를 사용하여 사용자의 입력이 3자리이고 서로 다른 숫자인지를 검사.
    - 유효하지 않은 입력일 경우 `IllegalArgumentException` 예외를 발생시켜 프로그램을 종료.

4. **사용자 입력 파싱**
    - `parseUserGuess(String input)` 메서드를 사용하여 사용자의 입력을 3개의 정수로 파싱.

5. **스트라이크 개수 계산**
    - `countStrikes(List<Integer> computer, List<Integer> userGuess)` 메서드를 사용하여 스트라이크 개수를 계산.

6. **볼 개수 계산**
    - `countBalls(List<Integer> computer, List<Integer> userGuess)` 메서드를 사용하여 볼 개수를 계산.

7. **게임 결과 메시지 생성**
    - `formatResult(int strikes, int balls)` 메서드를 사용하여 스트라이크와 볼의 개수에 따라 게임 결과 메시지를 생성.

8. **게임 재시작 또는 종료**
    - 사용자가 1 또는 2를 입력하여 게임을 재시작하거나 종료.

9. **3스트라이크 시 게임 종료**
    - 사용자가 3스트라이크를 달성하면 게임이 종료.

10. **낫싱 메시지 출력**
    - 스트라이크와 볼이 모두 없을 경우 "낫싱" 메시지를 출력.
