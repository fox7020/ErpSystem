
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Properties;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 許哲浩
 */
public class salesReport extends javax.swing.JPanel {
    private Connection conn;
    private Properties prop;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    //記錄當前選擇的欄位值
    private String sltYear = new String();
    private String sltMonth = new String();
    private int unitPrice;
    //欄位
    private String[] shiftfields = new String[]{"全部","早班","中班","晚班"};
    private LinkedList<String> productfields = new LinkedList<String>();   
    private LinkedList<String> yearfields = new LinkedList<String>();
    private LinkedList<String> monthfields = new LinkedList<String>();
    

    private LinkedList<String[]> orderList = new LinkedList<String[]>();//存訂單資訊(id,年,月)
    private LinkedList<String[]> productList = new LinkedList<String[]>();//存產品資訊(id,名稱,價格)
    private LinkedList<String> listNums = new LinkedList<String>(); //記錄符合的訂單ID    
    //TO DO 要將所有結果存入LinkedList中
    private LinkedList<String[]> data = new LinkedList<String[]>();
    private String[] datas = new String[5];
    
    public salesReport() {
        initComponents();
        setDBProp();
        productList = selectProduct();
        orderList = selectOrderList();    
        setDefault();
        

    }
    private void setDBProp() {

		prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "");
		prop.setProperty("characterEncoding", "UTF-8");
		prop.setProperty("useUnicode", "true");
		prop.setProperty("useSSL", "False");
		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/erp", prop);
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=erp;user=sa;password=00000000;");
                        System.out.println("salesReport.setDBProp()");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    private void setItem(JComboBox<String> cbox , String[] fields){        
        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(fields));
    }
    private void setDefault(){
        setItem(year, getDateFields(yearfields));
        month.setVisible(false);
        shift.setVisible(false);
        employee.setVisible(false);
        product.setVisible(false);
        
    }
   
    
