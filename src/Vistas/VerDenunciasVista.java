/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.VerDenunciasControlador;
import Repositories.DenunciaRepository;
import Repositories.DistritoRepository;
import Service.DenunciaService;
import Service.DistritoService;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sofía
 */
public class VerDenunciasVista extends javax.swing.JFrame {
     VerDenunciasControlador C_verDenuncias ;
    /**
     * Creates new form VerDenunciasVista
     */
    public VerDenunciasVista() {
        initComponents();
        DenunciaRepository denunciaRepository = new DenunciaRepository();
        DenunciaService denunciaService = new DenunciaService(denunciaRepository);
        DistritoRepository distritosRepository = new DistritoRepository();
        DistritoService distritosService = new DistritoService(distritosRepository);
        C_verDenuncias=new VerDenunciasControlador(this,denunciaService,distritosService);
        C_verDenuncias.llenarTabla(denunciaService.obtenerTodasLasDenuncias());
        C_verDenuncias.llenarComboBoxDistritos(CB_FILTARADISTRITO);
        C_verDenuncias.llenarComboBoxTipoDenuncias(CB_FILTRARINCIDENCIA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CB_FILTARADISTRITO = new javax.swing.JComboBox<>();
        CB_FILTRARINCIDENCIA = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLADENUNCIAS = new javax.swing.JTable();
        BTN_QUITARFILTRO = new javax.swing.JButton();
        BTN_FILTRAR = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        BTN_MOSTRARDETALLES = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LB_MOSTRARFOTO = new javax.swing.JLabel();
        LBL_NOMBRE = new javax.swing.JLabel();
        LBL_FECHA = new javax.swing.JLabel();
        LBL_HORA = new javax.swing.JLabel();
        LBL_DISTRITO = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LBL_TIPODENUN = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_MOSTRARDESC_DENUN = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TA_MOSTRARDESC_LUGAR1 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("DISTRITO");

        jLabel4.setText("TIPO DE INCIDENCIA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("FILTRAR POR:");

        CB_FILTARADISTRITO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ancón", "Ate", "Barranco", "Breña", "Carabayllo", "Cercado de Lima", "Chaclacayo", "Chorrillos", "Cieneguilla", "Comas", "El Agustino,", "Independencia", "Jesús María", "La Molina", "La Victoria", "Lince", "Los Olivos", "Lurigancho", "Lurín", "Magdalena del Mar", "Miraflores", "Pachacámac", "Pucusana", "Pueblo Libre", "Puente Piedra", "Punta Hermosa", "Punta Negra", "Rímac", "San Bartolo", "San Borja", "San Isidro", "San Juan de Lurigancho", "San Juan de Miraflores", "San Luis", "San Martin de Porres", "San Miguel", "Santa Anita", "Santa María del Mar", "Santa Rosa", "Santiago de Surco", "Surquillo", "Villa el Salvador", "Villa Maria del Triunfo" }));
        CB_FILTARADISTRITO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_FILTARADISTRITOActionPerformed(evt);
            }
        });

        CB_FILTRARINCIDENCIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Robo-Hurto", "Extorsión", "Asesinato", "Violencia Doméstica", "Feminicidio", "Acoso Sexual", "Corrupción" }));

        TABLADENUNCIAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Distrito", "Tipo de Denuncia", "Usuario"
            }
        ));
        TABLADENUNCIAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLADENUNCIASMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLADENUNCIAS);

        BTN_QUITARFILTRO.setBackground(new java.awt.Color(255, 153, 153));
        BTN_QUITARFILTRO.setText("QUITAR FILTRO");
        BTN_QUITARFILTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_QUITARFILTROActionPerformed(evt);
            }
        });

        BTN_FILTRAR.setBackground(new java.awt.Color(102, 255, 102));
        BTN_FILTRAR.setText("FILTRAR");
        BTN_FILTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_FILTRARActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel11.setFont(new java.awt.Font("Determination Sans Web", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DENUNCIAS PUBLICADAS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(343, 343, 343))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel11)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel12.setFont(new java.awt.Font("Determination Sans Web", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 0));
        jLabel12.setText("Detalles Denuncia");

        jLabel21.setText("VER LOS DETALLES");

        jLabel22.setText("SELECCIONE FILA DE LA TABLA Y PRESIONE MOSTRAR DETALLES PARA");

        BTN_MOSTRARDETALLES.setBackground(new java.awt.Color(255, 255, 255));
        BTN_MOSTRARDETALLES.setText("MOSTRAR DETALLES");
        BTN_MOSTRARDETALLES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MOSTRARDETALLESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel12)
                .addGap(49, 49, 49)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_MOSTRARDETALLES)
                .addGap(72, 72, 72))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(394, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addGap(273, 273, 273)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_MOSTRARDETALLES)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel12)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(jLabel22)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );

        jLabel6.setText("FECHA");

        jLabel7.setText("HORA:");

        jLabel8.setText("USUARIO:");

        jLabel9.setText("DISTRITO:");

        jLabel10.setText("FOTO:");

        LB_MOSTRARFOTO.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LBL_NOMBRE.setText("------");

        LBL_FECHA.setText("------");

        LBL_HORA.setText("------");

        LBL_DISTRITO.setText("------");

        jLabel17.setText("TIPO DE DENUNCIA:");

        LBL_TIPODENUN.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LBL_TIPODENUN.setForeground(new java.awt.Color(102, 0, 51));
        LBL_TIPODENUN.setText("------");

        jLabel19.setText("DESCRIPCIÓN LUGAR:");

        jLabel20.setText("DESCRIPCIÓN DENUNCIA:");

        TA_MOSTRARDESC_DENUN.setColumns(20);
        TA_MOSTRARDESC_DENUN.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TA_MOSTRARDESC_DENUN.setRows(5);
        jScrollPane2.setViewportView(TA_MOSTRARDESC_DENUN);

        TA_MOSTRARDESC_LUGAR1.setColumns(20);
        TA_MOSTRARDESC_LUGAR1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TA_MOSTRARDESC_LUGAR1.setRows(5);
        TA_MOSTRARDESC_LUGAR1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(TA_MOSTRARDESC_LUGAR1);

        jLabel23.setText("Puede seleccionar una opcion o ambas opciones para filtrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BTN_QUITARFILTRO)
                            .addComponent(BTN_FILTRAR)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CB_FILTRARINCIDENCIA, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_FILTARADISTRITO, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBL_FECHA)
                                    .addComponent(LBL_HORA)
                                    .addComponent(LBL_DISTRITO)
                                    .addComponent(LBL_NOMBRE)
                                    .addComponent(LBL_TIPODENUN)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_MOSTRARFOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CB_FILTARADISTRITO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB_FILTRARINCIDENCIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_FILTRAR)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_QUITARFILTRO)))
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LBL_NOMBRE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(LBL_FECHA))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(LBL_HORA))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(LBL_DISTRITO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(LBL_TIPODENUN))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(68, 68, 68))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addGap(34, 34, 34))))))
                    .addComponent(LB_MOSTRARFOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_QUITARFILTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_QUITARFILTROActionPerformed
        // TODO add your handling code here:
        C_verDenuncias.actionPerformed(evt);
    }//GEN-LAST:event_BTN_QUITARFILTROActionPerformed

    private void CB_FILTARADISTRITOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_FILTARADISTRITOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_FILTARADISTRITOActionPerformed

    private void BTN_FILTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_FILTRARActionPerformed
        // TODO add your handling code here:
        C_verDenuncias.actionPerformed(evt);
    }//GEN-LAST:event_BTN_FILTRARActionPerformed

    private void BTN_MOSTRARDETALLESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MOSTRARDETALLESActionPerformed
        // TODO add your handling code here:
        C_verDenuncias.actionPerformed(evt);
    }//GEN-LAST:event_BTN_MOSTRARDETALLESActionPerformed

    private void TABLADENUNCIASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLADENUNCIASMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLADENUNCIASMouseClicked

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
            java.util.logging.Logger.getLogger(VerDenunciasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDenunciasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDenunciasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDenunciasVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerDenunciasVista().setVisible(true);
            }
        });
    }

    public JButton getBTN_FILTRAR() {
        return BTN_FILTRAR;
    }

    public void setBTN_FILTRAR(JButton BTN_FILTRAR) {
        this.BTN_FILTRAR = BTN_FILTRAR;
    }

    public JButton getBTN_MOSTRARDETALLES() {
        return BTN_MOSTRARDETALLES;
    }

    public void setBTN_MOSTRARDETALLES(JButton BTN_MOSTRARDETALLES) {
        this.BTN_MOSTRARDETALLES = BTN_MOSTRARDETALLES;
    }

    public JButton getBTN_QUITARFILTRO() {
        return BTN_QUITARFILTRO;
    }

    public void setBTN_QUITARFILTRO(JButton BTN_QUITARFILTRO) {
        this.BTN_QUITARFILTRO = BTN_QUITARFILTRO;
    }

    public JComboBox<String> getCB_FILTARADISTRITO() {
        return CB_FILTARADISTRITO;
    }

    public void setCB_FILTARADISTRITO(JComboBox<String> CB_FILTARADISTRITO) {
        this.CB_FILTARADISTRITO = CB_FILTARADISTRITO;
    }

    public JComboBox<String> getCB_FILTRARINCIDENCIA() {
        return CB_FILTRARINCIDENCIA;
    }

    public void setCB_FILTRARINCIDENCIA(JComboBox<String> CB_FILTRARINCIDENCIA) {
        this.CB_FILTRARINCIDENCIA = CB_FILTRARINCIDENCIA;
    }

    public JLabel getLBL_DISTRITO() {
        return LBL_DISTRITO;
    }

    public void setLBL_DISTRITO(JLabel LBL_DISTRITO) {
        this.LBL_DISTRITO = LBL_DISTRITO;
    }

    public JLabel getLBL_FECHA() {
        return LBL_FECHA;
    }

    public void setLBL_FECHA(JLabel LBL_FECHA) {
        this.LBL_FECHA = LBL_FECHA;
    }

    public JLabel getLBL_HORA() {
        return LBL_HORA;
    }

    public void setLBL_HORA(JLabel LBL_HORA) {
        this.LBL_HORA = LBL_HORA;
    }

    public JLabel getLBL_NOMBRE() {
        return LBL_NOMBRE;
    }

    public void setLBL_NOMBRE(JLabel LBL_NOMBRE) {
        this.LBL_NOMBRE = LBL_NOMBRE;
    }

    public JLabel getLBL_TIPODENUN() {
        return LBL_TIPODENUN;
    }

    public void setLBL_TIPODENUN(JLabel LBL_TIPODENUN) {
        this.LBL_TIPODENUN = LBL_TIPODENUN;
    }

    public JLabel getLB_MOSTRARFOTO() {
        return LB_MOSTRARFOTO;
    }

    public void setLB_MOSTRARFOTO(JLabel LB_MOSTRARFOTO) {
        this.LB_MOSTRARFOTO = LB_MOSTRARFOTO;
    }

    public JTable getTABLADENUNCIAS() {
        return TABLADENUNCIAS;
    }

    public void setTABLADENUNCIAS(JTable TABLADENUNCIAS) {
        this.TABLADENUNCIAS = TABLADENUNCIAS;
    }

    public JTextArea getTA_MOSTRARDESC_DENUN() {
        return TA_MOSTRARDESC_DENUN;
    }

    public void setTA_MOSTRARDESC_DENUN(JTextArea TA_MOSTRARDESC_DENUN) {
        this.TA_MOSTRARDESC_DENUN = TA_MOSTRARDESC_DENUN;
    }

    public JTextArea getTA_MOSTRARDESC_LUGAR1() {
        return TA_MOSTRARDESC_LUGAR1;
    }

    public void setTA_MOSTRARDESC_LUGAR1(JTextArea TA_MOSTRARDESC_LUGAR1) {
        this.TA_MOSTRARDESC_LUGAR1 = TA_MOSTRARDESC_LUGAR1;
    }


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_FILTRAR;
    private javax.swing.JButton BTN_MOSTRARDETALLES;
    private javax.swing.JButton BTN_QUITARFILTRO;
    private javax.swing.JComboBox<String> CB_FILTARADISTRITO;
    private javax.swing.JComboBox<String> CB_FILTRARINCIDENCIA;
    private javax.swing.JLabel LBL_DISTRITO;
    private javax.swing.JLabel LBL_FECHA;
    private javax.swing.JLabel LBL_HORA;
    private javax.swing.JLabel LBL_NOMBRE;
    private javax.swing.JLabel LBL_TIPODENUN;
    private javax.swing.JLabel LB_MOSTRARFOTO;
    private javax.swing.JTable TABLADENUNCIAS;
    private javax.swing.JTextArea TA_MOSTRARDESC_DENUN;
    private javax.swing.JTextArea TA_MOSTRARDESC_LUGAR1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
