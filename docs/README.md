구현할 기능 목록

1. 시작, 종료, 결과 문구 작성 -> Message 클래스 생성 후 static 문자열로 사용 처리
2. 단순 1 부터 9 까지 3자리 숫자 생성 -> camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 사용
3. 서로 다른 수로 이루 어진 숫자의 요구 사항을 충족 하기 위해 중복 체크 로직 구현 -> RandomNumberUtils 클래스 안에서 duplicateCheck 중복 값 입력 되지 않도록 메소드 별도 추가
   하여 pickNumberInRange() 사용
4. 사용자의 값을 입력 받는다. -> camp.nextstep.edu.missionutils.Console의 readLine() 활용 하여 구현
5. 입력된 값이 3자리 숫자 혹은 숫자가 맞는지 확인 -> 빈값, 숫자 타입, 자릿수, 중복 값 check 로직 CheckUtils 로 구현
6. 입력한 수에 대한 볼 결과 로직 생성 -> baseBallCount 메소드로 리스트 contains 활용해서 구현
7. 입력한 수에 대한 스트라이크 결과 로직 생성 -> baseBallCount 메소드에서 같은 인덱스 값 비교 볼과 스트라이크 결과는 map 에 담아서 리턴
8. 종료 여부에 따른 게임 활성화 로직 생성 -> gameStart() 메소드와 process() 메소드로 기존 메소드들 구별 후 loop 처리