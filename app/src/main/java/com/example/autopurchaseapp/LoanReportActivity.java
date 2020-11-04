package com.example.autopurchaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoanReportActivity extends AppCompatActivity {
    TextView car_price, sales_tax, downpayment, totalcost, monthlypayment, loanamount, loanterm, loanrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_report);
        car_price = (TextView) findViewById(R.id.cc_Text);
        sales_tax = (TextView)findViewById(R.id.st_Text);
        downpayment = (TextView)findViewById(R.id.dp_Text);
        totalcost = (TextView)findViewById(R.id.tc_Text);
        monthlypayment = (TextView)findViewById(R.id.mp_Text);
        loanamount = (TextView)findViewById(R.id.la_Text);
        loanterm = (TextView)findViewById(R.id.lt_Text);
        loanrate = (TextView)findViewById(R.id.ir_Text);

        Intent intent = getIntent();
        String loanRate = intent.getStringExtra(MainActivity.LOAN_RATE);
        String loanTerm = intent.getStringExtra(MainActivity.LOAN_TERM);
        String loanAmount = intent.getStringExtra(MainActivity.LOAN_AMOUNT);
        String monthlyPayment = intent.getStringExtra(MainActivity.MONTHLY_PAYMENT);
        String totalCost = intent.getStringExtra(MainActivity.TOTAL_COST);
        String downPayment = intent.getStringExtra(MainActivity.DOWN_PAYMENT);
        String salesTax = intent.getStringExtra(MainActivity.SALES_TAX);
        String carPrice = intent.getStringExtra(MainActivity.CAR_PRICE);

        car_price.setText(carPrice);
        sales_tax.setText(salesTax);
        downpayment.setText(downPayment);
        totalcost.setText(totalCost);
        monthlypayment.setText(monthlyPayment);
        loanamount.setText(loanAmount);
        loanterm.setText(loanTerm + " years");
        loanrate.setText(loanRate);
    }
}