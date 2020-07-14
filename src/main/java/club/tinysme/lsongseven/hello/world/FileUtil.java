package club.tinysme.lsongseven.hello.world;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Base64;


public final class FileUtil {
    public static void copyFile(String source, String dest) {
        ClassPathResource resource = new ClassPathResource(source);
        try (InputStream inputStream = resource.getInputStream()) {
            saveFile(inputStream, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(InputStream inputStream, String dest) throws IOException {
        saveFile(inputStream, dest, false);
    }

    public static void saveFile(InputStream inputStream, String dest, boolean append) throws IOException {
        File file = new File(dest);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (FileOutputStream outputStream = new FileOutputStream(file, append)) {
            saveFile(inputStream, outputStream);
        }
    }

    private static void saveFile(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        int ch;
        while ((ch = inputStream.read()) != -1) {
            fileOutputStream.write(ch);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static void appendFile(InputStream inputStream, String dest) throws IOException {
        saveFile(inputStream, dest, true);
    }

    public static String fileToBaseStr(InputStream in) throws IOException {
        byte[] data = null;
        // 读取图片字节数组
        data = new byte[in.available()];
        in.read(data);
        in.close();
        // 对字节数组Base64编码
        return Base64.getMimeEncoder().encodeToString(data);
    }

    public static boolean baseStrToFile(String baseStr, String dest) {
        if (baseStr == null || baseStr.isEmpty()) {
            return false;
        }
        try {
            byte[] bytes = Base64.getMimeDecoder().decode(baseStr);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            InputStream inputStream = new ByteArrayInputStream(bytes);
            saveFile(inputStream, dest);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
