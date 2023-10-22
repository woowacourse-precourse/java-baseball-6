# 숫자 야구 기능 구현 목록

## 게임 시작 문구 출력 기능
- [ ] 게임 시작 문구 출력
  - [ ] "숫자 야구 게임을 시작합니다."를 출력한다.

## 컴퓨터 3자리 난수 생성 기능
- [ ] generateComputerRandomNumber 메서드 구현
  - [ ] 서로 다른 세 자리 숫자 리스트 생성
    - [ ] `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용해 random number를 생성한다.
    - [ ] 생성된 random number와 중복인 숫자가 리스트 내에 있는지 확인 후 추가

## 사용자 정답 입력 기능
- [ ] getUserNum 메서드 구현
  - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자의 값을 입력받는다.
  - [ ] validateStringLengthDuplicateDigitNumber 메서드 구현
    - [ ] 입력받은 값이 1 ~ 9 사이의 서로 다른 숫자면 통과
    - [ ] 이외의 값이라면 `IllegalArgumentException` 예외 발생
      - [ ] validateStringLength 메서드 구현
        - [ ] 주어진 문자열의 길이가 정해진 길이의 문자열인지 검증
      - [ ] validateStringDuplicate 메서드 구현
        - [ ] 주어진 문자열이 중복되는 문자가 없는지 검증
      - [ ] validateStringDigitNumber 메서드 구현
        - [ ] 주어진 문자열 자연수로 이루어진 문자열인지 검증
  - [ ] stringToIntegerList 메서드 구현
    - 입력받은 문자열을 숫자 리스트로 변환하여 반환한다.

## 스트라이크 개수 확인 기능
- [ ] countStrike 메서드 구현
  - [ ] strike 개수를 count 한다.
    - [ ] isStrike 메서드 구현
      - [ ] 매개변수로 컴퓨터의 숫자 리스트, 사용자의 숫자 리스트, 인덱스 값을 입력받는다.
      - [ ] 같은 인덱스에 같은 값이 있으면 strike에 해당하므로 true를 반환한다.
      - [ ] 같은 값이 없으면 false를 반환한다.
  
## 볼 개수 확인 기능
- [ ] countBall 메서드 구현
  - [ ] ball 개수를 count 한다.
  - [ ] isBall 메서드 구현
    - [ ] 매개변수로 컴퓨터의 숫자 리스트, 사용자의 숫자 리스트, 인덱스 값을 입력받는다.
    - [ ] 사용자 숫자 리스트의 인덱스 위치에 해당하는 값이 컴퓨터 숫자 리스트의 다른 인덱스 위치에서 
          발견된다면 ball에 해당하므로 true를 반환한다.
    - [ ] 발견되지 않으면 false를 반환한다.
    - [ ] isStrike 메서드를 실행했을 때 true를 반환한하면 isBall 메서드는 false를 반환한다.
  
## 게임 종료 기능
- [ ] isFinish의 값이 true면 프로그램을 종료한다.
  - [ ] 입력 값이 2면 isFinish의 값을 true로 바꿔준다.
  - [ ] 예외의 값을 입력하면 프로그램을 종료한다.

## 게임 재시작 / 종료 선택 기능
- [ ] isGameFinish 메서드 구현
  - [ ] 스트라이크의 개수가 3개면 프로그램을 종료할지 말지 질문을 출력한다.
    - [ ] "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."를 출력한다.
      - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자의 값을 입력받는다.
  - [ ] validateStringOneOrTwo 메서드 구현
    - [ ] 입력받은 문자열이 1또는 2면 통과
    - [ ] 이외의 값이라면 `IllegalArgumentException` 예외 발생
  - [ ] 1을 입력받으면 재시작, 2를 입력받으면 그대로 종료한다.

## 게임 결과 문구 출력 기능
- [ ] printGameResult 메서드 구현
  - [ ] 사용자의 입력에 대한 결과를 출력
    - [ ] 스트라이크, 볼, 낫싱을 확인한 후 출력
      - [ ] 스트라이크의 개수가 3이라면 스트라이크의 개수 출력 
      - [ ] 스트라이크, 볼의 개수가 0이면 낫싱 출력
      - [ ] 스트라이크, 볼의 개수가 모두 1이상이면, 둘의 개수 모두 출력
      - [ ] 스트라이크의 개수가 1이상이고, 볼의 개수가 0이면 스트라이크의 개수만 출력
      - [ ] 스트라이크의 개수가 0이고, 볼의 개수가 1이상이면 볼의 개수만 출력

## 예외 사항 처리 기능
- [ ] 사용자가 입력한 값을 유효성 검사를 통해 검증
- [ ] 잘못된 값을 입력한 경우 `IllegalArgumentException` 예외 발생
  - [ ] 사용자가 입력한 정답에 대한 예외 처리
    - [ ] 입력한 문자열의 길이가 3미만, 초과인 경우
    - [ ] 입력한 문자열이 숫자가 아닌 경우
    - [ ] 입력한 문자열에 중복인 문자가 있는 경우
  - [ ] 게임 재시작 / 종료를 위한 값에 대한 예외 처리
    - [ ] 입력한 문자열이 1또는 2가 아닌 경우