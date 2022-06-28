package Form;

import Laporan.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
public class LamanUtamaUser extends javax.swing.JFrame {

     private Connection conn = new Koneksi().connect();
    public LamanUtamaUser(String status) {
        initComponents();
        this.setLocationRelativeTo(null);
        cbJabatan.setSelectedItem(status);
        if (cbJabatan.getSelectedItem().equals("Kepala Area")) {
          daftarKerja.setEnabled(false);
    dataGangguan.setEnabled(false);
    
    lapPengaduan.setEnabled(true);
    
      progress.setEnabled(true);
    setuju.setEnabled(false);  
        }else if (cbJabatan.getSelectedItem().equals("Kepala Teknisi")) {
         lapPengaduan.setEnabled(false);
    daftarKerja.setEnabled(false);   
     progress.setEnabled(true);
     setuju.setEnabled(true);
     dataGangguan.setEnabled(true);
        }else if (cbJabatan.getSelectedItem().equals("Teknisi")) {
          dataGangguan.setEnabled(false);
    setuju.setEnabled(false);
    lapPengaduan.setEnabled(false);
    daftarKerja.setEnabled(true);
      progress.setEnabled(false);  
        }else{
            System.out.println("Tidak ada pilihan");
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        cbJabatan = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        setuju = new javax.swing.JButton();
        progress = new javax.swing.JButton();
        kodeLabel = new javax.swing.JLabel();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel11.setBackground(new java.awt.Color(30, 144, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("S I S T E M   P E M E L I H A R A A N   G E D U N G");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        teknisi2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        teknisi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/worker (1).png"))); // NOI18N
        teknisi2.setText("PROFILE");
        teknisi2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        teknisi2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        teknisi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teknisi2ActionPerformed(evt);
            }
        });

        namaLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        statusLabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        cbJabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kepala Area", "Kepala Teknisi", "Teknisi" }));
        cbJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJabatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(cbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addComponent(teknisi2)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teknisi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cbJabatan)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(namaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(30, 144, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("P T .  S U K S E S   K A R Y A   P E R D A N A");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lapPengaduan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lapPengaduan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/to-do-list.png"))); // NOI18N
        lapPengaduan.setText("LAPOR GANGGUAN");
        lapPengaduan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lapPengaduan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lapPengaduan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapPengaduanActionPerformed(evt);
            }
        });

