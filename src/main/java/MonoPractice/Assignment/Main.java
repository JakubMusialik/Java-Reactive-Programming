package MonoPractice.Assignment;

import MonoPractice.util.Util;

public class Main {
    public static void main(String[] args) {

        FileService.read("file.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file2.txt", "Content from service")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("file3.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
