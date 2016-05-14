package com.example.xiefei.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class MainActivity extends AppCompatActivity {
    ImageView imageView,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image);
        imageView2  = (ImageView) findViewById(R.id.image2);
        OpenCVLoader.initDebug();
        Mat src = new Mat();
        Mat gary = new Mat();
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.pic2);
        Utils.bitmapToMat(srcBitmap,src);
        Imgproc.cvtColor(src,gary,Imgproc.COLOR_BGRA2GRAY);
        Bitmap bitmap = Bitmap.createBitmap(srcBitmap.getWidth(),srcBitmap.getHeight(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(gary,bitmap);
        imageView.setImageBitmap(srcBitmap);
        imageView2.setImageBitmap(bitmap);
    }
}