        dataGangguan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dataGangguan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/checklist.png"))); // NOI18N
        dataGangguan.setText("DATA GANGGUAN");
        dataGangguan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dataGangguan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dataGangguan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataGangguanActionPerformed(evt);
            }
        });

        daftarKerja.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        daftarKerja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/customer.png"))); // NOI18N
        daftarKerja.setText("DAFTAR KERJA");
        daftarKerja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        daftarKerja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        daftarKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarKerjaActionPerformed(evt);
            }
        });

        setuju.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setuju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/ok (3).png"))); // NOI18N
        setuju.setText("PERSETUJUAN");
        setuju.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setuju.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        setuju.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setujuActionPerformed(evt);
            }
        });

        progress.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        progress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/work-in-progress.png"))); // NOI18N
        progress.setText("PROGRES PEKERJAAN");
        progress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        progress.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        progress.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        progress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressActionPerformed(evt);
            }
        });

        kodeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kodeLabel.setText(" ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(daftarKerja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lapPengaduan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(185, 185, 185)
                .addComponent(kodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataGangguan, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(setuju, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lapPengaduan)
                            .addComponent(dataGangguan))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(setuju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(daftarKerja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(kodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(progress)
                .addGap(129, 129, 129))
        );

        keluar.setBackground(new java.awt.Color(30, 144, 255));
        keluar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        keluar.setForeground(new java.awt.Color(255, 255, 255));
        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        keluar.setText("K E L U A R");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(keluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        int yakin = JOptionPane.showConfirmDialog(null,"anda yakin ingin keluar?","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if (yakin == 0) {
            dispose();
      
              Login login = new Login();
            login.setVisible(true);
            
        }
       
      
    }//GEN-LAST:event_keluarActionPerformed

    private void dataGangguanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataGangguanActionPerformed
        // TODO add your handling code here:
        DataGangguan dataG = new DataGangguan();
         dataG.setVisible(true);
       
    }//GEN-LAST:event_dataGangguanActionPerformed

    private void daftarKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarKerjaActionPerformed
        // TODO add your handling code here:
        DataKerja dataK = new DataKerja();
        dataK.setVisible(true);
       
    }//GEN-LAST:event_daftarKerjaActionPerformed

    private void lapPengaduanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapPengaduanActionPerformed
        // TODO add your handling code here:
       InputPengaduan input = new InputPengaduan();
       input.setVisible(true);
       
    }//GEN-LAST:event_lapPengaduanActionPerformed

    private void teknisi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teknisi2ActionPerformed
        // TODO add your handling code here:
        
        if (cbJabatan.getSelectedItem().equals("Kepala Area")) {
            KepalaArea karea = new KepalaArea(kodeLabel.getText());
        karea.setVisible(true);
        
        }else if (cbJabatan.getSelectedItem().equals("Kepala Teknisi")) {
             KepalaTeknisi kteknisi = new KepalaTeknisi(kodeLabel.getText());
        kteknisi.setVisible(true);
        
        }else if (cbJabatan.getSelectedItem().equals("Admin")) {
             Admin admin = new Admin(kodeLabel.getText());
                  admin.setVisible(true);
                  this.dispose();
            
        }else if (cbJabatan.getSelectedItem().equals("Teknisi")) {
            Teknisi teknisi = new Teknisi(kodeLabel.getText());
             
                  teknisi.setVisible(true);
        
        }else{
            System.out.println("tidak ada");
        }
        
    }//GEN-LAST:event_teknisi2ActionPerformed

    private void progressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressActionPerformed
        // TODO add your handling code here:
         LapPengaduan show = new LapPengaduan();
        show.setVisible(true);
    }//GEN-LAST:event_progressActionPerformed

    private void setujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setujuActionPerformed
        // TODO add your handling code here:
       new PenentuanTeknisi().setVisible(true);
    }//GEN-LAST:event_setujuActionPerformed

    private void cbJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJabatanActionPerformed
        // TODO add your handling code here:
     
        
        if (cbJabatan.getSelectedItem().equals("Kepala Area")) {
          daftarKerja.setEnabled(false);
    dataGangguan.setEnabled(false);
    
    lapPengaduan.setEnabled(true);
    
      progress.setEnabled(true);
    setuju.setEnabled(false);  
        }else if (cbJabatan.getSelectedItem().equals("Kepala Teknisi")) {
         lapPengaduan.setEnabled(false);
    daftarKerja.setEnabled(false);   
     progress.setEnabled(true);
     setuju.setEnabled(true);
     dataGangguan.setEnabled(true);
        }else if (cbJabatan.getSelectedItem().equals("Teknisi")) {
          dataGangguan.setEnabled(false);
    setuju.setEnabled(false);
    lapPengaduan.setEnabled(false);
    daftarKerja.setEnabled(true);
      progress.setEnabled(false);  
        }else{
            System.out.println("Tidak ada pilihan");
        }
    }//GEN-LAST:event_cbJabatanActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LamanUtamaUser(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbJabatan;
    public static final javax.swing.JButton daftarKerja = new javax.swing.JButton();
    public static final javax.swing.JButton dataGangguan = new javax.swing.JButton();
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton keluar;
    public static javax.swing.JLabel kodeLabel;
    public static final javax.swing.JButton lapPengaduan = new javax.swing.JButton();
    public static javax.swing.JLabel namaLabel;
    public static javax.swing.JButton progress;
    public static javax.swing.JButton setuju;
    public static javax.swing.JLabel statusLabel;
    public static final javax.swing.JButton teknisi2 = new javax.swing.JButton();
    // End of variables declaration//GEN-END:variables
}
