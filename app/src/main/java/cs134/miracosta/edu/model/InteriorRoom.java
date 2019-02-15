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
     * standard window area
     */
    public static final double WINDOW_AREA = 16.0;
    /**
     * how much square feet a gallon of paint covers
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

    /**
     * returns number of doors of the room
     * @return number of doors
     */
    public int getDoors() {
        return mDoors;
    }

    /**
     * returns number of windows of the room
     * @return number of windows
     */
    public int getWindows() {
        return mWindows;
    }

    /**
     * returns width of the room
     * @return width of room
     */
    public double getWidth() {
        return mWidth;
    }

    /**
     * returns height of the room
     * @return height of room
     */
    public double getHeight() {
        return mHeight;
    }

    /**
     * returns length of the room
     * @return length of room
     */
    public double getLength() {
        return mLength;
    }


    /**
     * set the amount of doors in the room
     * @param doors amount of doors
     */
    public void setDoors(int doors) {
        mDoors = doors;
    }

    /**
     * set the amount of windows in the room
     * @param windows amount of doors
     */
    public void setWindows(int windows) {
        mWindows = windows;
    }

    /**
     * set the width of the room
     * @param width of room
     */
    public void setWidth(double width) {
        mWidth = width;
    }

    /**
     * set the height of the room
     * @param height of room
     */
    public void setHeight(double height) {
        mHeight = height;
    }

    /**
     * set the legnth of the room
     * @param length of room
     */
    public void setLength(double length) {
        mLength = length;
    }

    /**
     * returns data variables in string form
     * @return the information about the room
     */
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

    /**
     * calculates the total area of the doors and windows
     * @return total area of windows and doors
     */
    public double doorAndWindowArea()
    {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    /**
     * calculates the total surface area of the 4 walls and ceiling
     * @return total surface area
     */
    public double totalSurfaceArea()
    {
        return 2.0 * mWidth * mHeight  + 2.0 * mLength * mHeight +
                mLength * mWidth;
    }

    /**
     * calculates the total wall surface area by subtracting the total surface area from the
     * are of the doors and windows
     * @return total wall surface area
     */
    public double wallSurfaceArea()
    {
        return totalSurfaceArea() - doorAndWindowArea();
    }

    /**
     * calculate the gallons of paint required
     * @return the number of gallons
     */
    public double gallonsOfPaintRequired()
    {
        return Math.round((wallSurfaceArea() / SQ_FT_PER_GALLON) * 10.0) / 10.0;
    }
}
