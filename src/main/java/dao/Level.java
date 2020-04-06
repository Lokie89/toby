package dao;

public enum Level {
    BASIC(1){
        public Level nextLevel(){
            return SILVER;
        }
    },
    SILVER(2){
        public Level nextLevel(){
            return GOLD;
        }
    },
    GOLD(3){
        public Level nextLevel(){
            return null;
        }
    },
    ;

    private final int value;


    Level(int value) {
        this.value = value;
    }

    public int intValue() {
        return value;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1:
                return BASIC;
            case 2:
                return SILVER;
            case 3:
                return GOLD;
            default:
                throw new AssertionError("Unknown value: " + value);
        }
    }

    public abstract Level nextLevel();
}
