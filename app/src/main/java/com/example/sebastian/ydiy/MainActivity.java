package com.example.sebastian.ydiy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.btnNext);
        Button previousButton = (Button) findViewById(R.id.btnPre);

        final TextView stepText = (TextView) findViewById(R.id.stepText);

        final StepCounter StepIndex = new StepCounter();
        StepIndex.setValue(-1);

        final ArrayList<String> steps = new ArrayList<String>();

        steps.add("How to make flapjacks\n\nIngredients\n" +
                "1 3/4 cups all-purpose flour\n" +
                "3 tablespoons sugar\n" +
                "2 teaspoons baking powder\n" +
                "1/4 teaspoon fine salt\n" +
                "1/8 teaspoon freshly ground nutmeg\n" +
                "3 tablespoons unsalted butter, plus more as needed\n" +
                "2 large eggs, room temperature\n" +
                "1 1/4 cups milk, at room temperature\n" +
                "1/2 teaspoon vanilla extract");
        steps.add("1.) In a large bowl, whisk together the flour, sugar, baking powder, salt, and nutmeg.");
        steps.add("2.) In another bowl, beat the eggs and then whisk in the milk and vanilla.");
        steps.add("3.) Melt the butter in a large cast-iron skillet or griddle over medium to medium-low heat.");
        steps.add("4.) Whisk the butter into the milk mixture, add to the flour mixture, and whisk until a thick batter is just formed.");
        steps.add("5.) Keeping the skillet at medium to medium low heat, ladle about 1/4 cup of the batter onto the skillet, to make a pancake. Make one or two more pancakes, taking care to keep them evenly spaced apart.");
        steps.add("6.) Cook, until bubbles break the surface of the pancakes, and the undersides are golden brown, about 2 minutes. Flip with a spatula and cook about 1 minute more on the second side.");
        steps.add("7.) Serve immediately or transfer to a platter and cover loosely with foil to keep warm.");
        steps.add("8.) Repeat with the remaining batter, adding more butter to the skillet as needed.");
        steps.add("9.) Enjoy your homemade Flapjacks");
        steps.add("10.) Now go take over the world!");

        View.OnClickListener stepNextListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StepIndex.addOne();
                if (StepIndex.getValue().equals(11) ) {
                    StepIndex.setValue(0);
                }
                stepText.setText( steps.get( StepIndex.getValue() ) );

            }
        };

        View.OnClickListener stepPreviousListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StepIndex.subtractOne();

                if (StepIndex.getValue().equals(-1) ) {
                    StepIndex.setValue(0);
                }

                stepText.setText( steps.get(StepIndex.getValue()) );
            }
        };

        nextButton.setOnClickListener(stepNextListener);
        previousButton.setOnClickListener(stepPreviousListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
