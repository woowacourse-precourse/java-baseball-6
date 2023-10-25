1. NumberGenerator: 임의의 3가지 중복되지 않은 숫자를 만들어 내는 Class
- 3개 숫자는 int array 이용 저장
- 1~9까지의 숫자를 랜덤으로 생성
- 중복되지 않는 숫자를 만들기 위해 숫자를 생성할 때마다 기존에 생성된 숫자와 비교
2. InputNumber: 사용자의 입력을 받는 Class
- 적합하지 않은 숫자가 입력될 시 IllegalArgumentException 발생
- 3개 숫자는 int array 이용 저장
- IllegalArgumentException 케이스 (1.문자열 입력, 2.중복된 숫자 입력)
3. Judge: 사용자의 입력값의 결과를 판정하는 Class
- 두개의 3 int array를 비교하여 결과를 판정
- 결과 문구는 string으로 저장
4. BaseballGame: 게임 진행을 총괄하는 Class
- 게임 진행을 위한 메소드들을 포함
- do  while 문을 이용하여 게임 진행
- 3 strike일 경우 게임 종료 후 다시 시작 여부를 묻는 메소드 실행