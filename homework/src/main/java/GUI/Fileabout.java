package GUI;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fileabout
{
        public static void Registerdata_Creat(String in,String out) {
                //所创建文件目录
                String path ="D:\\MY1.0\\data";
                String fileName = "Register_data.txt";
                //文件名及类型
                String defaultfile="Default_data.txt";
                File f = new File(path);
                try {
                if(!f.exists()){
                    f.mkdirs(); //创建目录
                }
                File file = new File(path,fileName);
                if(!file.exists()) {
                    //surround with try/catch
                    file.createNewFile();
                }
                FileWriter writer =new FileWriter(file,true);
                writer.append(in);
                writer.close();
                FileWriter dewriter =new FileWriter(defaultfile,true);
                dewriter.append(out);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    public static String filechoose()
    {
        JFileChooser fileChooser = new JFileChooser("D:\\");

        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null ;
    }
    public static List<String> filereader(String filepath) throws IOException {
                 List<String> emails = new ArrayList<String>();
                // String appendText = "This is extra text" + Environment.NewLine;
                 // Open the file to read from.
                // File.AppendAllText(path, appendText);
                 //emai ls = File.ReadAllLines(filepath);
        return emails;
    }
}
