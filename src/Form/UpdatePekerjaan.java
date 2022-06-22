
package Form;
import Laporan.DataGangguan;
import Laporan.DataKerja;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.text.SimpleDateFormat;
import javax.swing.JSpinner;

public class UpdatePekerjaan extends javax.swing.JFrame {
  private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
    
   public String kdLapor,layanan,kplArea,ruang,tlp,keluhan,keterangan,tlp1,nama;
   
    public String brg,jml,satu,ket,kode;
     public int stok,jml1,sisa;
     
    
public DataGangguan dg = null;
    
    public UpdatePekerjaan() {
        initComponents();
        this.setLocationRelativeTo(null);
        aktif();
    }
    
     public void itemTerpilihTek(){
        
            
            txtKd.setText(kdLapor);
            txtLyn.setText(layanan);
            txtKpl.setText(kplArea);
            txtRuang.setText(ruang);
            txtTlp.setText(tlp);
            txtKlh.setText(keluhan);
            txtTek.setText(nama);
            
        }
     public void itemTerpilihTkns(){
            PopUpTeknisi tek = new PopUpTeknisi();
            tek.input1 = this;
            txtTek.setText(nama);
            
            
        }
     public void itemTerpilihBrg(){
            UseBarang pBrg = new UseBarang();
            pBrg.input = this;
            txtBrg.setText(brg);
            txtJml.setText(jml);
            txtMsk.setText("");
            
            
        }
    protected void aktif(){
        txtKd.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl,"yyy/MM/dd"));
           Object[] Baris = {"Kode Barang", "Nama Barang","QTY", "Satuan"};
        table = new DefaultTableModel(null,Baris);
        tblData.setModel(table);
     
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLyn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKpl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtRuang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTlp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKlh = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        txtTek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        btnTmbh = new javax.swing.JButton();
        btnHps1 = new javax.swing.JButton();
        btnKmbl = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBrg = new javax.swing.JTextField();
        txtJml = new javax.swing.JTextField();
        btnBrg = new javax.swing.JButton();
        txtMsk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(30, 144, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("U P D A T E   P E K E R J A A N");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        jLabel2.setText("Kode Laporan");

        txtKd.setBackground(new java.awt.Color(225, 255, 255));
        txtKd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/technical-support (1).png"))); // NOI18N
        jLabel4.setText("Layanan");

        txtLyn.setBackground(new java.awt.Color(225, 255, 255));
        txtLyn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/employee (1).png"))); // NOI18N
        jLabel5.setText("Kepala Area");

        txtKpl.setBackground(new java.awt.Color(225, 255, 255));
        txtKpl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/building.png"))); // NOI18N
        jLabel6.setText("Ruang");

        txtRuang.setBackground(new java.awt.Color(225, 255, 255));
        txtRuang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel7.setText("Telepon");

        txtTlp.setBackground(new java.awt.Color(225, 255, 255));
        txtTlp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/edit (2).png"))); // NOI18N
        jLabel8.setText("Keluhan");

        txtKlh.setBackground(new java.awt.Color(225, 255, 255));
        txtKlh.setColumns(20);
        txtKlh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKlh.setRows(5);
        jScrollPane1.setViewportView(txtKlh);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/worker (1).png"))); // NOI18N
        jLabel10.setText("Teknisi");

        txtTek.setBackground(new java.awt.Color(225, 255, 255));
        txtTek.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/calendar.png"))); // NOI18N
        jLabel3.setText("Tanggal Perbaikan");

        jtgl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtgl.setModel(new javax.swing.SpinnerDateModel());

        btnTmbh.setBackground(new java.awt.Color(255, 255, 255));
        btnTmbh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTmbh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/add-button.png"))); // NOI18N
        btnTmbh.setText("TAMBAH");
        btnTmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTmbhActionPerformed(evt);
            }
        });

        btnHps1.setBackground(new java.awt.Color(255, 255, 255));
        btnHps1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHps1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/trash.png"))); // NOI18N
        btnHps1.setText("HAPUS");
        btnHps1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHps1ActionPerformed(evt);
            }
        });

        btnKmbl.setBackground(new java.awt.Color(255, 255, 255));
        btnKmbl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKmbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        btnKmbl.setText("KELUAR");
        btnKmbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKmblActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel10)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGap(55, 55, 55)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHps1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtRuang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKpl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtKd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtTlp, javax.swing.GroupLayout.Alignment.LEADING))
                                .addComponent(txtLyn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTek, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnTmbh)
                        .addComponent(btnKmbl, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTmbh)
                    .addComponent(btnHps1))
                .addGap(7, 7, 7)
                .addComponent(btnKmbl)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(30, 144, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("P T . S U K S E S  K A R Y A  P E R D A N A");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "B A R A N G", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N

        tblData.setBackground(new java.awt.Color(225, 255, 255));
        tblData.setForeground(new java.awt.Color(51, 51, 51));
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/typography.png"))); // NOI18N
        jLabel11.setText("Nama Barang");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/shelf.png"))); // NOI18N
        jLabel12.setText("Stok Tersedia");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/inventory.png"))); // NOI18N
        jLabel13.setText("Jumlah Penggunaan");

        txtBrg.setBackground(new java.awt.Color(225, 255, 255));
        txtBrg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtJml.setBackground(new java.awt.Color(225, 255, 255));
        txtJml.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtJml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlActionPerformed(evt);
            }
        });

        btnBrg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBrg.setForeground(new java.awt.Color(51, 51, 51));
        btnBrg.setText("Barang");
        btnBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrgActionPerformed(evt);
            }
        });

        txtMsk.setBackground(new java.awt.Color(225, 255, 255));
        txtMsk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMsk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addGap(81, 81, 81)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtJml, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtBrg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBrg))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtMsk, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrg))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMsk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKmblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKmblActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKmblActionPerformed

    private void btnTmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTmbhActionPerformed
        // TODO add your handling code here:
        String sql = "update i_pengaduan set layanan=?,kpl_area=?,ruang=?,telepon=?,keluhan=?,teknisi=?,tgl_p=?,status=? where kd_lapor = '"+txtKd.getText()+"'";
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
           String fd = sdf.format(jtgl.getValue());
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtLyn.getText());
            stat.setString(2, txtKpl.getText());
            stat.setString(3, txtRuang.getText());
            stat.setString(4, txtTlp.getText());
            stat.setString(5, txtKlh.getText());
            stat.setString(6, txtTek.getText());
            stat.setString(7, fd);
            stat.setString(8, "Selesai");
            
            stat.executeUpdate();
             
           
            

            JOptionPane.showMessageDialog(null, "Pekerjaan Telah Dilakukan ");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal ditambah"+e);

        }
        
        dispose();
        DataKerja dataK = new DataKerja();
        dataK.setVisible(true);
    }//GEN-LAST:event_btnTmbhActionPerformed

    private void btnBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrgActionPerformed
        // TODO add your handling code here:
        UseBarang pBrg = new UseBarang();
         pBrg.input = this;
        pBrg.setVisible(true);
        pBrg.setResizable(false);

    }//GEN-LAST:event_btnBrgActionPerformed

    private void txtMskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMskActionPerformed
        // TODO add your handling code here:
         stok = Integer.parseInt(txtMsk.getText());
        jml1 = Integer.parseInt(txtJml.getText());
      
       
       
        sisa = jml1 - stok;
        txtJml.setText(""+sisa);
        
        String sql1 = "update barang set nama=?,stok=? where nama='"+txtBrg.getText()+"'";
         String sql2 = "insert into use_brg values (?,?,?,?,?)";
       
        try{
        
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.setString(1, txtBrg.getText());
            stat1.setString(2, txtJml.getText());
            
            stat1.executeUpdate();
             PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setString(1, txtKd.getText());
            stat2.setString(2, kode);
            stat2.setString(3, txtBrg.getText());
            stat2.setString(4, txtMsk.getText());
            stat2.setString(5, satu);
            
            stat2.executeUpdate();
            
        String jmlMsk = txtMsk.getText();
        table.addRow(new Object[]{kode,brg,jmlMsk,satu});
        tblData.setModel(table);
        
        
           
       }
       catch(Exception e ){
           System.out.println("Error"+e);
       }
      
        


    }//GEN-LAST:event_txtMskActionPerformed

    private void btnHps1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHps1ActionPerformed
        // TODO add your handling code here:
        int index = tblData.getSelectedRow();
        table.removeRow(index);
        tblData.setModel(table);
        int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from use_brg where nama='"+txtBrg.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                //kosong();
                txtBrg.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
          
        }
    }//GEN-LAST:event_btnHps1ActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        
        int tabelBarang = tblData.getSelectedRow();
        
        String brg = tblData.getValueAt(tabelBarang, 1).toString();
         String jml = tblData.getValueAt(tabelBarang, 2).toString();
        
        txtBrg.setText(brg);
            txtJml.setText("");
            txtMsk.setText(jml);
            
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtJmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePekerjaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePekerjaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePekerjaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePekerjaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePekerjaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrg;
    private javax.swing.JButton btnHps1;
    private javax.swing.JButton btnKmbl;
    private javax.swing.JButton btnTmbh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtBrg;
    private javax.swing.JTextField txtJml;
    private javax.swing.JTextField txtKd;
    private javax.swing.JTextArea txtKlh;
    private javax.swing.JTextField txtKpl;
    private javax.swing.JTextField txtLyn;
    private javax.swing.JTextField txtMsk;
    private javax.swing.JTextField txtRuang;
    private javax.swing.JTextField txtTek;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}
