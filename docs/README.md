1. 추후에 여러 게임을 실행할 수 있도록 Game 인터페이스를 구현한다.
    - void start(void)
    - void exit(void)

2. View 인터페이스를 마련하여 추후에 여러 화면을 사용할 수 있도록 한다. 
   - void out(String)
   - String in(void)

2. 게임이 다시 시작될 수 있도록 구현한다.
    - void restart(void)
3. 컴퓨터의 랜덤숫자를 생성하는 함수를 만들어야 한다. 
    - String generateRandomNumber(void)
4. 중복되는 값이 있는지를 확인하는 함수가 필요하다.
    - boolean isDuplicated(String)
    - 
5. 사용자의 입력을 받고, 허용되지 않는 값인지 처리하는 함수가 필요하다.
    - void acceptable
6. 주어지는 숫자, 혹은 문자열을 세자리로 포맷팅하는함수가 필요하다.
    - String matchFormat(String)
    - String matchFormat(int)

+ 