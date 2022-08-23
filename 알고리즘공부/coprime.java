import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;



public class Solution {
	static int[] group;
	
	public static int find(int x) {
		if(group[x]==x)
			return x;
		else
			return find(group[x]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA < rootB)	//오름차순 
			group[rootB] = rootA;
		else
			group[rootA] = rootB;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=testCase;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Set<Integer> exist = new HashSet<Integer>();
			int count = 0;
			group = new int[N+1];
			
			
			for(int i=1;i<=N;i++)
				group[i]=i;//자기 자신 넣기
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				union( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(int i=1;i<=N;i++) {
				int tmp = find(i);
				if(!exist.contains(tmp)) {
					exist.add(tmp);
					count++;
				}
			}
			System.out.println(new StringBuilder().append("#").append(t).append(" ").append(count).toString());
		}
		
/*
 * 1~N까지 배열 생성
 * 자기자신
 */

	}

}
