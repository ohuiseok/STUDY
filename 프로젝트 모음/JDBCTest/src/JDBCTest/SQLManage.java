package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLManage {
	public String[][] dbData;
	public final int arrayIndex = 10;
	Connection con = null;
	private static SQLManage instance = null; 
	String url = "jdbc:mysql://경로";
	
	private SQLManage() {
		init();
	}
	
	public static SQLManage getInstance() {
		if(instance != null)
			return instance;
		
		instance = new SQLManage();
		return instance;
	}
	
	private void init() {
		System.out.println("초기 세팅...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "id", "password");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			System.out.println("초기 세팅 완료");			
		}

	}
	
	
	
	public void selectDB() {
		ArrayList<String[]> data = new ArrayList<String []>();
		
		System.out.println("SELECT 진행중...");
		try {
			String sql = "SELECT * FROM jobfinding";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	
	        while(rs.next()){       
	        	//StringBuilder sb = new StringBuilder();
	        	String[] tmp = new String[10];
	        	for(int i=1;i<=10;i++)
	            	tmp[i-1]=rs.getString(i);
	        	//sb.append(rs.getString(i)).append("\t");
	            //System.out.println(sb.toString());
//	        	ArrayList<String> dbData = new ArrayList<String>();
//	        	for(int i=1;i<=10;i++)
//	        		dbData.add(rs.getString(i));
	        	data.add(tmp);
	        	
	        }	
	        dbData = data.toArray(new String[data.size()][10]);
		}
		catch(SQLException e) {
			e.getStackTrace();
		}finally {
			System.out.println("SELECT 진행완료");
		}
	} 
	
	public void insertDB(String[] data)///////////////////
	{
		System.out.println("INSERT 진행중...");
		try {
			String sql = "INSERT INTO jobfinding VALUES (?,?,?,?,?,?,?,?,?,?)";//////////////INSERT INTO pet VALUES (?,?,?,?,?,?)
			PreparedStatement pstmt = con.prepareStatement(sql);
	
			if(data[3].isEmpty())
				data[3]="0";
			if(data[7].isEmpty())
				data[7]="0";
	
	        // 4. 데이터 binding
	        pstmt.setString(1, data[0]);//id 날짜로 하자 ㅎㅎ
	        pstmt.setString(2, data[1]);//회사명
	        pstmt.setString(3, data[2]);//직업 (프론트엔드,백엔드 ...등)
	        pstmt.setInt(4, Integer.parseInt(data[3]));//연봉
	        pstmt.setString(5, data[4]);//추가 스펙
	        pstmt.setString(6, data[5]);//위치
	        pstmt.setString(7, data[6]);//정규직or계약직
	        pstmt.setInt(8, Integer.parseInt(data[7]));//경력
	        pstmt.setString(9, data[8]);//add
	        pstmt.setString(10, data[9]);//기술 스텍
	
	
	        // 5. 쿼리 실행 및 결과 처리
	        // SELECT와 달리 INSERT는 반환되는 데이터들이 없으므로
	        // ResultSet 객체가 필요 없고, 바로 pstmt.executeUpdate()메서드를 호출하면 됩니다.
	        // INSERT, UPDATE, DELETE 쿼리는 이와 같이 메서드를 호출하며
	        // SELECT에서는 stmt.executeQuery(sql); 메서드를 사용했었습니다.
	        // @return     int - 몇 개의 row가 영향을 미쳤는지를 반환
	        int count = pstmt.executeUpdate();
	        if( count == 0 ){
	            System.out.println("데이터 입력 실패");
	        }
	        else{
	            System.out.println("데이터 입력 성공");
	        }
		}
		catch(SQLException e) {
			e.getStackTrace();
		}finally {
			System.out.println("INSERT 진행완료");
		}
	}
	
	public void deleteDB(String index) {

		System.out.println("delete 진행중...");
		try {
			String sql = "DELETE FROM jobfinding WHERE id=?";//////////////INSERT INTO pet VALUES (?,?,?,?,?,?)
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, index);//회사명
			pstmt.executeUpdate();
	        
		}
		catch(SQLException e) {
			e.getStackTrace();
		}finally {
			System.out.println("delete 진행완료");
		}
	} 
	
	
	

}
