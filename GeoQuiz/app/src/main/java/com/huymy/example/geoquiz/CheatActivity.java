package com.huymy.example.geoquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE =
            "com.huymy.example.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "com.huymy.example.geoquiz.answer_shown";
    private static final String KEY_ANSWER_SHOWN = "answer_shown";

    private boolean mAnswerIsTrue;
    private Button mShowAnswerBtn;
    private TextView mAnswerTextView;
    private boolean mAnswerShown;

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswerBtn = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.btn_true);
                } else {
                    mAnswerTextView.setText(R.string.btn_false);
                }
                mAnswerShown = true;
                setAnswerShownResult();
            }
        });

        if (savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(KEY_ANSWER_SHOWN);
            if (mAnswerShown) {
                setAnswerShownResult();
            }
        }
    }

    public static Intent newIntent(Context packageContext, boolean isAnswerTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, isAnswerTrue);
        return intent;
    }

    private void setAnswerShownResult() {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, true);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_ANSWER_SHOWN, mAnswerShown);
    }
}