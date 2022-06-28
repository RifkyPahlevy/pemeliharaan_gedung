package Form;

import Laporan.LapPengaduan;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import java.text.SimpleDateFormat;
import javax.swing.JSpinner;
import Form.Layanan;
import Laporan.DataGangguan;
import javax.swing.JFrame;
public class InputPengaduan extends javax.swing.JFrame {

    private Connection conn = new Koneksi().connect();
    private DefaultTableModel table;
     private DefaultTableModel tabel2 = new DefaultTableModel();
    public String layanan,kplArea,ruang,tlp,kode,kodeKepala;
    public LapPengaduan LapP;
    
    public InputPengaduan() {
        initComponents();
        this.setLocationRelativeTo(null);
        kosong();
        aktif();
        
        setLocationRelativeTo(getRootPane());
        autonumber();
    }

    protected void aktif(){
        txtKd.requestFocus();
        jtgl.setEditor(new JSpinner.DateEditor(jtgl,"yyy/MM/dd"));
    }
    
     private void daftarPengaduan(){
       tabel2.getDataVector().removeAllElements();
        tabel2.fireTableDataChanged();
       Object[] col ={"Kode Lapor","Tanggal","Nama Layanan","Nama Kepala Area","Ruang","telepon","Keluhan"};
            table = new DefaultTableModel(null, col);
        
                try {
         String sql  = "SELECT kd_lapor,tgl,nama_layanan,nama_kplarea,ruang,telepon,keluhan FROM pengaduan order by kd_lapor asc";
              Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
         while (hasil.next()){
          table.addRow(new Object[]{
            hasil.getString(1),
            hasil.getString(2),
            hasil.getString(3),
            hasil.getString(4),
            hasil.getString(5),
            hasil.getString(6),
            hasil.getString(7)
            
            
    }
        );
           }
tableDialogSupplier.setModel(table);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        e.printStackTrace();
    } 
    }
    protected void kosong(){
        txtKd.setText("");
        txtLyn.setText("");
        txtKpl.setText("");
        txtRoom.setText("");
        txtTlp.setText("");
        txtKlh.setText("");
        
        
    }
    
