package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Llogaritje_Porosi extends DritareDytesore implements ActionListener, ItemListener{
	
	private	JPanel rresht1;
	private	JPanel rresht2;
	private	JPanel rresht3;
	private JPanel rresht4;
	private	JPanel rresht5;
	
	private	JLabel nisja;
	private	JLabel perfundim;
	private	JLabel pesha;
	private	JLabel lloji;
	
	private	JComboBox<String> nisjaCombo;
	private	JComboBox<String> perfundimCombo;
	private	JComboBox<String> peshaCombo;
	private	JComboBox<String> llojiCombo;
	private	JButton fund;
	

	private double cmimi = 10;
	private double vlera;
	private double kufiza1;
	private double kufiza2;
	private double kufiza3;
	private double kufiza4;
	
	private int mode;
	
	String[] distancaVektor;
	
	Llogaritje_Porosi(int arg){
	
		super(6);
		
		mode = arg;
		
		
		File objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Pikat e postes.txt");
		Scanner objSk1;
		try {
			objSk1 = new Scanner(objFile);
			ArrayList<String> pikat = new ArrayList<String>();
			
			while(objSk1.hasNext()) {
			pikat.add(objSk1.nextLine());	
			}

			int nrRreshtash = pikat.size();
			String[][] emriDistanca = new String[nrRreshtash][2];
			String[] rresht;
			String[] emri = new String[nrRreshtash];
			distancaVektor = new String[nrRreshtash];
			
			for(int i = 0; i < nrRreshtash; i++) {
				for(int j = 0; j < 2; j++) {
					rresht = pikat.get(i).split(" ");
					emriDistanca[i][j] = rresht[j];
				}
				
				emri[i] = emriDistanca[i][0];
				distancaVektor[i] = emriDistanca[i][1];
				
			}
		
		nisjaCombo = new JComboBox<String>(emri);
		nisjaCombo.addItemListener(this);
		perfundimCombo = new JComboBox<String>(emri);
		perfundimCombo.addItemListener(this);
		llojiCombo = new JComboBox<String>(emri);
		llojiCombo.addItemListener(this);
	
		rresht1 = new JPanel();
		rresht1.setLayout(new FlowLayout());
		nisja = new JLabel("Nisja: ");
		rresht1.add(nisja);
		rresht1.add(nisjaCombo);
		
		
		rresht2 = new JPanel();
		rresht2.setLayout(new FlowLayout());
		perfundim = new JLabel("Destinacioni: ");
		rresht2.add(perfundim);
		rresht2.add(perfundimCombo);
		
		rresht3 = new JPanel();
		rresht3.setLayout(new FlowLayout());
		pesha = new JLabel("Pesha ne gr: ");
		String[] peshaVektor = {"1 - 50", "51 - 250", "251 - 500", "500+"};
		peshaCombo = new JComboBox<String>(peshaVektor);
		peshaCombo.addItemListener(this);
		rresht3.add(pesha);
		rresht3.add(peshaCombo);

		rresht4 = new JPanel();
		rresht4.setLayout(new FlowLayout());
		lloji = new JLabel("Pesha ne gr: ");
		String[] llojiVektor = {"Leter", "Pakete e vogel", "Pakete e madhe"};
		llojiCombo = new JComboBox<String>(llojiVektor);
		llojiCombo.addItemListener(this);
		rresht4.add(lloji);
		rresht4.add(llojiCombo);
		
		
		rresht5 = new JPanel();
		fund = new JButton();
		if(mode == 1) {
			fund.setText("Llogarit posten");
		}
		if(mode == 2) {
			fund.setText("Vendos porosine");
		}
		fund.addActionListener(this);

		rresht5.add(fund);
		
		super.shtimKomponent(rresht1);
		super.shtimKomponent(rresht2);
		super.shtimKomponent(rresht3);
		super.shtimKomponent(rresht4);
		super.shtimKomponent(rresht5);
	
		super.packWindow();
		super.setVisible(true);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.mrapa.addActionListener(this);
	
	}
	
	public static void main(String[] args) {
		Llogaritje_Porosi dritare = new Llogaritje_Porosi(2);
	}

	
	public void vendosjeCmimi(double arg) {
		this.cmimi = arg;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == mrapa) {
			super.setVisible(false);
			Klient dritare = new Klient();
		}
				
				if(e.getSource() == fund) {
					
					JOptionPane mesazh = new JOptionPane();
					
					vlera =(double)((Math.abs(kufiza1 - kufiza2) * cmimi) + kufiza3 + kufiza4);
					
					if(mode == 1) {
						mesazh.showMessageDialog(null, "Sherbimi kushton: " + vlera + " leke", "Llogaritje", JOptionPane.INFORMATION_MESSAGE);
					}else {
						
						Integer nrReference; 
						
						
						File objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Porosite e vendosura.txt");
						
						Scanner objSk;
						ArrayList<String> inputFile = new ArrayList<String>();
						String[] rresht;
						ArrayList<String> nrReferenceInput = new ArrayList<String>();
						try {
							objSk = new Scanner(objFile);
							
							while(objSk.hasNext()) {
								inputFile.add(objSk.nextLine());
							}
							
							
							for(int i = 0; i < inputFile.size(); i++) {
								
								
								rresht = inputFile.get(i).split(" ");

								nrReferenceInput.add(rresht[0]);
			
					
								
							}
							
	
							Random objRndm = new Random();
							
							do {
								nrReference = objRndm.nextInt(99999999);
							}while(nrReferenceInput.contains(nrReference.toString()));
							
							inputFile.add(nrReference.toString() + " " + "pritje");
						
							FileWriter objFileWriter;
							
							try {
								objFileWriter = new FileWriter("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Porosite e vendosura.txt");
								
								for(String rreshtFile : inputFile) {
									objFileWriter.write(rreshtFile);
									objFileWriter.write("\n");
								}
								
								objFileWriter.flush();
								objFileWriter.close();

								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							
							mesazh.showMessageDialog(null, "Sherbimi per porosine me numer reference: " + nrReference + ", e vendosur kushton: " + vlera + " leke" , "Porosia u vendos!", JOptionPane.INFORMATION_MESSAGE);

							
							
							
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
					}
				}
				
			
	}
	
	


	@Override
	public void itemStateChanged(ItemEvent e) {

		if(e.getSource() == nisjaCombo) {
			
			kufiza1 =  Double.parseDouble(distancaVektor[nisjaCombo.getSelectedIndex()]) ;
			
		}else {
			
			
			if(e.getSource() == peshaCombo) {
				
				switch(peshaCombo.getSelectedIndex()) {
				
				case 0: {
				
					kufiza3 = 10; 
					break;
				}
				
				case 1: {
					
					kufiza3 = 20; 
					break;
				}
				case 2: {
					
					kufiza3 = 30; 
					break;
				}
				case 3: {
					
					kufiza3 = 40; 
					break;
				}

				}
				
			}else {
				
				if(e.getSource() == llojiCombo) {
					
					switch(llojiCombo.getSelectedIndex()) {
					
					case 0: {
					
						kufiza4 = 100; 
						break;
					}
					
					case 1: {
						
						kufiza4 = 200; 
						break;
					}
					case 2: {
						
						kufiza4 = 300; 
						break;
					}
					

					}
					
					
					
				}else {
					if(e.getSource() == perfundimCombo) {
						kufiza2 = Double.parseDouble(distancaVektor[perfundimCombo.getSelectedIndex()]) ;

					}
				}
				
				
			}
	
		}
		
		
	}
	

}

