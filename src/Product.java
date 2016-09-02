import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elite2615
 */
public class Product extends javax.swing.JPanel {
	private String productNum;
	private String productName;
	private String price;
	private String category;
	private String note;

	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * Creates new form product
	 */
	public Product() {
		initComponents();
		setDBProp();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		label_productNum = new javax.swing.JLabel();
		label_productName = new javax.swing.JLabel();
		label_price = new javax.swing.JLabel();
		label_category = new javax.swing.JLabel();
		label_note = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		text_productName = new javax.swing.JTextField();
		text_price = new javax.swing.JTextField();
		dateChooser = new com.toedter.calendar.JDateChooser();
		label_dateTest = new javax.swing.JLabel();
		setPreferredSize(new java.awt.Dimension(980, 470));

		label_productNum.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_productNum.setText("產品編號");

		label_productName.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_productName.setText("品名");

		label_price.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_price.setText("單價");

		label_category.setFont(new Font("微軟正黑體", Font.PLAIN, 15)); // NOI18N
		label_category.setText("類別");

		label_note.setFont(new Font("微軟正黑體", Font.PLAIN, 14)); // NOI18N
		label_note.setText("備註");
		label_note.setToolTipText("");

		text_productName.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N

		text_price.setFont(new java.awt.Font("微軟正黑體", 0, 14));

		label_dateTest.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		label_dateTest.setText("日期測試");
		text_note = new javax.swing.JTextArea();

		text_note.setColumns(20);
		text_note.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
		text_note.setRows(5);

		CBcategory = new JComboBox();
		CBcategory.setModel(new DefaultComboBoxModel(new String[] { "", "奶茶", "紅茶", "綠茶", "咖啡" }));

		label_pNum = new JLabel("");
		label_pNum.setFont(new Font("微軟正黑體", Font.PLAIN, 15));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(66)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_productName).addComponent(label_note)
										.addComponent(label_productNum))
								.addGap(13)
								.addGroup(
										layout.createParallelGroup(Alignment.LEADING).addGroup(layout
												.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(text_productName,
																		GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
																.addGap(18))
														.addGroup(layout.createSequentialGroup().addGap(5)
																.addComponent(label_pNum, GroupLayout.PREFERRED_SIZE,
																		117, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(label_category)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(
																		CBcategory, GroupLayout.PREFERRED_SIZE, 150,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(label_price)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(text_price, GroupLayout.PREFERRED_SIZE,
																		150, GroupLayout.PREFERRED_SIZE))))
												.addComponent(text_note, GroupLayout.DEFAULT_SIZE, 390,
														Short.MAX_VALUE))
								.addGap(156))
								.addGroup(layout.createSequentialGroup().addComponent(label_dateTest).addGap(34)
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 150,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 400,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(295)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(21)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(label_productNum)
										.addComponent(label_price).addComponent(text_price, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_pNum, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(label_productName)
								.addComponent(label_category)
								.addComponent(text_productName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(CBcategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(label_note)
								.addComponent(text_note, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGap(55)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_dateTest))
						.addContainerGap(83, Short.MAX_VALUE)));
		this.setLayout(layout);
	}// </editor-fold>

	private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean getUserInputParm() {
		boolean isRightData = false;

		productName = text_productName.getText();
		price = text_price.getText();
		category = CBcategory.getSelectedItem().toString();
		// category = text_category.getText();
		note = text_note.getText();
		// productName = text_productName.getText();
		if (productName.equals("")) {
			isRightData = false;
		} else {
			isRightData = true;
		}
		return isRightData;
	}

	protected void setInputValue(HashMap<Integer, String> data) {

		label_pNum.setText(data.get(0));
		text_productName.setText(data.get(1));
		text_price.setText((data.get(2)));

		switch (data.get(3)) {
		// "奶茶", "紅茶", "綠茶", "咖啡"
		case "":
			CBcategory.setSelectedIndex(0);
			break;
		case "奶茶":
			CBcategory.setSelectedIndex(1);
			break;
		case "紅茶":
			CBcategory.setSelectedIndex(2);
			break;
		case "綠茶":
			CBcategory.setSelectedIndex(3);
			break;
		case "咖啡":
			CBcategory.setSelectedIndex(4);
			break;
		default:
			CBcategory.setSelectedIndex(0);
			break;
		}
		text_note.setText(data.get(4));
	}

	protected void clearInput() {
		label_pNum.setText("");
		text_productName.setText("");
		text_price.setText("");
		CBcategory.setSelectedIndex(0);
		;
		text_note.setText("");
	}

	protected int insertData() {
		int isInsert = 0;

		try {
			pstmt = con.prepareStatement(

					"INSERT INTO product(productName,price,category,note) VALUES('" + "" + text_productName.getText()
							+ "','" + "" + text_price.getText() + "','" + "" + CBcategory.getSelectedItem() + "','" + ""
							+ text_note.getText() + "')");
			//
			// "INSERT INTO
			// product(productName,price,category,note)VALUES(?,?,?,?)");
			// //pstmt.setString(1, productNum);
			// pstmt.setString(1, productName);
			// pstmt.setString(2, price);
			// pstmt.setString(3, category);
			// pstmt.setString(4, note);
			isInsert = pstmt.executeUpdate();
			pstmt.close();
			clearInput();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		return isInsert;
	}

	protected int updateData() {
		int isUpdate = 0;
		productNum = label_pNum.getText();
		if (getUserInputParm() == true) {
			try {

				pstmt = con.prepareStatement(
						"UPDATE product SET productName=?,price=?,category=?,note=? WHERE productNum=?");
				pstmt.setString(1, productName);
				pstmt.setString(2, price);
				pstmt.setString(3, category);
				pstmt.setString(4, note);
				pstmt.setString(5, productNum);

				isUpdate = pstmt.executeUpdate();

				clearInput();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}

		}
		return isUpdate;
	}

	protected int delData() {
		int isDel = 0;
		productNum = label_pNum.getText();
		if (!productNum.equals("")) {
			try {
				pstmt = con.prepareStatement("DELETE FROM product WHERE productNum=?");
				pstmt.setString(1, productNum);
				isDel = pstmt.executeUpdate();
				clearInput();
			} catch (SQLException ee) {
				System.out.println(ee.toString());
			}
		}
		return isDel;
	}

	protected LinkedList<String[]> queryData() {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];
				row[0] = rs.getString("productNum");
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");

				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	protected LinkedList<String[]> search(String value) {
		LinkedList<String[]> data = new LinkedList<>();
		try {
			pstmt = con.prepareStatement(
					"SELECT * FROM product WHERE productNum LIKE? OR productName LIKE ? OR price LIKE ? OR category LIKE ? OR note LIKE ?");
			String query = "%" + value + "%";
			for (int i = 1; i < 6; i++) {
				pstmt.setString(i, query);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] row = new String[5];

				row[0] = rs.getString("productNum");
				row[1] = rs.getString("productName");
				row[2] = rs.getString("price");
				row[3] = rs.getString("category");
				row[4] = rs.getString("note");
				data.add(row);
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		return data;
	}

	private void txtVendorNumKeyReleased(java.awt.event.KeyEvent evt) {
		String productNum = "";
		try {
			pstmt = con.prepareStatement("SELECT productNum FROM product Where productNum = ?");
			pstmt.setString(1, label_pNum.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				productNum = rs.getString("productNum");
			}
		} catch (SQLException ee) {
			System.out.println(ee.toString());
		}
		if (productNum.equals("")) {
			JOptionPane.showMessageDialog(label_pNum, "查無此商品");
		}
	}

	// Variables declaration - do not modify
	private com.toedter.calendar.JDateChooser dateChooser;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel label_category;
	private javax.swing.JLabel label_dateTest;
	private javax.swing.JLabel label_note;
	private javax.swing.JLabel label_price;
	private javax.swing.JLabel label_productName;
	private javax.swing.JLabel label_productNum;
	private javax.swing.JTextArea text_note;
	private javax.swing.JTextField text_price;
	private javax.swing.JTextField text_productName;
	private JComboBox CBcategory;
	private JLabel label_pNum;
}

// 2016/08/27