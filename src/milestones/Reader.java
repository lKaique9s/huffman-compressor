package milestones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Reader {
    public byte[] read(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Informe um caminho de arquivo");
        }

        Path path = Path.of(args[0]);
        try {
            byte[] data = Files.readAllBytes(path);
            System.out.println("Lidos: " + data.length + " bytes");
            return data;
        } catch (NoSuchFileException e) {
            throw new IllegalArgumentException("Arquivo não encontrado: " + path);
        }


    }

}
