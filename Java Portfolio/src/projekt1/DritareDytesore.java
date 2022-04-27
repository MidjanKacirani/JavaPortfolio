package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DritareDytesore extends Dritare{

	protected JButton mrapa;
	private JLabel titull;
	private JPanel rresht1;
	
	DritareDytesore(int permasa){
		
		super();
		super.setBorder(new GridLayout(permasa, 1));
		mrapa = new JButton("mrapa");
		titull = new JLabel("Dil mrapa");
		rresht1 = new JPanel();
		rresht1.add(mrapa);
		rresht1.add(titull);
		
		super.shtimKomponent(rresht1);
	}
	
	
}
