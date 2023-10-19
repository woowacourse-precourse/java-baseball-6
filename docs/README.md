# 구현할 내용

## Ball Class
    - Integer형 변수 number
    - checkRange(Integer) : number가 1~9 사이인지 확인
    - getNumber() : number를 반환
    
## Balls Class
    - List<Ball> balls
    - randomComputerBalls() : 3개의 Ball을 생성하여 balls에 추가
    - strToBalls(String) : String을 받아 3개의 Ball을 생성하여 balls에 추가
    - checkDuplication() : balls에 중복된 숫자가 있는지 확인
    - @Override toString() : balls를 String으로 변환하여 반환
    - isEqual(Balls) : balls와 매개변수로 받은 Balls의 숫자가 모두 같은지 확인
    - isContain(Ball) : balls에 매개변수로 받은 Ball이 있는지 확인
    - get(int) : balls의 index에 해당하는 Ball을 반환
## Game Class
    - Integer strike
    - Integer ball
    - final Integer MAX_COUNT = 3
    - result(Balls, Balls) : 사용자의 입력값과 컴퓨터의 랜덤값을 비교하여 결과를 반환
    - printResult() : 결과를 출력
    - ball과 strike에 대한 조건 함수

