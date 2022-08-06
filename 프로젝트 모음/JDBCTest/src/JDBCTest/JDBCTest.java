package JDBCTest;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


class Gui extends JFrame implements ActionListener
{
	JFrame frame;
	JPanel mainPanel = new JPanel(new GridLayout(2,1));
	
	private final int UP_PANEL_NUM = 5;
	
	private final int BTN_SIZE = 5;
	private final String[] btnName = {"입력","출력","제거","CLEAR","Excel 변환"};
	private JButton[] bt;
	 
	private final int LABEL_SIZE = 4;
	private final String[] labelContent1 = {"회사명","직업","연봉(만)","추가SPEC"};
	private final String[] labelContent2 = {"위치","정규직(유무)","경력","추가사항"};
	private JTextField[] textField1;
	private JTextField[] textField2;
	 
	private final int CHECK_SIZE = 10;
	private final String[] checkContent1 = {"자바","JavaScript","Spring","Html/css","jQuery","JSP","Vue.js","Oracle","MySQL","React"};
	private final String[] checkContent2 = {"Spring Boot","PHP","Python","Node.js","C#","Swift","전자정부프레임워크","Kotlin","MSSQL","React Native"};
	private final String[] checkContent3 = {"Laravel","Flask","Django","Express.js","Rails(Ruby)","Meteor","koa","Nest.js","Strapi","Angular"};
	private final String[] checkContent4 = {"Slack","JIRA","Fast Api","Rest API","Netty","DJango","ASP.NET","Svelte","KeystoneJS","클라우드"};
	private JCheckBox [] checkBox1; 
	private JCheckBox [] checkBox2; 
	private JCheckBox [] checkBox3; 
	private JCheckBox [] checkBox4; 
	
	private DefaultTableModel 	dbModel;
	private JTable			  	dbTable;
	private JScrollPane		  	dbPan;
	private String[]		  	dbTitle = { "날짜", "회사명", "직업","연봉(만)", "추가SPEC", "위치" ,"정규직(유무)","경력","추가사항","기술스택", };
	private SQLManage mgr = SQLManage.getInstance();
	
	Font font = new Font("돋움", Font.BOLD, 22) ;
	
