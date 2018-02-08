package com.mars.android20180208_3;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JobScheduler jobScheduler;
    JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个JobScheduler对象
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        /*
        当你想创建定时任务时，你可以使用JobInfo.Builder来构建一个JobInfo对象，
        然后传递给你的Service。JobInfo.Builder接收两个参数，
        第一个参数是你要运行的任务的标识符，第二个是这个Service组件的类名。
         */
        JobInfo.Builder builder = new JobInfo.Builder( 1,
                new ComponentName(getPackageName(),
                        MyService.class.getName() ) );
        /*
        这个builder允许你设置很多不同的选项来控制任务的执行。
        下面的代码片段就是展示了如何设置以使得你的任务可以每隔三秒运行一次。
         */
        //Android7.0以後的版本時間不法低於15分鐘
        builder.setPeriodic(3000);
        jobInfo = builder.build();
    }


    public void click1(View v)
    {
        /*
        通过如下所示的代码将它发送到你的JobScheduler
         */
        jobScheduler.schedule(jobInfo);
    }
}
