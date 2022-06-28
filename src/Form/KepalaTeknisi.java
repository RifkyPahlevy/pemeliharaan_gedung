/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;

public class KepalaTeknisi extends javax.swing.JFrame {
private DefaultTableModel table;
  private Connection conn = new Koneksi().connect();
  public static String kode;  

  DefaultTableModel tabel2 = new DefaultTableModel();
  public KepalaTeknisi(String kodeKepala) {
        initComponents();
        this.kode = kodeKepala;
        
      
        kosong();
        aktif();
          if (kode != null) {
          btnTambah.setVisible(false);
       
          isiField();
      }
        setLocationRelativeTo(getRootPane());
        
       
        autonumber();
    }
protected void aktif(){
        txtId.requestFocus();;
    }
    

    public void isiField(){
       
        try {
           String sql  = "SELECT * FROM kpl_teknisi where kd_kplteknisi like '%"+kode+"%' order by kd_kplteknisi asc";
        Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                txtId.setText(hasil.getString(1));
        txtNm.setText(hasil.getString(2));
         if ("Laki-Laki".equals(hasil.getString(3))) {
        rbLaki.setSelected(true);
        } else{
        rbPerempuan.setSelected(true);
        }
        txtAlamat.setText(hasil.getString(4));
                txtUser.setText(hasil.getString(5));
        txtPass.setText(hasil.getString(6));

        txtTlp.setText(hasil.getString(7));
            }
        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    e.printStackTrace();
        }
        
    }
    private void daftarKplTeknisi(){
       tabel2.getDataVector().removeAllElements();
        tabel2.fireTableDataChanged();
       Object[] col ={"Kode","Nama Kepala","Jenis Kelamin","Alamat","Username","Telepon"};
            table = new DefaultTableModel(null, col);
        
                try {
         String sql  = "SELECT kd_kplteknisi,nama_kplTeknisi,j_kelamin,alamat,username,telepon FROM kpl_teknisi order by kd_kplteknisi asc";
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
tableDialogSupplier.setModel(table);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        e.printStackTrace();
    } 
    }
