import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URI;

public class Main {
    public static void main(String[] args) {

        ImageIcon logo = new ImageIcon("images/logo.png");
        JFrame tela = new JFrame("Windows XP");
        
        tela.setIconImage(logo.getImage());
        
        tela.setSize(1200, 700);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(null);

        ImageIcon fundo = new ImageIcon("images/wallpaper.jpg");
        Image img = fundo.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 1200, 700);

        JPanel painel = new JPanel(null);
        painel.setBounds(0, 0, 1200, 700);

        JButton app3 = new JButton(resizeIcon(new ImageIcon("images/internet_explorer.png"), 80, 80));
        JButton app5 = new JButton(resizeIcon(new ImageIcon("images/lixeira.png"), 80, 80));
        JButton app6 = new JButton(resizeIcon(new ImageIcon("images/secret.png"), 80, 80));
        
        app3.addActionListener(e -> abrirInternetExplorer(tela));
        app6.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "BOTEI VIRUS NO SEU COMPUTADOR!");
            JOptionPane.showMessageDialog(null, "To zoando, isso faz nada mesmo, fiz no tedio.");
        });
        app5.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Isso é uma lixeira bonita né?");
        });

        JButton[] apps = {app3, app5, app6};
        for (JButton app : apps) {
            app.setContentAreaFilled(false);
            app.setBorderPainted(false);
            app.setFocusPainted(false);
            app.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        app6.setBounds(50, 150, 80, 80);
        app3.setBounds(50, 250, 80, 80);
        app5.setBounds(50, 450, 80, 80);
        
        JLabel lbl3 = new JLabel("Internet Explorer", SwingConstants.CENTER);
        JLabel lbl5 = new JLabel("Lixeira", SwingConstants.CENTER);
        JLabel lbl6 = new JLabel("Secreto", SwingConstants.CENTER);
        
        lbl6.setBounds(50, 230, 80, 20);
        lbl3.setBounds(50, 330, 80, 20);
        lbl5.setBounds(50, 530, 80, 20);
        
        painel.add(app6);
        painel.add(app3);
        painel.add(app5);
        painel.add(lbl6);
        painel.add(lbl3);
        painel.add(lbl5);
        
        painel.add(background);
        tela.setContentPane(painel);
        tela.setVisible(true);
    }

    private static void abrirInternetExplorer(JFrame parent) {
        JDialog ie = new JDialog(parent, "Internet Explorer", true);
        ie.setSize(600, 400);
        ie.setLayout(null);
        ie.setLocationRelativeTo(parent);

        JTextField barraEndereco = new JTextField("https://github.com/ThiagoBel/");
        JButton botaoIr = new JButton("Ir");
        barraEndereco.setBounds(10, 10, 450, 30);
        botaoIr.setBounds(470, 10, 60, 30);

        JLabel areaExibicao = new JLabel("Olá!", SwingConstants.CENTER);
        areaExibicao.setBounds(50, 100, 500, 200);
        areaExibicao.setOpaque(true);
        areaExibicao.setBackground(Color.LIGHT_GRAY);

        botaoIr.addActionListener(e -> {
            String url = barraEndereco.getText().trim();
            if ("https://linktr.ee/guitarduck34/".equals(url)) {
                abrirNavegador(url);
            } else if ("odeioGuitarDuck".equals(url)) {
                JOptionPane.showMessageDialog(null, "O GuitarDuck é bom!!!!!!!!!!!!!!!");
            } else {
                abrirNavegador(url);
            }
        });

        ie.add(barraEndereco);
        ie.add(botaoIr);
        ie.add(areaExibicao);
        ie.setVisible(true);
    }

    private static void abrirNavegador(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}