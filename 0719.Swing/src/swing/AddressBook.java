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

	// ex1)테이블에 데이터 출력(이름, 전화번호, 주소를 출력)

	// 컬럼 이름 배열
	String[] columns = { "이름", "전화번호", "주소" };

	// 데이터 배열
	String[][] data = { { "이우미", "01028594121", "서울시 도봉구 창동" }, { "제시카", "01012345678", "서울시 노원구 상계동" },
			{ "수지", "01045681235", "서울시 강북구 번동" }, { "아이유", "01012857246", "경기도 의정부시" } };

	public AddressBook() {
		setBounds(500, 500, 1000, 300);
		// setSize(800,800);
		// setLocation(500,500);
		setTitle("연락처");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 테이블 모델 만들기
		DefaultTableModel model = new DefaultTableModel(data, columns);
		// 테이블 모델을 이용해서 테이블을 만들기
		JTable table = new JTable(model);

		// 데이터가 처음에 없을 때
		// table.setModel(model);

		// 출력 영역의 크기보다 table이 커지더라도
		// 스크롤 바를 이용할 수 있도록 Scroll을 생성
		JScrollPane scrollpane = new JScrollPane(table);
		// 스크롤 페인을 프레임에 부착
		add(scrollpane);

		// 크기에 맞춰서 출력?
		// pack();

		// // MenuBar 생성
		// JMenuBar menubar = new JMenuBar();
		//
		// JMenu file = new JMenu("파일(a)");
		// //단축키 설정 ALT + a 누르면 메뉴 펼쳐짐
		// file.setMnemonic('a');
		//
		// JMenuItem item1 = new JMenuItem("열기");
		// file.add(item1);
		//
		// JMenuItem item2 = new JCheckBoxMenuItem("저장");
		// file.add(item2);
		//
		// JMenuItem item3 = new JRadioButtonMenuItem("삭제");
		// file.add(item3);
		//
		//
		//
		// menubar.add(file);
		// // 메뉴 바를 윈도우에 부착
		// setJMenuBar(menubar);
		//

		JLabel labelname = new JLabel("이름");
		JTextField tfname = new JTextField(10);
		JLabel labelphone = new JLabel("전화번호");
		JTextField tfphone = new JTextField(15);
		JLabel labeladdr = new JLabel("주소");
		JTextField tfaddr = new JTextField(30);

		JButton btnInsert = new JButton("삽입");
		JButton btnDelete = new JButton("삭제");

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

		// 삽입 버튼의 클릭 이벤트(ActionListener)처리
		ActionListener insertListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드에 입력된 내용 가져오기
				String name = tfname.getText();
				String phone = tfphone.getText();
				String addr = tfaddr.getText();

				// 좌우 공백 제거하기
				name = name.trim();
				phone = phone.trim();
				addr = addr.trim();

				// name의 필수 입력
				//이름이 입력되지 않은 경우 길이가 0
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "이름은 필수 입력!!!", "이름", JOptionPane.WARNING_MESSAGE);
					// 아래쪽을 더이상 수행하지 않도록 리턴
					return;
				}

				// 테이블의 데이터를 편집하기 위해서 테이블의 데이터 모델을 가져옴.
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				// 데이터를 추가하기 위해서 추가할 데이터 배열을 생성
				String[] row = { name, phone, addr };
				// 모델에 추가
				model.addRow(row);
				// 테이블 갱신
				table.updateUI();
				
				tfname.setText("");
				tfphone.setText("");
				tfphone.setText("");
				JOptionPane.showMessageDialog(null, "데이터 삽입 성공","삽입 작업",JOptionPane.PLAIN_MESSAGE);
			}
		};
		btnInsert.addActionListener(insertListener);

		ActionListener deletelistener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				//테이블에서 행을 선택하지 않았다면
				if(idx<0 || idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "행을 선택하세요!!","삭제 실패",JOptionPane.WARNING_MESSAGE);
					return;
				}
				//테이블의 모델 가져오기
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				//선택한 행에 해당하는 데이터 지우기
				model.removeRow(idx);
				table.updateUI();
				JOptionPane.showMessageDialog(null,"데이터 삭제 성공","삭제" ,JOptionPane.WARNING_MESSAGE);
				
			}
		};
		btnDelete.addActionListener(deletelistener);
		setVisible(true);

		// // 메시지 다이얼로그 출력
		// JOptionPane.showMessageDialog(null, "메시지 다이얼로그", "대화상자",
		// JOptionPane.QUESTION_MESSAGE);
		// // 선택 다이얼로그 출력
		// int r = JOptionPane.showConfirmDialog(null, "메시지 다이얼로그", "대화상자",
		// JOptionPane.YES_NO_OPTION);
		//
		// System.out.println(r);
		//
		// // 한줄 입력받는 다이얼로그 출력
		// String s = JOptionPane.showInputDialog(null, "메시지 다이얼로그", "대화상자",
		// JOptionPane.YES_NO_OPTION);
		//
		// System.out.println(s);

	}
}
