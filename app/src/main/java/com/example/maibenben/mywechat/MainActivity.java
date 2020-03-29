package com.example.maibenben.mywechat;

import android.app.Fragment;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{
    private Fragment nTab01b = new weixinFragment();  //这个之前犯错误了（V4的原因）
    private Fragment nTab02b = new frdFragment();
    private Fragment nTab03b = new contactFragment();
    private Fragment nTab04b = new settingFragment();

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAdd;
    private LinearLayout mTabSet;
    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAdd;
    private ImageButton mImgSet;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();

        iniEvent();
        selectFragment(0);

    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, nTab01b);
        transaction.add(R.id.id_content, nTab02b);
        transaction.add(R.id.id_content, nTab03b);
        transaction.add(R.id.id_content, nTab04b);
        transaction.commit();
    }

    private void selectFragment(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(nTab01b);
                resetimg();
                mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(nTab02b);
                resetimg();
                mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(nTab03b);
                resetimg();
                mImgAdd.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(nTab04b);
                resetimg();
                mImgSet.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(nTab01b);
        transaction.hide(nTab02b);
        transaction.hide(nTab03b);
        transaction.hide(nTab04b);
    }
    private void initView(){
        mTabWeixin = (LinearLayout)findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout)findViewById((R.id.id_tab_friend));
        mTabAdd = (LinearLayout)findViewById((R.id.id_tab_address));
        mTabSet = (LinearLayout)findViewById((R.id.id_tab_setting));

        mImgWeixin = (ImageButton)findViewById(R.id.imageButton1);
        mImgFrd = (ImageButton)findViewById(R.id.imageButton2);
        mImgAdd = (ImageButton)findViewById(R.id.imageButton3);
        mImgSet = (ImageButton)findViewById(R.id.imageButton4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_tab_weixin:
                selectFragment(0);
                break;
            case R.id.id_tab_friend:
                selectFragment(1);
                break;
            case R.id.id_tab_address:
                selectFragment(2);
                break;
            case R.id.id_tab_setting:
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    public void resetimg(){
        mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgAdd.setImageResource(R.drawable.tab_address_normal);
        mImgSet.setImageResource(R.drawable.tab_settings_normal);
    }

    private void iniEvent(){
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAdd.setOnClickListener(this);
        mImgSet.setOnClickListener(this);
    }
}
