package com.zlk.common.util.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FileUtils {
    //无成员变量 --- 无状态
    public static String getScript(String fileName){
        String resource = FileUtils.class.getClassLoader().getResource(fileName).getPath();
        return readFileByLines(resource);
    }

	public static String readFileByLines(String fileName) {
        FileInputStream file = null;
        BufferedReader reader = null;
        InputStreamReader inputFileReader = null;
        String content = "";
        String tempString = null;
        try {
            file = new FileInputStream(fileName);
            inputFileReader = new InputStreamReader(file, "utf-8");
            reader = new BufferedReader(inputFileReader);
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                content += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return content;
    }
	
	public static void main(String[] args) {
        String path = FileUtils.class.getClassLoader().getResource("lua/unlock.lua").getPath();
		String script = FileUtils.readFileByLines(path);
		System.out.println(script);
	}
}
