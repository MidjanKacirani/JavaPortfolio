package projekt1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pikaPoste extends DritareDytesore implements ActionListener{

	
	pikaPoste(){
		
		super(2);
		
		super.mrapa.addActionListener(this);
		
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
			for(int i = 0; i < nrRreshtash; i++) {
				for(int j = 0; j < 2; j++) {
					rresht = pikat.get(i).split(" ");
					emriDistanca[i][j] = rresht[j];
				}
			}

			String[] titull = {"Qyteti", "Largesia nga Tirana"};
			
			JTable tabele = new JTable(emriDistanca, titull);
			
			tabele.setBounds(30, 50, 200, 300);
			
			super.shtimKomponent(tabele);
			super.packWindow();
			super.setVisible(true);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		pikaPoste dritare = new pikaPoste();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==mrapa) {
			super.setVisible(false);
			Klient dritare = new Klient();
		}
		
	}
	
}
