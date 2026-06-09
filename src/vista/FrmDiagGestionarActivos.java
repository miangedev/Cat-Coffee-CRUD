package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminActivosBD;
import modelo.AdminCategoriasBD;
import modelo.AdminPrestamosActivoPersonasBD;
import modelo.AdminPersonasBD;
import modelo.activos;
import modelo.categorias;
import modelo.personas;
import modelo.prestamosactivopersonas;

public class FrmDiagGestionarActivos extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    AdminActivosBD objAdmActBD = new AdminActivosBD();
    AdminCategoriasBD objAdmCatBD = new AdminCategoriasBD();
    AdminPrestamosActivoPersonasBD objAdmPrestaBD = new AdminPrestamosActivoPersonasBD();
    AdminPersonasBD objAdmPerBD = new AdminPersonasBD();
    personas objPersonaActual = new personas();
    java.util.ArrayList<Integer> idsPorFila = new java.util.ArrayList<>();
    int idActivoSeleccionado = 0;

    public FrmDiagGestionarActivos(javax.swing.JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.cargarCategorias();
        this.refrescarTabla(0);
    }

    private void configurarTabla() {
        String cabecera[] = { "Nombre", "Tipo", "Marca", "Modelo", "Año Adq.", "Valor Comercial", "Estado" };
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblActivos.setModel(this.modeloTabla);

        this.tblActivos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblActivos.getSelectedRow() >= 0) {
                int fila = tblActivos.getSelectedRow();
                if (fila < idsPorFila.size()) {
                    idActivoSeleccionado = idsPorFila.get(fila);
                    lblActivoSeleccionado.setText("Activo: " + modeloTabla.getValueAt(fila, 0).toString()
                            + " | " + modeloTabla.getValueAt(fila, 2).toString()
                            + " | Estado: " + modeloTabla.getValueAt(fila, 6).toString());
                }
            }
        });
    }

    private void cargarCategorias() {
        cmbCategoria.addItem("-- Todas las categorias --");
        for (Object obj : objAdmCatBD.listarTodo()) {
            categorias objCat = (categorias) obj;
            cmbCategoria.addItem(objCat.getNombre());
        }
    }

    private void refrescarTabla(int categoriaFiltro) {
        modeloTabla.setNumRows(0);
        idsPorFila.clear();
        int count = 0;
        String estadoFiltro = cmbEstado.getSelectedItem().toString();

        for (Object obj : objAdmActBD.listarTodo()) {
            activos objActivo = (activos) obj;
            boolean categoriaOk = categoriaFiltro == 0 || objActivo.getCATEGORIAS_id() == categoriaFiltro;
            boolean estadoOk = estadoFiltro.equals("TODOS") || objActivo.getEstado().equals(estadoFiltro);

            if (categoriaOk && estadoOk) {
                String[] fila = {
                        objActivo.getNombre(),
                        objActivo.getTipo(),
                        objActivo.getMarca(),
                        objActivo.getModelo(),
                        objActivo.getAno_adquisicion(),
                        Double.toString(objActivo.getValor_comercial()),
                        objActivo.getEstado()
                };
                modeloTabla.addRow(fila);
                idsPorFila.add(objActivo.getId());
                count++;
            }
        }
        lblStatus.setText(count + " activo(s) - " + estadoFiltro);
        idActivoSeleccionado = 0;
        lblActivoSeleccionado.setText("Ningún activo seleccionado");
        tblActivos.clearSelection();
    }

    private void buscarPorNombre(String termino) {
        modeloTabla.setNumRows(0);
        idsPorFila.clear();
        int count = 0;

        for (Object obj : objAdmActBD.listarTodo()) {
            activos objActivo = (activos) obj;
            boolean nombreOk = objActivo.getNombre().toLowerCase().contains(termino.toLowerCase());
            boolean disponible = objActivo.getEstado().equals("DISPONIBLE");

            if (nombreOk && disponible) {
                String[] fila = {
                        objActivo.getNombre(),
                        objActivo.getTipo(),
                        objActivo.getMarca(),
                        objActivo.getModelo(),
                        objActivo.getAno_adquisicion(),
                        Double.toString(objActivo.getValor_comercial()),
                        objActivo.getEstado()
                };
                modeloTabla.addRow(fila);
                idsPorFila.add(objActivo.getId());
                count++;
            }
        }
        lblStatus.setText(count + " resultado(s) para: " + termino);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelBuscar = new javax.swing.JLabel();
        jLabelDoc = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        lblActivoSeleccionado = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnBuscarPersona = new javax.swing.JButton();
        btnPrestar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActivos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabelEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestionar Activo Promocional");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categoria:");

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setText("Estado:");

        cmbEstado.addItem("DISPONIBLE");
        cmbEstado.addItem("PRESTADO");
        cmbEstado.addItem("RESERVADO");
        cmbEstado.addItem("TODOS");
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarTabla(0);
            }
        });

        jLabelBuscar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBuscar.setText("Buscar por nombre:");

        jLabelDoc.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelDoc.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoc.setText("Documento Persona:");

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");

        jLabelEmail.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText("Email:");

        jLabelFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaInicio.setText("Fecha Inicio (YYYY-MM-DD):");

        jLabelFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 13));
        jLabelFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaFin.setText("Fecha Fin Programada (YYYY-MM-DD):");

        labNombre.setFont(new java.awt.Font("Segoe UI", 0, 13));
        labNombre.setForeground(new java.awt.Color(200, 255, 200));
        labNombre.setText("---");

        labEmail.setFont(new java.awt.Font("Segoe UI", 0, 13));
        labEmail.setForeground(new java.awt.Color(200, 255, 200));
        labEmail.setText("---");

        lblActivoSeleccionado.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblActivoSeleccionado.setForeground(new java.awt.Color(200, 200, 255));
        lblActivoSeleccionado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActivoSeleccionado.setText("Ningún activo seleccionado");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblStatus.setForeground(new java.awt.Color(200, 255, 200));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Cargando...");

        btnFiltrar.setBackground(new java.awt.Color(0, 51, 51));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBuscarPersona.setBackground(new java.awt.Color(0, 51, 51));
        btnBuscarPersona.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnBuscarPersona.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarPersona.setText("Buscar Persona");
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });

        btnPrestar.setBackground(new java.awt.Color(0, 51, 51));
        btnPrestar.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnPrestar.setForeground(new java.awt.Color(255, 255, 255));
        btnPrestar.setText("Registrar Prestamo");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 51, 51));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        jScrollPane1.setViewportView(tblActivos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnFiltrar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelBuscar)
                                .addGap(10, 10, 10)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnBuscar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblActivoSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, 650,
                                        Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelDoc)
                                .addGap(10, 10, 10)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnBuscarPersona)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelNombre)
                                .addGap(10, 10, 10)
                                .addComponent(labNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelEmail)
                                .addGap(10, 10, 10)
                                .addComponent(labEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelFechaInicio)
                                .addGap(10, 10, 10)
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelFechaFin)
                                .addGap(10, 10, 10)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnPrestar)
                                .addGap(20, 20, 20)
                                .addComponent(btnSalir)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                                .addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2).addComponent(cmbCategoria).addComponent(btnFiltrar))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelBuscar)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar))
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblActivoSeleccionado)
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDoc)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscarPersona))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNombre).addComponent(labNombre))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEmail).addComponent(labEmail))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFechaInicio)
                                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFechaFin).addComponent(txtFechaFin,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnPrestar).addComponent(btnSalir))
                                .addGap(8, 8, 8)
                                .addComponent(lblStatus)
                                .addGap(15, 15, 15)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {
        int index = cmbCategoria.getSelectedIndex();
        if (index == 0) {
            refrescarTabla(0);
        } else {
            String nombreCat = cmbCategoria.getSelectedItem().toString();
            int idCat = 0;
            for (Object obj : objAdmCatBD.listarTodo()) {
                categorias objCat = (categorias) obj;
                if (objCat.getNombre().equals(nombreCat)) {
                    idCat = objCat.getId();
                    break;
                }
            }
            refrescarTabla(idCat);
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String termino = txtBuscar.getText().trim();
        if (termino.isEmpty()) {
            refrescarTabla(0);
        } else {
            buscarPorNombre(termino);
        }
    }

    private void btnBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {
        String doc = txtDocumento.getText().trim();
        if (doc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de documento.");
            return;
        }
        objPersonaActual = objAdmPerBD.buscarPorDocumento(doc);
        if (objPersonaActual.getId() == 0) {
            JOptionPane.showMessageDialog(this, "!!! La persona no se encuentra en el sistema !!!");
            labNombre.setText("---");
            labEmail.setText("---");
            objPersonaActual = new personas();
        } else {
            labNombre.setText(objPersonaActual.getNombre());
            labEmail.setText(objPersonaActual.getEmail());
            lblStatus.setText("Persona encontrada: " + objPersonaActual.getNombre());
        }
    }

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {
        if (idActivoSeleccionado == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un activo de la tabla.");
            return;
        }
        if (objPersonaActual.getId() == 0) {
            JOptionPane.showMessageDialog(this, "Busque y seleccione una persona primero.");
            return;
        }
        if (txtFechaInicio.getText().trim().isEmpty() || txtFechaFin.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese las fechas de inicio y fin.");
            return;
        }

        // Registrar prestamo
        prestamosactivopersonas objPrestamo = new prestamosactivopersonas();
        objPrestamo.setFecha_inicio(txtFechaInicio.getText().trim());
        objPrestamo.setFecha_fin_programa(txtFechaFin.getText().trim());
        objPrestamo.setFecha_entrega_real(null);
        objPrestamo.setEstado("ACTIVO");
        objPrestamo.setPERSONAS_id(objPersonaActual.getId());
        objPrestamo.setACTIVOS_id(idActivoSeleccionado);
        objAdmPrestaBD.insertar(objPrestamo);

        // Cambiar estado del activo a PRESTADO
        objAdmActBD.actualizarEstado(idActivoSeleccionado, "PRESTADO");

        JOptionPane.showMessageDialog(this, "!!! El prestamo fue registrado exitosamente !!!");
        lblStatus.setText("Prestamo registrado para: " + objPersonaActual.getNombre());

        // Limpiar
        txtDocumento.setText("");
        txtFechaInicio.setText("");
        txtFechaFin.setText("");
        labNombre.setText("---");
        labEmail.setText("---");
        objPersonaActual = new personas();
        refrescarTabla(0);
        cmbCategoria.setSelectedIndex(0);
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelDoc;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel lblActivoSeleccionado;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblActivos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabelEstado;
    // End of variables declaration
}