package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cs134.miracosta.edu.model.InteriorRoom;

/**
 * Main activity lets the user enter the data about their room and lets the calculate the amount
 * of paint they need. The user can also find out more about the calculation
 *
 * @author Dennis La
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    //declare the views
    private EditText lengthEditText;
    private EditText widthEditText;
    private EditText heightEditText;
    private EditText doorEditText;
    private EditText windowEditText;
    private TextView resultsTextView;

    //declare the model
    private InteriorRoom room;


    /**
     * Instantiates all the views and the model
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link controller variables to the views
        lengthEditText = findViewById(R.id.lengthEditText);
        widthEditText = findViewById(R.id.widthEditText);
        heightEditText = findViewById(R.id.heighEditText);
        doorEditText = findViewById(R.id.doorEditText);
        windowEditText = findViewById(R.id.windowEditText);
        resultsTextView = findViewById(R.id.resultsTextView);

        //instantiate model
        room = new InteriorRoom(0,0,0,0,0);



    }


    /**
     * Extracts data that the user entered and uses to to compute the amount of gallons needed.
     * Then it displays the total wall surface area of the room (4 walls 1 ceiling) and displays
     * the amount of paint required.
     * @param v the compute gallons button
     */
    public void computeGallons(View v)
    {
        double length;
        double width;
        double height;
        int numDoors;
        int numWindows;

        //1.extract the data from the editTexts
        if(lengthEditText.getText().toString().length() > 0)
        {
            length = Double.parseDouble(lengthEditText.getText().toString());
        }
        else
        {
            length = 0;
        }

        if(widthEditText.getText().toString().length() > 0)
        {
            width = Double.parseDouble(widthEditText.getText().toString());
        }
        else
        {
            width = 0;
        }

        if(heightEditText.getText().toString().length() > 0)
        {
            height = Double.parseDouble(heightEditText.getText().toString());
        }
        else
        {
            height = 0;
        }

        if(doorEditText.getText().toString().length() > 0)
        {
            numDoors = Integer.parseInt(doorEditText.getText().toString());
        }
        else
        {
            numDoors = 0;
        }

        if(windowEditText.getText().toString().length() > 0)
        {
            numWindows = Integer.parseInt(windowEditText.getText().toString());
        }
        else
        {
            numWindows = 0;
        }

        //2.update the model
        room.setWidth(width);
        room.setHeight(height);
        room.setLength(length);
        room.setDoors(numDoors);
        room.setWindows(numWindows);

        //3.update the text view
        String results = getString(R.string.int_surf_area) + " " + room.wallSurfaceArea() +
                " " + getString(R.string.unit_of_length) + "\n" +
                getString(R.string.gallons_needed) + " " + room.gallonsOfPaintRequired();

        resultsTextView.setText(results);
    }

    /**
     * goes to the help activity. sends an intent holding the amount of gallons required
     * @param v the help button
     */
    public void goToHelp(View v)
    {
        double gallonsNeeded = room.gallonsOfPaintRequired();

        Intent helpActivityIntent = new Intent(this, HelpActivity.class);
        helpActivityIntent.putExtra("Gallons Needed", gallonsNeeded);

        startActivity(helpActivityIntent);


    }


}
