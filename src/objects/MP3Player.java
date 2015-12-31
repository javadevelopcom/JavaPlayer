package objects;

import guiPlayer.PlayerJFrame;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class MP3Player extends BasicPlayer {

    private BasicPlayer player = new BasicPlayer();
    private String currentFilename;
    private double currentVolumeValue;

    public MP3Player(BasicPlayerListener listener) {
        player.addBasicPlayerListener(listener);
    }

    public void play(String fileName) {
        try {
            if (currentFilename != null && currentFilename.equals(fileName)
                    && player.getStatus() == BasicPlayer.PAUSED) {
                player.resume();
                return;
            }
            File mp3File = new File(fileName);

            currentFilename = fileName;
            player.open(mp3File);
            player.play();
            player.setGain(currentVolumeValue);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {
        try {
            player.stop();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void pause() {
        try {
            player.pause();
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setVolume(int currentValue, int maxValue) {
        this.currentVolumeValue = currentValue;
        if (currentValue == 0) {
            try {
                player.setGain(0);
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                player.setGain(calcVolume(currentValue, maxValue));
            } catch (BasicPlayerException ex) {
                Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private double calcVolume(int currentValue, int maxValue) {
        currentVolumeValue = (double) currentValue / (double) maxValue;
        return currentVolumeValue;
    }

    public void jump(long bytes) {
        try {
            player.seek(bytes);
            player.setGain(currentVolumeValue);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(MP3Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
