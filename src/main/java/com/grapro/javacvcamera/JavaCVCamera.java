package com.grapro.javacvcamera;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacv.*;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaCVCamera implements Runnable{

    static OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

    @Override
    public void run() {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        try {
            grabber.start();   //开始获取摄像头数据
            CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
            canvas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            canvas.setAlwaysOnTop(true);
            long ex = 0;
            String url;
            while(true) {
                if (!canvas.isDisplayable()) {//窗口是否关闭
                    grabber.stop();//停止抓取
                    System.exit(2);//退出
                    break;
                }
                url = "http://localhost:8080/carcheck/dataConversion.do?index=";
                Frame frame = grabber.grab();
                canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
                opencv_core.Mat mat = converter.convertToMat(grabber.grabFrame());
                ex++;
                if(ex%10==0){
                    url=url+ex/10;
                    opencv_imgcodecs.imwrite("D:\\ideaproject\\cloneCarCheck\\src\\main\\webapp\\videocaptureimg\\" + ex/10 + ".png", mat);
                    URL urlget = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) urlget.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    System.out.println(connection.getResponseCode());
                }
                Thread.sleep(100);//100毫秒刷新一次图像
            }

        }catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}


