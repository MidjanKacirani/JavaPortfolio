package projekt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Administrator extends DritareDytesore implements ActionListener{
	
private	JPanel percaktoStatus;
private	JButton status;
	
private	JPanel vendosInfo;
private	JButton info;
	
	Administrator(){
		
		super(3);
		super.mrapa.addActionListener(this);
		super.setBorder(new GridLayout(3, 1));
		
		percaktoStatus = new JPanel();
		status = new JButton("Percakto statusin e porosise");
		status.addActionListener(this);
		percaktoStatus.add(status);
		
		vendosInfo = new JPanel();
		info = new JButton("Shpall informacion");
		info.addActionListener(this);
		vendosInfo.add(info);
		
		super.shtimKomponent(percaktoStatus);
		super.shtimKomponent(vendosInfo);
		super.packWindow();
		super.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		Administrator dritare = new Administrator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

			if(e.getSource() == mrapa) {
				super.setVisible(false);
				DritareHyrje dritare = new DritareHyrje();	
			}
			
			if(e.getSource() == status) {
				super.setVisible(false);
				AdmStatus dritare = new AdmStatus();
				
			}
			
			if(e.getSource() == info) {
				super.setVisible(false);
				AdmInfo dritare = new AdmInfo();
				
			}

}
}
