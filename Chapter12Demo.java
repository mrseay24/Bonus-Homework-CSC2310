import java.awt.*;
import java.awt.event.*;

// Driver class
public class Chapter12Demo {
	public static void main(String[] args) {
		Frame f = new DemoFrame("Chapter 12 Demo");
		f.setSize(250, 200);
		f.setVisible(true);
	}
}

// Frame class
class DemoFrame extends Frame {
	  private TextField personField;
	  private List personList;

	public DemoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		Panel topPanel = new Panel();
		add("North",topPanel);
		
		topPanel.setLayout(new FlowLayout());
		personField = new TextField();
		personField.setPreferredSize(new Dimension(100, 30));
		topPanel.add(personField);
		Button Botton_add = new Button("Add");
		topPanel.add(Botton_add);
		Botton_add.addActionListener(new Button_add_Listener());
		
		personList = new List();
		add("Center", personList);
		
		addWindowListener(new WindowCloser());
	}

	// Listener for button
	class Button_add_Listener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String personName = personField.getText();
			personField.setText("");
			personList.add(personName);
		}
	}

	  // Listener for window
	  class WindowCloser extends WindowAdapter {
	    public void windowClosing(WindowEvent evt) {
	      System.exit(0);
	    }
	  }
}
