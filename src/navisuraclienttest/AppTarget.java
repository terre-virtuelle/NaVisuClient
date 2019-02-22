/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navisuraclienttest;

import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconCardinal;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BeaconSpecialPurpose;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.BuoyCardinal;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.Buoyage;
import bzh.terrevirtuelle.navisu.domain.charts.vector.s57.model.geo.Landmark;
import bzh.terrevirtuelle.navisu.domain.navigation.model.NavigationData;
import bzh.terrevirtuelle.navisu.domain.navigation.model.NavigationDataSet;
import bzh.terrevirtuelle.navisu.domain.navigation.model.Target;
import bzh.terrevirtuelle.navisu.domain.navigation.model.TargetBuilder;
import bzh.terrevirtuelle.navisu.domain.navigation.sailingDirections.model.app.App;
import bzh.terrevirtuelle.navisu.navigation.Command;
import bzh.terrevirtuelle.navisu.util.xml.ImportExportXML;
import java.awt.event.WindowEvent;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
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
public class AppTarget extends javax.swing.JFrame {

    private Vertx cmdVertx;
    private WebSocket cmdWS;
    private final int PORT = 9090;
    private final String HOST = "localhost";
    private final String CANAL = "/navigation";

    public AppTarget() {
        initComponents();
    }

    //Initialisation du client
    //Ouverture du canal "/navigation" sur le serveur
    //Créeation des requêtes
    public void init() {
        cmdVertx = VertxFactory.newVertx();
        cmdVertx.createHttpClient().setHost(HOST)
                .setPort(PORT)
                .connectWebsocket(CANAL, (WebSocket websocket) -> {
                    websocket.dataHandler((Buffer data) -> {
                        if (data != null) {
                            response(data.toString());
                        }
                    });
                    cmdWS = websocket;
                    cmdRequest();
                });
    }

    public void cmdRequest() {
        sendCmdRequest(new Target(new BeaconCardinal(), 48.3130, -4.6214));
        sendCmdRequest(new Target(new BeaconSpecialPurpose(), 48.3130, -4.6214));
        //Option utilisation d'un TargetBuilder
        Target target = TargetBuilder
                .create()
                .navigationData(new BuoyCardinal())
                .latitude(48.3130)
                .longitude(-4.6214)
                .azimuth(275.0)
                .build();
        sendCmdRequest(target);
        sendCmdRequest(new Target(new Landmark(), 48.3130, -4.6214));
    }

    //Sérialisation de la commande en xml
    //Puis envoi
    public void sendCmdRequest(NavigationData target) {
        Writer stringWriter = new StringWriter();
        Command navCmd = new Command("TargetCmd", target);
        try {
            ImportExportXML.exports(navCmd, stringWriter);
        } catch (JAXBException ex) {
            Logger.getLogger(AppTarget.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }
        cmdWS.writeTextFrame(stringWriter.toString());
    }

    //Le resultat est en xml
    //Traduction du resultat en objets
    private void response(String resp) {

        NavigationDataSet navigationDataSet = new NavigationDataSet();
        if (!resp.equals("")) {
            try {
                navigationDataSet = ImportExportXML.imports(navigationDataSet, new StringReader(resp));
            } catch (JAXBException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, ex.toString(), ex);
            }
            //Recuperation de la liste des NavigationData et coercition de type
            List<NavigationData> result = navigationDataSet.getNavigationDataList();
            for (NavigationData n : result) {
                Target t = (Target) n;
                System.out.print("buoy : " + ((Buoyage) t.getNavigationData()).getObjectName());
                System.out.print(" type : " + t.getNavigationData().getClass().getSimpleName());
                System.out.printf(" distance : %.2f m", t.getDistance());
                System.out.printf(" azimuth : %.2f °\n", t.getAzimuth());
            }
        } else {
            System.out.println("Pas de cible");
        }
    }

    public void stop() {
        if (cmdVertx != null) {
            cmdVertx.stop();
        }
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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

        jButton1.setText("Start");
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

        jButton2.setText("Stop");
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
        stop();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new AppTarget().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
