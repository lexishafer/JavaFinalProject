//enum class, directions correspond to rows on sprite sheet
public enum Direction {
    NORTH(3),SOUTH(2),EAST(1),WEST(0);
    private int frameLineNumber;

    Direction(int frameLineNumber) {
        this.frameLineNumber = frameLineNumber;
    }

    public int getFrameLineNumber() {
        return frameLineNumber;
    }
}
