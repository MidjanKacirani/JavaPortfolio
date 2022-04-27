package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Klient extends DritareDytesore implements ActionListener{

	JPanel rresht1;
	JButton pikaPoste;
	
	JPanel rresht2;
	JButton llogaritPost;
	
	JPanel rresht3;
	JButton vendosPorosi;
	
	JPanel rresht4;
	JButton gjurmo;
	
	JPanel rresht5;
	JButton info;
Klient(){
	
	super(6);
	
	rresht1 = new JPanel();
	pikaPoste = new JButton("Pikat e postes");
	pikaPoste.addActionListener(this);
	rresht1.add(pikaPoste);
	
	rresht2 = new JPanel();
	llogaritPost = new JButton("Llogarit posten");
	llogaritPost.addActionListener(this);
	rresht2.add(llogaritPost);

	rresht3 = new JPanel();
	vendosPorosi = new JButton("Vendos porosi");
	vendosPorosi.addActionListener(this);
	rresht3.add(vendosPorosi);
	
	rresht4 = new JPanel();
	gjurmo = new JButton("Gjurmo porosi");
	gjurmo.addActionListener(this);
	rresht4.add(gjurmo);
	
	rresht5 = new JPanel();
	info = new JButton("Info");
	info.addActionListener(this);
	rresht5.add(info);
	
	super.mrapa.addActionListener(this);
	
	super.shtimKomponent(rresht1);
	super.shtimKomponent(rresht2);
	super.shtimKomponent(rresht3);
	super.shtimKomponent(rresht4);
	super.shtimKomponent(rresht5);
	super.packWindow();
	super.setVisible(true);
	
}




public static void main(String[] args) {
	Klient dritare = new Klient();
}




@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == mrapa) {
		super.setVisible(false);
		DritareHyrje dritare = new DritareHyrje();
	}
	
	if(e.getSource() == llogaritPost) {
		super.setVisible(false);
		Llogaritje_Porosi dritare = new Llogaritje_Porosi(1);
	}
	
	if(e.getSource() == vendosPorosi) {
		super.setVisible(false);
		Llogaritje_Porosi dritare = new Llogaritje_Porosi(2);
		}
	
	if(e.getSource() == pikaPoste) {
		super.setVisible(false);
		pikaPoste dritare = new pikaPoste();
	}
	
	if(e.getSource() == gjurmo) {
		super.setVisible(false);
		Gjurmim dritare = new Gjurmim();
	}
	
	if(e.getSource() == info) {
		
		File fileObj = new File("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Information.txt");
		try {
			
			Scanner objSk = new Scanner(fileObj);
			String arg = objSk.nextLine();
			
			JOptionPane mesazh = new JOptionPane();
			mesazh.showMessageDialog(null, arg, "Informacion", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
	
}
