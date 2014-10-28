package com.linux.fejfar.hfnasadailyimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class NasaDailyImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa_daily_image);
        IotdHandler handler = new IotdHandler();
        handler.processFeed();
        resetDisplay(handler.getTitle(), handler.getDate(), handler.getImage(), handler.getDescription());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nasa_daily_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void resetDisplay(String title, String date, Bitmap imageUrl, String description){
        TextView titleView = (TextView) findViewById(R.id.textViewHeader);
        titleView.setText(title);

        TextView dateView = (TextView) findViewById(R.id.textViewSubHeader);
        dateView.setText(date);

        IotdHandler handler = new IotdHandler();
        handler.getImage("http://www.nasa.gov/sites/default/files/thumbnails/image/potw1441a.jpg");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(handler.getImage("http://www.nasa.gov/sites/default/files/thumbnails/image/potw1441a.jpg"));

        TextView descriptionView = (TextView) findViewById(R.id.textViewDesc);
        descriptionView.setText(description);



    }
}
