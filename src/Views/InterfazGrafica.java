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

        JPanel panelCrearUsuario = new JPanel(new GridLayout(3, 2));
        JTextField campoUsuario = new JTextField();
        JPasswordField campoContrasena = new JPasswordField();
        JButton botonCrearUsuario = new JButton("Crear Usuario");
        panelCrearUsuario.add(new JLabel("Usuario:"));
        panelCrearUsuario.add(campoUsuario);
        panelCrearUsuario.add(new JLabel("Contraseña:"));
        panelCrearUsuario.add(campoContrasena);
        panelCrearUsuario.add(new JLabel());
        panelCrearUsuario.add(botonCrearUsuario);

        JPanel panelLogin = new JPanel(new GridLayout(3, 2));
        JTextField campoUsuarioLogin = new JTextField();
        JPasswordField campoContrasenaLogin = new JPasswordField();
        JButton botonLogin = new JButton("Iniciar Sesión");
        panelLogin.add(new JLabel("Usuario:"));
        panelLogin.add(campoUsuarioLogin);
        panelLogin.add(new JLabel("Contraseña:"));
        panelLogin.add(campoContrasenaLogin);
        panelLogin.add(new JLabel());
        panelLogin.add(botonLogin);

        JPanel panelPresupuesto = new JPanel(new GridLayout(2, 2));
        JTextField campoPresupuesto = new JTextField();
        JButton botonPresupuesto = new JButton("Establecer Presupuesto");
        panelPresupuesto.add(new JLabel("Presupuesto Inicial:"));
        panelPresupuesto.add(campoPresupuesto);
        panelPresupuesto.add(new JLabel());
        panelPresupuesto.add(botonPresupuesto);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panelInventario = new JPanel(new BorderLayout());
        JPanel panelFormularioInventario = new JPanel(new GridLayout(6, 2));
        JTextField campoNombreProducto = new JTextField();
        JTextField campoPrecioUnitario = new JTextField();
        JTextField campoPrecioVenta = new JTextField();
        JTextField campoFechaLlegada = new JTextField();
        JTextField campoCantidad = new JTextField();
        JButton botonAgregarProducto = new JButton("Agregar Producto");
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

        modeloTablaInventario = new DefaultTableModel(new String[]{"Nombre", "Precio Unitario", "Precio Venta", "Fecha", "Cantidad"}, 0);
        tablaInventario = new JTable(modeloTablaInventario);
        JScrollPane scrollTablaInventario = new JScrollPane(tablaInventario);

        panelInventario.add(panelFormularioInventario, BorderLayout.WEST);
        panelInventario.add(scrollTablaInventario, BorderLayout.CENTER);
        panelInventario.add(botonEliminarProducto, BorderLayout.SOUTH);

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
                new String[]{"Producto", "Cantidad", "Forma de Salida", "Presupuesto Actual"}, 0);
        JTable tablaSalidas = new JTable(modeloTablaSalidas);
        JScrollPane scrollTablaSalidas = new JScrollPane(tablaSalidas);

        panelSalidas.add(panelFormularioSalidas, BorderLayout.NORTH);
        panelSalidas.add(scrollTablaSalidas, BorderLayout.CENTER);

        JPanel panelPresupuestoTab = new JPanel(new BorderLayout());
        JLabel etiquetaPresupuesto = new JLabel("Presupuesto Actual: $0.00");
        panelPresupuestoTab.add(etiquetaPresupuesto, BorderLayout.CENTER);

        tabbedPane.addTab("Inventario", panelInventario);
        tabbedPane.addTab("Salidas", panelSalidas);
        tabbedPane.addTab("Presupuesto", panelPresupuestoTab);

        add(panelCrearUsuario, "CrearUsuario");
        add(panelLogin, "Login");
        add(panelPresupuesto, "Presupuesto");
        add(tabbedPane, "Principal");

        CardLayout layout = (CardLayout) getContentPane().getLayout();

        botonCrearUsuario.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());
            if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                usuarios.put(usuario, contrasena);
                layout.show(getContentPane(), "Login");
            }
        });

        botonLogin.addActionListener(e -> {
            String usuario = campoUsuarioLogin.getText();
            String contrasena = new String(campoContrasenaLogin.getPassword());
            if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasena)) {
                layout.show(getContentPane(), "Presupuesto");
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
                            modeloTablaSalidas.addRow(new Object[]{nombre, cantidad, tipo, presupuestoActual});
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