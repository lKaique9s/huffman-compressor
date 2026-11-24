import milestones.FrequencyCounter;
import milestones.Reader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        byte[] data;

        try {
            data = reader.read(args);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }


        FrequencyCounter fc;
        try{
            fc = new FrequencyCounter(data);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(fc.calculateTotalFrequency());
        for (var entry : fc.getFrequencies()) {
            int numberByte = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(numberByte + " : " + quantity);
        }



    }
}
