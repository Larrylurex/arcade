package dmitry.borodin.console.game.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResourceUtils {

    public static char[][] readResourceAsArray(String resource) {
        List<String> rows = new ArrayList<>();
        Scanner scanner;
        try (InputStream rStream = ResourceUtils.class.getClassLoader().getResourceAsStream(resource)) {
            scanner = new Scanner(rStream);
            while (scanner.hasNextLine()) {
                rows.add(scanner.nextLine());
            }
            return rows.stream().map(String::toCharArray).toArray(char[][]::new);
        } catch (Exception e) {
            throw new GameInitializationException("Couldn't load resource: " + resource, e);
        }
    }

    public static <T> T readResourceAsObject(String resource, Class<T> clazz) {
        try (InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(resource);
             ObjectInput oin = new ObjectInputStream(is)) {
            Object obj = oin.readObject();
            return clazz.cast(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readFileAsObject(String file, Class<T> clazz) {
        try (InputStream is = new FileInputStream(file);
             ObjectInput oin = new ObjectInputStream(is)) {
            Object obj = oin.readObject();
            return clazz.cast(obj);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean writeObject(String resource, Object object) {
        try (FileOutputStream bos = new FileOutputStream(resource);
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
