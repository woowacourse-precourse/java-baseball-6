## 구현할 기능 목록
### 1. playGame
- 게임 실행
  1. 게임 시작 문구 출력
  2. 사용자 숫자 입력 문구 출력
  3. 사용자 입력값에 대한 예외 처리
      - 잘못된 값 입력하는 경우, IllegalArgumentException 발생
  4. 스트라이크/볼 확인
  5. 3 스트라이크가 되면 게임 종료 및 게임 종료 문구 출력
  
### 2. makeRandom
- 상대방(컴퓨터)이 임의의 수 선택
  - 1 ~ 9 중 3개의 숫자 임의로 선택해 List에 추가

### 3. splitNumber
- 입력된 3개 숫자 쪼개서 List에 추가

### 4. checkException
- 사용자의 입력값에 대한 예외 확인
  - 입력 가능한 값
    - 3자리 수
    - 1 ~ 9의 수
    - 서로 다른 수로 구성

### 5. isSameNumber
- 입력 값에 같은 수가 중복되는지 확인
  - Hashmap 이용
  - 입력한 숫자의 각 자릿수에 해당되는 숫자를 key, index를 value로 Hashmap에 추가
  - 이미 해당 key가 존재하면 중복이므로 False 반환
  - 중복 없는 경우 True 반환

### 6. countStrikeAndBall
- 스트라이크, 볼 확인 및 개수 계산
  - strike, ball을 key, 개수를 value로 Hashmap 생성
  - 같은 수, 다른 자리인 경우 ball에 개수 추가
    - 자리에 관계 없이 해당 숫자가 computer 숫자에 있는 경우 ball에 개수 추가
    - 해당 숫자가 computer 숫자의 수와 자리도 같은 경우 strike이므로 ball에서 개수 차감
  - 같은 수, 같은 자리인 경우 strike에 개수 추가

### 7. printResult
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 출력
- 하나도 없는 경우 "낫싱" 출력

### 8. replay
- 게임이 끝난 경우
  - 게임 재시작/종료 선택 문구 출력
    - 입력 가능한 값
      - 1 : 재시작
      - 2 : 종료
    - 입력 가능한 값 아닌 경우 예외 처리 (IllegalArgumentException)