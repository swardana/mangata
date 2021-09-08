package com.swardana.mangata.base;

/**
 * Icon Font are fonts that contain symbols and glyphs instead of letters or
 * numbers.
 *
 * <p>
 *     Each of Icon is represent as an Unicode in Font files, so when an icon has
 *     not been encoded as a character in Unicode it must use
 *     <i>Private Use Areas</i> (PUA) Unicode.
 * </p>
 *
 * @author Sukma wardana
 */
public interface IconFont extends FontFace {

    /**
     * Icon Font Unicode.
     * <p>
     *     Either Unicode or PUA Unicode, Icon on Font files is represent as
     *     Unicode.
     * </p>
     *
     * @return the icon Unicode.
     */
    String unicode();

}
