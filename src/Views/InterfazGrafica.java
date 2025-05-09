package Views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class InterfazGrafica extends JFrame {
    private Map<String, String> usuarios = new HashMap<>();
    private double presupuestoInicial;
    private double presupuestoActual;
    private DefaultTableModel modeloTablaInventario;
    private JTable tablaInventario;

    public InterfazGrafica() {
        setTitle("Gestión Empresarial");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // NUEVO DISEÑO DE PANTALLA CREAR USUARIO Y LOGIN
        JPanel panelCrearUsuario = new JPanel();
        panelCrearUsuario.setLayout(new BoxLayout(panelCrearUsuario, BoxLayout.Y_AXIS));
        panelCrearUsuario.setBorder(new EmptyBorder(50, 300, 50, 300));

        JLabel labelTitulo = new JLabel("Sign in to continue");
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setBorder(new EmptyBorder(10, 0, 20, 0));

        JTextField campoUsuario = new JTextField(20);
        campoUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        campoUsuario.setBorder(BorderFactory.createTitledBorder("Email or Username"));

        JPasswordField campoContrasena = new JPasswordField(20);
        campoContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        campoContrasena.setBorder(BorderFactory.createTitledBorder("Password"));

        JCheckBox checkMantenerSesion = new JCheckBox("Keep me logged in");
        checkMantenerSesion.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton botonCrearUsuario = new JButton("Register");
        botonCrearUsuario.setPreferredSize(new Dimension(100, 30));
        JButton botonLogin = new JButton("Login Now");
        botonLogin.setPreferredSize(new Dimension(100, 30));
        panelBotones.add(botonCrearUsuario);
        panelBotones.add(botonLogin);

        panelCrearUsuario.add(labelTitulo);
        panelCrearUsuario.add(campoUsuario);
        panelCrearUsuario.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCrearUsuario.add(campoContrasena);
        panelCrearUsuario.add(Box.createRigidArea(new Dimension(0, 10)));
        panelCrearUsuario.add(checkMantenerSesion);
        panelCrearUsuario.add(Box.createRigidArea(new Dimension(0, 20)));
        panelCrearUsuario.add(panelBotones);

        // PRESUPUESTO
        JPanel panelPresupuesto = new JPanel();
        panelPresupuesto.setLayout(new BoxLayout(panelPresupuesto, BoxLayout.Y_AXIS));
        panelPresupuesto.setBorder(new EmptyBorder(100, 300, 100, 300));
        JTextField campoPresupuesto = new JTextField();
        JButton botonPresupuesto = new JButton("Establecer Presupuesto");
        JLabel labelPresupuesto = new JLabel("Ingrese Presupuesto Inicial:");
        labelPresupuesto.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPresupuesto.setFont(new Font("Arial", Font.BOLD, 16));
        panelPresupuesto.add(labelPresupuesto);
        campoPresupuesto.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panelPresupuesto.add(Box.createVerticalStrut(10));
        panelPresupuesto.add(campoPresupuesto);
        panelPresupuesto.add(new JLabel());
        botonPresupuesto.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonPresupuesto.setPreferredSize(new Dimension(150, 40));
        panelPresupuesto.add(Box.createVerticalStrut(20));
        panelPresupuesto.add(botonPresupuesto);

        // INVENTARIO
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panelInventario = new JPanel(new BorderLayout());
        JPanel panelFormularioInventario = new JPanel(new GridLayout(6, 2));
        JTextField campoNombreProducto = new JTextField();
        JTextField campoPrecioUnitario = new JTextField();
        JTextField campoPrecioVenta = new JTextField();
        JTextField campoFechaLlegada = new JTextField();
        JTextField campoCantidad = new JTextField();
        JButton botonAgregarProducto = new JButton("Agregar Producto");
        JButton botonEditarProducto = new JButton("Editar Producto");
        JButton botonEliminarProducto = new JButton("Eliminar Producto");

        panelFormularioInventario.add(new JLabel("Nombre:"));
        panelFormularioInventario.add(campoNombreProducto);
        panelFormularioInventario.add(new JLabel("Precio Unitario:"));
        panelFormularioInventario.add(campoPrecioUnitario);
        panelFormularioInventario.add(new JLabel("Precio de Venta:"));
        panelFormularioInventario.add(campoPrecioVenta);
        panelFormularioInventario.add(new JLabel("Fecha de Llegada:"));
        panelFormularioInventario.add(campoFechaLlegada);
        panelFormularioInventario.add(new JLabel("Cantidad:"));
        panelFormularioInventario.add(campoCantidad);
        panelFormularioInventario.add(botonAgregarProducto);
        panelFormularioInventario.add(botonEditarProducto);

        modeloTablaInventario = new DefaultTableModel(new String[]{"Nombre", "Precio Unitario", "Precio Venta", "Fecha", "Cantidad"}, 0);
        tablaInventario = new JTable(modeloTablaInventario);
        JScrollPane scrollTablaInventario = new JScrollPane(tablaInventario);

        panelInventario.add(panelFormularioInventario, BorderLayout.WEST);
        panelInventario.add(scrollTablaInventario, BorderLayout.CENTER);
        panelInventario.add(botonEliminarProducto, BorderLayout.SOUTH);

        // SALIDAS
        JPanel panelSalidas = new JPanel(new BorderLayout());
        panelSalidas.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelSalidas.setBackground(Color.WHITE);

        JPanel panelFormularioSalidas = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField campoNombreSalida = new JTextField();
        JTextField campoCantidadSalida = new JTextField();
        JComboBox<String> comboTipoSalida = new JComboBox<>(new String[]{"Venta", "Desperdicio"});
        JButton botonRegistrarSalida = new JButton("Registrar Salida");

        panelFormularioSalidas.add(new JLabel("Nombre Producto:"));
        panelFormularioSalidas.add(campoNombreSalida);
        panelFormularioSalidas.add(new JLabel("Cantidad:"));
        panelFormularioSalidas.add(campoCantidadSalida);
        panelFormularioSalidas.add(new JLabel("Tipo de Salida:"));
        panelFormularioSalidas.add(comboTipoSalida);
        panelFormularioSalidas.add(new JLabel());
        panelFormularioSalidas.add(botonRegistrarSalida);

        DefaultTableModel modeloTablaSalidas = new DefaultTableModel(
                new String[]{"Producto", "Cantidad Salida", "Cantidad Restante", "Forma de Salida", "Presupuesto Actual"}, 0);
        JTable tablaSalidas = new JTable(modeloTablaSalidas);
        JScrollPane scrollTablaSalidas = new JScrollPane(tablaSalidas);

        panelSalidas.add(panelFormularioSalidas, BorderLayout.NORTH);
        panelSalidas.add(scrollTablaSalidas, BorderLayout.CENTER);

        // PRESUPUESTO PANEL
        JPanel panelPresupuestoTab = new JPanel(new BorderLayout());
        JLabel etiquetaPresupuesto = new JLabel("Presupuesto Actual: $0.00");
        panelPresupuestoTab.add(etiquetaPresupuesto, BorderLayout.CENTER);

        // PROVEEDORES
        JPanel panelProveedores = new JPanel(new BorderLayout());
        JPanel panelFormularioProveedores = new JPanel(new GridLayout(5, 2, 10, 10));
        panelFormularioProveedores.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextField campoNombreProveedor = new JTextField();
        JTextField campoTelefonoProveedor = new JTextField();
        JTextField campoCorreoProveedor = new JTextField();
        JTextField campoProductoProveedor = new JTextField();

        JButton botonAgregarProveedor = new JButton("Agregar Proveedor");
        JButton botonActualizarProveedor = new JButton("Actualizar Proveedor");

        panelFormularioProveedores.add(new JLabel("Nombre:"));
        panelFormularioProveedores.add(campoNombreProveedor);
        panelFormularioProveedores.add(new JLabel("Teléfono:"));
        panelFormularioProveedores.add(campoTelefonoProveedor);
        panelFormularioProveedores.add(new JLabel("Correo:"));
        panelFormularioProveedores.add(campoCorreoProveedor);
        panelFormularioProveedores.add(new JLabel("Producto a Comprar:"));
        panelFormularioProveedores.add(campoProductoProveedor);
        panelFormularioProveedores.add(botonAgregarProveedor);
        panelFormularioProveedores.add(botonActualizarProveedor);

        DefaultTableModel modeloTablaProveedores = new DefaultTableModel(
                new String[]{"Nombre", "Teléfono", "Correo", "Producto"}, 0);
        JTable tablaProveedores = new JTable(modeloTablaProveedores);
        JScrollPane scrollProveedores = new JScrollPane(tablaProveedores);

        panelProveedores.add(panelFormularioProveedores, BorderLayout.WEST);
        panelProveedores.add(scrollProveedores, BorderLayout.CENTER);

        // ENTRADA (Nuevo diseño)
        JPanel panelEntrada = new JPanel(new BorderLayout());
        JPanel panelFormularioEntrada = new JPanel();
        panelFormularioEntrada.setLayout(new BoxLayout(panelFormularioEntrada, BoxLayout.Y_AXIS));
        panelFormularioEntrada.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel labelProveedor = new JLabel("Proveedor:");
        JComboBox<String> comboProveedoresEntrada = new JComboBox<>();
        for (int i = 0; i < modeloTablaProveedores.getRowCount(); i++) {
            comboProveedoresEntrada.addItem((String) modeloTablaProveedores.getValueAt(i, 0));
        }

        JLabel labelFecha = new JLabel("Fecha del Pedido:");
        JTextField campoFecha = new JTextField();
        campoFecha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel labelProductos = new JLabel("Productos solicitados:");
        JPanel panelCheckboxProductos = new JPanel();
        panelCheckboxProductos.setLayout(new BoxLayout(panelCheckboxProductos, BoxLayout.Y_AXIS));
        JScrollPane scrollProductos = new JScrollPane(panelCheckboxProductos);
        java.util.List<JCheckBox> checkboxesProductosEntrada = new java.util.ArrayList<>();

        JLabel labelEstado = new JLabel("Estado del Pedido:");
        JComboBox<String> comboEstado = new JComboBox<>(new String[]{"Pendiente", "En proceso", "Completado"});

        JButton botonCrearPedido = new JButton("Crear Pedido");
        JButton botonEditarPedido = new JButton("Editar Pedido");

        DefaultTableModel modeloTablaPedidos = new DefaultTableModel(
                new String[]{"Proveedor", "Fecha", "Productos", "Estado"}, 0);
        JTable tablaPedidos = new JTable(modeloTablaPedidos);
        JScrollPane scrollTablaPedidos = new JScrollPane(tablaPedidos);

        // Actualizar productos al seleccionar proveedor
        comboProveedoresEntrada.addActionListener(e -> {
            panelCheckboxProductos.removeAll();
            checkboxesProductosEntrada.clear();
            String proveedorSeleccionado = (String) comboProveedoresEntrada.getSelectedItem();
            for (int i = 0; i < modeloTablaProveedores.getRowCount(); i++) {
                String nombre = (String) modeloTablaProveedores.getValueAt(i, 0);
                String producto = (String) modeloTablaProveedores.getValueAt(i, 3);
                if (nombre.equals(proveedorSeleccionado)) {
                    String[] productosSeparados = producto.split(",");
                    for (String p : productosSeparados) {
                        JCheckBox cb = new JCheckBox(p.trim());
                        checkboxesProductosEntrada.add(cb);
                        panelCheckboxProductos.add(cb);
                    }
                }
            }
            panelCheckboxProductos.revalidate();
            panelCheckboxProductos.repaint();
        });

        // Acción botón editar pedido
        botonEditarPedido.addActionListener(e -> {
            int fila = tablaPedidos.getSelectedRow();
            if (fila != -1) {
                StringBuilder productosSeleccionados = new StringBuilder();
                for (JCheckBox cb : checkboxesProductosEntrada) {
                    if (cb.isSelected()) {
                        if (productosSeleccionados.length() > 0) productosSeleccionados.append(", ");
                        productosSeleccionados.append(cb.getText());
                    }
                }
                String proveedor = (String) comboProveedoresEntrada.getSelectedItem();
                String fecha = campoFecha.getText().trim();
                String productos = productosSeleccionados.toString();
                String estado = (String) comboEstado.getSelectedItem();

                if (!fecha.isEmpty() && !productos.isEmpty()) {
                    modeloTablaPedidos.setValueAt(proveedor, fila, 0);
                    modeloTablaPedidos.setValueAt(fecha, fila, 1);
                    modeloTablaPedidos.setValueAt(productos, fila, 2);
                    modeloTablaPedidos.setValueAt(estado, fila, 3);
                } else {
                    JOptionPane.showMessageDialog(null, "Complete todos los campos para editar el pedido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un pedido para editar.");
            }
        });

        // Acción del botón
        botonCrearPedido.addActionListener(e -> {
            String proveedor = (String) comboProveedoresEntrada.getSelectedItem();
            String fecha = campoFecha.getText().trim();
            StringBuilder productosBuilder = new StringBuilder();
            for (JCheckBox cb : checkboxesProductosEntrada) {
                if (cb.isSelected()) {
                    if (productosBuilder.length() > 0) productosBuilder.append(", ");
                    productosBuilder.append(cb.getText());
                }
            }
            String productos = productosBuilder.toString();
            String estado = (String) comboEstado.getSelectedItem();

            if (proveedor != null && !fecha.isEmpty() && !productos.isEmpty()) {
                modeloTablaPedidos.addRow(new Object[]{proveedor, fecha, productos, estado});
                campoFecha.setText("");
                for (JCheckBox cb : checkboxesProductosEntrada) cb.setSelected(false);
                comboEstado.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            }
        });

        panelFormularioEntrada.add(labelProveedor);
        panelFormularioEntrada.add(comboProveedoresEntrada);
        panelFormularioEntrada.add(Box.createVerticalStrut(10));
        panelFormularioEntrada.add(labelFecha);
        panelFormularioEntrada.add(campoFecha);
        panelFormularioEntrada.add(Box.createVerticalStrut(10));
        panelFormularioEntrada.add(labelProductos);
        panelFormularioEntrada.add(scrollProductos);
        panelFormularioEntrada.add(Box.createVerticalStrut(10));
        panelFormularioEntrada.add(labelEstado);
        panelFormularioEntrada.add(comboEstado);
        panelFormularioEntrada.add(Box.createVerticalStrut(10));
        panelFormularioEntrada.add(botonCrearPedido);
        panelFormularioEntrada.add(Box.createVerticalStrut(5));
        panelFormularioEntrada.add(botonEditarPedido);

        panelEntrada.add(panelFormularioEntrada, BorderLayout.WEST);
        panelEntrada.add(scrollTablaPedidos, BorderLayout.CENTER);

        // TABS
        // Agregar listener para actualizar proveedores dinámicamente en la pestaña Entrada
        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                if (tabbedPane.getSelectedIndex() == tabbedPane.indexOfTab("Entrada")) {
                    comboProveedoresEntrada.removeAllItems();
                    for (int i = 0; i < modeloTablaProveedores.getRowCount(); i++) {
                        comboProveedoresEntrada.addItem((String) modeloTablaProveedores.getValueAt(i, 0));
                    }
                }
            }
        });
        tabbedPane.addTab("Inventario", panelInventario);
        tabbedPane.addTab("Proveedores", panelProveedores);
        tabbedPane.addTab("Entrada", panelEntrada);
        tabbedPane.addTab("Salidas", panelSalidas);
        tabbedPane.addTab("Presupuesto", panelPresupuestoTab);

        // ADD PANELES A CARDLAYOUT
        add(panelCrearUsuario, "CrearUsuario");
        add(panelPresupuesto, "Presupuesto");
        add(tabbedPane, "Principal");

        CardLayout layout = (CardLayout) getContentPane().getLayout();

        // ACCIONES
        botonCrearUsuario.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());
            if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                usuarios.put(usuario, contrasena);
                JOptionPane.showMessageDialog(this, "Usuario creado. Ahora puede iniciar sesión.");
                campoUsuario.setText("");
                campoContrasena.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Llene todos los campos para registrar un usuario.");
            }
        });

        botonLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());
            if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena)) {
                layout.show(getContentPane(), "Presupuesto");
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas o usuario no registrado.");
            }
        });

        botonPresupuesto.addActionListener(e -> {
            try {
                presupuestoInicial = Double.parseDouble(campoPresupuesto.getText());
                presupuestoActual = presupuestoInicial;
                etiquetaPresupuesto.setText("Presupuesto Actual: $" + presupuestoActual);
                layout.show(getContentPane(), "Principal");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido para el presupuesto.");
            }
        });

        botonAgregarProducto.addActionListener(e -> {
            try {
                String nombre = campoNombreProducto.getText();
                double precioUnitario = Double.parseDouble(campoPrecioUnitario.getText());
                double precioVenta = Double.parseDouble(campoPrecioVenta.getText());
                String fecha = campoFechaLlegada.getText();
                int cantidad = Integer.parseInt(campoCantidad.getText());
                double costoTotal = precioUnitario * cantidad;

                if (costoTotal <= presupuestoActual) {
                    modeloTablaInventario.addRow(new Object[]{nombre, precioUnitario, precioVenta, fecha, cantidad});
                    presupuestoActual -= costoTotal;
                    etiquetaPresupuesto.setText("Presupuesto Actual: $" + presupuestoActual);
                } else {
                    JOptionPane.showMessageDialog(this, "Presupuesto insuficiente para agregar este producto.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.");
            }
        });

        botonEditarProducto.addActionListener(e -> {
            int filaSeleccionada = tablaInventario.getSelectedRow();
            if (filaSeleccionada != -1) {
                try {
                    String nombre = campoNombreProducto.getText();
                    double precioUnitario = Double.parseDouble(campoPrecioUnitario.getText());
                    double precioVenta = Double.parseDouble(campoPrecioVenta.getText());
                    String fecha = campoFechaLlegada.getText();
                    int cantidad = Integer.parseInt(campoCantidad.getText());

                    double precioAnterior = (double) modeloTablaInventario.getValueAt(filaSeleccionada, 1);
                    int cantidadAnterior = (int) modeloTablaInventario.getValueAt(filaSeleccionada, 4);
                    double costoAnterior = precioAnterior * cantidadAnterior;
                    double costoNuevo = precioUnitario * cantidad;

                    double diferencia = costoNuevo - costoAnterior;
                    if (diferencia <= presupuestoActual) {
                        modeloTablaInventario.setValueAt(nombre, filaSeleccionada, 0);
                        modeloTablaInventario.setValueAt(precioUnitario, filaSeleccionada, 1);
                        modeloTablaInventario.setValueAt(precioVenta, filaSeleccionada, 2);
                        modeloTablaInventario.setValueAt(fecha, filaSeleccionada, 3);
                        modeloTablaInventario.setValueAt(cantidad, filaSeleccionada, 4);

                        presupuestoActual -= diferencia;
                        etiquetaPresupuesto.setText("Presupuesto Actual: $" + presupuestoActual);
                    } else {
                        JOptionPane.showMessageDialog(this, "Presupuesto insuficiente para realizar esta edición.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese valores válidos para editar el producto.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto de la tabla para editar.");
            }
        });

        botonEliminarProducto.addActionListener(e -> {
            int filaSeleccionada = tablaInventario.getSelectedRow();
            if (filaSeleccionada != -1) {
                double precioUnitario = (double) modeloTablaInventario.getValueAt(filaSeleccionada, 1);
                int cantidad = (int) modeloTablaInventario.getValueAt(filaSeleccionada, 4);
                double costoTotal = precioUnitario * cantidad;

                presupuestoActual += costoTotal;
                etiquetaPresupuesto.setText("Presupuesto Actual: $" + presupuestoActual);

                modeloTablaInventario.removeRow(filaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto para eliminar.");
            }
        });


        botonAgregarProveedor.addActionListener(e -> {
            String nombre = campoNombreProveedor.getText();
            String telefono = campoTelefonoProveedor.getText();
            String correo = campoCorreoProveedor.getText();
            String producto = campoProductoProveedor.getText();
            if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !producto.isEmpty()) {
                modeloTablaProveedores.addRow(new Object[]{nombre, telefono, correo, producto});
                campoNombreProveedor.setText("");
                campoTelefonoProveedor.setText("");
                campoCorreoProveedor.setText("");
                campoProductoProveedor.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los campos para agregar un proveedor.");
            }
        });

        botonActualizarProveedor.addActionListener(e -> {
            int filaSeleccionada = tablaProveedores.getSelectedRow();
            if (filaSeleccionada != -1) {
                try {
                    String nombre = campoNombreProveedor.getText();
                    String telefono = campoTelefonoProveedor.getText();
                    String correo = campoCorreoProveedor.getText();
                    String producto = campoProductoProveedor.getText();

                    if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !producto.isEmpty()) {
                        modeloTablaProveedores.setValueAt(nombre, filaSeleccionada, 0);
                        modeloTablaProveedores.setValueAt(telefono, filaSeleccionada, 1);
                        modeloTablaProveedores.setValueAt(correo, filaSeleccionada, 2);
                        modeloTablaProveedores.setValueAt(producto, filaSeleccionada, 3);
                    } else {
                        JOptionPane.showMessageDialog(this, "Complete todos los campos antes de actualizar.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al actualizar proveedor.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un proveedor para editar.");
            }
        });

        tablaProveedores.getSelectionModel().addListSelectionListener(e -> {
            int filaSeleccionada = tablaProveedores.getSelectedRow();
            if (filaSeleccionada != -1) {
                campoNombreProveedor.setText((String) modeloTablaProveedores.getValueAt(filaSeleccionada, 0));
                campoTelefonoProveedor.setText((String) modeloTablaProveedores.getValueAt(filaSeleccionada, 1));
                campoCorreoProveedor.setText((String) modeloTablaProveedores.getValueAt(filaSeleccionada, 2));
                campoProductoProveedor.setText((String) modeloTablaProveedores.getValueAt(filaSeleccionada, 3));
            }
        });

        botonRegistrarSalida.addActionListener(e -> {
            try {
                String nombre = campoNombreSalida.getText();
                int cantidad = Integer.parseInt(campoCantidadSalida.getText());
                String tipo = (String) comboTipoSalida.getSelectedItem();

                for (int i = 0; i < modeloTablaInventario.getRowCount(); i++) {
                    if (modeloTablaInventario.getValueAt(i, 0).equals(nombre)) {
                        int cantidadActual = (int) modeloTablaInventario.getValueAt(i, 4);
                        if (cantidad <= cantidadActual) {
                            modeloTablaInventario.setValueAt(cantidadActual - cantidad, i, 4);
                            if ("Venta".equals(tipo)) {
                                double precioVenta = (double) modeloTablaInventario.getValueAt(i, 2);
                                presupuestoActual += cantidad * precioVenta;
                                etiquetaPresupuesto.setText("Presupuesto Actual: $" + presupuestoActual);
                            }
                            modeloTablaSalidas.addRow(new Object[]{nombre, cantidad, cantidadActual - cantidad, tipo, presupuestoActual});
                        } else {
                            JOptionPane.showMessageDialog(this, "Cantidad insuficiente en inventario.");
                        }
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Campos numéricos inválidos.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazGrafica interfaz = new InterfazGrafica();
            interfaz.setVisible(true);
        });
    }
}