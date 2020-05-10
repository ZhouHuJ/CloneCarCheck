package com.grapro.api;

import java.io.*;

public class PicIo {
    public static String copyFile(String src,String imageDirectory) throws Exception {
        String target = "";
        File imageDirectoryFile = new File(imageDirectory);
        File[] file = imageDirectoryFile.listFiles();
        if(file.length>0){
            int index = Integer.valueOf(file[file.length-1].getName()) + 1;
            target = imageDirectory + "\\" + index + ".png";
        }else{
            target = imageDirectory + "\\1.png";
        }
        File srcFile = new File(src);
        File targetFile = new File(target);
        InputStream in = new FileInputStream(srcFile);
        OutputStream out = new FileOutputStream(targetFile);
        byte[] bytes = new byte[1024];
        int len = -1;
        while((len=in.read(bytes))!=-1){
            out.write(bytes, 0, len);
        }
        srcFile.delete();
        in.close();
        out.close();
        return target;
    }

}

