package net.aegistudio.resonance.uicomponents;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class demo extends JFrame
{
    private GhostGlassPane glassPane;
    private GhostComponentAdapter componentAdapter;
    private JButton ceshi1;
    private JButton ceshi2;
    private JButton ceshi3;
    private JButton ceshi4;
    private JLabel  lceshi;
    private JPanel jpanel;
    private JButton button;
    public demo()
    {
        super("Drag n' Ghost Demo");
        setLayout(new BorderLayout());

        glassPane = new GhostGlassPane();
        componentAdapter = new GhostComponentAdapter(null,null);
        setGlassPane(glassPane);

        ceshi1 = new JButton("��ס���ƶ����");
        ceshi1.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���Button"));
        ceshi1.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        ceshi2 = new JButton("��ס���ƶ����");
        ceshi2.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���Button"));
        ceshi2.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        ceshi3 = new JButton("��ס���ƶ����");
        ceshi3.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���Button"));
        ceshi3.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        ceshi4 = new JButton("��ס���ƶ����");
        ceshi4.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���Button"));
        ceshi4.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        lceshi = new JLabel("��ס����ק(JLabel)");
        lceshi.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���JLabel"));
        lceshi.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        button = new JButton("��ס���ƶ����");
        button.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���Button"));
        button.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        
        jpanel = new JPanel();
        jpanel.setBackground(Color.gray);
        jpanel.addMouseListener(componentAdapter = new GhostComponentAdapter(glassPane, "���ǳ���JPanel"));
        jpanel.addMouseMotionListener(new GhostMotionAdapter(glassPane));
        jpanel.add(lceshi);
        jpanel.add(button);
 
        add(ceshi1,BorderLayout.SOUTH);
        add(ceshi2,BorderLayout.WEST);
        add(ceshi3,BorderLayout.EAST);
        add(ceshi4,BorderLayout.NORTH);
        add(jpanel,BorderLayout.CENTER);
        setSize(400,300);
        setTitle("��͸����ק���");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

     public static void main(String[] args)
    {
        demo d = new demo();
        d.setVisible(true);
    }
}
