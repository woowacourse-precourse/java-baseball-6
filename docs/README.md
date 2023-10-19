1. 컴퓨터가 뽑힌 숫자 조합 정하기

-Computer 클래스 생성
-Computer 클래스의 객체는 numbers라는 arrayList로 선택한 3개의 난수를 저장함.
-3개의 난수는 Computer클래스 생성자를 통해 생성됨

2. 플레이어의 숫자를 입력 받기

-User 클래스 생성, 입력 받은 숫자는 User의 guessNumber라는 arrayList로 저장함.
-User.setGuessNumber() 메소드를 통해 올바른 입력인지 확인 후 저장
-만약, 올바른 입력이 아닐 시 IllegalArgumentException 발생 후 종료
-guessNumber을 초기화하는 메소드


3.숫자 야구 게임 진행하기

-Game 클래스 생성
-Game 클래스에서 전체적인 숫자 야구 진행
-숫자를 입력 받을 때마다 이전에 플레이어가 입력했던 숫자를 저장한 arraylist를 초기화