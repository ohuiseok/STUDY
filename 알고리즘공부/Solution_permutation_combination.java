import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int N = 3;//3개만 뽑아서 하겠다.
	static int caseNumber = 0;//경우의 수
	static int[] arr = {1,2,3,4,5,6,7,8,9,10};
	static int[] answer = new int[3];
	static boolean[] isUse;
	
	public static void reduplicationPermutation(int search,int count) {//중복 순열
		if(count==N) {
//			for(int a : answer)
//				System.out.print(a+" ");
//			System.out.println();
			caseNumber++;
			return;
		}
		
		for(int i=0;i<arr.length;i++) {						//순열은 처음부터 끝까지 검색함
			answer[count]=arr[i];
			reduplicationPermutation(search+1,count+1);
		}
	}
	public static void permutation(int search,int count) {// 순열
		if(count==N) {
//			for(int a : answer)
//				System.out.print(a+" ");
//			System.out.println();
			caseNumber++;
			return;
		}
		
		for(int i=0;i<arr.length;i++) {						//순열은 처음부터 끝까지 검색함
			if(isUse[i])
				continue;
			answer[count]=arr[i];
			isUse[i]=true;
			permutation(search+1,count+1);
			isUse[i]=false;
		}
	}
	public static void reduplicationCombination(int search,int count) {//중복 조합
		if(count==N) {
//			for(int a : answer)
//				System.out.print(a+" ");
//			System.out.println();
			caseNumber++;
			return;
		}
		
		for(int i=search;i<arr.length;i++) {		//자기자신 포함 해서 검색
			answer[count]=arr[i];
			reduplicationCombination(i,count+1);/////////////i가 핵심 이전값은 무시하고 앞으로 검색할 것에 자기자신을 포함한 i를 넣음
		}
	}
	public static void combination(int search,int count) {//조합
		if(count==N) {
//			for(int a : answer)
//				System.out.print(a+" ");
//			System.out.println();
			caseNumber++;
			return;
		}
		
		for(int i=search;i<arr.length;i++) {
			if(isUse[i])
				continue;
			isUse[i]=true;
			answer[count]=arr[i];
			combination(i,count+1);/////////////i가 핵심 이전값은 무시하고 앞으로 검색할 것
			isUse[i]=false;
		}
	}
	public static void main(String[] args) throws IOException  {	
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		
		System.out.println("case 1  중복순열 : 3개만 고를 것임");
		caseNumber=0;
		reduplicationPermutation(0,0);
		System.out.println("caseNumber : "+caseNumber);//10*10*10

		System.out.println("case 2  순열 : 3개만 고를 것임");
		caseNumber=0;
		isUse = new boolean[arr.length];
		permutation(0,0);
		System.out.println("caseNumber : "+caseNumber);//10*9*8

		System.out.println("case 3  중복조합 : 3개만 고를 것임");
		caseNumber=0;
		reduplicationCombination(0,0);
		System.out.println("caseNumber : "+caseNumber);//nHr 10H3 => (n+r-1)!/r!/(n-1)! 12!/3!/9!  220

		System.out.println("case 4  조합 : 3개만 고를 것임");
		caseNumber=0;
		isUse = new boolean[arr.length];
		combination(0,0);
		System.out.println("caseNumber : "+caseNumber);//nCr => n!/r!/(n-r)! 10C3//10!/3!/7!  120
		
	}
	
}