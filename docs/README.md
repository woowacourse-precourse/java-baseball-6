# 프로그램 흐름

### ✅ 게임 시작

- [x]  1~9 범위 내에서 랜덤으로 숫자 3개를 뽑는다.

### ✅ 사용자의 입력

- [x]  3자리 수를 입력 받는다.
    - [x]  비정상적인 입력은  `IllegalArgumentException`을 발생시킨다.
        - 중복 숫자가 입력되는 경우
        - 1~9 숫자가 아닌 경우
        - 길이가 3이 아닌 경우

### ✅ 힌트

- [x]  3스트라이크가 나올 때까지 반복한다.
    - [x]  정답과 사용자의 입력을 비교하여 ball, strike 변수에 기입한다.
    - [x]  4가지 경우(낫싱, 볼, 스트라이크, 볼+스트라이크)로 나누어 힌트를 출력한다.
- [x]  반복이 끝나면 게임을 종료한다.

### ✅ 게임 종료

- [x]  새로 시작하려면 1, 종료하려면 2를 입력받는다.
    - [x]  비정상적인 입력은  `IllegalArgumentException`을 발생시킨다.
    - [x]  1을 입력받으면 게임을 재시작한다.
    - [x]  2를 입력받으면 종료한다.

---

# 메소드 주요 기능 설명

## 1. Game

### startGame()

- 랜덤으로 숫자 3개 뽑기 (getRandomAnswer)
- playGame 호출

### playGame()

- 3스트라이크가 나오지 전까지 반복
    - 사용자에게 3자리 수 입력받기 (getUserInput)
    - 힌트 계산 및 출력 (compareAnswers)
- 3스트라이크가 나오면 restart/exit 입력 받기
    - 1 입력 → 재시작 (restartGame)
    - 2 입력 → 종료
    - 그 외 입력 → 에러 출력

### restartGame()

- 랜덤으로 숫자 3개 뽑기 (getRandomAnswer)
- 힌트 초기화 (hint.init)
- playGame 호출

## 2. Array

### getRandomAnswer()

- 랜덤 3자리 수 만들기
- 중복된 숫자는 제외 (isValueInArray)

  ### isValueInArray(int input, int arr[])

    - 얻은 숫자가 배열 내에 이미 존재하는지 확인

### getUserInput()

- 사용자에게 3자리 수 입력받기
- throwError()로 에러 확인 (중복 숫자, 길이, 형식)
- 문자열 → int array 변환

## 3. Hint

### compareAnswers()

- 정답과 사용자 입력 배열 비교하여 ball, strike 개수 구하기
- ball과 strike 출력 (printHint)

### printHint()

- 둘 다 있는 경우 (볼 + 스트라이크)
- 둘 다 없는 경우 (낫싱)
- 볼만 있는 경우
- 스트라이크만 있는 경우
    - 3스트라이크인 경우 끝내기

### init()

- 스트라이크, 볼, 엔드(flag) 0으로 초기화