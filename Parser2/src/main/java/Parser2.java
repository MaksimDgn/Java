import java.io.IOException;
/*import java.util.ArrayList;
import java.util.List;
import java.util.*;*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

// JSOUP Cookbook
//Use DOM methods to navigate a document
//https://jsoup.org/cookbook/extracting-data/dom-navigation
public class Parser2 {


    public void run() throws IOException {
        String html = "<html><head><title>First parse</title></head>"
                + "<body> <div>DIV 1 <p>First</p> <p>textp1</p> <p>textp2</p><div>DIV 1.2</div></div> <div>DIV 2</div><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Element testF = doc.select("div>p").first();
        System.out.printf("");
        Element test2 = doc.prepend("<p>First</p>");

        System.out.println(testF.text());
        System.out.println(test2);
    }

//        сортировка вставками
    public static class MySotrting{
    public void sortInsert(){
//        int s[]={1,2,3};
//        char c[]={'a','b','c'};
        int it[]={3, 2, 5, 1, 4};
        int j = 0;
        for (int a=1; a<5; a++){
           int x = it[a];
             j = (a)-(1);
            while (x < it[j]){
                it[j+1] = it[j];
                j--;
                if(j<0)
                break;
            }
           // j++;
            it[j+1] = x;

        }
        for (int i = 0; i<5; i++) {
            System.out.println("IT: " + it[i]);
        }
//for (int n=0; n<4; n++) System.out.println("IT: " + it[n]);
        //System.out.println();


/*
        while (i>=0 || i2>=0){
            if (i>=0){
            System.out.println("i = "+c[i]);
            i--;}
            System.out.println("\t iT = "+it[i2]);

            i2--;
        }
*/
    }
    }

    public static void main(String[] args) throws IOException {

        new Parser2().run();


//        сортировка вставками
//        MySotrting s = new MySotrting();
//        s.sortInsert();

    }
}


