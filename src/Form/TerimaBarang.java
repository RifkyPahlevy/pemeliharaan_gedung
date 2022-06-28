    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Laporan.DataSupplier;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JSpinner;

public class TerimaBarang extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
    DefaultTableModel tabel2 = new DefaultTableModel();
    
     public String kdBrg,brg,jml,satu,jenis,fd;
     public int stok,jml1,sisa;
     
   public String kode,nama,alamat,noTlp,email;
     LocalDate date = LocalDate.now();    
    public DataSupplier lapB = null;
    
    public TerimaBarang() {
        initComponents();
        kosong();
        aktif();
        setLocationRelativeTo(getRootPane());
        autonumber();
        
    }

    protected void datatable(String tgl){
        Object[] col ={"Kode Barang","Nama Barang","Stok Masuk","Satuan","Jenis"};
            table = new DefaultTableModel(null, col);
        String cariitem = txtCari.getText();
                try {
         String sql  = "SELECT kd_barang,nama_barang,stok,satuan,jenis FROM barang_masuk where tgl_brg like '%"+tgl+"%' order by kd_barang asc";
              Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
         while (hasil.next()){
          table.addRow(new Object[]{
            hasil.getString(1),
            hasil.getString(2),
            hasil.getString(3),
            hasil.getString(4),
            hasil.getString(5)
            
    }
        );
           }
tblBrg.setModel(table);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        e.printStackTrace();
    } 
    }
   protected void aktif(){
        txtKd.requestFocus();
        txtTgl.setText(date.toString());
//           Object[] Baris = {"Nama Barang", "Jumlah","Satuan", "Keterangan"};
//        table = new DefaultTableModel(null,Baris);
//        tblBrg.setModel(table);
     
    }
   
    protected void kosong(){
        
        txtNama.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtTlp.setText("");
        txtBrg.setText("");
        txtMsk.setText("");
        txtSatu.setText("");
       
     
        
    }
    
    public void itemTerpilihTerima(){
        
        txtKd.setText(kode);
        txtNama.setText(nama);
        txtNama.setText(alamat);
        txtTlp.setText(noTlp);
        txtEmail.setText(email);
        
    }

     public void itemTerpilihBrg(){
            PopUpBarang pBrg = new PopUpBarang();
            pBrg.input = this;
            txtKdbrg.setText(kdBrg);
            txtBrg.setText(brg);
            txtJenis.setText(jenis);
            txtSatu.setText(satu);
           
            
            
        }
     private void daftarSupplier(){
       tabel2.getDataVector().removeAllElements();
        tabel2.fireTableDataChanged();
       Object[] col ={"Kode Supplier","Nama Supplier","Alamat","No Telepon","Email"};
            table = new DefaultTableModel(null, col);
        String cariitem = txtCari.getText();
                try {
         String sql  = "SELECT * FROM supplier order by kd_spr asc";
              Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
         while (hasil.next()){
          table.addRow(new Object[]{
            hasil.getString(1),
            hasil.getString(2),
            hasil.getString(3),
            hasil.getString(4),
            hasil.getString(5)
            
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
            String sql = "Select * from supplier order by kd_spr asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKd.setText("SP0001");
            while(rs.next()){
                String kd_spr = rs.getString("kd_spr").substring(2);
                int an = Integer.parseInt(kd_spr) + 1;
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
                
                txtKd.setText("SP"+nol+an);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal"+e);
            
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogSupplier = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDialogSupplier = new javax.swing.JTable();
        btnDialogKembaliObat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtKd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTlp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTgl = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtBrg = new javax.swing.JTextField();
        btnBrg = new javax.swing.JButton();
        txtMsk = new javax.swing.JTextField();
        txtSatu = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtKdbrg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBrg = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHps = new javax.swing.JButton();
        btnKbl = new javax.swing.JButton();

        dialogSupplier.setSize(new java.awt.Dimension(450, 300));

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

        javax.swing.GroupLayout dialogSupplierLayout = new javax.swing.GroupLayout(dialogSupplier.getContentPane());
        dialogSupplier.getContentPane().setLayout(dialogSupplierLayout);
        dialogSupplierLayout.setHorizontalGroup(
            dialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(dialogSupplierLayout.createSequentialGroup()
                        .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogSupplierLayout.setVerticalGroup(
            dialogSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogSupplierLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 69, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PENERIMAAN BARANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(30, 144, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("U P D A T E   L O G I S T I K");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(30, 144, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("P T . S U K S E S  K A R Y A  P E R D A N A");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "D A T A   S U P P L I E R", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/calendar.png"))); // NOI18N
        jLabel14.setText("Tanggal");

        txtKd.setBackground(new java.awt.Color(225, 255, 255));
        txtKd.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        jLabel3.setText("Kode Supplier");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/address.png"))); // NOI18N
        jLabel9.setText("Alamat");

        txtAlamat.setBackground(new java.awt.Color(225, 255, 255));
        txtAlamat.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/typography.png"))); // NOI18N
        jLabel4.setText("Nama Supplier");

        txtNama.setBackground(new java.awt.Color(225, 255, 255));
        txtNama.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel5.setText("Telepon");

        txtTlp.setBackground(new java.awt.Color(225, 255, 255));
        txtTlp.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        txtEmail.setBackground(new java.awt.Color(225, 255, 255));
        txtEmail.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/mail.png"))); // NOI18N
        jLabel6.setText("Email");

        jButton1.setText("///");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtNama)
                            .addComponent(txtEmail)
                            .addComponent(txtTlp))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTgl)
                            .addComponent(txtKd, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "D A T A   B A R A N G  M A S U K", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/box (2).png"))); // NOI18N
        jLabel1.setText("Barang");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/inventory.png"))); // NOI18N
        jLabel10.setText("Stok Masuk");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/delivery-box.png"))); // NOI18N
        jLabel11.setText("Satuan");

        txtBrg.setBackground(new java.awt.Color(225, 255, 255));
        txtBrg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnBrg.setBackground(new java.awt.Color(255, 255, 255));
        btnBrg.setForeground(new java.awt.Color(51, 51, 51));
        btnBrg.setText("///");
        btnBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrgActionPerformed(evt);
            }
        });

        txtMsk.setBackground(new java.awt.Color(225, 255, 255));
        txtMsk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMskActionPerformed(evt);
            }
        });

        txtSatu.setBackground(new java.awt.Color(225, 255, 255));
        txtSatu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSatu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSatuActionPerformed(evt);
            }
        });

        btnTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/add-button.png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Barang");

        jLabel12.setText("Jenis");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel12)))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSatu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtMsk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtJenis, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(101, 101, 101))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(113, 113, 113)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBrg, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtKdbrg))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrg)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBrg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSatu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnTambah)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/transparency.png"))); // NOI18N

        txtCari.setBackground(new java.awt.Color(225, 255, 255));

        tblBrg.setBackground(new java.awt.Color(225, 255, 255));
        tblBrg.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrgMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBrg);

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/floppy-disk.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
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

        btnKbl.setBackground(new java.awt.Color(255, 255, 255));
        btnKbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        btnKbl.setText("KEMBALI");
        btnKbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKblActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(btnHps))
                            .addComponent(btnKbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnHps))
                        .addGap(26, 26, 26)
                        .addComponent(btnKbl)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
         String sql = "insert into supplier values (?,?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKd.getText());
            stat.setString(2, txtNama.getText());
            stat.setString(3, txtAlamat.getText());
            stat.setString(4, txtTlp.getText());
            stat.setString(5, txtEmail.getText());
            
            stat.executeUpdate();
            
               
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            //kosong();
            txtKd.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
            // TODO add your handling code here:
        }
        
        autonumber();
        kosong();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHpsActionPerformed
        // TODO add your handling code here:
        
        int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
         
        if (ok==0){
            
            String sql1 = "delete from barang_masuk where kd_barang ='"+txtKdbrg.getText()+"'";
            
            try{
                
                PreparedStatement stat1 = conn.prepareStatement(sql1);
                stat1.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtKd.requestFocus();
                datatable(txtTgl.getText());
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            
        }
        
    }//GEN-LAST:event_btnHpsActionPerformed

    private void btnKblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKblActionPerformed
        // TODO add your handling code here:
        new LamanUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKblActionPerformed

    private void tblBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrgMouseClicked
        // TODO add your handling code here:
        
        int tabelBarang = tblBrg.getSelectedRow();
        
        kdBrg = tblBrg.getValueAt(tabelBarang, 0).toString();
         brg = tblBrg.getValueAt(tabelBarang, 1).toString();
         jml = tblBrg.getValueAt(tabelBarang, 2).toString();
         satu = tblBrg.getValueAt(tabelBarang, 3).toString();
         
         
         
        
        itemTerpilihBrg();
    }//GEN-LAST:event_tblBrgMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        try{
