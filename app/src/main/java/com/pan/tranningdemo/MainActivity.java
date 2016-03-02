package com.pan.tranningdemo;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TrainingDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * 内部存储的特点
         * 1.总是可用的
         * 2.默认只能被自己访问
         * 3.当app被删除时，其存储在内部存储区域中相关的文件都会被删除
         * 4.是避免其他app访问的最佳存储区域
         */
        /**获取内部存储的路径*/
        String fileDir = getFilesDir().toString();
        Log.i(TAG, fileDir);

        /**获取内部存储缓存路径*/
        String cacheDir = getCacheDir().toString();
        Log.i(TAG, cacheDir);

        /**在内部存储区域创建一个文件，并写入内容*/
        String fileName = "TrainingFile";
        File file = new File(getFilesDir(), fileName);
        String fileContent = "TrainingContent";
        //向文件中写入内容
        try {
            FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(fileContent.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**获取此app内部存储区域中的所有文件*/
        File[] files = getFilesDir().listFiles();
        for (File file1 : files) {
            Log.i(TAG, file1.toString());
        }

        /**在内部存储缓存区创建一个缓存文件*/
        String tempFileName = "TrainingTempFile";
        try {
            File tempFile = File.createTempFile(tempFileName, null, getCacheDir());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**获取此app内部存储缓存区中的所有缓存文件*/
        File[] cacheFiles = getCacheDir().listFiles();
        for (File cacheFile : cacheFiles) {
            Log.i(TAG, cacheFile.toString());
        }

        /**
         * 外部存储的特点
         * 1.不一定能访问
         * 2.能被其他的app访问
         * 3.当app被卸载时，只会删除根目录下的文件
         * 4.允许其他app访问的最佳存储区域
         */

        /**
         * 因为外部存储不一定能访问的特点，所以在使用外部存储时，
         * 需要获取外部存储区域的状态，判断外部存储是否可用
         */
        String externalStorageState = Environment.getExternalStorageState();
        //判断外部存储是否可读可写
        boolean readAndWriteState = externalStorageState.equals(Environment.MEDIA_MOUNTED);
        if (readAndWriteState) {
            Log.i(TAG, "External can read and write !");
        }
        //判断外部存储是否可读
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED) || externalStorageState.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            Log.i(TAG, "External can read !");
        }

        //获取外部存储路径下private file路径，此处存储的文件同样可以被其他app访问（其他app无法使用的文件），app被删除时，此处的文件会被删除
        File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Log.i(TAG, externalFilesDir.toString());

        //获取外部存储的根目录，即public file 存储的路径，此处存储的文件可以被其他app访问，app被删除时，此处的文件不会被删除
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Log.i(TAG, externalStorageDirectory.toString());

        /**查看内部存储空间*/
//        Log.i(TAG, getFilesDir().getFreeSpace()+"");
//        Log.i(TAG, getFilesDir().getTotalSpace()+"");
//        Log.i(TAG, getCacheDir().getFreeSpace()+"");
//        Log.i(TAG, getCacheDir().getTotalSpace()+"");

        /**查看外部存储空间*/
        long freeSpace = externalStorageDirectory.getFreeSpace();
        Log.i(TAG, freeSpace + "");
        long totalSpace = externalStorageDirectory.getTotalSpace();
        Log.i(TAG, totalSpace + "");

        /**操作文件*/
        //删除文件
        for (File cacheFile : cacheFiles) {
            boolean isDelete = cacheFile.delete();
//            deleteFile(cacheFile.toString());
            if (isDelete) {
                Log.i(TAG, cacheFile.toString()+" is delete");
            }
        }


    }


}
