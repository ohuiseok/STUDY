import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static int[] value;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		area = new int[N][N];
		value = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
			value[i] = Integer.MAX_VALUE;
		}
		
		
		int min,node=0;
		long answer = 0;
		
		boolean[] isUsed = new boolean[N];
		value[0] = 0;//0번 노드 부터 탐색 하기 위한 세팅
		
		for(int v=0 ; v <N ; v++) {
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				if(isUsed[i])
					continue;
				if(min > value[i]) {
					node = i;
					min = value[i];
				}
			}//탐색하지 않았던 노드 중에서 가장 작은 가중치를 가진 곳을 탐색하기로 결정
			
			isUsed[node] = true;	//탐색을 시작하기로 했기때문에 방문표시
			answer+=min;			//가중치를 더한다.
			
			for(int i=0;i<N;i++) {	
				/*
				 * 해당 노드를 기점으로 주변의 노드들의 가중치를 비교. 
				 * 그 값이 0이 아닌데도 내가 저장하고 있는 가중치보다 작으면 그 노드값을 저장. 
				 * */
				if(!isUsed[i] && area[node][i] != 0 && value[i] > area[node][i]) {
					value[i] =  area[node][i];
				}
			}
			/*
			 * 즉, (미리 시작할 노드의 가중치를 0으로 가장낮게 설정한다.)
			 * 
			 * 가장 가중치가 낮은 노드 선택
			 * 방문표시.
			 * (가중치 값 저장 (사실적으로 두번째 방문부터 의미 있음))
			 * 이동한 노드를 기준으로 주변 노드들의 값을 확인
			 * 자신이 기록한 값들 보다 낮으면 그 값으로 저장.
			 * 
			 * */
			
			
		}
		System.out.println(answer);
		
	}

}
