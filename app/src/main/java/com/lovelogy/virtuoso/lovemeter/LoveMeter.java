package com.lovelogy.virtuoso.lovemeter;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lovelogy.virtuoso.lovelogyd.R;

import java.util.Random;

/**
 * Created by Virtuoso on 7/8/2015.
 */
public class LoveMeter extends Fragment {

    static String male, female;
    protected EditText firstperson,secoundperson;
    protected ImageView dilvil,wheel;
    protected Button calculate;
    protected  TextView percentage;
    int state=0,count_t=0,rotation=0,amount;
    Random random;
    Animation animation=null;
    Handler handler=new Handler(){
        public void handleMessage(Message m)
        {
            if(state==0)
            {
                count_t++;
                if(count_t==100)
                {
                    state=1;
                }
            }
            else
            {
                count_t--;
                if(count_t==0)
                {
                    state=0;
                }
            }
            percentage.setTextColor(Color.WHITE);

            percentage.setText(count_t+"%");
        }
    };

    public LoveMeter() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.love_meter, container, false);

        firstperson=(EditText)v.findViewById(R.id.first_person);
        secoundperson=(EditText)v.findViewById(R.id.second_person);

        wheel=(ImageView)v.findViewById(R.id.wheel);
        calculate=(Button)v.findViewById(R.id.cal_button);
        percentage=(TextView)v.findViewById(R.id.love_percentage);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                male=firstperson.getText().toString().trim();
                female=secoundperson.getText().toString().trim();

                if(male.length()==0||female.length()==0)
                {
                    Toast.makeText(getActivity(), "Please Enter Name then click button", Toast.LENGTH_LONG).show();
                }
                else{

                    Love love = new Love();
                    love.setNames(male,female);

                    String calculate =love.toString();
                    amount=Integer.valueOf(calculate);


                    Float f=Float.parseFloat("0.5");
                    random=new Random();
                    if(amount>=0&&amount<=10){

                        amount = amount +70;
                        rotation=22;
                    }
                    if(amount>10&&amount<=20){

                        amount = amount + 60;
                        rotation=22+45;
                    }
                    if(amount>20&&amount<=30){

                        amount = amount + 50;
                        rotation=22+90;
                    }
                    if(amount>30&&amount<=40){

                        amount = amount + 40;
                        rotation=22+135;
                    }
                    if(amount>40&&amount<=50){

                        amount = amount + 30;
                        rotation=22+180;
                    }
                    if(amount>50&&amount<=65){
                        amount = amount + 20;
                        rotation=22+225;
                    }
                    if(amount>65&&amount<=85){

                        rotation=360-22-45;
                    }
                    if(amount>85&&amount<=100){
                        rotation=360-22;
                    }
                    //rotation+=170;
                    rotation+=1440;
                    animation=new RotateAnimation(0,rotation,Animation.RELATIVE_TO_SELF,f,Animation.RELATIVE_TO_SELF,f);
                   // ImageView image1=(ImageView)findViewById(R.id.imageView2);
                    animation.setDuration(6000);
                    animation.setFillAfter(true);
                    Float start,end;
                    start=1F;
                    end=.5F;
                    Animation animation1=new ScaleAnimation(start,end,start,end,Animation.RELATIVE_TO_SELF,f,Animation.RELATIVE_TO_SELF,f);
                    animation1.setDuration(600);
                    animation1.setRepeatCount(9);
                    animation1.setRepeatMode(Animation.REVERSE);
                    animation1.setFillAfter(true);

                    Thread count=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            for(int j=0;j<400+amount;j++)
                            {
                                try
                                {
                                    handler.sendMessage(handler.obtainMessage());
                                    Thread.sleep(6000/(400+amount));
                                }
                                catch(Exception e)
                                {
                                    //Toast.makeText(getActivity(),e.toString(),Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
                    state=0;
                    count_t=0;
                   // image1.startAnimation(animation1);
                    wheel.startAnimation(animation);
                    animation1.setAnimationListener(new Animation.AnimationListener() {

                        @Override
                        public void onAnimationStart(Animation arg0) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animation arg0) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animation arg0) {
                            if(amount>=0&&amount<=10){
                                Toast.makeText(getActivity(),"Worst Enemies - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>10&&amount<=20){
                                Toast.makeText(getActivity(),"Some Day Some Way - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>20&&amount<=30){
                                Toast.makeText(getActivity(),"Love is in the AIR - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>30&&amount<=40){
                                Toast.makeText(getActivity(),"Find Someone Else - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>40&&amount<=50){
                                Toast.makeText(getActivity(),"Artificial Relationship - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>50&&amount<=65){
                                Toast.makeText(getActivity(),"Just Best Friends - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>65&&amount<=85){
                                Toast.makeText(getActivity(),"True Love - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            if(amount>85&&amount<=100){
                                Toast.makeText(getActivity(),"Made for each other - Luck "+amount+"%",Toast.LENGTH_LONG).show();
                            }
                            // TODO Auto-generated method stub

                        }
                    });
                    count.start();


                }




            }
        });



        return v;
    }


}
