/**
 * ColorFactory.java
 * @author Pedro Gárate on 1/23/2015
 * @desc Create colors in Binary, Octal, Decimal or Hex using sliders. 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorFactory extends JFrame 
                          implements ActionListener, ChangeListener
{
	public String decimal = "Decimal";
	public String octal = "Octal";
	public String binary = "Binary";
	public String hex = "Hexadecimal";
	public String hexString = "0123456789ABCDEF";
	public int redInt = 0;
	public int grnInt = 0;
	public int bluInt = 0;
	public String redString = intToString(redInt), 
			grnString = intToString(grnInt), 
			bluString = intToString(bluInt);
	JTextField panel3_4, panel3_5, panel3_6;
	JTextField hexNumber;
	public JRadioButton decButton, octButton, binButton, hexButton; 
	public JSlider redSlider, grnSlider, bluSlider;
	
	//********************** ColorFactory() ********************
	public ColorFactory()
	{
		setTitle("COLOR FACTORY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);
		setLocation(100, 100);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		createRadioButtons();
		createSliders();
						
		//*************** Panel1 of Main Frame *****************
		JPanel panel1 = new JPanel()
		{
			@Override
            protected void paintComponent(Graphics g)
			{
				g.setColor(new Color(redInt,grnInt,bluInt));
                g.fillOval(0,0,400,150);
            }
        };
        panel1.setPreferredSize(new Dimension(400,150));
        c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridwidth = 2;
		add(panel1, c);
		
		//*************** Panel2 of Main Frame *****************
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(decButton); panel2.add(octButton);
		panel2.add(binButton); panel2.add(hexButton);
		hexNumber = new JTextField("", 8);
		hexNumber.setEditable(false);
		hexNumber.setHorizontalAlignment(JTextField.CENTER);
		hexNumber.setForeground(Color.BLACK);
		panel2.add(hexNumber);
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 1;
		add(panel2, c);
		
		//*************** Panel3 of Main Frame *****************
		JPanel panel3 = createPanel3();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(panel3, c);
		
		//*************** Panel4 of Main Frame *****************
		JPanel panel4 = new JPanel();
		panel4.add(redSlider); panel4.add(grnSlider); panel4.add(bluSlider);
		c.gridx = 2;
		c.gridy = 1;
		c.weighty = 0.5;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridheight = 2;
		add(panel4, c);
		
		setVisible(true);
	}// end colorFactory
	
	//****************** createPanel3 **************************
	private JPanel createPanel3()
	{
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		panel3.setBackground(Color.BLACK);
		GridBagConstraints c = new GridBagConstraints();
		
		//*************** Panel1 inside Panel3 *****************
		JPanel panel3_1 = new JPanel() 
		{
			@Override
            protected void paintComponent(Graphics g)
			{
				g.setColor(Color.RED);
                g.fillRect(0,128,100,-redInt/2);
                g.drawString("RED", 37, 140);
            }
        };
        panel3_1.setPreferredSize(new Dimension(100,150));
        c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		panel3.add(panel3_1, c);
		
		//*************** Panel2 inside Panel3 *****************
		JPanel panel3_2 = new JPanel() 
		{
			@Override
            protected void paintComponent(Graphics g)
			{
				g.setColor(Color.GREEN);
                g.fillRect(0,128,100,-grnInt/2);
                g.drawString("GREEN", 29, 140);
            }
        };
        panel3_2.setPreferredSize(new Dimension(100,150));
        c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		panel3.add(panel3_2, c);
		
		//*************** Panel3 inside Panel3 *****************
		JPanel panel3_3 = new JPanel() 
		{
			@Override
            protected void paintComponent(Graphics g)
			{
				g.setColor(Color.BLUE);
                g.fillRect(0,128,100,-bluInt/2);
                g.drawString("BLUE", 33, 140);
            }
        };
        panel3_3.setPreferredSize(new Dimension(100,150));
        c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.gridwidth = 1;
		panel3.add(panel3_3, c);
		
		//*************** Panel4 inside Panel3 *****************
		panel3_4 = new JTextField(redString,8);
		panel3_4.setEditable(false);
		panel3_4.setHorizontalAlignment(JTextField.CENTER);
		panel3_4.setForeground(Color.RED);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.5;
		c.weightx = 1;
		c.gridwidth = 1;
		panel3.add(panel3_4, c);
		
		//*************** Panel5 inside Panel3 *****************
		panel3_5 = new JTextField(grnString,8);
		panel3_5.setEditable(false);
		panel3_5.setHorizontalAlignment(JTextField.CENTER);
		panel3_5.setForeground(Color.GREEN);
		c.gridx = 1;
		c.gridy = 1;
		c.weighty = 0.5;
		c.weightx = 1;
		c.gridwidth = 1;
		panel3.add(panel3_5, c);
		
		//*************** Panel6 inside Panel3 *****************
		panel3_6 = new JTextField(bluString,8);
		panel3_6.setEditable(false);
		panel3_6.setHorizontalAlignment(JTextField.CENTER);
		panel3_6.setForeground(Color.BLUE);
		c.gridx = 2;
		c.gridy = 1;
		c.weighty = 0.5;
		c.weightx = 1;
		c.gridwidth = 1;
		panel3.add(panel3_6, c);
		
		return panel3;
	}// end createPanel3

	//******************** createRadioButtons ******************
	public void createRadioButtons()
	{
		decButton = new JRadioButton(decimal);
	    decButton.setMnemonic(KeyEvent.VK_D);
	    decButton.setActionCommand(decimal);
	    decButton.setSelected(true);

	    octButton = new JRadioButton(octal);
	    octButton.setMnemonic(KeyEvent.VK_O);
	    octButton.setActionCommand(octal);

	    binButton = new JRadioButton(binary);
	    binButton.setMnemonic(KeyEvent.VK_B);
	    binButton.setActionCommand(binary);

	    hexButton = new JRadioButton(hex);
	    hexButton.setMnemonic(KeyEvent.VK_H);
	    hexButton.setActionCommand(hex);

	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(decButton);
	    group.add(octButton);
	    group.add(binButton);
	    group.add(hexButton);

	    //Register a listener for the radio buttons.
	    decButton.addActionListener(this);
	    octButton.addActionListener(this);
	    binButton.addActionListener(this);
	    hexButton.addActionListener(this);
	}// end createRadioButtons
	
	//****************** actionPerformed ***********************
	//Listeners for RadioButtons
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
		case "Octal":        panel3_4.setText(intToOct(redInt));
		                     panel3_5.setText(intToOct(grnInt)); 
				             panel3_6.setText(intToOct(bluInt));
				             hexNumber.setText("");
				             break;
		case "Binary":       panel3_4.setText(intToBin(redInt)); 
		                     panel3_5.setText(intToBin(grnInt)); 
                             panel3_6.setText(intToBin(bluInt));
                             hexNumber.setText("");
                             break;
		case "Hexadecimal":  panel3_4.setText(intToHex(redInt)); 
		                     panel3_5.setText(intToHex(grnInt)); 
                             panel3_6.setText(intToHex(bluInt));
                             hexNumber.setText(intToHex(redInt)+
                            		 intToHex(grnInt)+intToHex(bluInt));
                             break;
		case "Decimal":      panel3_4.setText(intToString(redInt)); 
		                     panel3_5.setText(intToString(grnInt)); 
                             panel3_6.setText(intToString(bluInt));
                             hexNumber.setText("");
                             break;
		}// end switch
	}// end actionPerformed
	
	//************************* createSliders ******************
	public void createSliders()
	{
		redSlider = new JSlider(JSlider.VERTICAL,0,255,0);
		redSlider.setMajorTickSpacing(15);
		redSlider.setMinorTickSpacing(5);
		redSlider.setPaintTicks(true);
		redSlider.setBackground(Color.RED);
		redSlider.setPaintTrack(true);
		redSlider.setForeground(Color.WHITE);
		
		grnSlider = new JSlider(JSlider.VERTICAL,0,255,0);
		grnSlider.setMajorTickSpacing(15);
		grnSlider.setMinorTickSpacing(5);
		grnSlider.setPaintTicks(true);
		grnSlider.setBackground(Color.GREEN);
		grnSlider.setPaintTrack(true);
		grnSlider.setForeground(Color.BLACK);
		
		bluSlider = new JSlider(JSlider.VERTICAL,0,255,0);
		bluSlider.setMajorTickSpacing(15);
		bluSlider.setMinorTickSpacing(5);
		bluSlider.setPaintTicks(true);
		bluSlider.setBackground(Color.BLUE);
		bluSlider.setPaintTrack(true);
		bluSlider.setForeground(Color.WHITE);
		
		redSlider.addChangeListener(this);
		grnSlider.addChangeListener(this);
		bluSlider.addChangeListener(this);
	}// end createSliders
	
	//****************** stateChanged **************************
	//Listeners for Sliders
	@Override
	public void stateChanged(ChangeEvent e) 
	{
		if ((JSlider)e.getSource()==redSlider)
		{
			redInt = redSlider.getValue();
		}
		if ((JSlider)e.getSource()==grnSlider)
		{
			grnInt = grnSlider.getValue();
		}
		if ((JSlider)e.getSource()==bluSlider)
		{
			bluInt = bluSlider.getValue();
		}
		if(decButton.isSelected())
		{
			panel3_4.setText(intToString(redInt));
			panel3_5.setText(intToString(grnInt));
			panel3_6.setText(intToString(bluInt));
			hexNumber.setText("");
		}
		if(octButton.isSelected())
		{
			panel3_4.setText(intToOct(redInt));
			panel3_5.setText(intToOct(grnInt));
			panel3_6.setText(intToOct(bluInt));
			hexNumber.setText("");
		}
		if(binButton.isSelected())
		{
			panel3_4.setText(intToBin(redInt));
			panel3_5.setText(intToBin(grnInt));
			panel3_6.setText(intToBin(bluInt));
			hexNumber.setText("");
		}
		if(hexButton.isSelected())
		{
			panel3_4.setText(intToHex(redInt));
			panel3_5.setText(intToHex(grnInt));
			panel3_6.setText(intToHex(bluInt));
			hexNumber.setText(intToHex(redInt)+
					intToHex(grnInt)+intToHex(bluInt));
		}
		repaint();
	}// end stateChanged
	
	//************************** intToHex **********************
	private String intToHex( int i )
	{
		int ihi, ilo;
	    ihi = i / 16;
	    ilo = i % 16;
	    return hexString.substring( ihi, ihi+1 ) + 
	    		hexString.substring( ilo, ilo+1 );
	}// end intToHex
	
	//*********************** intToOct *************************
	private String intToOct( int i )
	{
		return Integer.toString(i, 8);
	}// end intToOct
	
	//*********************** intToBin *************************
	private String intToBin( int i )
	{
		return Integer.toString(i, 2);
	}// end intToBin
	
	//*********************** intToString *********************
	private String intToString(int i)
	{
		return Integer.toString(i);
	}// end intToString
	
	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new ColorFactory();
            }// end run
        });// end invokeLater
    }// end main
}
