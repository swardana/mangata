package com.swardana.mangata.material;

import com.swardana.mangata.base.IconFontControl;
import javafx.beans.NamedArg;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Paint;

/**
 * JavaFX UI control for Material Designs Icon Font.
 *
 * @author Sukma Wardana
 */
public class MaterialIcon extends IconFontControl<MaterialIconFont> {

    private final ObjectProperty<MaterialIconFont> icon;

    /**
     * Creates new MaterialIcon.
     * <p>
     *     Constructor with empty arguments is require for scene-builder.
     * </p>
     */
    public MaterialIcon() {
        this(MaterialIconFont._10K, DEFAULT_SIZE, DEFAULT_COLOR);
    }

    /**
     * Creates new MaterialIcon.
     *
     * @param icon the icon font.
     * @param size the icon size.
     * @param color the icon color.
     */
    public MaterialIcon(
        @NamedArg("icon") final MaterialIconFont icon,
        @NamedArg("size") final Integer size,
        @NamedArg("color") final Paint color
    ) {
        super();
        this.icon = new SimpleObjectProperty<>(this, "icon", null);
        setup(icon, size, color);
    }

    @Override
    public ObjectProperty<MaterialIconFont> iconProperty() {
        return this.icon;
    }

    @Override
    public MaterialIconFont getIcon() {
        return this.icon.get();
    }

    @Override
    public void setIcon(final MaterialIconFont ico) {
        this.icon.set(ico);
    }

}
