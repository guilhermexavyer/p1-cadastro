import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCliente {
    public static void main(String[] args) {
        JFrame tela = new JFrame("Primeira tela");
        JPanel panel = new JPanel();

        tela.setSize(800, 400);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.add(panel);

        panel.setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 10, 150, 25);
        panel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 30, 150, 25);
        panel.add(txtNome);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setBounds(10, 60, 150, 25);
        panel.add(lblCPF);

        JTextField txtCPF = new JTextField();
        txtCPF.setBounds(10, 80, 150, 25);
        panel.add(txtCPF);

        JLabel lblRG = new JLabel("RG");
        lblRG.setBounds(10, 110, 150, 25);
        panel.add(lblRG);

        JTextField txtRG = new JTextField();
        txtRG.setBounds(10, 130, 150, 25);
        panel.add(txtRG);

        JLabel lblEndereco = new JLabel("Endereço");
        lblEndereco.setBounds(10, 160, 150, 25);
        panel.add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(10, 180, 150, 25);
        panel.add(txtEndereco);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 210, 150, 25);
        panel.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 230, 150, 25);
        panel.add(txtTelefone);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 270, 150, 25);
        panel.add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnSalvar, "Clique no botão Salvar",
                "Teste de clique no botão",
                1);
            }
        });

        tela.setVisible(true);
    }
}