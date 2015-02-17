package com.example.ratan_000.calculator;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebHistoryItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;

import static java.lang.System.*;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    ImageButton iButton1,iButton2,iButton3,iButton4,iButton5,iButton6,iButton7,iButton8,iButton9,iButtonZero,iButtonAdd,iButtonPlus,iButtonMinus,iButtonClear;
    LinearLayout baseLayout;
    TextView  display;
    TextView  display2;
    String Number1 = "";
    int finalResult=0;
    String currentOperation="";
    int lastnumberPressed=0;
    String lastOperation="";
    String lastOperator="null";

    MediaPlayer buttonPress0,buttonPress1,buttonPress2,buttonPress3,buttonPress4,buttonPress5,buttonPress6,buttonPress7,buttonPress8,buttonPress9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);  // to remove the bar having application name.
        out.print("app started ratan");

        prepare();
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        baseLayout.setBackgroundResource(R.drawable.bk3);
        iButtonZero = (ImageButton) findViewById(R.id.iButtonZero);
        iButton1 = (ImageButton) findViewById(R.id.iButton1); //1
        iButton2 = (ImageButton) findViewById(R.id.iButton2); //4
        iButton3 = (ImageButton) findViewById(R.id.iButton3); //7
        iButton4 = (ImageButton) findViewById(R.id.iButton4); //1
        iButton5 = (ImageButton) findViewById(R.id.iButton5); //4
        iButton6 = (ImageButton) findViewById(R.id.iButton6); //7
        iButton7 = (ImageButton) findViewById(R.id.iButton7); //1
        iButton8 = (ImageButton) findViewById(R.id.iButton8); //4
        iButton9 = (ImageButton) findViewById(R.id.iButton9); //7
        iButtonClear = (ImageButton) findViewById(R.id.iButtonClear);
       // buttonPress = MediaPlayer.create(this,R.raw.button12);
        buttonPress0 = MediaPlayer.create(this,R.raw.zero);
        buttonPress1 = MediaPlayer.create(this,R.raw.one);
        buttonPress2 = MediaPlayer.create(this,R.raw.two);
        buttonPress3 = MediaPlayer.create(this,R.raw.three);

        buttonPress4 = MediaPlayer.create(this,R.raw.four);
        buttonPress5 = MediaPlayer.create(this,R.raw.five);
        buttonPress6 = MediaPlayer.create(this,R.raw.six);
        buttonPress7 = MediaPlayer.create(this,R.raw.seven);
        buttonPress8 = MediaPlayer.create(this,R.raw.eight);
        buttonPress9 = MediaPlayer.create(this,R.raw.nine);



        iButtonAdd =(ImageButton) findViewById(R.id.iButtonAdd);
        iButtonPlus =(ImageButton) findViewById(R.id.iButtonPlus);
        iButtonMinus =(ImageButton) findViewById(R.id.iButtonMinus);
        //display= (TextView) findViewById(R.id.display);
        display2= (TextView) findViewById(R.id.display2);

        iButtonZero.setOnClickListener(this);
        iButton1.setOnClickListener(this);
        iButton2.setOnClickListener(this);
        iButton3.setOnClickListener(this);
        iButton4.setOnClickListener(this);
        iButton5.setOnClickListener(this);
        iButton6.setOnClickListener(this);
        iButton7.setOnClickListener(this);
        iButton8.setOnClickListener(this);
        iButton9.setOnClickListener(this);
        iButtonAdd.setOnClickListener(this);
        iButtonPlus.setOnClickListener(this);
        iButtonMinus.setOnClickListener(this);
        iButtonClear.setOnClickListener(this);


    }

    private void prepare() {
        out.println("Enterred to prepare section..");


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

    @Override
    public void onClick(View v) {
        out.print("Entered into Switch");
        int choise = v.getId();

        switch(choise)
        {
            case R.id.iButtonZero:
            {


                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() == 0 || Number1.length() >= 7 )
               {
                    if ( Number1.length() >= 7)
                    {
                        Log.d("xxx","enterred");
                        Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();

                    }
               }
               else {
                    buttonPress0.start();
                   Log.d("Ratan", "pressed Button 0");
                   Number1 = Number1.concat("0");
                   Log.d("newString", Number1);
                   display2.setText(Number1);
                   Log.d("Number", "" + Number1.length());
                   lastOperation = "digitPress"; // discarding operation if multiple pressed 0
                     }
                break;
            }

            case R.id.iButton1:
            {

                if (lastOperation == "equals") {
                    finalResult = 0;
                    lastOperator  = "null";
                    Number1 = "";
                }
                if (Number1.length() >= 7 )
                {
                 Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    buttonPress1.start();
                    Log.d("Ratan", "pressed Button 1");
                    Number1 = Number1.concat("1");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());
                   lastOperation = "digitPress";
                }
                break;
            }

            case R.id.iButton2:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    buttonPress2.start();
                    Log.d("Ratan", "pressed Button 2");
                    Number1 = Number1.concat("2");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());


                  lastOperation="digitPress";
                }


                break;
            }
            case R.id.iButton3:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    buttonPress3.start();
                    Log.d("Ratan", "pressed Button 3");
                    Number1 = Number1.concat("3");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());


                    lastOperation = "digitPress";
                }  // else finished

                break;
            }

            case R.id.iButton4:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else {

                    buttonPress4.start();
                    Log.d("Ratan", "pressed Button 4");
                    Number1 = Number1.concat("4");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());

                    lastOperation = "digitPress";
                }
                break;
            }

            case R.id.iButton5:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    buttonPress5.start();
                    Log.d("Ratan", "pressed Button 5");
                    Number1 = Number1.concat("5");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());


                    lastOperation = "digitPress";
                 }
                break;
            }

            case R.id.iButton6:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonPress6.start();
                    Log.d("Ratan1", "pressed Button 6");
                    Number1 = Number1.concat("6");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());


                    lastOperation = "digitPress";
                }
                break;
            }

            case R.id.iButton7:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }

                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonPress7.start();

                    Log.d("Ratan", "pressed Button 7");
                    Number1 = Number1.concat("7");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());
                    lastOperation = "digitPress";
                }
                break;
            }

            case R.id.iButton8:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonPress8.start();
                    Log.d("Ratan", "pressed Button 1");
                    Number1 = Number1.concat("8");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());


                    lastOperation = "digitPress";
                }
                break;
            }
            case R.id.iButton9:
            {
                if (lastOperation == "equals") {
                    finalResult = 0;
                    Number1 = "";
                }
                if ( Number1.length() >= 7 )
                {
                    Log.d("msg","ignoring multiple 0 Or more than 7");
                    Toast.makeText(MainActivity.this, "Max limit reached ", Toast.LENGTH_SHORT).show();
                }
                else {
                    buttonPress9.start();
                    Log.d("Ratan", "pressed Button 9");
                    Number1 = Number1.concat("9");
                    Log.d("newString", Number1);
                    display2.setText(Number1);
                    Log.d("Number", "" + Number1.length());
                    lastOperation = "digitPress";
                }
                break;
            }
            case R.id.iButtonAdd:
            {
                Log.d("Pre1 =" ,""+ Number1+"operator"+ lastOperator);
                String result ="";
                if(lastOperation != "equals")
                {

                    try {
                        if (lastOperator == "null") {
                           finalResult =  Integer.parseInt(Number1);

                            Log.d("Pre2 =", "" + finalResult);
                        }
                        if (lastOperator == "plus") {
                            finalResult = finalResult + Integer.parseInt(Number1);

                            Log.d("Pre3 =", "" + finalResult);
                        }

                        if (lastOperator == "minus") {

                            finalResult = finalResult - Integer.parseInt(Number1);

                            Log.d("Pre4 =", "" + finalResult);
                        }
                    } catch (Exception e) {
                        Log.d("msg1", "exception catched");
                        Number1 = "0";
                    }
                    Log.d("Number", "" + Number1.length());

                    display2.setText("" + finalResult);


                    lastOperation = "equals";
                    lastOperator = "null";
                }
                else
                {
                    Log.d("bbb","ignored..");
                }


                    //finalResult = 0;
                    break;

            }
            case R.id.iButtonMinus:
            {
                display2.setText(""+finalResult);
                Log.d("msg","Pressed - sign");
                if(lastOperation == "equals")
                {
                    Number1="";
                    display2.setText("");
                }

                if(lastOperation == "plus")
                {
                    lastOperation = "minus";
                }
                else
                {
                    if (lastOperation == "minus")
                    {
                        Log.d("msg","ignoring minus press");
                    }
                    else
                    {
                       try {


                           if (lastOperation == "digitPress") {
                               if (lastOperator == "plus") {
                                   finalResult = finalResult + Integer.parseInt(Number1);
                               }

                               if (lastOperator == "minus") {
                                   finalResult = finalResult - Integer.parseInt(Number1);
                               }

                               if (lastOperator == "null") {
                                   finalResult = Integer.parseInt(Number1);
                               }
                               Number1 = "";
                               display2.setText("");

                           }
                       }
                       catch(Exception e)
                        {
                            Number1 = "0";
                            display2.setText("");
                        }
                    }
                }
                Log.d("Number",""+Number1.length());
                display2.setText(""+finalResult);
                lastOperation = "minus";
                lastOperator  = "minus";
                break;
            }

            case R.id.iButtonPlus:
            {
              Log.d("msg","Pressed + sign");
                display2.setText(""+finalResult);
                if(lastOperation == "equals")
                {
                  Number1="";
                    display2.setText("");
                }

              if(lastOperation == "plus")
              {
                  Log.d("msg","igoring the plus press");
              }
                else
                {
                  if (lastOperation == "minus")
                  {
                      lastOperation = "plus";
                  }
                  else
                  {
                      if (lastOperation == "digitPress")
                      {
                              if(lastOperator == "plus")
                              {finalResult = finalResult +  Integer.parseInt(Number1);}

                              if(lastOperator == "minus")
                              {finalResult = finalResult  -  Integer.parseInt(Number1);}

                              if(lastOperator == "null")
                              {
                                 finalResult = Integer.parseInt(Number1);
                              }
                              Number1 = "";
                              display2.setText("");

                      }
                  }
                }
                Log.d("Number",""+Number1.length());
                display2.setText(""+finalResult);
                  lastOperation = "plus";
                  lastOperator  = "plus";
                break;
            }

            case R.id.iButtonClear:
                out.print("clearing all");
                finalResult=0;
                Number1="";
                currentOperation = "null";
                lastOperator="null";
                String result=""+finalResult;
                display2.setText(result);
                Log.d("Number",""+Number1.length());
        }

    }
}
