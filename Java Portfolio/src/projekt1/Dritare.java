package projekt1;
import javax.swing.*;
import java.awt.*;


public class Dritare {

	protected JFrame dritare1;
	
	Dritare(){
		
	dritare1 = new JFrame();
	dritare1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	dritare1.setSize(1280, 720);
	}
	
	public void setTitle(String arg) {
		dritare1.setTitle(arg);
	}
	
	public void setVisible(boolean arg) {
		dritare1.setVisible(arg);
	}
	
	public void setBorder(LayoutManager boder) {
		dritare1.setLayout(boder);
	}
	
	public void packWindow() {
		dritare1.pack();
	}
	
	public void shtimKomponent(Component arg) {
		dritare1.add(arg);
	}
	
}
