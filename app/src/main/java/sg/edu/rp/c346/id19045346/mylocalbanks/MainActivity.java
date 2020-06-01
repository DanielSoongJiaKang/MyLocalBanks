package sg.edu.rp.c346.id19045346.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttondbs;
    Button buttonocbc;
    Button buttonuob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttondbs = findViewById(R.id.btndbs);
        buttonocbc = findViewById(R.id.btnocbc);
        buttonuob = findViewById(R.id.btnuob);



                registerForContextMenu(buttondbs);



                registerForContextMenu(buttonocbc);
                registerForContextMenu(buttonuob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        if(v.getId() == R.id.btndbs) {
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        }
        else if(v.getId() == R.id.btnocbc) {

            menu.add(1,0,0,"Website");
            menu.add(1,1,1,"Contact the bank");
        }
        else if(v.getId() == R.id.btnuob) {
            menu.add(2,0,0,"Website");
            menu.add(2,1,1,"Contact the bank");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0 && item.getGroupId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intent);
                return true; //menu item successfully handled
            }


        else if(item.getItemId() == 1 && item.getGroupId() == 0) {
            String dbs = getString(R.string.dbsnum);
            Intent intentCall= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+ dbs));
            startActivity(intentCall);
            return  true;

        }

        else if(item.getItemId() == 0 && item.getGroupId() == 1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
            startActivity(intent);
            return true; //menu item successfully handled
        }
        else if(item.getItemId() == 1 && item.getGroupId() == 1) {
            String ocbc = getString(R.string.ocbcnum);
            Intent intentCall= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + ocbc));
            startActivity(intentCall);
            return true;


        }
        else if(item.getItemId() == 0 && item.getGroupId() == 2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
            startActivity(intent);
            return true; //menu item successfully handled
        }
        else if(item.getItemId() == 1 && item.getGroupId() == 2) {
            String uob = getString(R.string.uobnum);
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + uob));
            startActivity(intent);
            return true;
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.iteng) {

            buttondbs.setText(getString(R.string.dbs));
            buttonocbc.setText(getString(R.string.ocbc));
            buttonuob.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.itchi) {
            buttondbs.setText(getString(R.string.dbschi));
            buttonocbc.setText(getString(R.string.ocbcchi));
            buttonuob.setText(getString(R.string.uobchi));
            return true;
        } else {
            buttondbs.setText("Error translation");
            buttonocbc.setText("Error translation");
            buttonuob.setText("Error translation");

        }

        return super.onOptionsItemSelected(item);
    }










}
