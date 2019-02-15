package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Help activity shows the user how much paint is required and how it was calculated
 * Lets the user go back to input different data
 *
 * @author Dennis La
 * @version 1.0
 */
public class HelpActivity extends AppCompatActivity {

    //declare the view
    private TextView helpPaintReqTextView;

    /**
     * instantiate the views and get the intent from main. then update the paint required
     * text view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //instantiate the view
        helpPaintReqTextView = findViewById(R.id.helpPaintReqTextView);

        //get the intent
        Intent intent = getIntent();

        String text = getString(R.string.estimated_paint_req) + " " +
                intent.getDoubleExtra("Gallons Needed", 0) + " " +
                getString(R.string.unit_of_volume);

        //set the text view
        helpPaintReqTextView.setText(text);

    }


    /**
     * ends the activity and goes back to the main activity
     * @param v the button to go back to data entry
     */
    //button method
    public void goToInput(View v)
    {
        this.finish();
    }
}
