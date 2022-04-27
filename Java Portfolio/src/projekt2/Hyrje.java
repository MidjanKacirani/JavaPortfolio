package projekt2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hyrje extends DritareKryesore implements ActionListener{

private	JButton buton1;
private	JButton buton2;
private	JButton buton3;
	
	Hyrje(){
		
		super();
		super.setTitle("Faqja kryesore");
		super.setLayout(new GridLayout(3, 1));
		
		buton1 = new JButton("Konvertim Milie - Km");
		buton1.setPreferredSize(new Dimension(200, 100));
		buton1.addActionListener(this);
		
		buton2 = new JButton("Konvertim Km - Milie");
		buton2.setPreferredSize(new Dimension(200, 100));
		buton2.addActionListener(this);

		buton3 = new JButton("Info");
		buton3.setPreferredSize(new Dimension(200, 100));
		buton3.addActionListener(this);

		
		super.shtimKompononent(buton1);
		super.shtimKompononent(buton2);
		super.shtimKompononent(buton3);
		super.packWindow();
	}
	
	public static void main(String[] args) {
		Hyrje dritare = new Hyrje();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==buton1) {
			super.visibility(false);
			Milie_Km buton1 = new Milie_Km(1);
		}else {
			if(e.getSource()==buton2) {
				Milie_Km buton1 = new Milie_Km(2);
				
			}else {
				JOptionPane mesazh = new JOptionPane();
				mesazh.showMessageDialog(null,  "Konvertues i zhvilluar nga Midjan Kaçirani", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
}
