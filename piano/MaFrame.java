package piano;
import java.awt.Color;
import java.awt.event.*;

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MaFrame extends JFrame implements MouseListener, ActionListener {

    public MaFrame(){
        setSize(500,300);
        setTitle("Voilà une fenêtre");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        switch(e.getActionCommand()){
   
            case "DO4": 
                playNote(60, 0);
                break;
        
            case "RE":
                playNote(62, 0);
                break;
        
            case "MI":
                playNote(64, 0);
                break;
            case "FA":
                playNote(65, 0);
                break;
            case "SOL":
                playNote(67, 0);
                break;
            case "LA":
                playNote(67, 0);
                break;
            case "SI":
                playNote(69, 0);
                break;
            case "DO5":
                playNote(70, 0);
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }
        
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
}
