package projekt1;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class DritareHyrje extends Dritare implements ActionListener{

	private JPanel rresht1;
	private JButton krijim;

	
	private	JPanel rresht2;
	private JButton hyrje;
	
	
DritareHyrje(){

	super();
	super.setTitle("Sherbimi i postes online");
	super.setBorder(new GridLayout(2, 1));
	
	
	rresht1 = new JPanel();
	rresht1.setLayout(new BorderLayout());
	krijim = new JButton("Krijim llogarie");
	krijim.addActionListener(this);
	rresht1.add(krijim, BorderLayout.CENTER);

	
	rresht2 = new JPanel();
	rresht2.setLayout(new BorderLayout());
	hyrje = new JButton("Hyrje ne llogarie");
	hyrje.addActionListener(this);
	rresht2.add(hyrje, BorderLayout.CENTER);
	
	super.shtimKomponent(rresht1);
	super.shtimKomponent(rresht2);
	super.packWindow();

	super.setVisible(true);
	
}

public static void main(String[] args) {
	DritareHyrje dritare = new DritareHyrje();
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==krijim) {
		super.setVisible(false);
		Krijim_Hyrje dritare = new Krijim_Hyrje(1);
		
	}
	if(e.getSource()==hyrje) {
		super.setVisible(false);
		Krijim_Hyrje dritare = new Krijim_Hyrje(2);
	}
	
}



}
