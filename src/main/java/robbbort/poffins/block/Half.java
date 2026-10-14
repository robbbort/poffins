package robbbort.poffins.block;

import net.minecraft.util.StringRepresentable;

public enum Half implements StringRepresentable {
    LOWER("lower"),
    UPPER("upper") {
        @Override
        <T> T or(T first, T second) {
            return second;
        }

        @Override
        public Half opposite() {
            return LOWER;
        }
    };

    private final String name;

    Half(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }

    <T> T or(T first, T second) {
        return first;
    }

    public Half opposite() {
        return UPPER;
    }
}
