package practice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object obj = new Object();
		// obj 인스턴스의 toString 결과 출력
		// 직접 호출하나 인스턴스 이름만 설정하나 결과는 같음
		System.out.println(obj.toString());
		System.out.println(obj);

		Integer i = 100;
		//toString의 결과가 저장하고 있는 데이터인 100입니다.
		System.out.println(i.toString());
		System.out.println(i);
		
		//상위 클래스 타입의 참조형 변수에 
		//하위 클래스 타입의 인스턴스 참조를 대입할 수 있다.
		Object str = "Hello world";
		//출력만 할 때는 형변환 없이 사용해도 된다.
		//toString은 Object가 가지고 있으므로
		//호출할 수 있기 때문이다.
		System.out.println(str);
		//Object 타입의 변수는 출력할 때를 제외하고는 
		//아래처럼 원래의 자료형으로 강제 형변환해서 사용
		String imsi = (String) str;
		for(int j =0; j<imsi.length(); j++) {}
	}

}
