# 숫자 야구 게임

## 구현에 초점을 둔 v1

### 기능명세
- checkResult 
- checkValidInputNumber
- generateRandomNumber
- checkValidOption
- isInteger

### checkResult
사용자가 숫자를 입력하면 컴퓨터 숫자와 비교하여 몇볼,몇스트라이크인지 비교해준다.
게임을 재시작할지 안할지 판별해서 만약 3스트라이크일 경우 게임이 종료되고 재시작된다.

### checkValidInputNumber
사용자의 숫자입력에 대해 예외를 확인한다.

### generateRandomNumber
컴퓨터의 숫자를 랜덤하게 생성한다

### checkValidOption
재시작할지 종료할지에 대한 Option의 입력값이 1또는2가 아닌 경우에 대한 예외를 확인한다.

### isInteger
checkValidInputNumber에서 사용되는 함수로 사용자가 입력한 값이 숫자인지를 판별한다.