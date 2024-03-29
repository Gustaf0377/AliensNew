
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author gustafneander
 */
public class AlienPlats extends javax.swing.JFrame {
private static InfDB idb;
    /**
     * Creates new form AlienPlats
     */
    public AlienPlats() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxPlatser = new javax.swing.JComboBox<>();
        btnHamtaPlats = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnHämtaAliens = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAliensPlats = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxPlatser.setEnabled(false);
        cbxPlatser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlatserActionPerformed(evt);
            }
        });

        btnHamtaPlats.setText("Hämta platser");
        btnHamtaPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaPlatsActionPerformed(evt);
            }
        });

        jLabel3.setText("Välj Plats:");

        btnHämtaAliens.setText("Hämta Aliens på vald plats");
        btnHämtaAliens.setEnabled(false);
        btnHämtaAliens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHämtaAliensActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtAliensPlats.setColumns(20);
        txtAliensPlats.setRows(5);
        jScrollPane1.setViewportView(txtAliensPlats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHamtaPlats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxPlatser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHämtaAliens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(99, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(btnHamtaPlats)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cbxPlatser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(btnHämtaAliens)
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPlatserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlatserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPlatserActionPerformed

    private void btnHamtaPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaPlatsActionPerformed

        try {

            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            //Sql frågan som hämtar alla platser.
            String SQLQuery = "SELECT Plats_ID, Benamning FROM Plats;";
            //tömmer listan med platser.
            cbxPlatser.removeAllItems();
            //kör sql frågan till en ArrayList.
            ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

            // Loopar igenom resultatet.
            for (HashMap<String, String> row : resultList) {
                // Hämta platsID och Benamning.
                String platsId = row.get("Plats_ID");
                String benamning = row.get("Benamning");

                System.out.println("Plats_ID: " + platsId + ", Benamning: " + benamning);
                //Lägger till platsID och benamning i listan.
                cbxPlatser.addItem(platsId + " - " + benamning);
            }

            //Ser till så man kan välja plats och hämta aliens.
            cbxPlatser.setEnabled(true);
            btnHämtaAliens.setEnabled(true);

            // TODO add your handling code here:
        } catch (InfException ex) {
           }

    }//GEN-LAST:event_btnHamtaPlatsActionPerformed

    private void btnHämtaAliensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHämtaAliensActionPerformed
        try {

            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            String platsId;
            Object selectedItem = cbxPlatser.getSelectedItem();

            if (selectedItem != null) {
                //tar första tecknet i rutan som är ett platsID
                platsId = selectedItem.toString().substring(0, 1);
                int position = selectedItem.toString().indexOf("-")+1;
                //Tar allt efter bindesstreck som är platsnamn.
                String platsnamn = selectedItem.toString().substring(position);

                System.out.println("PlatsID: " + platsId);
                String SQLQuery = "SELECT Namn from Alien where Plats ="+ platsId+";";
                //kör sql frågan till en ArrayList.
                ArrayList<HashMap<String, String>> resultList = idb.fetchRows(SQLQuery);

                // Loopar igenom resultatet i ArrayList.
                if (resultList.isEmpty()){
                    txtAliensPlats.setText("");
                    txtAliensPlats.append("I "+ platsnamn + " finns inga Aliens ");
                }

                else{
                    txtAliensPlats.setText("");
                    txtAliensPlats.append("I "+ platsnamn + " finns: ");

                    for (HashMap<String, String> row : resultList) {
                        // Hämtar namnen på aliens.
                        String Namn = row.get("Namn");

                        System.out.println("Namn: " + Namn);

                        txtAliensPlats.append("\n" + Namn)  ;

                    }

                }
            }

            else {
                System.out.println("Inget objekt valt.");
            }

        }

        catch (InfException ex) {
          }

    }//GEN-LAST:event_btnHämtaAliensActionPerformed

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
            java.util.logging.Logger.getLogger(AlienPlats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlienPlats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlienPlats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlienPlats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlienPlats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHamtaPlats;
    private javax.swing.JButton btnHämtaAliens;
    private javax.swing.JComboBox<String> cbxPlatser;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAliensPlats;
    // End of variables declaration//GEN-END:variables
}
