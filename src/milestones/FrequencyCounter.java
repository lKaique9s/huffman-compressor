package milestones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
    private int[] freq = new int[256];
    private List<Map.Entry<Integer,Integer>> frequencies = new ArrayList<>();

    public FrequencyCounter( byte[] data){
        for(var b:data){
            freq[b & 0xFF]++;
        }
        createTableFrequency();
    }

    public int calculateTotalFrequency(){
        int total = 0;
        for(var t:freq){
            total+=t;
        }
        return total;
    }

    public int[] getFreq() {
        return freq.clone();
    }

    public List<Map.Entry<Integer, Integer>> getFrequencies() {
        return List.copyOf(frequencies);
    }

    private void createTableFrequency(){
        for(int i = 0;i<256;i++){
            if(freq[i] > 0){
                frequencies.add(Map.entry(i, freq[i]));
            }
        }
        frequencies.sort((a,b) -> Integer.compare(b.getValue(),a.getValue()));
    }

}
