/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.RegistrarDenunciaControlador;
import Modelos.Denuncia;
import Utils.ImagesManager;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Sofía
 */
public class RegistrarDenunciaVista extends javax.swing.JFrame {
    RegistrarDenunciaControlador C_RDenuncia;
    
    byte[] imgEnBytes = null;
    /**
     * Creates new form RealizarDenunciaVista
     */
    public RegistrarDenunciaVista() {
        initComponents();
        Denuncia M_RDenuncia = new Denuncia();
        //C_RDenuncia = new RegistrarDenunciaControlador(this,M_RDenuncia);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_FECHA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXT_HORA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CBOX_DISTRITOS = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TXT_DESC_LUGAR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BTN_CARGAR_FOTO = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        RB_SI = new javax.swing.JRadioButton();
        RB_NO = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        CBOX_INCIDENCIAS = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        TXT_DESC_INCIDENTE = new javax.swing.JTextField();
        BTN_REGISTRAR = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TXT_NOMBREUSUARIO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INGRESE DATOS DEL INCIDENTE");

        jLabel2.setText("Fecha");

        jLabel3.setText("Hora");

        jLabel4.setText("Distrito");

        CBOX_DISTRITOS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ancón", "Ate", "Barranco", "Breña", "Carabayllo", "Cercado de Lima", "Chaclacayo", "Chorrillos", "Cieneguilla", "Comas", "El Agustino,", "Independencia", "Jesús María", "La Molina", "La Victoria", "Lince", "Los Olivos", "Lurigancho", "Lurín", "Magdalena del Mar", "Miraflores", "Pachacámac", "Pucusana", "Pueblo Libre", "Puente Piedra", "Punta Hermosa", "Punta Negra", "Rímac", "San Bartolo", "San Borja", "San Isidro", "San Juan de Lurigancho", "San Juan de Miraflores", "San Luis", "San Martin de Porres", "San Miguel", "Santa Anita", "Santa María del Mar", "Santa Rosa", "Santiago de Surco", "Surquillo", "Villa el Salvador", "Villa Maria del Triunfo" }));

        jLabel5.setText("Describir lugar:");

        jLabel6.setText("Foto:");

        BTN_CARGAR_FOTO.setBackground(new java.awt.Color(255, 102, 102));
        BTN_CARGAR_FOTO.setText("Cargar Foto");
        BTN_CARGAR_FOTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CARGAR_FOTOActionPerformed(evt);
            }
        });

        jLabel7.setText("¿Anonimo?:");

        RB_SI.setText("SI");
        RB_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_SIActionPerformed(evt);
            }
        });

        RB_NO.setText("NO");
        RB_NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_NOActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre:");

        CBOX_INCIDENCIAS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Robo-Hurto", "Extorsión", "Asesinato", "Violencia Doméstica", "Feminicidio", "Acoso Sexual", "Corrupción" }));

        jLabel9.setText("Describir la Incidencia:");

        BTN_REGISTRAR.setBackground(new java.awt.Color(51, 255, 51));
        BTN_REGISTRAR.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BTN_REGISTRAR.setText("REGISTRAR");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("REGISTRAR DENUNCIA");

        jLabel11.setText("Tipo de incidencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TXT_HORA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBOX_DISTRITOS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TXT_FECHA)))
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel1))
                        .addComponent(TXT_DESC_LUGAR)
                        .addComponent(BTN_CARGAR_FOTO, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(TXT_NOMBREUSUARIO))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TXT_DESC_INCIDENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(CBOX_INCIDENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RB_SI)
                        .addGap(55, 55, 55)
                        .addComponent(RB_NO)
                        .addGap(56, 56, 56)))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BTN_REGISTRAR, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(296, 296, 296))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(RB_SI)
                    .addComponent(RB_NO))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(TXT_HORA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CBOX_DISTRITOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBOX_INCIDENCIAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_DESC_LUGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTN_CARGAR_FOTO))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TXT_DESC_INCIDENTE, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(13, 13, 13)
                        .addComponent(BTN_REGISTRAR))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(TXT_NOMBREUSUARIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CARGAR_FOTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CARGAR_FOTOActionPerformed
        // TODO add your handling code here:
        JFileChooser file_upload = new JFileChooser();
        
        int res = file_upload.showOpenDialog(this);
        
        if(res == JFileChooser.APPROVE_OPTION) {
            File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
            String fileName = file_path.toString();
            ImagesManager im = new ImagesManager();
            // Imagen en Bytes para setear en la propiedad foto
            imgEnBytes = im.uploadImage(file_path);
            // Luego lo llamas al momento de presionar el boton REGISTRAR y lo seteas en el NEW DENUNCIA
        }
    }//GEN-LAST:event_BTN_CARGAR_FOTOActionPerformed

    private void RB_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_SIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_SIActionPerformed

    private void RB_NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_NOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_NOActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarDenunciaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarDenunciaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarDenunciaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarDenunciaVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarDenunciaVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CARGAR_FOTO;
    private javax.swing.JButton BTN_REGISTRAR;
    private javax.swing.JComboBox<String> CBOX_DISTRITOS;
    private javax.swing.JComboBox<String> CBOX_INCIDENCIAS;
    private javax.swing.JRadioButton RB_NO;
    private javax.swing.JRadioButton RB_SI;
    private javax.swing.JTextField TXT_DESC_INCIDENTE;
    private javax.swing.JTextField TXT_DESC_LUGAR;
    private javax.swing.JTextField TXT_FECHA;
    private javax.swing.JTextField TXT_HORA;
    private javax.swing.JTextField TXT_NOMBREUSUARIO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
