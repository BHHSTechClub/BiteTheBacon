package org.byramhills.bitethebacon.controller.actions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileSystem {
    private static final String ROOT_FOLDER = "./";
    static {
        new File(ROOT_FOLDER).mkdirs();
    }
    
    public static File getFile(String subPath) {
        return new File(ROOT_FOLDER + subPath);
    }
    
    public static BufferedImage getImage(String subPath) {
        try {
            return ImageIO.read(getFile(subPath));
        } catch (IOException e) {
            return null;
        }
    }
}
