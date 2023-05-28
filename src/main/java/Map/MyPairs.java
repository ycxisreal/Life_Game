package Map;

import java.util.Objects;

public class MyPairs {
    public int row;
    public int col;

    public MyPairs(int a, int b) {
        this.row = a;
        this.col = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyPairs myPairs = (MyPairs) o;
        return row == myPairs.row && col == myPairs.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
