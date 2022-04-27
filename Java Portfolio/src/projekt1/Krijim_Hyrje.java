package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Krijim_Hyrje extends Dritare implements ActionListener {

	
private String emriInput;
private String fjaleInput;
private int mode;
	
private	JPanel rresht1;
private	JPanel rresht2;
private	JPanel rresht3;
private	JPanel rresht4;
private	JPanel rresht5;
	
private	JButton mrapa;
private	JLabel titull;
	
private	JLabel zgjidh;
private	JRadioButton administrator;
private	JRadioButton klient;
	
private	JLabel emri;
private	JTextField emriFusha;
	
private	JLabel fjalekalim;
private	JPasswordField fjaleFusha;
	
private	JButton dergo;
	
	Krijim_Hyrje(int tip){
		
		super();
		super.setBorder(new GridLayout(5, 1));
		
		rresht1 = new JPanel();
		mrapa = new JButton("Mrapa");
		mrapa.addActionListener(this);
		titull = new JLabel();
		if(tip == 1) {
			titull.setText("Krijim Llogarie");
			mode = 1;
		}else {
			if(tip == 2) {
				titull.setText("Hyrje ne Llogari");		
				mode = 2;
			}
		}
		rresht1.setLayout(new FlowLayout());
		rresht1.add(mrapa);
		rresht1.add(titull);
		
		rresht2 = new JPanel();
		zgjidh = new JLabel("Zgjidh: ");
		administrator = new JRadioButton("Administrator");
		administrator.addActionListener(this);
		klient = new JRadioButton("Klient");
		klient.addActionListener(this);
		ButtonGroup grup = new ButtonGroup();
		grup.add(administrator);
		grup.add(klient);
		rresht2.setLayout(new FlowLayout());
		rresht2.add(zgjidh);
		rresht2.add(administrator);
		rresht2.add(klient);

		rresht3 = new JPanel();
		emri = new JLabel("Emri: ");
		emriFusha = new JTextField();
		emriFusha.setPreferredSize(new Dimension(100, 50));
		rresht3.setLayout(new FlowLayout());
		rresht3.add(emri);
		rresht3.add(emriFusha);
	
		rresht4 = new JPanel();
		fjalekalim = new JLabel("Fjalekalimi: ");
		fjaleFusha = new JPasswordField();
		fjaleFusha.setPreferredSize(new Dimension(100, 50));
		rresht4.setLayout(new FlowLayout());
		rresht4.add(fjalekalim);
		rresht4.add(fjaleFusha);
		
		rresht5 = new JPanel();
		dergo = new JButton("Dergo");
		dergo.addActionListener(this);
		rresht5.add(dergo);
		
		
		super.shtimKomponent(rresht1);
		super.shtimKomponent(rresht2);
		super.shtimKomponent(rresht3);
		super.shtimKomponent(rresht4);
		super.shtimKomponent(rresht5);

		super.packWindow();
		super.setVisible(true);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Krijim_Hyrje dritare = new Krijim_Hyrje(1);
	}




	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==mrapa) {
			super.setVisible(false);
			DritareHyrje dritare = new DritareHyrje();
		}else {
			if(e.getSource()==dergo) {
				if(!administrator.isSelected()&&!klient.isSelected()) {
					JOptionPane mesazh = new JOptionPane();
					mesazh.showMessageDialog(null, "Zgjidhni nje pozicion", "Gabim", JOptionPane.ERROR_MESSAGE);
				}else {
					emriInput = emriFusha.getText();
					fjaleInput = fjaleFusha.getText();
					File objFile = null;
					Scanner objSk;
					
					
					if(administrator.isSelected()) {
					
					objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Administrator.txt");
					
					
						ArrayList<String> inputFile = new ArrayList<String>();
						String[] rresht;
						ArrayList<String> emriInput = new ArrayList<String>();
						ArrayList<String> fjaleInput = new ArrayList<String>();

						try {
							objSk = new Scanner(objFile);
							
							while(objSk.hasNext()) {
								inputFile.add(objSk.nextLine());
							}
							
							
							for(int i = 0; i < inputFile.size(); i++) {
								rresht = inputFile.get(i).split(" ");
								emriInput.add(rresht[0]);
								fjaleInput.add(rresht[1]);
							}
							
							
							if(mode == 1) {
								
								
								if(emriInput.contains(emriFusha.getText())) {
									
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Ekziston nje administrator me kete emer", "Vendosni emer tjeter", JOptionPane.ERROR_MESSAGE);
									
								}else{
									
									emriInput.add(emriFusha.getText());
									fjaleInput.add(fjaleFusha.getText());
									
									FileWriter objFileWrite;
									try {
										objFileWrite = new FileWriter("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Administrator.txt");
										for(int i = 0; i < fjaleInput.size(); i++) {
											
											objFileWrite.write(emriInput.get(i) + " " + fjaleInput.get(i));
											objFileWrite.write("\n");
											
										}
										objFileWrite.flush();
										objFileWrite.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
													
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Rregjistrimi u be me sukses", "Sukses", JOptionPane.INFORMATION_MESSAGE);
									this.dritare1.setVisible(false);
									Administrator dritare = new Administrator();
								}
								
								
							}else {
								
								if(inputFile.contains(emriFusha.getText() + " " + fjaleFusha.getText())) {
									this.dritare1.setVisible(false);
									Administrator dritare = new Administrator();
									
								}else {
								
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Nuk ekziston nje administrator me ato te dhena", "Vendosni te dhena te sakta", JOptionPane.ERROR_MESSAGE);
									
								}
								
							}
							
						
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					}
					
					
					if(klient.isSelected()) {
						
						objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Klient.txt");
						
						
						ArrayList<String> inputFile = new ArrayList<String>();
						String[] rresht;
						ArrayList<String> emriInput = new ArrayList<String>();
						ArrayList<String> fjaleInput = new ArrayList<String>();

						try {
							objSk = new Scanner(objFile);
							
							while(objSk.hasNext()) {
								inputFile.add(objSk.nextLine());
							}
							
							
							for(int i = 0; i < inputFile.size(); i++) {
								rresht = inputFile.get(i).split(" ");
								emriInput.add(rresht[0]);
								fjaleInput.add(rresht[1]);
							}
							
							
							if(mode == 1) {
								
								
								if(emriInput.contains(emriFusha.getText())) {
									
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Ekziston nje klient me kete emer", "Vendosni emer tjeter", JOptionPane.ERROR_MESSAGE);
									
								}else{
									
									emriInput.add(emriFusha.getText());
									fjaleInput.add(fjaleFusha.getText());
									
									FileWriter objFileWrite;
									try {
										objFileWrite = new FileWriter("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Klient.txt");
										for(int i = 0; i < fjaleInput.size(); i++) {
											
											objFileWrite.write(emriInput.get(i) + " " + fjaleInput.get(i));
											objFileWrite.write("\n");
											
										}
										objFileWrite.flush();
										objFileWrite.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
													
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Rregjistrimi u be me sukses", "Sukses", JOptionPane.INFORMATION_MESSAGE);
									this.dritare1.setVisible(false);
									Klient dritare = new Klient();
				
								}
								
								
							}else {
								
								if(inputFile.contains(emriFusha.getText() + " " + fjaleFusha.getText())) {
									
									this.dritare1.setVisible(false);
									Klient dritare = new Klient();
									
								}else {
								
									JOptionPane mesazh = new JOptionPane();
									mesazh.showMessageDialog(null,  "Nuk ekziston nje klient me ato te dhena", "Vendosni te dhena te sakta", JOptionPane.ERROR_MESSAGE);
									
								}
								
							}
							
						
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						
						
						
					}
					
				
					
				}

				
				
				
			}
		}
		
		
		
	}
	
}
