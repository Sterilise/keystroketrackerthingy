package typetracker;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleProcessor extends Processor {

    private Label displayLabel;
    private KeyHistory keyHistory;
    private int currentWPM;
    private final int wordLength = 5;
    private final int keyCache = 20;

    public SimpleProcessor(Label displayLabel) {
        this.displayLabel = displayLabel;
        this.keyHistory = new KeyHistory(keyCache);
        setUpdateLoop();
    }

    public void processKey(Key keyPressed){
        keyHistory.addKey(keyPressed);
        super.processKey(keyPressed);
    }

    public void updateWPM() {
        List<Key> keys = keyHistory.getLastKeys();
        int numberOfKeysPressed = keys.size();
        if(keys.size() > 1) {
            LocalDateTime startDateTime = keys.get(0).timeOfKeyPress;
            LocalDateTime currentDateTime = LocalDateTime.now();

            long milliseconds = ChronoUnit.MILLIS.between(startDateTime, currentDateTime);
            double seconds = milliseconds/1000f;

            double wordsPerSecond =  (numberOfKeysPressed / (seconds * wordLength));
            currentWPM = (int) (wordsPerSecond * 60);
            System.out.println(wordsPerSecond);
            System.out.println("Wpm: " + currentWPM);
        }else {
            currentWPM = 0;
        }

    }

    public void updateLabel() {
        displayLabel.setText(String.valueOf(currentWPM));
    }

    private void setUpdateLoop() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{updateLabel();});
            }
        };


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task,100, 500);
    }

    public void reset(){
        currentWPM = 0;
        keyHistory = new KeyHistory(keyCache);
    }
}
