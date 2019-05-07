
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Random  {


    public static void main(String []args){
        int i = 5;

        print("\r\n");
        print(i++);
        print(i);
        print(++i);
        print(i=++i+i++);
        print(i);
    }

    public static <T> void print(T t){
        System.out.println(t);
    }


    @Override
    public void testMethod() {
        print("Main");
    }

    public void newMethod(){

    }
}
