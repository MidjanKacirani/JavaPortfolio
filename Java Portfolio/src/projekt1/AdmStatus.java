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

public class AdmStatus extends DritareDytesore implements ActionListener{
	
		JPanel rresht1;
		JPanel rresht2;
		
		JLabel inputLabel;
		JTextField inputNr;
		
		JButton perfunduar;
	
	
		AdmStatus(){
			
			super(3);
			super.setBorder(new GridLayout(3, 1));
			super.mrapa.addActionListener(this);
			
			rresht1 = new JPanel();
			rresht1.setLayout(new FlowLayout());

			inputLabel = new JLabel();
			inputLabel.setText("Vendosni kodin: ");
			inputNr = new JTextField();
			inputNr.setPreferredSize(new Dimension(100, 50));
			rresht1.add(inputLabel);
			rresht1.add(inputNr);
			
			rresht2 = new JPanel();
			perfunduar = new JButton("Vendos");
			perfunduar.setToolTipText("Duke klikuar kete buton, porosia ka mberritur ne destinacion");
			perfunduar.addActionListener(this);
			rresht2.add(perfunduar);
			
			super.shtimKomponent(rresht1);
			super.shtimKomponent(rresht2);
			super.packWindow();
			super.setVisible(true);
		}


		public static void main(String[] args) {
			new AdmStatus();
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==mrapa) {
				super.setVisible(false);
				Administrator dritare = new Administrator();
			}
			
			if(e.getSource() == perfunduar) {
				File objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Porosite e vendosura.txt");
				Scanner objSk;
				ArrayList<String> inputFile = new ArrayList<String>();
				String[] rresht;
				ArrayList<String> nrReferenceInput = new ArrayList<String>();
				ArrayList<String> statusInput = new ArrayList<String>();
				
				try {
					objSk = new Scanner(objFile);
					
					while(objSk.hasNext()) {
						inputFile.add(objSk.nextLine());
					}			
					
					for(int i = 0; i < inputFile.size(); i++) {	
						
						rresht = inputFile.get(i).split(" ");
						nrReferenceInput.add(rresht[0]);
						statusInput.add(rresht[1]);
					
					}
					
					JOptionPane mesazh;
					
					if(nrReferenceInput.contains(inputNr.getText())) {
						
						if(statusInput.get(nrReferenceInput.indexOf(inputNr.getText())).equals("pritje")) {
							statusInput.set(nrReferenceInput.indexOf(inputNr.getText()), "destinacion");
							
							try {
								FileWriter objFileWrite = new FileWriter("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Porosite e vendosura.txt");
								
								for(int i = 0; i < statusInput.size(); i++) {
									objFileWrite.write(nrReferenceInput.get(i) + " " + statusInput.get(i));
									objFileWrite.write("\n");
								}
								
								objFileWrite.flush();
								objFileWrite.close();
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							mesazh = new JOptionPane();
							mesazh.showMessageDialog(null, "Porosia u vendos ne destinacion", "Mesazh", JOptionPane.INFORMATION_MESSAGE);
						}else {
							
							mesazh = new JOptionPane();
							mesazh.showMessageDialog(null, "Porosia eshte ne destinacion", "Mesazh", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
					}else {
						mesazh = new JOptionPane();
						mesazh.showMessageDialog(null, "Nuk ka porosi me ate numer reference", "Mesazh", JOptionPane.ERROR_MESSAGE);
					}
					
				
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
	

	
	
	
}