//未完成(datetime方法:跳過日期的搜尋方法)
    protected LinkedList selectAttendance(){
        Calendar sltDate = Calendar.getInstance();
        sltDate.set(Calendar.YEAR, Integer.parseInt(sltYear));
        sltDate.set(Calendar.MONTH, Integer.parseInt(sltMonth));
        
        
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM attendance WHERE work BETWEEN ? AND ?");
            //pstmt.setDate(1,);
            
            
            ResultSet result =  pstmt.executeQuery();
            
            
            LinkedList<String[]> rows = new LinkedList<String[]>();
            
            while(result.next()){
                String[] row = new String[2];
                row[0] = result.getString("employeeNum");
                row[1] = result.getString("work");  //上班打卡時間
                
                Calendar c = Calendar.getInstance();
                c.setTime(result.getDate("work"));
                
                String y = Integer.toString(c.get(Calendar.YEAR));
                String m = Integer.toString(c.get(Calendar.MONTH));
                
                String hour = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                String minute = Integer.toString(c.get(Calendar.MINUTE));
                
                System.out.println(y + ":" + m + ":" + hour + ":" + minute);
                rows.add(row);
            }

            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    
    protected LinkedList selectProduct(){
        productfields.add("---全部---");
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet result =  pstmt.executeQuery();
            
            
            LinkedList<String[]> rows = new LinkedList<String[]>();
            while(result.next()){
                String[] row = new String[3];
                row[0] = result.getString("productNum");
                row[1] = result.getString("productName");
                row[2] = result.getString("price");
                productfields.add( row[0] + "--" + row[1]);
                rows.add(row);
            }

            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    protected LinkedList selectOrderItem(String pnum){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderItem WHERE productNum = ?");
            pstmt.setString(1, pnum);
            ResultSet result =  pstmt.executeQuery();
            
            
            LinkedList<String[]> rows = new LinkedList<String[]>();
            
            while(result.next()){
                String[] row = new String[2];
                row[0] = result.getString("orderNum");
                row[1] = result.getString("qty");                

                rows.add(row);
            }

            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    protected LinkedList selectOrderList(){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orderList");
            ResultSet result =  pstmt.executeQuery();
           
            LinkedList<String[]> rows = new LinkedList<String[]>();
            while(result.next()){
                
                Calendar c = Calendar.getInstance();
                c.setTime(result.getDate("orderDate"));
                String y = Integer.toString(c.get(Calendar.YEAR));
                String m = Integer.toString(c.get(Calendar.MONTH)+1);                
                String[] row = new String[3];
                row[0] = result.getString("orderNum");
                row[1] = y;
                row[2] = m;

                if(yearfields.indexOf(y) < 0)yearfields.add(y);                
               rows.add(row);
            }           
            //排序
            java.util.Collections.sort(yearfields);
            pstmt.close();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private String[] getDateFields(LinkedList<String> date){
        String[] strDate = new String[date.size()];
        for(int i = 0; i < date.size();i++){
            strDate[i] = date.get(i);
        }
        return strDate;
    }
    
    
    
    protected LinkedList<String[]> getData(){
        return data;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        year = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        shift = new javax.swing.JComboBox<>();
        product = new javax.swing.JComboBox<>();
        label_total = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        label_shift = new javax.swing.JLabel();
        label_product = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelEmp = new javax.swing.JLabel();
        employee = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(980, 470));
        setPreferredSize(new java.awt.Dimension(980, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        year.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        year.setToolTipText("");
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        add(year, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, 40));

        month.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthActionPerformed(evt);
            }
        });
        add(month, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, 40));

        shift.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        shift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        shift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftActionPerformed(evt);
            }
        });
        add(shift, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, 40));

        product.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        product.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionPerformed(evt);
            }
        });
        add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, -1, 40));

        label_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_total.setText("總額");
        add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, 100, 40));

        label_date.setText("日期區間");
        label_date.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(label_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 150, -1));

        label_shift.setText("班別");
        add(label_shift, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        label_product.setText("產品");
        add(label_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        jLabel1.setText("年");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jLabel2.setText("月");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        labelEmp.setText("值班人員");
        add(labelEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        employee.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        employee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });
        add(employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        sltYear = cb.getSelectedItem().toString();
        monthfields.clear();    //選擇後將之前的清空
        for(int i = 0; i < orderList.size();i++){
            if(orderList.get(i)[1].equals(cb.getSelectedItem())){
                if(monthfields.indexOf(orderList.get(i)[2]) < 0)
                    monthfields.add(orderList.get(i)[2]);
            }
        }
        
        
        java.util.Collections.sort(monthfields);    //排序
        setItem(month,getDateFields(monthfields));  
        month.setVisible(true);
    }//GEN-LAST:event_yearActionPerformed

    private void monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthActionPerformed
        // TODO add your handling code here:
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        sltMonth = cb.getSelectedItem().toString();
        
        //取得符合日期區間的訂單ID
        for(int i = 0; i < orderList.size();i++){
            if(orderList.get(i)[1].equals(sltYear)&&orderList.get(i).equals(sltMonth))
                listNums.add(orderList.get(i)[0]);
        }  
        setItem(shift,shiftfields);
        shift.setVisible(true);
        
        datas[0] = sltYear + "年" + sltMonth +"月";
    }//GEN-LAST:event_monthActionPerformed

    private void shiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftActionPerformed
        // TODO add your handling code here:
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        String sltShift = cb.getSelectedItem().toString();
        switch(sltShift){
            case "全部":
                break;
            case "早班":
                break;
            case "中班":
                break;
            case "晚班":
                break;
        }
        
        datas[1] = sltShift;
        employee.setVisible(true);
    }//GEN-LAST:event_shiftActionPerformed

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        // TODO add your handling code here:
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        System.out.println(cb.getSelectedItem());
        
        
        
        datas[2] = cb.getSelectedItem().toString();
        
        String pfields[] = new String[productfields.size()];
        for(int i = 0; i < productfields.size();i++){
            pfields[i] = productfields.get(i);
        }        
        setItem(product,pfields);
        product.setVisible(true);
    }//GEN-LAST:event_employeeActionPerformed

    
    private void productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionPerformed
        // TODO add your handling code here:
        data.clear();
        javax.swing.JComboBox cb = (javax.swing.JComboBox)evt.getSource();
        String strSlt = cb.getSelectedItem().toString().substring(0, 1);
        for(int i = 0; i < productList.size();i++){
            if(productList.get(i)[0].equals(strSlt)){
                unitPrice = Integer.parseInt(productList.get(i)[2]);
            }
        }
        LinkedList<String[]> orderItem = selectOrderItem(strSlt);
        int qty = 0;
        for(int i = 0; i < orderItem.size();i++){
            if(listNums.indexOf(orderItem.get(i)[0]) > -1)
                qty += Integer.parseInt(orderItem.get(i)[1]);
        }
        String total = qty * unitPrice + "";
        label_total.setText(total);
        datas[3] = strSlt;
        datas[4] = total;
        data.add(datas);
    }//GEN-LAST:event_productActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> employee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelEmp;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_product;
    private javax.swing.JLabel label_shift;
    private javax.swing.JLabel label_total;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JComboBox<String> product;
    private javax.swing.JComboBox<String> shift;
    private javax.swing.JComboBox<String> year;
    // End of variables declaration//GEN-END:variables
}
