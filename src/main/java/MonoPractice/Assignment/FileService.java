package MonoPractice.Assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path path = Paths.get("src/main/java/MonoPractice/Assignment/Textfiles/");

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<String> write(String fileName, String content){
        return Mono.fromRunnable(() -> writeFile(fileName,content));
    }

    public static Mono<Void> delete(String fileName){
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName) {
        try {
            return Files.readString(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void writeFile(String fileName, String content) {
        try {
            Files.writeString(path.resolve(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void deleteFile(String fileName) {
        try {
            Files.delete(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
