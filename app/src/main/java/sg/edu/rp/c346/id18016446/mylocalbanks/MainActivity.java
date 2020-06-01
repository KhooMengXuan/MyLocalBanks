package sg.edu.rp.c346.id18016446.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvDBS) {
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        } else if (v == tvOCBC) {
            menu.add(0,2,0,"Website");
            menu.add(1,3,1,"Contact the bank");
        } else if (v == tvUOB) {
            menu.add(0,4,0,"Website");
            menu.add(2,5,1,"Contact the bank");
        }

    }

    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 1) {
            String number = "18001111111";
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(intentCall);
        } else if (item.getItemId() == 2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 3) {
            String number = "18003633333";
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(intentCall);
        } else if (item.getItemId() == 4) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);
            return true; //menu item successfully handled
        } else if (item.getItemId() == 5) {
            String number = "18002222121";
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.

        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
