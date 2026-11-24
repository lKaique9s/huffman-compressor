package milestones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

    static void main(String[] args) throws IOException {
        //Evita Run sem caminhom definido
        if(args.length == 0){
            System.out.println("Informe um caminho de arquivo");
            return;
        }
        Path path = Path.of(args[0]);

        //Ler quantidade de bytes no arquivo
        byte[] data = Files.readAllBytes(path);
        System.out.println("Lidos: " + data.length + " bytes");


        //Conta a frequencia que um byte se repete
        int[] freq = new int[256];
        for(var b:data){
            freq[b & 0xFF]++;
        }

        //Mostra a soma das frequencias
        int total = 0;
        for(var t:freq){
            total+=t;
        }
        System.out.println("Soma das frequencias: "+total);

        //Criar a tabele frequencia
        List<Map.Entry<Integer,Integer>> frequencias = new ArrayList<>();

        for(int i = 0;i<256;i++){
            if(freq[i] > 0){
                frequencias.add(Map.entry(i, freq[i]));

            }
        }
        //Ordena em ordem decrescente
        frequencias.sort((a,b) -> Integer.compare(b.getValue(),a.getValue()));

        //Imprime a tabela
        for(var entry:frequencias){
            int numberByte = entry.getKey();
            int quantity = entry.getValue();

            System.out.println((char) numberByte + "|" + numberByte + " : " + quantity);
        }

    }

}
