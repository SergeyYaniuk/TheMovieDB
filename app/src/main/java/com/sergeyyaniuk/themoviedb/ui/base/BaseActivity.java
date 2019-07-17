package com.sergeyyaniuk.themoviedb.ui.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.utils.NetworkUtils;

import dagger.android.support.DaggerAppCompatActivity;


public abstract class BaseActivity extends DaggerAppCompatActivity implements ErrorCallback {

    ProgressDialog progressDialog;

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    @Override
    public void setDataError(boolean isError) {
        if (isError) showToast(getResources().getString(R.string.error));
    }

    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransitionExit();
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }
    
    public void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
