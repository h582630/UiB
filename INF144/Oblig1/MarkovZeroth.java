import java.io.*;
import java.util.Vector;
import java.util.HashMap;
import java.util.Random;

class MarkovZeroth {

    public static HashMap<Character, Integer> mChain = new HashMap<Character, Integer>();
    
    public static void main (String[] args) {

        char[] alphabet = new char[] {'a','b','c','d','e','f',
                                      'g','h','i','j','k','l',
                                      'm','n','o','p','q','r',
                                      's','t','u','v','w','x',
                                      'y','z','�','�','�',' '};
        char start = 'a';

        for(int i = 0; i < alphabet.length; i++) {
            mChain.put(alphabet[i], new Integer(0));
        }

        readFile("Folktale.txt");
        
        for(int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + ": " +  mChain.get(alphabet[i]));
        }
    }

    public static void readFile(String fileName) {
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String str;
            String[] arr;

            while((str = br.readLine()) != null) {
                arr = str.split(" ");
                int val = mChain.get(' ').intValue();
                mChain.put(' ', new Integer(val + 1));
                
                for(int i = 0; i < arr.length; i++) {
                    addChar(arr[i]);
                }
                arr = null;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addChar(String text) {
        char[] letters = text.toCharArray();

        for(int i = 0; i < letters.length; i++) {
            
            if(i == 0) {
                mChain.put(letters[i], new Integer(1));
            }
            else {
                
                int value = mChain.get(letters[i]).intValue();
                mChain.put(letters[i], new Integer(value + 1));
            }
        }
    }
}
