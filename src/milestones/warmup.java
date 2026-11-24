package milestones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class warmup {
    static void main() throws IOException {
        int number = 173;
        StringBuilder builder = new StringBuilder();
        for(int i = 7; i>= 0;i--){
            int bit = (number >> i) & 1;
            System.out.print(bit);
            builder.append(bit);
        }
        String numberBinary = builder.toString();

        if(Integer.toBinaryString(number).equals(numberBinary)){
            System.out.println("\nsi");
        }

        //Task 2

        Path pathing = Path.of("teste.txt");
        byte[] data = Files.readAllBytes(pathing);
        for(int i = 0; i < 20 && i < data.length; i++){
            int valor = data[i] & 0xFF;
            System.out.print(valor + " ");
        }

        //Task 3

        int[] bits = {1,1,1};
        int numberByBits = 0;
        for(int i =0; i< bits.length; i++){
            numberByBits = (numberByBits << 1) | bits[i];
        }
        System.out.println("\n"+numberByBits);
    }
}
