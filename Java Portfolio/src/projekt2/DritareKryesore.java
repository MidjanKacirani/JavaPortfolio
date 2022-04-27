package projekt2;
import javax.swing.*;
import java.awt.*;

public class DritareKryesore {

	private JFrame dritare;
	
	DritareKryesore(){
		dritare = new JFrame();
		dritare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dritare.setVisible(true);
	}
	
	public void setTitle(String arg) {
		dritare.setTitle(arg);
	}
	
	public void setLayout(LayoutManager arg) {
		dritare.setLayout(arg);
	}
	
	public void shtimKompononent(Component arg) {
		dritare.add(arg);
	}
	
	public void packWindow() {
		dritare.pack();
	}
	
	public void visibility(boolean arg) {
	
		dritare.setVisible(arg);
		
	}
	
}
