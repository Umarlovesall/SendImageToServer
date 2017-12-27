package com.moadd.sendimagetoserver;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import static android.R.attr.path;

public class MainActivity extends AppCompatActivity {
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv= (ImageView) findViewById(R.id.iv);
        new HttpRequestTask1().execute();
        /**/

    }
    public  class HttpRequestTask1 extends AsyncTask<Void, Void,String > {
        String la=null;
        @Override
        public  String doInBackground(Void... params) {
            try {
                String URL = "http://192.168.0.107:8082/Moaddi1/operator/serviesoperatorimges1.htm";
                Bitmap bm =  BitmapFactory.decodeResource(MainActivity.this.getResources(),
                        R.drawable.tinnnn);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                byte[] b = baos.toByteArray();
                String encodedImage = Base64.encodeToString(b ,Base64.DEFAULT);
                Image m=new Image();
                m.setData(encodedImage);
                //m.setData("LokiBuoy");
                m.setName("TinTinDharla");
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                la = restTemplate.postForObject(URL,m,String.class);
                return la;
            } catch (Exception e) {
                Log.e("LoginActivity", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String  la) {
        Toast.makeText(MainActivity.this,la,Toast.LENGTH_LONG).show();
        //Decoding Recieved image string and displaying the image in the imageView.
            InputStream stream = new ByteArrayInputStream(Base64.decode(la.getBytes(), Base64.DEFAULT));
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            iv.setImageBitmap(bitmap);
        }
    }
   /* public class HttpRequestTask extends AsyncTask<Void, Void,String > {
        String la=null;
        @Override
        public  String doInBackground(Void... params) {
            FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
            formHttpMessageConverter.setCharset(Charset.forName("UTF8"));


            RestTemplate restTemplate = new RestTemplate();


            restTemplate.getMessageConverters().add( formHttpMessageConverter );
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

            String uri = "http://192.168.0.106:8081/Moaddi123/supplier/serviescreateitem.htm";

            //String imagePath = "/mnt/sdcard/DCIM/Camera/IMG_20140406_130350.jpg";

            MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
            //map.add("expenseId", 1);
            map.add("file", R.drawable.bluetoothoff);
            String data = UtilBase64Image.encoder(imagePath);
            //map.add("file", new FileSystemResource(imagePath));
            HttpHeaders imageHeaders = new HttpHeaders();
            imageHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<MultiValueMap<String, Object>> imageEntity = new HttpEntity<MultiValueMap<String, Object>>(map, imageHeaders);
            restTemplate.exchange(uri, HttpMethod.POST, imageEntity, Boolean.class);
            return "ab";
        }

        @Override
        protected void onPostExecute(String  la) {
            Toast.makeText(MainActivity.this,la,Toast.LENGTH_LONG).show();
        }
    }*/
   public Bitmap ConvertToImage(String image){
       try{
           InputStream stream = new ByteArrayInputStream(Base64.decode(image.getBytes(), Base64.DEFAULT));
           Bitmap bitmap = BitmapFactory.decodeStream(stream);
           return bitmap;
       }
       catch (Exception e) {
           return null;
       }
   }
}
