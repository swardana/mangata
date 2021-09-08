package com.swardana.mangata.metro;

import com.swardana.mangata.base.IconFontControl;
import javafx.beans.NamedArg;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Paint;

/**
 * JavaFX UI control for Metro UI Icon Font.
 *
 * @author Sukma Wardana
 */
public class MetroIcon extends IconFontControl<MetroIconFont> {

    private final ObjectProperty<MetroIconFont> icon;

    /**
     * Creates new MetroIcon.
     * <p>
     *     Constructor with empty arguments is require for scene-builder.
     * </p>
     */
    public MetroIcon() {
        this(MetroIconFont.AC_UNIT, DEFAULT_SIZE, DEFAULT_COLOR);
    }

    /**
     * Creates new MetroIcon.
     *
     * @param icon the icon font.
     * @param size the icon size.
     * @param color the icon color.
     */
    public MetroIcon(
        @NamedArg("icon") final MetroIconFont icon,
        @NamedArg("size") final Integer size,
        @NamedArg("color") final Paint color
    ) {
        super();
        this.icon = new SimpleObjectProperty<>(this, "icon", null);
        setup(icon, size, color);
    }

    @Override
    public ObjectProperty<MetroIconFont> iconProperty() {
        return this.icon;
    }

    @Override
    public MetroIconFont getIcon() {
        return this.icon.get();
    }

    @Override
    public void setIcon(final MetroIconFont ico) {
        this.icon.set(ico);
    }

}
