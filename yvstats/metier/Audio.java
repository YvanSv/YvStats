package yvstats.metier;

import  java.io.*;
import javax.sound.sampled.*;

import yvstats.Controleur;
 
 
public class Audio extends Thread {
    private Controleur ctrl;
    private SourceDataLine line;
    private String link;
    private float vol;
    private boolean play;
    private boolean stop;

    public Audio(Controleur ctrl) {
        this.ctrl = ctrl;
        this.play = true;
        this.stop = false;
        this.setVolume(50);
    }

    public void setLink(String s) {
        this.link = s;
    }

    public void setVolume(float vol) {
        if (this.line != null) {
            FloatControl volume = (FloatControl) this.line.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(20.0f * (float) Math.log10( vol / 300.0 ));
        }
        this.vol = 20.0f * (float) Math.log10( vol / 300.0 );
    }

    public void pause() {
        this.play = false;
    }

    public void unpause() {
        this.play = true;
    }

    public void setTime(int i) {
        
    }

    public void arreter() {
        this.stop = true;
    }

    public void run(){
        System.out.println("Playing " + link);
        AudioInputStream audioInputStream = null;
        File fichier = new File("../ressources/audio/"+link+".wav");
        try { audioInputStream = AudioSystem.getAudioInputStream(fichier); }
        catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }

        AudioFormat audioFormat = audioInputStream.getFormat();
        DataLine.Info info = new DataLine.Info(SourceDataLine.class,audioFormat);

        try { line = (SourceDataLine) AudioSystem.getLine(info); }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }

        try { line.open(audioFormat); }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        }

        FloatControl volume = (FloatControl) this.line.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(vol);

        line.start();
        try {
            byte bytes[] = new byte[1024];
            int bytesRead=0;
            while ((bytesRead = audioInputStream.read(bytes, 0, bytes.length)) != -1 && !this.stop) {
                while(!this.play) { try{Thread.sleep(10);}catch(Exception e){} }
                long pos = this.line.getFramePosition() / 1000;
                long tot = audioInputStream.getFrameLength() / 1000;
                this.ctrl.majAffichageProgression((int)(pos * 600 / tot));
                line.write(bytes, 0, bytesRead);
            }
        } catch (IOException io) {
            io.printStackTrace();
            return;
        }

        this.line.stop();
        this.line.close();
    }
}
