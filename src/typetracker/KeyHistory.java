package typetracker;


import java.util.LinkedList;
import java.util.List;

public class KeyHistory {
    private int keyCache;
    private List<Key> lastKeys;

    public KeyHistory(int keyCache) {
        this.keyCache = keyCache;
        lastKeys = new LinkedList<>();
    }

    /**
     * Removes (FIFO) key if the cache limit is exceeded
     * @param key
     */

    public void addKey(Key key) {
        if(lastKeys.size() >= keyCache) {
            lastKeys.remove(0);
        }
        lastKeys.add(key);
    }

    public List<Key> getLastKeys() {
        return lastKeys;
    }

}
