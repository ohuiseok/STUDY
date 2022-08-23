import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static kruskal[] kr;
	static int[] node;

	static class kruskal implements Comparable<kruskal> {
		int start;
		int end;
		int weight;

		public kruskal(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(kruskal o) {
			// TODO Auto-generated method stub
			return this.weight <= o.weight ? -1 : 1;
		}

	}

	static void make(int N) {
		node = new int[N];
		for (int i = 0; i < N; i++)
			node[i] = i;
	}

	static int find(int x) {
		if (node[x] == x)
			return x;
		return find(node[x]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA < rootB)
			node[rootB] = rootA;
		else
			node[rootA] = rootB;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		long answer = 0;
		kr = new kruskal[M];//입력받을 값
		make(N+1);	//숫자가 1부터 시작하기 때문

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			kr[i] = new kruskal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(kr); // 가중치가 작은 값부터 정렬

		for (int i = 0; i < M; i++) {
			int start = kr[i].start;
			int end = kr[i].end;
			int weight = kr[i].weight;
			if(find(start)==find(end))
				continue;
			union(start,end);
			count++;
			answer+=weight;
			if(count==N-1) {
				break;
			}
		}
		System.out.println(answer);
	}

}
