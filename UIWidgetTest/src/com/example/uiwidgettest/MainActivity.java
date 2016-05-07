package com.example.uiwidgettest;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button button;
	private EditText editText;
	private ImageView imageView;
	private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);
        
    }
    
    @Override
    public void onClick(View v){
		switch (v.getId()) {
		case R.id.button:
//			String inputText = editText.getText().toString();
//			Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
//			imageView.setImageResource(R.drawable.jelly_bean);
//			if(progressBar.getVisibility() == View.GONE){
//				progressBar.setVisibility(View.VISIBLE);
//			}else{
//				progressBar.setVisibility(View.GONE);
//			}
//			int progress = progressBar.getProgress();
//			progress = progress + 10;
//			progressBar.setProgress(progress);
//			AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//			dialog.setTitle("This is Dialog");
//			dialog.setMessage("Something important.");
//			dialog.setCancelable(false);
//			dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//			}
//			});
//			dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {				
//				@Override
//				public void onClick(DialogInterface arg0, int arg1) {
//					
//				}
//			});
//			dialog.show();
			ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setTitle("This is ProgressDialog");
			progressDialog.setMessage("Loading...");
			progressDialog.setCancelable(true);
			progressDialog.show();
			break;
		default:
			break;
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
