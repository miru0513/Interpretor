package Model.Type;
import Model.Value.Value;

public interface Type {
    boolean equals(Object obj);
    String toString();
    Value defaultValue();

    Type deepCopy();
}