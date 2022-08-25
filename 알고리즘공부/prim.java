import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Graph graph;
	static boolean[] isVisited;
	static int answer = 0;
	static List<int []> process = new ArrayList<int []>(); //없어도 됨 확인용
	
	static class Graph{
		List<Node>[] node;

		public Graph(int N) {
			super();
			node = new List[N+1];
			for(int i=0;i<N+1;i++) {
				node[i] = new ArrayList<Node>();
			}
		}
		
		public void addNode(int from,int to ,int weight) {
			node[from].add(new Node(to,weight));
			node[to].add(new Node(from,weight));
		}
		
		
	}
	
	static class Node implements Comparable<Node>{
		int vertex,weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.weight == o.weight) return 0;
			return this.weight < o.weight ? -1 : 1;
		}

		
		
	}
	
	public static void prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Queue<Integer> input = new LinkedList<Integer>();
		
		input.add(start);
		
		while(!input.isEmpty()) {
			int from = input.poll();
			isVisited[from] = true;
			
			for (Node node : graph.node[from]) {//주변 노드를 검색한다.
				if(isVisited[node.vertex])
					continue;
				pq.add(node);//방문하지 않은 노드를 다 넣는다. 우선순위큐 이기 때문에 가중치가 낮은 순으로 들어간다.
			}
			
			while(!pq.isEmpty()) {//주변 노드들의 정보를 한 번씩 훑어본다.
				Node node = pq.poll();
				if(isVisited[node.vertex])
					continue;
				input.add(node.vertex);	// 탐색하지 않은 노드들만 본다. 즉, 앞으로 갈 노드들 // 그 들의 가중치를 더한다.
				answer+=node.weight;
				process.add(new int[] {from,node.vertex,node.weight});
				break;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new Graph(N);
		isVisited = new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			graph.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		prim(1);
		
//		for(int[] pr : process)
//			System.out.printf("%d -> %d (가중치 : %d)\n",pr[0],pr[1],pr[2]);
		
		System.out.println(answer);
	}
}
