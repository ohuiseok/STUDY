import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int []> pascal = new ArrayList<int []>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		pascal.add(new int[] {1});
		pascal.add(new int[] {1,1});
		
		
		for (int t = 1; t < N; t++) {
			int[] before = pascal.get(pascal.size()-1);
			int[] cur = new int[before.length+1];
			cur[0]=1;
			cur[cur.length-1]=1;
			for(int i=1;i<cur.length-1;i++) {
				cur[i]=before[i-1]+before[i];
			}
			pascal.add(cur);
		}

//		for(int[] a : pascal) {
//			System.out.println(Arrays.toString(a));
//		}
		System.out.println(pascal.get(N)[M]);
	}
}
