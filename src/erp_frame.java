﻿

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class erp_frame extends JFrame {
    private CardLayout nowLayout;
    private EmptyPanel empty;
    private Employee employee;
    private Attendance attendance;
    private PayRoll payRoll;
    private Achievement achievement;
    private Material material;
    private OrderList orderList;
    private OrderItem orderItem;
    private Issue issue;
    private Vendor vendor;
    
    private myTableModel tableModel;
    public LinkedList<String[]> data;
    String[] fields;
    String[] employeeFields = {"員工編號","姓名","地址","電話","性別","生日","職等","部門","備註"};
    String[] attendanceFields = {"編號","員工編號","上班打卡","下班打卡","假別","部門","備註"};
    String[] achivevmentFields = {"編號","員工編號","年月份","考績","備註"};
    String[] payRollFields = {"員工編號","薪資","備註"};
    String[] materialFields = {"原料編號","原料名稱","數量","進貨廠商編號","備註"};
    
    String[] issueFields = {"客戶編號","客訴內容","金額","備註"};
    String[] vendorFields = {"廠商編號","廠商名稱","電話","地址","統編","聯絡人","付款條件","備註"};
    String[] orderListFields = {"訂單編號","客戶編號","下單日期","狀態","配送方式","備註"};
    String[] orderItemFields = {"訂單編號","產品編號","數量","備註"};
    
    
    String path = null;
    public erp_frame() {
        initComponents();
        init();
        empty = new EmptyPanel();
        employee = new Employee();
        attendance = new Attendance();
        payRoll = new PayRoll();
        achievement = new Achievement();
        material = new Material();
        orderList = new OrderList();
        orderItem = new OrderItem();
        issue = new Issue();
        vendor = new Vendor();
        
        
        panel_dataInput.add("empty",empty);
        panel_dataInput.add("employee",employee);
        panel_dataInput.add("attendance", attendance);
        panel_dataInput.add("payRoll", payRoll);
        panel_dataInput.add("achievement", achievement);
        panel_dataInput.add("material", material);
        panel_dataInput.add("orderList", orderList);
        panel_dataInput.add("orderItem", orderItem);
        panel_dataInput.add("issue", issue);
        panel_dataInput.add("vendor", vendor);
//       setExtendedState(JFrame.MAXIMIZED_BOTH); 
        data = new LinkedList<>();
        
    }
    private void init(){
        setResizable(false);
        setLocationRelativeTo(null);//置中
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/drink.png")));
        setTitle("公司名稱 : 休閒小棧 使用者名稱 : OOO 使用者代碼 : A123456789");
        
        DefaultTableCellRenderer tableAlign = (DefaultTableCellRenderer)table_firmData.getTableHeader().getDefaultRenderer(); //欄位置中
        tableAlign.setHorizontalAlignment(SwingConstants.CENTER);
        
        nowLayout = new CardLayout();       
        panel_dataInput.setLayout(nowLayout);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_folder = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeFolder = new javax.swing.JTree();
        panel_dataInput = new javax.swing.JPanel();
        panel_dataShow = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_firmData = new javax.swing.JTable();
        text_search = new javax.swing.JTextField();
        label_search = new javax.swing.JLabel();
        JToolBar = new javax.swing.JToolBar();
        btnFirstData = new javax.swing.JButton();
        btnPreData = new javax.swing.JButton();
        btnNextData = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 1024));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_folder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        treeFolder.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
