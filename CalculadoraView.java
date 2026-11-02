
import java.awt.*;
import javax.swing.*;


public class CalculadoraView {
    private double numero1;
    private String operador;

    private Calculadora calculadora = new Calculadora();
    public CalculadoraView() {

        JFrame janela = new JFrame("Calculadora");

        janela.setSize(300, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        //cria um painel para adicionar os componentes

        JPanel painelVisor = new JPanel(new BorderLayout());
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 5, 5));
        
        //cria o visor da calculadora
        JTextField visor = new JTextField();
        visor.setPreferredSize(new Dimension(250, 50));
        
        //botões
        JButton botao7 = new JButton("7");
        JButton botao8 = new JButton("8");
        JButton botao9 = new JButton("9");
        JButton botao4 = new JButton("4");
        JButton botao5 = new JButton("5");
        JButton botao6 = new JButton("6");
        JButton botao1 = new JButton("1");
        JButton botao2 = new JButton("2");
        JButton botao3 = new JButton("3");
        JButton botao0 = new JButton("0");

        //operadores
        JButton botaoMais = new JButton("+");
        JButton botaoSubtrair = new JButton("-");
        JButton botaoMultiplicar = new JButton("*");
        JButton botaoDividir = new JButton("/");
        JButton botaoIgual = new JButton("=");

        //limpar
        JButton botaoLimpar = new JButton("C");

        
        botao7.addActionListener(e -> {
            adicionarNumero(visor, "7");
        });
        botao8.addActionListener(e -> {
            adicionarNumero(visor, "8");
        });
        botao9.addActionListener(e -> {
            adicionarNumero(visor, "9");
        });
        botao4.addActionListener(e -> {
            adicionarNumero(visor, "4");
        });
        botao5.addActionListener(e -> {
            adicionarNumero(visor, "5");
        });
        botao6.addActionListener(e -> {
            adicionarNumero(visor, "6");
        });
        botao1.addActionListener(e -> {
            adicionarNumero(visor, "1");
        });
        botao2.addActionListener(e -> {
            adicionarNumero(visor, "2");
        });
        botao3.addActionListener(e -> {
            adicionarNumero(visor, "3");
        });
        botao0.addActionListener(e -> {
            adicionarNumero(visor, "0");
        });

        //funções dos operadores
        botaoMais.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "+";
            visor.setText("");
        });
        botaoSubtrair.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "-";
            visor.setText("");
        });
        botaoMultiplicar.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "*";
            visor.setText("");
        });
        botaoDividir.addActionListener(e -> {
            numero1 = Double.parseDouble(visor.getText());
            operador = "/";
            visor.setText("");
        });

        //função do botão igual
        botaoIgual.addActionListener(e -> {
            double numero2 = Double.parseDouble(visor.getText());
            double resultado = 0;
            switch (operador) {
                case "+" -> resultado = calculadora.somar(numero1, numero2);
                case "-" -> resultado = calculadora.subtrair(numero1, numero2);
                case "*" -> resultado = calculadora.multiplicar(numero1, numero2);
                case "/" -> resultado = calculadora.dividir(numero1, numero2);
            }
            visor.setText(String.valueOf(resultado));
        });

        //botao limpar
        botaoLimpar.addActionListener(e -> {
            visor.setText("");
            numero1 = 0;
            operador = null;
        });
        
        //elementos do painel
        painelVisor.add(visor, BorderLayout.CENTER);
        painelBotoes.add(botao7);
        painelBotoes.add(botao8);
        painelBotoes.add(botao9);
        painelBotoes.add(botaoMais);

        painelBotoes.add(botao4);
        painelBotoes.add(botao5);
        painelBotoes.add(botao6);
        painelBotoes.add(botaoSubtrair);
        
        painelBotoes.add(botao1);
        painelBotoes.add(botao2);
        painelBotoes.add(botao3);
        painelBotoes.add(botaoMultiplicar);
        
        painelBotoes.add(botaoDividir);
        painelBotoes.add(botao0);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoIgual);
        
        janela.add(painelVisor, BorderLayout.NORTH);
        janela.add(painelBotoes, BorderLayout.CENTER);

        visor.setEditable(false);
        visor.setHorizontalAlignment(JTextField.RIGHT);

        janela.setVisible(true); 
    }
    private void adicionarNumero(JTextField visor, String numero) {
        visor.setText(visor.getText() + numero);
    }
    
}
