package com.android.tipsytrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tipsytrivia.model.Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionsPageActivity extends AppCompatActivity {
    private List<Question> questionList;
    private TextView textView;
    private TextView textViewquestion;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private String multipleChoiceOne;
    private String multipleChoiceTwo;
    private String multipleChoiceThree;
    private String multipleChoiceFour;
    private String WRONG = "Wrong Answer - Sorry!";
    private String RIGHT = "You are Correct!!";
    private String[] wrongAnswers = new String[4];
    private String[] choices;
    private String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);

        Intent intent = getIntent();
        questionList = (List<Question>) intent.getSerializableExtra("category");

        String[] wrongAnswers = questionList.get(0).getIncorrect_answers();
        String one = wrongAnswers[0];
        String two = wrongAnswers[1];
        String three = wrongAnswers[2];
        correctAnswer = questionList.get(0).getCorrect_answer();
        choices = new String[]{one, two, three, correctAnswer};

        textViewquestion = findViewById(R.id.question);
        textView = findViewById(R.id.textview_multiple_choice_one);
        textView2 = findViewById(R.id.textview_multiple_choice_two);
        textView3 = findViewById(R.id.textview_multiple_choice_three);
        textView4 = findViewById(R.id.textview_multiple_choice_four);
        Collections.shuffle(Arrays.asList(choices));

        textViewquestion.setText(Html.fromHtml(questionList.get(0).getQuestion()));
        textView.setText(choices[0]);
        textView2.setText(choices[1]);
        textView3.setText(choices[2]);
        textView4.setText(choices[3]);

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
                    if (questionList.contains(multipleChoiceOne)) {
                        Intent wrongIntent = new Intent(this, WrongResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceOne.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, WrongResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_two:
                if (checked) {
                    if (questionList.contains(multipleChoiceTwo)) {
                        Intent wrongIntent = new Intent(this, WrongResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceTwo.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, WrongResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_three:
                if (checked) {
                    if (questionList.contains(multipleChoiceThree)) {
                        Intent wrongIntent = new Intent(this, WrongResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceThree.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, WrongResultsActivity.class);
                        rightIntent.putExtra("right", RIGHT);
                        startActivity(rightIntent);
                    }
                }
                break;
            case R.id.textview_multiple_choice_four:
                if (checked) {
                    if (questionList.contains(multipleChoiceFour)) {
                        Intent wrongIntent = new Intent(this, WrongResultsActivity.class);
                        wrongIntent.putExtra("wrong", WRONG);
                        startActivity(wrongIntent);
                    } else if (multipleChoiceFour.equals(correctAnswer)) {
                        Intent rightIntent = new Intent(this, WrongResultsActivity.class);
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
