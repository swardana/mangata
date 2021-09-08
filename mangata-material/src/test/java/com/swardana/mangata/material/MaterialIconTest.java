package com.swardana.mangata.material;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link MaterialIcon}.
 *
 * @author Sukma Wardana
 */
public class MaterialIconTest {

    @Test
    @DisplayName("Test update the icon unicode")
    public void testUpdateIconUnicode() {
        var expected = MaterialIconFont.ACCESS_ALARM;

        var icon = new MaterialIcon();
        icon.setIcon(MaterialIconFont.ACCESS_ALARM);

        var actual = icon.getIcon();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon color")
    public void testUpdateIconColor() {
        var expected = Color.AZURE;

        var icon = new MaterialIcon();
        icon.setColor(Color.AZURE);

        var actual = icon.getColor();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon color using null")
    public void testUpdateIconColorWithNullParameter() {
        var icon = new MaterialIcon();
        assertThatThrownBy(() -> icon.setColor(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("The 'clr' must not be null!");
    }

    @Test
    @DisplayName("Test update the icon size")
    public void testUpdateIconSize() {
        var expected = 36;

        var icon = new MaterialIcon();
        icon.setSize(36);

        var actual = icon.getSize();

        assertThat(actual).isNotNull().isEqualTo(expected);
    }

    @Test
    @DisplayName("Test update the icon size with number lower than zero")
    public void testUpdateIconSizeWithNumberLowerThanZero() {
        var icon = new MaterialIcon();
        assertThatThrownBy(() -> icon.setSize(-32))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("The 'num' can't be null or lower than 0!");
    }

}