package com.example.osl.mysqldemo;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by OSL on 16/3/2017.
 */
public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    Intent mainPageIntent;

    //input dialog Login status
    BackgroundWorker (Context ctx) {
        context = (Context) ctx;
    } // on click listener
    @Override
    protected String doInBackground(String... params) { //this method does background tasks. It gets parameters as an array when execute() is called
        String type = params[0]; //
        String login_url = "http://roonec.com/login.php";
        if(type.equals("login")) {
            try {
                String phone = params[1];
                String provider = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");//connect to php
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8")); //
                String post_data = URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"
                        // this post is sending info to php code
                        +URLEncoder.encode("provider","UTF-8")+"="+URLEncoder.encode(provider,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1")); // code encrypting
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
        //for login status


    }

    @Override
    protected void onPostExecute(String result) {



        if(result.equals("welcome")) {

            mainPageIntent = new Intent(context.getApplicationContext(), MainPage.class);
            context.startActivity(mainPageIntent);


        }
        else {
            alertDialog.setMessage(result); // result what you get from your database
            alertDialog.show();
        }



    }




    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }



}