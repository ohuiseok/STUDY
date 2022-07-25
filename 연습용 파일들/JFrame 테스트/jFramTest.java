package io.velog.JFrameTest;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * https://www.javatpoint.com/java-swing
 * https://docs.oracle.com/javase/8/docs/api/
 * 
 * */


/**
 * @author dkdle
 * 윈도우 관련함수
 */
class WindowSetting implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class Handler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str =e.getActionCommand();
		if(str.equals("CLICK"))
			System.out.println("이벤트 start");
		else if(str.equals("LOGIN"))
			System.out.println("이벤트 LOGIN");
	}
}

class KeboadSetting implements KeyListener{


	public KeboadSetting() {

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		System.out.println(code);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class FrameSetting extends JFrame{
	
	private ImageIcon img1 = new ImageIcon(getClass().getClassLoader().getResource("background.jpg"));
	private ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("background.jpg"));
	//private Image background=new ImageIcon(getClass().getClassLoader().getResource("background.jpg")).getImage();
	
	
	public FrameSetting() {
		super();
		
		
		//창 열리고 닫고..
		WindowSetting ws = new WindowSetting();
		
		//handler
		Handler hd = new Handler();

		//button
		JButton b1 = new JButton("CLICK");
		b1.setBounds(100, 100, 100, 40);
		b1.addActionListener(hd);
		b1.setIcon(img1);
		//keyboard
		KeboadSetting ks = new KeboadSetting();
				
		//Font
		Font font1 = new Font("고딕",Font.BOLD,20);
		
		//label
		Label label1 =new Label("labeltest",Label.CENTER);
		label1.setBounds(0, 0, 100, 100);
		label1.setFont(font1);
		
		//TextField
		TextField tf1 = new TextField();
		tf1.setBounds(0, 100, 100, 40);
		tf1.addActionListener(hd);
		tf1.addKeyListener(ks);			//텍스트필드에 키보드 핸들러 세팅
				
		//frame setting
		add(b1);
		add(label1);
		add(tf1);
		setSize(300,400);
		setLayout(null);
		setVisible(true);
		setTitle("jframe 테스트");
		addWindowListener(ws);	// 윈도우 세팅
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

//	public void paint(Graphics g) {//그리는 함수
//		g.drawImage(background, 0, 0, null);//background를 그려줌
//	}
}

public class jFramTest  {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSetting fs = new FrameSetting();
		
		
	}

}


