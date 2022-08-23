import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static List<Prim>[] node; 
	
	public static class Prim implements Comparable<Prim>{
		int v;
		int weight;
		
		public Prim(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Prim o) {
			// TODO Auto-generated method stub
//			if(this.weight == o.weight)
//				return 0;
//			return this.weight < o.weight ? -1 : 1;
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static void make(int N) {
		node = new List[N];
		for(int i=0;i<N;i++)
			node[i]=new ArrayList<Prim>();
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		make(N+1);//0사용 안함.
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			node[a].add(new Prim(b,weight));
			node[b].add(new Prim(a,weight));
		}
		
		PriorityQueue<Prim> pq = new PriorityQueue<Prim>();
		pq.add(new Prim(1,0));//시작 포인트. 가중치 없도록 시작
		
		long answer = 0;
		int count = 0;
		
		boolean[] isUsed = new boolean[N+1];//0사용 안해서
		
		while(!pq.isEmpty()) {
			Prim cur = pq.poll();
			if(isUsed[cur.v])
				continue;
			
			isUsed[cur.v]=true;
			answer+=cur.weight;
			count++;
			
			if(count==N)	//마지막 노드까지 검색했을 경우 빠져나오기
				break;

			for(Prim next : node[cur.v])
				pq.add(next);
		}
		
		System.out.println(answer);
	}
	
	

}