	public Gui(){	
		//super("채용공고 저장소");
		mgr.selectDB();
		
		frame = new JFrame("채용공고 저장소");
		
		bt = new JButton[BTN_SIZE];
        
		JLabel[] label1 = new JLabel[LABEL_SIZE];
		textField1 = new JTextField[LABEL_SIZE];
		JLabel[] label2 = new JLabel[LABEL_SIZE];
		textField2 = new JTextField[LABEL_SIZE];
		
		checkBox1 = new JCheckBox[CHECK_SIZE];
		checkBox2 = new JCheckBox[CHECK_SIZE];
		checkBox3 = new JCheckBox[CHECK_SIZE];
		checkBox4 = new JCheckBox[CHECK_SIZE];
		
		
		JPanel upPanel = new JPanel(new GridLayout(UP_PANEL_NUM,1));
		JPanel dbPanel = new JPanel(new GridLayout());


		JPanel upPanel1 = new JPanel(new GridLayout(1,BTN_SIZE));
		JPanel upPanel2 = new JPanel(new GridLayout(1,LABEL_SIZE*2));
		JPanel upPanel3 = new JPanel(new GridLayout(1,LABEL_SIZE*2));
		JPanel upPanel4 = new JPanel(new GridLayout(2,1));
		JPanel upPanel5 = new JPanel(new GridLayout(2,1));
		
		
		JPanel checkPanel1 = new JPanel(new GridLayout(1,CHECK_SIZE));
		JPanel checkPanel2 = new JPanel(new GridLayout(1,CHECK_SIZE));
		JPanel checkPanel3 = new JPanel(new GridLayout(1,CHECK_SIZE));
		JPanel checkPanel4 = new JPanel(new GridLayout(1,CHECK_SIZE));
		
        
		
		for(int i=0 ; i < BTN_SIZE; i++)
		{	
			bt[i] = new JButton(btnName[i]);
			bt[i].setFont(font);
			bt[i].addActionListener(this);
			upPanel1.add(bt[i]);
			
		}
		
		for(int i=0 ; i < LABEL_SIZE; i++)
		{	
			label1[i] = new JLabel(labelContent1[i]);
			textField1[i] = new JTextField();
			label1[i].setFont(font);
			textField1[i].setFont(font);
			upPanel2.add(label1[i]);
			upPanel2.add(textField1[i]);
		}
		
		for(int i=0 ; i < LABEL_SIZE; i++)
		{	
			label2[i] = new JLabel(labelContent2[i]);
			textField2[i] = new JTextField();
			label2[i].setFont(font);
			textField2[i].setFont(font);
			upPanel3.add(label2[i]);
			upPanel3.add(textField2[i]);
		}
		
		
		for(int i=0 ; i < CHECK_SIZE; i++)
		{	
			checkBox1[i] = new JCheckBox(checkContent1[i]);
			checkBox1[i].setFont(font);
			checkPanel1.add(checkBox1[i]);
		}

		for(int i=0 ; i < CHECK_SIZE; i++)
		{	
			checkBox2[i] = new JCheckBox(checkContent2[i]);
			checkBox2[i].setFont(font);
			checkPanel2.add(checkBox2[i]);
		}
		upPanel4.add(checkPanel1);
		upPanel4.add(checkPanel2);
		
		for(int i=0 ; i < CHECK_SIZE; i++)
		{	
			checkBox3[i] = new JCheckBox(checkContent3[i]);
			checkBox3[i].setFont(font);
			checkPanel3.add(checkBox3[i]);
		}

		for(int i=0 ; i < CHECK_SIZE; i++)
		{	
			checkBox4[i] = new JCheckBox(checkContent4[i]);
			checkBox4[i].setFont(font);
			checkPanel4.add(checkBox4[i]);
		}
		upPanel5.add(checkPanel3);
		upPanel5.add(checkPanel4);
		
		
		dbModel = new DefaultTableModel(dbTitle,20);
		dbTable = new JTable(dbModel);
		dbPan = new JScrollPane(dbTable);
		dbTable.setColumnSelectionAllowed(true);
		dbTable.setAutoCreateRowSorter(true);
		dbTable.setFont(font);
		dbTable.getTableHeader().setFont(font);
		dbTable.setRowHeight(50);
		dbPanel.add(dbPan);
		
		dbModel.setDataVector(mgr.dbData,dbTitle);

		upPanel.add(upPanel1);
		upPanel.add(upPanel2);
		upPanel.add(upPanel3);
		upPanel.add(upPanel4);
		upPanel.add(upPanel5);

		mainPanel.add(upPanel);
		mainPanel.add(dbPanel);
		frame.add(mainPanel);
		frame.setLayout(new GridLayout());
		frame.setSize(1500, 800);
//		frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt[0]) {
			LocalDateTime currentDateTime = LocalDateTime.now();    
			String[] input = new String[10];
			int loc=0;
			int result = 0;
			
			if(!textField1[2].getText().matches("[+-]?\\d*(\\.\\d+)?"))//숫자가 아니라면
			{
				JOptionPane.showMessageDialog(null, "연봉은 숫자만 적어주세요");
				return;
			}
			if(!textField2[2].getText().matches("[+-]?\\d*(\\.\\d+)?"))//숫자가 아니라면
			{
				JOptionPane.showMessageDialog(null, "경력은 숫자만 적어주세요");
				return;
			}
			
			input[loc++] = currentDateTime.toString();
			for(int i=0;i<LABEL_SIZE;i++) {
				input[loc++] = textField1[i].getText();
			}
			for(int i=0;i<LABEL_SIZE;i++) {
				input[loc++] = textField2[i].getText();
			}
			input[loc++] = selectCheckBox();
			
			System.out.println(Arrays.toString(input));
			
			result = JOptionPane.showConfirmDialog(null, "입력하시겠습니까?");
			if(result == 0) {
				mgr.insertDB(input);
				mgr.selectDB();
				dbModel.setDataVector(mgr.dbData,dbTitle);
				clearEvent();
			}
		}
		else if(e.getSource()==bt[1]) {
			mgr.selectDB();
			dbModel.setDataVector(mgr.dbData,dbTitle);
		}
		else if(e.getSource()==bt[2]) {
			int row =  dbTable.getSelectedRow();
			int result=0;
			
			if(row>=0) {
				result = JOptionPane.showConfirmDialog(null, "제거하시겠습니까?");
				if(result==0) {
					row=dbTable.convertRowIndexToModel(row);
					mgr.deleteDB((String)dbTable.getValueAt(row, 0));
					mgr.selectDB();
					dbModel.setDataVector(mgr.dbData,dbTitle);
				}
			}

		}
		else if(e.getSource()==bt[3]) {
			clearEvent();
		}
		else if(e.getSource()==bt[4]) {
			JFileChooser fchoose = new JFileChooser();
			int option = fchoose.showSaveDialog(this);
			if(option == JFileChooser.APPROVE_OPTION){
				String name = fchoose.getSelectedFile().getName(); 
				if(name.isEmpty())
					name="jobTable";
				String path = fchoose.getSelectedFile().getParentFile().getPath();
				String file = path + "\\" + name + ".xls"; 
				export(dbTable,file);
			}
		}
	}
	
	public String selectCheckBox() {
		StringBuilder sb =  new StringBuilder();
		for(int i=0;i<CHECK_SIZE;i++)
			if(checkBox1[i].isSelected())
				sb.append(checkBox1[i].getText()).append("|");
		for(int i=0;i<CHECK_SIZE;i++)
			if(checkBox2[i].isSelected())
				sb.append(checkBox2[i].getText()).append("|");
		for(int i=0;i<CHECK_SIZE;i++)
			if(checkBox3[i].isSelected())
				sb.append(checkBox3[i].getText()).append("|");
		for(int i=0;i<CHECK_SIZE;i++)
			if(checkBox4[i].isSelected())
				sb.append(checkBox4[i].getText()).append("|");
		if(sb.length()>0)
			sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	public void clearEvent() {
		for(int i=0;i<CHECK_SIZE;i++)
			checkBox1[i].setSelected(false);
		for(int i=0;i<CHECK_SIZE;i++)
			checkBox2[i].setSelected(false);
		for(int i=0;i<CHECK_SIZE;i++)
			checkBox3[i].setSelected(false);
		for(int i=0;i<CHECK_SIZE;i++)
			checkBox4[i].setSelected(false);
		
		for(int i=0;i<LABEL_SIZE;i++) 
			textField1[i].setText("");
		for(int i=0;i<LABEL_SIZE;i++) 
			textField2[i].setText("");
	}
	
	public void export(JTable table, String fileName)
	{
		try
		{
			FileOutputStream output=new FileOutputStream(fileName,false);
	        OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
	        BufferedWriter out=new BufferedWriter(writer);
			
//			File file = new File(fileName);
//			System.out.println("fileName"+fileName);
			TableModel m = dbTable.getModel();
//			FileWriter fw = new FileWriter(file);
			out.write("\uFEFF");
			for(int i = 0; i < m.getColumnCount(); i++)
				out.write(m.getColumnName(i) + ",");
			out.write("\n");

			for(int i=0; i < m.getRowCount(); i++) {
				for(int j=0; j < m.getColumnCount(); j++) {
					out.write(m.getValueAt(i,j).toString()+",");
					System.out.println(m.getValueAt(i,j).toString());
				}
				out.write("\n");
			}

			out.close();
	    }
	    catch(IOException e){ 
	    	System.out.println(e); 
	    }

	}
}




public class JDBCTest {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] cmd = {"1","qwe","asd","0","q","a","z","s","99","c,d,,w,w"};
//		String[][] tmp;
//		SQLManage mgr = SQLManage.getInstance();
//		mgr.selectDB();
//		mgr.insertDB(cmd);
//		mgr.selectDB();
//		tmp = mgr.data.toArray(new String[mgr.data.size()][mgr.arrayIndex]);
//		for(String[] tt : tmp)
//			for(String t : tt)
//				System.out.println(t);
//		mgr.deleteDB("1");
//		mgr.selectDB();
		new Gui();
		
		
	}
}
