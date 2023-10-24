클래스 GameManager를 사용하여 숫자 야구 게임 진행

1. 게임준비 : 클래스 생성자를 활용, 값 초기화 및 설정, 이후 2번의 3자리수의 정답 생성하는 함수인 setResult()실행
2. setResult() : 3자리수의 정답을 만드는 함수, 이때 각 숫자의 자릿수와 중복여부를 확인한다.
3. 게임 실행 : startGames(), 종료 전까지 계속 반복, do~while문 사용, 결과값에 따라 true/false를 반환받아 종료한다.
4. 입력값 받기 : playGames(), Console.readLine()으로 값을 받고, 자릿수별로 나누어 setScore()를 실행한다. 
5. setScore() : 점수산정, 받은 숫자가 존재하는지, 위치가 일치하는지를 확인하여 strike 또는 ball을 증가시킨다.
6. 점수 문자열 생성 : setPrint(), strike와 ball의 값을 가져와 문자열 생성, String형으로 반환한다.
7. 문자열 출력 및 종료여부 확인 : printScore(), setPrint()로 받은 문자열 출력 후 strike가 3개면 true를 반환시키고, 아니면 false를 반환한다.
8. 게임 재시작 여부 확인 : 1또는 2만 받고 그에따라 boolean형 반환

- 예외처리 = IllegalArgumentException
  - 예외처리가 되는 경우
    1. 입력값이 3자리가 아닌경우
    2. 입력값이 숫자가 아닌경우
    3. 재시작 여부시에 1,2 가 아닌 다른 값이 들어올경우
