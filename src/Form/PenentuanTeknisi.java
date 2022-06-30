
package Form;
import Laporan.DataGangguan;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.text.SimpleDateFormat;

public class PenentuanTeknisi extends javax.swing.JFrame {
  private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
    
   public String kdLapor,layanan,kplArea,ruang,tlp,keluhan,keterangan,tlp1,nama,kode;
   
    
public DataGangguan dg = null;

    
    public PenentuanTeknisi() {
        initComponents();
        this.setLocationRelativeTo(null);
        datatable();

    }
    protected void datatable(){
        Object[] col ={"No-Lapor","Tanggal","Layanan","Kepala Area","Ruang","Telepon","Keluhan","Teknisi","Telepon","Tanggal Perbaikan","Status"};
            table = new DefaultTableModel(null, col);
        
                try {
          String sql = "SELECT\n" +
"     pengaduan.`kd_lapor` ,\n" +
"     pengaduan.`tgl` ,\n" +
"     pengaduan.`kd_layanan` ,\n" +
"     pengaduan.`kd_kplarea` ,\n" +
"     pengaduan.`keluhan` ,\n" +
"     pengaduan.`kd_teknisi`,\n" +
"     pengaduan.`tgl_perbaikan`,\n" +
"     pengaduan.`status` ,\n" +
"     teknisi.`kd_teknisi`,\n" +
"     teknisi.`nama_teknisi`,\n" +
"     teknisi.`telepon` ,\n" +
"     layanan.`kd_layanan`,\n" +
"     layanan.`nama_layanan`,\n" +
"     kpl_area.`kd_kplarea`,\n" +
"     kpl_area.`nama_kplarea`,\n" +
"     kpl_area.`ruang` ,\n" +
"     kpl_area.`telepon`\n" +
"FROM\n" +
"     `teknisi` teknisi INNER JOIN `pengaduan` pengaduan ON teknisi.`kd_teknisi` = pengaduan.`kd_teknisi`\n" +
"     INNER JOIN `layanan` layanan ON pengaduan.`kd_layanan` = layanan.`kd_layanan`\n" +
"     INNER JOIN `kpl_area` kpl_area ON pengaduan.`kd_kplarea` = kpl_area.`kd_kplarea`where status = '"+"Selesai"+"';";
          Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
        table.addRow(new Object[]{
            hasil.getString("kd_lapor"),
            hasil.getString("tgl"),
            hasil.getString("nama_layanan"),
            hasil.getString("nama_kplarea"),
            hasil.getString("ruang"),
            hasil.getString("telepon"),
            hasil.getString("keluhan"),
            hasil.getString("nama_teknisi"),
            hasil.getString("telepon"),
            hasil.getString("tgl_perbaikan"),
            hasil.getString("status")
            
            
            
            
            
            
            
            
    }
        );
            }
                tblData.setModel(table);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
    e.printStackTrace();
} 
    }
    
     public void itemTerpilihTek(){
        
            
            txtKd.setText(kdLapor);
            txtLyn.setText(layanan);
            txtKpl.setText(kplArea);
            txtRuang.setText(ruang);
            txtTlp.setText(tlp);
            txtKlh.setText(keluhan);
            txtTek.setText(nama);
            txtTlp1.setText(tlp1);
            
        }
     public void itemTerpilihTkns(){
            PopUpTeknisi tek = new PopUpTeknisi();
            tek.input = this;
            txtTek.setText(nama);
            txtTlp1.setText(tlp1);
            
            
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtKd = new javax.swing.JTextField();
        jtgl = new javax.swing.JSpinner();
        txtLyn = new javax.swing.JTextField();
        txtKpl = new javax.swing.JTextField();
        txtRuang = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKlh = new javax.swing.JTextArea();
        txtTlp1 = new javax.swing.JTextField();
        btnTkn = new javax.swing.JButton();
        txtTek = new javax.swing.JTextField();
        btnTmbh = new javax.swing.JButton();
        btnHps = new javax.swing.JButton();
        btnKmbl = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(30, 144, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PENENTUAN  TEKNISI");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        jLabel2.setText("Kode Laporan");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/calendar.png"))); // NOI18N
        jLabel3.setText("Tanggal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/technical-support (1).png"))); // NOI18N
        jLabel4.setText("Layanan");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/employee (1).png"))); // NOI18N
        jLabel5.setText("Kepala Area");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/building.png"))); // NOI18N
        jLabel6.setText("Ruang");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel7.setText("Telepon");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/edit (2).png"))); // NOI18N
        jLabel8.setText("Keluhan");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/worker (1).png"))); // NOI18N
        jLabel10.setText("Teknisi");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel11.setText("Telepon");

        txtKd.setBackground(new java.awt.Color(224, 255, 255));
        txtKd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKd.setForeground(new java.awt.Color(51, 51, 51));

        jtgl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtgl.setModel(new javax.swing.SpinnerDateModel());

        txtLyn.setBackground(new java.awt.Color(224, 255, 255));
        txtLyn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtLyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLynActionPerformed(evt);
            }
        });

        txtKpl.setBackground(new java.awt.Color(224, 255, 255));
        txtKpl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtRuang.setBackground(new java.awt.Color(224, 255, 255));
        txtRuang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtTlp.setBackground(new java.awt.Color(224, 255, 255));
        txtTlp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtKlh.setBackground(new java.awt.Color(224, 255, 255));
        txtKlh.setColumns(20);
        txtKlh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKlh.setRows(5);
        jScrollPane1.setViewportView(txtKlh);

        txtTlp1.setBackground(new java.awt.Color(224, 255, 255));
        txtTlp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnTkn.setBackground(new java.awt.Color(255, 255, 255));
        btnTkn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTkn.setForeground(new java.awt.Color(51, 51, 51));
        btnTkn.setText("Teknisi");
        btnTkn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTknActionPerformed(evt);
            }
        });

        txtTek.setBackground(new java.awt.Color(224, 255, 255));
        txtTek.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnTmbh.setBackground(new java.awt.Color(255, 255, 255));
        btnTmbh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/add-button.png"))); // NOI18N
        btnTmbh.setText("TAMBAH");
        btnTmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmbhActionPerformed(evt);
            }
        });

        btnHps.setBackground(new java.awt.Color(255, 255, 255));
        btnHps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/trash.png"))); // NOI18N
        btnHps.setText("HAPUS");
        btnHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHpsActionPerformed(evt);
            }
        });

        btnKmbl.setBackground(new java.awt.Color(255, 255, 255));
        btnKmbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        btnKmbl.setText("KEMBALI");
        btnKmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKmblActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
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
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblData);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/ok (2).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtLyn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKpl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRuang, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTlp))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTek))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTlp1)))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnTkn, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnTmbh)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHps)))
                                .addContainerGap(30, Short.MAX_VALUE))))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnKmbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTkn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtLyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTlp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtKpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTmbh)
                                    .addComponent(btnHps)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnKmbl)
                .addContainerGap(42, Short.MAX_VALUE))
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
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKmblActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKmblActionPerformed

    private void btnTknActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTknActionPerformed
        // TODO add your handling code here:
        PopUpTeknisi pTek = new PopUpTeknisi();
         pTek.input = this;
        pTek.setVisible(true);
        pTek.setResizable(false);
    }//GEN-LAST:event_btnTknActionPerformed

    private void btnTmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmbhActionPerformed
        // TODO add your handling code here:
        String sql = "update pengaduan set status=?,kd_teknisi=? where kd_lapor = '"+txtKd.getText()+"'";
          SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
           String fd = sdf.format(jtgl.getValue());
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, "Proses");
            stat.setString(2, kode);
            
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teknisi Berhasil Ditambahkan, Laporan akan segera dikerjakan");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Teknisi gagal ditambah"+e);

        }
        
        this.dispose();
