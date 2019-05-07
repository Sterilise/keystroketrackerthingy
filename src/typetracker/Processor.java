package typetracker;


abstract public class Processor {

    public void processKey(Key keyPressed) {
        updateWPM();
    }

    abstract public void updateWPM();

    abstract public void updateLabel();

    abstract public void reset();
}
