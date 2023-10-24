# `Computer` 클래스를 활용한 `Application` 구현
## `Computer` 클래스 정의
### Public 메서드
1. `public void initializeAnswer()`: 새로운 게임 시작 시, `Answer` 재할당
2. `public boolean makeGuess()`: 사용자 추측 결과 출력, 완벽한 정답인 경우 `true` 반환
### Private 메서드
1. 랜덤 세 자리 `Answer` 생성
   - `Randoms.pickNumberInRange()` 사용
2. 사용자 Guess 입력 및 검증
   - 입력: `Console.readLine()` 사용
   - 검증: 조건문 확인 후 `throw new IllegalArgumentException()`
3. Guess와 Answer 비교
   - 볼, 스트라이크 개수 반환
4. Guess와 Answer 비교 결과 출력
   - `x볼 x스트라이크` 형식 (0이면 출력 안 함)
   - `0볼 0스트라이크`면 `"낫싱"`
   - `3스트라이크`면 `return true`
