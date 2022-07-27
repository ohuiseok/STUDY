package test;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

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

class Background extends JPanel {
	private ImageIcon background;
	
	public Background(ImageIcon b) {
		this.background=b;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Image img = background.getImage();
		
		//g.drawImage(img, 0, 0, null);
		g.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), 0, 0, img.getWidth(null), img.getHeight(null), null);
	}
}


/**
 * @author SSAFY
 * 타이틀 바 관련 클래스
 */
class changeTheme extends DefaultMetalTheme {
    public ColorUIResource getWindowTitleInactiveBackground() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getWindowTitleBackground() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getPrimaryControlHighlight() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getPrimaryControlDarkShadow() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getPrimaryControl() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getControlHighlight() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getControlDarkShadow() {
      return new ColorUIResource(java.awt.Color.green);
    }
  
    public ColorUIResource getControl() {
      return new ColorUIResource(java.awt.Color.green);
    }
}


class FrameSetting extends JFrame{
	
	private String background = "images\\\\whale.jpg";
	private String img1 = "images\\\\whale.jpg";
	private String btnImage1 ="images\\\\whale.jpg";
	
	private ImageIcon stringToImageIcon(String path,int width, int height) {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
		Image img = icon.getImage();
		
		if(width == 0)
			width = img.getWidth(null);
		if(height == 0)
			height = img.getHeight(null);
		
		return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
	public FrameSetting() {
		super();
		
		//배경 이미지 변경
		setContentPane(new Background(stringToImageIcon(background,0,0)  )  );
		
		//타이틀바 관련
//		setUndecorated(true);// 원래 타이틀바 제거
//		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//		MetalLookAndFeel.setCurrentTheme(new changeTheme());
//		try {
//	          UIManager.setLookAndFeel(new MetalLookAndFeel());
//	        } catch (Exception e) {
//	          e.printStackTrace();
//	    }
//		SwingUtilities.updateComponentTreeUI(this);
	    
		
		//창 열리고 닫고..
		WindowSetting ws = new WindowSetting();
		
		//handler
		Handler hd = new Handler();

		//button
		JButton b1 = new JButton();
		b1.setBounds(100, 100, 100, 40);
		b1.addActionListener(hd);
		//b1.setIcon(btnImage1);
		b1.setIcon(stringToImageIcon(btnImage1,b1.getWidth(),b1.getHeight()));
		
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
				
		//icon change
		this.setIconImage(stringToImageIcon(img1,0,0).getImage());
		
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
	

}

/**
 * @author SSAFY
 *
 */
public class jFramTest2  {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameSetting fs = new FrameSetting();
		
		
	}

}
