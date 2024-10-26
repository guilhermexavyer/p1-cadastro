import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        lblNome.setBounds(10, 10, 200, 25);
        panel.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(10, 30, 200, 25);
        panel.add(txtNome);

        JLabel lblCPF = new JLabel("CPF");
        lblCPF.setBounds(10, 60, 200, 25);
        panel.add(lblCPF);

        JTextField txtCPF = new JTextField();
        txtCPF.setBounds(10, 80, 200, 25);
        panel.add(txtCPF);

        JLabel lblRG = new JLabel("RG");
        lblRG.setBounds(10, 110, 200, 25);
        panel.add(lblRG);

        JTextField txtRG = new JTextField();
        txtRG.setBounds(10, 130, 200, 25);
        panel.add(txtRG);

        JLabel lblEndereco = new JLabel("Endereço");
        lblEndereco.setBounds(10, 160, 200, 25);
        panel.add(lblEndereco);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(10, 180, 200, 25);
        panel.add(txtEndereco);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(10, 210, 200, 25);
        panel.add(lblTelefone);

        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(10, 230, 200, 25);
        panel.add(txtTelefone);

        JLabel lblEmailDestino = new JLabel("Email de destino");
        lblEmailDestino.setBounds(10, 260, 200, 25);
        panel.add(lblEmailDestino);

        JTextField txtEmailDestino = new JTextField();
        txtEmailDestino.setBounds(10, 280, 200, 25);
        panel.add(txtEmailDestino);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 310, 200, 25);
        panel.add(btnSalvar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(10, 340, 200, 25);
        panel.add(btnExcluir);

        JButton btnEnviarEmail = new JButton("Enviar no Email");
        btnEnviarEmail.setBounds(10, 370, 200, 25);
        panel.add(btnEnviarEmail);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(txtNome.getText());
                cliente.setCpf(txtCPF.getText());
                cliente.setRg(txtRG.getText());
                cliente.setEndereco(txtEndereco.getText());
                cliente.setTelefone(txtTelefone.getText());
                geraArquivo(cliente);
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluiArquivo();
            }
        });

        btnEnviarEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarEmail(txtEmailDestino.getText());
            }
        });

        tela.setVisible(true);
    }

    private static void geraArquivo(Cliente cliente) {
        String caminhoArquivo = "p1-cadastro.txt";

        File arquivo = new File(caminhoArquivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("Nome: " + cliente.getNome() + "\n");
            writer.write("CPF: " + cliente.getCpf() + "\n");
            writer.write("RG: " + cliente.getRg() + "\n");
            writer.write("Endereço: " + cliente.getEndereco() + "\n");
            writer.write("Telefone: " + cliente.getTelefone() + "\n");
            JOptionPane.showMessageDialog(
                null,
                "Arquivo criado",
                "Arquivo",
                1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                null,
                "Erro ao gravar dados",
                "Erro",
                0);
            e.printStackTrace();
        }
    }

    private static void excluiArquivo() {
        String caminhoArquivo = "p1-cadastro.txt";

        File arquivo = new File(caminhoArquivo);

        if (arquivo.delete()) {
            JOptionPane.showMessageDialog(null,
            "Arquivo excluido",
            "Arquivo",
            1);
        } else {
            JOptionPane.showMessageDialog(null,
            "Erro ao excluir arquivo",
            "Erro",
            1);
        }
    }

    private static void enviarEmail(String emailDestino) {
        // Configurações do servidor SMTP
        String host = "smtp.gmail.com";
        final String user = "guilhermexavierpessoal@gmail.com";
        final String password = "Topeira.01";

        String para = emailDestino;

        // Propriedades do servidor SMTP
        Properties proprieties = new Properties();
        proprieties.put("mail.smtp.host", host);
        proprieties.put("mail.smtp.host", true);
        proprieties.put("mail.smtp.host", 587); // 587 ou 465
        proprieties.put("mail.smtp.starttls.host", true); // Requer STARTTLS

        // Criação de uma sessão com autenticação
        Session session = null;
        try {
            session = Session.getInstance(proprieties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
            "Erro ao conectar ao gmail." + e.getMessage(),
            "Erro",
            0);
        }

        try {
            // Criação da mensagem
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
            message.setSubject("Teste de envio de e-mail na disciplina de Programação I");
            message.setText("Estou enviando um email de teste.");

            // Envio do e-mail
            Transport.send(message);

            JOptionPane.showMessageDialog(null,
            "Email enviado",
            "E-mail",
            0);

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null,
            "Erro ao enviar e-mail. " + e.getMessage(),
            "Erro",
            0);
        }
    }
}