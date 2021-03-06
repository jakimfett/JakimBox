package jakimbox.helper;

import jakimbox.reference.Color.HexColor;

/**
 * Helper class for ingame colors
 *
 * @author jakimfett
 */
public class ColorHelper
{

    /**
     * Somewhat arbitrary, used for gas blocks mainly
     *
     * @param meta
     * @return HexColor
     */
    public static int getHexColorFromMeta(int meta)
    {
        switch (meta)
        {
            case 1:
                return HexColor.BLACK;
            case 2:
                return HexColor.BLACK;
            case 3:
                return HexColor.BLACK;
            case 4:
                return HexColor.BLACK;
            case 5:
                return HexColor.BLUE;
            case 6:
                return HexColor.CYAN;
            case 7:
                return HexColor.GREEN;
            case 8:
                return HexColor.KHAKI;
            case 9:
                return HexColor.MAGENTA;
            case 10:
                return HexColor.MAROON;
            case 11:
                return HexColor.PINK;
            case 12:
                return HexColor.PURPLE;
            case 13:
                return HexColor.RED;
            case 14:
                return HexColor.SALMON;
            case 15:
                return HexColor.YELLOW;
            default:
                return HexColor.WHITE;
        }
    }
}
