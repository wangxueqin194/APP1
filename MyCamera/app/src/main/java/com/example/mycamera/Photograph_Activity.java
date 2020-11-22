package com.example.mycamera;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableCompoundDrawablesView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mycamera.R;

import java.io.IOException;
import java.util.List;

import view.PictureView;

public class Photograph_Activity extends AppCompatActivity implements SurfaceHolder.Callback{

    private static final String TAG=Photograph_Activity.class.getSimpleName();//获得类名
    private SurfaceHolder holder;//用于控制SurfaceView显示内容
    private SurfaceView surfaceView;//显示相机拍摄内容
    private PictureView pictureView;//效果自定义view
    private RelativeLayout bottom;//底部按钮栏
    private ImageView save;
    private ProgressDialog dialog;

    private boolean haveCamera;//是否有相机设备
    private int mCurrentCamIndex;//相机指数
    private int ROTATE;//旋转值；
    private int minFocus;
    private int maxFocus;
    private int everyFocus;
    private int nowFocus;//当前焦距
    private Camera camera;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_photograph);
            initViews();
            setViews();
        }
        public void OnBack(View view){
            Photograph_Activity.this.finish();
        }
    public void discern(View view){
        startActivity(new Intent(this, Discern.class));
    }

    private void initViews(){
            surfaceView=(SurfaceView)findViewById(R.id.surface);
            pictureView=(PictureView)findViewById(R.id.picture);
            bottom=(RelativeLayout)findViewById(R.id.bottom);
    }
    private boolean checkCameraHardware(){
            //判断是否有摄像头
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            return true;
        }
        else {
            return false;
        }
    }
    private Camera openFrontFacingCameraGingerbread(){
            int cameraCount;
            Camera mCamera=null;
            Camera.CameraInfo cameraInfo =new Camera.CameraInfo();
            cameraCount=Camera.getNumberOfCameras();
            for(int camIdx=0;camIdx<cameraCount;camIdx++){
                Camera.getCameraInfo(camIdx,cameraInfo);
                //判断是否有前置摄像头
                if(cameraInfo.facing==Camera.CameraInfo.CAMERA_FACING_FRONT){
                    try{
                        mCamera=Camera.open(camIdx);
                        mCurrentCamIndex=camIdx;
                    }catch (RuntimeException e){
                        Log.e(TAG,"相机打开失败："+e.getLocalizedMessage());
                    }
                }
            }
            return mCamera;
    }
    private void setCameraDisplayOrientation(Activity activity,int cameraId,Camera camera){
            Camera.CameraInfo info=new Camera.CameraInfo();
            Camera.getCameraInfo(cameraId,info);
            int rotation=activity.getWindowManager().getDefaultDisplay().getRotation();
            int degress=0;
            switch(rotation){
                case Surface.ROTATION_0:
                    degress=0;
                break;
                case Surface.ROTATION_90:
                    degress=90;
                    break;
                    case Surface.ROTATION_180:
                        degress=180;
                        break;
                        case Surface.ROTATION_270:
                            degress=270;
                            break;
            }
           int result=0;
            if(info.facing==Camera.CameraInfo.CAMERA_FACING_FRONT){
                result=(info.orientation+degress)%360;
                result=(360-result)%360;
            }else{
                result=(info.orientation-degress+360)%360;
            }
            ROTATE=result+180;
            camera.setDisplayOrientation(result);
    }
    private void setCamera(){
            if(checkCameraHardware()){
                camera=openFrontFacingCameraGingerbread();
                setCameraDisplayOrientation(this,mCurrentCamIndex,camera);
                Camera.Parameters parameters=camera.getParameters();
                parameters.setPictureFormat(ImageFormat.JPEG);
                List<String> list=parameters.getSupportedFocusModes();
                for(String str:list){
                    Log.e(TAG,"支持对焦的模式："+str);
                }
                List<Camera.Size> pictureList=parameters.getSupportedPictureSizes();
                List<Camera.Size> previewList=parameters.getSupportedPreviewSizes();
                parameters.setPictureSize(pictureList.get(0).width,pictureList.get(0).height);
                parameters.setPreviewSize(previewList.get(0).width,previewList.get(0).height);
                nowFocus=parameters.getZoom();
                camera.setParameters(parameters);
            }
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Log.e("surfaceCreated","绘制开始");
        try{
            setCamera();
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            camera.release();
            camera=null;
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {

            Log.e("surfaceChanged","绘制改变");
            try{
                camera.stopPreview();
                camera.setPreviewDisplay(holder);
                camera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            Log.e("surfaceDestroyed","绘制结束");
            toRelease();
    }
    private void toRelease(){
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera=null;
    }
    private void setViews(){
            holder=surfaceView.getHolder();
            holder.addCallback(this);
    }







}