package jakimbox.prefab.gui.tabTypes;

import jakimbox.prefab.gui.BasicTabbedGUI;
import jakimbox.prefab.gui.Tabs.TabSide;
import jakimbox.prefab.gui.Tabs.TabType;
import jakimbox.reference.RelativeDirection;

/**
 *
 * @author jakimfett
 */
public class ChestTab extends AbstractTab
{
    private final int DOUBLE_TAB_WIDTH = 122;

    public ChestTab(String modID, TabSide side, TabType type, RelativeDirection direction)
    {
        super(modID, // Used to set the texture
            type, // Tab type
            side, // Side, passed in from object construction
            direction, // Direction, relative to the block
            0, // Texture coordinate for open (x)
            18, // Texture coordinate for open (y)
            66, // Maximum tab width, used to reset the tab
            174 // Maximum tab height, used to reset the tab
        );
        if (type == TabType.CHEST_DOUBLE)
        {
            invTextureX = 66;
            invWidth = DOUBLE_TAB_WIDTH;

            iconTextureX = 18;
        } else if (type == TabType.CHEST_ENDER)
        {
            iconTextureX = 36;
            invTextureX = 185;
        }
    }

    @Override
    protected void renderOpenTabForSide(BasicTabbedGUI gui, TabSide side)
    {
        if (side == TabSide.LEFT)
        {
            gui.drawTexturedModalRect(guiCoords[0] - invWidth, gui.height / 2 + ((BasicTabbedGUI) gui).getTextureHeight() / 2 - getInvHeight() - 16, invTextureX, invTextureY, getInvWidth(), getInvHeight());
        } else
        {
            gui.drawTexturedModalRect(guiCoords[0] + getIconWidth(), gui.height / 2 + ((BasicTabbedGUI) gui).getTextureHeight() / 2 - getInvHeight() - 16, invTextureX, invTextureY, getInvWidth(), getInvHeight());
        }
    }

    @Override
    protected void renderTabTransition(BasicTabbedGUI gui, TabSide side)
    {
        if (side == TabSide.LEFT)
        {
            if (type == TabType.CHEST_ENDER)
            {
                gui.drawTexturedModalRect(guiCoords[0] - 3, guiCoords[1], 60, 0, 3, getIconHeight());
            } else
            {
                gui.drawTexturedModalRect(guiCoords[0] - 3, guiCoords[1], 54, 0, 3, getIconHeight());
            }
        } else
        {
            if (type == TabType.CHEST_ENDER)
            {
                gui.drawTexturedModalRect(guiCoords[0] + getIconWidth(), guiCoords[1], 63, iconTextureY, 3, getIconHeight());
            } else
            {
                gui.drawTexturedModalRect(guiCoords[0] + getIconWidth(), guiCoords[1], 57, iconTextureY, 3, getIconHeight());
            }
        }
    }

    /**
     * Move tab to the default coordinate position
     */
    @Override
    protected void resetTabGUICoordinates()
    {

        int xOffset = defaultGUIX;
        int yOffset = defaultGUIY;

        if (type == TabType.CHEST_DOUBLE)
        {
            //xOffset -= DOUBLE_TAB_WIDTH;
        }

        setTabGUICoordinates(xOffset, yOffset);
    }
}