//            String nama = txtBrg.getText();
//            String jml = txtMsk.getText();
//            String satuan =  txtSatu.getText();
          //  String keterangan =  txtKet.getText();

//            table.addRow(new Object[]{nama,jml,satuan});
//            tblBrg.setModel(table);
            
             String sql = "insert into barang_masuk(kd_spr,tgl_brg,kd_barang,nama_barang,stok,satuan,jenis) values (?,?,?,?,?,?,?)";
             
            
                PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKd.getText());
            stat.setString(2, txtTgl.getText());
            stat.setString(3, txtKdbrg.getText());
            stat.setString(4, txtBrg.getText());
            stat.setString(5, txtMsk.getText());
            stat.setString(6, txtSatu.getText());
             stat.setString(7, txtJenis.getText());

            
            

            stat.executeUpdate();

            datatable(txtTgl.getText());
        }
        catch(Exception e ){
            System.out.println("Error"+e);
        }

    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtSatuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSatuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSatuActionPerformed

    private void txtMskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMskActionPerformed
        // TODO add your handling code here:

//        stok = Integer.parseInt(txtMsk.getText());
//        jml1 = Integer.parseInt(txtJml.getText());
//
//        sisa = stok + jml1;
//        txtJml.setText(""+sisa);
//        String sql1 = "update barang set nama=?,stok=?, satuan=?,keterangan=? where nama='"+txtBrg.getText()+"'";
//        String sql2 = "insert into nama_barang values (?,?,?,?,?,?)";
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
//        String fd = sdf.format(jtgl.getValue());
//
//        try {
//            PreparedStatement stat1 = conn.prepareStatement(sql1);
//            stat1.setString(1, txtBrg.getText());
//            stat1.setString(2, txtJml.getText());
//            stat1.setString(3, txtSatu.getText());
//           
//
//            stat1.executeUpdate();
//
//            PreparedStatement stat2 = conn.prepareStatement(sql2);
//            stat2.setString(1, txtKd.getText());
//            stat2.setString(2, fd);
//            stat2.setString(3, txtBrg.getText());
//            stat2.setString(4, txtMsk.getText());
//            stat2.setString(5, txtSatu.getText());
//            
//
//            stat2.executeUpdate();
//
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_txtMskActionPerformed

    private void btnBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrgActionPerformed
        // TODO add your handling code here:
        PopUpBarang pBrg = new PopUpBarang();
        pBrg.input = this;
        pBrg.setVisible(true);
        pBrg.setResizable(false);
    }//GEN-LAST:event_btnBrgActionPerformed

    private void btnDialogKembaliObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogKembaliObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDialogKembaliObatActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void tableDialogSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDialogSupplierMouseClicked
        // TODO add your handling code here:
        String getKd = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 0).toString();
        String getNm = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 1).toString();
        String getAlamat = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 2).toString();
        String getNoTlp = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 3).toString();
        String getEmail = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 4).toString();

        txtKd.setText(getKd);
        txtNama.setText(getNm);
        txtAlamat.setText(getAlamat);
        txtTlp.setText(getNoTlp);
        txtEmail.setText(getEmail);

        dialogSupplier.setVisible(false);
    }//GEN-LAST:event_tableDialogSupplierMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         dialogSupplier.setLocationRelativeTo(null);
        daftarSupplier();
        dialogSupplier.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TerimaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TerimaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TerimaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TerimaBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TerimaBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrg;
    private javax.swing.JButton btnDialogKembaliObat;
    private javax.swing.JButton btnHps;
    private javax.swing.JButton btnKbl;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JDialog dialogSupplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tableDialogSupplier;
    private javax.swing.JTable tblBrg;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtBrg;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtJenis;
    public javax.swing.JTextField txtKd;
    private javax.swing.JTextField txtKdbrg;
    private javax.swing.JTextField txtMsk;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtSatu;
    private javax.swing.JTextField txtTgl;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}
