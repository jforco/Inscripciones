

package inscripciones;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Confirmar extends javax.swing.JFrame {
    String nombre;
    String sexo;
    String iglesia;
    String edad;
    String pago;
    String telefono;
    conexion con;
    
    Nuevo n;
    public Confirmar() {
        initComponents();
        
    }

    public Confirmar(Nuevo nn,String nombre, String sexo, String iglesia, String edad, String pago, String telefono) throws HeadlessException {
        initComponents();
        n = nn;
        this.nombre = nombre;
        this.sexo = sexo;
        this.iglesia = iglesia;
        this.edad = edad;
        this.pago = pago;
        this.telefono = telefono;
        con = new conexion();
        llenarLabels();
        rellenarColores();
        jButton1.requestFocus();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lnombre = new javax.swing.JLabel();
        liglesia = new javax.swing.JLabel();
        ledad = new javax.swing.JLabel();
        lpago = new javax.swing.JLabel();
        ltelefono = new javax.swing.JLabel();
        lsexo = new javax.swing.JLabel();
        colores = new javax.swing.JComboBox();
        lcolor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lnombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lnombre.setText("Nombre : ");

        liglesia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        liglesia.setText("Iglesia : ");

        ledad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ledad.setText("Edad : ");

        lpago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lpago.setText("Pago : ");

        ltelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ltelefono.setText("Telefono : ");

        lsexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lsexo.setText("Sexo : ");

        colores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        colores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lcolor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lcolor.setText("Color : ");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lsexo)
                            .addComponent(liglesia)
                            .addComponent(ledad)
                            .addComponent(lpago)
                            .addComponent(ltelefono)
                            .addComponent(lnombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lcolor)
                        .addGap(55, 55, 55)
                        .addComponent(colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lnombre)
                .addGap(18, 18, 18)
                .addComponent(lsexo)
                .addGap(21, 21, 21)
                .addComponent(liglesia)
                .addGap(18, 18, 18)
                .addComponent(ledad)
                .addGap(18, 18, 18)
                .addComponent(lpago)
                .addGap(18, 18, 18)
                .addComponent(ltelefono)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lcolor))
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"En realidad desea realizar cerrar la aplicacion (perderas los datos que no hayan sido guardados)","Mensaje de Confirmacion",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) registrar();
    }//GEN-LAST:event_jButton1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox colores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lcolor;
    private javax.swing.JLabel ledad;
    private javax.swing.JLabel liglesia;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lpago;
    private javax.swing.JLabel lsexo;
    private javax.swing.JLabel ltelefono;
    // End of variables declaration//GEN-END:variables



    private void llenarLabels() {
        lnombre.setText(lnombre.getText() + nombre);
        lsexo.setText(lsexo.getText() + sexo);
        liglesia.setText(liglesia.getText() + iglesia);
        ledad.setText(ledad.getText() + edad);
        lpago.setText(lpago.getText() + pago);
        ltelefono.setText(ltelefono.getText() + telefono);
    }    
    
    private void rellenarColores() {
        colores.removeAllItems();
        ArrayList<String> lista = con.verDatos(sexo, edad);
        for(String a : lista){
            colores.addItem(a);
        }
    }
    
    private void registrar(){
        String color = (String)colores.getSelectedItem();
        boolean v = con.registrar(nombre, sexo, iglesia, edad, pago, telefono, color);
        if (v){
            JOptionPane.showMessageDialog(null, "Registrado correctamente"); 
            n.limpiar();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al inscribir, intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
}
