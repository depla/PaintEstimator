package cs134.miracosta.edu.model;

/**
 * The <code>InteriorRoom</code> class calculates the amount of paint needed to re-coat a room.
 *
 * @author Dennis La
 * @version 1.0
 */
public class InteriorRoom
{
    private int mDoors;
    private int mWindows;

    private double mWidth;
    private double mHeight;
    private double mLength;
    /**
     * standard door area (3 feet * 7 feet)
     */
    public static final double DOOR_AREA = 21.0;
    /**
     *
     */
    public static final double WINDOW_AREA = 16.0;
    /**
     *
     */
    public static final double SQ_FT_PER_GALLON = 275.0;

    /**
     * Instantiates a new <code>InteriorRoom</code> provided with the number of doors, windows,
     * and its dimensions: width, height and length
     * @param doors number of doors in the room
     * @param windows number of windows in the room
     * @param width width of the room
     * @param height height of the room
     * @param length length of the room
     */
    public InteriorRoom(int doors, int windows, double width, double height, double length)
    {
        mDoors = doors;
        mWindows = windows;
        mWidth = width;
        mHeight = height;
        mLength = length;
    }

    public int getDoors() {
        return mDoors;
    }

    public int getWindows() {
        return mWindows;
    }

    public double getWidth() {
        return mWidth;
    }

    public double getHeight() {
        return mHeight;
    }

    public double getLength() {
        return mLength;
    }

    public void setDoors(int doors) {
        mDoors = doors;
    }

    public void setWindows(int windows) {
        mWindows = windows;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public void setLength(int length) {
        mLength = length;
    }

    @Override
    public String toString() {
        return "InteriorRoom{" +
                "mDoors=" + mDoors +
                ", mWindows=" + mWindows +
                ", mWidth=" + mWidth +
                ", mHeight=" + mHeight +
                ", mLength=" + mLength +
                '}';
    }

    public double doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public double totalSurfaceArea()
    {
        return 2.0 *mWidth * mHeight  + 2.0 * mLength * mHeight;
    }

    public double wallSurfaceArea()
    {
        return totalSurfaceArea() - doorAndWindowArea();
    }

    public double gallonsOfPaintRequired()
    {
        return wallSurfaceArea() / SQ_FT_PER_GALLON;
    }
}
