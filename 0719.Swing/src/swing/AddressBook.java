package swing;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddressBook extends JFrame {

	// ex1)���̺� ������ ���(�̸�, ��ȭ��ȣ, �ּҸ� ���)

	// �÷� �̸� �迭
	String[] columns = { "�̸�", "��ȭ��ȣ", "�ּ�" };

	// ������ �迭
	String[][] data = { { "�̿��", "01028594121", "����� ������ â��" }, { "����ī", "01012345678", "����� ����� ��赿" },
			{ "����", "01045681235", "����� ���ϱ� ����" }, { "������", "01012857246", "��⵵ �����ν�" } };

	public AddressBook() {
		setBounds(500, 500, 1000, 300);
		// setSize(800,800);
		// setLocation(500,500);
		setTitle("����ó");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ���̺� �� �����
		DefaultTableModel model = new DefaultTableModel(data, columns);
		// ���̺� ���� �̿��ؼ� ���̺��� �����
		JTable table = new JTable(model);

		// �����Ͱ� ó���� ���� ��
		// table.setModel(model);

		// ��� ������ ũ�⺸�� table�� Ŀ������
		// ��ũ�� �ٸ� �̿��� �� �ֵ��� Scroll�� ����
		JScrollPane scrollpane = new JScrollPane(table);
		// ��ũ�� ������ �����ӿ� ����
		add(scrollpane);

		// ũ�⿡ ���缭 ���?
		// pack();

		// // MenuBar ����
		// JMenuBar menubar = new JMenuBar();
		//
		// JMenu file = new JMenu("����(a)");
		// //����Ű ���� ALT + a ������ �޴� ������
		// file.setMnemonic('a');
		//
		// JMenuItem item1 = new JMenuItem("����");
		// file.add(item1);
		//
		// JMenuItem item2 = new JCheckBoxMenuItem("����");
		// file.add(item2);
		//
		// JMenuItem item3 = new JRadioButtonMenuItem("����");
		// file.add(item3);
		//
		//
		//
		// menubar.add(file);
		// // �޴� �ٸ� �����쿡 ����
		// setJMenuBar(menubar);
		//

		JLabel labelname = new JLabel("�̸�");
		JTextField tfname = new JTextField(10);
		JLabel labelphone = new JLabel("��ȭ��ȣ");
		JTextField tfphone = new JTextField(15);
		JLabel labeladdr = new JLabel("�ּ�");
		JTextField tfaddr = new JTextField(30);

		JButton btnInsert = new JButton("����");
		JButton btnDelete = new JButton("����");

		JPanel southPanel = new JPanel();
		southPanel.add(labelname);
		southPanel.add(tfname);
		southPanel.add(labelphone);
		southPanel.add(tfphone);
		southPanel.add(labeladdr);
		southPanel.add(tfaddr);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);

		add("South", southPanel);

		// ���� ��ư�� Ŭ�� �̺�Ʈ(ActionListener)ó��
		ActionListener insertListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �ؽ�Ʈ �ʵ忡 �Էµ� ���� ��������
				String name = tfname.getText();
				String phone = tfphone.getText();
				String addr = tfaddr.getText();

				// �¿� ���� �����ϱ�
				name = name.trim();
				phone = phone.trim();
				addr = addr.trim();

				// name�� �ʼ� �Է�
				//�̸��� �Էµ��� ���� ��� ���̰� 0
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ� �Է�!!!", "�̸�", JOptionPane.WARNING_MESSAGE);
					// �Ʒ����� ���̻� �������� �ʵ��� ����
					return;
				}

				// ���̺��� �����͸� �����ϱ� ���ؼ� ���̺��� ������ ���� ������.
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				// �����͸� �߰��ϱ� ���ؼ� �߰��� ������ �迭�� ����
				String[] row = { name, phone, addr };
				// �𵨿� �߰�
				model.addRow(row);
				// ���̺� ����
				table.updateUI();
				
				tfname.setText("");
				tfphone.setText("");
				tfphone.setText("");
				JOptionPane.showMessageDialog(null, "������ ���� ����","���� �۾�",JOptionPane.PLAIN_MESSAGE);
			}
		};
		btnInsert.addActionListener(insertListener);

		ActionListener deletelistener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				//���̺��� ���� �������� �ʾҴٸ�
				if(idx<0 || idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "���� �����ϼ���!!","���� ����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//���̺��� �� ��������
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				//������ �࿡ �ش��ϴ� ������ �����
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null,"������ ���� ����","����" ,JOptionPane.WARNING_MESSAGE);
				
			}
		};
		btnDelete.addActionListener(deletelistener);
		setVisible(true);

		// // �޽��� ���̾�α� ���
		// JOptionPane.showMessageDialog(null, "�޽��� ���̾�α�", "��ȭ����",
		// JOptionPane.QUESTION_MESSAGE);
		// // ���� ���̾�α� ���
		// int r = JOptionPane.showConfirmDialog(null, "�޽��� ���̾�α�", "��ȭ����",
		// JOptionPane.YES_NO_OPTION);
		//
		// System.out.println(r);
		//
		// // ���� �Է¹޴� ���̾�α� ���
		// String s = JOptionPane.showInputDialog(null, "�޽��� ���̾�α�", "��ȭ����",
		// JOptionPane.YES_NO_OPTION);
		//
		// System.out.println(s);

	}
}
