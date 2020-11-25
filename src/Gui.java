package src;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Gui extends JFrame
{
    private JButton start;
    private JButton pause;
    private JButton pSun;
    private JButton mSun;
    boolean s = false; 
    boolean p = false;
    boolean moveSun = false;
    boolean clear = false;
    
    public Gui()
    {
        super("Control Panel");
        super.setSize(800,650);
        //super.getContentPane().setBackground(Color.RED);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        setLayout(null); //makes the button smaller

        Handler1 handler = new Handler1();
        Handler2 handler2 = new Handler2();
        
        start = new JButton("Start");
        start.setFont(new Font("San Serif",Font.PLAIN,28));
        start.setBounds(50,150,300,100);
        add(start);
        start.addActionListener(handler);
        
        pause = new JButton("Pause");
        pause.setFont(new Font("San Serif",Font.PLAIN,28));
        pause.setBounds(400,150,300,100);
        add(pause);
        pause.addMouseListener(handler);
        
        pSun = new JButton("Portable Sun");
        pSun.setFont(new Font("San Serif",Font.PLAIN,28));
        pSun.setBounds(50,300,300,100);
        add(pSun);
        pSun.addActionListener(handler2);
        
        mSun = new JButton("Stop Sun");
        mSun.setFont(new Font("San Serif",Font.PLAIN,28));
        mSun.setBounds(400,300,300,100);
        add(mSun);
        mSun.addMouseListener(handler2);
    }
    
    private class Handler1 implements MouseListener,ActionListener
    {
        public void actionPerformed(ActionEvent e){
            s = true;
            p = false;
        }

        public void mouseClicked(MouseEvent e){
        	p = true;
        	s = false;
        }

        public void mousePressed(MouseEvent e){
        }

        public void mouseReleased(MouseEvent e){
            
        }

        public void mouseEntered(MouseEvent e){
        }

        public void mouseExited(MouseEvent e){

        }
    }
    
    private class Handler2 implements MouseListener,ActionListener
    {
        public void actionPerformed(ActionEvent e){
            moveSun = true;
        }

        public void mouseClicked(MouseEvent e){
        	moveSun = false;	
        }

        public void mousePressed(MouseEvent e){
        }

        public void mouseReleased(MouseEvent e){
            
        }

        public void mouseEntered(MouseEvent e){
        }

        public void mouseExited(MouseEvent e){

        }
    }
      
    public boolean getS(){
        return s;
    }
    
    public boolean getP(){
        return p;
    }
}