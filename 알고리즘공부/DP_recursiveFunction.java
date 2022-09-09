import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 다이나믹 재귀 
   배열을 만들어 놓고, 재귀함수 내에서 배열이 null 일때만 내부 재귀를 타고 들어가게 한다. 
   그리고 마지막에는 배열에 값 넣기
	 */

	static Integer[] dp;

	public static int makeOne(int value) {
		if (dp[value] != null)
			return dp[value]; 

		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;
		
		if (value % 3 == 0)
			a = makeOne(value / 3) + 1;

		if (value % 2 == 0)
			b = makeOne(value / 2) + 1;

		if (value - 1 >= 0)
			c = makeOne(value - 1) + 1;

		a = Integer.min(a, b);
		
		dp[value] = Integer.min(a, c);
		return dp[value];
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		dp = new Integer[T + 1];
		dp[1] = 0;
		
		makeOne(T);

		System.out.println(dp[T]);

	}

}
