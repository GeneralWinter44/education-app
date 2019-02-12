package com.example.wolframapitestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import io.github.kexanie.library.MathView;

public class MathlyGenerator extends AppCompatActivity implements MathMLAPIFetch {

    private TextView equation;
    private TextView choices;

    private JSONObject jsonObject;
    private MathView mathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathly);

        equation = findViewById(R.id.textView4);
        choices = findViewById(R.id.textView5);
        mathView = findViewById(R.id.formula_one);

        MathMLQuerier mq = new MathMLQuerier(this);
        mq.execute("https://math.ly/api/v1/algebra/linear-equations.json");
    }

    @Override
    public void onEvaluateCompleted(String result) {

        try {

            jsonObject = new JSONObject(result);
            // equation.setText(jsonObject.getString("correct_choice"));
            mathView.setText(jsonObject.getString("question"));

            // JSONArray jsonArray = jsonObject.getJSONArray("choices");
            // equation.setText(jsonObject.getString("question"));
            // choices.setText(jsonArray.toString());
       } catch (JSONException e) {

           e.printStackTrace();
       }
    }
}