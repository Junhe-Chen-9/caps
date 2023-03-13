import java.util.Objects;

public class StringToken implements Token{

    // because we we not allowing people to modify the value of our token, this can be implemented as public
    // that way we dont have to set a getter for it
    // in the meantime, people should not be able to change it anyways
    public final String s;

    // constructor
    public StringToken(final String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "StringToken{" +
                "s='" + s + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // direct compare
        if (this == o) return true;
        // if the other object is null or not same class then it is not going to be equal
        if (o == null || getClass() != o.getClass()) return false;
        // now we cast token to string token
        StringToken that = (StringToken) o;
        // and compare the value
        return s.equals(that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
