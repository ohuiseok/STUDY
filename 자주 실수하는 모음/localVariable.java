package localVariable;


public class localVariable {
	
	public static void arrTest(int[] arr) {
		arr = new int[10];
		arr[0]=9;
	}
	
	public static void main(String[] args) {	
		int[] arr = {1,2,3,4,56};
		for(int a : arr)
			System.out.print(a);
		arrTest(arr);
		System.out.println();
		for(int a : arr)
			System.out.print(a);
	}
}


/*
new 로 되어있는 변수들은 주소를 가리키게 한다. (배열, 클래스..등등)
즉, 함수 내에서 new가 되면 매개변수로 들어간 변수와 별개로 보면 된다. (해당 변수가 가리키는 주소값이 매개변수가 가리키던 곳이 아니기때문이다.)
많이 실수 했던 것! (함수에 매개변수로 클래스 객체를 보냈는데, 함수내에서 새로 인스턴스화 하였던 적이 있다. 지역변수임에도 함수외부의 객체에도 영향을 준다고 생각했었다.

*/
