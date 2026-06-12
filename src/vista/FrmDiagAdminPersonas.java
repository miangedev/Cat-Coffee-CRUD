package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminPersonasBD;
import modelo.personas;

public class FrmDiagAdminPersonas extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    AdminPersonasBD objAdmPerBD = new AdminPersonasBD();

    public FrmDiagAdminPersonas(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.refrescarTabla();
    }
    

    private void configurarTabla() {
        String cabecera[] = {"ID", "Tipo Doc", "Num Doc", "Razon Social", "Telefono", "Email", "Direccion", "ID Rol", "Nombre"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblPersonas.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {
        this.modeloTabla.setNumRows(0);
        String filaDeTabla[] = new String[9];

        for (Object obj : objAdmPerBD.listarTodo()) {
            personas objPersona = (personas) obj;
            filaDeTabla[0] = Integer.toString(objPersona.getId());
            filaDeTabla[1] = objPersona.getTipo_documento();
            filaDeTabla[2] = objPersona.getNumero_documento();
            filaDeTabla[3] = objPersona.getRazon_social();
            filaDeTabla[4] = objPersona.getTelefono();
            filaDeTabla[5] = objPersona.getEmail();
            filaDeTabla[6] = objPersona.getDireccion();
            filaDeTabla[7] = Integer.toString(objPersona.getROL_id());
            filaDeTabla[8] = objPersona.getNombre();
            this.modeloTabla.addRow(filaDeTabla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Personas");

        jScrollPane1.setViewportView(tblPersonas);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(55, 55, 55)
                        .addComponent(btnModificar)
                        .addGap(65, 65, 65)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        personas objPersona = new personas();
        FrmDiagAdminPersonasAgregar objFrm = new FrmDiagAdminPersonasAgregar((javax.swing.JFrame) null, true, objPersona);
        objFrm.setLocationRelativeTo(null);
        objFrm.setVisible(true);
        objAdmPerBD.insertar(objPersona);
        this.refrescarTabla();
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.tblPersonas.getSelectedRow() >= 0) {
            personas objPersona = new personas();
            int id = Integer.parseInt(this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 0).toString());
            objPersona.setId(id);
            objPersona = (personas) objAdmPerBD.listarUno(objPersona);

            FrmDiagAdminPersonasModificar objFrm = new FrmDiagAdminPersonasModificar((javax.swing.JFrame) null, true, objPersona);
            objFrm.setLocationRelativeTo(null);
            objFrm.setVisible(true);

            objAdmPerBD.actualizar(objPersona);
            this.refrescarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "!!! Por favor, seleccione una Persona !!!");
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.tblPersonas.getSelectedRow() >= 0) {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que quiere eliminar esta persona?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                personas objPersona = new personas();
                int id = Integer.parseInt(this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 0).toString());
                objPersona.setId(id);
                if (objAdmPerBD.eliminar(objPersona)) {
                    JOptionPane.showMessageDialog(this, "!!! La persona se eliminó exitosamente !!!");
                } else {
                    JOptionPane.showMessageDialog(this, "!!! No se pudo eliminar la persona !!!");
                }
                this.refrescarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "!!! Por favor, seleccione una Persona !!!");
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonas;
    // End of variables declaration
}