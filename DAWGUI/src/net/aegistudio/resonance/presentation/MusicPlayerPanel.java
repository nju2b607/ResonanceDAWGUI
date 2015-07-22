package net.aegistudio.resonance.presentation;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.aegistudio.resonance.uicomponents.MyColor;

public class MusicPlayerPanel extends JPanel implements Runnable{

	JLabel play;
	JLabel record;
	JLabel stop;
	JLabel bpm;
	JLabel bpm_num;
	JLabel time;
	JPanel center;
	JPanel south;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MusicPlayerPanel(){
		this.setSize(300,100);
		initComponent();
		initPanel();
		addComponent();
		setListener();
	}
	
	private  void initComponent(){
		play=new JLabel();
		record=new JLabel();
		stop=new JLabel();
		bpm=new JLabel("BPM");
		bpm.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,14));
		bpm.setHorizontalAlignment(SwingConstants.CENTER);
		bpm.setVerticalAlignment(SwingConstants.CENTER);
		bpm_num=new JLabel("sdf");
		bpm_num.setHorizontalAlignment(SwingConstants.CENTER);
		bpm_num.setVerticalAlignment(SwingConstants.CENTER);
		time=new JLabel();
		
	}

	private void initPanel(){
		center=new JPanel();center.setBackground(MyColor.BLUE.getColor());
		center.setBounds(0, 0, this.getWidth(), (int)(this.getHeight()/2));
		center.setLayout(null);
		south=new JPanel();south.setBackground(MyColor.DARKWHITE.getColor());
		south.setBounds(0, (int)(this.getHeight()/2), this.getWidth(), (int)(this.getHeight()/2));
		System.out.println((int)(this.getHeight()/2));
		south.setLayout(null);
		this.setLayout(null);

	}
	private void addComponent(){System.out.println("dsfgh");
		time.setBounds(0, 0, (int)center.getWidth()*2/3, (int)center.getHeight());
		bpm.setBounds((int)center.getWidth()*2/3, 0, (int)center.getWidth()/3,  (int)center.getHeight()/2);
		bpm_num.setBounds((int)center.getWidth()*2/3,  (int)center.getHeight()/2, (int)center.getWidth()/3,  (int)center.getHeight()/2);
		center.add(bpm);
		center.add(time);
		center.add(bpm_num);
		this.add(center);
		this.add(south);
	}
	private void setListener(){
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]){
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 150);
		frame.add(new MusicPlayerPanel());

	}
}
