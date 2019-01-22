/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.woaipaifang.user.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class DownloadVideo {

    private static String videoUrl = "https://fs.esf.fangdd.com/ddjj/lnGPyUg_eEvTWGP591Afmk8MH90w.mp4";
    private static final int MAX_BUFFER_SIZE = 1000000;

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        try {
            // 1.获取连接对象
            URL url = new URL(videoUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Range", "bytes=0-");
            connection.connect();
            if(connection.getResponseCode() / 100 != 2) {
                System.out.println("连接失败...");
                return;
            }
            // 2.获取连接对象的流
            inputStream = connection.getInputStream();
            //已下载的大小
            int downloaded = 0;
            //总文件的大小
            int fileSize = connection.getContentLength();
            String fileName = url.getFile();
            System.out.println(fileName);
            fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
            StringBuffer sb = new StringBuffer();
            sb.append("C:/video-pf/");
            sb.append(UUID.randomUUID().toString().replaceAll("-", ""));
            sb.append(".mp4");
            // 3.把资源写入文件
            randomAccessFile = new RandomAccessFile(sb.toString(),"rw");
            System.out.println(fileName);
            while(downloaded < fileSize) {
                // 3.1设置缓存流的大小
                byte[] buffer = null;
                if(fileSize - downloaded >= MAX_BUFFER_SIZE) {
                    buffer = new byte[MAX_BUFFER_SIZE];
                }else {
                    buffer = new byte[fileSize - downloaded];
                }
                // 3.2把每一次缓存的数据写入文件
                int read = -1;
                int currentDownload = 0;
                long startTime = System.currentTimeMillis();
                while(currentDownload < buffer.length) {
                    read = inputStream.read();
                    buffer[currentDownload ++] = (byte) read;
                }
                long endTime = System.currentTimeMillis();
                double speed = 0.0;
                if(endTime - startTime > 0) {
                    speed = currentDownload / 1024.0 / ((double)(endTime - startTime)/1000);
                }
                randomAccessFile.write(buffer);
                downloaded += currentDownload;
                randomAccessFile.seek(downloaded);
                System.out.printf("下载了进度:%.2f%%,下载速度：%.1fkb/s(%.1fM/s)%n",downloaded * 1.0 / fileSize * 10000 / 100,speed,speed/1000);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.disconnect();
                inputStream.close();
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void demo() {
        try {
            URL url = new URL(videoUrl);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