//create tree with root, category, sheet
        javax.swing.tree.DefaultMutableTreeNode ERP = new javax.swing.tree.DefaultMutableTreeNode("ERP");
        
        javax.swing.tree.DefaultMutableTreeNode DB_hr = new javax.swing.tree.DefaultMutableTreeNode("人事資料庫");
        javax.swing.tree.DefaultMutableTreeNode employee = new javax.swing.tree.DefaultMutableTreeNode("員工資料表");
        DB_hr.add(employee);
        javax.swing.tree.DefaultMutableTreeNode achievement = new javax.swing.tree.DefaultMutableTreeNode("員工考績表");
        DB_hr.add(achievement);
        javax.swing.tree.DefaultMutableTreeNode attendance = new javax.swing.tree.DefaultMutableTreeNode("出缺勤表");
        DB_hr.add(attendance);
        javax.swing.tree.DefaultMutableTreeNode payRoll = new javax.swing.tree.DefaultMutableTreeNode("薪資表");
        DB_hr.add(payRoll);
        ERP.add(DB_hr); 
        
        javax.swing.tree.DefaultMutableTreeNode DB_Purchase = new javax.swing.tree.DefaultMutableTreeNode("採購資料庫");
        javax.swing.tree.DefaultMutableTreeNode purchaseSheet = new javax.swing.tree.DefaultMutableTreeNode("進貨表");
        DB_Purchase.add(purchaseSheet);
        ERP.add(DB_Purchase);
        
        javax.swing.tree.DefaultMutableTreeNode DB_Product = new javax.swing.tree.DefaultMutableTreeNode("產品資料庫");
        javax.swing.tree.DefaultMutableTreeNode productSheet = new javax.swing.tree.DefaultMutableTreeNode("產品資料表");
        DB_Product.add(productSheet);
        ERP.add(DB_Product);
   
        javax.swing.tree.DefaultMutableTreeNode DB_Material = new javax.swing.tree.DefaultMutableTreeNode("庫存資料庫");
        javax.swing.tree.DefaultMutableTreeNode MaterialSheet = new javax.swing.tree.DefaultMutableTreeNode("原料庫存資料表");
        DB_Material.add(MaterialSheet);
        ERP.add(DB_Material);

        
        javax.swing.tree.DefaultMutableTreeNode DB_Sales = new javax.swing.tree.DefaultMutableTreeNode("銷售資料庫");
        javax.swing.tree.DefaultMutableTreeNode orderList = new javax.swing.tree.DefaultMutableTreeNode("訂單資料表");
        javax.swing.tree.DefaultMutableTreeNode orderItem = new javax.swing.tree.DefaultMutableTreeNode("訂單項目資料表");
        javax.swing.tree.DefaultMutableTreeNode issue = new javax.swing.tree.DefaultMutableTreeNode("異常紀錄表");
        javax.swing.tree.DefaultMutableTreeNode vendor = new javax.swing.tree.DefaultMutableTreeNode("廠商資料表");
        DB_Sales.add(orderList);
        DB_Sales.add(orderItem);
        DB_Sales.add(issue);
        DB_Sales.add(vendor);
        ERP.add(DB_Sales);
        
        javax.swing.tree.DefaultMutableTreeNode DB_Account = new javax.swing.tree.DefaultMutableTreeNode("會計資料庫");
        javax.swing.tree.DefaultMutableTreeNode payableList = new javax.swing.tree.DefaultMutableTreeNode("應付帳款管理表");
        javax.swing.tree.DefaultMutableTreeNode Asset = new javax.swing.tree.DefaultMutableTreeNode("資產管理表");
        DB_Account.add(payableList);
        DB_Account.add(Asset); 
        ERP.add(DB_Account);
  
        javax.swing.tree.DefaultMutableTreeNode DB_Customer = new javax.swing.tree.DefaultMutableTreeNode("客戶資料庫");
        javax.swing.tree.DefaultMutableTreeNode CustomerList = new javax.swing.tree.DefaultMutableTreeNode("客戶資料表");
        DB_Customer.add(CustomerList);
        ERP.add(DB_Customer);
     
        javax.swing.tree.DefaultMutableTreeNode DB_System = new javax.swing.tree.DefaultMutableTreeNode("系統管理庫");
        javax.swing.tree.DefaultMutableTreeNode admin = new javax.swing.tree.DefaultMutableTreeNode("帳號管理表");
        javax.swing.tree.DefaultMutableTreeNode billboard = new javax.swing.tree.DefaultMutableTreeNode("公告管理表");
        javax.swing.tree.DefaultMutableTreeNode department = new javax.swing.tree.DefaultMutableTreeNode("部門管理表");
        DB_System.add(admin);
        DB_System.add(billboard);  
        DB_System.add(department);
        ERP.add(DB_System);
        treeFolder.setModel(new javax.swing.tree.DefaultTreeModel(ERP));
        treeFolder.setRowHeight(30);
        treeFolder.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeFolderValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeFolder);

        javax.swing.GroupLayout panel_folderLayout = new javax.swing.GroupLayout(panel_folder);
        panel_folder.setLayout(panel_folderLayout);
        panel_folderLayout.setHorizontalGroup(
            panel_folderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );
        panel_folderLayout.setVerticalGroup(
            panel_folderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );

        getContentPane().add(panel_folder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 1024));

        panel_dataInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_dataInput.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel_dataInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 980, 470));

        panel_dataShow.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_dataShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        table_firmData.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        table_firmData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "廠商名稱", "聯絡電話", "地址", "統編", "聯絡人", "付款條件", "備註"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_firmData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_firmDataMouseClicked(evt);
            }
        });
        
        jScrollPane3.setViewportView(table_firmData);

        panel_dataShow.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 980, 460));
        text_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_searchKeyReleased(evt);
            }
        });
        panel_dataShow.add(text_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, 25));

        label_search.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
        label_search.setLabelFor(text_search);
        label_search.setText("搜尋 : ");
        panel_dataShow.add(label_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        getContentPane().add(panel_dataShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 980, 500));

        JToolBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JToolBar.setRollover(true);
        JToolBar.setAlignmentY(0.5F);
        JToolBar.setMaximumSize(new java.awt.Dimension(80, 50));
        JToolBar.setMinimumSize(new java.awt.Dimension(80, 50));
        JToolBar.setPreferredSize(new java.awt.Dimension(80, 50));

        btnFirstData.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnFirstData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/left-arrow-2.png"))); // NOI18N
        btnFirstData.setToolTipText("第一筆");
        btnFirstData.setPreferredSize(new java.awt.Dimension(80, 50));
        btnFirstData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFirstDataMouseClicked(evt);
            }
        });
        JToolBar.add(btnFirstData);

        btnPreData.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnPreData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/left-arrow.png"))); // NOI18N
        btnPreData.setToolTipText("上一筆");
        btnPreData.setPreferredSize(new java.awt.Dimension(80, 50));
        btnPreData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreDataMouseClicked(evt);
            }
        });
        JToolBar.add(btnPreData);

        btnNextData.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnNextData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        btnNextData.setToolTipText("下一筆");
        btnNextData.setPreferredSize(new java.awt.Dimension(80, 50));
        btnNextData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextDataMouseClicked(evt);
            }
        });
        JToolBar.add(btnNextData);

        btnInsert.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/insert.png"))); // NOI18N
        btnInsert.setToolTipText("新增資料");
        btnInsert.setPreferredSize(new java.awt.Dimension(80, 50));
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });
        JToolBar.add(btnInsert);

        btnModify.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        btnModify.setToolTipText("修改資料");
        btnModify.setPreferredSize(new java.awt.Dimension(80, 50));
        btnModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifyMouseClicked(evt);
            }
        });
        JToolBar.add(btnModify);
        btnModify.getAccessibleContext().setAccessibleDescription("");

        btnClear.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clear.png"))); // NOI18N
        btnClear.setToolTipText("清空輸入");
        btnClear.setPreferredSize(new java.awt.Dimension(80, 50));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        JToolBar.add(btnClear);

        btnExport.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/export.png"))); // NOI18N
        btnExport.setToolTipText("匯出");
        btnExport.setPreferredSize(new java.awt.Dimension(80, 50));
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        JToolBar.add(btnExport);

        btnDelete.setFont(new java.awt.Font("微軟正黑體", 0, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnDelete.setToolTipText("刪除資料");
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 50));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        JToolBar.add(btnDelete);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout.png"))); // NOI18N
        btnLogout.setToolTipText("登出");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        JToolBar.add(btnLogout);

        getContentPane().add(JToolBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 980, 50));

        pack();
        setLocationRelativeTo(null);
    }
    
    class myTableModel extends DefaultTableModel{
    	public myTableModel(String[] fields){
    		super(fields,0);
    	}
    	
    	 @Override
         public int getRowCount() {
            return data.size();
         }

         @Override
         public int getColumnCount() {
        	 int length = 0;
        	 if(path != null){
        		 switch(path){
                	case "員工資料表":
                		length = employeeFields.length;
             		break;
                	case "出缺勤表":
                		length = attendanceFields.length;
                		break;
                	case "員工考績表":
                		length = achivevmentFields.length;
                		break;
                	case "薪資表":
                		length = payRollFields.length;
                		break;
                	case "原料庫存資料表":
                		length = materialFields.length;
                		break;
                	case "訂單資料表":
                		length = orderListFields.length;
                		break;
                	case "訂購項目資料表":
                		length = orderItemFields.length;
                		break;
                	case "異常紀錄表":
                		length = issueFields.length;
                		break;
                	case "廠商資料表":
                		length = vendorFields.length;
                		break;
             	}
        	 }
           return length;
         }
         
         @Override
         public void fireTableCellUpdated(int row, int column) {
         	super.fireTableCellUpdated(row, column);
         	System.out.println("fireTableCell");
         }
         
         @Override
         public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         	System.out.println(rowIndex + "x" + columnIndex + "x" + aValue);
         }

         @Override
         public Object getValueAt(int rowIndex, int columnIndex) {
             return data.get(rowIndex)[columnIndex];
         }
         
          @Override
         public boolean isCellEditable(int row, int col){
            return false;
             
         }
    }
	
    //If user not select a table will alert
    //If user select a table but not click a data column will display first data in input area
    private void btnFirstDataMouseClicked(java.awt.event.MouseEvent evt) {
    	if(path != null){
    		switch(path){
        	case "員工資料表":
        			employee.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        			break;
        	case "出缺勤表":
        			attendance.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        			break;
        	case "員工考績表":
        			achievement.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        			break;
        	case "薪資表":
        			payRoll.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	case "原料庫存資料表":
        			material.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	case "訂單資料表":
        		orderList.setInputValue(tableSelData(0));
    			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	case "訂購項目資料表":
        		orderItem.setInputValue(tableSelData(0));
    			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	case "異常紀錄表":
    			issue.setInputValue(tableSelData(0));
    			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	case "廠商資料表":
    			vendor.setInputValue(tableSelData(0));
    			table_firmData.setRowSelectionInterval(0,0);
        		break;
        	default:
        		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
        		break;
        	}
    	}
    	else{
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    	}
    	
    	
    }                                         
    //If user not select a table will alert
    //If user select a table but not click a data column will display first data in input area
    private void btnPreDataMouseClicked(java.awt.event.MouseEvent evt) {   
    	if(path != null){
    		switch(path){
        	case "員工資料表":
        			if(table_firmData.getSelectedRow()-1 >= 0){
        				employee.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
        				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
        			}
        			else{
        				employee.setInputValue(tableSelData(0));
        				table_firmData.setRowSelectionInterval(0,0);
            		}
        			break;
        	case "出缺勤表":
        			if(table_firmData.getSelectedRow()-1 >= 0){
        				attendance.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
        				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
        			}
        			else{
        				attendance.setInputValue(tableSelData(0));
        				table_firmData.setRowSelectionInterval(0,0);
            		}
        			break;
        	case "員工考績表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				achievement.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			achievement.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "薪資表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				payRoll.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			payRoll.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "原料庫存資料表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				material.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			material.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "訂單資料表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				orderList.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			orderList.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "訂購項目資料表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
        			orderItem.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			orderItem.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "異常紀錄表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				issue.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			issue.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;
        	case "廠商資料表":
        		if(table_firmData.getSelectedRow()-1 >= 0){
    				vendor.setInputValue(tableSelData(table_firmData.getSelectedRow()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()-1,table_firmData.getSelectedRow()-1 );
    			}
        		else{
        			vendor.setInputValue(tableSelData(0));
        			table_firmData.setRowSelectionInterval(0,0);
        		}
        		break;

        	default:
        		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
        		break;
        	}
    		
    	}
    	else{
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    	}
    	
    }                                       
    //If user not select a table will alert
    //If user select a table but not click a data column will display last data in input area
    private void btnNextDataMouseClicked(java.awt.event.MouseEvent evt) {
    	if(path != null){
    		switch(path){
        	case "員工資料表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			employee.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1);
        		}
        		else{
        			employee.setInputValue(tableSelData(table_firmData.getRowCount()-1));
        			table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "出缺勤表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			attendance.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1);
        		}
        		else{
        			attendance.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "員工考績表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			achievement.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			achievement.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "薪資表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			payRoll.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			payRoll.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "原料庫存資料表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			material.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			material.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "訂單資料表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			orderList.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			orderList.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "訂購項目資料表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			orderItem.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			orderItem.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "異常紀錄表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			issue.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			issue.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	case "廠商資料表":
        		if(table_firmData.getSelectedRow() >=0 &&table_firmData.getRowCount() - table_firmData.getSelectedRow()>1){
        			vendor.setInputValue(tableSelData(table_firmData.getSelectedRow()+1));
    				table_firmData.setRowSelectionInterval(table_firmData.getSelectedRow()+1,table_firmData.getSelectedRow()+1 );
        		}
        		else{
        			vendor.setInputValue(tableSelData(table_firmData.getRowCount()-1));
    				table_firmData.setRowSelectionInterval(table_firmData.getRowCount()-1,table_firmData.getRowCount()-1);
        		}
        		break;
        	default:
        		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
        		break;
        	}
    	}
    	else{
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    	}
    	
    }                                        

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {
    	data.clear();
    	int isInsert = 0;
    	if(path != null){
    		switch(path){
    			case "員工資料表":
    				isInsert = employee.insertData();
    				data = employee.queryData();
    				tableModel.fireTableDataChanged();
    				break;
    			case "出缺勤表":
    				isInsert = attendance.insertData();
    				data = attendance.queryData();
    				tableModel.fireTableDataChanged();
    				break;
    			case "員工考績表":
    				isInsert = achievement.insertData();
    				data = achievement.queryData();
    				tableModel.fireTableDataChanged();
    				break;
    			case "薪資表":
    				isInsert = payRoll.insertData();
    				data = payRoll.queryData();
    				tableModel.fireTableDataChanged();
    				break;
    			case "原料庫存資料表":
    				isInsert = material.insertData();
    				data = material.queryData();
    				tableModel.fireTableDataChanged();
    				break;
            	case "訂單資料表":
            		isInsert = orderList.insertData();
    				data = orderList.queryData();
    				tableModel.fireTableDataChanged();
            		break;
            	case "訂購項目資料表":
            		isInsert = orderItem.insertData();
    				data = orderItem.queryData();
    				tableModel.fireTableDataChanged();
            		break;
            	case "異常紀錄表":
            		isInsert = issue.insertData();
    				data = issue.queryData();
    				tableModel.fireTableDataChanged();
            		break;
            	case "廠商資料表":
            		isInsert = vendor.insertData();
    				data = vendor.queryData();
    				tableModel.fireTableDataChanged();
            		break;
    		}
    		if(isInsert == 1 ){
    			JOptionPane.showMessageDialog(rootPane, "新增資料成功");
    		}
    		else{
    			JOptionPane.showMessageDialog(rootPane, "新增資料失敗");
    		}
    	}
  
    }                                      

    private void btnModifyMouseClicked(java.awt.event.MouseEvent evt) { 
    	int isUpdate = 0;
    	data.clear();
    	if(path != null){
    		switch(path){
           	case "員工資料表":
           		isUpdate = employee.updateData();
           		data = employee.queryData();
           		tableModel.fireTableDataChanged();
        		break;
           	case "出缺勤表":
    			isUpdate = attendance.updateData();
    			data = attendance.queryData();
    			tableModel.fireTableDataChanged();
        		break;
           	case "員工考績表":
           		isUpdate = achievement.updateData();
    			data = achievement.queryData();
    			tableModel.fireTableDataChanged();
           		break;
           	case "薪資表":
           		isUpdate = payRoll.updateData();
    			data = payRoll.queryData();
    			tableModel.fireTableDataChanged();
           		break;
           	case "原料庫存資料表":
           		isUpdate = material.updateData();
    			data = material.queryData();
    			tableModel.fireTableDataChanged();
           		break;
        	case "訂單資料表":
           		isUpdate = orderList.updateData();
    			data = orderList.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "訂購項目資料表":
           		isUpdate = orderItem.updateData();
    			data = orderItem.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "異常紀錄表":
           		isUpdate = issue.updateData();
    			data = issue.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "廠商資料表":
           		isUpdate = vendor.updateData();
    			data = vendor.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	}
    		
    	}
    	if(isUpdate == 1){
    		JOptionPane.showMessageDialog(rootPane, "更新資料成功");
    	}
    	else{
    		JOptionPane.showMessageDialog(rootPane, "更新資料失敗");
    	}
    	
    }
    //If user not select a table will alert
    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {                                      
    	if(path != null){
    		switch(path){
           	case "員工資料表":
           		employee.clearInput();
        		break;
           	case "出缺勤表":
           		attendance.clearInput();
           		break;
           	case "員工考績表":
           		achievement.clearInput();
           		break;
           	case "薪資表":
           		payRoll.clearInput();
           		break;
           	case "原料庫存資料表":
           		material.clearInput();
           		break;
        	case "訂單資料表":
        		orderList.clearInput();
        		break;
        	case "訂購項目資料表":
        		orderItem.clearInput();
        		break;
        	case "異常紀錄表":
        		issue.clearInput();
        		break;
        	case "廠商資料表":
        		vendor.clearInput();
        		break;
           	default:
        		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
        		break;
        	}
    	}
    	else{
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    	}
    }                                     
    //Generate an Microsoft Excel file form table data
    //This need  Jakarta POI library
    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {  
    	String outputFile = "D:/ERPOutputFile/" + path +".xls";
    	switch(path){
    	case "員工資料表":
    		fields = employeeFields;
    		break;
    	case "出缺勤表":
    		fields = attendanceFields;
       		break;
       	case "員工考績表":
       		fields = achivevmentFields;
       		break;
       	case "薪資表":
       		fields = payRollFields;
       		break;
       	case "原料庫存資料表":
       		fields = materialFields;
       		break;
    	case "訂單資料表":
    		fields = orderListFields;
    		break;
    	case "訂購項目資料表":
    		fields = orderItemFields;
    		break;
    	case "異常紀錄表":
    		fields = issueFields;
    		break;
    	case "廠商資料表":
    		fields = vendorFields;
    		break;
       	default:
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    		break;
    	}
    	try{
    		//Create a excel file
    		HSSFWorkbook workbook = new HSSFWorkbook();
    		//Create a sheet with name
			HSSFSheet sheet = workbook.createSheet(path);
			HSSFRow row = null;
			HSSFCell cell = null;
			//set the sheet row count and set the first row data with title
			for(int i=0 ; i<table_firmData.getRowCount()+1; i++){
				if(i==0){
					row = sheet.createRow((short) i);
					for(int k=0; k<fields.length;k++){
						cell = row.createCell((short) k);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(fields[k]);
					}
				}
				else{
					//Insert table data in next row
					row = sheet.createRow((short) i);
					for(int k=0; k<fields.length;k++){
						cell = row.createCell((short) k);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue((String) table_firmData.getValueAt(i-1,k));
					}
					
				}
			}
			FileOutputStream fOut = new FileOutputStream(outputFile);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
			JOptionPane.showMessageDialog(JToolBar, "產生檔案成功!\n 檔案位置 :" + outputFile );
    	}
    	catch(Exception ee){
    		JOptionPane.showMessageDialog(JToolBar, "產生檔案失敗 : " + ee.getMessage());
    		System.out.println(ee.toString());
    	}
    }                                      

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {                                       
    	int isDel = 0;
    	data.clear();
    	if(path != null){
    		if(JOptionPane.showConfirmDialog(JToolBar, "確定刪除此筆資料")==0){
    			switch(path){
               	case "員工資料表":
               		isDel = employee.delData();
               		data = employee.queryData();
               		tableModel.fireTableDataChanged();
            		break;
               	case "出缺勤表":
               		isDel = attendance.delData();
               		data = attendance.queryData();
               		tableModel.fireTableDataChanged();
            		break;
               	case "員工考績表":
               		isDel = achievement.delData();
               		data = achievement.queryData();
               		tableModel.fireTableDataChanged();
            		break;
               	case "薪資表":
               		isDel = payRoll.delData();
               		data = payRoll.queryData();
               		tableModel.fireTableDataChanged();
               		break;
               	case "原料庫存資料表":
               		isDel = material.delData();
               		data = material.queryData();
               		tableModel.fireTableDataChanged();
               		break;
            	case "訂單資料表":
               		isDel = orderList.delData();
               		data = orderList.queryData();
               		tableModel.fireTableDataChanged();
            		break;
            	case "訂購項目資料表":
               		isDel = orderItem.delData();
               		data = orderItem.queryData();
               		tableModel.fireTableDataChanged();
            		break;
            	case "異常紀錄表":
               		isDel = issue.delData();
               		data = issue.queryData();
               		tableModel.fireTableDataChanged();
            		break;
            	case "廠商資料表":
               		isDel = vendor.delData();
               		data = vendor.queryData();
               		tableModel.fireTableDataChanged();
            		break;
               	default:
               		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
               		break;
            	}
    			
    			if(path != null && isDel == 1){
            		JOptionPane.showMessageDialog(rootPane, "刪除資料成功");
            	}
            	else{
            		JOptionPane.showMessageDialog(rootPane, "刪除資料失敗");
            	}
        	}
        	
    	}
    	else{
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    	}
    		
    }                                      

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {                                       
    	System.out.println("Logout");
    	
    }            
    // Change the input view area
    private void treeFolderValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeFolderValueChanged
        
    	if(treeFolder.getSelectionPath().getLastPathComponent().toString()!=null){
    		path = treeFolder.getSelectionPath().getLastPathComponent().toString();
    		data.clear();
    		switch(path){
    		case "員工資料表":
    			nowLayout.show(panel_dataInput, "employee");
    			tableModel = new myTableModel(employeeFields);
    			table_firmData.setModel(tableModel);
    			data = employee.queryData();
				tableModel.fireTableDataChanged();
    			break;
    		case "出缺勤表":
    			nowLayout.show(panel_dataInput, "attendance");
    			tableModel = new myTableModel(attendanceFields);
    			table_firmData.setModel(tableModel);
    			data = attendance.queryData();
    			tableModel.fireTableDataChanged();
    			break;
    		case "薪資表":
    			nowLayout.show(panel_dataInput, "payRoll");
    			tableModel = new myTableModel(payRollFields);
    			table_firmData.setModel(tableModel);
    			data = payRoll.queryData();
    			tableModel.fireTableDataChanged();
    			break;
    		case "員工考績表":
    			nowLayout.show(panel_dataInput, "achievement");
    			tableModel = new myTableModel(achivevmentFields);
    			table_firmData.setModel(tableModel);
    			data = achievement.queryData();
    			tableModel.fireTableDataChanged();
    			break;
    		case "原料庫存資料表":
    			nowLayout.show(panel_dataInput, "material");
    			tableModel = new myTableModel(materialFields);
    			table_firmData.setModel(tableModel);
    			data = material.queryData();
    			tableModel.fireTableDataChanged();
    			break;
        	case "訂單資料表":
    			nowLayout.show(panel_dataInput, "orderList");
    			tableModel = new myTableModel(orderListFields);
    			table_firmData.setModel(tableModel);
    			data = orderList.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "訂購項目資料表":
    			nowLayout.show(panel_dataInput, "orderItem");
    			tableModel = new myTableModel(orderItemFields);
    			table_firmData.setModel(tableModel);
    			data = orderItem.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "異常紀錄表":
    			nowLayout.show(panel_dataInput, "issue");
    			tableModel = new myTableModel(issueFields);
    			table_firmData.setModel(tableModel);
    			data = issue.queryData();
    			tableModel.fireTableDataChanged();
        		break;
        	case "廠商資料表":
    			nowLayout.show(panel_dataInput, "vendor");
    			tableModel = new myTableModel(vendorFields);
    			table_firmData.setModel(tableModel);
    			data = vendor.queryData();
    			tableModel.fireTableDataChanged();
        		break;
    		} 
    	}
   
    }
    // Display user select table data in input area
    private void table_firmDataMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	switch(path){
    	case "員工資料表":
    			employee.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    			break;
    	case "出缺勤表":
    			attendance.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    			break;
    	case "員工考績表":
    			achievement.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	case "薪資表":
				payRoll.setInputValue(tableSelData(table_firmData.getSelectedRow()));
		break;
    	case "原料庫存資料表":
    			material.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	case "訂單資料表":
    		orderList.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	case "訂購項目資料表":
    		orderItem.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	case "異常紀錄表":
    		issue.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	case "廠商資料表":
    		vendor.setInputValue(tableSelData(table_firmData.getSelectedRow()));
    		break;
    	default:
    		JOptionPane.showMessageDialog(JToolBar, "未選擇一個資料表");
    		break;
    	}
    }
    
    //If search field is not empty will search 
    private void text_searchKeyReleased(java.awt.event.KeyEvent evt) {                                        
        
        if(path != null){
    		switch(path){
           	case "員工資料表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = employee.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = employee.queryData();
               		tableModel.fireTableDataChanged();
           		}
        		break;
           	case "出缺勤表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = attendance.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = attendance.queryData();
               		tableModel.fireTableDataChanged();
           		}
        		break;
           	case "員工考績表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = achievement.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = achievement.queryData();
               		tableModel.fireTableDataChanged();
           		}
           		break;
           	case "薪資表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = payRoll.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = payRoll.queryData();
               		tableModel.fireTableDataChanged();
           		}
           		break;
           	case "原料庫存資料表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = material.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = material.queryData();
               		tableModel.fireTableDataChanged();
           		}
           		break;
           	case "訂單資料表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = orderList.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = orderList.queryData();
               		tableModel.fireTableDataChanged();
           		}
        		break;
        	case "訂購項目資料表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = orderItem.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = orderItem.queryData();
               		tableModel.fireTableDataChanged();
           		}
        		break;
        	case "異常紀錄表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = issue.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = issue.queryData();
               		tableModel.fireTableDataChanged();
           		}
        		break;
        	case "廠商資料表":
           		if(text_search.getText()!=""){
           			data.clear();
           			data = vendor.search(text_search.getText());
               		tableModel.fireTableDataChanged();
           		}
           		else{
           			data.clear();
           			data = vendor.queryData();
               		tableModel.fireTableDataChanged();
           		}
        	}
    	}
        
     }  
    
    //When user select an row this method will input the row data into a hashmap
    protected  HashMap<Integer, String > tableSelData (int selRow){
    	HashMap<Integer, String>tableData = new HashMap<>();
    	
    	for(int i=0; i <table_firmData.getColumnCount(); i++ ){
    		String data = (String) table_firmData.getValueAt(selRow,i);
    		tableData.put(i , data);
    	}
    	return tableData;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(erp_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(erp_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(erp_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(erp_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new erp_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar JToolBar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnFirstData;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnNextData;
    private javax.swing.JButton btnPreData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_search;
    private javax.swing.JPanel panel_dataInput;
    private javax.swing.JPanel panel_dataShow;
    private javax.swing.JPanel panel_folder;
    private javax.swing.JTable table_firmData;
    private javax.swing.JTextField text_search;
    private javax.swing.JTree treeFolder;
    // End of variables declaration//GEN-END:variables
}
