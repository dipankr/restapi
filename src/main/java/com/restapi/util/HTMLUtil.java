package com.restapi.util;

public class HTMLUtil {
    public static String getDogViewHTML(String url){
        return "<html style=\"height: 100%;\">\n" +
                "    <head>\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, minimum-scale=0.1\">\n" +
                "        <title>Dog</title>\n" +
                "    </head>\n" +
                "    <body style=\"margin: 0px; background: #0e0e0e; height: 100%\">\n" +
                "        <img style=\"display: block;-webkit-user-select: none;margin: auto;cursor: zoom-in;background-color: hsl(0, 0%, 90%);transition: background-color 300ms;\"\n" +
                "        src=\"https://"+url+"\" width=auto height=100%>\n" +
                "    </body>\n" +
                "</html>";
    }

    public static String getTextHTML(String fact){
        return  "<html>\n" +
                "    <body><span style=\"font-size: calc(3vw + 3vh);\")>" + fact + "</span></body>\n" +
                "</html>";
    }

    public static boolean isImage(String res) {
        return  res.endsWith(".jpg\"}")  ||
                res.endsWith(".png\"}")  ||
                res.endsWith(".gif\"}")  ||
                res.endsWith(".jpeg\"}");
    }
}
