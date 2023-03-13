import java.util.Objects;

public class DoubleToken implements Token{
    public final double num;

    public DoubleToken(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "DoubleToken{" +
                "num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleToken that = (DoubleToken) o;
        return Double.compare(that.num, num) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
