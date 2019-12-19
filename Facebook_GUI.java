import java.awt.*;
import java.awt.event.*;

// Driver class
public class Facebook_GUI {
	public static void main(String[] args) {
		Frame f = new DemoFrame("Facebook_GUI");
		f.setSize(600, 500);
		f.setVisible(true);
	}
}

// Frame class
class DemoFrame extends Frame {
	private TextField personField;
	private List personList;
	private TextField moodField;
	Panel centerPanel = new Panel();
	private Label dMood;
	private String personMood;

	public DemoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());

		Panel topPanel = new Panel();
		add("North", topPanel);

		// Top Panel
		topPanel.setLayout(new FlowLayout());
		Label Name = new Label("Name:");
		String labelContents = Name.getText();
		topPanel.add(Name);

		personField = new TextField();
		personField.setPreferredSize(new Dimension(100, 30));
		topPanel.add(personField);

		Button addPerson = new Button("Add Person");
		topPanel.add(addPerson);
		addPerson.addActionListener(new addPerson());

		// South Panel
		Panel bottomPanel = new Panel();
		add("South", bottomPanel);

		bottomPanel.setLayout(new FlowLayout());
		Label Mood = new Label("New Mood:");
		String labelContents1 = Mood.getText();
		bottomPanel.add(Mood);

		moodField = new TextField();
		moodField.setPreferredSize(new Dimension(100, 30));
		bottomPanel.add(moodField);

		Button changeMood = new Button("Change Mood");
		bottomPanel.add(changeMood);
		changeMood.addActionListener(new changeMood());

		// West Panel
		personList = new List();
		add("West", personList);

		// Center Panel

		add("Center", centerPanel);
		// centerPanel.setLayout(new FlowLayout());
		centerPanel.setBackground(Color.lightGray);
		dMood = new Label("default_Mood");
		//String labelContents3 = dMood.getText();
		centerPanel.add(dMood);

		addWindowListener(new WindowCloser());
	}

	// Listener for button
	class addPerson implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String personName = personField.getText();
			//FacebookPerson_Graphics fbg = new FacebookPerson_Graphics(personName);
			
			//make fb_g object and use the name provided + default mood
		personField.setText("");
				personList.add(personName);
				//personList.addItemListener(new clickedItem());
	centerPanel.setBackground(Color.lightGray);
		dMood.setText("default_Mood");
			//String labelContents3 = dMood.getText();
		centerPanel.add(dMood);

		}
	}
	
	/**class clickedItem implements java.awt.event.ItemListener {
		///when a user item is clicked
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			int userIndex = personList.getSelectedIndex();
//			System.out.println("Person # " + userIndex + " got clicked");
			for(int i = 0; i < personList.getItemCount(); i++){
				if (personList.getItemCount() == i){
					
				}
				
			}
		}
	}*/

	// Listener for button
	class changeMood implements ActionListener {
		public void actionPerformed(ActionEvent evt) {

			personMood = moodField.getText();
			// javax.swing.JOptionPane.showMessageDialog(null,
			// "Mood field is "+personMood );
			moodField.setText("");
			// centerPanel.add(personMood);
			
			if (personMood.equals("happy")) {
				// javax.swing.JOptionPane.showMessageDialog(null, "HAPPY!" );
				centerPanel.setBackground(Color.RED);
				//dMood = new Label(personMood, Label.CENTER);
				//dMood.getText();
				dMood.setText(personMood);
				//String labelContents3 = dMood.getText();
				// dMood.getText("Enter first name:");
				centerPanel.add(dMood);
			} else {
				
				centerPanel.setBackground(Color.lightGray);
				//Label dMood2 = new Label(moodField.getText());
				dMood.setText(personMood);
				//String labelContents4 = dMood.getText();
				centerPanel.add(dMood);
			}

		}

	}

	// Listener for window
	class WindowCloser extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}

}