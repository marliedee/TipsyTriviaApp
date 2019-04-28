package com.android.tipsytrivia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
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
    private String WRONG = "WrongResultActivity Answer - Sorry!";
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

        String[] allQuestions = new String[]{questionList.get(0).getQuestion()};

        textViewquestion = findViewById(R.id.question);
        textView = findViewById(R.id.radio_button_multiple_choice_one);
        textView2 = findViewById(R.id.radio_button_multiple_choice_two);
        textView3 = findViewById(R.id.radio_button_multiple_choice_three);
        textView4 = findViewById(R.id.radio_button_multiple_choice_four);

        Collections.shuffle(Arrays.asList(choices));

        Collections.shuffle(Arrays.asList(allQuestions));

        textViewquestion.setText(Html.fromHtml(questionList.get(0).getQuestion()));
        textView.setText(Html.fromHtml(choices[0]));
        textView2.setText(Html.fromHtml(choices[1]));
        textView3.setText(Html.fromHtml(choices[2]));
        textView4.setText(Html.fromHtml(choices[3]));

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
            case R.id.radio_button_multiple_choice_one:
                if (checked) {
                    if (multipleChoiceOne.equals(correctAnswer)) {
                        rightAnswer();
                    } else {
                        wrongAnswer();
                    }
                }
                break;
            case R.id.radio_button_multiple_choice_two:
                if (checked) {
                    if (multipleChoiceTwo.equals(correctAnswer)) {
                        rightAnswer();
                    } else {
                        wrongAnswer();
                    }
                }
                break;
            case R.id.radio_button_multiple_choice_three:
                if (checked) {
                    if (multipleChoiceThree.equals(correctAnswer)) {
                        rightAnswer();
                    } else {
                        wrongAnswer();
                    }
                }
                break;
            case R.id.radio_button_multiple_choice_four:
                if (checked) {
                    if (multipleChoiceFour.equals(correctAnswer)) {
                        rightAnswer();
                    } else {
                        wrongAnswer();
                    }
                }
                break;

            default:
                Toast toast = Toast.makeText(getApplicationContext(), "Make A Selection.", Toast.LENGTH_SHORT);
                toast.show();
                break;

        }


    }

    public void rightAnswer() {
        Intent rightIntent = new Intent(this, RightResultActivity.class);
        rightIntent.putExtra("Right", RIGHT);
        startActivity(rightIntent);

    }

    public void wrongAnswer() {
        Intent rightIntent = new Intent(this, WrongResultActivity.class);
        rightIntent.putExtra("Wrong", WRONG);
        startActivity(rightIntent);
    }

}

