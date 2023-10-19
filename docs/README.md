설계

프로그램 흐름도

1. 시작
2. 상대 수 생성하기. (targetNumber)
3. 플레이어 수 입력 받기. (myNumber)
4. 예외 처리. (IllegalArgumentException을 발생)
4. 수 비교. (myNumber) -> [strike, ball, miss]
5. 힌트 생성. [strike, ball, miss] -> (hint)
6. 힌트 출력.
6. 정답 여부 확인. 정답시 7번이동.
7. 다시 시작 여부 확인(1 시작 , 2 종료)

model(Computer)

1. 필드 : targetNumber
2. 생성자 : targetNumber를 생성
   -> camp.nextstep.edu.missionutils.Randoms의
   pickNumberInRange()을 활용한다.
3. CompareNumber
   -> 플레이어측 수를 비교해 배열 생성
4. MakeHint
   -> 배열을 문자열로 반환

controller(Application)
camp.nextstep.edu.missionutils 모듈 사용

1. player 객체 생성
2. myNumber 생성
   -> camp.nextstep.edu.missionutils.Console의
   readLine()을 활용한다.
3. if 문을 이용해 myNumber을 판별한다.
4. 수를 비교한다.
   -> baseball 클래스에 CompareNumber 이용
5. 힌트를 생성한다.
   -> baseball 클래스에 MakeHint 이용
6. Hint 출력
7. if 문을 이용해 3 strike 시 종료 .