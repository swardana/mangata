package com.swardana.mangata.win10;

import com.swardana.mangata.base.IconFont;

import java.io.InputStream;

/**
 * Icons8 Windows 10 Icon Font.
 * <p>
 *     List of icons in Icons8 Windows 10 Icon Font version 1.
 * </p>
 *
 * @author Sukma Wardana
 */
public enum Win10IconFont implements IconFont {

    ADD_SHOPPING_CART("\uf100");

    private final String unicode;

    Win10IconFont(final String unicode) {
        this.unicode = unicode;
    }

    @Override
    public final String unicode() {
        return this.unicode;
    }

    @Override
    public final String family() {
        return "icons8-win10";
    }

    @Override
    public final InputStream source() {
        return Win10IconFont.class.getResourceAsStream("icons8-win10.ttf");
    }
}
