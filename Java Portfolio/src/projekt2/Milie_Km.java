package projekt2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Milie_Km extends DritareKryesore implements ActionListener{
	
	private JPanel rresht1;
	private JLabel etikete1;
	private JTextField fushe1;
	
	private JButton mrapa;
	private JLabel etiketeKoka;
	private JPanel rreshtFillim;
	
	private JPanel fund;
	
	private JButton llogarit;
	
	private static int menu;
	Milie_Km(int mode){

		super();
		
		menu = mode;
		
		super.setTitle("Konvertues nga milie ne km");
		super.setLayout(new GridLayout(3, 1));
		
		
		rreshtFillim = new JPanel();
		rreshtFillim.setLayout(new FlowLayout());
		rreshtFillim.setPreferredSize(new Dimension(300, 100));
		etiketeKoka = new JLabel();
		etikete1 = new JLabel();
		if(menu == 1) {
			etiketeKoka.setText("Konvertues nga Milie ne km");	
			etikete1.setText("Vendosni madhesine ne Milie: ");
		}
		if(menu == 2) {
			etiketeKoka.setText("Konvertues nga km ne Milie");
			etikete1.setText("Vendosni madhesine ne km: ");
		}
		mrapa = new JButton("Mrapa");
		mrapa.addActionListener(this);
		rreshtFillim.add(mrapa);
		rreshtFillim.add(etiketeKoka);
		
		rresht1 = new JPanel();
		rresht1.setPreferredSize(new Dimension(200, 100));
		rresht1.setLayout(new FlowLayout());
		fushe1 = new JTextField();
		fushe1.setPreferredSize(new Dimension(150, 75));
		rresht1.add(etikete1);
		rresht1.add(fushe1);
	
		fund = new JPanel();
		fund.setPreferredSize(new Dimension(100, 50));
		llogarit = new JButton("Llogarit");
		llogarit.addActionListener(this);
		fund.add(llogarit);
		
		super.shtimKompononent(rreshtFillim);
		super.shtimKompononent(rresht1);
		super.shtimKompononent(fund);
		super.packWindow();
	}
	
	
	public static void main(String[] args) {
		Milie_Km prove = new Milie_Km(1);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==llogarit) {
			try {
				Double rezultati = null;
				if(menu == 1) {
					 rezultati = Double.parseDouble(fushe1.getText()) *  1.609;			
				}
				if(menu == 2) {
					 rezultati = Double.parseDouble(fushe1.getText()) /  1.609
;			
					
				}
		
				JOptionPane mesazh = new JOptionPane();
				mesazh.showMessageDialog(null, "Rezultati eshte: " + rezultati, "Rezultati", JOptionPane.INFORMATION_MESSAGE);	
			}
			catch(Exception e1) {
				JOptionPane mesazh1 = new JOptionPane();
				mesazh1.showMessageDialog(null, "Keni vendosur vlere gabim!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		//	System.out.println(rezultati);
		}else {
			if(e.getSource()==mrapa) {
				super.visibility(false);
				Hyrje dritare = new Hyrje();
			}
		}
		
	}
	
}
