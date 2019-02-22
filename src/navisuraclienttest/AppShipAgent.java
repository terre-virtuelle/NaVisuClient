/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navisuraclienttest;

import bzh.terrevirtuelle.navisu.domain.navigation.model.NavigationDataSet;
import bzh.terrevirtuelle.navisu.domain.navigation.sailingDirections.model.app.App;
import bzh.terrevirtuelle.navisu.domain.ship.model.Ship;
import bzh.terrevirtuelle.navisu.navigation.Command;
import bzh.terrevirtuelle.navisu.util.xml.ImportExportXML;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.VertxFactory;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.WebSocket;

/**
 *
 * @author serge
 */
public class AppShipAgent
        extends javax.swing.JFrame {

    private Vertx cmdVertx;
    private WebSocket cmdWS;
    private Ship ship;
    private double inc = -0.00001;
    double lon = -4.49;

    /**
     * Creates new form App
     */
    public AppShipAgent() {
        initComponents();
    }

    public void init() {

        cmdVertx = VertxFactory.newVertx();
        //  cmdVertx.createHttpClient().setHost("192.168.0.14")
        cmdVertx.createHttpClient().setHost("localhost")
                .setPort(9090)
                .connectWebsocket("/navigation", (WebSocket websocket) -> {
                    websocket.dataHandler((Buffer data) -> {
                        if (data != null) {
                            response(data.toString());
                        }
                    });
                    cmdWS = websocket;
                    initRequest();
                });
    }

    public void initRequest() {
        // System.out.println("initRequest");
        Writer stringWriter = new StringWriter();
        Command navCmd = new Command("ShipAgentCmd", new Ship(), "data/collada/rov.dae");
        try {
            ImportExportXML.exports(navCmd, stringWriter);
        } catch (JAXBException ex) {
            Logger.getLogger(AppShipAgent.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }
        cmdWS.writeTextFrame(stringWriter.toString());
    }

    public void cmdRequest(int period) {
        cmdVertx.setPeriodic(period, (Long timerID) -> {

            lon += inc;
            ship = new Ship("Lithops", 48.36, lon, 10.0, 270.0);
            // System.out.println("h : " + h);
            Writer stringWriter = new StringWriter();
            Command navCmd = new Command("ShipAgentCmd", ship);
            try {
                ImportExportXML.exports(navCmd, stringWriter);
            } catch (JAXBException ex) {
                Logger.getLogger(AppShipAgent.class.getName()).log(Level.SEVERE, ex.toString(), ex);
            }
            //  System.out.println(stringWriter.toString());
            cmdWS.writeTextFrame(stringWriter.toString());

        });
    }

    private void response(String resp) {
        if (resp != null && !resp.equals("")) {

            NavigationDataSet navigationDataSet = new NavigationDataSet();
            try {
                navigationDataSet = ImportExportXML.imports(navigationDataSet, new StringReader(resp));
            } catch (JAXBException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, ex.toString(), ex);
            }
            //  System.out.println("resp : " + navigationDataSet);
            //  if (navigationDataSet != null) {
            //      navigationDataSet.print();
            // }
        }
    }

    public void stop() {
        cmdVertx.stop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NaVisuClientHttpTest");

        jButton1.setText("Init Ship");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jButton2.setText("Start requests");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        init();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cmdRequest(500);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppShipAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppShipAgent().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
