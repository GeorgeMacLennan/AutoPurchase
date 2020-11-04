  package com.example.autopurchaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

  public class MainActivity extends AppCompatActivity {
    static final String LOAN_TERM = "loanTerm";
    static final String MONTHLY_PAYMENT = "monthlyPayment";
    static final String TOTAL_COST = "totalCost";
    static final String DOWN_PAYMENT = "downPayment";
    static final String SALES_TAX = "salesTax";
    static final String LOAN_AMOUNT = "loanAmount";
    static final String LOAN_RATE = "loanRate";
    static final String CAR_PRICE = "carPrice";

    EditText carPrice, downPayment, interestRate;
    RadioGroup term;
    RadioButton threeYears, fiveYears, sixYears;
    RadioGroup radioGroup;
    Auto auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carPrice = (EditText)findViewById(R.id.cp_Input);
        downPayment = (EditText)findViewById(R.id.dp_Input);
        interestRate = (EditText)findViewById(R.id.ir_Input);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        auto = new Auto();

        carPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    auto.setPrice(Double.parseDouble(charSequence.toString()));
                }
                catch (NumberFormatException e)
                {
                    auto.setPrice(0.0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        downPayment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    auto.setDownPayment(Double.parseDouble(charSequence.toString()));
                }
                catch (NumberFormatException e)
                {
                    auto.setDownPayment(0.0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        interestRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try{
                    auto.setRate(Double.parseDouble(charSequence.toString()));
                }
                catch (NumberFormatException e)
                {
                    auto.setRate(0.0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i)
                {
                    case R.id.threeYears:
                        auto.setLoanTerm(3);
                        break;
                    case R.id.fiveYears:
                        auto.setLoanTerm(5);
                        break;
                    case R.id.sixYears:
                        auto.setLoanTerm(6);
                        break;
                }
            }
        });
    }

    public void goToSummary(View view) {
        Intent intent = new Intent(MainActivity.this, LoanReportActivity.class);
        intent.putExtra(LOAN_TERM, auto.getLoanTerm().toString());
        intent.putExtra(MONTHLY_PAYMENT, auto.getMonthlyPayment().toString());
        intent.putExtra(DOWN_PAYMENT, auto.getDownPayment().toString());
        intent.putExtra(SALES_TAX, auto.getSalesTax().toString());
        intent.putExtra(TOTAL_COST, auto.getTotalCost().toString());
        intent.putExtra(LOAN_AMOUNT, auto.getLoanAmount().toString());
        intent.putExtra(LOAN_RATE, auto.getRate().toString());
        intent.putExtra(CAR_PRICE, auto.getPrice().toString());
        startActivity(intent);
    }

}