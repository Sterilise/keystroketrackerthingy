import java.util.function.BinaryOperator;

public interface Func {
    <T> void  test(BinaryOperator<T> t);
}
