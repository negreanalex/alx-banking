/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atm;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author alex.negrean
 */
public class Transfer extends javax.swing.JFrame {

    /**
     * Creates new form Transfer
     */
    
    Connection con;
    PreparedStatement ps;
    PreparedStatement ps1;
    PreparedStatement ps2;
    PreparedStatement ps3;
    ResultSet rs = null;
    Statement st = null;
//    LocalDateTime ldt = new LocalDateTime(ldt.getTime());
    
    public Transfer() {
        initComponents();
    }
    
    int MyAccNum;
    public Transfer(int AccNum){
        initComponents();
        MyAccNum = AccNum;
        GetBalance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        YBalanceLB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AmountTb = new javax.swing.JTextField();
        TransferBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AccNumTb = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);

        BackBtn.setText("BACK");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Amount :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Your Balance :");

        YBalanceLB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSFER");

        AmountTb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        TransferBtn.setText("TRANSFER");
        TransferBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferBtnMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Account Number :");

        AccNumTb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(TransferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(YBalanceLB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AmountTb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AccNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(YBalanceLB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccNumTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AmountTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addComponent(TransferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int oldBalance;
    private void GetBalance(){
        String query = "SELECT * FROM accounttbl WHERE accnum="+MyAccNum+"";
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ATMDb","postgres","Parola1A");
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                oldBalance = rs.getInt(8);
                YBalanceLB.setText(""+oldBalance);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    int transferBalance;
    private void GetAccBalance(){
        String query = "SELECT * FROM accounttbl WHERE accnum="+AccNumTb.getText()+"";
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ATMDb","postgres","Parola1A");
            st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                transferBalance = rs.getInt(8);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void GetAccNumber(){
        String query = "UPDATE accounttbl SET balance=? WHERE accnum=?";
        try{
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ATMDb","postgres","Parola1A");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,transferBalance + Integer.valueOf(AmountTb.getText()));
            ps.setInt(2,Integer.valueOf(AccNumTb.getText()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        new MainMenu(MyAccNum).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    String uniqueKey = UUID.randomUUID().toString();
    private void TransferBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferBtnMouseClicked
        String receiverAccount = AccNumTb.getText();
        String amount = AmountTb.getText();
        if(AmountTb.getText().isEmpty() || AmountTb.getText().equals(0) || AccNumTb.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter valid information");
        }else if(oldBalance >= Integer.valueOf(amount)){
            try{
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ATMDb","postgres","Parola1A");
                con.setAutoCommit(false);
                ps = con.prepareStatement("UPDATE accounttbl SET balance=balance-? WHERE accnum=?");
                ps.setInt(1,Integer.valueOf(AmountTb.getText()));
                ps.setInt(2,MyAccNum);
                ps.executeUpdate();
                ps1 = con.prepareStatement("UPDATE accounttbl SET balance=balance+? WHERE accnum=?");
                ps1.setInt(1,Integer.valueOf(AmountTb.getText()));
                ps1.setInt(2,Integer.valueOf(AccNumTb.getText()));
                ps1.executeUpdate();
                ps2 = con.prepareStatement("INSERT INTO transfertbl(id,sender,receiver,amount,date)VALUES(?,?,?,?,CURRENT_TIMESTAMP)");
                ps2.setString(1,uniqueKey);
                ps2.setInt(2,MyAccNum);
                ps2.setInt(3, Integer.valueOf(AccNumTb.getText()));
                ps2.setInt(4, Integer.valueOf(AmountTb.getText()));
                ps2.executeUpdate();
                ps3 = con.prepareStatement("SELECT balance FROM accounttbl WHERE accnum=?");
                ps3.setInt(1,MyAccNum);
                rs = ps3.executeQuery();
                if(rs.next()){
                    con.commit();
                    JOptionPane.showMessageDialog(this,"Transfer Succes!");
                    new Transfer(MyAccNum).setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Missing Information");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Insufficient funds");
        }
    }//GEN-LAST:event_TransferBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccNumTb;
    private javax.swing.JTextField AmountTb;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton TransferBtn;
    private javax.swing.JLabel YBalanceLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
