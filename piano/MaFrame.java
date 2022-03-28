package piano;
import java.awt.Color;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class MaFrame extends JFrame implements MouseListener, ActionListener {

    Map<String,Integer> notes = new HashMap<String,Integer>();
    protected JLabel j11;
    protected JLabel j12;

    public MaFrame(){
        j11 = new JLabel("Superbe Etiquette");
        j12 = new JLabel("Magnifique Etiquette");
        setSize(500,300);
        setTitle("Voilà une fenêtre");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        notes.put("DO4",60);
        notes.put("RE",62);
        notes.put("MI",64);
        notes.put("FA",65);
        notes.put("SOL",67);
        notes.put("LA",69);
        notes.put("SI",71);
        notes.put("DO5",72);
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("souris cliquée ds la fenetre");
    }

    public void mousePressed(java.awt.event.MouseEvent e) {
        System.out.println("souris pressee ds la fenetre");
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
        System.out.println("souris relachée ds la fenetre");
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
        this.getContentPane().setBackground(Color.pink);
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
        this.getContentPane().setBackground(Color.green);
    }

    public void actionPerformed(java.awt.event.MouseEvent e) {
        System.out.println("Bouton pressé hé hé hé");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Plonk");
        System.out.println(e.getActionCommand());
        playNote(notes.get(e.getActionCommand()), 0);
        j12.setText(""+notes.get(e.getActionCommand())+" de code midi :"+e.getActionCommand());
        
    }

    public void playNote(int finalNote, int finalInstrument) {

        new Thread(new Runnable() {
    
            @Override
    
            public void run() {
    
                try {
    
                    Synthesizer synth = MidiSystem.getSynthesizer();
    
                    synth.open();
    
                    MidiChannel[] channels = synth.getChannels();
    
                    channels[1].programChange(finalInstrument);
    
                    channels[1].noteOn(finalNote, 100);
    
                    Thread.sleep(1000);
    
                    channels[1].noteOff(finalNote);
    
                } catch (MidiUnavailableException | InterruptedException ex) {
    
                    ex.printStackTrace();
    
                }
    
            }
    
        }).start();
    
    }

    public JLabel getNote() {
        return this.j12;
    }
}
