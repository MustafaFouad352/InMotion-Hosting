package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialUtils {
        private static final String FILE_PATH = "src/test/resources/testdata.properties";

        public static void writeEmailandPassword(String email, String password) throws IOException {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileOutputStream out = new FileOutputStream(file)) {
                Properties props = new Properties();
                props.setProperty("email", email);
                props.setProperty("password", password);
                props.store(out, null);
            }
        }

        public static String getEmail() throws IOException {
            return getProperty("email");
        }

        public static String getPassword() throws IOException {
            return getProperty("password");
        }

        private static String getProperty(String key) throws IOException {
            Properties props = new Properties();
            try (FileInputStream in = new FileInputStream(FILE_PATH)) {
                props.load(in);
                return props.getProperty(key);
            }
        }
    }