//        DataGangguan dataG = new DataGangguan();
//        dataG.setVisible(true);
    }//GEN-LAST:event_btnTmbhActionPerformed

    private void btnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHpsActionPerformed
        // TODO add your handling code here:
         int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pengaduan where kd_lapor ='"+txtKd.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                
                txtKd.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            
        }
        dispose();
        DataGangguan dataG = new DataGangguan();
        dataG.setVisible(true);
    }//GEN-LAST:event_btnHpsActionPerformed

    private void txtLynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLynActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLynActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        
        int bar = tblData.getSelectedRow();
        String a = table.getValueAt(bar, 0).toString();
        String b = table.getValueAt(bar, 2).toString();
        String c = table.getValueAt(bar, 3).toString();
        String d = table.getValueAt(bar, 4).toString();
        String e = table.getValueAt(bar, 5).toString();
        String f = table.getValueAt(bar, 6).toString();
        String g = table.getValueAt(bar, 7).toString();
        String h = table.getValueAt(bar, 8).toString();


        String i = table.getValueAt(bar, 10).toString();


        txtKd.setText(a);
        txtLyn.setText(b);
        
        txtKpl.setText(c);
        txtRuang.setText(d);
        txtTlp.setText(e);
    txtKlh.setText(f);
    txtTek.setText(g);
        txtTlp1.setText(h);

    
    

    }//GEN-LAST:event_tblDataMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sql = "update pengaduan set status=? where kd_lapor = '"+txtKd.getText()+"'";
          SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
           String fd = sdf.format(jtgl.getValue());
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, "Diterima");
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pekerjeaan Berhasil Dietujui");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal diperbarui"+e);

        }
        
        datatable();
        
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
            java.util.logging.Logger.getLogger(PenentuanTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenentuanTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenentuanTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenentuanTeknisi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenentuanTeknisi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHps;
    private javax.swing.JButton btnKmbl;
    private javax.swing.JButton btnTkn;
    private javax.swing.JButton btnTmbh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtKd;
    private javax.swing.JTextArea txtKlh;
    private javax.swing.JTextField txtKpl;
    private javax.swing.JTextField txtLyn;
    private javax.swing.JTextField txtRuang;
    private javax.swing.JTextField txtTek;
    private javax.swing.JTextField txtTlp;
    private javax.swing.JTextField txtTlp1;
    // End of variables declaration//GEN-END:variables
}
