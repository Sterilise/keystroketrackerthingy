import java.util.ArrayList;

public class  Random2<T> {
    private ArrayList<T> randomArrayList;

    public Random2(ArrayList<T> inputArrayList) {
        randomArrayList = inputArrayList;
    }
    public ArrayList<T> getIt() {
        return randomArrayList;
    }
}
