package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;


public class AdmInfo extends DritareDytesore implements ActionListener{

	JPanel info;
	JLabel infoTekst;
	JTextArea tekst;
	
	JScrollPane ashensore;
	
	JPanel fund;
	JButton vendos;
	
	
	
AdmInfo(){
	
	super(3);
	super.setBorder(new GridLayout(4, 1));
	super.mrapa.addActionListener(this);
	
	
	info = new JPanel();
	infoTekst = new JLabel("Vendosni informacionin e ri");
	info.add(infoTekst);
	
	tekst = new JTextArea(25, 50);
	ashensore = new JScrollPane(tekst, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	

	fund = new JPanel();
	vendos = new JButton("Vendos Informacionin");
	vendos.addActionListener(this);
	fund.add(vendos);
	
	super.shtimKomponent(info);
	super.shtimKomponent(ashensore);
	super.shtimKomponent(fund);
	
	super.dritare1.setSize(500, 300);
	//super.packWindow();
	super.setVisible(true);
	
	
}

public static void main(String[] args) {
	AdmInfo dritare = new AdmInfo();
}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource() == mrapa) {
		super.setVisible(false);
		Administrator dritare = new Administrator();
	}
	
	if(e.getSource() == vendos) {
		
		
		String input = tekst.getText();
		
		if(input == null) {
			JOptionPane mesazh = new JOptionPane();
			mesazh.showMessageDialog(null, "Vendosni tekst", "GABIM", JOptionPane.ERROR_MESSAGE);
		}else {
			
			FileWriter objFile;
			try {
				objFile = new FileWriter("C:\\Users\\Dell\\Documents\\Midjan\\Java Portfolio\\src\\projekt1\\Information.txt");
				objFile.write(input);

				objFile.flush();
				objFile.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			JOptionPane mesazh = new JOptionPane();
			mesazh.showMessageDialog(null, "Informacioni u vendos me sukses", "", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		
	}
	
	
}
	
	
}
