import java.io.BufferedReader;

import java.io.IOException;
import java.util.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame implements ActionListener {
	
	private static	JFrame frame,framebmi,frameresult,frameenter;
					JTextField txt_weight,txt_height,txt_bmi;
					JRadioButton age1,age2,age3,glucoseyes,glucoseno,
									bloodyes,bloodno,pregyes,pregno,bmi1,bmi2,bmi3;
					JLabel title,age,pregnant,blood,bmi,glucose, positive,negative,
							potential,height,weight,bmilevel,title2;
	private static	JButton btn_check,btn_checkbmi,btn_reset,btn_bmical,btn_back,btnenter;
					ButtonGroup grpage,grppreg,grpblood,grpbmi,grpglucose;
	private static JTable table;
	private static	JTabbedPane tab;
	int m1=0,m2=0,m3=0,m4=0,m5=0,total=0;
	
//	privapubte int clickCount = 0;
		public Main() {
	Editing();
}
	
	
	
	public void  Editing()  {
		
		
		btnenter = new JButton("ENTER");
		Container panes = getContentPane();
		panes.setBackground(Color.white);
		panes.setLayout(new BorderLayout());
		ImageIcon icon = new ImageIcon("image/diabetes.jpg");
		JLabel picdiabetes = new JLabel(icon);
		
		JPanel panelss = new JPanel();
		panelss.setLayout(new FlowLayout());
		panelss.add(picdiabetes);
		
		JPanel panelsss = new JPanel();
		panelsss.setLayout(new FlowLayout());
		panelsss.add(btnenter);
		
		panes.add(panelss, BorderLayout.CENTER);
		panes.add(panelsss, BorderLayout.SOUTH);
		
		frameenter = new JFrame();
		frameenter.setTitle("Diabetes Checker");
		frameenter.setSize(500,500);
		frameenter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frameenter.setLocationRelativeTo(null);
		frameenter.setVisible(true);
		frameenter.getContentPane().add(panes);
		
		
		
		btnenter.addActionListener(this);
	}
	public void Frameutama() {
	
		frame = new JFrame("Diabetes Checker");
		frame.setBounds(100, 100, 1028, 721);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setLayout(null);
	    frame.setVisible(true);
	    
	    
	    
	    title = new JLabel("DIABETES DIAGNOSIS CHECKER TOOLS");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(337, 23, 403, 38);
		frame.getContentPane().add(title);
		frame.repaint();
		
		age= new JLabel("1) Tell us your range age so that we can estimate your risk better");
		age.setBounds(89, 89, 488, 17);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().add(age);
		frame.repaint();
		
		age1 = new JRadioButton("Less than 45 years old");
		age1.setBackground(new Color(255, 204, 204));
		age1.setBounds(106, 126, 168, 23);
		frame.getContentPane().add(age1);
		frame.repaint();
		
		age2 = new JRadioButton("45 years old and above");
		age2.setBackground(new Color(255, 204, 204));
		age2.setBounds(295, 126, 160, 23);
		frame.getContentPane().add(age2);
		frame.repaint();
		
		
		// group button for radio button
		grpage = new ButtonGroup();		
		grpage.add(age1);
		grpage.add(age2);
		

		
		pregnant = new JLabel("2) Are you pregnant ?");
		pregnant.setBounds(89, 168, 168, 17);
		frame.getContentPane().add(pregnant);
		pregnant.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		frame.repaint();
		
		pregyes = new JRadioButton("Yes");
		pregyes.setBackground(new Color(255, 204, 204));
		pregyes.setBounds(106, 206, 90, 23);
		frame.getContentPane().add(pregyes);
		frame.repaint();
		
		pregno = new JRadioButton("No");
		pregno.setBackground(new Color(255, 204, 204));
		pregno.setBounds(196, 206, 109, 23);
		frame.getContentPane().add(pregno);
		frame.repaint();
		
		
		//group button for radio button
		grppreg = new ButtonGroup();
		grppreg.add(pregyes);
		grppreg.add(pregno);
		
		
		
		
		blood = new JLabel("3) Do you often eat foods that contain high sugar?");
		blood.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		blood.setBounds(89, 245, 366, 23);
		frame.getContentPane().add(blood);
		frame.repaint();
		
		bloodyes = new JRadioButton("Yes");
		bloodyes.setBackground(new Color(255, 204, 204));
		bloodyes.setBounds(108, 283, 78, 23);
		frame.getContentPane().add(bloodyes);
		frame.repaint();
		
		
		bloodno = new JRadioButton("No");
		bloodno.setBackground(new Color(255, 204, 204));
		bloodno.setBounds(196, 283, 109, 23);
		frame.getContentPane().add(bloodno);
		frame.repaint();
		
		// group button for radio button
		grpblood = new ButtonGroup();
		grpblood.add(bloodyes);
		grpblood.add(bloodno);
		
		bmi = new JLabel("4) What is your BMI level (kg/m^2) ?");
		bmi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		bmi.setBounds(93, 328, 282, 23);
		frame.getContentPane().add(bmi);
		frame.repaint();
		
		bmi1 = new JRadioButton("18.5 - 24.9 ( Normal Weight)\r\n");
		bmi1.setBackground(new Color(255, 204, 204));
		bmi1.setBounds(111, 370, 194, 28);
		frame.getContentPane().add(bmi1);
		frame.repaint();
		
		bmi2 = new JRadioButton("25.0 - 29.9 ( Overweight )");
		bmi2.setBackground(new Color(255, 204, 204));
		bmi2.setBounds(307, 373, 168, 23);
		frame.getContentPane().add(bmi2);
		frame.repaint();
		
		bmi3= new JRadioButton("30.0 and above ( Obesity )");
		bmi3.setBackground(new Color(255, 204, 204));
		bmi3.setBounds(504, 373, 188, 23);
		frame.getContentPane().add(bmi3);
		frame.repaint();
		
		grpbmi = new ButtonGroup();
		grpbmi.add(bmi1);
		grpbmi.add(bmi2);
		grpbmi.add(bmi3);
		
		btn_bmical = new JButton("BMI Calculator");
		btn_bmical.setBounds(385, 330, 121, 23);
		frame.getContentPane().add(	btn_bmical);
		frame.repaint();
		
		glucose = new JLabel("5) Do you experience any of these symptoms : Shortness of Breath, Frequent Urination, Fatigue and Stomach Pain");
		glucose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		glucose.setBounds(89, 430, 850, 23);
		frame.getContentPane().add(glucose);
		frame.repaint();
		
		glucoseyes = new JRadioButton("Yes");
		glucoseyes.setBackground(new Color(255, 204, 204));
		glucoseyes.setBounds(244, 460, 141, 23);
		frame.getContentPane().add(glucoseyes);
		frame.repaint();
		
		
		glucoseno = new JRadioButton("No");
		glucoseno.setBackground(new Color(255, 204, 204));
		glucoseno.setBounds(385, 460, 160, 23);
		frame.getContentPane().add(glucoseno);
		frame.repaint();
		
		
		grpglucose = new ButtonGroup();
		grpglucose.add(glucoseno);
		grpglucose.add(glucoseyes);
	
		
		btn_check = new JButton("CHECK");
		btn_check.setBounds(747, 545, 109, 38);
		frame.getContentPane().add(btn_check);
		frame.repaint();
		
		
		age1.addActionListener(this);
		age2.addActionListener(this);
	//	age3.addActionListener(this);
		glucoseyes.addActionListener(this);
		glucoseno.addActionListener(this);
		bloodyes.addActionListener(this);
		bloodno.addActionListener(this);
		pregyes.addActionListener(this);
		pregno.addActionListener(this);
		bmi1.addActionListener(this);
		bmi2.addActionListener(this);
		bmi3.addActionListener(this);
		btn_check.addActionListener(this);
		btn_bmical.addActionListener(this);
		
		
		
	    
	    
	   
		
	}
	
	public void actionPerformed (ActionEvent e) {

		if(e.getSource()== age1) {
		//	age2.setSelected(false);
			m1=2;
			
		}
		
		if(e.getSource()==age2) {
		
			m1=30;
		}
		
	//	if(e.getSource()==age3) {
	//		age2.setSelected(false);
	//		age1.setSelected(false);
	//	}
		
		if(e.getSource()==glucoseyes) {
			glucoseno.setSelected(false);
			m5=97;
					
		}
		
		if(e.getSource()==glucoseno) {	
			glucoseyes.setSelected(false);
			m5=51;
		}
		
		if(e.getSource()==bloodno) {
			bloodyes.setSelected(false);
			m3=66;
		}
		
		
		if(e.getSource()==bloodyes) {
			bloodno.setSelected(false);
			m3=9;
		}
		
		if(e.getSource()==pregyes) {
			pregno.setSelected(false);
			m2=11;
		}
		if(e.getSource()==pregno) {
			pregyes.setSelected(false);
			m2=25;
		}
		if(e.getSource()==bmi1) {
			bmi2.setSelected(false);
			bmi3.setSelected(false);
			m4=88;
		}
		if(e.getSource()==bmi2) {
			bmi1.setSelected(false);
			bmi3.setSelected(false);
			m4=18;
		}
		if(e.getSource()==bmi3) {
			bmi1.setSelected(false);
			bmi2.setSelected(false);
			m4=44;
		}
		
		if(e.getSource()==btn_check) {
			
	
			if(grpage.getSelection()==null || grppreg.getSelection()==null || grpblood.getSelection()==null || grpbmi.getSelection()==null || grpglucose.getSelection()==null) {
				
			JOptionPane.showMessageDialog(null, "Field cannot be empty");
		
			}
		
		
			else {
			total=m1+m2+m3+m4+m5;
			result(total);
			}
		}
		if(e.getSource()==btn_bmical) {
			bmicalculator();
		}
		if(e.getSource()==btn_checkbmi) {
			
			double iWeight = Double.parseDouble(txt_weight.getText());
			double iHeight = Double.parseDouble(txt_height.getText());
			double ibmi = iWeight / (iHeight * iHeight);
			
			String calc = String.format("%.2f", ibmi);
			txt_bmi.setText(calc);
			
			
			
			
			
		}
		if(e.getSource()==btn_back) {
			
			framebmi.dispose();
		}
		if(e.getSource()==btn_reset) {
			
			txt_height.setText(null);
			txt_weight.setText(null);
			txt_bmi.setText(null);
			txt_bmi.setOpaque(true);
			txt_bmi.setBackground(null);
		}
		if(e.getSource()==btnenter) {
			
			frameenter.dispose();
			Frameutama();
		}
		
	
	}
	
	public void bmicalculator() {
		
		framebmi = new JFrame();
		framebmi.setBounds(100, 100, 711, 433);
		framebmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framebmi.getContentPane().setLayout(null);
		framebmi.setLocationRelativeTo(null);
		framebmi.setResizable(false);
	    framebmi.setLayout(null);
	    framebmi.setVisible(true);
	    
		
		title2 = new JLabel("BMI CALCULATOR");
		title2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		title2.setBounds(282, 23, 158, 23);
		framebmi.getContentPane().add(title2);
		framebmi.repaint();
		
		weight = new JLabel("Weight (Kg) :");
		weight.setFont(new Font("Tahoma", Font.BOLD, 11));
		weight.setBounds(51, 90, 89, 23);
		framebmi.getContentPane().add(weight);
		framebmi.repaint();
		
		height = new JLabel("Height (m^2) :");
		height.setFont(new Font("Tahoma", Font.BOLD, 11));
		height.setBounds(40, 145, 89, 23);
		framebmi.getContentPane().add(height);
		framebmi.repaint();
		
		txt_height = new JTextField();
		txt_height.setBounds(150, 138, 158, 37);
		framebmi.getContentPane().add(txt_height);
		txt_height.setColumns(10);
		framebmi.repaint();
		
		txt_weight = new JTextField();
		txt_weight.setBounds(150, 82, 158, 38);
		framebmi.getContentPane().add(txt_weight);
		txt_weight.setColumns(10);
		framebmi.repaint();
		
		bmilevel = new JLabel("BMI LEVEL :");						
		bmilevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		bmilevel.setBounds(63, 208, 77, 23);
		framebmi.getContentPane().add(bmilevel);
		framebmi.repaint();
		
		txt_bmi = new JTextField();
		txt_bmi.setBounds(150, 200, 158, 38);
		framebmi.getContentPane().add(txt_bmi);
		//txt_bmi.setBackground(Color.LIGHT_GRAY);
		txt_bmi.setColumns(10);
		txt_bmi.setEditable(false);
		framebmi.repaint();
		
		
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(459, 123, 194, 76);
		framebmi.getContentPane().add(tab);
		framebmi.repaint();
		
		String data[][] =	new String[][] {
			{"Normal Weight", "18.5 - 24.9"},
			{"Overweight", "25.0 - 29.9"},
			{"Obesity", "30.0 and above "},
		};
		
		String column[]={
				"Meaning", "BMI LEVEL"
			};
		table = new JTable(data,column);
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.setForeground(Color.BLACK);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.WHITE);
		tab.addTab("BMI LEVEL", null, table, null);
		btn_checkbmi = new JButton("CHECK");
		btn_checkbmi.setBounds(150, 310, 102, 38);
		framebmi.getContentPane().add(btn_checkbmi);
		framebmi.repaint();
		
		btn_reset = new JButton("RESET");
		btn_reset.setBounds(269, 310, 102, 38);
		framebmi.getContentPane().add(btn_reset);
		framebmi.repaint();
		
		btn_back = new JButton("BACK");
		btn_back.setBounds(564, 315, 89, 28);
		framebmi.getContentPane().add(btn_back);
		framebmi.repaint();
		
		btn_back.addActionListener(this);
		btn_checkbmi.addActionListener(this);
		btn_reset.addActionListener(this);
		
		
		
	}
	
	
	public void result(int m) {
		if(m==232) {
			
			
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE LOW POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You can maintain your healthy lifestyle"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		       
		}
		if(m==218) {
			
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
			  
		}
		if(m==175) {
			
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==161) {
			
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==162) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE LOW POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You can maintain your lifestyle but better to exercise more."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==148) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake.",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		
		if(m==105) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake.",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==91) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!.",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==188) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 - above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change your lifestyle by eating healthier and exercise frequently!"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==174) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 - above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==131) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 - above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==117) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 - above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==260) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE LOW POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You can maintain your healthy lifestyle",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==246) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==203) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       
		}
		if(m==189) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Try to be more active",">You should make a medical check up."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==190) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You can maintain your lifestyle but better to exercise more."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==176) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake.",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==133) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==119) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==216) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE MODERATE POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change your lifestyle by eating healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==202) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should maintain controlling your sugar intake.",">Eat healthier and exercise frequently."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==159) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms:   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==145) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: NO","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should control your sugar intake!",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		
		//30
		if(m==278) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle",">You should make a medical check up"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
			
		}
		if(m==264) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle",">You should make a medical check up"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==221) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms:   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle",">Make sure your sugar intake is low",">You should make a medical check up"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==207) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle",">Make sure your sugar intake is low",">You should make a medical check up"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		
			
			
			
		}
		if(m==208) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==194) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==151) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :    less than 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">You should make a medical check up",">Exercise regularly."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==137) {
			
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   < 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low.",">You should make a medical check up."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==234) {
			JScrollPane scrollpane = new JScrollPane(); 
		     String categories[] = { "Based on Your answers :","\n", "Your Age :   < 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should make a medical check up",">You must change to healthy lifestyle.",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==220) {
			JScrollPane scrollpane = new JScrollPane(); 
		     String categories[] = { "Based on Your answers :","\n", "Your Age :   < 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should make a medical check up",">You must change to healthy lifestyle.",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==177) {
			JScrollPane scrollpane = new JScrollPane(); 
		     String categories[] = { "Based on Your answers :","\n", "Your Age :   < 45 years old", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should make a medical check up",">You must change to healthy lifestyle.",">Make sure your sugar intake is low healthy lifestyle.",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==163) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answesr :","\n", "Your Age :   < 45 years old", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">Seek for medical inspection and do the treatment if needes",">You must change to healthy lifestyle.",">Make sure your sugar intake is low."};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==306) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==292) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==249) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms:   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">You should make a medical check up",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==235) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   18.5 - 24.9(Normal Weight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">You should make a medical check up",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==236) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==222) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==179) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(OOverweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">You should make a medical check up",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==165) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   25.0 - 29.9(Overweight)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">You should make a medical check up",">Exercise regularly"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==262) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==248) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   NO", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==205) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   NO", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">You should change to healthy lifestyle.",">You should make a medical check up",">Eat healthier and exercise frequently"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		if(m==191) {
			JScrollPane scrollpane = new JScrollPane(); 
			
		       String categories[] = { "Based on Your answers :","\n", "Your Age :   45 years old and above", "Are You Pregnant :   YES", "Do you often eat foods with high sugar contain :   YES", "What is your BMI level :   30.0 and above(Obesity)"
		               ,"Do you exprience any of these symptoms :   Shortness of breath, Frequent Urination, Fatigue and Stomach Pain: YES","\n","\n","\n","RESULT :","\n"
		               ,"YOU HAVE HIGH POSSIBILITY TO GET DIABETES","\n","\n","COMMENT :","\n",">Seek for medical inspection and do the treartment if needed",">You should change to healthy lifestyle.",">Make sure your sugar intake is low",">Try to be more active"};
		     
		       
		       JList list = new JList(categories);
		    
		       scrollpane = new JScrollPane(list);
		       
		       JPanel panel = new JPanel(); 
		 
		       panel.add(scrollpane,BorderLayout.NORTH);
		       
		   
		       
		       scrollpane.setPreferredSize(new Dimension(800,500));
		       JOptionPane.showMessageDialog(null, scrollpane, "Your Diagnosis Result",  
		                                              JOptionPane.PLAIN_MESSAGE);
		      
		       frame.dispose();
		       Frameutama();
		}
		
	}
	
	
	public static void main (String [] args) {
		
		new Main();
	}

}