protected void autonumber(){
        try {
            String sql = "Select * from kpl_teknisi order by kd_kplteknisi asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtId.setText("KP0001");
            while(rs.next()){
                String kd_area = rs.getString("kd_kplteknisi").substring(2);
                int an = Integer.parseInt(kd_area) + 1;
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
                
                txtId.setText("KP"+nol+an);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal"+e);
            
        }
    }
    protected void kosong(){
        txtId.setText("");
        txtNm.setText("");
        
        txtAlamat.setText("");
        txtUser.setText("");
        txtPass.setText("");
        buttonGroup1.clearSelection();
        txtTlp.setText("");
        
        
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialogAdmin = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDialogSupplier = new javax.swing.JTable();
        btnDialogKembaliObat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelKode = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNm = new javax.swing.JTextField();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnHps = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBtl = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        dialogAdmin.setSize(new java.awt.Dimension(450, 300));

        tableDialogSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDialogSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDialogSupplierMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableDialogSupplier);

        btnDialogKembaliObat.setText("Kembali");
        btnDialogKembaliObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDialogKembaliObatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogAdminLayout = new javax.swing.GroupLayout(dialogAdmin.getContentPane());
        dialogAdmin.getContentPane().setLayout(dialogAdminLayout);
        dialogAdminLayout.setHorizontalGroup(
            dialogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(dialogAdminLayout.createSequentialGroup()
                        .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogAdminLayout.setVerticalGroup(
            dialogAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAdminLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(30, 144, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("K E P A L A  T E K N I S I");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/typography.png"))); // NOI18N
        jLabel6.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/address.png"))); // NOI18N
        jLabel5.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/lavatory.png"))); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/typography.png"))); // NOI18N
        jLabel3.setText("Nama");

        labelKode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelKode.setForeground(new java.awt.Color(51, 51, 51));
        labelKode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        labelKode.setText("Kode");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/secure.png"))); // NOI18N
        jLabel7.setText("Password");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel8.setText("Telepon");

        txtId.setBackground(new java.awt.Color(224, 255, 255));
        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtNm.setBackground(new java.awt.Color(224, 255, 255));
        txtNm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        rbLaki.setBackground(new java.awt.Color(255, 255, 255));
        rbLaki.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbLaki.setForeground(new java.awt.Color(51, 51, 51));
        rbLaki.setText("Laki - Laki");
        rbLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiActionPerformed(evt);
            }
        });

        rbPerempuan.setBackground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbPerempuan.setForeground(new java.awt.Color(51, 51, 51));
        rbPerempuan.setText("Perempuan");
        rbPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanActionPerformed(evt);
            }
        });

        txtAlamat.setBackground(new java.awt.Color(224, 255, 255));
        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAlamat.setRows(5);
        txtAlamat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(txtAlamat);

        txtUser.setBackground(new java.awt.Color(224, 255, 255));
        txtUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(224, 255, 255));
        txtPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtTlp.setBackground(new java.awt.Color(224, 255, 255));
        txtTlp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnTambah.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/add-button.png"))); // NOI18N
        btnTambah.setText("DAFTAR");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHps.setBackground(new java.awt.Color(255, 255, 255));
        btnHps.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/trash.png"))); // NOI18N
        btnHps.setText("HAPUS");
        btnHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHpsActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/edit.png"))); // NOI18N
        btnEdit.setText("UBAH");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("LIHAT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(labelKode)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTlp)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rbLaki)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(rbPerempuan))
                    .addComponent(txtNm, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnHps)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBtl)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(labelKode)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rbLaki)
                            .addComponent(rbPerempuan)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBtl)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHps))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(30, 144, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("P T . S U K S E S  K A R Y A  P E R D A N A");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHpsActionPerformed
        // TODO add your handling code here:
        int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from kpl_teknisi where kd_kplteknisi ='"+txtId.getText()+"'";
            String sql1 = "delete from user where id ='"+txtId.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                PreparedStatement stat1 = conn.prepareStatement(sql1);
                stat1.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtId.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
         this.dispose();
            new Login().setVisible(true);    
        }
    }//GEN-LAST:event_btnHpsActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String jenis = null;
        if(rbLaki.isSelected()){
            jenis = "Laki-Laki";
        }else if(rbPerempuan.isSelected()){
            jenis = "Perempuan";
        }
        try{
            String sql = "update kpl_teknisi set nama_kplteknisi=?,j_kelamin=?,alamat=?,username = ?,password=?, telepon=? where id_kpl='"+kode+"'";
            PreparedStatement stat = conn.prepareStatement(sql);

            stat.setString(1, txtNm.getText());
            stat.setString(2, jenis);
            stat.setString(3, txtAlamat.getText());
            stat.setString(4, txtUser.getText());
            stat.setString(5, txtPass.getText());
            stat.setString(6, txtTlp.getText());
            
            stat.executeUpdate();
            
             String sql2 = "update user set nama=?,username = ?,password=? where id ='"+kode+"'";

            PreparedStatement stat2 = conn.prepareStatement(sql2);
            
            stat2.setString(1, txtNm.getText());
            stat2.setString(2, txtUser.getText());
            stat2.setString(3, txtPass.getText());
            
            
            stat2.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            txtId.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBtlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBtlActionPerformed
        // TODO add your handling code here:
        kosong();
    }//GEN-LAST:event_btnBtlActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        String jenis = null;
        if(rbLaki.isSelected()){
            jenis = "Laki-Laki";
        }else if(rbPerempuan.isSelected()){
            jenis = "Perempuan";
        }
        String sql = "insert into kpl_teknisi values (?,?,?,?,?,?,?)";
        String sql2 = "insert into user values(?,?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtId.getText());
            stat.setString(2, txtNm.getText());
            stat.setString(3, jenis);
            stat.setString(4, txtAlamat.getText());
            stat.setString(5, txtUser.getText());
            stat.setString(6, txtPass.getText());
            stat.setString(7, txtTlp.getText());
            
            stat.executeUpdate();
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, txtId.getText());
            stat2.setString(2, txtNm.getText());
            stat2.setString(3, txtUser.getText());
            stat2.setString(4, txtPass.getText());
            stat2.setString(5, "Kepala Teknisi");
            stat2.setString(6, txtTlp.getText());

            
            stat2.executeUpdate();

            JOptionPane.showMessageDialog(null, "data berhasil didaftarkan\nSilahkan login kembali");
            kosong();
            txtId.requestFocus();
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal didaftarkan"+e);
            // TODO add your handling code here:
        }
       
    }//GEN-LAST:event_btnTambahActionPerformed

    private void rbPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPerempuanActionPerformed

    private void rbLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakiActionPerformed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        this.dispose();
            new Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void tableDialogSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDialogSupplierMouseClicked
        // TODO add your handling code here:
        //        String getKd = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 0).toString();
        //        String getNm = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 1).toString();
        //        String getAlamat = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 2).toString();
        //        String getNoTlp = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 3).toString();
        //        String getEmail = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 4).toString();
        //
        //        txtKd.setText(getKd);
        //        txtNama.setText(getNm);
        //        txtAlamat.setText(getAlamat);
        //        txtTlp.setText(getNoTlp);
        //        txtEmail.setText(getEmail);

        dialogAdmin.setVisible(false);
    }//GEN-LAST:event_tableDialogSupplierMouseClicked

    private void btnDialogKembaliObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogKembaliObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDialogKembaliObatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         dialogAdmin.setLocationRelativeTo(null);
        daftarKplTeknisi();
        dialogAdmin.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(KepalaTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KepalaTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KepalaTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KepalaTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KepalaTeknisi(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBtl;
    private javax.swing.JButton btnDialogKembaliObat;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHps;
    private javax.swing.JButton btnTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog dialogAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelKode;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tableDialogSupplier;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNm;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTlp;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
