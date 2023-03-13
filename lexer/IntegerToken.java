import java.util.Objects;

public class IntegerToken implements Token{
    // this is one of the building base of our number token
    public final int num;


    public IntegerToken(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "IntegerToken{" +
                "num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerToken that = (IntegerToken) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
