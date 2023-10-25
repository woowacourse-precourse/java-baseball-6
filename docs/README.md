
-미션을 읽으면서
 랜덤한 숫자 3개를 생성하고, while문을 돌면서 3자리 숫자를 입력해서 각 index를 비교하면 되겠구나. 정도로만 생각했다.

-구현 기능 목록(과제 프로그래밍 전 설계)
1.기본기능(Base_Function.java 클래스에 구현)
    1.주어진 API를 이용해 랜덤숫자를 만드는 함수와 콘솔에서 입력값을 읽어오는 함수를 구현한다.
    2.예외처리에 대한 함수를 구현한다.->요구사항에 System.exit()를 호출하지 않아야 하기 때문에 return값으로 처리하겠다.
        -return 1이면 정상적 처리
        -예외발생의 경우 IllegalArgumentException를 메시지와 함께 throw한다. 
        -exception 종류
            1.입력받은 값의 길이가 3또는 1이 아닌 경우->입력받은 문자열과 해당 문자열의 올바른 길이를 매개변수로 받는다.
            2.입력받은 3자리수 입력에서 1~9가 아닌 숫자가 있는 경우. 문자열-'0'방식으로 찾기 때문에 숫자아닌 문자입력도 여기서 거른다.
            3.입력받은 3자리수에 중복된 값이 있는 경우.

2.Application.java 
    -main 함수-
    1.Base_Function 클래스로 객체를 만들어 함수 기능을 사용한다.
    2.초기 컴퓨터 랜덤 숫자를 만들어 주고 while문으로 들어간다.
    3.콘솔입력 3자리 숫자를 각각 저장하는 List객체를 만들고 0으로 초기화 한다.
    4.시작 메시지 출력후 while 문으로 진입한다. while(true) 방식으로 진행. while 내부에서 break;를 통해 제어
        1.입력을 받아서 Exception을 체크한다. Base_Function에 구현한 함수 사용
        2.입력에 문제가 없다면 입력값과 컴퓨터에 저장된 값을 비교한다.->비교함수 따로 만들자.
        3.비교 결과값을 리턴받아 출력 요구사항을 만족하는 print를 수행한다.
        4.3스트라이크 상황에서(비교 결과값 가지고) 1,2 입력을 수행하자.
    -비교함수 Compare_~
    1.컴퓨터 숫자랑 입력값이랑 3자리수 비교하는 코드 구현.
    2.리턴값으로 strike랑 boll을 넘겨줘야 한다.
    
위의 설계를 바탕으로 코드를 구현했다.


-과제 프로그래밍 수행과정.
    1.Application.java
        1.main 함수
            -main함수 종료 전에 console.close()를 추가했다.
        2.public static int Compare_Input_And_Cnum(List<Integer> input_num, List<Integer> Cnum) 
            -입력값과 컴퓨터 값을 비교하는 함수. index로 비교하면서 strike, boll 갯수를 count한다. 
            -리턴값으로 strike*10+boll 을 넘겨준다. ->문자열로 넘겨도 되고, 리스트 만들어서 념겨도 괜찮은데 정수의 자리수 구분으로 해봤다.
        3.public static String Make_Print_String(int cmp_num)
            -strike, boll 숫자에 따라 알맞는 출력 문자열을 생성해 리턴해 주는 함수.
    2.Base_Function.java
        1.public List<Integer> Make_RandomNum()
            -라이브러리 사용 예시를 변형하지 않는 방식으로 사용했다.
        2.public String Input_Data()
            -console. 을 눌러서 readline()이라는 함수를 발견하고 문자열을 읽는 함수라서 사용했다.
            console.close()는 main 함수 종료전에 수행.
        3.public int Input_Correction_Check(String input_str, int str_len)
        4.public int Input_Correction_Check(List<Integer> Input_num)
            -함수 오버로딩으로 구현. 3번은 문자열의 길이를 비교(1차적 처리)하는 것이고, 4번은 입력받은 3개의 숫자를 확인(2차적 처리)하는 것이다.
            -*처음에는 당연히 try-catch 구조로 구현했는데 TEST과정에서 오류가 나서 찾아보니 요구사항에서 try-catch가 아닌 throw만 요구했다.
            -그래서 try-catch부분을 주석처리 하고, throw만 구현하는 방식으로 바꿨다. 
 
-과제 프로그래밍 완료후 테스트: BUILD SUCCESSFUL in 4s 
    try-catch를 구현해서 fail을 했었다. 처음에는 조금 당황스러웠는데 ApplicationTest.java파일 읽어보면서 금방 찾을 수 있었다.



프로그래밍을 하며 찾아보게된 정보들
1.String변수에 indexing 하는 방법
    -자바는 C,python과 다르게 String.charAt(idx) 방식으로 접근해야 한다.
    -또는 String.toCharArray()[idx]; 방식으로 사용함.