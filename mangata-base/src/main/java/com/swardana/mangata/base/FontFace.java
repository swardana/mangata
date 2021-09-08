package com.swardana.mangata.base;

import java.io.InputStream;

/**
 * Font Face allows to input custom font to appear on JavaFX UI even when the
 * particular font is not installed on JavaFX or user computer.
 *
 * <p>
 *     Font Face is a set of CSS rule to define custom Font into the UI. The rule is
 *     very simple, it's only require to know the Font Family and source location of
 *     the custom Font.
 * </p>
 *
 * <p>
 *     Normally in browsers world the specific font files supported list shown as
 *     below:
 *
 *    <ul>
 *        <li>Internet Explorer: EOT</li>
 *        <li>Mozilla: OTF, TTF</li>
 *        <li>Safari: OTF, TTF, SVG</li>
 *        <li>Opera: OTF, TTF, SVG</li>
 *        <li>Chrome: TTF, SVG</li>
 *    </ul>
 * </p>
 *
 * <p>
 *     However, in JavaFX only supported <i>True Type Font</i> (TTF) Font file.
 * </p>
 *
 * @author Sukma Wardana
 */
public interface FontFace {

    /**
     * Font family property of the custom Font.
     *
     * <p>
     *     Font Family property is used to identified certain Font and to
     *     differentiate from another Font.
     * </p>
     *
     * @return the font family name.
     */
    String family();

    /**
     * Source of Font file.
     *
     * <p>
     *     Font files is bundled into one file with specific data type format. In
     *     order to embed the custom Font into JavaFX required to read the TTF Font
     *     file.
     * </p>
     *
     * @return the byte stream data of the Font file.
     */
    InputStream source();

}
