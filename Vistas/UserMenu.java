
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class UserMenu extends javax.swing.JFrame {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados;
    
    
    public UserMenu() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(this);
        listarEmpleados();
    }

    private void listarEmpleados() throws SQLException{
        //Si no hay nada en el campo de busqueda se cargaran todos los empleados
        String filtroBusqueda = txtSearch.getText();
        if(filtroBusqueda.isEmpty()){
        String query = "SELECT *FROM empleados";
        try{connection = conexion.getConnection();
            //Creamos la consulta query para la base de datos 
            st = connection.createStatement();
            rs = st.executeQuery(query);
            //Asignar en un objeto los datos que devuelve de cada registro
            Object [] empleado = new Object [6];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            //El resultado de la consulta del query nos determinara la cantidad de empleados que existen
            while(rs.next()){
                empleado[0]= rs.getInt("idEmp");
                empleado[1]= rs.getString("nombreEmp");
                empleado[2]= rs.getString("apellidos");
                empleado[3]= rs.getString("tipoDocumento");
                empleado[4]= rs.getString("documento");
                empleado[5]= rs.getString("correo");
                //En la tabla creamos una nueva fila con los cinco atributos del objeto empleado.
                contenidoTablaEmpleados.addRow(empleado);
                tblEmpleados.setModel(contenidoTablaEmpleados);
                System.out.println("idEmp: " + empleado[0]+ ", nombre: "+ empleado[1]+ " "
                + ", documento: " + empleado[2]+ " "+ empleado[3]+ ", correo: " +empleado[4]);
            }
        }catch(SQLException e){
            System.out.println("No se pudo cargar la información de los empleados");
        }
    }else {
            String query = "SELECT * FROM empleados WHERE nombreEmp like'%"+filtroBusqueda+"%'OR apellidos like'%"+filtroBusqueda+"%';";
            System.out.println(filtroBusqueda + "\n" +query);
            try{connection = conexion.getConnection();
            //Creamos la consulta query para la base de datos 
            st = connection.createStatement();
            rs = st.executeQuery(query);
            //Asignar en un objeto los datos que devuelve de cada registro
            Object [] empleado = new Object [6];
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            //El resultado de la consulta del query nos determinara la cantidad de empleados que existen
            while(rs.next()){
                empleado[0]= rs.getInt("idEmp");
                empleado[1]= rs.getString("nombreEmp");
                empleado[2]= rs.getString("apellidos");
                empleado[3]= rs.getString("tipoDocumento");
                empleado[4]= rs.getString("documento");
                empleado[5]= rs.getString("correo");
                //En la tabla creamos una nueva fila con los cinco atributos del objeto empleado.
                contenidoTablaEmpleados.addRow(empleado);
                tblEmpleados.setModel(contenidoTablaEmpleados);
                System.out.println("idEmp: " + empleado[0]+ ", nombre: "+ empleado[1]+ " "
                + ", documento: " + empleado[2]+ " "+ empleado[3]+ ", correo: " +empleado[4]);
            }
        }catch(SQLException e){
            System.out.println("No se pudo cargar la información de los empleados");
        }
        }
    }
    private void borrarRegistroTabla(){
        //getRowCount devuelve la cantidad de filas que tiene la tabla
        for (int i = 0; i < tblEmpleados.getRowCount(); i++){
            contenidoTablaEmpleados.removeRow(i);
            //Cada vez que se elimina una fila deden quedar menos filas por eliminar
            i = i-1;
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(207, 207, 207));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/mintic.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdEmp", "Nombre", "Apellido(s)", "Tipo de documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/emAñadir.png"))); // NOI18N
        btnAddUser.setText("Añadir");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("EMPLEADOS");

        jLabel3.setText("Mision TIC 2022");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Buscar:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/busqueda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser)
                .addGap(38, 38, 38))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(252, 252, 252)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Empleados", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
       AddUserForm addUserForm = new AddUserForm(this, true);
       addUserForm.setVisible(true);
       //Actualización de la información
       borrarRegistroTabla();
        try {
            listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarRegistroTabla();
        try {
            listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
       int filaSeleccionada = tblEmpleados.getSelectedRow();
       System.out.println("Fila seleccionada: "+ filaSeleccionada);
       //Se convierte el texto que se captura de la tabla en entero
       int idEmp = Integer.parseInt(tblEmpleados.getValueAt(filaSeleccionada, 0).toString());
       String nombreEmp = tblEmpleados.getValueAt(filaSeleccionada, 1).toString();
       String apellidos = tblEmpleados.getValueAt(filaSeleccionada, 2).toString();
       String tipoDocumento = tblEmpleados.getValueAt(filaSeleccionada, 3).toString();
       String documento =tblEmpleados.getValueAt(filaSeleccionada, 4).toString();
       String correo = tblEmpleados.getValueAt(filaSeleccionada, 5).toString();
       
       String empleadoSeleccionado = "{\n     idEmp: " + idEmp + ",\n    nombre: " + nombreEmp + " "
               + apellidos + ",\n   documento: " + tipoDocumento + " " + documento 
               + ",\n    correo: " + correo + "\n}";
       
       System.out.println(empleadoSeleccionado);
       //Instancia el constructor del JDialog
       ShowUserForm showUserForm = new ShowUserForm(this,true);
       //Cargamos la información 
       showUserForm.recibirDatosDeAddUserMenu(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
       //Se hace visible
       showUserForm.setVisible(true);
       this.borrarRegistroTabla();
        try {
            this.listarEmpleados();
        } catch (SQLException ex) {
            Logger.getLogger(UserMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
