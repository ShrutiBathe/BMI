import java.net.*;
import java.util.*;
import java.io.*;
class UCDemo
{
    public static void main(String args[])throws MalformedURLException
    {
        URL hp=new URL("http://www.MSBTE.com");
        URLConnection hpcon=hp.openConnection();
        long d=hpcon.getDate();
        System.out.println("Date ="+new Date(d));
        System.out.println("Content Type= "+hpcon.getContentType());
        long da=hpcon.getExpirationDate();
        System.out.println("Expiry Date = "+new Date(da));
        long lda=hpcon.getLastModifierDate();
        System.out.println("Last Modifier Date = "+new Date(lda));
        int len=hpcon.getContentLength();
        System.out.println("Content Length = "+len);
    }
}
