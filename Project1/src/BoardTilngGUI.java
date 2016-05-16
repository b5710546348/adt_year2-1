import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BoardTilngGUI {
	private JTextField location_x,location_y;
	
	public static void main(String[] args) {
		BoardTilngGUI gui = new BoardTilngGUI();
		gui.run();
	}
	
	public void run(){
		this.initComponent();
	}
	
	public void initComponent(){
		JFrame frame = new JFrame();
		frame.setTitle("Board Tiling");
		frame.setVisible(true);
		frame.setLocation(100, 100);
		JPanel main_panel = new JPanel();
		main_panel.setLayout(new FlowLayout());
		
		JLabel size_label = new JLabel("Input size");
		main_panel.add(size_label);
		JComboBox choice = new JComboBox();
		choice.addItem("2x2");
		choice.addItem("4x4");
		choice.addItem("8x8");
		choice.addItem("16x16");
		choice.addItem("32x32");
		choice.addItem("64x64");
		
		main_panel.add(choice);
		
		JLabel x = new JLabel(" X ");
		main_panel.add(x);
		location_x = new JTextField(10);
		main_panel.add(location_x);
		JLabel y = new JLabel(" Y ");
		main_panel.add(y);
		location_y = new JTextField(10);
		main_panel.add(location_y);
		
		JButton create = new JButton("Create");
		main_panel.add(create);
		
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = getSize(choice.getSelectedItem().toString());
				try{
					int x = Integer.parseInt(location_x.getText());
					int y = Integer.parseInt(location_y.getText());
					if(x <= size && x > 0 && y <= size && y > 0){
						BoardTiling bt = new BoardTiling(size, x, y);
					}
					else{
						JOptionPane.showMessageDialog(null, "Input only integer in range (0,size].");
					}
				} catch(Exception exception) {
					JOptionPane.showMessageDialog(null, "Input only integer.");
				}
				
				
				
			}
		});
		
		frame.add(main_panel);
		frame.pack();
	}
	public int getSize(String c){
		if(c.equals("2x2")){
			return 2;
		}
		if(c.equals("4x4")){
			return 4;
		}
		if(c.equals("8x8")){
			return 8;
		}
		if(c.equals("16x16")){
			return 16;
		}
		if(c.equals("32x32")){
			return 32;
		}
		else{
			return 64;
		}
	}
}