        protected void autonumber(){
        try {
            String sql = "Select * from pengaduan order by kd_lapor asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            txtKd.setText("LP0001");
            while(rs.next()){
                String kd_lpr = rs.getString("kd_lapor").substring(2);
                int an = Integer.parseInt(kd_lpr) + 1;
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
                
                txtKd.setText("LP"+nol+an);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto Number Gagal"+e);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogPengaduan = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDialogSupplier = new javax.swing.JTable();
        btnDialogKembaliObat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtKd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtgl = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtLyn = new javax.swing.JTextField();
        btnLyn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtKpl = new javax.swing.JTextField();
        btnKpl = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtRoom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTlp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKlh = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        btnHps = new javax.swing.JButton();
        btnKlr = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        dialogPengaduan.setSize(new java.awt.Dimension(450, 300));

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

        javax.swing.GroupLayout dialogPengaduanLayout = new javax.swing.GroupLayout(dialogPengaduan.getContentPane());
        dialogPengaduan.getContentPane().setLayout(dialogPengaduanLayout);
        dialogPengaduanLayout.setHorizontalGroup(
            dialogPengaduanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPengaduanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogPengaduanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(dialogPengaduanLayout.createSequentialGroup()
                        .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dialogPengaduanLayout.setVerticalGroup(
            dialogPengaduanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogPengaduanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDialogKembaliObat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 144, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("I N P U T   P E N G A D U A N");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        txtKd.setBackground(new java.awt.Color(224, 255, 255));
        txtKd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/key.png"))); // NOI18N
        jLabel2.setText("Kode Laporan");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/calendar.png"))); // NOI18N
        jLabel3.setText("Tanggal");

        jtgl.setModel(new javax.swing.SpinnerDateModel());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/technical-support (1).png"))); // NOI18N
        jLabel4.setText("Layanan");

        txtLyn.setBackground(new java.awt.Color(224, 255, 255));
        txtLyn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnLyn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLyn.setText("///");
        btnLyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLynActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/employee (1).png"))); // NOI18N
        jLabel5.setText("Kepala Area");

        txtKpl.setBackground(new java.awt.Color(224, 255, 255));
        txtKpl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnKpl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnKpl.setText("///");
        btnKpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKplActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/building.png"))); // NOI18N
        jLabel6.setText("Ruang");

        txtRoom.setBackground(new java.awt.Color(224, 255, 255));
        txtRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/phone.png"))); // NOI18N
        jLabel7.setText("Telepon");

        txtTlp.setBackground(new java.awt.Color(224, 255, 255));
        txtTlp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/edit (2).png"))); // NOI18N
        jLabel8.setText("Keluhan");

        txtKlh.setBackground(new java.awt.Color(224, 255, 255));
        txtKlh.setColumns(20);
        txtKlh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtKlh.setRows(5);
        jScrollPane1.setViewportView(txtKlh);

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/floppy-disk.png"))); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHps.setBackground(new java.awt.Color(255, 255, 255));
        btnHps.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/trash.png"))); // NOI18N
        btnHps.setText("HAPUS");
        btnHps.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHpsActionPerformed(evt);
            }
        });

        btnKlr.setBackground(new java.awt.Color(255, 255, 255));
        btnKlr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnKlr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        btnKlr.setText("KEMBALI");
        btnKlr.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnKlr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlrActionPerformed(evt);
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

        jButton1.setText("LIHAT");
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
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtKpl, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnKpl))
                                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtKd, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtLyn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLyn))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(28, 28, 28)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHps)))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(8, 8, 8))))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnKlr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLyn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLyn))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKpl))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHps)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKlr, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(30, 144, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("P T . S U K S E S  K A R Y A  P E R D A N A");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLynActionPerformed
        // TODO add your handling code here:
        PopUpLayanan lyn = new PopUpLayanan();
         lyn.input = this;
        lyn.setVisible(true);
        lyn.setResizable(false);
        
    }//GEN-LAST:event_btnLynActionPerformed

    private void btnKplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKplActionPerformed
        // TODO add your handling code here:
        PopKepalaArea area = new PopKepalaArea();
        area.input = this;
        area.setVisible(true);
        area.setResizable(false);
    }//GEN-LAST:event_btnKplActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
          String sql = "insert into pengaduan (kd_lapor,tgl,nama_layanan,nama_kplarea,ruang,telepon,keluhan,status,kd_layanan,kd_kplarea) values (?,?,?,?,?,?,?,?,?,?)";
          SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
           String fd = sdf.format(jtgl.getValue());
        try{
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKd.getText());
            stat.setString(2, fd);
            stat.setString(3, txtLyn.getText());
            stat.setString(4, txtKpl.getText());
            stat.setString(5, txtRoom.getText());
            stat.setString(6, txtTlp.getText());
            stat.setString(7, txtKlh.getText());
            stat.setString(8, "Menunggu");
            stat.setString(9, kode);
            stat.setString(10, kodeKepala);
            
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Laporan Berhasil Ditambah, dan Akan segera Diproses");
            kosong();
            
            txtKd.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Laporan Gagal Ditambahkan"+e);

        }
         
        autonumber();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHpsActionPerformed
        // TODO add your handling code here:
        int ok =  JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from pengaduan where kd_lapor ='"+txtKd.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                kosong();
                txtKd.requestFocus();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
            
        }
       
       
    }//GEN-LAST:event_btnHpsActionPerformed

    private void btnKlrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlrActionPerformed
        // TODO add your handling code here:
       
        this.dispose();
    }//GEN-LAST:event_btnKlrActionPerformed

    private void tableDialogSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDialogSupplierMouseClicked
        
                String getKd = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 0).toString();
                String getTgl = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 1).toString();
                String getLayanan = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 2).toString();
                String getNmkpl = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 3).toString();
                String getRuang = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 4).toString();
                String getTelepon = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 5).toString();
                String getKeluhan = tableDialogSupplier.getValueAt(tableDialogSupplier.getSelectedRow(), 6).toString();

        
        txtKd.setText(getKd);
        txtLyn.setText(getLayanan);
        txtKpl.setText(getNmkpl);
        txtRoom.setText(getRuang);
        txtTlp.setText(getTelepon);
        txtKlh.setText(getKeluhan);
        dialogPengaduan.setVisible(false);
    }//GEN-LAST:event_tableDialogSupplierMouseClicked

    private void btnDialogKembaliObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDialogKembaliObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDialogKembaliObatActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "update pengaduan set nama_layanan=?,nama_kplarea=?,ruang = ?, telepon=?, keluhan=? where kd_lapor='"+txtKd.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtLyn.getText());
            stat.setString(2, txtKpl.getText());
            stat.setString(3, txtRoom.getText());
            stat.setString(4, txtTlp.getText());
            stat.setString(5, txtKlh.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil diubah");
            kosong();
            txtKd.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e);
            e.printStackTrace();
        }
       

        btnEdit.setEnabled(false);
        

        }

       public void btnHps1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
           
            
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dialogPengaduan.setLocationRelativeTo(null);
        daftarPengaduan();
        dialogPengaduan.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

   public void itemTerpilihLyn(){
            PopUpLayanan lyn = new PopUpLayanan();
            lyn.input = this;
            txtLyn.setText(layanan);
            
            
        }
    public void itemTerpilihKpl(){
            PopKepalaArea area = new PopKepalaArea();
            area.input = this;
            txtKpl.setText(kplArea);
            txtRoom.setText(ruang);
            txtTlp.setText(tlp);
            
            
        }
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
            java.util.logging.Logger.getLogger(InputPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputPengaduan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputPengaduan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDialogKembaliObat;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHps;
    private javax.swing.JButton btnKlr;
    private javax.swing.JButton btnKpl;
    private javax.swing.JButton btnLyn;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JDialog dialogPengaduan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jtgl;
    private javax.swing.JTable tableDialogSupplier;
    private javax.swing.JTextField txtKd;
    private javax.swing.JTextArea txtKlh;
    private javax.swing.JTextField txtKpl;
    private javax.swing.JTextField txtLyn;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}
