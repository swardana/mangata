package com.swardana.mangata.metro;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link MetroIcon}.
 *
 * @author Sukma Wardana
 */
public class MetroIconTest {

    @Test
    @DisplayName("Test update the icon unicode")
    public void testUpdateIconUnicode() {
        var expected = MetroIconFont.ICO_MOON;

        var icon = new MetroIcon();
        icon.setIcon(MetroIconFont.ICO_MOON);

        var actual = icon.getIcon();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon color")
    public void testUpdateIconColor() {
        var expected = Color.AZURE;

        var icon = new MetroIcon();
        icon.setColor(Color.AZURE);

        var actual = icon.getColor();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon color using null")
    public void testUpdateIconColorWithNullParameter() {
        var icon = new MetroIcon();
        assertThatThrownBy(() -> icon.setColor(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("The 'clr' must not be null!");
    }

    @Test
    @DisplayName("Test update the icon size")
    public void testUpdateIconSize() {
        var expected = 36;

        var icon = new MetroIcon();
        icon.setSize(36);

        var actual = icon.getSize();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon size with number lower than zero")
    public void testUpdateIconSizeWithNumberLowerThanZero() {
        var icon = new MetroIcon();
        assertThatThrownBy(() -> icon.setSize(-32))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("The 'num' can't be null or lower than 0!");
    }
}