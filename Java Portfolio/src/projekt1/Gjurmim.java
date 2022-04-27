package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gjurmim extends DritareDytesore implements ActionListener{

	private JPanel rresht1;
	private JPanel rresht2;
	private JLabel vendosKod;
	private JTextField kodi;
	private JButton kerko;
	
	Gjurmim(){
		
		super(3);
		super.setBorder(new GridLayout(3, 1));
		super.mrapa.addActionListener(this);
		
		rresht1 = new JPanel();
		rresht1.setLayout(new FlowLayout());
		vendosKod = new JLabel("Vendosni kodin: ");
		kodi = new JTextField();
		kodi.setPreferredSize(new Dimension(100, 50));
		rresht1.add(vendosKod);
		rresht1.add(kodi);
	
		rresht2 = new JPanel();
		kerko = new JButton("Kerko");
		kerko.addActionListener(this);
		rresht2.add(kerko);		
	
		super.shtimKomponent(rresht1);
		super.shtimKomponent(rresht2);
		super.packWindow();
		super.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Gjurmim dritare = new Gjurmim();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == mrapa) {
			super.setVisible(false);
			Klient dritare = new Klient();
		}
		
		if(e.getSource() == kerko) {
			
			String inputFushe = kodi.getText();
			
			File objFile = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Porosite e vendosura.txt");
			
			Scanner objSk;
			ArrayList<String> inputFile = new ArrayList<String>();
			String[] rresht;
			ArrayList<String> nrReference = new ArrayList<String>();
			ArrayList<String> status = new ArrayList<String>();
			
			try {
				objSk = new Scanner(objFile);
				
				while(objSk.hasNext()) {
					inputFile.add(objSk.nextLine());
				}
				
				for(String rreshtFile : inputFile) {
					rresht = rreshtFile.split(" ");
					nrReference.add(rresht[0]);
					status.add(rresht[1]);
				}
				
				if(nrReference.contains(inputFushe)) {
					JOptionPane mesazh = new JOptionPane();
					mesazh.showMessageDialog(null, "Porosia eshte ne " + status.get(nrReference.indexOf(inputFushe)), "Rezultati kerkimit", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane mesazh = new JOptionPane();
					mesazh.showMessageDialog(null, "Nuk ka porosi me ate kod ", "Rezultati kerkimit", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
		}
		
		
	}
	
	
	
}
