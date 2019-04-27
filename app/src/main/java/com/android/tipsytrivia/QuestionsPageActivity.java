package com.android.tipsytrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuestionsPageActivity extends AppCompatActivity {
    private List<String> incorrectChoiceArray;
    private String correctAnswer;
    private RadioGroup radioGroup;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private String multipleChoiceOne;
    private String multipleChoiceTwo;
    private String multipleChoiceThree;
    private String multipleChoiceFour;
    private String WRONG = "Wrong Answer - Sorry!";
    private String RIGHT = "You are Correct!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);

        radioGroup = findViewById(R.id.radio_choices);
        textView = findViewById(R.id.textview_multiple_choice_one);
        textView2 = findViewById(R.id.textview_multiple_choice_two);
        textView3 = findViewById(R.id.textview_multiple_choice_three);
        textView4 = findViewById(R.id.textview_multiple_choice_four);

        multipleChoiceOne = textView.getText().toString();
        multipleChoiceTwo = textView2.getText().toString();
        multipleChoiceThree = textView3.getText().toString();
        multipleChoiceFour = textView4.getText().toString();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.textview_multiple_choice_one:
                if (checked) {
                    if (incorrectChoiceArray.contains(multipleChoiceOne)) {
                        Intent wrongIntent = new Intent(this, ResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceOne.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, ResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_two:
                if (checked) {
                    if (incorrectChoiceArray.contains(multipleChoiceTwo)) {
                        Intent wrongIntent = new Intent(this, ResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceTwo.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, ResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_three:
                if (checked) {
                    if (incorrectChoiceArray.contains(multipleChoiceThree)) {
                        Intent wrongIntent = new Intent(this, ResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceThree.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, ResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_four:
                if (checked) {
                    if (incorrectChoiceArray.contains(multipleChoiceFour)) {
                        Intent wrongIntent = new Intent(this, ResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceFour.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, ResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;

            default:
                Toast toast = Toast.makeText(getApplicationContext(), "Make A Selection.", Toast.LENGTH_SHORT);
                toast.show();
                break;

        }
    }
}
