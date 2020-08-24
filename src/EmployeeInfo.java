import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilya
 */
public class EmployeeInfo extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeInfo
     */
    public ArrayList<Employee> getEmployee()
    {
        ArrayList<Employee> emplList=new ArrayList<Employee>();
        Connection conn=sqlConnection.dbConnector();
        String query="select EID, Name,Surname,Project,Salary from employeeInfo";
        Statement st;
        ResultSet rs;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(query);
            Employee empl;
            while (rs.next())
            {
                empl=new Employee(rs.getInt("EID"),rs.getString("Name"),rs.getString("Surname"),rs.getString("Project"),rs.getInt("Salary"));
                emplList.add(empl);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return emplList;
    }
    public void Show_Employees_In_JTable()
    {
        ArrayList<Employee> EList=getEmployee();
        DefaultTableModel model=(DefaultTableModel) tableEmpl.getModel();
        Object[] row=new Object[5];
        for (int i=0;i<EList.size();i++)
        {
            row[0]=EList.get(i).getEID();
            row[1]=EList.get(i).getName();
            row[2]=EList.get(i).getSurname();
            row[3]=EList.get(i).getProject();
            row[4]=EList.get(i).getSalary();
            model.addRow(row);
        }
    }
    public EmployeeInfo() {
        super("Company");
        initComponents();
        setLocationRelativeTo(null);
        Show_Employees_In_JTable();
        tableEmpl.setRowSelectionInterval(0, 0);
    }
    public EmployeeInfo(String str1,String str2)
    {
        super("Company");
        initComponents();
        setLocationRelativeTo(null);
        Show_Employees_In_JTable();
        tableEmpl.setRowSelectionInterval(0, 0);
        try{
            String query="select * from employeeInfo where UserName='"+str1+"' and Password='"+CryptWithMD5.cryptWithMD5(str2)+"'";
            Connection connection=sqlConnection.dbConnector();
            PreparedStatement st=connection.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            if (rs.next())
            hellolbl.setText("Hello, "+rs.getString("Name")+" "+rs.getString("Surname")+"!");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpl = new javax.swing.JTable();
        hellolbl = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");

        tableEmpl.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tableEmpl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EID", "Name", "Surname", "Project", "Salary $"
            }
        ));
        tableEmpl.setRowHeight(25);
        tableEmpl.setRowMargin(0);
        jScrollPane1.setViewportView(tableEmpl);

        hellolbl.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        hellolbl.setText("Good Job!!!");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hellolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(179, 179, 179)
                            .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(hellolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        dispose();
        Calculator calc=new Calculator();
        calc.EIDtxt.setVisible(false);
             calc.jLabel1.setVisible(false);
        calc.setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        int i=tableEmpl.getSelectedRow();
        TableModel model=tableEmpl.getModel();
        Connection con=sqlConnection.dbConnector();
        Statement st;
        try{
            String query="delete from employeeInfo where EID="+model.getValueAt(i, 0).toString();
            st=con.createStatement();
            if (st.executeUpdate(query)==1)
            {JOptionPane.showMessageDialog(null, "Data deleted successfully");
            DefaultTableModel model1=(DefaultTableModel)tableEmpl.getModel();
            model1.setRowCount(0);
            Show_Employees_In_JTable();
            tableEmpl.setRowSelectionInterval(0, 0);};
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
       int i=tableEmpl.getSelectedRow();
       TableModel model=tableEmpl.getModel();
       Calculator calc=new Calculator();
       calc.Addbtn.setVisible(false);
       calc.Addbtn.setEnabled(false);
       calc.btnUpdate.setEnabled(true);
       calc.btnUpdate.setVisible(true);
       calc.EIDtxt.setText(model.getValueAt(i, 0).toString());
       calc.EIDtxt.setEnabled(false);
       calc.Nametxt.setText(model.getValueAt(i, 1).toString());
       calc.Surnametxt.setText(model.getValueAt(i, 2).toString());
       calc.projectBox.setSelectedItem(model.getValueAt(i, 3));
     
       try{
            String query="select * from employeeInfo where EID="+model.getValueAt(i, 0).toString();
            Connection connection=sqlConnection.dbConnector();
            PreparedStatement st=connection.prepareStatement(query);
            ResultSet rs=st.executeQuery();
            if (rs.next())
            {
                calc.UserNametxt.setText(rs.getString("UserName"));
                //calc.Passwordtxt.setText(rs.getString("Password"));
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
       calc.setVisible(true);
       dispose();
    }//GEN-LAST:event_UpdateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel hellolbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEmpl;
    // End of variables declaration//GEN-END:variables
}
