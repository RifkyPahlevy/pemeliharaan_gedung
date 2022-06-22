
package Form;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.awt.Frame;
import javax.swing.JFrame;

public class Admin extends javax.swing.JFrame {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
    public static String kdAdmin ;

     
    public Admin(String kode) {
      
        initComponents();
       
        this.setLocationRelativeTo(null);
        kosong();
        aktif();
         this.kdAdmin = kode;
         if (kdAdmin !=  null) {
            btnTambah.setVisible(false);
            
           
        isiField();
         }
        datatable();
        setLocationRelativeTo(getRootPane());
        autonumber();
    }

     public void isiField(){
        
        try {
            String sql  = "SELECT * FROM admin where kd_admin like '%"+kdAdmin+"%' order by kd_admin asc";
        Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                txtKd.setText(hasil.getString(1));
        txtTek.setText(hasil.getString(2));
        txtEmail.setText(hasil.getString(3));
        txtUser.setText(hasil.getString(4));
        cbKet.setSelectedItem(hasil.getString(6));
        txtPass.setText(hasil.getString(5));
        txtTlp.setText(hasil.getString(7));
            }
        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    e.printStackTrace();
        }
        
    }
     protected void aktif(){
        txtKd.requestFocus();;
    }
    
    protected void kosong(){
        txtKd.setText("");
        txtTek.setText("");
        txtEmail.setText("");
        txtUser.setText("");
        txtPass.setText("");
        cbKet.setSelectedItem("");
        txtTlp.setText("");
        
        
    }
    
        protected void autonumber(){
        try {
            String sql = "Select * from admin order by kd_admin asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKd.setText("AD0001");
            while(rs.next()){
                String kd_tek = rs.getString("kd_admin").substring(2);
                int an = Integer.parseInt(kd_tek) + 1;
                String nol = "";
                
                if (an < 10) {
                    nol = "000";
                }else if (an <100) {
                    nol = "00";
                }else if (an < 1000) {
                    nol = "0";
                }else if (an < 10000) {
                    nol = "";
                }
                
                txtKd.setText("AD"+nol+an);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal"+e);
            
        }
    }
     protected void datatable(){
         
        Object[] col ={"Kode","Nama Admin","Email","Username","Keterangan","Telepon"};
            table = new DefaultTableModel(null, col);
        
        
                try {
         String sql  = "SELECT * FROM admin where kd_admin like '%"+kdAdmin+"%' order by kd_admin asc";
        Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
        table.addRow(new Object[]{
            hasil.getString(1),
            hasil.getString(2),
            hasil.getString(3),
            hasil.getString(4),
            hasil.getString(5),
            hasil.getString(6)
            
            
            
    }
        );
            }
                
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    e.printStackTrace();
} 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelKode = new javax.swing.JLabel();
        txtKd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbKet = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txtTlp = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnBtl = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(30, 144, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("D A T A   A D M I N");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        labelKode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelKode.setForeground(new java.awt.Color(51, 51, 51));
        labelKode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        labelKode.setText("Kode");

        txtKd.setBackground(new java.awt.Color(225, 255, 255));
        txtKd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/technical-support (1).png"))); // NOI18N
        jLabel2.setText("Nama Admin");

        txtTek.setBackground(new java.awt.Color(225, 255, 255));
        txtTek.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/mail.png"))); // NOI18N
        jLabel3.setText("Email");

        txtEmail.setBackground(new java.awt.Color(225, 255, 255));
        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/typography.png"))); // NOI18N
        jLabel4.setText("Username");

        txtUser.setBackground(new java.awt.Color(225, 255, 255));
        txtUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/secure.png"))); // NOI18N
        jLabel5.setText("Password");

        txtPass.setBackground(new java.awt.Color(225, 255, 255));
        txtPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/file.png"))); // NOI18N
        jLabel6.setText("Keterangan");

        cbKet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbKet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin Gudang", "Admin Laporan", " " }));
        cbKet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel7.setText("Telepon");

        txtTlp.setBackground(new java.awt.Color(225, 255, 255));
        txtTlp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTlp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTlpActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/add-button.png"))); // NOI18N
        btnTambah.setText("DAFTAR");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnBtl.setBackground(new java.awt.Color(255, 255, 255));
        btnBtl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBtl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/cancel.png"))); // NOI18N
        btnBtl.setText("BATAL");
        btnBtl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBtlActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 255, 255));
        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/trash.png"))); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/edit.png"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnKembali.setBackground(new java.awt.Color(255, 255, 255));
        btnKembali.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        btnKembali.setText("KELUAR");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(btnBtl)))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbKet, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnEdit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHapus))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelKode, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTek, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKode))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnBtl)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(30, 144, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("P T .  S U K S E S   K A R Y A   P E R D A N A");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTlpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTlpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTlpActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         
        try{
            String sql = "update admin set nama=?,email=?,username = ?,password=?, telepon=?,keterangan=? where kd_admin='"+kdAdmin+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, txtTek.getText());
            stat.setString(2, txtEmail.getText());
            stat.setString(3, txtUser.getText());
            stat.setString(4, txtPass.getText());
            stat.setString(5, txtTlp.getText());
            stat.setString(6, cbKet.getSelectedItem().toString());
            stat.executeUpdate();
            
            String sql2 = "update user set nama=?,username = ?,password=? where id ='"+kdAdmin+"'";

            PreparedStatement stat2 = conn.prepareStatement(sql2);
            
            stat2.setString(1, txtTek.getText());
            stat2.setString(2, txtUser.getText());
            stat2.setString(3, txtPass.getText());
            
            
            stat2.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            txtKd.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
            e.printStackTrace();
        }
        datatable();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
         
        String sql = "insert into admin values (?,?,?,?,?,?,?)";
        String sql2 = "insert into user values(?,?,?,?,?,?)";
        
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKd.getText());
            stat.setString(2, txtTek.getText());
            stat.setString(3, txtEmail.getText());
            stat.setString(4, txtUser.getText());
            stat.setString(5, txtPass.getText());
            stat.setString(6, cbKet.getSelectedItem().toString());
            stat.setString(7, txtTlp.getText());
            
            
            stat.executeUpdate();
            
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, txtKd.getText());
            stat2.setString(2, txtTek.getText());
            stat2.setString(3, txtUser.getText());
            stat2.setString(4, txtPass.getText());
            stat2.setString(5, "Admin");
            stat2.setString(6, txtTlp.getText());

            
            
            stat2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "data berhasil didaftarkan\nSilahkan login kembali");
            kosong();
            txtKd.requestFocus();
        this.dispose();
            new Login().setVisible(true);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal ditambah"+e);
            // TODO add your handling code here:
        }
        datatable();
        
        autonumber();
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from admin where kd_admin ='"+txtKd.getText()+"'";
            String sql1 = "delete from user where id ='"+txtKd.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                PreparedStatement stat1 = conn.prepareStatement(sql1);
                stat1.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtKd.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            datatable();
              this.dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBtlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBtlActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
        autonumber();
    }//GEN-LAST:event_btnBtlActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        new LamanUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void cbKetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             new Admin(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBtl;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox cbKet;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelKode;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKd;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTek;
    private javax.swing.JTextField txtTlp;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}