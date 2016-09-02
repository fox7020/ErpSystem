import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;

public class ProfitReport extends javax.swing.JPanel {
	
	private Properties prop;
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String year;
	private String month;
    private String report;
    
    private int sales;
    private int extend;
    private int profit;
    public ProfitReport() {
        initComponents();
        setDBProp();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	   bgGender = new javax.swing.ButtonGroup();
           jLabel1 = new javax.swing.JLabel();
           jLabel2 = new javax.swing.JLabel();
           jLabel7 = new javax.swing.JLabel();
           jLabel10 = new javax.swing.JLabel();
           jLabel11 = new javax.swing.JLabel();
           jLabel12 = new javax.swing.JLabel();
           cbYear = new javax.swing.JComboBox<>();
           cbMonth = new javax.swing.JComboBox<>();
           lbProfit = new javax.swing.JLabel();
           lbExpend = new javax.swing.JLabel();
           lbSales1 = new javax.swing.JLabel();
           cbReport = new javax.swing.JComboBox<>();
           jLabel3 = new javax.swing.JLabel();

           setPreferredSize(new java.awt.Dimension(980, 470));

           jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel1.setText("年份");

           jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel2.setText("月份");

           jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N

           jLabel10.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel10.setText("當月銷售");

           jLabel11.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel11.setText("當月支出");

           jLabel12.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel12.setText("當月盈餘");

           cbYear.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

           cbMonth.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N

           lbProfit.setFont(new java.awt.Font("微軟正黑體", 1, 15)); // NOI18N

           lbExpend.setFont(new java.awt.Font("微軟正黑體", 1, 15)); // NOI18N

           lbSales1.setFont(new java.awt.Font("微軟正黑體", 1, 15)); // NOI18N

           cbReport.setFont(new java.awt.Font("微軟正黑體", 0, 15)); // NOI18N
           cbReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "支出報表", "銷售報表" }));

           jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 18)); // NOI18N
           jLabel3.setText("觀看");

           javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
           this.setLayout(layout);
           layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                   .addGap(59, 59, 59)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                       .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                   .addGap(18, 18, 18)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                       .addComponent(cbReport, 0, 152, Short.MAX_VALUE)
                       .addComponent(cbYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addComponent(cbMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                   .addGap(143, 143, 143)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addComponent(jLabel11)
                       .addComponent(jLabel10)
                       .addComponent(jLabel12))
                   .addGap(29, 29, 29)
                   .addComponent(jLabel7)
                   .addGap(23, 23, 23)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addComponent(lbSales1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(lbExpend, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(lbProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addContainerGap(272, Short.MAX_VALUE))
           );
           layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                   .addGap(62, 62, 62)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                       .addComponent(jLabel1)
                       .addComponent(jLabel11)
                       .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addComponent(lbExpend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       .addGroup(layout.createSequentialGroup()
                           .addGap(0, 0, Short.MAX_VALUE)
                           .addComponent(jLabel7)
                           .addGap(83, 83, 83))
                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                           .addGap(25, 25, 25)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel10))
                               .addComponent(lbSales1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGap(18, 18, 18)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                               .addGroup(layout.createSequentialGroup()
                                   .addGap(0, 0, Short.MAX_VALUE)
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addComponent(cbReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                               .addGroup(layout.createSequentialGroup()
                                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                       .addComponent(lbProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addComponent(jLabel12))
                                   .addGap(0, 0, Short.MAX_VALUE)))))
                   .addGap(311, 311, 311))
           );
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
    
    protected void setLableDetail(){
    	lbSales1.setText(Integer.toString(sales));
    	lbExpend.setText(Integer.toString(extend));
    	lbProfit.setText(Integer.toString(sales-extend));
    }

    protected void getYears(){
    	LinkedList<String> years = new LinkedList<>();
    	try{
    		pstmt = con.prepareStatement("SELECT orderDate FROM orderlist");
    		rs = pstmt.executeQuery();
    		while(rs.next()){
    			String data = rs.getString(1);
    			String year = data.substring(0, 4);
    			if(!years.contains(year)){
    				years.add(year);
    			}	
    		}
    		
    		String[] arrayYear = new String[years.size()];
    		years.toArray(arrayYear);
    		Arrays.sort(arrayYear);
    		
    		
    		for(int i = 0 ;i<arrayYear.length; i++){
    			cbYear.addItem(arrayYear[i]);
    		}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    }
    
    protected void getMonths(){
    	LinkedList<String> months = new LinkedList<>();
    	
    	try{
    		pstmt = con.prepareStatement("SELECT orderDate FROM orderlist");
    		rs = pstmt.executeQuery();
    		while(rs.next()){
    			String data = rs.getString(1);
    			String month = data.substring(5, 7);
    			if(!months.contains(month)){
    				months.add(month);
    			}	
    		}
    		String[] arrayMonth = new String[months.size()];
    		months.toArray(arrayMonth);
    		Arrays.sort(arrayMonth);
    		
    		for(int i = 0 ;i<arrayMonth.length; i++){
    			cbMonth.addItem(arrayMonth[i]);
    		}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    }
    
    protected String getSelectReport(){
    	report = cbReport.getSelectedItem().toString();
    	return report;
    }
    
    protected LinkedList<String[]> querySales() {
    	sales = 0;
		LinkedList<String[]> data = new LinkedList<>();
		year = cbYear.getSelectedItem().toString();
		month = cbMonth.getSelectedItem().toString();
		try{
			String QueryMonth = "%" + year + "-" + month + "%";
			pstmt = con.prepareStatement("SELECT orderitem.orderNum, orderitem.productNum ,product.productName,orderitem.qty,product.price, (orderitem.qty * product.price) AS TOTAL FROM orderitem ,product WHERE orderNum IN(SELECT orderNum FROM orderlist WHERE orderDate LIKE ? AND status = ?) AND orderitem.productNum = (product.productNum)");
			pstmt.setString(1, QueryMonth);
			pstmt.setString(2, "交易完成");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String[] row = new String[6];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				sales += Integer.parseInt(row[5]);
				data.add(row);
			}
		}
		catch(SQLException ee){
			System.out.println(ee.toString());
		}
		return data;
    }
    
    protected LinkedList<String[]> queryExpend() {
    	extend = 0;
    	LinkedList<String[]> data = new LinkedList<>();
    	year = cbYear.getSelectedItem().toString();
		month = cbMonth.getSelectedItem().toString();
		int ExtendMoney = 0;
    	try{
    		String QueryMonth = "%" + year + "-" + month + "%";
			pstmt = con.prepareStatement("SELECT purchaseDate, purchaseNum,materialNum,vendorNum,qty,price,employeeNum,note FROM purchase WHERE purchaseDate LIKE ?");
			pstmt.setString(1, QueryMonth);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				String[] row = new String[8];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				row[7] = rs.getString(8);
				data.add(row);
				extend += Integer.parseInt(row[5]);
			}
    	}
    	catch(SQLException ee){
    		System.out.println(ee.toString());
    	}
    	return data;
    }
    
    private void lbQueryActionPerformed(java.awt.event.ActionEvent evt) {                                        
       System.out.println("Query");
    }                                       

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbReport;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbExpend;
    private javax.swing.JLabel lbProfit;
    private javax.swing.JLabel lbSales1;
    // End of variables declaration                   
}
