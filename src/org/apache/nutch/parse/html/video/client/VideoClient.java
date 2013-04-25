package org.apache.nutch.parse.html.video.client;

import javax.xml.ws.BindingProvider;
import java.util.*;
import org.apache.nutch.parse.html.video.client.*;

public class VideoClient {
    public static void main (String[] args) {
        try {
            VideoWebservice port = new VideoWebserviceService().getVideoWebservicePort();
            log((BindingProvider)port);
            
            System.out.println("Invoking getAreaInfo");
            //port.getAreaInfo();
            List<AreaCategoryTbl> l = port.getAreaInfo();
				for(int k=0;k<l.size();k++)
				     System.out.println("value:"+l.get(k).getAcName());

            System.out.println("Invoking getList");
            List<Test> re = port.getList();
            System.out.println("reee:"+re.get(1).getDesc());

            int number1 = 50;
            int number2 = 20;

            System.out.printf ("Invoking addNumbers(%d, %d)\n", number1, number2);
            int result = port.addNumbers (number1, number2);
            System.out.printf ("The result of adding %d and %d is %d.\n\n", number1, number2, result);

            number1 = -30;
            System.out.printf ("Invoking addNumbers(%d, %d)\n", number1, number2);
            result = port.addNumbers (number1, number2);
            System.out.printf ("The result of adding %d and %d is %d.\n", number1, number2, result);

        } catch (VideoException_Exception ex) {
            System.out.printf ("Caught VideoException_Exception: %s\n", ex.getFaultInfo ().getDetail ());
        }
    }

    private static final void log(BindingProvider port) {
        if (Boolean.getBoolean("wsmonitor")) {
            String address = (String)port.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
            address = address.replaceFirst("8080", "4040");
            port.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
        }
    }
}