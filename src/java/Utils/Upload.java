/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItemStream;

/**
 *
 * @author Santosh
 */
public class Upload { 
    public static String writeFile(FileItemStream file, String filename) {
        String fullFileName = "";
        try {
//            String path = "E:\\SGM_Nidhi\\photo";
            String path = "D:\\git_project\\ProgressiveHostel\\docImage";

            File fi = new File(path);
            if (!fi.exists()) {
                fi.mkdirs();
            }
            String ext = file.getName().substring(file.getName().lastIndexOf('.'));

            fullFileName = filename + ext;
            File savefile = new File(fi.getAbsolutePath() + File.separator + fullFileName);

            InputStream i = file.openStream();
            FileOutputStream fout = new FileOutputStream(savefile);
            int x = 0;
            byte b[] = new byte[1024];
            while ((x = i.read(b)) != -1) {
                fout.write(b, 0, x);
            }
            fout.flush();
            fout.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return fullFileName;
    }  
}
