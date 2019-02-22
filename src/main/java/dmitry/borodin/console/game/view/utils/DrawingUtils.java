package dmitry.borodin.console.game.view.utils;

import java.util.Arrays;

public class DrawingUtils {

    public static int getMaxWidth(char[][] content) {
        return Arrays.stream(content)
                .mapToInt(c -> c.length)
                .max()
                .orElse(0);
    }

    public static void copyArray(char[][] src, char[][] dest) {
        for (int i = 0; i < src.length && i < dest.length; i++) {
            for (int j = 0; j < src[i].length && j < dest[i].length; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }
}
