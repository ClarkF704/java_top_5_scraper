import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Scraper {

    public static void main(String[] args) throws Exception {

        final Document document = Jsoup.connect("https://www.woot.com/").get();

        for (Element div : document.select(".overview")) {

            final String title = div.select(".fn.main-title").text();
            final String price = div.select(".price-holder > .price").text();


            System.out.println(title + " is today's item on Woot. It costs " + price);


            final Document document2 = Jsoup.connect("https://www.bing.com/shop?q="+title+"%2c+&FORM=SHOPTB").get();

            for (Element div2 : document2.select(".br-items")) {

                final String title2 = div2.select("li.br-item:nth-of-type(1) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .br-voidlink > .br-standardText.br-pdItemName").text();
                final String title3 = div2.select("li.br-item:nth-of-type(2) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .br-voidlink > .br-standardText.br-pdItemName").text();
                final String title4 = div2.select("li.br-item:nth-of-type(3) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .br-voidlink > .br-standardText.br-pdItemName").text();
                final String title5 = div2.select("li.br-item:nth-of-type(4) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .br-voidlink > .br-standardText.br-pdItemName").text();
                final String title6 = div2.select("li.br-item:nth-of-type(5) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .br-voidlink > .br-standardText.br-pdItemName").text();

                final String price2 = div2.select("li.br-item:nth-of-type(1) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .promoted.br-standardPrice.pd-price").text();
                final String price3 = div2.select("li.br-item:nth-of-type(2) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .promoted.br-standardPrice.pd-price").text();
                final String price4 = div2.select("li.br-item:nth-of-type(3) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .promoted.br-standardPrice.pd-price").text();
                final String price5 = div2.select("li.br-item:nth-of-type(4) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .promoted.br-standardPrice.pd-price").text();
                final String price6 = div2.select("li.br-item:nth-of-type(5) > .br-ahdecorations.br-small.br-card > .br-pdInfo > .promoted.br-standardPrice.pd-price").text();


                System.out.println("The top 5 products on Bing are "+title2+", " + title3+", " + title4+", " + title5+", " + title6+", " + ".These items costs " + price2+" , "+ price3+" , "+price4+" , "+price5+" , "+price6+" , "+".");

            }

        }






    }
}
