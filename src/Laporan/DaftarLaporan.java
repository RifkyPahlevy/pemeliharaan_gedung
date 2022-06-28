/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laporan;

import Laporan.*;

import javax.swing.JOptionPane;
import java.io.InputStream;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
public class DaftarLaporan extends javax.swing.JFrame {
private Connection conn = new Koneksi().connect();
    public DaftarLaporan() {
        initComponents();
    }

    public void runReportDefault(String sourcefilename) {
        try {
            InputStream report;
            report = getClass().getResourceAsStream(sourcefilename);
            JasperPrint jprint = JasperFillManager.fillReport(report,null, conn);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setFitPageZoomRatio();
            viewer.setVisible(true);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        laporanDataGangguan = new javax.swing.JButton();
        lapTeknisi = new javax.swing.JButton();
        lapKpl = new javax.swing.JButton();
        lapDataBarang = new javax.swing.JButton();
        lapKpl1 = new javax.swing.JButton();
        lapDataSupplier = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lapDataBarang1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(30, 144, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DAFTAR LAPORAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        laporanDataGangguan.setBackground(new java.awt.Color(255, 255, 255));
        laporanDataGangguan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        laporanDataGangguan.setForeground(new java.awt.Color(51, 51, 51));
        laporanDataGangguan.setText("LAPORAN PENGERJAAN");
        laporanDataGangguan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanDataGangguanMouseClicked(evt);
            }
        });
        laporanDataGangguan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanDataGangguanActionPerformed(evt);
            }
        });

        lapTeknisi.setBackground(new java.awt.Color(255, 255, 255));
        lapTeknisi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapTeknisi.setForeground(new java.awt.Color(51, 51, 51));
        lapTeknisi.setText("LAPORAN DATA TEKNISI");
        lapTeknisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapTeknisiMouseClicked(evt);
            }
        });
        lapTeknisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapTeknisiActionPerformed(evt);
            }
        });

        lapKpl.setBackground(new java.awt.Color(255, 255, 255));
        lapKpl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapKpl.setForeground(new java.awt.Color(51, 51, 51));
        lapKpl.setText("LAPORAN DATA KEPALA AREA");
        lapKpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapKplActionPerformed(evt);
            }
        });

        lapDataBarang.setBackground(new java.awt.Color(255, 255, 255));
        lapDataBarang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapDataBarang.setForeground(new java.awt.Color(51, 51, 51));
        lapDataBarang.setText("LAPORAN DATA BARANG");
        lapDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapDataBarangMouseClicked(evt);
            }
        });
        lapDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapDataBarangActionPerformed(evt);
            }
        });

        lapKpl1.setBackground(new java.awt.Color(255, 255, 255));
        lapKpl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapKpl1.setForeground(new java.awt.Color(51, 51, 51));
        lapKpl1.setText("LAPORAN DATA ADMIN");
        lapKpl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapKpl1ActionPerformed(evt);
            }
        });

        lapDataSupplier.setBackground(new java.awt.Color(255, 255, 255));
        lapDataSupplier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapDataSupplier.setForeground(new java.awt.Color(51, 51, 51));
        lapDataSupplier.setText("LAPORAN DATA KEPALA TEKNISI");
        lapDataSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapDataSupplierMouseClicked(evt);
            }
        });
        lapDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapDataSupplierActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/logout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lapDataBarang1.setBackground(new java.awt.Color(255, 255, 255));
        lapDataBarang1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lapDataBarang1.setForeground(new java.awt.Color(51, 51, 51));
        lapDataBarang1.setText("LAPORAN DATA LAYANAN");
        lapDataBarang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapDataBarang1MouseClicked(evt);
            }
        });
        lapDataBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lapDataBarang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lapDataSupplier)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lapTeknisi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lapKpl)
                                    .addComponent(lapKpl1))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laporanDataGangguan, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lapDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lapDataBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1)))
                .addGap(0, 62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lapDataBarang)
                        .addGap(18, 18, 18)
                        .addComponent(laporanDataGangguan)
                        .addGap(18, 18, 18)
                        .addComponent(lapDataBarang1)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lapKpl1)
                        .addGap(18, 18, 18)
                        .addComponent(lapTeknisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lapKpl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addComponent(lapDataSupplier)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(30, 144, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lapTeknisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapTeknisiMouseClicked
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Teknisi.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapTeknisiMouseClicked

    private void lapKplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapKplActionPerformed
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/area.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapKplActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lapTeknisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapTeknisiActionPerformed
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Teknisi.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapTeknisiActionPerformed

    private void lapDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapDataBarangMouseClicked
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Barang.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapDataBarangMouseClicked

    private void lapDataSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapDataSupplierMouseClicked
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/KepalaTeknisi.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapDataSupplierMouseClicked

    private void lapDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapDataSupplierActionPerformed
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/KepalaTeknisi.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_lapDataSupplierActionPerformed

    private void laporanDataGangguanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanDataGangguanMouseClicked
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Gangguan.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_laporanDataGangguanMouseClicked

    private void laporanDataGangguanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanDataGangguanActionPerformed
        // TODO add your handling code here:
         try {
            String NamaFile = "/Laporan/Gangguan.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_laporanDataGangguanActionPerformed

    private void lapKpl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapKpl1ActionPerformed
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Admin.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_lapKpl1ActionPerformed

    private void lapDataBarang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapDataBarang1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lapDataBarang1MouseClicked

    private void lapDataBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapDataBarang1ActionPerformed
        // TODO add your handling code here:
         try {
            String NamaFile = "/Laporan/Layanan.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapDataBarang1ActionPerformed

    private void lapDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lapDataBarangActionPerformed
        // TODO add your handling code here:
        try {
            String NamaFile = "/Laporan/Barang.jasper"; //Lokasi File jasper
            
            runReportDefault(NamaFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lapDataBarangActionPerformed

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
            java.util.logging.Logger.getLogger(DaftarLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DaftarLaporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton lapDataBarang;
    private javax.swing.JButton lapDataBarang1;
    private javax.swing.JButton lapDataSupplier;
    private javax.swing.JButton lapKpl;
    private javax.swing.JButton lapKpl1;
    private javax.swing.JButton lapTeknisi;
    private javax.swing.JButton laporanDataGangguan;
    // End of variables declaration//GEN-END:variables
}
