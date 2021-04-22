package scientific_calculator;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Sci_cal {

	private JFrame frame;
	private JTextField textField;
	double firstnum;
	double secondnum;
	double result;
	String operation;
	private Object math;
	public int f;
	private JTextField textField_1;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());	
			}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sci_cal window = new Sci_cal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sci_cal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowActivated(WindowEvent e) {
				frame.setResizable(true);
				frame.setSize(270,410);
			}
		});
		frame.setBounds(100, 100, 1097, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar=new JMenuBar();
		
		JMenu fileMenu=new JMenu("File");
		fileMenu.setFont(new Font("Dialog", Font.BOLD, 15));
		JMenu editMenu=new JMenu("Edit");
		editMenu.setFont(new Font("Dialog", Font.BOLD, 15));
		
		menubar.add(fileMenu);
		
		JMenuItem StandardMenuItem = new JMenuItem("Standard");
		StandardMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setResizable(true);
				frame.setSize(270,410);
				textField.setSize(245,48);
			}
		});
		fileMenu.add(StandardMenuItem);
		
		JMenuItem ScientificMenuItem = new JMenuItem("Scientific");
		ScientificMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setResizable(true);
				frame.setSize(658,410);
				textField.setSize(560, 48);
			}
		});
		fileMenu.add(ScientificMenuItem);
		
		JMenuItem ExitMenuItem = new JMenuItem("Exit");
		ExitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.quit();
				System.exit(0);
			}
		});
		
		JMenuItem UnitNewMenuItem = new JMenuItem("Unit Conversion");
		UnitNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setResizable(true);
				frame.setSize(1100,410);
				textField.setSize(560, 48);
				
			}
		});
		fileMenu.add(UnitNewMenuItem);
		fileMenu.add(ExitMenuItem);
		menubar.add(editMenu);
		
		JMenuItem CopyMenuItem = new JMenuItem("Copy");
		editMenu.add(CopyMenuItem);
		
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(pasteMenuItem);
		frame.setJMenuBar(menubar);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
					Toolkit.getDefaultToolkit().beep();
					e.consume();
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(10, 0, 244, 48);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton CutButton = new JButton("C");
		CutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		CutButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		CutButton.setBounds(70, 59, 50, 48);
		frame.getContentPane().add(CutButton);
		
		JButton rootButton = new JButton("\u221A");
		rootButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.sqrt(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		rootButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		rootButton.setBounds(135, 59, 50, 48);
		frame.getContentPane().add(rootButton);
		
		JButton backButton = new JButton("\u2190");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace;
				
				if (textField.getText().length()>0) {
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backspace=str.toString();
					textField.setText(backspace);
				}
			}
		});
		backButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
		backButton.setBounds(10, 59, 50, 48);
		frame.getContentPane().add(backButton);
		
		JButton AddButton = new JButton("+");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText(" ");
				operation="+";
			}
		});
		AddButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		AddButton.setBounds(204, 59, 50, 48);
		frame.getContentPane().add(AddButton);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num=textField.getText()+btn7.getText();
				textField.setText(num);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(10, 118, 50, 48);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn8.getText();
				textField.setText(num);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(70, 118, 50, 48);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn9.getText();
				textField.setText(num);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(135, 118, 50, 48);
		frame.getContentPane().add(btn9);
		
		JButton subButton = new JButton("-");
		subButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText(" ");
				operation="-";
			}
		});
		subButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		subButton.setBounds(204, 118, 50, 48);
		frame.getContentPane().add(subButton);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn4.getText();
				textField.setText(num);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(10, 177, 50, 48);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String num=textField.getText()+btn5.getText();
				textField.setText(num);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(70, 177, 50, 48);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn6.getText();
				textField.setText(num);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(135, 177, 50, 48);
		frame.getContentPane().add(btn6);
		
		JButton divButton = new JButton("/");
		divButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText(" ");
				operation="/";
			}
		});
		divButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		divButton.setBounds(204, 177, 50, 48);
		frame.getContentPane().add(divButton);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn1.getText();
				textField.setText(num);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(10, 237, 50, 48);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn2.getText();
				textField.setText(num);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(70, 237, 50, 48);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn3.getText();
				textField.setText(num);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(135, 237, 50, 48);
		frame.getContentPane().add(btn3);
		
		JButton mulButton = new JButton("*");
		mulButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText(" ");
				operation="*";
			}
		});
		mulButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		mulButton.setBounds(204, 237, 50, 48);
		frame.getContentPane().add(mulButton);
		
		JButton equalButton = new JButton("=");
		equalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				secondnum=Double.parseDouble(textField.getText());
				
				if (operation=="+") {
					result=firstnum+secondnum;
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				
				if (operation=="-") {
					result=firstnum-secondnum;
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				
				if (operation=="/") {
					result=firstnum/secondnum;
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				
				if (operation=="*") {
					result=firstnum*secondnum;
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				
				if (operation=="mod") {
					result=(firstnum%secondnum);
					answer=String.format("%.2f", result);
					textField.setText(answer);
					
				}
				
			}
		});
		equalButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		equalButton.setBounds(204, 291, 50, 48);
		frame.getContentPane().add(equalButton);
		
		JButton btnNewButton_1_3_1 = new JButton("\u00B1");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=ops*(-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_3_1.setBounds(135, 291, 50, 48);
		frame.getContentPane().add(btnNewButton_1_3_1);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String num=textField.getText()+btnDot.getText();
				textField.setText(num);*/
				if (!textField.getText().contains(".")) {
					textField.setText(textField.getText() +btnDot.getText());
				}
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(70, 291, 50, 48);
		frame.getContentPane().add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num=textField.getText()+btn0.getText();
				textField.setText(num);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(10, 291, 50, 48);
		frame.getContentPane().add(btn0);
		
		JButton sinhbtn = new JButton("Sinh");
		sinhbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.sinh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		sinhbtn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		sinhbtn.setBounds(422, 59, 72, 48);
		frame.getContentPane().add(sinhbtn);
		
		JButton sinbtn = new JButton("Sin");
		sinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.sin(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		sinbtn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		sinbtn.setBounds(351, 59, 61, 48);
		frame.getContentPane().add(sinbtn);
		
		JButton logbtn = new JButton("Log");
		logbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.log(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		logbtn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 11));
		logbtn.setBounds(280, 59, 61, 48);
		frame.getContentPane().add(logbtn);
		
		JButton coshbtn = new JButton("Cosh");
		coshbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.cosh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		coshbtn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		coshbtn.setBounds(422, 118, 72, 48);
		frame.getContentPane().add(coshbtn);
		
		JButton cosbtn = new JButton("Cos");
		cosbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.cos(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		cosbtn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		cosbtn.setBounds(351, 118, 61, 48);
		frame.getContentPane().add(cosbtn);
		
		JButton pibtn = new JButton("\u03C0");
		pibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops;
				ops=(3.14159265);
				textField.setText(String.valueOf(ops));
			}
		});
		pibtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		pibtn.setBounds(280, 118, 61, 48);
		frame.getContentPane().add(pibtn);
		
		JButton btnNewButton_1_4_2 = new JButton("Tanh");
		btnNewButton_1_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.tanh(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_1_4_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnNewButton_1_4_2.setBounds(422, 177, 72, 48);
		frame.getContentPane().add(btnNewButton_1_4_2);
		
		JButton btnNewButton_7_2 = new JButton("Tan");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.tan(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_7_2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnNewButton_7_2.setBounds(351, 177, 61, 48);
		frame.getContentPane().add(btnNewButton_7_2);
		
		JButton xPybtn = new JButton("x\u02C4y");
		xPybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.pow(ops,ops);
				textField.setText(String.valueOf(ops));
			}
		});
		xPybtn.setFont(new Font("Serif", Font.BOLD, 19));
		xPybtn.setBounds(280, 177, 61, 48);
		frame.getContentPane().add(xPybtn);
		
		JButton btnNewButton_1_4_3 = new JButton("Rund");
		btnNewButton_1_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.round(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_1_4_3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnNewButton_1_4_3.setBounds(422, 237, 72, 48);
		frame.getContentPane().add(btnNewButton_1_4_3);
		
		JButton btnNewButton_7_3 = new JButton("Cbr");
		btnNewButton_7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.cbrt(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_7_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7_3.setBounds(582, 292, 61, 48);
		frame.getContentPane().add(btnNewButton_7_3);
		
		JButton xP2btn = new JButton("x\u02C42");
		xP2btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=(ops*ops);
				textField.setText(String.valueOf(ops));
			}
		});
		xP2btn.setFont(new Font("Serif", Font.BOLD, 18));
		xP2btn.setBounds(280, 237, 61, 48);
		frame.getContentPane().add(xP2btn);
		
		JButton btnNewButton_1_4_4 = new JButton("Hex");
		btnNewButton_1_4_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,16));
			}
		});
		btnNewButton_1_4_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnNewButton_1_4_4.setBounds(422, 291, 72, 48);
		frame.getContentPane().add(btnNewButton_1_4_4);
		
		JButton btnNewButton_7_4 = new JButton("Bin");
		btnNewButton_7_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,2));
			}
		});
		btnNewButton_7_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_7_4.setBounds(351, 291, 61, 48);
		frame.getContentPane().add(btnNewButton_7_4);
		
		JButton xP3btn = new JButton("x\u02C43");
		xP3btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=(ops*ops*ops);
				textField.setText(String.valueOf(ops));
			}
		});
		xP3btn.setFont(new Font("Serif", Font.BOLD, 18));
		xP3btn.setBounds(280, 291, 61, 48);
		frame.getContentPane().add(xP3btn);
		
		JButton btnMod = new JButton("mod");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum=Double.parseDouble(textField.getText());
				textField.setText(" ");
				operation="mod";
			}
		});
		btnMod.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnMod.setBounds(504, 238, 72, 48);
		frame.getContentPane().add(btnMod);
		
		JButton btnLn = new JButton("ln");
		btnLn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnLn.setBounds(351, 238, 61, 48);
		frame.getContentPane().add(btnLn);
		
		JButton cosinvBtn = new JButton("Cos\u02C4-1");
		cosinvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//double a = Math.PI;
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.toRadians(ops);
				ops=Math.acos(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		cosinvBtn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		cosinvBtn.setBounds(504, 120, 72, 48);
		frame.getContentPane().add(cosinvBtn);
		
		JButton Sininvbtn = new JButton("Sin\u02C4-1");
		Sininvbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.toRadians(ops);
				ops=Math.asin(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		Sininvbtn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		Sininvbtn.setBounds(504, 61, 72, 48);
		frame.getContentPane().add(Sininvbtn);
		
		JButton OctButton = new JButton("Oct");
		OctButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,8));
			}
		});
		OctButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		OctButton.setBounds(504, 292, 72, 48);
		frame.getContentPane().add(OctButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Item", "Distance", "Time", "Speed"}));
		comboBox.setBounds(793, 15, 219, 24);
		frame.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Centaur", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(667, 89, 145, 40);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Centaur", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(952, 89, 121, 40);
		frame.getContentPane().add(textField_2);
		
		JLabel l5 = new JLabel("");
		l5.setFont(new Font("Tahoma", Font.BOLD, 12));
		l5.setBounds(691, 59, 68, 19);
		frame.getContentPane().add(l5);
		
		JLabel l6 = new JLabel("");
		l6.setFont(new Font("Tahoma", Font.BOLD, 12));
		l6.setBounds(951, 59, 61, 24);
		frame.getContentPane().add(l6);
		
		JLabel l1 = new JLabel(" ");
		l1.setHorizontalAlignment(SwingConstants.LEFT);
		l1.setFont(new Font("Centaur", Font.BOLD, 16));
		l1.setBounds(667, 140, 97, 40);
		Border border1 =BorderFactory.createLineBorder(Color.gray,5);
		l1.setBorder(border1);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Centaur", Font.BOLD, 16));
		l2.setBounds(771, 140, 136, 40);
		Border border2 =BorderFactory.createLineBorder(Color.gray,5);
		l2.setBorder(border2);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("Centaur", Font.BOLD, 16));
		l3.setBounds(952, 140, 121, 40);
		Border border3 =BorderFactory.createLineBorder(Color.gray,5);
		l3.setBorder(border3);
		frame.getContentPane().add(l3);
		
		JLabel l4 = new JLabel("");
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setFont(new Font("Centaur", Font.BOLD, 16));
		l4.setBounds(793, 220, 149, 40);
		Border border4 =BorderFactory.createLineBorder(Color.gray,5);
		l4.setBorder(border4);
		frame.getContentPane().add(l4);
		
		
		JLabel lunit = new JLabel("");
		lunit.setHorizontalAlignment(SwingConstants.CENTER);
		lunit.setBounds(952, 220, 121, 40);
		Border borderlim =BorderFactory.createLineBorder(Color.gray,5);
		lunit.setBorder(borderlim);
		frame.getContentPane().add(lunit);
		
		
		JLabel l1_1 = new JLabel("");
		l1_1.setHorizontalAlignment(SwingConstants.CENTER);
		l1_1.setFont(new Font("Centaur", Font.BOLD, 22));
		l1_1.setBounds(904, 140, 49, 40);
		frame.getContentPane().add(l1_1);
		
		
		
		JButton conbtn = new JButton("convert");
		conbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if (comboBox.getSelectedItem().equals("Distance")) {
					
					double dst1=Double.parseDouble(textField_1.getText());
					double dst2=Double.parseDouble(textField_2.getText());
					double dst3;
					l1.setText("Distance=");
					l2.setText("Speed ");
					l3.setText("Time");
					l5.setText("Speed");
					l6.setText("Time");
					l1_1.setText("*");
					
					
					dst3=dst1*dst2;
					String value=String.format("%.2f", dst3);
					l4.setText(value);
					lunit.setText("Meter");
				}
				
                     if (comboBox.getSelectedItem().equals("Time")) {
					
					double dst1=Double.parseDouble(textField_1.getText());
					double dst2=Double.parseDouble(textField_2.getText());
					double dst3;
					l1.setText("Time=");
					l2.setText("Distance");
					l3.setText("Speed");
					
					l5.setText("Distance");
					l6.setText("Speed");
					l1_1.setText("/");
					
					dst3=dst1/dst2;
					String value=String.format("%.2f", dst3);
					l4.setText(value);
					lunit.setText("Second");
				}
                     
                     if (comboBox.getSelectedItem().equals("Speed")) {
     					
     					double dst1=Double.parseDouble(textField_1.getText());
     					double dst2=Double.parseDouble(textField_2.getText());
     					double dst3;
     					l1.setText("Speed=");
     					l2.setText("Distance ");
     					l3.setText("Time");
     					
     					l5.setText("Distance");
    					l6.setText("Time");
    					l1_1.setText("/");
     					
     					dst3=dst1/dst2;
     					String value=String.format("%.2f", dst3);
     					l4.setText(value);
     					lunit.setText("Meter/Second");
     				}
			}
		});
		conbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		conbtn.setBounds(822, 87, 120, 42);
		frame.getContentPane().add(conbtn);
		
		JLabel lblNewLabel = new JLabel("Ans:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(697, 220, 97, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnTaninv = new JButton("Tan\u02C4-1");
		btnTaninv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Double opp=Double.parseDouble(textField.getText().)
				double ops=Double.parseDouble(String.valueOf(textField.getText()));
				ops=Math.toRadians(ops);
				ops=Math.atan(ops);
				textField.setText(String.valueOf(ops));
			}
		});
		btnTaninv.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		btnTaninv.setBounds(504, 177, 72, 48);
		frame.getContentPane().add(btnTaninv);
		
	}
}
