import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import javax.swing.text.Document;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 * Created by Max on 21.07.2017.
 */

class Myt {
    String str = "str";
    public void nfo(){
        System.out.println("My test: "+ str);
    }

}

public class Myparser {
    public static void main(String[] args) throws IOException {

        String hostA = "http://www.ya.ru";
        String hostB = "http://www.yandex.ru";
        String hostC = "http://www.render.ru";
        String hostD = "http://www.4pda.ru";

        Socket s = new Socket("render.ru", 80);
        s.setSoTimeout(3000);

        try {


            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            System.out.println("Connect");
//            InetAddress adr = InetAddress.getByName("4pda.ru");
            InetAddress adr = InetAddress.getByName("localhost");


//           InetAddress[] adr =  InetAddress.getAllByName("ya.ru");
//           for (InetAddress a : adr)
            System.out.println(adr);
            int i = 0;

            URL url = new URL(hostD);
            // URL url = new URL("http://www.yandex.ru");
            InputStream inStrm = url.openStream();
            Scanner ins = new Scanner(inStrm);

            List<Article> articleList = new ArrayList<Article>();
//            org.jsoup.nodes.Document doc = Jsoup.connect("http://4pda.ru").get();
            org.jsoup.nodes.Document doc = Jsoup.connect("http://localhost").get();
            while (ins.hasNextLine() && i<1) {
// Создаем приложение "Погода" на Java [GeekBrains]
// Регулярные выпажения https://youtu.be/sZgXUK5L3Ss?t=26m37s


//                Elements h1Elements = doc.getElementsByAttributeValue("class", "list-post-title");
                //Elements h1Elements = doc.getElementsByAttributeValue("class", "wk_photo_no_padding");
//                System.out.println("I: "+i+"E lement: "+ h1Elements);
//
//                Elements a1Elements = doc.getElementsByAttributeValue("class", "wall_post_text");
                //Element bookNotes  = doc.getElementById("detail_content_wrapper");
                Element bookNotes  = doc.getElementById("detail_content_wrapper");

                Element h1Element = bookNotes.getElementsByTag("h1").first();
//                System.out.println("I: "+i+"a lement: "+ a1Elements);


               // Element eh  = h1Elements.select("wall_post_text").first();
                String hstr = null;
                int counter = 0;
                for(Node node : h1Element.childNodes()){
                    //System.out.println("Counter: "+counter);


                    if (node instanceof TextNode && counter == 0 ){
                        hstr = ((TextNode) node).getWholeText();
                        System.out.println("1 Header: " + hstr+ "\n");
                        counter++;
                    } else {System.out.println("Counter: "+counter);
                        if (node instanceof TextNode && counter == 1 ){
                        String h2str = null;
                       h2str = ((TextNode) node).getWholeText();
                        System.out.println("2 Header: " + h2str);

                        counter++;}
                        break;
                    }




                }
//                System.out.println("2 Header: " + hstr+ "\n");
//                h1Elements.select("a").next();
//                System.out.println("2 Header: " + hstr+ "\n");

//                Element tit = a1Elements.select("a").first();
//
//               // String str = tit.siblingElements().text();
//                String t = tit.text();
//                System.out.println("Title string: "+t);

                    //System.out.println("A string: " + str + "\n");


/*                    int ii = 0;
                    while (a1Elements.size() > ii) {
                        Elements etit = a1Elements.next();

                        String t = etit.text();
                        System.out.println("Next : " + t + "\n");
                        ii++;
                    }*/
                i++;
            }
/*            while (in.hasNextLine()) {
                System.out.println("I: " + i);
                i++;
                String line = in.nextLine();
                System.out.println(line);
            }*/

        } catch (InterruptedIOException exception) {
            System.out.println("Socket Error");
        }
////// v


/*        h1Elements.forEach(h1Elements ->{

            Element aElement = h1Elements.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            articleList.add(new Article(url, title));
    });

        articleList.forEach(System.out::println);*/

        Gson gson = new Gson();

        gson.toJson(1);
        gson.toJson("adcd");
        gson.toJson(new Long(10));
        int[] values = {1};
        gson.toJson(values);


        int one = gson.fromJson("1", int.class);
        Integer onet = gson.fromJson("1", Integer.class);
        Long Lone = gson.fromJson("91", Long.class);
/*        Boolean false = gson.fromJson("false", Boolean.class);*/
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);

        System.out.println("One: " + one);
        System.out.println("OneT: " + onet);
        System.out.println("Lone: " + Lone);
        System.out.println("Str: " + str);
        System.out.println("anotherStr: " + anotherStr[0]);

        Myt st = new Myt();
        st.str = "stroka str";
        st.nfo();

        Collection<Integer> c = new ArrayList<Integer>();
        for (int i= 0; i < 10; i++)
            c.add(i);
        for (Integer i:c)
            System.out.println(i + ", ");

        st.nfo();


        Gson gs = new Gson();
        gs.toJson(gs);
    }
}

class Asd {
    String str;

    public Asd(String name){
        this.str = name;
    }

//    public String element(){
//
//    }

    public String getStr(){
        return str;
    }
}

class Article {
    private String url;
    private String name;

    public Article(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}