package swing;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class MyWindow1 extends JFrame {
	String[] data = { "Encapsulation", "Inhoritance", "Polymorphism", "Information Hiding" };

	public MyWindow1() {
		setBounds(200, 200, 800, 800);
		setTitle("스윙");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JList<String> list = new JList<>(data);
		JComboBox<String> combo = new JComboBox<>(data);
		
		JPanel p = new JPanel();

		JLabel label = new JLabel();
		label.setText("선택해 주세요.");

		p.add(label);
		p.add(list);
		p.add(combo);
		

		JButton btn = new JButton("버튼");

		p.add(btn);

		add(p);

		setVisible(true);
	}
}
