# 숫자 야구 프로그램 기능 목록
- - -

## 1. 게임 시작 기능
- - -
> play 메서드 구현
- 사용자가 3개의 숫자를 모두 맞힐때 까지 반복

## 2. 게임 재시작 or 종료 선택 기능
- - -
> askExit 메서드 구현
- 게임이 종료되면 게임을 종료 or 재시작 질문 출력
  - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
- 사용자의 입력을 받음  
  - readLine()을 통해 입력 받아 int로 저장
- validateOneOrTwo 메서드 호출하여 입력값 검증
    - 사용자가 올바른 값을 입력했을 경우 통과
    - 사용자가 잘못된 값을 입력했을 경우 예외 발생 후 애플리케이션 종료
- 사용자의 입력값이 1이라면 재시작, 2라면 

## 3. 컴퓨터 랜덤 숫자 선택 기능
- - -
> generateComputerNumbers 메서드 구현
- 컴퓨터가 선택한 랜덤 숫자는 HashMap<Integer, Integer> 객체 변수 computerNumbers에 저장
  - <랜덤 숫자, 숫자 순서> 형태로 저장
- pickNumberInRange()를 통해 1~9 사이의 숫자를 선택 
  - 선택한 숫자가 computerNumbers에 존재하지 않을 경우 추가
  - 선택한 숫자가 computerNumbers에 존재할 경우 다시 선택

## 4. 사용자 숫자 입력 기능
- - -
> inputUserNumbers 메서드 구현
- 사용자 숫자 입력 메시지를 출력
  - "숫자를 입력해주세요. : "
- 사용자의 숫자를 입력 받음
  - readLine()을 통해 입력 받아 String으로 저장
  - 이를 toCharArray()을 사용하여 char형 배열에 저장
- validateInput 메서드 호출
  - 사용자가 올바른 값을 입력했을 경우 통과
  - 사용자가 잘못된 값을 입력했을 경우 예외 발생 후 애플리케이션 종료
- 사용자의 값이 올바를 경우 char[]을 객체 변수 int[] userNumbers에 변환하여 저장

## 5. 스트라이크 개수 카운트 기능
- - -
> countStrike 메서드 구현
- 사용자가 입력한 숫자가 저장된 userNumbers에 순차적으로 접근
  - 만약 숫자가 computerNumbers에 포함되고 숫자의 위치가 동일할 경우 strike 개수 증가
- 검사가 끝나면 strike 개수 반환

## 6. 볼 개수 카운트 기능
- - -
> countBall 메서드 구현
- 사용자가 입력한 숫자가 저장된 userNumbers에 순차적으로 접근
    - 만약 숫자가 computerNumbers에 포함되고 숫자의 위치가 다를 경우 ball 개수 증가
- 검사가 끝나면 ball 개수 반환

## 7. 결과 출력 기능
- - -
> displayGameResult 메서드 구현
- strike의 개수와 ball의 개수를 입력으로 받음
- strike의 개수와 ball의 개수의 따라 출력 조건
  - strike != 0 and ball == 0 일 경우
    - 스트라이크_개수 + "스트라이크" 출력
  - strike == 0 and ball != 0 일 경우
    - 볼_개수 + "볼" 출력 
  - ball != 0 and strike != 0 일 경우
    - 볼_개수 + "볼 " + 스트라이크_개수 + "스트라이크" 출력
  - strike == 0 and ball == 0 일 경우
    - "낫싱" 출력

## 8. 게임 종료 여부 확인 기능
> checkGameOver 메서드 구현
- 스트라이크 개수가 3일 경우 true 반환하여 게임 종료
- 스트라이크 개수가 3이 아닐 경우 false를 반환하여 게임 지속

## 9. 예외 처리 기능
- - -
> validateOneOrTwo 메서드 구현
- 사용자가 입력한 값이 1 or 2의 값인지 검사
  - 값이 1 or 2라면 통과
  - 값이 1or 2가 아니라면 IllegalArgumentException을 발생시킨 후 종료
> validateDigits 메서드 구현
- 사용자가 입력한 값이 숫자인지 검사
    - 숫자라면 통과
    - 숫자가 아니라면 IllegalArgumentException을 발생시킨 후 종료
> validateLength 메서드 구현
- 사용자가 입력한 값이 3자리인지 검사
  - 3자리라면 통과
  - 3자리가 아니라면 IllegalArgumentException을 발생시킨 후 종료
> validateDuplicateNumbers 메서드 구현
- 사용자가 입력한 값들 중에 중복된 수가 있는지 검사
  - 중복된 수가 없다면 통과
  - 중복된 수가 있다면 IllegalArgumentException을 발생시킨 후 종료
  