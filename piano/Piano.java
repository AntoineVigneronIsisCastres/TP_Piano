package piano;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Piano {
    public static void main(String[] args) {
        JFrame fen = new MaFrame();
        
        JLabel j11 = new JLabel("Superbe Etiquette");
        JLabel j12 = new JLabel("Magnifique Etiquette");
        
        JButton do4 = new JButton("DO4");
        JButton re = new JButton("RE");
        JButton mi = new JButton("MI");
        JButton fa = new JButton("FA");
        JButton sol = new JButton("SOL");
        JButton la = new JButton("LA");
        JButton si = new JButton("SI");
        JButton do5 = new JButton("DO5");

        fen.addMouseListener((MouseListener) fen);
        do4.addActionListener((ActionListener) fen);
        re.addActionListener((ActionListener) fen);
        mi.addActionListener((ActionListener) fen);
        fa.addActionListener((ActionListener) fen);
        sol.addActionListener((ActionListener) fen);
        la.addActionListener((ActionListener) fen);
        si.addActionListener((ActionListener) fen);
        do5.addActionListener((ActionListener) fen);

        Container fenCont = fen.getContentPane();
        fenCont.setLayout(new BorderLayout());
        
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1,3));
        jp.add(do4); jp.add(re); jp.add(mi); jp.add(fa); jp.add(sol); jp.add(la); jp.add(si); jp.add(do5);
        fen.getContentPane().add(jp);
        
        fenCont.add(j11, BorderLayout.NORTH);
        fenCont.add(jp, BorderLayout.CENTER);
        fenCont.add(j12, BorderLayout.SOUTH);
        fen.setVisible(true);
    }
}