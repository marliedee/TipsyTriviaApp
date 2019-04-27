package com.android.tipsytrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuestionsPageActivity extends AppCompatActivity {
 private String [] incorrectChoiceArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.textview_multiple_choice_one:
                if (checked)
                    // Choice One
                    break;
            case R.id.textview_multiple_choice_two:
                if (checked)
                    // Choice Two
                    break;
            case R.id.textview_multiple_choice_three:
                if (checked)
                    // Choice Three
                    break;
            case R.id.textview_multiple_choice_four:
                if (checked)
                    // Choice Four
                    break;
        }
    }
}
