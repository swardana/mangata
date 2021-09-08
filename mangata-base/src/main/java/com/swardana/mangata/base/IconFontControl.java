package com.swardana.mangata.base;

import javafx.beans.DefaultProperty;
import javafx.beans.property.ObjectProperty;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableIntegerProperty;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleableProperty;
import javafx.css.converter.PaintConverter;
import javafx.css.converter.SizeConverter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The base of JavaFX UI control for Icon Font.
 * <p>
 *     The concrete class MUST call {@link #setup(IconFont, Integer, Paint)} on
 *     their primary constructor!
 * </p>
 *
 * @param <T> the Icon Font.
 * @author Sukma Wardana
 */
@DefaultProperty("content")
public abstract class IconFontControl<T extends IconFont> extends Region {

    public static final Integer DEFAULT_SIZE = 12;
    public static final Paint DEFAULT_COLOR = Color.BLACK;

    private final StyleableIntegerProperty size;
    private final StyleableObjectProperty<Paint> color;

    private final Text text;

    public IconFontControl() {
        this.size = new StyleableIntegerProperty() {
            @Override
            public Object getBean() {
                return IconFontControl.this;
            }

            @Override
            public String getName() {
                return "iconSize";
            }

            @Override
            public CssMetaData<? extends Styleable, Number> getCssMetaData() {
                return StyleableProperties.ICON_SIZE;
            }
        };
        this.color = new StyleableObjectProperty<Paint>() {
            @Override
            public Object getBean() {
                return IconFontControl.this;
            }

            @Override
            public String getName() {
                return "iconColor";
            }

            @Override
            public CssMetaData<? extends Styleable, Paint> getCssMetaData() {
                return StyleableProperties.ICON_COLOR;
            }
        };
        this.text = new Text();

        initGraphics();
    }

    /**
     * An observable icon property.
     *
     * @return the IconFont property.
     */
    public abstract ObjectProperty<T> iconProperty();

    /**
     * Get the Icon.
     *
     * @return the icon.
     */
    public abstract T getIcon();

    /**
     * Update the Icon.
     *
     * @param ico the new icon.
     */
    public abstract void setIcon(T ico);

    /**
     * A styleable size observable property.
     *
     * @return the styleable size property.
     */
    public final StyleableIntegerProperty sizeProperty() {
        return this.size;
    }

    /**
     * Get the icon size.
     *
     * @return the size.
     */
    public final Integer getSize() {
        return this.sizeProperty().getValue();
    }

    /**
     * Update the current icon size.
     *
     * @param num the new size.
     * @throws IllegalArgumentException if the size is {@code null} or lower
     * than 0.
     */
    public final void setSize(final Integer num) {
        if (num == null || Integer.signum(num) == -1) {
            throw new IllegalArgumentException(
                "The 'num' can't be null or lower than 0!"
            );
        }
        this.sizeProperty().setValue(num);
    }

    /**
     * A styleable color observable property.
     *
     * @return the styleable color property.
     */
    public final StyleableObjectProperty<Paint> colorProperty() {
        return this.color;
    }

    /**
     * Get the icon color.
     *
     * @return the color.
     */
    public final Paint getColor() {
        return this.colorProperty().get();
    }

    /**
     * Update the current icon color.
     *
     * @param clr the new color.
     * @throws IllegalArgumentException if the clr is {@code null}.
     */
    public final void setColor(final Paint clr) {
        if (clr == null) {
            throw new IllegalArgumentException("The 'clr' must not be null!");
        }
        this.colorProperty().set(clr);
    }

    /**
     * An initial setup.
     * <p>
     *     Concrete class MUST call this method on their primary constructor!
     * </p>
     *
     * @param ico the icon.
     * @param num the icon size.
     * @param clr the icon color.
     */
    protected final void setup(final T ico, final Integer num, final Paint clr) {
        registerListeners();
        setIcon(ico);
        setSize(num);
        setColor(clr);
    }

    @Override
    protected void layoutChildren() {
        layoutInArea(
            this.text,
            0,
            0,
            getWidth(),
            getHeight(),
            0,
            HPos.CENTER,
            VPos.CENTER
        );
        super.layoutChildren();
    }

    /**
     * A handler for {@link #colorProperty()} listener.
     *
     * @param clr the new color.
     */
    private void handleChangeColor(final Paint clr) {
        this.text.setFill(clr);
    }

    /**
     * A handler for {@link #sizeProperty()} listener.
     *
     * @param num the new size number.
     */
    private void handleChangeSize(final Number num) {
        setWidth(num.doubleValue());
        setHeight(num.doubleValue());
        this.text.setFont(
            Font.loadFont(
                getIcon().source(),
                num.intValue()
            )
        );
    }

    /**
     * A handler for {@link #iconProperty()} listener.
     *
     * @param ico the new icon.
     */
    private void handleChangeIcon(final T ico) {
        this.text.setFont(
            Font.loadFont(
                getIcon().source(),
                getSize()
            )
        );
        this.text.setText(getIcon().unicode());
    }

    private void registerListeners() {
        this.sizeProperty().addListener((obv, old, val) -> handleChangeSize(val));
        this.colorProperty().addListener((obv, old, val) -> handleChangeColor(val));
        this.iconProperty().addListener((obv, old, val) -> handleChangeIcon(val));
    }

    private void initGraphics() {
        getChildren().setAll(this.text);
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
        return getClassCssMetaData();
    }

    /**
     * A class CSS metadata.
     *
     * @return The CssMetaData associated with this class, which may include the
     * CssMetaData of its superclasses.
     */
    public static List<CssMetaData<? extends Styleable, ?>> getClassCssMetaData() {
        return StyleableProperties.STYLEABLES;
    }

    private static class StyleableProperties {

        static final CssMetaData<IconFontControl, Number> ICON_SIZE =
            new CssMetaData<IconFontControl, Number>(
                "-fx-icon-size",
                SizeConverter.getInstance(),
                DEFAULT_SIZE
            ) {
                @Override
                public boolean isSettable(final IconFontControl ico) {
                    return ico.size == null || !ico.size.isBound();
                }

                @Override
                public StyleableProperty<Number> getStyleableProperty(final IconFontControl ico) {
                    return (StyleableProperty<Number>) ico.sizeProperty();
                }
            };

        static final CssMetaData<IconFontControl, Paint> ICON_COLOR =
            new CssMetaData<IconFontControl, Paint>(
                "-fx-icon-color",
                PaintConverter.getInstance(),
                DEFAULT_COLOR
            ) {
                @Override
                public boolean isSettable(final IconFontControl ico) {
                    return ico.color == null || !ico.color.isBound();
                }

                @Override
                public StyleableProperty<Paint> getStyleableProperty(final IconFontControl ico) {
                    return (StyleableProperty<Paint>) ico.colorProperty();
                }
            };

        static final List<CssMetaData<? extends Styleable, ?>> STYLEABLES;

        static {
            final List<CssMetaData<? extends Styleable, ?>> styleables = new ArrayList<>(
                Region.getClassCssMetaData()
            );
            Collections.addAll(styleables, ICON_SIZE, ICON_COLOR);
            STYLEABLES = Collections.unmodifiableList(styleables);
        }

    }

}
