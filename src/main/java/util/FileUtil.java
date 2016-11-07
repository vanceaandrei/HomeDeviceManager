package util;

import org.apache.commons.io.FileExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by andrei.vancea on 10/25/2016.
 */
public class FileUtil {

    static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    //make sure noone instantiates a class of FileUtil type
    private FileUtil() {

    }

    public static File createUserDirectory(String dirName) throws FileExistsException {

        File dir = new File(dirName);
        if (!dir.exists() && !dir.mkdir()) {
            throw new FileExistsException();
        }
        return dir;
    }

    public static File createFile(String path) throws IOException {

        File file = new File(Const.HDM_FILE_FOLDER + File.separator + path);
        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdirs()) {
                logger.info("Created directory path");
            } else {
                logger.error("Error creating directory path!!!");
                throw new SecurityException("Could not make file parent directory!!!");
            }
        }

        if (!file.createNewFile()) {
            logger.error("Error creating file!!!");
            throw new SecurityException("Could not create file!!!");
        } else {
            logger.info("File created successfully");
        }

        return file;
    }

    public static byte[] getEncodedProfilePicture(String email) {
        byte[] result = new byte[2048];
        try {
            FileInputStream fis = new FileInputStream(new File(Const.HDM_FILE_FOLDER + File.separator + email + File.separator + Const.PROFILE_PICTURE));
            fis.read(result);
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
