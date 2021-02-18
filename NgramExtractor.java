import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Murat ES
 * @since 09.01.2021
 */
public class NgramExtractor {
    public static void main(String[] args) throws IOException {

        String line;
        // read input
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
        line = bufferedReader.readLine();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lines = 0;
        while (true) {
            try {
                if (reader.readLine() == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            lines++;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a=0;
        while (a<lines-1){
            line+=" ";
            line+=bufferedReader.readLine();

            a++;
        }

        dataInputStream.close();

        int numberOfChar=line.length();

        line=line.replaceAll("\\p{Punct}", " ");

        ArrayList<String> words=new ArrayList<>();
        String[] tempWords=new String[numberOfChar];
        for (int i = 0; i <tempWords.length ; i++) {
            tempWords=line.split(" ");
        }


        for (int i = 0; i <tempWords.length; i++) {
            if (!tempWords[i].equals("")){
               words.add(tempWords[i]);
            }
        }

        for (int i = 0; i <words.size() ; i++) {
            words.set(i,words.get(i).toLowerCase());
        }


        HashMap<String, Integer> frequency = new HashMap<>();
        int totalToken=0;

        for (Map.Entry<String, Integer> entry : nGram(frequency,Integer.parseInt(args[2]),words).entrySet()) {

            totalToken+=entry.getValue();
        }


        HashMap<String, Integer> sortedMapDesc = sortByComparator(frequency);

        //write output to the file
        try {
            File myFile = new File(args[1]);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(args[1]);
            myWriter.write("Total number of tokens: "+totalToken+"\n\n");
            myWriter.write("ngram,count,frequency");
            myWriter.write(printHashMap(sortedMapDesc,totalToken));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     *<p>This method arrange the nGram that given integer</p>
     *
     * @param frequency is hashMap will be arranged
     * @param nGram is integer to choose word interval
     * @param words is ArrayList
     * @return frequency
     */
    public static Map<String, Integer> nGram(HashMap<String, Integer> frequency,int nGram,ArrayList<String> words){
        String gr;
        for (int i = 0; i < words.size()-nGram+1; i++) {
            gr="";
            gr+=words.get(i);
            for (int j = i+1; j <nGram+i ; j++) {
                    gr+=" "+words.get(j);

            }

            if (frequency.containsKey(gr)) {
                frequency.replace(gr, frequency.get(gr) + 1);
            } else {
                frequency.put(gr, 1);
            }
        }
        return frequency;
    }

    /**
     *<p>This method sort the value of key according to by descending order</p>
     * @param unsortMap is the hashMap will be sorted
     * @return the bigger value
     */
    private static HashMap<String, Integer> sortByComparator(Map<String, Integer> unsortMap)
    {

        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2)
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
        });

        // Maintaining insertion order with the help of LinkedList
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    /**
     *<p>This method print the element of HashMap</p>
     * @param map is needed to print key and value
     * @param totalToken is needed to find frequency
     * @return all elements of hashMap with key,value and frequency
     */
    public static String printHashMap(HashMap<String, Integer> map,int totalToken) {
        String output="";
        for (Entry<String, Integer> entry : map.entrySet())
        {
           output+="\n";
           output+=(entry.getKey() + ","+ entry.getValue()+","+((double)entry.getValue()/totalToken)*100);
        }
        return output;
    }
}