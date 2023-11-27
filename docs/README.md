
    프로그램이 실행 
- programStart() : main()에서 실행되는 프로그램을 실행했을 때 첫번째로 실행되는 메서드 
- displayProgramStart() : 프로그램이 실행되면 프로그램의 시작 문구를 출력해주는 메서드


    프로그램을 시작 (1번)
- displayProgramStartNum() : 프로그램의 시작과 종료의 숫자를 선택하는 문구를 출력해주고 숫자를 입력받는 메서드 (1.시작하기 2.종료하기)
- selectProgramStartNum() : 입력받은 숫자를 통해 프로그램을 시작할지 종료할지 정하는 메서드 (switch)
- validateNumber() : 사용자가 입력한 데이터가 옳바른 값(숫자)인지 검증하는 메서드


    프로그램이 종료 (2번)
- displayRunAgainProgram() : 프로그램의 재실행 선택 문구를 출력해주는 메서드 
- displayProgramEnd() : 프로그램을 종료한다면 알리는 문구를 출력해주는 메서드
- validateNumber() : 사용자가 입력한 데이터가 옳바른 값(숫자)인지 검증하는 메서드


    컴퓨터가 숫자를 선택
- setRandomNum() : 컴퓨터가 무작위 숫자를 만드는 메서드


    사용자가 숫자를 입력
- inputNumData() : 사용자가 입력한 숫자(3개)를 입력받을 메서드
- validateNumber() : 사용자가 입력한 데이터가 옳바른 값(숫자)인지 검증하는 메서드
- compareInputNum() : 사용자가 입력한 숫자와 컴퓨터가 선택한 숫자를 비교하여 볼, 스트라이크, 낫싱을 리턴하는 메서드


    사용자가 숫자를 모두 맞추었을 때
- displayMatchNum() : 사용자가 숫자를 모두 맞추었을 때 문구를 출력해주는 메서드 
- displayRunAgainProgram() : 프로그램의 재실행 선택 문구를 출력해주는 메서드 
